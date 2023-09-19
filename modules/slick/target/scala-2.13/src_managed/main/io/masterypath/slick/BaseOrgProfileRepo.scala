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
import Tables.{OrgProfileRow, OrgProfileTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class OrgProfileRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseOrgProfileRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseOrgProfileRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[OrgProfileTable, OrgProfileRow, OrgProfile](TableQuery[OrgProfileTable], dbConfigProvider) {

    def fromRow(row: OrgProfileRow): OrgProfile =
      OrgProfile(
				id = OrgID(row.id),
				name = row.name,
				domain = row.domain,
				familyPlan = row.familyPlan,
			)

    def toRow(nonRow: OrgProfile): OrgProfileRow =
      OrgProfileRow(
				id = nonRow.id,
				name = nonRow.name,
				domain = nonRow.domain,
				familyPlan = nonRow.familyPlan,
			)
  }

case class OrgProfile(id: OrgID, name: String, domain: String, familyPlan: Boolean = false)
object OrgProfile {
  implicit val f: OFormat[OrgProfile] = Jsonx.formatCaseClass[OrgProfile]
}
case class OrgID(uuid: UUID) {
  override def toString = uuid.toString
}
object OrgID {
  implicit val formatter: Format[OrgID] =
    new Format[OrgID] with Serializable {
      override def writes(o: OrgID): JsValue = Json.valueWrites[OrgID].writes(o)

      override def reads(json: JsValue): JsResult[OrgID] = Json.valueReads[OrgID].reads(json)
    }

  def apply(id: UUID): OrgID           = new OrgID(uuid = id)
  implicit def toUUID(id: OrgID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[OrgID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: OrgID = new OrgID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[OrgID] {
    def tryUUID(str: String) =
      try {
        Right(OrgID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, OrgID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: OrgID): String = {
      id.toString
    }
  }
}
  
