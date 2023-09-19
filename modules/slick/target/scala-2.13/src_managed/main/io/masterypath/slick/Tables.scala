package io.masterypath.slick
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import repos.{BaseEntity, BaseTable}
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Account.schema, Alias.schema, AnswerChoice.schema, AnswerLog.schema, BillingItems.schema, BillingTransactions.schema, CardDue.schema, Card.schema, CodeExercise.schema, Config.schema, FlashcardType.schema, LinkAccount.schema, LinkMapMember.schema, LinkMember.schema, LinkOrganization.schema, LinkRole.schema, LoginTime.schema, MapRights.schema, MemberProfile.schema, MindMap.schema, NodeAttributes.schema, Node.schema, OrgProfile.schema, PostRead.schema, Post.schema, RoleInvite.schema, Role.schema, Site.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Account
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param profileID Database column profileID SqlType(uuid)
   *  @param tokenSubject Database column tokenSubject SqlType(varchar)
   *  @param email Database column email SqlType(varchar)
   *  @param enabled Database column enabled SqlType(bool)
   *  @param created Database column created SqlType(int8) */
  case class AccountRow(id: java.util.UUID, profileID: java.util.UUID, tokenSubject: String, email: String, enabled: Boolean, created: Long) extends BaseEntity
  /** GetResult implicit for fetching AccountRow objects using plain SQL queries */
  implicit def GetResultAccountRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean], e3: GR[Long]): GR[AccountRow] = GR{
    prs => import prs._
    AccountRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[String], <<[Boolean], <<[Long]))
  }
  /** Table description of table account. Objects of this class serve as prototypes for rows in queries. */
  class AccountTable(_tableTag: Tag) extends BaseTable[AccountRow](_tableTag, Some("organization"), "account") {
    def * = (id, profileID, tokenSubject, email, enabled, created) <> (AccountRow.tupled, AccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(profileID), Rep.Some(tokenSubject), Rep.Some(email), Rep.Some(enabled), Rep.Some(created))).shaped.<>({r=>import r._; _1.map(_=> AccountRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")
    /** Database column tokenSubject SqlType(varchar) */
    val tokenSubject: Rep[String] = column[String]("tokenSubject")
    /** Database column email SqlType(varchar) */
    val email: Rep[String] = column[String]("email")
    /** Database column enabled SqlType(bool) */
    val enabled: Rep[Boolean] = column[Boolean]("enabled")
    /** Database column created SqlType(int8) */
    val created: Rep[Long] = column[Long]("created")

    /** Foreign key referencing MemberProfile (database name account_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("account_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (tokenSubject) (database name account_tokenSubject_key) */
    val index1 = index("account_tokenSubject_key", tokenSubject, unique=true)
  }
  /** Collection-like TableQuery object for table Account */
  lazy val Account = new TableQuery(tag => new AccountTable(tag))

  /** Entity class storing rows of table Alias
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param siteID Database column siteID SqlType(uuid)
   *  @param alias Database column alias SqlType(varchar)
   *  @param ssl Database column ssl SqlType(bool), Default(false) */
  case class AliasRow(id: java.util.UUID, siteID: java.util.UUID, alias: String, ssl: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching AliasRow objects using plain SQL queries */
  implicit def GetResultAliasRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[AliasRow] = GR{
    prs => import prs._
    AliasRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[Boolean]))
  }
  /** Table description of table alias. Objects of this class serve as prototypes for rows in queries. */
  class AliasTable(_tableTag: Tag) extends BaseTable[AliasRow](_tableTag, Some("websites"), "alias") {
    def * = (id, siteID, alias, ssl) <> (AliasRow.tupled, AliasRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(siteID), Rep.Some(alias), Rep.Some(ssl))).shaped.<>({r=>import r._; _1.map(_=> AliasRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column siteID SqlType(uuid) */
    val siteID: Rep[java.util.UUID] = column[java.util.UUID]("siteID")
    /** Database column alias SqlType(varchar) */
    val alias: Rep[String] = column[String]("alias")
    /** Database column ssl SqlType(bool), Default(false) */
    val ssl: Rep[Boolean] = column[Boolean]("ssl", O.Default(false))

    /** Foreign key referencing Site (database name alias_siteID_fkey) */
    lazy val siteTableFk = foreignKey("alias_siteID_fkey", siteID, Site)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (alias) (database name alias_alias_key) */
    val index1 = index("alias_alias_key", alias, unique=true)
  }
  /** Collection-like TableQuery object for table Alias */
  lazy val Alias = new TableQuery(tag => new AliasTable(tag))

  /** Entity class storing rows of table AnswerChoice
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param cardID Database column cardID SqlType(uuid)
   *  @param answer Database column answer SqlType(text)
   *  @param correct Database column correct SqlType(bool) */
  case class AnswerChoiceRow(id: java.util.UUID, cardID: java.util.UUID, answer: String, correct: Boolean) extends BaseEntity
  /** GetResult implicit for fetching AnswerChoiceRow objects using plain SQL queries */
  implicit def GetResultAnswerChoiceRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[AnswerChoiceRow] = GR{
    prs => import prs._
    AnswerChoiceRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[Boolean]))
  }
  /** Table description of table answer_choice. Objects of this class serve as prototypes for rows in queries. */
  class AnswerChoiceTable(_tableTag: Tag) extends BaseTable[AnswerChoiceRow](_tableTag, Some("flashcard"), "answer_choice") {
    def * = (id, cardID, answer, correct) <> (AnswerChoiceRow.tupled, AnswerChoiceRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(cardID), Rep.Some(answer), Rep.Some(correct))).shaped.<>({r=>import r._; _1.map(_=> AnswerChoiceRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column cardID SqlType(uuid) */
    val cardID: Rep[java.util.UUID] = column[java.util.UUID]("cardID")
    /** Database column answer SqlType(text) */
    val answer: Rep[String] = column[String]("answer")
    /** Database column correct SqlType(bool) */
    val correct: Rep[Boolean] = column[Boolean]("correct")

    /** Foreign key referencing Card (database name answer_choice_cardID_fkey) */
    lazy val cardTableFk = foreignKey("answer_choice_cardID_fkey", cardID, Card)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table AnswerChoice */
  lazy val AnswerChoice = new TableQuery(tag => new AnswerChoiceTable(tag))

  /** Entity class storing rows of table AnswerLog
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param profileID Database column profileID SqlType(uuid)
   *  @param cardID Database column cardID SqlType(uuid)
   *  @param correct Database column correct SqlType(bool)
   *  @param time Database column time SqlType(int8)
   *  @param elapsedTime Database column elapsedTime SqlType(int4) */
  case class AnswerLogRow(id: java.util.UUID, profileID: java.util.UUID, cardID: java.util.UUID, correct: Boolean, time: Long, elapsedTime: Int) extends BaseEntity
  /** GetResult implicit for fetching AnswerLogRow objects using plain SQL queries */
  implicit def GetResultAnswerLogRow(implicit e0: GR[java.util.UUID], e1: GR[Boolean], e2: GR[Long], e3: GR[Int]): GR[AnswerLogRow] = GR{
    prs => import prs._
    AnswerLogRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID], <<[Boolean], <<[Long], <<[Int]))
  }
  /** Table description of table answer_log. Objects of this class serve as prototypes for rows in queries. */
  class AnswerLogTable(_tableTag: Tag) extends BaseTable[AnswerLogRow](_tableTag, Some("flashcard"), "answer_log") {
    def * = (id, profileID, cardID, correct, time, elapsedTime) <> (AnswerLogRow.tupled, AnswerLogRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(profileID), Rep.Some(cardID), Rep.Some(correct), Rep.Some(time), Rep.Some(elapsedTime))).shaped.<>({r=>import r._; _1.map(_=> AnswerLogRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")
    /** Database column cardID SqlType(uuid) */
    val cardID: Rep[java.util.UUID] = column[java.util.UUID]("cardID")
    /** Database column correct SqlType(bool) */
    val correct: Rep[Boolean] = column[Boolean]("correct")
    /** Database column time SqlType(int8) */
    val time: Rep[Long] = column[Long]("time")
    /** Database column elapsedTime SqlType(int4) */
    val elapsedTime: Rep[Int] = column[Int]("elapsedTime")

    /** Foreign key referencing Card (database name answer_log_cardID_fkey) */
    lazy val cardTableFk = foreignKey("answer_log_cardID_fkey", cardID, Card)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing MemberProfile (database name answer_log_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("answer_log_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AnswerLog */
  lazy val AnswerLog = new TableQuery(tag => new AnswerLogTable(tag))

  /** Entity class storing rows of table BillingItems
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param name Database column name SqlType(varchar)
   *  @param description Database column description SqlType(varchar), Default(None)
   *  @param cost Database column cost SqlType(float8), Default(0.0)
   *  @param monthly Database column monthly SqlType(bool), Default(false) */
  case class BillingItemsRow(id: java.util.UUID, name: String, description: Option[String] = None, cost: Double = 0.0, monthly: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching BillingItemsRow objects using plain SQL queries */
  implicit def GetResultBillingItemsRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Option[String]], e3: GR[Double], e4: GR[Boolean]): GR[BillingItemsRow] = GR{
    prs => import prs._
    BillingItemsRow.tupled((<<[java.util.UUID], <<[String], <<?[String], <<[Double], <<[Boolean]))
  }
  /** Table description of table billing_items. Objects of this class serve as prototypes for rows in queries. */
  class BillingItemsTable(_tableTag: Tag) extends BaseTable[BillingItemsRow](_tableTag, Some("organization"), "billing_items") {
    def * = (id, name, description, cost, monthly) <> (BillingItemsRow.tupled, BillingItemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), description, Rep.Some(cost), Rep.Some(monthly))).shaped.<>({r=>import r._; _1.map(_=> BillingItemsRow.tupled((_1.get, _2.get, _3, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column description SqlType(varchar), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column cost SqlType(float8), Default(0.0) */
    val cost: Rep[Double] = column[Double]("cost", O.Default(0.0))
    /** Database column monthly SqlType(bool), Default(false) */
    val monthly: Rep[Boolean] = column[Boolean]("monthly", O.Default(false))

    /** Uniqueness Index over (name) (database name billing_items_name_key) */
    val index1 = index("billing_items_name_key", name, unique=true)
  }
  /** Collection-like TableQuery object for table BillingItems */
  lazy val BillingItems = new TableQuery(tag => new BillingItemsTable(tag))

  /** Entity class storing rows of table BillingTransactions
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param billingItem Database column billingItem SqlType(uuid)
   *  @param timestamp Database column timestamp SqlType(int8)
   *  @param paid Database column paid SqlType(bool), Default(false) */
  case class BillingTransactionsRow(id: java.util.UUID, orgID: java.util.UUID, billingItem: java.util.UUID, timestamp: Long, paid: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching BillingTransactionsRow objects using plain SQL queries */
  implicit def GetResultBillingTransactionsRow(implicit e0: GR[java.util.UUID], e1: GR[Long], e2: GR[Boolean]): GR[BillingTransactionsRow] = GR{
    prs => import prs._
    BillingTransactionsRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID], <<[Long], <<[Boolean]))
  }
  /** Table description of table billing_transactions. Objects of this class serve as prototypes for rows in queries. */
  class BillingTransactionsTable(_tableTag: Tag) extends BaseTable[BillingTransactionsRow](_tableTag, Some("organization"), "billing_transactions") {
    def * = (id, orgID, billingItem, timestamp, paid) <> (BillingTransactionsRow.tupled, BillingTransactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID), Rep.Some(billingItem), Rep.Some(timestamp), Rep.Some(paid))).shaped.<>({r=>import r._; _1.map(_=> BillingTransactionsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column billingItem SqlType(uuid) */
    val billingItem: Rep[java.util.UUID] = column[java.util.UUID]("billingItem")
    /** Database column timestamp SqlType(int8) */
    val timestamp: Rep[Long] = column[Long]("timestamp")
    /** Database column paid SqlType(bool), Default(false) */
    val paid: Rep[Boolean] = column[Boolean]("paid", O.Default(false))

    /** Foreign key referencing BillingItems (database name billing_transactions_billingItem_fkey) */
    lazy val billingItemsTableFk = foreignKey("billing_transactions_billingItem_fkey", billingItem, BillingItems)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name billing_transactions_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("billing_transactions_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (paid) (database name organization_billing_transactions_paid) */
    val index1 = index("organization_billing_transactions_paid", paid)
  }
  /** Collection-like TableQuery object for table BillingTransactions */
  lazy val BillingTransactions = new TableQuery(tag => new BillingTransactionsTable(tag))

  /** Entity class storing rows of table CardDue
   *  @param id Database column id SqlType(uuid)
   *  @param profileID Database column profileID SqlType(uuid)
   *  @param ef Database column ef SqlType(float8)
   *  @param interval Database column interval SqlType(int4)
   *  @param lastAnswerTime Database column lastAnswerTime SqlType(int8)
   *  @param due Database column due SqlType(int8) */
  case class CardDueRow(id: java.util.UUID, profileID: java.util.UUID, ef: Double, interval: Int, lastAnswerTime: Long, due: Long) extends BaseEntity
  /** GetResult implicit for fetching CardDueRow objects using plain SQL queries */
  implicit def GetResultCardDueRow(implicit e0: GR[java.util.UUID], e1: GR[Double], e2: GR[Int], e3: GR[Long]): GR[CardDueRow] = GR{
    prs => import prs._
    CardDueRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[Double], <<[Int], <<[Long], <<[Long]))
  }
  /** Table description of table card_due. Objects of this class serve as prototypes for rows in queries. */
  class CardDueTable(_tableTag: Tag) extends BaseTable[CardDueRow](_tableTag, Some("flashcard"), "card_due") {
    def * = (id, profileID, ef, interval, lastAnswerTime, due) <> (CardDueRow.tupled, CardDueRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(profileID), Rep.Some(ef), Rep.Some(interval), Rep.Some(lastAnswerTime), Rep.Some(due))).shaped.<>({r=>import r._; _1.map(_=> CardDueRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")
    /** Database column ef SqlType(float8) */
    val ef: Rep[Double] = column[Double]("ef")
    /** Database column interval SqlType(int4) */
    val interval: Rep[Int] = column[Int]("interval")
    /** Database column lastAnswerTime SqlType(int8) */
    val lastAnswerTime: Rep[Long] = column[Long]("lastAnswerTime")
    /** Database column due SqlType(int8) */
    val due: Rep[Long] = column[Long]("due")

    /** Primary key of CardDue (database name card_due_pkey) */
    val pk = primaryKey("card_due_pkey", (id, profileID))

    /** Foreign key referencing Card (database name card_due_id_fkey) */
    lazy val cardTableFk = foreignKey("card_due_id_fkey", id, Card)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing MemberProfile (database name card_due_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("card_due_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table CardDue */
  lazy val CardDue = new TableQuery(tag => new CardDueTable(tag))

  /** Entity class storing rows of table Card
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param mapID Database column mapID SqlType(uuid)
   *  @param flashcardTypeID Database column flashcardTypeID SqlType(uuid)
   *  @param question Database column question SqlType(text)
   *  @param audio Database column audio SqlType(varchar), Length(255,true)
   *  @param markdown Database column markdown SqlType(text), Default()
   *  @param markdown_html Database column markdown_html SqlType(text), Default() */
  case class CardRow(id: java.util.UUID, mapID: java.util.UUID, flashcardTypeID: java.util.UUID, question: String, audio: Option[String], markdown: String = "", markdown_html: String = "") extends BaseEntity
  /** GetResult implicit for fetching CardRow objects using plain SQL queries */
  implicit def GetResultCardRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Option[String]]): GR[CardRow] = GR{
    prs => import prs._
    CardRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID], <<[String], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table card. Objects of this class serve as prototypes for rows in queries. */
  class CardTable(_tableTag: Tag) extends BaseTable[CardRow](_tableTag, Some("flashcard"), "card") {
    def * = (id, mapID, flashcardTypeID, question, audio, markdown, markdown_html) <> (CardRow.tupled, CardRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(mapID), Rep.Some(flashcardTypeID), Rep.Some(question), audio, Rep.Some(markdown), Rep.Some(markdown_html))).shaped.<>({r=>import r._; _1.map(_=> CardRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column mapID SqlType(uuid) */
    val mapID: Rep[java.util.UUID] = column[java.util.UUID]("mapID")
    /** Database column flashcardTypeID SqlType(uuid) */
    val flashcardTypeID: Rep[java.util.UUID] = column[java.util.UUID]("flashcardTypeID")
    /** Database column question SqlType(text) */
    val question: Rep[String] = column[String]("question")
    /** Database column audio SqlType(varchar), Length(255,true) */
    val audio: Rep[Option[String]] = column[Option[String]]("audio", O.Length(255,varying=true))
    /** Database column markdown SqlType(text), Default() */
    val markdown: Rep[String] = column[String]("markdown", O.Default(""))
    /** Database column markdown_html SqlType(text), Default() */
    val markdown_html: Rep[String] = column[String]("markdown_html", O.Default(""))

    /** Foreign key referencing FlashcardType (database name card_flashcardTypeID_fkey) */
    lazy val flashcardTypeTableFk = foreignKey("card_flashcardTypeID_fkey", flashcardTypeID, FlashcardType)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing MindMap (database name card_mapID_fkey) */
    lazy val mindMapTableFk = foreignKey("card_mapID_fkey", mapID, MindMap)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Node (database name card_id_fkey) */
    lazy val nodeTableFk = foreignKey("card_id_fkey", id, Node)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Card */
  lazy val Card = new TableQuery(tag => new CardTable(tag))

  /** Entity class storing rows of table CodeExercise
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param explanation Database column explanation SqlType(text)
   *  @param explanationHTML Database column explanationHTML SqlType(text)
   *  @param template Database column template SqlType(text)
   *  @param test Database column test SqlType(text)
   *  @param solution Database column solution SqlType(text) */
  case class CodeExerciseRow(id: java.util.UUID, explanation: String, explanationHTML: String, template: String, test: String, solution: String) extends BaseEntity
  /** GetResult implicit for fetching CodeExerciseRow objects using plain SQL queries */
  implicit def GetResultCodeExerciseRow(implicit e0: GR[java.util.UUID], e1: GR[String]): GR[CodeExerciseRow] = GR{
    prs => import prs._
    CodeExerciseRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table code_exercise. Objects of this class serve as prototypes for rows in queries. */
  class CodeExerciseTable(_tableTag: Tag) extends BaseTable[CodeExerciseRow](_tableTag, Some("flashcard"), "code_exercise") {
    def * = (id, explanation, explanationHTML, template, test, solution) <> (CodeExerciseRow.tupled, CodeExerciseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(explanation), Rep.Some(explanationHTML), Rep.Some(template), Rep.Some(test), Rep.Some(solution))).shaped.<>({r=>import r._; _1.map(_=> CodeExerciseRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column explanation SqlType(text) */
    val explanation: Rep[String] = column[String]("explanation")
    /** Database column explanationHTML SqlType(text) */
    val explanationHTML: Rep[String] = column[String]("explanationHTML")
    /** Database column template SqlType(text) */
    val template: Rep[String] = column[String]("template")
    /** Database column test SqlType(text) */
    val test: Rep[String] = column[String]("test")
    /** Database column solution SqlType(text) */
    val solution: Rep[String] = column[String]("solution")

    /** Foreign key referencing Card (database name code_exercise_id_fkey) */
    lazy val cardTableFk = foreignKey("code_exercise_id_fkey", id, Card)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table CodeExercise */
  lazy val CodeExercise = new TableQuery(tag => new CodeExerciseTable(tag))

  /** Entity class storing rows of table Config
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param blog Database column blog SqlType(bool), Default(false)
   *  @param contests Database column contests SqlType(bool), Default(false)
   *  @param defaultLanguage Database column defaultLanguage SqlType(varchar)
   *  @param mapDocumentationGeneration Database column mapDocumentationGeneration SqlType(bool), Default(false)
   *  @param marketingCampaigns Database column marketingCampaigns SqlType(bool), Default(false)
   *  @param marketingEngagementCampaigns Database column marketingEngagementCampaigns SqlType(bool), Default(false)
   *  @param problemBoard Database column problemBoard SqlType(bool), Default(false)
   *  @param salesAds Database column salesAds SqlType(bool), Default(false)
   *  @param salesCertificates Database column salesCertificates SqlType(bool), Default(false)
   *  @param salesCourses Database column salesCourses SqlType(bool), Default(false)
   *  @param salesFreeTrials Database column salesFreeTrials SqlType(bool), Default(false)
   *  @param salesMemberFeesActive Database column salesMemberFeesActive SqlType(bool), Default(false)
   *  @param salesMemberFeesStatic Database column salesMemberFeesStatic SqlType(bool), Default(false)
   *  @param salesMemberships Database column salesMemberships SqlType(bool), Default(false)
   *  @param salesOrganizations Database column salesOrganizations SqlType(bool), Default(false)
   *  @param supportTier Database column supportTier SqlType(int2)
   *  @param trainingAnswerTimeTracking Database column trainingAnswerTimeTracking SqlType(bool), Default(false)
   *  @param trainingBreakTime Database column trainingBreakTime SqlType(bool), Default(false)
   *  @param trainingComplianceEnforcement Database column trainingComplianceEnforcement SqlType(bool), Default(false)
   *  @param trainingComments Database column trainingComments SqlType(bool), Default(false)
   *  @param trainingContentPageStudentSubmission Database column trainingContentPageStudentSubmission SqlType(bool), Default(false)
   *  @param trainingContentPageTimeTracking Database column trainingContentPageTimeTracking SqlType(bool), Default(false)
   *  @param trainingContentPageUpvote Database column trainingContentPageUpvote SqlType(bool), Default(false)
   *  @param trainingCorrectAnswerAnimation Database column trainingCorrectAnswerAnimation SqlType(bool), Default(false)
   *  @param trainingCorrectAnswerSound Database column trainingCorrectAnswerSound SqlType(bool), Default(false)
   *  @param trainingFeedback Database column trainingFeedback SqlType(bool), Default(false)
   *  @param trainingLearningPaths Database column trainingLearningPaths SqlType(bool), Default(false)
   *  @param trainingMnemonics Database column trainingMnemonics SqlType(bool), Default(false)
   *  @param trainingQuotes Database column trainingQuotes SqlType(bool), Default(false)
   *  @param trainingRankings Database column trainingRankings SqlType(bool), Default(false)
   *  @param trainingReporting Database column trainingReporting SqlType(bool), Default(false)
   *  @param trainingRewardsProgram Database column trainingRewardsProgram SqlType(bool), Default(false)
   *  @param trainingSessionEndCelebration Database column trainingSessionEndCelebration SqlType(bool), Default(false)
   *  @param trainingSessionEndFeedback Database column trainingSessionEndFeedback SqlType(bool), Default(false)
   *  @param trainingStraightThruMode Database column trainingStraightThruMode SqlType(bool), Default(false)
   *  @param trainingStudyGoals Database column trainingStudyGoals SqlType(bool), Default(false)
   *  @param trainingVirtualLabs Database column trainingVirtualLabs SqlType(bool), Default(false)
   *  @param whiteLabeled Database column whiteLabeled SqlType(bool), Default(false)
   *  @param memberMonthlyCost Database column memberMonthlyCost SqlType(float8), Default(0.0)
   *  @param memberAnnualCost Database column memberAnnualCost SqlType(float8), Default(0.0)
   *  @param memberPaymentMethodRequired Database column memberPaymentMethodRequired SqlType(bool), Default(false) */
  case class ConfigRow(id: java.util.UUID, blog: Boolean = false, contests: Boolean = false, defaultLanguage: String, mapDocumentationGeneration: Boolean = false, marketingCampaigns: Boolean = false, marketingEngagementCampaigns: Boolean = false, problemBoard: Boolean = false, salesAds: Boolean = false, salesCertificates: Boolean = false, salesCourses: Boolean = false, salesFreeTrials: Boolean = false, salesMemberFeesActive: Boolean = false, salesMemberFeesStatic: Boolean = false, salesMemberships: Boolean = false, salesOrganizations: Boolean = false, supportTier: Short, trainingAnswerTimeTracking: Boolean = false, trainingBreakTime: Boolean = false, trainingComplianceEnforcement: Boolean = false, trainingComments: Boolean = false, trainingContentPageStudentSubmission: Boolean = false, trainingContentPageTimeTracking: Boolean = false, trainingContentPageUpvote: Boolean = false, trainingCorrectAnswerAnimation: Boolean = false, trainingCorrectAnswerSound: Boolean = false, trainingFeedback: Boolean = false, trainingLearningPaths: Boolean = false, trainingMnemonics: Boolean = false, trainingQuotes: Boolean = false, trainingRankings: Boolean = false, trainingReporting: Boolean = false, trainingRewardsProgram: Boolean = false, trainingSessionEndCelebration: Boolean = false, trainingSessionEndFeedback: Boolean = false, trainingStraightThruMode: Boolean = false, trainingStudyGoals: Boolean = false, trainingVirtualLabs: Boolean = false, whiteLabeled: Boolean = false, memberMonthlyCost: Double = 0.0, memberAnnualCost: Double = 0.0, memberPaymentMethodRequired: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching ConfigRow objects using plain SQL queries */
  implicit def GetResultConfigRow(implicit e0: GR[java.util.UUID], e1: GR[Boolean], e2: GR[String], e3: GR[Short], e4: GR[Double]): GR[ConfigRow] = GR{
    prs => import prs._
    ConfigRow(<<[java.util.UUID], <<[Boolean], <<[Boolean], <<[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Short], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Double], <<[Double], <<[Boolean])
  }
  /** Table description of table config. Objects of this class serve as prototypes for rows in queries. */
  class ConfigTable(_tableTag: Tag) extends BaseTable[ConfigRow](_tableTag, Some("organization"), "config") {
    def * = (id :: blog :: contests :: defaultLanguage :: mapDocumentationGeneration :: marketingCampaigns :: marketingEngagementCampaigns :: problemBoard :: salesAds :: salesCertificates :: salesCourses :: salesFreeTrials :: salesMemberFeesActive :: salesMemberFeesStatic :: salesMemberships :: salesOrganizations :: supportTier :: trainingAnswerTimeTracking :: trainingBreakTime :: trainingComplianceEnforcement :: trainingComments :: trainingContentPageStudentSubmission :: trainingContentPageTimeTracking :: trainingContentPageUpvote :: trainingCorrectAnswerAnimation :: trainingCorrectAnswerSound :: trainingFeedback :: trainingLearningPaths :: trainingMnemonics :: trainingQuotes :: trainingRankings :: trainingReporting :: trainingRewardsProgram :: trainingSessionEndCelebration :: trainingSessionEndFeedback :: trainingStraightThruMode :: trainingStudyGoals :: trainingVirtualLabs :: whiteLabeled :: memberMonthlyCost :: memberAnnualCost :: memberPaymentMethodRequired :: HNil).mapTo[ConfigRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id) :: Rep.Some(blog) :: Rep.Some(contests) :: Rep.Some(defaultLanguage) :: Rep.Some(mapDocumentationGeneration) :: Rep.Some(marketingCampaigns) :: Rep.Some(marketingEngagementCampaigns) :: Rep.Some(problemBoard) :: Rep.Some(salesAds) :: Rep.Some(salesCertificates) :: Rep.Some(salesCourses) :: Rep.Some(salesFreeTrials) :: Rep.Some(salesMemberFeesActive) :: Rep.Some(salesMemberFeesStatic) :: Rep.Some(salesMemberships) :: Rep.Some(salesOrganizations) :: Rep.Some(supportTier) :: Rep.Some(trainingAnswerTimeTracking) :: Rep.Some(trainingBreakTime) :: Rep.Some(trainingComplianceEnforcement) :: Rep.Some(trainingComments) :: Rep.Some(trainingContentPageStudentSubmission) :: Rep.Some(trainingContentPageTimeTracking) :: Rep.Some(trainingContentPageUpvote) :: Rep.Some(trainingCorrectAnswerAnimation) :: Rep.Some(trainingCorrectAnswerSound) :: Rep.Some(trainingFeedback) :: Rep.Some(trainingLearningPaths) :: Rep.Some(trainingMnemonics) :: Rep.Some(trainingQuotes) :: Rep.Some(trainingRankings) :: Rep.Some(trainingReporting) :: Rep.Some(trainingRewardsProgram) :: Rep.Some(trainingSessionEndCelebration) :: Rep.Some(trainingSessionEndFeedback) :: Rep.Some(trainingStraightThruMode) :: Rep.Some(trainingStudyGoals) :: Rep.Some(trainingVirtualLabs) :: Rep.Some(whiteLabeled) :: Rep.Some(memberMonthlyCost) :: Rep.Some(memberAnnualCost) :: Rep.Some(memberPaymentMethodRequired) :: HNil).shaped.<>(r => ConfigRow(r(0).asInstanceOf[Option[java.util.UUID]].get, r(1).asInstanceOf[Option[Boolean]].get, r(2).asInstanceOf[Option[Boolean]].get, r(3).asInstanceOf[Option[String]].get, r(4).asInstanceOf[Option[Boolean]].get, r(5).asInstanceOf[Option[Boolean]].get, r(6).asInstanceOf[Option[Boolean]].get, r(7).asInstanceOf[Option[Boolean]].get, r(8).asInstanceOf[Option[Boolean]].get, r(9).asInstanceOf[Option[Boolean]].get, r(10).asInstanceOf[Option[Boolean]].get, r(11).asInstanceOf[Option[Boolean]].get, r(12).asInstanceOf[Option[Boolean]].get, r(13).asInstanceOf[Option[Boolean]].get, r(14).asInstanceOf[Option[Boolean]].get, r(15).asInstanceOf[Option[Boolean]].get, r(16).asInstanceOf[Option[Short]].get, r(17).asInstanceOf[Option[Boolean]].get, r(18).asInstanceOf[Option[Boolean]].get, r(19).asInstanceOf[Option[Boolean]].get, r(20).asInstanceOf[Option[Boolean]].get, r(21).asInstanceOf[Option[Boolean]].get, r(22).asInstanceOf[Option[Boolean]].get, r(23).asInstanceOf[Option[Boolean]].get, r(24).asInstanceOf[Option[Boolean]].get, r(25).asInstanceOf[Option[Boolean]].get, r(26).asInstanceOf[Option[Boolean]].get, r(27).asInstanceOf[Option[Boolean]].get, r(28).asInstanceOf[Option[Boolean]].get, r(29).asInstanceOf[Option[Boolean]].get, r(30).asInstanceOf[Option[Boolean]].get, r(31).asInstanceOf[Option[Boolean]].get, r(32).asInstanceOf[Option[Boolean]].get, r(33).asInstanceOf[Option[Boolean]].get, r(34).asInstanceOf[Option[Boolean]].get, r(35).asInstanceOf[Option[Boolean]].get, r(36).asInstanceOf[Option[Boolean]].get, r(37).asInstanceOf[Option[Boolean]].get, r(38).asInstanceOf[Option[Boolean]].get, r(39).asInstanceOf[Option[Double]].get, r(40).asInstanceOf[Option[Double]].get, r(41).asInstanceOf[Option[Boolean]].get), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column blog SqlType(bool), Default(false) */
    val blog: Rep[Boolean] = column[Boolean]("blog", O.Default(false))
    /** Database column contests SqlType(bool), Default(false) */
    val contests: Rep[Boolean] = column[Boolean]("contests", O.Default(false))
    /** Database column defaultLanguage SqlType(varchar) */
    val defaultLanguage: Rep[String] = column[String]("defaultLanguage")
    /** Database column mapDocumentationGeneration SqlType(bool), Default(false) */
    val mapDocumentationGeneration: Rep[Boolean] = column[Boolean]("mapDocumentationGeneration", O.Default(false))
    /** Database column marketingCampaigns SqlType(bool), Default(false) */
    val marketingCampaigns: Rep[Boolean] = column[Boolean]("marketingCampaigns", O.Default(false))
    /** Database column marketingEngagementCampaigns SqlType(bool), Default(false) */
    val marketingEngagementCampaigns: Rep[Boolean] = column[Boolean]("marketingEngagementCampaigns", O.Default(false))
    /** Database column problemBoard SqlType(bool), Default(false) */
    val problemBoard: Rep[Boolean] = column[Boolean]("problemBoard", O.Default(false))
    /** Database column salesAds SqlType(bool), Default(false) */
    val salesAds: Rep[Boolean] = column[Boolean]("salesAds", O.Default(false))
    /** Database column salesCertificates SqlType(bool), Default(false) */
    val salesCertificates: Rep[Boolean] = column[Boolean]("salesCertificates", O.Default(false))
    /** Database column salesCourses SqlType(bool), Default(false) */
    val salesCourses: Rep[Boolean] = column[Boolean]("salesCourses", O.Default(false))
    /** Database column salesFreeTrials SqlType(bool), Default(false) */
    val salesFreeTrials: Rep[Boolean] = column[Boolean]("salesFreeTrials", O.Default(false))
    /** Database column salesMemberFeesActive SqlType(bool), Default(false) */
    val salesMemberFeesActive: Rep[Boolean] = column[Boolean]("salesMemberFeesActive", O.Default(false))
    /** Database column salesMemberFeesStatic SqlType(bool), Default(false) */
    val salesMemberFeesStatic: Rep[Boolean] = column[Boolean]("salesMemberFeesStatic", O.Default(false))
    /** Database column salesMemberships SqlType(bool), Default(false) */
    val salesMemberships: Rep[Boolean] = column[Boolean]("salesMemberships", O.Default(false))
    /** Database column salesOrganizations SqlType(bool), Default(false) */
    val salesOrganizations: Rep[Boolean] = column[Boolean]("salesOrganizations", O.Default(false))
    /** Database column supportTier SqlType(int2) */
    val supportTier: Rep[Short] = column[Short]("supportTier")
    /** Database column trainingAnswerTimeTracking SqlType(bool), Default(false) */
    val trainingAnswerTimeTracking: Rep[Boolean] = column[Boolean]("trainingAnswerTimeTracking", O.Default(false))
    /** Database column trainingBreakTime SqlType(bool), Default(false) */
    val trainingBreakTime: Rep[Boolean] = column[Boolean]("trainingBreakTime", O.Default(false))
    /** Database column trainingComplianceEnforcement SqlType(bool), Default(false) */
    val trainingComplianceEnforcement: Rep[Boolean] = column[Boolean]("trainingComplianceEnforcement", O.Default(false))
    /** Database column trainingComments SqlType(bool), Default(false) */
    val trainingComments: Rep[Boolean] = column[Boolean]("trainingComments", O.Default(false))
    /** Database column trainingContentPageStudentSubmission SqlType(bool), Default(false) */
    val trainingContentPageStudentSubmission: Rep[Boolean] = column[Boolean]("trainingContentPageStudentSubmission", O.Default(false))
    /** Database column trainingContentPageTimeTracking SqlType(bool), Default(false) */
    val trainingContentPageTimeTracking: Rep[Boolean] = column[Boolean]("trainingContentPageTimeTracking", O.Default(false))
    /** Database column trainingContentPageUpvote SqlType(bool), Default(false) */
    val trainingContentPageUpvote: Rep[Boolean] = column[Boolean]("trainingContentPageUpvote", O.Default(false))
    /** Database column trainingCorrectAnswerAnimation SqlType(bool), Default(false) */
    val trainingCorrectAnswerAnimation: Rep[Boolean] = column[Boolean]("trainingCorrectAnswerAnimation", O.Default(false))
    /** Database column trainingCorrectAnswerSound SqlType(bool), Default(false) */
    val trainingCorrectAnswerSound: Rep[Boolean] = column[Boolean]("trainingCorrectAnswerSound", O.Default(false))
    /** Database column trainingFeedback SqlType(bool), Default(false) */
    val trainingFeedback: Rep[Boolean] = column[Boolean]("trainingFeedback", O.Default(false))
    /** Database column trainingLearningPaths SqlType(bool), Default(false) */
    val trainingLearningPaths: Rep[Boolean] = column[Boolean]("trainingLearningPaths", O.Default(false))
    /** Database column trainingMnemonics SqlType(bool), Default(false) */
    val trainingMnemonics: Rep[Boolean] = column[Boolean]("trainingMnemonics", O.Default(false))
    /** Database column trainingQuotes SqlType(bool), Default(false) */
    val trainingQuotes: Rep[Boolean] = column[Boolean]("trainingQuotes", O.Default(false))
    /** Database column trainingRankings SqlType(bool), Default(false) */
    val trainingRankings: Rep[Boolean] = column[Boolean]("trainingRankings", O.Default(false))
    /** Database column trainingReporting SqlType(bool), Default(false) */
    val trainingReporting: Rep[Boolean] = column[Boolean]("trainingReporting", O.Default(false))
    /** Database column trainingRewardsProgram SqlType(bool), Default(false) */
    val trainingRewardsProgram: Rep[Boolean] = column[Boolean]("trainingRewardsProgram", O.Default(false))
    /** Database column trainingSessionEndCelebration SqlType(bool), Default(false) */
    val trainingSessionEndCelebration: Rep[Boolean] = column[Boolean]("trainingSessionEndCelebration", O.Default(false))
    /** Database column trainingSessionEndFeedback SqlType(bool), Default(false) */
    val trainingSessionEndFeedback: Rep[Boolean] = column[Boolean]("trainingSessionEndFeedback", O.Default(false))
    /** Database column trainingStraightThruMode SqlType(bool), Default(false) */
    val trainingStraightThruMode: Rep[Boolean] = column[Boolean]("trainingStraightThruMode", O.Default(false))
    /** Database column trainingStudyGoals SqlType(bool), Default(false) */
    val trainingStudyGoals: Rep[Boolean] = column[Boolean]("trainingStudyGoals", O.Default(false))
    /** Database column trainingVirtualLabs SqlType(bool), Default(false) */
    val trainingVirtualLabs: Rep[Boolean] = column[Boolean]("trainingVirtualLabs", O.Default(false))
    /** Database column whiteLabeled SqlType(bool), Default(false) */
    val whiteLabeled: Rep[Boolean] = column[Boolean]("whiteLabeled", O.Default(false))
    /** Database column memberMonthlyCost SqlType(float8), Default(0.0) */
    val memberMonthlyCost: Rep[Double] = column[Double]("memberMonthlyCost", O.Default(0.0))
    /** Database column memberAnnualCost SqlType(float8), Default(0.0) */
    val memberAnnualCost: Rep[Double] = column[Double]("memberAnnualCost", O.Default(0.0))
    /** Database column memberPaymentMethodRequired SqlType(bool), Default(false) */
    val memberPaymentMethodRequired: Rep[Boolean] = column[Boolean]("memberPaymentMethodRequired", O.Default(false))

    /** Foreign key referencing OrgProfile (database name config_id_fkey) */
    lazy val orgProfileTableFk = foreignKey("config_id_fkey", id :: HNil, OrgProfile)(r => r.id :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Config */
  lazy val Config = new TableQuery(tag => new ConfigTable(tag))

  /** Entity class storing rows of table FlashcardType
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param cardType Database column cardType SqlType(varchar), Length(40,true)
   *  @param name Database column name SqlType(varchar), Length(20,true)
   *  @param commonName Database column commonName SqlType(varchar), Length(40,true)
   *  @param description Database column description SqlType(text), Default(None)
   *  @param config Database column config SqlType(text), Default(None) */
  case class FlashcardTypeRow(id: java.util.UUID, cardType: String, name: String, commonName: String, description: Option[String] = None, config: Option[String] = None) extends BaseEntity
  /** GetResult implicit for fetching FlashcardTypeRow objects using plain SQL queries */
  implicit def GetResultFlashcardTypeRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Option[String]]): GR[FlashcardTypeRow] = GR{
    prs => import prs._
    FlashcardTypeRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[String], <<?[String], <<?[String]))
  }
  /** Table description of table flashcard_type. Objects of this class serve as prototypes for rows in queries. */
  class FlashcardTypeTable(_tableTag: Tag) extends BaseTable[FlashcardTypeRow](_tableTag, Some("flashcard"), "flashcard_type") {
    def * = (id, cardType, name, commonName, description, config) <> (FlashcardTypeRow.tupled, FlashcardTypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(cardType), Rep.Some(name), Rep.Some(commonName), description, config)).shaped.<>({r=>import r._; _1.map(_=> FlashcardTypeRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column cardType SqlType(varchar), Length(40,true) */
    val cardType: Rep[String] = column[String]("cardType", O.Length(40,varying=true))
    /** Database column name SqlType(varchar), Length(20,true) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=true))
    /** Database column commonName SqlType(varchar), Length(40,true) */
    val commonName: Rep[String] = column[String]("commonName", O.Length(40,varying=true))
    /** Database column description SqlType(text), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column config SqlType(text), Default(None) */
    val config: Rep[Option[String]] = column[Option[String]]("config", O.Default(None))

    /** Uniqueness Index over (name) (database name flashcard_types_no_dups) */
    val index1 = index("flashcard_types_no_dups", name, unique=true)
  }
  /** Collection-like TableQuery object for table FlashcardType */
  lazy val FlashcardType = new TableQuery(tag => new FlashcardTypeTable(tag))

  /** Entity class storing rows of table LinkAccount
   *  @param id Database column id SqlType(uuid)
   *  @param orgID Database column orgID SqlType(uuid) */
  case class LinkAccountRow(id: java.util.UUID, orgID: java.util.UUID) extends BaseEntity
  /** GetResult implicit for fetching LinkAccountRow objects using plain SQL queries */
  implicit def GetResultLinkAccountRow(implicit e0: GR[java.util.UUID]): GR[LinkAccountRow] = GR{
    prs => import prs._
    LinkAccountRow.tupled((<<[java.util.UUID], <<[java.util.UUID]))
  }
  /** Table description of table link_account. Objects of this class serve as prototypes for rows in queries. */
  class LinkAccountTable(_tableTag: Tag) extends BaseTable[LinkAccountRow](_tableTag, Some("organization"), "link_account") {
    def * = (id, orgID) <> (LinkAccountRow.tupled, LinkAccountRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID))).shaped.<>({r=>import r._; _1.map(_=> LinkAccountRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")

    /** Foreign key referencing Account (database name link_account_id_fkey) */
    lazy val accountTableFk = foreignKey("link_account_id_fkey", id, Account)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name link_account_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("link_account_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (id,orgID) (database name link_account_no_dups) */
    val index1 = index("link_account_no_dups", (id, orgID), unique=true)
  }
  /** Collection-like TableQuery object for table LinkAccount */
  lazy val LinkAccount = new TableQuery(tag => new LinkAccountTable(tag))

  /** Entity class storing rows of table LinkMapMember
   *  @param id Database column id SqlType(uuid)
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param profileID Database column profileID SqlType(uuid) */
  case class LinkMapMemberRow(id: java.util.UUID, orgID: java.util.UUID, profileID: java.util.UUID) extends BaseEntity
  /** GetResult implicit for fetching LinkMapMemberRow objects using plain SQL queries */
  implicit def GetResultLinkMapMemberRow(implicit e0: GR[java.util.UUID]): GR[LinkMapMemberRow] = GR{
    prs => import prs._
    LinkMapMemberRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID]))
  }
  /** Table description of table link_map_member. Objects of this class serve as prototypes for rows in queries. */
  class LinkMapMemberTable(_tableTag: Tag) extends BaseTable[LinkMapMemberRow](_tableTag, Some("mind_map"), "link_map_member") {
    def * = (id, orgID, profileID) <> (LinkMapMemberRow.tupled, LinkMapMemberRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID), Rep.Some(profileID))).shaped.<>({r=>import r._; _1.map(_=> LinkMapMemberRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")

    /** Foreign key referencing MapRights (database name link_map_member_id_fkey) */
    lazy val mapRightsTableFk = foreignKey("link_map_member_id_fkey", id, MapRights)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing MemberProfile (database name link_map_member_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("link_map_member_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name link_map_member_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("link_map_member_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (id,profileID) (database name link_maprights_no_dups) */
    val index1 = index("link_maprights_no_dups", (id, profileID), unique=true)
  }
  /** Collection-like TableQuery object for table LinkMapMember */
  lazy val LinkMapMember = new TableQuery(tag => new LinkMapMemberTable(tag))

  /** Entity class storing rows of table LinkMember
   *  @param id Database column id SqlType(uuid)
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param internal Database column internal SqlType(bool), Default(false)
   *  @param payPerCourse Database column payPerCourse SqlType(bool), Default(false) */
  case class LinkMemberRow(id: java.util.UUID, orgID: java.util.UUID, internal: Boolean = false, payPerCourse: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching LinkMemberRow objects using plain SQL queries */
  implicit def GetResultLinkMemberRow(implicit e0: GR[java.util.UUID], e1: GR[Boolean]): GR[LinkMemberRow] = GR{
    prs => import prs._
    LinkMemberRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[Boolean], <<[Boolean]))
  }
  /** Table description of table link_member. Objects of this class serve as prototypes for rows in queries. */
  class LinkMemberTable(_tableTag: Tag) extends BaseTable[LinkMemberRow](_tableTag, Some("organization"), "link_member") {
    def * = (id, orgID, internal, payPerCourse) <> (LinkMemberRow.tupled, LinkMemberRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID), Rep.Some(internal), Rep.Some(payPerCourse))).shaped.<>({r=>import r._; _1.map(_=> LinkMemberRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column internal SqlType(bool), Default(false) */
    val internal: Rep[Boolean] = column[Boolean]("internal", O.Default(false))
    /** Database column payPerCourse SqlType(bool), Default(false) */
    val payPerCourse: Rep[Boolean] = column[Boolean]("payPerCourse", O.Default(false))

    /** Foreign key referencing MemberProfile (database name link_member_id_fkey) */
    lazy val memberProfileTableFk = foreignKey("link_member_id_fkey", id, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name link_member_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("link_member_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (id,orgID) (database name link_member_no_dups) */
    val index1 = index("link_member_no_dups", (id, orgID), unique=true)
  }
  /** Collection-like TableQuery object for table LinkMember */
  lazy val LinkMember = new TableQuery(tag => new LinkMemberTable(tag))

  /** Entity class storing rows of table LinkOrganization
   *  @param id Database column id SqlType(uuid)
   *  @param orgMemberID Database column orgMemberID SqlType(uuid) */
  case class LinkOrganizationRow(id: java.util.UUID, orgMemberID: java.util.UUID) extends BaseEntity
  /** GetResult implicit for fetching LinkOrganizationRow objects using plain SQL queries */
  implicit def GetResultLinkOrganizationRow(implicit e0: GR[java.util.UUID]): GR[LinkOrganizationRow] = GR{
    prs => import prs._
    LinkOrganizationRow.tupled((<<[java.util.UUID], <<[java.util.UUID]))
  }
  /** Table description of table link_organization. Objects of this class serve as prototypes for rows in queries. */
  class LinkOrganizationTable(_tableTag: Tag) extends BaseTable[LinkOrganizationRow](_tableTag, Some("organization"), "link_organization") {
    def * = (id, orgMemberID) <> (LinkOrganizationRow.tupled, LinkOrganizationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgMemberID))).shaped.<>({r=>import r._; _1.map(_=> LinkOrganizationRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column orgMemberID SqlType(uuid) */
    val orgMemberID: Rep[java.util.UUID] = column[java.util.UUID]("orgMemberID")

    /** Foreign key referencing OrgProfile (database name link_organization_id_fkey) */
    lazy val orgProfileTableFk1 = foreignKey("link_organization_id_fkey", id, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name link_organization_orgMemberID_fkey) */
    lazy val orgProfileTableFk2 = foreignKey("link_organization_orgMemberID_fkey", orgMemberID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (id,orgMemberID) (database name link_organization_no_dups) */
    val index1 = index("link_organization_no_dups", (id, orgMemberID), unique=true)
  }
  /** Collection-like TableQuery object for table LinkOrganization */
  lazy val LinkOrganization = new TableQuery(tag => new LinkOrganizationTable(tag))

  /** Entity class storing rows of table LinkRole
   *  @param id Database column id SqlType(uuid)
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param roleID Database column roleID SqlType(uuid) */
  case class LinkRoleRow(id: java.util.UUID, orgID: java.util.UUID, roleID: java.util.UUID) extends BaseEntity
  /** GetResult implicit for fetching LinkRoleRow objects using plain SQL queries */
  implicit def GetResultLinkRoleRow(implicit e0: GR[java.util.UUID]): GR[LinkRoleRow] = GR{
    prs => import prs._
    LinkRoleRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID]))
  }
  /** Table description of table link_role. Objects of this class serve as prototypes for rows in queries. */
  class LinkRoleTable(_tableTag: Tag) extends BaseTable[LinkRoleRow](_tableTag, Some("organization"), "link_role") {
    def * = (id, orgID, roleID) <> (LinkRoleRow.tupled, LinkRoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID), Rep.Some(roleID))).shaped.<>({r=>import r._; _1.map(_=> LinkRoleRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column roleID SqlType(uuid) */
    val roleID: Rep[java.util.UUID] = column[java.util.UUID]("roleID")

    /** Foreign key referencing MemberProfile (database name link_role_id_fkey) */
    lazy val memberProfileTableFk = foreignKey("link_role_id_fkey", id, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name link_role_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("link_role_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Role (database name link_role_roleID_fkey) */
    lazy val roleTableFk = foreignKey("link_role_roleID_fkey", roleID, Role)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)

    /** Uniqueness Index over (id,roleID) (database name link_role_no_dups) */
    val index1 = index("link_role_no_dups", (id, roleID), unique=true)
  }
  /** Collection-like TableQuery object for table LinkRole */
  lazy val LinkRole = new TableQuery(tag => new LinkRoleTable(tag))

  /** Entity class storing rows of table LoginTime
   *  @param id Database column id SqlType(uuid)
   *  @param timestamp Database column timestamp SqlType(int8) */
  case class LoginTimeRow(id: java.util.UUID, timestamp: Long) extends BaseEntity
  /** GetResult implicit for fetching LoginTimeRow objects using plain SQL queries */
  implicit def GetResultLoginTimeRow(implicit e0: GR[java.util.UUID], e1: GR[Long]): GR[LoginTimeRow] = GR{
    prs => import prs._
    LoginTimeRow.tupled((<<[java.util.UUID], <<[Long]))
  }
  /** Table description of table login_time. Objects of this class serve as prototypes for rows in queries. */
  class LoginTimeTable(_tableTag: Tag) extends BaseTable[LoginTimeRow](_tableTag, Some("organization"), "login_time") {
    def * = (id, timestamp) <> (LoginTimeRow.tupled, LoginTimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(timestamp))).shaped.<>({r=>import r._; _1.map(_=> LoginTimeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid) */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id")
    /** Database column timestamp SqlType(int8) */
    val timestamp: Rep[Long] = column[Long]("timestamp")

    /** Foreign key referencing Account (database name login_time_id_fkey) */
    lazy val accountTableFk = foreignKey("login_time_id_fkey", id, Account)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table LoginTime */
  lazy val LoginTime = new TableQuery(tag => new LoginTimeTable(tag))

  /** Entity class storing rows of table MapRights
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(40,true)
   *  @param mapID Database column mapID SqlType(uuid)
   *  @param admin Database column admin SqlType(bool), Default(false)
   *  @param feedback Database column feedback SqlType(bool), Default(false)
   *  @param mnemonics Database column mnemonics SqlType(bool), Default(false)
   *  @param modify Database column modify SqlType(bool), Default(false)
   *  @param permissions Database column permissions SqlType(bool), Default(false)
   *  @param publish Database column publish SqlType(bool), Default(false)
   *  @param share Database column share SqlType(bool), Default(false)
   *  @param stats Database column stats SqlType(bool), Default(false)
   *  @param training Database column training SqlType(bool), Default(false)
   *  @param transfer Database column transfer SqlType(bool), Default(false)
   *  @param view Database column view SqlType(bool), Default(false) */
  case class MapRightsRow(id: java.util.UUID, name: String, mapID: java.util.UUID, admin: Boolean = false, feedback: Boolean = false, mnemonics: Boolean = false, modify: Boolean = false, permissions: Boolean = false, publish: Boolean = false, share: Boolean = false, stats: Boolean = false, training: Boolean = false, transfer: Boolean = false, view: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching MapRightsRow objects using plain SQL queries */
  implicit def GetResultMapRightsRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[MapRightsRow] = GR{
    prs => import prs._
    MapRightsRow.tupled((<<[java.util.UUID], <<[String], <<[java.util.UUID], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean]))
  }
  /** Table description of table map_rights. Objects of this class serve as prototypes for rows in queries. */
  class MapRightsTable(_tableTag: Tag) extends BaseTable[MapRightsRow](_tableTag, Some("mind_map"), "map_rights") {
    def * = (id, name, mapID, admin, feedback, mnemonics, modify, permissions, publish, share, stats, training, transfer, view) <> (MapRightsRow.tupled, MapRightsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(mapID), Rep.Some(admin), Rep.Some(feedback), Rep.Some(mnemonics), Rep.Some(modify), Rep.Some(permissions), Rep.Some(publish), Rep.Some(share), Rep.Some(stats), Rep.Some(training), Rep.Some(transfer), Rep.Some(view))).shaped.<>({r=>import r._; _1.map(_=> MapRightsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(40,true) */
    val name: Rep[String] = column[String]("name", O.Length(40,varying=true))
    /** Database column mapID SqlType(uuid) */
    val mapID: Rep[java.util.UUID] = column[java.util.UUID]("mapID")
    /** Database column admin SqlType(bool), Default(false) */
    val admin: Rep[Boolean] = column[Boolean]("admin", O.Default(false))
    /** Database column feedback SqlType(bool), Default(false) */
    val feedback: Rep[Boolean] = column[Boolean]("feedback", O.Default(false))
    /** Database column mnemonics SqlType(bool), Default(false) */
    val mnemonics: Rep[Boolean] = column[Boolean]("mnemonics", O.Default(false))
    /** Database column modify SqlType(bool), Default(false) */
    val modify: Rep[Boolean] = column[Boolean]("modify", O.Default(false))
    /** Database column permissions SqlType(bool), Default(false) */
    val permissions: Rep[Boolean] = column[Boolean]("permissions", O.Default(false))
    /** Database column publish SqlType(bool), Default(false) */
    val publish: Rep[Boolean] = column[Boolean]("publish", O.Default(false))
    /** Database column share SqlType(bool), Default(false) */
    val share: Rep[Boolean] = column[Boolean]("share", O.Default(false))
    /** Database column stats SqlType(bool), Default(false) */
    val stats: Rep[Boolean] = column[Boolean]("stats", O.Default(false))
    /** Database column training SqlType(bool), Default(false) */
    val training: Rep[Boolean] = column[Boolean]("training", O.Default(false))
    /** Database column transfer SqlType(bool), Default(false) */
    val transfer: Rep[Boolean] = column[Boolean]("transfer", O.Default(false))
    /** Database column view SqlType(bool), Default(false) */
    val view: Rep[Boolean] = column[Boolean]("view", O.Default(false))

    /** Foreign key referencing MindMap (database name map_rights_mapID_fkey) */
    lazy val mindMapTableFk = foreignKey("map_rights_mapID_fkey", mapID, MindMap)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table MapRights */
  lazy val MapRights = new TableQuery(tag => new MapRightsTable(tag))

  /** Entity class storing rows of table MemberProfile
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param firstName Database column firstName SqlType(varchar)
   *  @param lastName Database column lastName SqlType(varchar)
   *  @param avatarURL Database column avatarURL SqlType(varchar)
   *  @param enabled Database column enabled SqlType(bool) */
  case class MemberProfileRow(id: java.util.UUID, firstName: String, lastName: String, avatarURL: String, enabled: Boolean) extends BaseEntity
  /** GetResult implicit for fetching MemberProfileRow objects using plain SQL queries */
  implicit def GetResultMemberProfileRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[MemberProfileRow] = GR{
    prs => import prs._
    MemberProfileRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table member_profile. Objects of this class serve as prototypes for rows in queries. */
  class MemberProfileTable(_tableTag: Tag) extends BaseTable[MemberProfileRow](_tableTag, Some("organization"), "member_profile") {
    def * = (id, firstName, lastName, avatarURL, enabled) <> (MemberProfileRow.tupled, MemberProfileRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(firstName), Rep.Some(lastName), Rep.Some(avatarURL), Rep.Some(enabled))).shaped.<>({r=>import r._; _1.map(_=> MemberProfileRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column firstName SqlType(varchar) */
    val firstName: Rep[String] = column[String]("firstName")
    /** Database column lastName SqlType(varchar) */
    val lastName: Rep[String] = column[String]("lastName")
    /** Database column avatarURL SqlType(varchar) */
    val avatarURL: Rep[String] = column[String]("avatarURL")
    /** Database column enabled SqlType(bool) */
    val enabled: Rep[Boolean] = column[Boolean]("enabled")
  }
  /** Collection-like TableQuery object for table MemberProfile */
  lazy val MemberProfile = new TableQuery(tag => new MemberProfileTable(tag))

  /** Entity class storing rows of table MindMap
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param published Database column published SqlType(bool), Default(false)
   *  @param icon Database column icon SqlType(varchar), Length(255,true)
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param name Database column name SqlType(varchar), Length(255,true)
   *  @param mode Database column mode SqlType(varchar), Length(12,true)
   *  @param description Database column description SqlType(text), Default(None)
   *  @param cost Database column cost SqlType(float8), Default(None)
   *  @param originMapID Database column originMapID SqlType(uuid), Default(None)
   *  @param releaseVersion Database column releaseVersion SqlType(float8), Default(Some(0.0)) */
  case class MindMapRow(id: java.util.UUID, published: Boolean = false, icon: Option[String], orgID: java.util.UUID, name: String, mode: String, description: Option[String] = None, cost: Option[Double] = None, originMapID: Option[java.util.UUID] = None, releaseVersion: Option[Double] = Some(0.0)) extends BaseEntity
  /** GetResult implicit for fetching MindMapRow objects using plain SQL queries */
  implicit def GetResultMindMapRow(implicit e0: GR[java.util.UUID], e1: GR[Boolean], e2: GR[Option[String]], e3: GR[String], e4: GR[Option[Double]], e5: GR[Option[java.util.UUID]]): GR[MindMapRow] = GR{
    prs => import prs._
    MindMapRow.tupled((<<[java.util.UUID], <<[Boolean], <<?[String], <<[java.util.UUID], <<[String], <<[String], <<?[String], <<?[Double], <<?[java.util.UUID], <<?[Double]))
  }
  /** Table description of table mind_map. Objects of this class serve as prototypes for rows in queries. */
  class MindMapTable(_tableTag: Tag) extends BaseTable[MindMapRow](_tableTag, Some("mind_map"), "mind_map") {
    def * = (id, published, icon, orgID, name, mode, description, cost, originMapID, releaseVersion) <> (MindMapRow.tupled, MindMapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(published), icon, Rep.Some(orgID), Rep.Some(name), Rep.Some(mode), description, cost, originMapID, releaseVersion)).shaped.<>({r=>import r._; _1.map(_=> MindMapRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column published SqlType(bool), Default(false) */
    val published: Rep[Boolean] = column[Boolean]("published", O.Default(false))
    /** Database column icon SqlType(varchar), Length(255,true) */
    val icon: Rep[Option[String]] = column[Option[String]]("icon", O.Length(255,varying=true))
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column name SqlType(varchar), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column mode SqlType(varchar), Length(12,true) */
    val mode: Rep[String] = column[String]("mode", O.Length(12,varying=true))
    /** Database column description SqlType(text), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column cost SqlType(float8), Default(None) */
    val cost: Rep[Option[Double]] = column[Option[Double]]("cost", O.Default(None))
    /** Database column originMapID SqlType(uuid), Default(None) */
    val originMapID: Rep[Option[java.util.UUID]] = column[Option[java.util.UUID]]("originMapID", O.Default(None))
    /** Database column releaseVersion SqlType(float8), Default(Some(0.0)) */
    val releaseVersion: Rep[Option[Double]] = column[Option[Double]]("releaseVersion", O.Default(Some(0.0)))

    /** Foreign key referencing MindMap (database name mind_map_originMapID_fkey) */
    lazy val mindMapTableFk = foreignKey("mind_map_originMapID_fkey", originMapID, MindMap)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing OrgProfile (database name mind_map_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("mind_map_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table MindMap */
  lazy val MindMap = new TableQuery(tag => new MindMapTable(tag))

  /** Entity class storing rows of table NodeAttributes
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param nodeID Database column nodeID SqlType(uuid)
   *  @param profileID Database column profileID SqlType(uuid)
   *  @param collapsed Database column collapsed SqlType(bool), Default(false) */
  case class NodeAttributesRow(id: java.util.UUID, nodeID: java.util.UUID, profileID: java.util.UUID, collapsed: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching NodeAttributesRow objects using plain SQL queries */
  implicit def GetResultNodeAttributesRow(implicit e0: GR[java.util.UUID], e1: GR[Boolean]): GR[NodeAttributesRow] = GR{
    prs => import prs._
    NodeAttributesRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID], <<[Boolean]))
  }
  /** Table description of table node_attributes. Objects of this class serve as prototypes for rows in queries. */
  class NodeAttributesTable(_tableTag: Tag) extends BaseTable[NodeAttributesRow](_tableTag, Some("mind_map"), "node_attributes") {
    def * = (id, nodeID, profileID, collapsed) <> (NodeAttributesRow.tupled, NodeAttributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(nodeID), Rep.Some(profileID), Rep.Some(collapsed))).shaped.<>({r=>import r._; _1.map(_=> NodeAttributesRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column nodeID SqlType(uuid) */
    val nodeID: Rep[java.util.UUID] = column[java.util.UUID]("nodeID")
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")
    /** Database column collapsed SqlType(bool), Default(false) */
    val collapsed: Rep[Boolean] = column[Boolean]("collapsed", O.Default(false))

    /** Foreign key referencing MemberProfile (database name node_attributes_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("node_attributes_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Node (database name node_attributes_nodeID_fkey) */
    lazy val nodeTableFk = foreignKey("node_attributes_nodeID_fkey", nodeID, Node)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table NodeAttributes */
  lazy val NodeAttributes = new TableQuery(tag => new NodeAttributesTable(tag))

  /** Entity class storing rows of table Node
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param nodeNumber Database column nodeNumber SqlType(int2)
   *  @param parentID Database column parentID SqlType(uuid), Default(None)
   *  @param mapID Database column mapID SqlType(uuid)
   *  @param segmentID Database column segmentID SqlType(uuid)
   *  @param path Database column path SqlType(text)
   *  @param order Database column order SqlType(float8)
   *  @param name Database column name SqlType(varchar), Length(255,true)
   *  @param `type` Database column type SqlType(varchar), Length(40,true)
   *  @param root Database column root SqlType(int2), Default(None)
   *  @param disabled Database column disabled SqlType(bool), Default(false)
   *  @param publishedID Database column publishedID SqlType(uuid), Default(None) */
  case class NodeRow(id: java.util.UUID, nodeNumber: Short, parentID: Option[java.util.UUID] = None, mapID: java.util.UUID, segmentID: java.util.UUID, path: String, order: Double, name: String, `type`: String, root: Option[Short] = None, disabled: Boolean = false, publishedID: Option[java.util.UUID] = None) extends BaseEntity
  /** GetResult implicit for fetching NodeRow objects using plain SQL queries */
  implicit def GetResultNodeRow(implicit e0: GR[java.util.UUID], e1: GR[Short], e2: GR[Option[java.util.UUID]], e3: GR[String], e4: GR[Double], e5: GR[Option[Short]], e6: GR[Boolean]): GR[NodeRow] = GR{
    prs => import prs._
    NodeRow.tupled((<<[java.util.UUID], <<[Short], <<?[java.util.UUID], <<[java.util.UUID], <<[java.util.UUID], <<[String], <<[Double], <<[String], <<[String], <<?[Short], <<[Boolean], <<?[java.util.UUID]))
  }
  /** Table description of table node. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class NodeTable(_tableTag: Tag) extends BaseTable[NodeRow](_tableTag, Some("mind_map"), "node") {
    def * = (id, nodeNumber, parentID, mapID, segmentID, path, order, name, `type`, root, disabled, publishedID) <> (NodeRow.tupled, NodeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(nodeNumber), parentID, Rep.Some(mapID), Rep.Some(segmentID), Rep.Some(path), Rep.Some(order), Rep.Some(name), Rep.Some(`type`), root, Rep.Some(disabled), publishedID)).shaped.<>({r=>import r._; _1.map(_=> NodeRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10, _11.get, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column nodeNumber SqlType(int2) */
    val nodeNumber: Rep[Short] = column[Short]("nodeNumber")
    /** Database column parentID SqlType(uuid), Default(None) */
    val parentID: Rep[Option[java.util.UUID]] = column[Option[java.util.UUID]]("parentID", O.Default(None))
    /** Database column mapID SqlType(uuid) */
    val mapID: Rep[java.util.UUID] = column[java.util.UUID]("mapID")
    /** Database column segmentID SqlType(uuid) */
    val segmentID: Rep[java.util.UUID] = column[java.util.UUID]("segmentID")
    /** Database column path SqlType(text) */
    val path: Rep[String] = column[String]("path")
    /** Database column order SqlType(float8) */
    val order: Rep[Double] = column[Double]("order")
    /** Database column name SqlType(varchar), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column type SqlType(varchar), Length(40,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(40,varying=true))
    /** Database column root SqlType(int2), Default(None) */
    val root: Rep[Option[Short]] = column[Option[Short]]("root", O.Default(None))
    /** Database column disabled SqlType(bool), Default(false) */
    val disabled: Rep[Boolean] = column[Boolean]("disabled", O.Default(false))
    /** Database column publishedID SqlType(uuid), Default(None) */
    val publishedID: Rep[Option[java.util.UUID]] = column[Option[java.util.UUID]]("publishedID", O.Default(None))

    /** Foreign key referencing MindMap (database name node_mapID_fkey) */
    lazy val mindMapTableFk = foreignKey("node_mapID_fkey", mapID, MindMap)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Node (database name node_parentID_fkey) */
    lazy val nodeTableFk2 = foreignKey("node_parentID_fkey", parentID, Node)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Node (database name node_publishedID_fkey) */
    lazy val nodeTableFk3 = foreignKey("node_publishedID_fkey", publishedID, Node)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (segmentID,nodeNumber) (database name map_nodenumber) */
    val index1 = index("map_nodenumber", (segmentID, nodeNumber), unique=true)
    /** Uniqueness Index over (parentID,order) (database name parent_order) */
    val index2 = index("parent_order", (parentID, order), unique=true)
    /** Index over (root) (database name root_node) */
    val index3 = index("root_node", root)
    /** Uniqueness Index over (parentID,name) (database name title_parent) */
    val index4 = index("title_parent", (parentID, name), unique=true)
    /** Index over (segmentID) (database name top_map_id) */
    val index5 = index("top_map_id", segmentID)
  }
  /** Collection-like TableQuery object for table Node */
  lazy val Node = new TableQuery(tag => new NodeTable(tag))

  /** Entity class storing rows of table OrgProfile
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param name Database column name SqlType(varchar)
   *  @param domain Database column domain SqlType(varchar)
   *  @param familyPlan Database column familyPlan SqlType(bool), Default(false) */
  case class OrgProfileRow(id: java.util.UUID, name: String, domain: String, familyPlan: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching OrgProfileRow objects using plain SQL queries */
  implicit def GetResultOrgProfileRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[OrgProfileRow] = GR{
    prs => import prs._
    OrgProfileRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table org_profile. Objects of this class serve as prototypes for rows in queries. */
  class OrgProfileTable(_tableTag: Tag) extends BaseTable[OrgProfileRow](_tableTag, Some("organization"), "org_profile") {
    def * = (id, name, domain, familyPlan) <> (OrgProfileRow.tupled, OrgProfileRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(name), Rep.Some(domain), Rep.Some(familyPlan))).shaped.<>({r=>import r._; _1.map(_=> OrgProfileRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column domain SqlType(varchar) */
    val domain: Rep[String] = column[String]("domain")
    /** Database column familyPlan SqlType(bool), Default(false) */
    val familyPlan: Rep[Boolean] = column[Boolean]("familyPlan", O.Default(false))

    /** Uniqueness Index over (domain) (database name org_profile_domain_key) */
    val index1 = index("org_profile_domain_key", domain, unique=true)
    /** Uniqueness Index over (name) (database name org_profile_name_key) */
    val index2 = index("org_profile_name_key", name, unique=true)
  }
  /** Collection-like TableQuery object for table OrgProfile */
  lazy val OrgProfile = new TableQuery(tag => new OrgProfileTable(tag))

  /** Entity class storing rows of table PostRead
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param profileID Database column profileID SqlType(uuid)
   *  @param timeRead Database column timeRead SqlType(int8) */
  case class PostReadRow(id: java.util.UUID, profileID: java.util.UUID, timeRead: Long) extends BaseEntity
  /** GetResult implicit for fetching PostReadRow objects using plain SQL queries */
  implicit def GetResultPostReadRow(implicit e0: GR[java.util.UUID], e1: GR[Long]): GR[PostReadRow] = GR{
    prs => import prs._
    PostReadRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[Long]))
  }
  /** Table description of table post_read. Objects of this class serve as prototypes for rows in queries. */
  class PostReadTable(_tableTag: Tag) extends BaseTable[PostReadRow](_tableTag, Some("mind_map"), "post_read") {
    def * = (id, profileID, timeRead) <> (PostReadRow.tupled, PostReadRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(profileID), Rep.Some(timeRead))).shaped.<>({r=>import r._; _1.map(_=> PostReadRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column profileID SqlType(uuid) */
    val profileID: Rep[java.util.UUID] = column[java.util.UUID]("profileID")
    /** Database column timeRead SqlType(int8) */
    val timeRead: Rep[Long] = column[Long]("timeRead")

    /** Foreign key referencing MemberProfile (database name post_read_profileID_fkey) */
    lazy val memberProfileTableFk = foreignKey("post_read_profileID_fkey", profileID, MemberProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Post (database name post_read_id_fkey) */
    lazy val postTableFk = foreignKey("post_read_id_fkey", id, Post)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table PostRead */
  lazy val PostRead = new TableQuery(tag => new PostReadTable(tag))

  /** Entity class storing rows of table Post
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param mapID Database column mapID SqlType(uuid)
   *  @param markdown Database column markdown SqlType(text)
   *  @param html Database column html SqlType(text) */
  case class PostRow(id: java.util.UUID, mapID: java.util.UUID, markdown: String, html: String) extends BaseEntity
  /** GetResult implicit for fetching PostRow objects using plain SQL queries */
  implicit def GetResultPostRow(implicit e0: GR[java.util.UUID], e1: GR[String]): GR[PostRow] = GR{
    prs => import prs._
    PostRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[String]))
  }
  /** Table description of table post. Objects of this class serve as prototypes for rows in queries. */
  class PostTable(_tableTag: Tag) extends BaseTable[PostRow](_tableTag, Some("mind_map"), "post") {
    def * = (id, mapID, markdown, html) <> (PostRow.tupled, PostRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(mapID), Rep.Some(markdown), Rep.Some(html))).shaped.<>({r=>import r._; _1.map(_=> PostRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column mapID SqlType(uuid) */
    val mapID: Rep[java.util.UUID] = column[java.util.UUID]("mapID")
    /** Database column markdown SqlType(text) */
    val markdown: Rep[String] = column[String]("markdown")
    /** Database column html SqlType(text) */
    val html: Rep[String] = column[String]("html")

    /** Foreign key referencing MindMap (database name post_mapID_fkey) */
    lazy val mindMapTableFk = foreignKey("post_mapID_fkey", mapID, MindMap)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Node (database name post_id_fkey) */
    lazy val nodeTableFk = foreignKey("post_id_fkey", id, Node)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Post */
  lazy val Post = new TableQuery(tag => new PostTable(tag))

  /** Entity class storing rows of table RoleInvite
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param roleID Database column roleID SqlType(uuid)
   *  @param mapRightsID Database column mapRightsID SqlType(uuid), Default(None)
   *  @param expires Database column expires SqlType(int8) */
  case class RoleInviteRow(id: java.util.UUID, roleID: java.util.UUID, mapRightsID: Option[java.util.UUID] = None, expires: Long) extends BaseEntity
  /** GetResult implicit for fetching RoleInviteRow objects using plain SQL queries */
  implicit def GetResultRoleInviteRow(implicit e0: GR[java.util.UUID], e1: GR[Option[java.util.UUID]], e2: GR[Long]): GR[RoleInviteRow] = GR{
    prs => import prs._
    RoleInviteRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<?[java.util.UUID], <<[Long]))
  }
  /** Table description of table role_invite. Objects of this class serve as prototypes for rows in queries. */
  class RoleInviteTable(_tableTag: Tag) extends BaseTable[RoleInviteRow](_tableTag, Some("organization"), "role_invite") {
    def * = (id, roleID, mapRightsID, expires) <> (RoleInviteRow.tupled, RoleInviteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(roleID), mapRightsID, Rep.Some(expires))).shaped.<>({r=>import r._; _1.map(_=> RoleInviteRow.tupled((_1.get, _2.get, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column roleID SqlType(uuid) */
    val roleID: Rep[java.util.UUID] = column[java.util.UUID]("roleID")
    /** Database column mapRightsID SqlType(uuid), Default(None) */
    val mapRightsID: Rep[Option[java.util.UUID]] = column[Option[java.util.UUID]]("mapRightsID", O.Default(None))
    /** Database column expires SqlType(int8) */
    val expires: Rep[Long] = column[Long]("expires")

    /** Foreign key referencing MapRights (database name role_invite_mapRightsID_fkey) */
    lazy val mapRightsTableFk = foreignKey("role_invite_mapRightsID_fkey", mapRightsID, MapRights)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing Role (database name role_invite_roleID_fkey) */
    lazy val roleTableFk = foreignKey("role_invite_roleID_fkey", roleID, Role)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table RoleInvite */
  lazy val RoleInvite = new TableQuery(tag => new RoleInviteTable(tag))

  /** Entity class storing rows of table Role
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param roleName Database column roleName SqlType(varchar)
   *  @param autoJoin Database column autoJoin SqlType(bool), Default(false)
   *  @param blogApprove Database column blogApprove SqlType(bool), Default(false)
   *  @param blogCreate Database column blogCreate SqlType(bool), Default(false)
   *  @param blogDelete Database column blogDelete SqlType(bool), Default(false)
   *  @param blogPublish Database column blogPublish SqlType(bool), Default(false)
   *  @param manageBlog Database column manageBlog SqlType(bool), Default(false)
   *  @param manageContests Database column manageContests SqlType(bool), Default(false)
   *  @param manageMarketingCampaigns Database column manageMarketingCampaigns SqlType(bool), Default(false)
   *  @param manageOrganizationBilling Database column manageOrganizationBilling SqlType(bool), Default(false)
   *  @param manageOrganizationConfig Database column manageOrganizationConfig SqlType(bool), Default(false)
   *  @param manageOrganizationMembers Database column manageOrganizationMembers SqlType(bool), Default(false)
   *  @param manageOrganizationPermissions Database column manageOrganizationPermissions SqlType(bool), Default(false)
   *  @param manageOrganizationWhitelabel Database column manageOrganizationWhitelabel SqlType(bool), Default(false)
   *  @param manageRewardsProgram Database column manageRewardsProgram SqlType(bool), Default(false)
   *  @param manageSalesAds Database column manageSalesAds SqlType(bool), Default(false)
   *  @param manageSalesCertificates Database column manageSalesCertificates SqlType(bool), Default(false)
   *  @param manageSalesCourses Database column manageSalesCourses SqlType(bool), Default(false)
   *  @param manageSalesMemberships Database column manageSalesMemberships SqlType(bool), Default(false)
   *  @param manageSalesOrganizations Database column manageSalesOrganizations SqlType(bool), Default(false)
   *  @param manageTrainingBreakTime Database column manageTrainingBreakTime SqlType(bool), Default(false)
   *  @param manageTrainingComplianceEnforcement Database column manageTrainingComplianceEnforcement SqlType(bool), Default(false)
   *  @param manageTrainingQuotes Database column manageTrainingQuotes SqlType(bool), Default(false)
   *  @param manageTrainingSessionSettings Database column manageTrainingSessionSettings SqlType(bool), Default(false)
   *  @param manageProblemBoard Database column manageProblemBoard SqlType(bool), Default(false)
   *  @param mapApprove Database column mapApprove SqlType(bool), Default(false)
   *  @param mapCreate Database column mapCreate SqlType(bool), Default(false)
   *  @param mapCreateDocuments Database column mapCreateDocuments SqlType(bool), Default(false)
   *  @param mapDirectory Database column mapDirectory SqlType(bool), Default(false)
   *  @param mapFeedback Database column mapFeedback SqlType(bool), Default(false)
   *  @param mapFork Database column mapFork SqlType(bool), Default(false)
   *  @param mapMnemonics Database column mapMnemonics SqlType(bool), Default(false)
   *  @param mapModify Database column mapModify SqlType(bool), Default(false)
   *  @param mapPermissions Database column mapPermissions SqlType(bool), Default(false)
   *  @param mapPublish Database column mapPublish SqlType(bool), Default(false)
   *  @param mapShare Database column mapShare SqlType(bool), Default(false)
   *  @param mapStats Database column mapStats SqlType(bool), Default(false)
   *  @param mapTraining Database column mapTraining SqlType(bool), Default(false)
   *  @param mapTransfer Database column mapTransfer SqlType(bool), Default(false)
   *  @param mapView Database column mapView SqlType(bool), Default(false)
   *  @param organizationInvite Database column organizationInvite SqlType(bool), Default(false)
   *  @param organizationPublish Database column organizationPublish SqlType(bool), Default(false)
   *  @param trainingRankings Database column trainingRankings SqlType(bool), Default(false)
   *  @param trainingReporting Database column trainingReporting SqlType(bool), Default(false) */
  case class RoleRow(id: java.util.UUID, orgID: java.util.UUID, roleName: String, autoJoin: Boolean = false, blogApprove: Boolean = false, blogCreate: Boolean = false, blogDelete: Boolean = false, blogPublish: Boolean = false, manageBlog: Boolean = false, manageContests: Boolean = false, manageMarketingCampaigns: Boolean = false, manageOrganizationBilling: Boolean = false, manageOrganizationConfig: Boolean = false, manageOrganizationMembers: Boolean = false, manageOrganizationPermissions: Boolean = false, manageOrganizationWhitelabel: Boolean = false, manageRewardsProgram: Boolean = false, manageSalesAds: Boolean = false, manageSalesCertificates: Boolean = false, manageSalesCourses: Boolean = false, manageSalesMemberships: Boolean = false, manageSalesOrganizations: Boolean = false, manageTrainingBreakTime: Boolean = false, manageTrainingComplianceEnforcement: Boolean = false, manageTrainingQuotes: Boolean = false, manageTrainingSessionSettings: Boolean = false, manageProblemBoard: Boolean = false, mapApprove: Boolean = false, mapCreate: Boolean = false, mapCreateDocuments: Boolean = false, mapDirectory: Boolean = false, mapFeedback: Boolean = false, mapFork: Boolean = false, mapMnemonics: Boolean = false, mapModify: Boolean = false, mapPermissions: Boolean = false, mapPublish: Boolean = false, mapShare: Boolean = false, mapStats: Boolean = false, mapTraining: Boolean = false, mapTransfer: Boolean = false, mapView: Boolean = false, organizationInvite: Boolean = false, organizationPublish: Boolean = false, trainingRankings: Boolean = false, trainingReporting: Boolean = false) extends BaseEntity
  /** GetResult implicit for fetching RoleRow objects using plain SQL queries */
  implicit def GetResultRoleRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[RoleRow] = GR{
    prs => import prs._
    RoleRow(<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean], <<[Boolean])
  }
  /** Table description of table role. Objects of this class serve as prototypes for rows in queries. */
  class RoleTable(_tableTag: Tag) extends BaseTable[RoleRow](_tableTag, Some("organization"), "role") {
    def * = (id :: orgID :: roleName :: autoJoin :: blogApprove :: blogCreate :: blogDelete :: blogPublish :: manageBlog :: manageContests :: manageMarketingCampaigns :: manageOrganizationBilling :: manageOrganizationConfig :: manageOrganizationMembers :: manageOrganizationPermissions :: manageOrganizationWhitelabel :: manageRewardsProgram :: manageSalesAds :: manageSalesCertificates :: manageSalesCourses :: manageSalesMemberships :: manageSalesOrganizations :: manageTrainingBreakTime :: manageTrainingComplianceEnforcement :: manageTrainingQuotes :: manageTrainingSessionSettings :: manageProblemBoard :: mapApprove :: mapCreate :: mapCreateDocuments :: mapDirectory :: mapFeedback :: mapFork :: mapMnemonics :: mapModify :: mapPermissions :: mapPublish :: mapShare :: mapStats :: mapTraining :: mapTransfer :: mapView :: organizationInvite :: organizationPublish :: trainingRankings :: trainingReporting :: HNil).mapTo[RoleRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id) :: Rep.Some(orgID) :: Rep.Some(roleName) :: Rep.Some(autoJoin) :: Rep.Some(blogApprove) :: Rep.Some(blogCreate) :: Rep.Some(blogDelete) :: Rep.Some(blogPublish) :: Rep.Some(manageBlog) :: Rep.Some(manageContests) :: Rep.Some(manageMarketingCampaigns) :: Rep.Some(manageOrganizationBilling) :: Rep.Some(manageOrganizationConfig) :: Rep.Some(manageOrganizationMembers) :: Rep.Some(manageOrganizationPermissions) :: Rep.Some(manageOrganizationWhitelabel) :: Rep.Some(manageRewardsProgram) :: Rep.Some(manageSalesAds) :: Rep.Some(manageSalesCertificates) :: Rep.Some(manageSalesCourses) :: Rep.Some(manageSalesMemberships) :: Rep.Some(manageSalesOrganizations) :: Rep.Some(manageTrainingBreakTime) :: Rep.Some(manageTrainingComplianceEnforcement) :: Rep.Some(manageTrainingQuotes) :: Rep.Some(manageTrainingSessionSettings) :: Rep.Some(manageProblemBoard) :: Rep.Some(mapApprove) :: Rep.Some(mapCreate) :: Rep.Some(mapCreateDocuments) :: Rep.Some(mapDirectory) :: Rep.Some(mapFeedback) :: Rep.Some(mapFork) :: Rep.Some(mapMnemonics) :: Rep.Some(mapModify) :: Rep.Some(mapPermissions) :: Rep.Some(mapPublish) :: Rep.Some(mapShare) :: Rep.Some(mapStats) :: Rep.Some(mapTraining) :: Rep.Some(mapTransfer) :: Rep.Some(mapView) :: Rep.Some(organizationInvite) :: Rep.Some(organizationPublish) :: Rep.Some(trainingRankings) :: Rep.Some(trainingReporting) :: HNil).shaped.<>(r => RoleRow(r(0).asInstanceOf[Option[java.util.UUID]].get, r(1).asInstanceOf[Option[java.util.UUID]].get, r(2).asInstanceOf[Option[String]].get, r(3).asInstanceOf[Option[Boolean]].get, r(4).asInstanceOf[Option[Boolean]].get, r(5).asInstanceOf[Option[Boolean]].get, r(6).asInstanceOf[Option[Boolean]].get, r(7).asInstanceOf[Option[Boolean]].get, r(8).asInstanceOf[Option[Boolean]].get, r(9).asInstanceOf[Option[Boolean]].get, r(10).asInstanceOf[Option[Boolean]].get, r(11).asInstanceOf[Option[Boolean]].get, r(12).asInstanceOf[Option[Boolean]].get, r(13).asInstanceOf[Option[Boolean]].get, r(14).asInstanceOf[Option[Boolean]].get, r(15).asInstanceOf[Option[Boolean]].get, r(16).asInstanceOf[Option[Boolean]].get, r(17).asInstanceOf[Option[Boolean]].get, r(18).asInstanceOf[Option[Boolean]].get, r(19).asInstanceOf[Option[Boolean]].get, r(20).asInstanceOf[Option[Boolean]].get, r(21).asInstanceOf[Option[Boolean]].get, r(22).asInstanceOf[Option[Boolean]].get, r(23).asInstanceOf[Option[Boolean]].get, r(24).asInstanceOf[Option[Boolean]].get, r(25).asInstanceOf[Option[Boolean]].get, r(26).asInstanceOf[Option[Boolean]].get, r(27).asInstanceOf[Option[Boolean]].get, r(28).asInstanceOf[Option[Boolean]].get, r(29).asInstanceOf[Option[Boolean]].get, r(30).asInstanceOf[Option[Boolean]].get, r(31).asInstanceOf[Option[Boolean]].get, r(32).asInstanceOf[Option[Boolean]].get, r(33).asInstanceOf[Option[Boolean]].get, r(34).asInstanceOf[Option[Boolean]].get, r(35).asInstanceOf[Option[Boolean]].get, r(36).asInstanceOf[Option[Boolean]].get, r(37).asInstanceOf[Option[Boolean]].get, r(38).asInstanceOf[Option[Boolean]].get, r(39).asInstanceOf[Option[Boolean]].get, r(40).asInstanceOf[Option[Boolean]].get, r(41).asInstanceOf[Option[Boolean]].get, r(42).asInstanceOf[Option[Boolean]].get, r(43).asInstanceOf[Option[Boolean]].get, r(44).asInstanceOf[Option[Boolean]].get, r(45).asInstanceOf[Option[Boolean]].get), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column roleName SqlType(varchar) */
    val roleName: Rep[String] = column[String]("roleName")
    /** Database column autoJoin SqlType(bool), Default(false) */
    val autoJoin: Rep[Boolean] = column[Boolean]("autoJoin", O.Default(false))
    /** Database column blogApprove SqlType(bool), Default(false) */
    val blogApprove: Rep[Boolean] = column[Boolean]("blogApprove", O.Default(false))
    /** Database column blogCreate SqlType(bool), Default(false) */
    val blogCreate: Rep[Boolean] = column[Boolean]("blogCreate", O.Default(false))
    /** Database column blogDelete SqlType(bool), Default(false) */
    val blogDelete: Rep[Boolean] = column[Boolean]("blogDelete", O.Default(false))
    /** Database column blogPublish SqlType(bool), Default(false) */
    val blogPublish: Rep[Boolean] = column[Boolean]("blogPublish", O.Default(false))
    /** Database column manageBlog SqlType(bool), Default(false) */
    val manageBlog: Rep[Boolean] = column[Boolean]("manageBlog", O.Default(false))
    /** Database column manageContests SqlType(bool), Default(false) */
    val manageContests: Rep[Boolean] = column[Boolean]("manageContests", O.Default(false))
    /** Database column manageMarketingCampaigns SqlType(bool), Default(false) */
    val manageMarketingCampaigns: Rep[Boolean] = column[Boolean]("manageMarketingCampaigns", O.Default(false))
    /** Database column manageOrganizationBilling SqlType(bool), Default(false) */
    val manageOrganizationBilling: Rep[Boolean] = column[Boolean]("manageOrganizationBilling", O.Default(false))
    /** Database column manageOrganizationConfig SqlType(bool), Default(false) */
    val manageOrganizationConfig: Rep[Boolean] = column[Boolean]("manageOrganizationConfig", O.Default(false))
    /** Database column manageOrganizationMembers SqlType(bool), Default(false) */
    val manageOrganizationMembers: Rep[Boolean] = column[Boolean]("manageOrganizationMembers", O.Default(false))
    /** Database column manageOrganizationPermissions SqlType(bool), Default(false) */
    val manageOrganizationPermissions: Rep[Boolean] = column[Boolean]("manageOrganizationPermissions", O.Default(false))
    /** Database column manageOrganizationWhitelabel SqlType(bool), Default(false) */
    val manageOrganizationWhitelabel: Rep[Boolean] = column[Boolean]("manageOrganizationWhitelabel", O.Default(false))
    /** Database column manageRewardsProgram SqlType(bool), Default(false) */
    val manageRewardsProgram: Rep[Boolean] = column[Boolean]("manageRewardsProgram", O.Default(false))
    /** Database column manageSalesAds SqlType(bool), Default(false) */
    val manageSalesAds: Rep[Boolean] = column[Boolean]("manageSalesAds", O.Default(false))
    /** Database column manageSalesCertificates SqlType(bool), Default(false) */
    val manageSalesCertificates: Rep[Boolean] = column[Boolean]("manageSalesCertificates", O.Default(false))
    /** Database column manageSalesCourses SqlType(bool), Default(false) */
    val manageSalesCourses: Rep[Boolean] = column[Boolean]("manageSalesCourses", O.Default(false))
    /** Database column manageSalesMemberships SqlType(bool), Default(false) */
    val manageSalesMemberships: Rep[Boolean] = column[Boolean]("manageSalesMemberships", O.Default(false))
    /** Database column manageSalesOrganizations SqlType(bool), Default(false) */
    val manageSalesOrganizations: Rep[Boolean] = column[Boolean]("manageSalesOrganizations", O.Default(false))
    /** Database column manageTrainingBreakTime SqlType(bool), Default(false) */
    val manageTrainingBreakTime: Rep[Boolean] = column[Boolean]("manageTrainingBreakTime", O.Default(false))
    /** Database column manageTrainingComplianceEnforcement SqlType(bool), Default(false) */
    val manageTrainingComplianceEnforcement: Rep[Boolean] = column[Boolean]("manageTrainingComplianceEnforcement", O.Default(false))
    /** Database column manageTrainingQuotes SqlType(bool), Default(false) */
    val manageTrainingQuotes: Rep[Boolean] = column[Boolean]("manageTrainingQuotes", O.Default(false))
    /** Database column manageTrainingSessionSettings SqlType(bool), Default(false) */
    val manageTrainingSessionSettings: Rep[Boolean] = column[Boolean]("manageTrainingSessionSettings", O.Default(false))
    /** Database column manageProblemBoard SqlType(bool), Default(false) */
    val manageProblemBoard: Rep[Boolean] = column[Boolean]("manageProblemBoard", O.Default(false))
    /** Database column mapApprove SqlType(bool), Default(false) */
    val mapApprove: Rep[Boolean] = column[Boolean]("mapApprove", O.Default(false))
    /** Database column mapCreate SqlType(bool), Default(false) */
    val mapCreate: Rep[Boolean] = column[Boolean]("mapCreate", O.Default(false))
    /** Database column mapCreateDocuments SqlType(bool), Default(false) */
    val mapCreateDocuments: Rep[Boolean] = column[Boolean]("mapCreateDocuments", O.Default(false))
    /** Database column mapDirectory SqlType(bool), Default(false) */
    val mapDirectory: Rep[Boolean] = column[Boolean]("mapDirectory", O.Default(false))
    /** Database column mapFeedback SqlType(bool), Default(false) */
    val mapFeedback: Rep[Boolean] = column[Boolean]("mapFeedback", O.Default(false))
    /** Database column mapFork SqlType(bool), Default(false) */
    val mapFork: Rep[Boolean] = column[Boolean]("mapFork", O.Default(false))
    /** Database column mapMnemonics SqlType(bool), Default(false) */
    val mapMnemonics: Rep[Boolean] = column[Boolean]("mapMnemonics", O.Default(false))
    /** Database column mapModify SqlType(bool), Default(false) */
    val mapModify: Rep[Boolean] = column[Boolean]("mapModify", O.Default(false))
    /** Database column mapPermissions SqlType(bool), Default(false) */
    val mapPermissions: Rep[Boolean] = column[Boolean]("mapPermissions", O.Default(false))
    /** Database column mapPublish SqlType(bool), Default(false) */
    val mapPublish: Rep[Boolean] = column[Boolean]("mapPublish", O.Default(false))
    /** Database column mapShare SqlType(bool), Default(false) */
    val mapShare: Rep[Boolean] = column[Boolean]("mapShare", O.Default(false))
    /** Database column mapStats SqlType(bool), Default(false) */
    val mapStats: Rep[Boolean] = column[Boolean]("mapStats", O.Default(false))
    /** Database column mapTraining SqlType(bool), Default(false) */
    val mapTraining: Rep[Boolean] = column[Boolean]("mapTraining", O.Default(false))
    /** Database column mapTransfer SqlType(bool), Default(false) */
    val mapTransfer: Rep[Boolean] = column[Boolean]("mapTransfer", O.Default(false))
    /** Database column mapView SqlType(bool), Default(false) */
    val mapView: Rep[Boolean] = column[Boolean]("mapView", O.Default(false))
    /** Database column organizationInvite SqlType(bool), Default(false) */
    val organizationInvite: Rep[Boolean] = column[Boolean]("organizationInvite", O.Default(false))
    /** Database column organizationPublish SqlType(bool), Default(false) */
    val organizationPublish: Rep[Boolean] = column[Boolean]("organizationPublish", O.Default(false))
    /** Database column trainingRankings SqlType(bool), Default(false) */
    val trainingRankings: Rep[Boolean] = column[Boolean]("trainingRankings", O.Default(false))
    /** Database column trainingReporting SqlType(bool), Default(false) */
    val trainingReporting: Rep[Boolean] = column[Boolean]("trainingReporting", O.Default(false))

    /** Foreign key referencing OrgProfile (database name role_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("role_orgID_fkey", orgID :: HNil, OrgProfile)(r => r.id :: HNil, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Role */
  lazy val Role = new TableQuery(tag => new RoleTable(tag))

  /** Entity class storing rows of table Site
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param orgID Database column orgID SqlType(uuid)
   *  @param domain Database column domain SqlType(varchar)
   *  @param theme Database column theme SqlType(varchar)
   *  @param ssl Database column ssl SqlType(bool), Default(false)
   *  @param name Database column name SqlType(varchar), Length(255,true), Default()
   *  @param description Database column description SqlType(text), Default()
   *  @param logo Database column logo SqlType(varchar), Length(255,true), Default()
   *  @param favicon Database column favicon SqlType(varchar), Length(255,true), Default() */
  case class SiteRow(id: java.util.UUID, orgID: java.util.UUID, domain: String, theme: String, ssl: Boolean = false, name: String = "", description: String = "", logo: String = "", favicon: String = "") extends BaseEntity
  /** GetResult implicit for fetching SiteRow objects using plain SQL queries */
  implicit def GetResultSiteRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean]): GR[SiteRow] = GR{
    prs => import prs._
    SiteRow.tupled((<<[java.util.UUID], <<[java.util.UUID], <<[String], <<[String], <<[Boolean], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table site. Objects of this class serve as prototypes for rows in queries. */
  class SiteTable(_tableTag: Tag) extends BaseTable[SiteRow](_tableTag, Some("websites"), "site") {
    def * = (id, orgID, domain, theme, ssl, name, description, logo, favicon) <> (SiteRow.tupled, SiteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(orgID), Rep.Some(domain), Rep.Some(theme), Rep.Some(ssl), Rep.Some(name), Rep.Some(description), Rep.Some(logo), Rep.Some(favicon))).shaped.<>({r=>import r._; _1.map(_=> SiteRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    override val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column orgID SqlType(uuid) */
    val orgID: Rep[java.util.UUID] = column[java.util.UUID]("orgID")
    /** Database column domain SqlType(varchar) */
    val domain: Rep[String] = column[String]("domain")
    /** Database column theme SqlType(varchar) */
    val theme: Rep[String] = column[String]("theme")
    /** Database column ssl SqlType(bool), Default(false) */
    val ssl: Rep[Boolean] = column[Boolean]("ssl", O.Default(false))
    /** Database column name SqlType(varchar), Length(255,true), Default() */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true), O.Default(""))
    /** Database column description SqlType(text), Default() */
    val description: Rep[String] = column[String]("description", O.Default(""))
    /** Database column logo SqlType(varchar), Length(255,true), Default() */
    val logo: Rep[String] = column[String]("logo", O.Length(255,varying=true), O.Default(""))
    /** Database column favicon SqlType(varchar), Length(255,true), Default() */
    val favicon: Rep[String] = column[String]("favicon", O.Length(255,varying=true), O.Default(""))

    /** Foreign key referencing OrgProfile (database name site_orgID_fkey) */
    lazy val orgProfileTableFk = foreignKey("site_orgID_fkey", orgID, OrgProfile)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (domain) (database name site_domain_key) */
    val index1 = index("site_domain_key", domain, unique=true)
    /** Uniqueness Index over (theme) (database name site_theme_key) */
    val index2 = index("site_theme_key", theme, unique=true)
  }
  /** Collection-like TableQuery object for table Site */
  lazy val Site = new TableQuery(tag => new SiteTable(tag))
}
