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
import Tables.{ConfigRow, ConfigTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class ConfigRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseConfigRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseConfigRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[ConfigTable, ConfigRow, Config](TableQuery[ConfigTable], dbConfigProvider) {

    def fromRow(row: ConfigRow): Config =
      Config(
				id = OrgID(row.id),
				blog = row.blog,
				contests = row.contests,
				defaultLanguage = row.defaultLanguage,
				mapDocumentationGeneration = row.mapDocumentationGeneration,
				marketingCampaigns = row.marketingCampaigns,
				marketingEngagementCampaigns = row.marketingEngagementCampaigns,
				problemBoard = row.problemBoard,
				salesAds = row.salesAds,
				salesCertificates = row.salesCertificates,
				salesCourses = row.salesCourses,
				salesFreeTrials = row.salesFreeTrials,
				salesMemberFeesActive = row.salesMemberFeesActive,
				salesMemberFeesStatic = row.salesMemberFeesStatic,
				salesMemberships = row.salesMemberships,
				salesOrganizations = row.salesOrganizations,
				supportTier = row.supportTier,
				trainingAnswerTimeTracking = row.trainingAnswerTimeTracking,
				trainingBreakTime = row.trainingBreakTime,
				trainingComplianceEnforcement = row.trainingComplianceEnforcement,
				trainingComments = row.trainingComments,
				trainingContentPageStudentSubmission = row.trainingContentPageStudentSubmission,
				trainingContentPageTimeTracking = row.trainingContentPageTimeTracking,
				trainingContentPageUpvote = row.trainingContentPageUpvote,
				trainingCorrectAnswerAnimation = row.trainingCorrectAnswerAnimation,
				trainingCorrectAnswerSound = row.trainingCorrectAnswerSound,
				trainingFeedback = row.trainingFeedback,
				trainingLearningPaths = row.trainingLearningPaths,
				trainingMnemonics = row.trainingMnemonics,
				trainingQuotes = row.trainingQuotes,
				trainingRankings = row.trainingRankings,
				trainingReporting = row.trainingReporting,
				trainingRewardsProgram = row.trainingRewardsProgram,
				trainingSessionEndCelebration = row.trainingSessionEndCelebration,
				trainingSessionEndFeedback = row.trainingSessionEndFeedback,
				trainingStraightThruMode = row.trainingStraightThruMode,
				trainingStudyGoals = row.trainingStudyGoals,
				trainingVirtualLabs = row.trainingVirtualLabs,
				whiteLabeled = row.whiteLabeled,
				memberMonthlyCost = row.memberMonthlyCost,
				memberAnnualCost = row.memberAnnualCost,
				memberPaymentMethodRequired = row.memberPaymentMethodRequired,
			)

    def toRow(nonRow: Config): ConfigRow =
      ConfigRow(
				id = nonRow.id,
				blog = nonRow.blog,
				contests = nonRow.contests,
				defaultLanguage = nonRow.defaultLanguage,
				mapDocumentationGeneration = nonRow.mapDocumentationGeneration,
				marketingCampaigns = nonRow.marketingCampaigns,
				marketingEngagementCampaigns = nonRow.marketingEngagementCampaigns,
				problemBoard = nonRow.problemBoard,
				salesAds = nonRow.salesAds,
				salesCertificates = nonRow.salesCertificates,
				salesCourses = nonRow.salesCourses,
				salesFreeTrials = nonRow.salesFreeTrials,
				salesMemberFeesActive = nonRow.salesMemberFeesActive,
				salesMemberFeesStatic = nonRow.salesMemberFeesStatic,
				salesMemberships = nonRow.salesMemberships,
				salesOrganizations = nonRow.salesOrganizations,
				supportTier = nonRow.supportTier,
				trainingAnswerTimeTracking = nonRow.trainingAnswerTimeTracking,
				trainingBreakTime = nonRow.trainingBreakTime,
				trainingComplianceEnforcement = nonRow.trainingComplianceEnforcement,
				trainingComments = nonRow.trainingComments,
				trainingContentPageStudentSubmission = nonRow.trainingContentPageStudentSubmission,
				trainingContentPageTimeTracking = nonRow.trainingContentPageTimeTracking,
				trainingContentPageUpvote = nonRow.trainingContentPageUpvote,
				trainingCorrectAnswerAnimation = nonRow.trainingCorrectAnswerAnimation,
				trainingCorrectAnswerSound = nonRow.trainingCorrectAnswerSound,
				trainingFeedback = nonRow.trainingFeedback,
				trainingLearningPaths = nonRow.trainingLearningPaths,
				trainingMnemonics = nonRow.trainingMnemonics,
				trainingQuotes = nonRow.trainingQuotes,
				trainingRankings = nonRow.trainingRankings,
				trainingReporting = nonRow.trainingReporting,
				trainingRewardsProgram = nonRow.trainingRewardsProgram,
				trainingSessionEndCelebration = nonRow.trainingSessionEndCelebration,
				trainingSessionEndFeedback = nonRow.trainingSessionEndFeedback,
				trainingStraightThruMode = nonRow.trainingStraightThruMode,
				trainingStudyGoals = nonRow.trainingStudyGoals,
				trainingVirtualLabs = nonRow.trainingVirtualLabs,
				whiteLabeled = nonRow.whiteLabeled,
				memberMonthlyCost = nonRow.memberMonthlyCost,
				memberAnnualCost = nonRow.memberAnnualCost,
				memberPaymentMethodRequired = nonRow.memberPaymentMethodRequired,
			)
  }

case class Config(id: OrgID, blog: Boolean = false, contests: Boolean = false, defaultLanguage: String, mapDocumentationGeneration: Boolean = false, marketingCampaigns: Boolean = false, marketingEngagementCampaigns: Boolean = false, problemBoard: Boolean = false, salesAds: Boolean = false, salesCertificates: Boolean = false, salesCourses: Boolean = false, salesFreeTrials: Boolean = false, salesMemberFeesActive: Boolean = false, salesMemberFeesStatic: Boolean = false, salesMemberships: Boolean = false, salesOrganizations: Boolean = false, supportTier: Short, trainingAnswerTimeTracking: Boolean = false, trainingBreakTime: Boolean = false, trainingComplianceEnforcement: Boolean = false, trainingComments: Boolean = false, trainingContentPageStudentSubmission: Boolean = false, trainingContentPageTimeTracking: Boolean = false, trainingContentPageUpvote: Boolean = false, trainingCorrectAnswerAnimation: Boolean = false, trainingCorrectAnswerSound: Boolean = false, trainingFeedback: Boolean = false, trainingLearningPaths: Boolean = false, trainingMnemonics: Boolean = false, trainingQuotes: Boolean = false, trainingRankings: Boolean = false, trainingReporting: Boolean = false, trainingRewardsProgram: Boolean = false, trainingSessionEndCelebration: Boolean = false, trainingSessionEndFeedback: Boolean = false, trainingStraightThruMode: Boolean = false, trainingStudyGoals: Boolean = false, trainingVirtualLabs: Boolean = false, whiteLabeled: Boolean = false, memberMonthlyCost: Double = 0.0, memberAnnualCost: Double = 0.0, memberPaymentMethodRequired: Boolean = false)
object Config {
  implicit val f: OFormat[Config] = Jsonx.formatCaseClass[Config]
}

