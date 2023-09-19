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
import Tables.{AnswerLogRow, AnswerLogTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class AnswerLogRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseAnswerLogRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseAnswerLogRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[AnswerLogTable, AnswerLogRow, AnswerLog](TableQuery[AnswerLogTable], dbConfigProvider) {

    def fromRow(row: AnswerLogRow): AnswerLog =
      AnswerLog(
				id = AnswerLogID(row.id),
				profileID = ProfileID(row.profileID),
				cardID = NodeID(row.cardID),
				correct = row.correct,
				time = row.time,
				elapsedTime = row.elapsedTime,
			)

    def toRow(nonRow: AnswerLog): AnswerLogRow =
      AnswerLogRow(
				id = nonRow.id,
				profileID = nonRow.profileID,
				cardID = nonRow.cardID,
				correct = nonRow.correct,
				time = nonRow.time,
				elapsedTime = nonRow.elapsedTime,
			)
  }

case class AnswerLog(id: AnswerLogID, profileID: ProfileID, cardID: NodeID, correct: Boolean, time: Long, elapsedTime: Int)
object AnswerLog {
  implicit val f: OFormat[AnswerLog] = Jsonx.formatCaseClass[AnswerLog]
}
case class AnswerLogID(uuid: UUID) {
  override def toString = uuid.toString
}
object AnswerLogID {
  implicit val formatter: Format[AnswerLogID] =
    new Format[AnswerLogID] with Serializable {
      override def writes(o: AnswerLogID): JsValue = Json.valueWrites[AnswerLogID].writes(o)

      override def reads(json: JsValue): JsResult[AnswerLogID] = Json.valueReads[AnswerLogID].reads(json)
    }

  def apply(id: UUID): AnswerLogID           = new AnswerLogID(uuid = id)
  implicit def toUUID(id: AnswerLogID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[AnswerLogID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: AnswerLogID = new AnswerLogID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[AnswerLogID] {
    def tryUUID(str: String) =
      try {
        Right(AnswerLogID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, AnswerLogID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: AnswerLogID): String = {
      id.toString
    }
  }
}
  
