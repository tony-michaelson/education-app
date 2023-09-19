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
import Tables.{CodeExerciseRow, CodeExerciseTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class CodeExerciseRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseCodeExerciseRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseCodeExerciseRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[CodeExerciseTable, CodeExerciseRow, CodeExercise](TableQuery[CodeExerciseTable], dbConfigProvider) {

    def fromRow(row: CodeExerciseRow): CodeExercise =
      CodeExercise(
				id = NodeID(row.id),
				explanation = row.explanation,
				explanationHTML = row.explanationHTML,
				template = row.template,
				test = row.test,
				solution = row.solution,
			)

    def toRow(nonRow: CodeExercise): CodeExerciseRow =
      CodeExerciseRow(
				id = nonRow.id,
				explanation = nonRow.explanation,
				explanationHTML = nonRow.explanationHTML,
				template = nonRow.template,
				test = nonRow.test,
				solution = nonRow.solution,
			)
  }

case class CodeExercise(id: NodeID, explanation: String, explanationHTML: String, template: String, test: String, solution: String)
object CodeExercise {
  implicit val f: OFormat[CodeExercise] = Jsonx.formatCaseClass[CodeExercise]
}

