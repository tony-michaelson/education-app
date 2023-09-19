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
import Tables.{PostRow, PostTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class PostRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BasePostRepo(dbConfigProvider = dbConfigProvider)
abstract class BasePostRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[PostTable, PostRow, Post](TableQuery[PostTable], dbConfigProvider) {

    def fromRow(row: PostRow): Post =
      Post(
				id = NodeID(row.id),
				mapID = MapID(row.mapID),
				markdown = row.markdown,
				html = row.html,
			)

    def toRow(nonRow: Post): PostRow =
      PostRow(
				id = nonRow.id,
				mapID = nonRow.mapID,
				markdown = nonRow.markdown,
				html = nonRow.html,
			)
  }

case class Post(id: NodeID, mapID: MapID, markdown: String, html: String)
object Post {
  implicit val f: OFormat[Post] = Jsonx.formatCaseClass[Post]
}

