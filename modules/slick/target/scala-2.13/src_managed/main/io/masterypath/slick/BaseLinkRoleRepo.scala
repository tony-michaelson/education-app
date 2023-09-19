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
import Tables.{LinkRoleRow, LinkRoleTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LinkRoleRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLinkRoleRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLinkRoleRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LinkRoleTable, LinkRoleRow, LinkRole](TableQuery[LinkRoleTable], dbConfigProvider) {

    def fromRow(row: LinkRoleRow): LinkRole =
      LinkRole(
				id = ProfileID(row.id),
				orgID = OrgID(row.orgID),
				roleID = RoleID(row.roleID),
			)

    def toRow(nonRow: LinkRole): LinkRoleRow =
      LinkRoleRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				roleID = nonRow.roleID,
			)
  }

case class LinkRole(id: ProfileID, orgID: OrgID, roleID: RoleID)
object LinkRole {
  implicit val f: OFormat[LinkRole] = Jsonx.formatCaseClass[LinkRole]
}

