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
import Tables.{LoginTimeRow, LoginTimeTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LoginTimeRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLoginTimeRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLoginTimeRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LoginTimeTable, LoginTimeRow, LoginTime](TableQuery[LoginTimeTable], dbConfigProvider) {

    def fromRow(row: LoginTimeRow): LoginTime =
      LoginTime(
				id = AccountID(row.id),
				timestamp = row.timestamp,
			)

    def toRow(nonRow: LoginTime): LoginTimeRow =
      LoginTimeRow(
				id = nonRow.id,
				timestamp = nonRow.timestamp,
			)
  }

case class LoginTime(id: AccountID, timestamp: Long)
object LoginTime {
  implicit val f: OFormat[LoginTime] = Jsonx.formatCaseClass[LoginTime]
}

