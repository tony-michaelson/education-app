
package com.scalatsi.generator

import _root_.com.scalatsi._
import _root_.com.scalatsi.TypescriptType._

/** User imports */

import io.masterypath.slick._ 
import models.TypescriptExports._ 
import models.flashcard._ 
import models.flashcard.dto._ 
import models.flashcard.exercise.dto._ 
import models.mindmap.dto._ 
import models.organization.dto._ 

object ExportTypescript {
  import _root_.com.{ scalatsi => ts }
  import _root_.scala.collection.{ immutable => im }

  // If you get a generator or implicit not found error here, make sure you have defined a TSType[T] implicit and imported it
  val toOutput: im.Map[String, ts.TypescriptType] = im.Map[String, ts.TypescriptType](
    
      """AnswerChoice""" -> ts.TSType.getOrGenerate[AnswerChoice].get, 
      """AnswerChoiceBriefEdit""" -> ts.TSType.getOrGenerate[AnswerChoiceBriefEdit].get, 
      """AnswerChoiceBriefTest""" -> ts.TSType.getOrGenerate[AnswerChoiceBriefTest].get, 
      """BlogCreate""" -> ts.TSType.getOrGenerate[BlogCreate].get, 
      """BlogPage""" -> ts.TSType.getOrGenerate[BlogPage].get, 
      """BlogPatch""" -> ts.TSType.getOrGenerate[BlogPatch].get, 
      """CardGradeAnswer""" -> ts.TSType.getOrGenerate[CardGradeAnswer].get, 
      """CardMetaData""" -> ts.TSType.getOrGenerate[CardMetaData].get, 
      """CardBriefEdit""" -> ts.TSType.getOrGenerate[CardBriefEdit].get, 
      """CardBriefTest""" -> ts.TSType.getOrGenerate[CardBriefTest].get, 
      """CardPost""" -> ts.TSType.getOrGenerate[CardPost].get, 
      """CardsDue""" -> ts.TSType.getOrGenerate[CardsDue].get, 
      """CodeExerciseBriefEdit""" -> ts.TSType.getOrGenerate[CodeExerciseBriefEdit].get, 
      """CodeExerciseBriefTest""" -> ts.TSType.getOrGenerate[CodeExerciseBriefTest].get, 
      """Config""" -> ts.TSType.getOrGenerate[Config].get, 
      """ConfigPatch""" -> ts.TSType.getOrGenerate[ConfigPatch].get, 
      """ExerciseAnswer""" -> ts.TSType.getOrGenerate[ExerciseAnswer].get, 
      """Exercise""" -> ts.TSType.getOrGenerate[Exercise].get, 
      """ExerciseUpdate""" -> ts.TSType.getOrGenerate[ExerciseUpdate].get, 
      """FlashcardTypeBrief""" -> ts.TSType.getOrGenerate[FlashcardTypeBrief].get, 
      """MapProperties""" -> ts.TSType.getOrGenerate[MapProperties].get, 
      """MapPropertiesPatch""" -> ts.TSType.getOrGenerate[MapPropertiesPatch].get, 
      """MapRightsInvite""" -> ts.TSType.getOrGenerate[MapRightsInvite].get, 
      """MapRightsPost""" -> ts.TSType.getOrGenerate[MapRightsPost].get, 
      """MapRightsPatch""" -> ts.TSType.getOrGenerate[MapRightsPatch].get, 
      """MapRightsMembers""" -> ts.TSType.getOrGenerate[MapRightsMembers].get, 
      """MemberOrgPermissions""" -> ts.TSType.getOrGenerate[MemberOrgPermissions].get, 
      """MemberProfileEmail""" -> ts.TSType.getOrGenerate[MemberProfileEmail].get, 
      """MemberProfile""" -> ts.TSType.getOrGenerate[MemberProfile].get, 
      """MemberRegistration""" -> ts.TSType.getOrGenerate[MemberRegistration].get, 
      """MindMap""" -> ts.TSType.getOrGenerate[MindMap].get, 
      """Node""" -> ts.TSType.getOrGenerate[Node].get, 
      """NodeCardPostInfo""" -> ts.TSType.getOrGenerate[NodeCardPostInfo].get, 
      """NodePatch""" -> ts.TSType.getOrGenerate[NodePatch].get, 
      """NodePatchAttributes""" -> ts.TSType.getOrGenerate[NodePatchAttributes].get, 
      """NodePost""" -> ts.TSType.getOrGenerate[NodePost].get, 
      """OrgLink""" -> ts.TSType.getOrGenerate[OrgLink].get, 
      """Post""" -> ts.TSType.getOrGenerate[Post].get, 
      """PostTimeRead""" -> ts.TSType.getOrGenerate[PostTimeRead].get, 
      """PostMarkdown""" -> ts.TSType.getOrGenerate[PostMarkdown].get, 
      """Quality""" -> ts.TSType.getOrGenerate[Quality].get, 
      """Role""" -> ts.TSType.getOrGenerate[Role].get, 
      """RoleInviteRequest""" -> ts.TSType.getOrGenerate[RoleInviteRequest].get, 
      """RoleInviteResponse""" -> ts.TSType.getOrGenerate[RoleInviteResponse].get, 
      """SegmentID""" -> ts.TSType.getOrGenerate[SegmentID].get, 
      """Site""" -> ts.TSType.getOrGenerate[Site].get, 
      """TestAnswer""" -> ts.TSType.getOrGenerate[TestAnswer].get, 
      """UserCode""" -> ts.TSType.getOrGenerate[UserCode].get, 
      """Quality""" -> ts.TSType.getOrGenerate[Quality].get, 
  )

  val options = ts.output.OutputOptions(
    targetFile = new _root_.java.io.File("""/app/../client/src/api/models.ts"""), // Warning: always use literal string here for windows paths with \
    styleOptions = ts.output.StyleOptions(
      semicolons = false,
      taggedUnionDiscriminator =  Some("""type""") 
    ),
    header = if("""// DO NOT EDIT: generated file by scala-tsi""" == "") None else Some("""// DO NOT EDIT: generated file by scala-tsi""")
  )

  def main(args: Array[String]): Unit = {
    ts.output.WriteTSToFiles.generate(options)(toOutput)
  }
}
