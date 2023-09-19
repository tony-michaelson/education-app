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
import Tables.{RoleRow, RoleTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class RoleRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseRoleRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseRoleRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[RoleTable, RoleRow, Role](TableQuery[RoleTable], dbConfigProvider) {

    def fromRow(row: RoleRow): Role =
      Role(
				id = RoleID(row.id),
				orgID = OrgID(row.orgID),
				roleName = row.roleName,
				autoJoin = row.autoJoin,
				blogApprove = row.blogApprove,
				blogCreate = row.blogCreate,
				blogDelete = row.blogDelete,
				blogPublish = row.blogPublish,
				manageBlog = row.manageBlog,
				manageContests = row.manageContests,
				manageMarketingCampaigns = row.manageMarketingCampaigns,
				manageOrganizationBilling = row.manageOrganizationBilling,
				manageOrganizationConfig = row.manageOrganizationConfig,
				manageOrganizationMembers = row.manageOrganizationMembers,
				manageOrganizationPermissions = row.manageOrganizationPermissions,
				manageOrganizationWhitelabel = row.manageOrganizationWhitelabel,
				manageRewardsProgram = row.manageRewardsProgram,
				manageSalesAds = row.manageSalesAds,
				manageSalesCertificates = row.manageSalesCertificates,
				manageSalesCourses = row.manageSalesCourses,
				manageSalesMemberships = row.manageSalesMemberships,
				manageSalesOrganizations = row.manageSalesOrganizations,
				manageTrainingBreakTime = row.manageTrainingBreakTime,
				manageTrainingComplianceEnforcement = row.manageTrainingComplianceEnforcement,
				manageTrainingQuotes = row.manageTrainingQuotes,
				manageTrainingSessionSettings = row.manageTrainingSessionSettings,
				manageProblemBoard = row.manageProblemBoard,
				mapApprove = row.mapApprove,
				mapCreate = row.mapCreate,
				mapCreateDocuments = row.mapCreateDocuments,
				mapDirectory = row.mapDirectory,
				mapFeedback = row.mapFeedback,
				mapFork = row.mapFork,
				mapMnemonics = row.mapMnemonics,
				mapModify = row.mapModify,
				mapPermissions = row.mapPermissions,
				mapPublish = row.mapPublish,
				mapShare = row.mapShare,
				mapStats = row.mapStats,
				mapTraining = row.mapTraining,
				mapTransfer = row.mapTransfer,
				mapView = row.mapView,
				organizationInvite = row.organizationInvite,
				organizationPublish = row.organizationPublish,
				trainingRankings = row.trainingRankings,
				trainingReporting = row.trainingReporting,
			)

    def toRow(nonRow: Role): RoleRow =
      RoleRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				roleName = nonRow.roleName,
				autoJoin = nonRow.autoJoin,
				blogApprove = nonRow.blogApprove,
				blogCreate = nonRow.blogCreate,
				blogDelete = nonRow.blogDelete,
				blogPublish = nonRow.blogPublish,
				manageBlog = nonRow.manageBlog,
				manageContests = nonRow.manageContests,
				manageMarketingCampaigns = nonRow.manageMarketingCampaigns,
				manageOrganizationBilling = nonRow.manageOrganizationBilling,
				manageOrganizationConfig = nonRow.manageOrganizationConfig,
				manageOrganizationMembers = nonRow.manageOrganizationMembers,
				manageOrganizationPermissions = nonRow.manageOrganizationPermissions,
				manageOrganizationWhitelabel = nonRow.manageOrganizationWhitelabel,
				manageRewardsProgram = nonRow.manageRewardsProgram,
				manageSalesAds = nonRow.manageSalesAds,
				manageSalesCertificates = nonRow.manageSalesCertificates,
				manageSalesCourses = nonRow.manageSalesCourses,
				manageSalesMemberships = nonRow.manageSalesMemberships,
				manageSalesOrganizations = nonRow.manageSalesOrganizations,
				manageTrainingBreakTime = nonRow.manageTrainingBreakTime,
				manageTrainingComplianceEnforcement = nonRow.manageTrainingComplianceEnforcement,
				manageTrainingQuotes = nonRow.manageTrainingQuotes,
				manageTrainingSessionSettings = nonRow.manageTrainingSessionSettings,
				manageProblemBoard = nonRow.manageProblemBoard,
				mapApprove = nonRow.mapApprove,
				mapCreate = nonRow.mapCreate,
				mapCreateDocuments = nonRow.mapCreateDocuments,
				mapDirectory = nonRow.mapDirectory,
				mapFeedback = nonRow.mapFeedback,
				mapFork = nonRow.mapFork,
				mapMnemonics = nonRow.mapMnemonics,
				mapModify = nonRow.mapModify,
				mapPermissions = nonRow.mapPermissions,
				mapPublish = nonRow.mapPublish,
				mapShare = nonRow.mapShare,
				mapStats = nonRow.mapStats,
				mapTraining = nonRow.mapTraining,
				mapTransfer = nonRow.mapTransfer,
				mapView = nonRow.mapView,
				organizationInvite = nonRow.organizationInvite,
				organizationPublish = nonRow.organizationPublish,
				trainingRankings = nonRow.trainingRankings,
				trainingReporting = nonRow.trainingReporting,
			)
  }

