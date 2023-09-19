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
import Tables.{BillingItemsRow, BillingItemsTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class BillingItemsRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseBillingItemsRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseBillingItemsRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[BillingItemsTable, BillingItemsRow, BillingItems](TableQuery[BillingItemsTable], dbConfigProvider) {

    def fromRow(row: BillingItemsRow): BillingItems =
      BillingItems(
				id = BillingItemsID(row.id),
				name = row.name,
				description = row.description,
				cost = row.cost,
				monthly = row.monthly,
			)

    def toRow(nonRow: BillingItems): BillingItemsRow =
      BillingItemsRow(
				id = nonRow.id,
				name = nonRow.name,
				description = nonRow.description,
				cost = nonRow.cost,
				monthly = nonRow.monthly,
			)
  }

case class BillingItems(id: BillingItemsID, name: String, description: Option[String] = None, cost: Double = 0.0, monthly: Boolean = false)
object BillingItems {
  implicit val f: OFormat[BillingItems] = Jsonx.formatCaseClass[BillingItems]
}
case class BillingItemsID(uuid: UUID) {
  override def toString = uuid.toString
}
object BillingItemsID {
  implicit val formatter: Format[BillingItemsID] =
    new Format[BillingItemsID] with Serializable {
      override def writes(o: BillingItemsID): JsValue = Json.valueWrites[BillingItemsID].writes(o)

      override def reads(json: JsValue): JsResult[BillingItemsID] = Json.valueReads[BillingItemsID].reads(json)
    }

  def apply(id: UUID): BillingItemsID           = new BillingItemsID(uuid = id)
  implicit def toUUID(id: BillingItemsID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[BillingItemsID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: BillingItemsID = new BillingItemsID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[BillingItemsID] {
    def tryUUID(str: String) =
      try {
        Right(BillingItemsID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, BillingItemsID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: BillingItemsID): String = {
      id.toString
    }
  }
}
  
