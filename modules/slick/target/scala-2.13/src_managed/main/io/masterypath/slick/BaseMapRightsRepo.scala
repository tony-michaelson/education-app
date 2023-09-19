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
import Tables.{MapRightsRow, MapRightsTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class MapRightsRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseMapRightsRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseMapRightsRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[MapRightsTable, MapRightsRow, MapRights](TableQuery[MapRightsTable], dbConfigProvider) {

    def fromRow(row: MapRightsRow): MapRights =
      MapRights(
				id = MapRightsID(row.id),
				name = row.name,
				mapID = MapID(row.mapID),
				admin = row.admin,
				feedback = row.feedback,
				mnemonics = row.mnemonics,
				modify = row.modify,
				permissions = row.permissions,
				publish = row.publish,
				share = row.share,
				stats = row.stats,
				training = row.training,
				transfer = row.transfer,
				view = row.view,
			)

    def toRow(nonRow: MapRights): MapRightsRow =
      MapRightsRow(
				id = nonRow.id,
				name = nonRow.name,
				mapID = nonRow.mapID,
				admin = nonRow.admin,
				feedback = nonRow.feedback,
				mnemonics = nonRow.mnemonics,
				modify = nonRow.modify,
				permissions = nonRow.permissions,
				publish = nonRow.publish,
				share = nonRow.share,
				stats = nonRow.stats,
				training = nonRow.training,
				transfer = nonRow.transfer,
				view = nonRow.view,
			)
  }

case class MapRights(id: MapRightsID, name: String, mapID: MapID, admin: Boolean = false, feedback: Boolean = false, mnemonics: Boolean = false, modify: Boolean = false, permissions: Boolean = false, publish: Boolean = false, share: Boolean = false, stats: Boolean = false, training: Boolean = false, transfer: Boolean = false, view: Boolean = false)
object MapRights {
  implicit val f: OFormat[MapRights] = Jsonx.formatCaseClass[MapRights]
}
case class MapRightsID(uuid: UUID) {
  override def toString = uuid.toString
}
object MapRightsID {
  implicit val formatter: Format[MapRightsID] =
    new Format[MapRightsID] with Serializable {
      override def writes(o: MapRightsID): JsValue = Json.valueWrites[MapRightsID].writes(o)

      override def reads(json: JsValue): JsResult[MapRightsID] = Json.valueReads[MapRightsID].reads(json)
    }

  def apply(id: UUID): MapRightsID           = new MapRightsID(uuid = id)
  implicit def toUUID(id: MapRightsID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[MapRightsID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: MapRightsID = new MapRightsID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[MapRightsID] {
    def tryUUID(str: String) =
      try {
        Right(MapRightsID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, MapRightsID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: MapRightsID): String = {
      id.toString
    }
  }
}
  