case class Role(id: RoleID, orgID: OrgID, roleName: String, autoJoin: Boolean = false, blogApprove: Boolean = false, blogCreate: Boolean = false, blogDelete: Boolean = false, blogPublish: Boolean = false, manageBlog: Boolean = false, manageContests: Boolean = false, manageMarketingCampaigns: Boolean = false, manageOrganizationBilling: Boolean = false, manageOrganizationConfig: Boolean = false, manageOrganizationMembers: Boolean = false, manageOrganizationPermissions: Boolean = false, manageOrganizationWhitelabel: Boolean = false, manageRewardsProgram: Boolean = false, manageSalesAds: Boolean = false, manageSalesCertificates: Boolean = false, manageSalesCourses: Boolean = false, manageSalesMemberships: Boolean = false, manageSalesOrganizations: Boolean = false, manageTrainingBreakTime: Boolean = false, manageTrainingComplianceEnforcement: Boolean = false, manageTrainingQuotes: Boolean = false, manageTrainingSessionSettings: Boolean = false, manageProblemBoard: Boolean = false, mapApprove: Boolean = false, mapCreate: Boolean = false, mapCreateDocuments: Boolean = false, mapDirectory: Boolean = false, mapFeedback: Boolean = false, mapFork: Boolean = false, mapMnemonics: Boolean = false, mapModify: Boolean = false, mapPermissions: Boolean = false, mapPublish: Boolean = false, mapShare: Boolean = false, mapStats: Boolean = false, mapTraining: Boolean = false, mapTransfer: Boolean = false, mapView: Boolean = false, organizationInvite: Boolean = false, organizationPublish: Boolean = false, trainingRankings: Boolean = false, trainingReporting: Boolean = false)
object Role {
  implicit val f: OFormat[Role] = Jsonx.formatCaseClass[Role]
}
case class RoleID(uuid: UUID) {
  override def toString = uuid.toString
}
object RoleID {
  implicit val formatter: Format[RoleID] =
    new Format[RoleID] with Serializable {
      override def writes(o: RoleID): JsValue = Json.valueWrites[RoleID].writes(o)

      override def reads(json: JsValue): JsResult[RoleID] = Json.valueReads[RoleID].reads(json)
    }

  def apply(id: UUID): RoleID           = new RoleID(uuid = id)
  implicit def toUUID(id: RoleID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[RoleID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: RoleID = new RoleID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[RoleID] {
    def tryUUID(str: String) =
      try {
        Right(RoleID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, RoleID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: RoleID): String = {
      id.toString
    }
  }
}
  
