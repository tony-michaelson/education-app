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
import Tables.{AccountRow, AccountTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class AccountRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseAccountRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseAccountRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[AccountTable, AccountRow, Account](TableQuery[AccountTable], dbConfigProvider) {

    def fromRow(row: AccountRow): Account =
      Account(
				id = AccountID(row.id),
				profileID = ProfileID(row.profileID),
				tokenSubject = row.tokenSubject,
				email = row.email,
				enabled = row.enabled,
				created = row.created,
			)

    def toRow(nonRow: Account): AccountRow =
      AccountRow(
				id = nonRow.id,
				profileID = nonRow.profileID,
				tokenSubject = nonRow.tokenSubject,
				email = nonRow.email,
				enabled = nonRow.enabled,
				created = nonRow.created,
			)
  }

case class Account(id: AccountID, profileID: ProfileID, tokenSubject: String, email: String, enabled: Boolean, created: Long)
object Account {
  implicit val f: OFormat[Account] = Jsonx.formatCaseClass[Account]
}
case class AccountID(uuid: UUID) {
  override def toString = uuid.toString
}
object AccountID {
  implicit val formatter: Format[AccountID] =
    new Format[AccountID] with Serializable {
      override def writes(o: AccountID): JsValue = Json.valueWrites[AccountID].writes(o)

      override def reads(json: JsValue): JsResult[AccountID] = Json.valueReads[AccountID].reads(json)
    }

  def apply(id: UUID): AccountID           = new AccountID(uuid = id)
  implicit def toUUID(id: AccountID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[AccountID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: AccountID = new AccountID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[AccountID] {
    def tryUUID(str: String) =
      try {
        Right(AccountID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, AccountID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: AccountID): String = {
      id.toString
    }
  }
}
  
