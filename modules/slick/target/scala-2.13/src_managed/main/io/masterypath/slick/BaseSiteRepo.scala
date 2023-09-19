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
import Tables.{SiteRow, SiteTable}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions

class SiteRepo @Inject()(implicit dbConfigProvider: DatabaseConfigProvider, ec: ExecutionContext)
    extends BaseSiteRepo(dbConfigProvider = dbConfigProvider)
abstract class BaseSiteRepo(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
    extends BaseRepository[SiteTable, SiteRow, Site](TableQuery[SiteTable], dbConfigProvider) {

    def fromRow(row: SiteRow): Site =
      Site(
				id = SiteID(row.id),
				orgID = row.orgID,
				domain = row.domain,
				theme = row.theme,
				ssl = row.ssl,
				name = row.name,
				description = row.description,
				logo = row.logo,
				favicon = row.favicon,
			)

    def toRow(nonRow: Site): SiteRow =
      SiteRow(
				id = nonRow.id,
				orgID = nonRow.orgID,
				domain = nonRow.domain,
				theme = nonRow.theme,
				ssl = nonRow.ssl,
				name = nonRow.name,
				description = nonRow.description,
				logo = nonRow.logo,
				favicon = nonRow.favicon,
			)
  }

case class Site(id: SiteID, orgID: java.util.UUID, domain: String, theme: String, ssl: Boolean = false, name: String = "", description: String = "", logo: String = "", favicon: String = "")
object Site {
  implicit val f: OFormat[Site] = Jsonx.formatCaseClass[Site]
}
case class SiteID(uuid: UUID) {
  override def toString = uuid.toString
}
object SiteID {
  implicit val formatter: Format[SiteID] =
    new Format[SiteID] with Serializable {
      override def writes(o: SiteID): JsValue = Json.valueWrites[SiteID].writes(o)

      override def reads(json: JsValue): JsResult[SiteID] = Json.valueReads[SiteID].reads(json)
    }

  def apply(id: UUID): SiteID           = new SiteID(uuid = id)
  implicit def toUUID(id: SiteID): UUID = id.uuid
  implicit def toUUIDOption(id: Option[SiteID]): Option[UUID] = id flatMap { x => Some(x.uuid) }

  def random: SiteID = new SiteID(uuid = UUID.randomUUID())

  implicit def pathBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[SiteID] {
    def tryUUID(str: String) =
      try {
        Right(SiteID(id = UUID.fromString(str)))
      } catch {
        case _: Exception =>
          Left("Unable to parse UUID: " + str)
      }

    override def bind(key: String, value: String): Either[String, SiteID] = {
      stringBinder.bind(key, value) match {
        case Right(idString) => tryUUID(idString)
        case Left(error)     => Left(error)
      }
    }
    override def unbind(key: String, id: SiteID): String = {
      id.toString
    }
  }
}
  
