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
import Tables.{AliasRow, AliasTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class AliasRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseAliasRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseAliasRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[AliasTable, AliasRow, Alias](TableQuery[AliasTable], dbConfigProvider) {

    def fromRow(row: AliasRow): Alias =
      Alias(
				id = AliasID(row.id),
				siteID = row.siteID,
				alias = row.alias,
				ssl = row.ssl,
			)

    def toRow(nonRow: Alias): AliasRow =
      AliasRow(
				id = nonRow.id,
				siteID = nonRow.siteID,
				alias = nonRow.alias,
				ssl = nonRow.ssl,
			)
  }

case class Alias(id: AliasID, siteID: java.util.UUID, alias: String, ssl: Boolean = false)
object Alias {
  implicit val f: OFormat[Alias] = Jsonx.formatCaseClass[Alias]
}
case class AliasID(uuid: UUID) {
  override def toString = uuid.toString
}
object AliasID {
  implicit val formatter: Format[AliasID] =
    new Format[AliasID] with Serializable {
      override def writes(o: AliasID): JsValue = Json.valueWrites[AliasID].writes(o)

      override def reads(json: JsValue): JsResult[AliasID] = Json.valueReads[AliasID].reads(json)
    }

  def apply(id: UUID): AliasID           = new AliasID(uuid = id)
  implicit def toUUID(id: AliasID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[AliasID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: AliasID = new AliasID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[AliasID] {
    def tryUUID(str: String) =
      try {
        Right(AliasID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, AliasID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: AliasID): String = {
      id.toString
    }
  }
}
  
