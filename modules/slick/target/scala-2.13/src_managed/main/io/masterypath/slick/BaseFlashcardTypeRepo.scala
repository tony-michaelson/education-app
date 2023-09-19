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
import Tables.{FlashcardTypeRow, FlashcardTypeTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class FlashcardTypeRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseFlashcardTypeRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseFlashcardTypeRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[FlashcardTypeTable, FlashcardTypeRow, FlashcardType](TableQuery[FlashcardTypeTable], dbConfigProvider) {

    def fromRow(row: FlashcardTypeRow): FlashcardType =
      FlashcardType(
				id = FlashcardTypeID(row.id),
				cardType = row.cardType,
				name = row.name,
				commonName = row.commonName,
				description = row.description,
				config = row.config,
			)

    def toRow(nonRow: FlashcardType): FlashcardTypeRow =
      FlashcardTypeRow(
				id = nonRow.id,
				cardType = nonRow.cardType,
				name = nonRow.name,
				commonName = nonRow.commonName,
				description = nonRow.description,
				config = nonRow.config,
			)
  }

case class FlashcardType(id: FlashcardTypeID, cardType: String, name: String, commonName: String, description: Option[String] = None, config: Option[String] = None)
object FlashcardType {
  implicit val f: OFormat[FlashcardType] = Jsonx.formatCaseClass[FlashcardType]
}
case class FlashcardTypeID(uuid: UUID) {
  override def toString = uuid.toString
}
object FlashcardTypeID {
  implicit val formatter: Format[FlashcardTypeID] =
    new Format[FlashcardTypeID] with Serializable {
      override def writes(o: FlashcardTypeID): JsValue = Json.valueWrites[FlashcardTypeID].writes(o)

      override def reads(json: JsValue): JsResult[FlashcardTypeID] = Json.valueReads[FlashcardTypeID].reads(json)
    }

  def apply(id: UUID): FlashcardTypeID           = new FlashcardTypeID(uuid = id)
  implicit def toUUID(id: FlashcardTypeID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[FlashcardTypeID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: FlashcardTypeID = new FlashcardTypeID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[FlashcardTypeID] {
    def tryUUID(str: String) =
      try {
        Right(FlashcardTypeID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, FlashcardTypeID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: FlashcardTypeID): String = {
      id.toString
    }
  }
}
  
