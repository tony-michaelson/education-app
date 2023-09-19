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
import Tables.{AnswerChoiceRow, AnswerChoiceTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class AnswerChoiceRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseAnswerChoiceRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseAnswerChoiceRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[AnswerChoiceTable, AnswerChoiceRow, AnswerChoice](TableQuery[AnswerChoiceTable], dbConfigProvider) {

    def fromRow(row: AnswerChoiceRow): AnswerChoice =
      AnswerChoice(
				id = AnswerChoiceID(row.id),
				cardID = NodeID(row.cardID),
				answer = row.answer,
				correct = row.correct,
			)

    def toRow(nonRow: AnswerChoice): AnswerChoiceRow =
      AnswerChoiceRow(
				id = nonRow.id,
				cardID = nonRow.cardID,
				answer = nonRow.answer,
				correct = nonRow.correct,
			)
  }

case class AnswerChoice(id: AnswerChoiceID, cardID: NodeID, answer: String, correct: Boolean)
object AnswerChoice {
  implicit val f: OFormat[AnswerChoice] = Jsonx.formatCaseClass[AnswerChoice]
}
case class AnswerChoiceID(uuid: UUID) {
  override def toString = uuid.toString
}
object AnswerChoiceID {
  implicit val formatter: Format[AnswerChoiceID] =
    new Format[AnswerChoiceID] with Serializable {
      override def writes(o: AnswerChoiceID): JsValue = Json.valueWrites[AnswerChoiceID].writes(o)

      override def reads(json: JsValue): JsResult[AnswerChoiceID] = Json.valueReads[AnswerChoiceID].reads(json)
    }

  def apply(id: UUID): AnswerChoiceID           = new AnswerChoiceID(uuid = id)
  implicit def toUUID(id: AnswerChoiceID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[AnswerChoiceID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: AnswerChoiceID = new AnswerChoiceID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[AnswerChoiceID] {
    def tryUUID(str: String) =
      try {
        Right(AnswerChoiceID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, AnswerChoiceID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: AnswerChoiceID): String = {
      id.toString
    }
  }
}
  
