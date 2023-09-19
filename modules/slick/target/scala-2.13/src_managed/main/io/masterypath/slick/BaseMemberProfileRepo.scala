package io.masterypath.slick

import java.util.UUID

import javax.inject.Inject
import ai.x.play.json.Jsonx
import ai.x.play.json.Encoders.encoder
import play.api.libs.json.{Format, JsResult, JsValue, Json, OFormat}
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.PathBindable
import slick.jdbc.PostgresProfile.api._
import repos.BaseRepository
import Tables.{MemberProfileRow, MemberProfileTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class MemberProfileRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseMemberProfileRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseMemberProfileRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[MemberProfileTable, MemberProfileRow, MemberProfile](TableQuery[MemberProfileTable], dbConfigProvider) {

    def fromRow(row: MemberProfileRow): MemberProfile =
      MemberProfile(
				id = ProfileID(row.id),
				firstName = row.firstName,
				lastName = row.lastName,
				avatarURL = row.avatarURL,
				enabled = row.enabled,
			)

    def toRow(nonRow: MemberProfile): MemberProfileRow =
      MemberProfileRow(
				id = nonRow.id,
				firstName = nonRow.firstName,
				lastName = nonRow.lastName,
				avatarURL = nonRow.avatarURL,
				enabled = nonRow.enabled,
			)
  }

case class MemberProfile(id: ProfileID, firstName: String, lastName: String, avatarURL: String, enabled: Boolean)
object MemberProfile {
  implicit val f: OFormat[MemberProfile] = Jsonx.formatCaseClass[MemberProfile]
}
case class ProfileID(uuid: UUID) {
  override def toString = uuid.toString
}
object ProfileID {
  implicit val formatter: Format[ProfileID] =
    new Format[ProfileID] with Serializable {
      override def writes(o: ProfileID): JsValue = Json.valueWrites[ProfileID].writes(o)

      override def reads(json: JsValue): JsResult[ProfileID] = Json.valueReads[ProfileID].reads(json)
    }

  def apply(id: UUID): ProfileID           = new ProfileID(uuid = id)
  implicit def toUUID(id: ProfileID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[ProfileID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: ProfileID = new ProfileID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[ProfileID] {
    def tryUUID(str: String) =
      try {
        Right(ProfileID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, ProfileID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: ProfileID): String = {
      id.toString
    }
  }
}
  
