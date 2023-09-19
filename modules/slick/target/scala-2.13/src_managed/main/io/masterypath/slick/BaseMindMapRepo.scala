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
import Tables.{MindMapRow, MindMapTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class MindMapRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseMindMapRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseMindMapRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[MindMapTable, MindMapRow, MindMap](TableQuery[MindMapTable], dbConfigProvider) {

    def fromRow(row: MindMapRow): MindMap =
      MindMap(
				id = MapID(row.id),
				published = row.published,
				icon = row.icon,
				orgID = OrgID(row.orgID),
				name = row.name,
				mode = row.mode,
				description = row.description,
				cost = row.cost,
				originMapID = row.originMapID,
				releaseVersion = row.releaseVersion,
			)

    def toRow(nonRow: MindMap): MindMapRow =
      MindMapRow(
				id = nonRow.id,
				published = nonRow.published,
				icon = nonRow.icon,
				orgID = nonRow.orgID,
				name = nonRow.name,
				mode = nonRow.mode,
				description = nonRow.description,
				cost = nonRow.cost,
				originMapID = nonRow.originMapID,
				releaseVersion = nonRow.releaseVersion,
			)
  }

case class MindMap(id: MapID, published: Boolean = false, icon: Option[String], orgID: OrgID, name: String, mode: String, description: Option[String] = None, cost: Option[Double] = None, originMapID: Option[java.util.UUID] = None, releaseVersion: Option[Double] = Some(0.0))
object MindMap {
  implicit val f: OFormat[MindMap] = Jsonx.formatCaseClass[MindMap]
}
case class MapID(uuid: UUID) {
  override def toString = uuid.toString
}
object MapID {
  implicit val formatter: Format[MapID] =
    new Format[MapID] with Serializable {
      override def writes(o: MapID): JsValue = Json.valueWrites[MapID].writes(o)

      override def reads(json: JsValue): JsResult[MapID] = Json.valueReads[MapID].reads(json)
    }

  def apply(id: UUID): MapID           = new MapID(uuid = id)
  implicit def toUUID(id: MapID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[MapID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: MapID = new MapID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[MapID] {
    def tryUUID(str: String) =
      try {
        Right(MapID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, MapID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: MapID): String = {
      id.toString
    }
  }
}
  
