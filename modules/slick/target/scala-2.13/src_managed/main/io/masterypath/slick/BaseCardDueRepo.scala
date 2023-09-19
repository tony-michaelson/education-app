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
import Tables.{CardDueRow, CardDueTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class CardDueRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseCardDueRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseCardDueRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[CardDueTable, CardDueRow, CardDue](TableQuery[CardDueTable], dbConfigProvider) {

    def fromRow(row: CardDueRow): CardDue =
      CardDue(
				id = NodeID(row.id),
				profileID = ProfileID(row.profileID),
				ef = row.ef,
				interval = row.interval,
				lastAnswerTime = row.lastAnswerTime,
				due = row.due,
			)

    def toRow(nonRow: CardDue): CardDueRow =
      CardDueRow(
				id = nonRow.id,
				profileID = nonRow.profileID,
				ef = nonRow.ef,
				interval = nonRow.interval,
				lastAnswerTime = nonRow.lastAnswerTime,
				due = nonRow.due,
			)
  }

case class CardDue(id: NodeID, profileID: ProfileID, ef: Double, interval: Int, lastAnswerTime: Long, due: Long)
object CardDue {
  implicit val f: OFormat[CardDue] = Jsonx.formatCaseClass[CardDue]
}

