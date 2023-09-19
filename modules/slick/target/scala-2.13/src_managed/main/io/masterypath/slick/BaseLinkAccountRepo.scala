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
import Tables.{LinkAccountRow, LinkAccountTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LinkAccountRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLinkAccountRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLinkAccountRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LinkAccountTable, LinkAccountRow, LinkAccount](TableQuery[LinkAccountTable], dbConfigProvider) {

    def fromRow(row: LinkAccountRow): LinkAccount =
      LinkAccount(
				id = AccountID(row.id),
				orgID = OrgID(row.orgID),
			)

    def toRow(nonRow: LinkAccount): LinkAccountRow =
      LinkAccountRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
			)
  }

case class LinkAccount(id: AccountID, orgID: OrgID)
object LinkAccount {
  implicit val f: OFormat[LinkAccount] = Jsonx.formatCaseClass[LinkAccount]
}

