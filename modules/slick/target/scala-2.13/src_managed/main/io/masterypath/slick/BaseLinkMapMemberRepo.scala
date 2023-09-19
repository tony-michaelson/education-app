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
import Tables.{LinkMapMemberRow, LinkMapMemberTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class LinkMapMemberRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseLinkMapMemberRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseLinkMapMemberRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[LinkMapMemberTable, LinkMapMemberRow, LinkMapMember](TableQuery[LinkMapMemberTable], dbConfigProvider) {

    def fromRow(row: LinkMapMemberRow): LinkMapMember =
      LinkMapMember(
				id = MapRightsID(row.id),
				orgID = OrgID(row.orgID),
				profileID = ProfileID(row.profileID),
			)

    def toRow(nonRow: LinkMapMember): LinkMapMemberRow =
      LinkMapMemberRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				profileID = nonRow.profileID,
			)
  }

case class LinkMapMember(id: MapRightsID, orgID: OrgID, profileID: ProfileID)
object LinkMapMember {
  implicit val f: OFormat[LinkMapMember] = Jsonx.formatCaseClass[LinkMapMember]
}

