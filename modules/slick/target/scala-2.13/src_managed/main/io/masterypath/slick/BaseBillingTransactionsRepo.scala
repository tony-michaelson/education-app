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
import Tables.{BillingTransactionsRow, BillingTransactionsTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class BillingTransactionsRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseBillingTransactionsRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseBillingTransactionsRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[BillingTransactionsTable, BillingTransactionsRow, BillingTransactions](TableQuery[BillingTransactionsTable], dbConfigProvider) {

    def fromRow(row: BillingTransactionsRow): BillingTransactions =
      BillingTransactions(
				id = BillingTransactionsID(row.id),
				orgID = row.orgID,
				billingItem = row.billingItem,
				timestamp = row.timestamp,
				paid = row.paid,
			)

    def toRow(nonRow: BillingTransactions): BillingTransactionsRow =
      BillingTransactionsRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				billingItem = nonRow.billingItem,
				timestamp = nonRow.timestamp,
				paid = nonRow.paid,
			)
  }

case class BillingTransactions(id: BillingTransactionsID, orgID: java.util.UUID, billingItem: java.util.UUID, timestamp: Long, paid: Boolean = false)
object BillingTransactions {
  implicit val f: OFormat[BillingTransactions] = Jsonx.formatCaseClass[BillingTransactions]
}
case class BillingTransactionsID(uuid: UUID) {
  override def toString = uuid.toString
}
object BillingTransactionsID {
  implicit val formatter: Format[BillingTransactionsID] =
    new Format[BillingTransactionsID] with Serializable {
      override def writes(o: BillingTransactionsID): JsValue = Json.valueWrites[BillingTransactionsID].writes(o)

      override def reads(json: JsValue): JsResult[BillingTransactionsID] = Json.valueReads[BillingTransactionsID].reads(json)
    }

  def apply(id: UUID): BillingTransactionsID           = new BillingTransactionsID(uuid = id)
  implicit def toUUID(id: BillingTransactionsID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[BillingTransactionsID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: BillingTransactionsID = new BillingTransactionsID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[BillingTransactionsID] {
    def tryUUID(str: String) =
      try {
        Right(BillingTransactionsID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, BillingTransactionsID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: BillingTransactionsID): String = {
      id.toString
    }
  }
}
  
