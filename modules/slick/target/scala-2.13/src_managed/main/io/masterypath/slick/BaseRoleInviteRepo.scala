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
import Tables.{RoleInviteRow, RoleInviteTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class RoleInviteRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseRoleInviteRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseRoleInviteRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[RoleInviteTable, RoleInviteRow, RoleInvite](TableQuery[RoleInviteTable], dbConfigProvider) {

    def fromRow(row: RoleInviteRow): RoleInvite =
      RoleInvite(
				id = RoleInviteID(row.id),
				roleID = RoleID(row.roleID),
				mapRightsID = row.mapRightsID.flatMap(x => Option(MapRightsID(x))),
				expires = row.expires,
			)

    def toRow(nonRow: RoleInvite): RoleInviteRow =
      RoleInviteRow(
				id = nonRow.id,
				roleID = nonRow.roleID,
				mapRightsID = nonRow.mapRightsID,
				expires = nonRow.expires,
			)
  }

case class RoleInvite(id: RoleInviteID, roleID: RoleID, mapRightsID: Option[MapRightsID], expires: Long)
object RoleInvite {
  implicit val f: OFormat[RoleInvite] = Jsonx.formatCaseClass[RoleInvite]
}
case class RoleInviteID(uuid: UUID) {
  override def toString = uuid.toString
}
object RoleInviteID {
  implicit val formatter: Format[RoleInviteID] =
    new Format[RoleInviteID] with Serializable {
      override def writes(o: RoleInviteID): JsValue = Json.valueWrites[RoleInviteID].writes(o)

      override def reads(json: JsValue): JsResult[RoleInviteID] = Json.valueReads[RoleInviteID].reads(json)
    }

  def apply(id: UUID): RoleInviteID           = new RoleInviteID(uuid = id)
  implicit def toUUID(id: RoleInviteID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[RoleInviteID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: RoleInviteID = new RoleInviteID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[RoleInviteID] {
    def tryUUID(str: String) =
      try {
        Right(RoleInviteID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, RoleInviteID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: RoleInviteID): String = {
      id.toString
    }
  }
}
  
