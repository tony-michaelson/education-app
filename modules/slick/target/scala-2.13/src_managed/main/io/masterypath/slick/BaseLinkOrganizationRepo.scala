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
import Tables.{LinkOrganizationRow, LinkOrganizationTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LinkOrganizationRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLinkOrganizationRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLinkOrganizationRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LinkOrganizationTable, LinkOrganizationRow, LinkOrganization](TableQuery[LinkOrganizationTable], dbConfigProvider) {

    def fromRow(row: LinkOrganizationRow): LinkOrganization =
      LinkOrganization(
				id = OrgID(row.id),
				orgMemberID = row.orgMemberID,
			)

    def toRow(nonRow: LinkOrganization): LinkOrganizationRow =
      LinkOrganizationRow(
				id = nonRow.id,
				orgMemberID = nonRow.orgMemberID,
			)
  }

case class LinkOrganization(id: OrgID, orgMemberID: java.util.UUID)
object LinkOrganization {
  implicit val f: OFormat[LinkOrganization] = Jsonx.formatCaseClass[LinkOrganization]
}

