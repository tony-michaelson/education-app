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
import Tables.{CardRow, CardTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class CardRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseCardRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseCardRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[CardTable, CardRow, Card](TableQuery[CardTable], dbConfigProvider) {

    def fromRow(row: CardRow): Card =
      Card(
				id = NodeID(row.id),
				mapID = row.mapID,
				flashcardTypeID = FlashcardTypeID(row.flashcardTypeID),
				question = row.question,
				audio = row.audio,
				markdown = row.markdown,
				markdown_html = row.markdown_html,
			)

    def toRow(nonRow: Card): CardRow =
      CardRow(
				id = nonRow.id,
				mapID = nonRow.mapID,
				flashcardTypeID = nonRow.flashcardTypeID,
				question = nonRow.question,
				audio = nonRow.audio,
				markdown = nonRow.markdown,
				markdown_html = nonRow.markdown_html,
			)
  }

case class Card(id: NodeID, mapID: java.util.UUID, flashcardTypeID: FlashcardTypeID, question: String, audio: Option[String], markdown: String = "", markdown_html: String = "")
object Card {
  implicit val f: OFormat[Card] = Jsonx.formatCaseClass[Card]
}

