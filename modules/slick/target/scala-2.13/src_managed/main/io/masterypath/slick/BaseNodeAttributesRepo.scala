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
import Tables.{NodeAttributesRow, NodeAttributesTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class NodeAttributesRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseNodeAttributesRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseNodeAttributesRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[NodeAttributesTable, NodeAttributesRow, NodeAttributes](TableQuery[NodeAttributesTable], dbConfigProvider) {

    def fromRow(row: NodeAttributesRow): NodeAttributes =
      NodeAttributes(
				id = NodeAttributesID(row.id),
				nodeID = NodeID(row.nodeID),
				profileID = ProfileID(row.profileID),
				collapsed = row.collapsed,
			)

    def toRow(nonRow: NodeAttributes): NodeAttributesRow =
      NodeAttributesRow(
				id = nonRow.id,
				nodeID = nonRow.nodeID,
				profileID = nonRow.profileID,
				collapsed = nonRow.collapsed,
			)
  }

case class NodeAttributes(id: NodeAttributesID, nodeID: NodeID, profileID: ProfileID, collapsed: Boolean = false)
object NodeAttributes {
  implicit val f: OFormat[NodeAttributes] = Jsonx.formatCaseClass[NodeAttributes]
}
case class NodeAttributesID(uuid: UUID) {
  override def toString = uuid.toString
}
object NodeAttributesID {
  implicit val formatter: Format[NodeAttributesID] =
    new Format[NodeAttributesID] with Serializable {
      override def writes(o: NodeAttributesID): JsValue = Json.valueWrites[NodeAttributesID].writes(o)

      override def reads(json: JsValue): JsResult[NodeAttributesID] = Json.valueReads[NodeAttributesID].reads(json)
    }

  def apply(id: UUID): NodeAttributesID           = new NodeAttributesID(uuid = id)
  implicit def toUUID(id: NodeAttributesID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[NodeAttributesID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: NodeAttributesID = new NodeAttributesID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[NodeAttributesID] {
    def tryUUID(str: String) =
      try {
        Right(NodeAttributesID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, NodeAttributesID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: NodeAttributesID): String = {
      id.toString
    }
  }
}
  
