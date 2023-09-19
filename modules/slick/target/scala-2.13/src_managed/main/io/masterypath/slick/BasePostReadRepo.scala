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
import Tables.{PostReadRow, PostReadTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class PostReadRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BasePostReadRepo(dbConfigProvider = dbConfigProvider)
abstract class BasePostReadRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[PostReadTable, PostReadRow, PostRead](TableQuery[PostReadTable], dbConfigProvider) {

    def fromRow(row: PostReadRow): PostRead =
      PostRead(
				id = NodeID(row.id),
				profileID = ProfileID(row.profileID),
				timeRead = row.timeRead,
			)

    def toRow(nonRow: PostRead): PostReadRow =
      PostReadRow(
				id = nonRow.id,
				profileID = nonRow.profileID,
				timeRead = nonRow.timeRead,
			)
  }

case class PostRead(id: NodeID, profileID: ProfileID, timeRead: Long)
object PostRead {
  implicit val f: OFormat[PostRead] = Jsonx.formatCaseClass[PostRead]
}

