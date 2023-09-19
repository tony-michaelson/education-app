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
import Tables.{LinkMemberRow, LinkMemberTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LinkMemberRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLinkMemberRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLinkMemberRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LinkMemberTable, LinkMemberRow, LinkMember](TableQuery[LinkMemberTable], dbConfigProvider) {

    def fromRow(row: LinkMemberRow): LinkMember =
      LinkMember(
				id = ProfileID(row.id),
				orgID = OrgID(row.orgID),
				internal = row.internal,
				payPerCourse = row.payPerCourse,
			)

    def toRow(nonRow: LinkMember): LinkMemberRow =
      LinkMemberRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				internal = nonRow.internal,
				payPerCourse = nonRow.payPerCourse,
			)
  }

case class LinkMember(id: ProfileID, orgID: OrgID, internal: Boolean = false, payPerCourse: Boolean = false)
object LinkMember {
  implicit val f: OFormat[LinkMember] = Jsonx.formatCaseClass[LinkMember]
}

