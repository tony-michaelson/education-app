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
import Tables.{NodeRow, NodeTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions


abstract class BaseNodeRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[NodeTable, NodeRow, Node](TableQuery[NodeTable], dbConfigProvider) {

    def fromRow(row: NodeRow): Node =
      Node(
				id = NodeID(row.id),
				nodeNumber = row.nodeNumber,
				parentID = row.parentID.flatMap(x => Option(NodeID(x))),
				mapID = MapID(row.mapID),
				segmentID = SegmentID(row.segmentID),
				path = row.path,
				order = row.order,
				name = row.name,
				`type` = row.`type`,
				root = row.root,
				disabled = row.disabled,
				publishedID = row.publishedID,
			)

    def toRow(nonRow: Node): NodeRow =
      NodeRow(
				id = nonRow.id,
				nodeNumber = nonRow.nodeNumber,
				parentID = nonRow.parentID,
				mapID = nonRow.mapID,
				segmentID = nonRow.segmentID,
				path = nonRow.path,
				order = nonRow.order,
				name = nonRow.name,
				`type` = nonRow.`type`,
				root = nonRow.root,
				disabled = nonRow.disabled,
				publishedID = nonRow.publishedID,
			)
  }

case class Node(id: NodeID, nodeNumber: Short, parentID: Option[NodeID], mapID: MapID, segmentID: SegmentID, path: String, order: Double, name: String, `type`: String, root: Option[Short] = None, disabled: Boolean = false, publishedID: Option[java.util.UUID] = None)
object Node {
  implicit val f: OFormat[Node] = Jsonx.formatCaseClass[Node]
}
case class NodeID(uuid: UUID) {
  override def toString = uuid.toString
}
object NodeID {
  implicit val formatter: Format[NodeID] =
    new Format[NodeID] with Serializable {
      override def writes(o: NodeID): JsValue = Json.valueWrites[NodeID].writes(o)

      override def reads(json: JsValue): JsResult[NodeID] = Json.valueReads[NodeID].reads(json)
    }

  def apply(id: UUID): NodeID           = new NodeID(uuid = id)
  implicit def toUUID(id: NodeID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[NodeID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: NodeID = new NodeID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[NodeID] {
    def tryUUID(str: String) =
      try {
        Right(NodeID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, NodeID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: NodeID): String = {
      id.toString
    }
  }
}
  
