// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.io.masterypath.slick.{MapID, NodeID, ProfileID, MapRightsID, RoleID, RoleInviteID, OrgID, SegmentID}

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  MemberController_2: controllers.MemberController,
  // @LINE:10
  OrganizationController_0: controllers.OrganizationController,
  // @LINE:34
  MapController_1: controllers.MapController,
  // @LINE:72
  TrainController_3: controllers.TrainController,
  // @LINE:82
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    MemberController_2: controllers.MemberController,
    // @LINE:10
    OrganizationController_0: controllers.OrganizationController,
    // @LINE:34
    MapController_1: controllers.MapController,
    // @LINE:72
    TrainController_3: controllers.TrainController,
    // @LINE:82
    Assets_4: controllers.Assets
  ) = this(errorHandler, MemberController_2, OrganizationController_0, MapController_1, TrainController_3, Assets_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, MemberController_2, OrganizationController_0, MapController_1, TrainController_3, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/profile""", """controllers.MemberController.getProfile"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/linkAccount""", """controllers.MemberController.linkAccount"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/logSignIn""", """controllers.MemberController.logSignIn"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/register""", """controllers.MemberController.register"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/organizations""", """controllers.MemberController.getOrganizations"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """member/jwt/""" + "$" + """walletID<[^/]+>""", """controllers.MemberController.getJWT(walletID:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org""", """controllers.OrganizationController.createOrg"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog""", """controllers.OrganizationController.getBlog(orgID:OrgID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog""", """controllers.OrganizationController.createBlog(orgID:OrgID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog""", """controllers.OrganizationController.patchBlog(orgID:OrgID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog""", """controllers.OrganizationController.deleteBlog(orgID:OrgID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog/build""", """controllers.OrganizationController.buildBlog(orgID:OrgID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog/publish""", """controllers.OrganizationController.publishBlog(orgID:OrgID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/blog/logo""", """controllers.OrganizationController.uploadSiteLogo(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/config""", """controllers.OrganizationController.getConfig(orgID:OrgID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/config""", """controllers.OrganizationController.patchConfig(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/mypermissions""", """controllers.OrganizationController.getMyPermissions(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/members""", """controllers.OrganizationController.getOrgMembers(orgID:OrgID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""", """controllers.OrganizationController.removeOrgMember(orgID:OrgID, profileID:ProfileID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/roles""", """controllers.OrganizationController.getRoles(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/members""", """controllers.OrganizationController.getRoleMembers(orgID:OrgID, roleID:RoleID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role""", """controllers.OrganizationController.createRole(orgID:OrgID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>""", """controllers.OrganizationController.patchRole(orgID:OrgID, roleID:RoleID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>""", """controllers.OrganizationController.getRole(orgID:OrgID, roleID:RoleID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""", """controllers.OrganizationController.addRoleMember(orgID:OrgID, roleID:RoleID, profileID:ProfileID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""", """controllers.OrganizationController.removeRoleMember(orgID:OrgID, roleID:RoleID, profileID:ProfileID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/invite""", """controllers.OrganizationController.roleInvite(orgID:OrgID, roleID:RoleID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """invite/""" + "$" + """inviteID<[^/]+>/join""", """controllers.OrganizationController.join(inviteID:RoleInviteID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/mymaps""", """controllers.MapController.getMyMaps(orgID:OrgID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/mymaps""", """controllers.MapController.createMap(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/flashcardTypes""", """controllers.MapController.getFlashcardTypes(orgID:OrgID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/export""", """controllers.MapController.mapContentToJson(orgID:OrgID, mapID:MapID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/fork""", """controllers.MapController.forkMap(orgID:OrgID, mapID:MapID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/page""", """controllers.MapController.getMapAsBlogPage(orgID:OrgID, mapID:MapID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/publish""", """controllers.MapController.publishMap(orgID:OrgID, mapID:MapID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/settings""", """controllers.MapController.getMapSettings(orgID:OrgID, mapID:MapID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/settings""", """controllers.MapController.patchMapSettings(orgID:OrgID, mapID:MapID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/icon""", """controllers.MapController.uploadMapIcon(orgID:OrgID, mapID:MapID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/image""", """controllers.MapController.storeImageFile(orgID:OrgID, mapID:MapID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/card/validate""", """controllers.MapController.validateCard(orgID:OrgID, mapID:MapID, cardType:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/audio""", """controllers.MapController.storeAudioFile(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>""", """controllers.MapController.mapToJson(orgID:OrgID, mapID:MapID, segmentID:SegmentID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/breadcrumb""", """controllers.MapController.getBreadcrumb(orgID:OrgID, mapID:MapID, segmentID:SegmentID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node""", """controllers.MapController.createMapNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>""", """controllers.MapController.patchMapNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/attributes""", """controllers.MapController.patchMapNodeAttributes(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>""", """controllers.MapController.deleteNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/makeSubMap""", """controllers.MapController.convertNodeToSubMap(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""", """controllers.MapController.createCard(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID, cardType:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""", """controllers.MapController.getCardAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/cardType""", """controllers.MapController.getCardTypeAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""", """controllers.MapController.updateCard(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID, cardType:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""", """controllers.MapController.createOrUpdatePost(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""", """controllers.MapController.createOrUpdatePost(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""", """controllers.MapController.getPostAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""", """controllers.MapController.deletePost(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights""", """controllers.MapController.getMapRights(orgID:OrgID, mapID:MapID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights""", """controllers.MapController.createMapRights(orgID:OrgID, mapID:MapID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/invite""", """controllers.MapController.mapRightsInvite(orgID:OrgID, mapID:MapID, rightsID:MapRightsID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""", """controllers.MapController.getMapRightsByID(orgID:OrgID, mapID:MapID, rightsID:MapRightsID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""", """controllers.MapController.deleteMapRightsByID(orgID:OrgID, mapID:MapID, rightsID:MapRightsID)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""", """controllers.MapController.patchMapRights(orgID:OrgID, mapID:MapID, rightsID:MapRightsID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""", """controllers.MapController.addMapRightsMember(orgID:OrgID, mapID:MapID, rightsID:MapRightsID, profileID:ProfileID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""", """controllers.MapController.removeMapRightsMember(orgID:OrgID, mapID:MapID, rightsID:MapRightsID, profileID:ProfileID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/cards""", """controllers.TrainController.cardsToJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/postsReadTimes""", """controllers.TrainController.getPostsReadTimes(orgID:OrgID, mapID:MapID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/post/""" + "$" + """nodeID<[^/]+>""", """controllers.TrainController.getPostAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/post/""" + "$" + """nodeID<[^/]+>/markRead""", """controllers.TrainController.markPostRead(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/grade""", """controllers.TrainController.gradeCard(orgID:OrgID, mapID:MapID, nodeID:NodeID, cardType:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/quality""", """controllers.TrainController.submitCardQuality(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>""", """controllers.TrainController.getCardAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/cardType""", """controllers.TrainController.getCardTypeAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_MemberController_getProfile0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/profile")))
  )
  private[this] lazy val controllers_MemberController_getProfile0_invoker = createInvoker(
    MemberController_2.getProfile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "getProfile",
      Nil,
      "GET",
      this.prefix + """member/profile""",
      """ Members""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_MemberController_linkAccount1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/linkAccount")))
  )
  private[this] lazy val controllers_MemberController_linkAccount1_invoker = createInvoker(
    MemberController_2.linkAccount,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "linkAccount",
      Nil,
      "POST",
      this.prefix + """member/linkAccount""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_MemberController_logSignIn2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/logSignIn")))
  )
  private[this] lazy val controllers_MemberController_logSignIn2_invoker = createInvoker(
    MemberController_2.logSignIn,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "logSignIn",
      Nil,
      "POST",
      this.prefix + """member/logSignIn""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_MemberController_register3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/register")))
  )
  private[this] lazy val controllers_MemberController_register3_invoker = createInvoker(
    MemberController_2.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "register",
      Nil,
      "POST",
      this.prefix + """member/register""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_MemberController_getOrganizations4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/organizations")))
  )
  private[this] lazy val controllers_MemberController_getOrganizations4_invoker = createInvoker(
    MemberController_2.getOrganizations,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "getOrganizations",
      Nil,
      "GET",
      this.prefix + """member/organizations""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_MemberController_getJWT5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("member/jwt/"), DynamicPart("walletID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MemberController_getJWT5_invoker = createInvoker(
    MemberController_2.getJWT(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MemberController",
      "getJWT",
      Seq(classOf[String]),
      "GET",
      this.prefix + """member/jwt/""" + "$" + """walletID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_OrganizationController_createOrg6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org")))
  )
  private[this] lazy val controllers_OrganizationController_createOrg6_invoker = createInvoker(
    OrganizationController_0.createOrg,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "createOrg",
      Nil,
      "POST",
      this.prefix + """org""",
      """ Organizations""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_OrganizationController_getBlog7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog")))
  )
  private[this] lazy val controllers_OrganizationController_getBlog7_invoker = createInvoker(
    OrganizationController_0.getBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getBlog",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_OrganizationController_createBlog8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog")))
  )
  private[this] lazy val controllers_OrganizationController_createBlog8_invoker = createInvoker(
    OrganizationController_0.createBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "createBlog",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_OrganizationController_patchBlog9_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog")))
  )
  private[this] lazy val controllers_OrganizationController_patchBlog9_invoker = createInvoker(
    OrganizationController_0.patchBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "patchBlog",
      Seq(classOf[OrgID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_OrganizationController_deleteBlog10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog")))
  )
  private[this] lazy val controllers_OrganizationController_deleteBlog10_invoker = createInvoker(
    OrganizationController_0.deleteBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "deleteBlog",
      Seq(classOf[OrgID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_OrganizationController_buildBlog11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog/build")))
  )
  private[this] lazy val controllers_OrganizationController_buildBlog11_invoker = createInvoker(
    OrganizationController_0.buildBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "buildBlog",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog/build""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_OrganizationController_publishBlog12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog/publish")))
  )
  private[this] lazy val controllers_OrganizationController_publishBlog12_invoker = createInvoker(
    OrganizationController_0.publishBlog(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "publishBlog",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog/publish""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_OrganizationController_uploadSiteLogo13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/blog/logo")))
  )
  private[this] lazy val controllers_OrganizationController_uploadSiteLogo13_invoker = createInvoker(
    OrganizationController_0.uploadSiteLogo(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "uploadSiteLogo",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/blog/logo""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_OrganizationController_getConfig14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_OrganizationController_getConfig14_invoker = createInvoker(
    OrganizationController_0.getConfig(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getConfig",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_OrganizationController_patchConfig15_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_OrganizationController_patchConfig15_invoker = createInvoker(
    OrganizationController_0.patchConfig(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "patchConfig",
      Seq(classOf[OrgID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_OrganizationController_getMyPermissions16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/mypermissions")))
  )
  private[this] lazy val controllers_OrganizationController_getMyPermissions16_invoker = createInvoker(
    OrganizationController_0.getMyPermissions(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getMyPermissions",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/mypermissions""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_OrganizationController_getOrgMembers17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/members")))
  )
  private[this] lazy val controllers_OrganizationController_getOrgMembers17_invoker = createInvoker(
    OrganizationController_0.getOrgMembers(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getOrgMembers",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/members""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_OrganizationController_removeOrgMember18_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/member/"), DynamicPart("profileID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrganizationController_removeOrgMember18_invoker = createInvoker(
    OrganizationController_0.removeOrgMember(fakeValue[OrgID], fakeValue[ProfileID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "removeOrgMember",
      Seq(classOf[OrgID], classOf[ProfileID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_OrganizationController_getRoles19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/roles")))
  )
  private[this] lazy val controllers_OrganizationController_getRoles19_invoker = createInvoker(
    OrganizationController_0.getRoles(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getRoles",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/roles""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_OrganizationController_getRoleMembers20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true), StaticPart("/members")))
  )
  private[this] lazy val controllers_OrganizationController_getRoleMembers20_invoker = createInvoker(
    OrganizationController_0.getRoleMembers(fakeValue[OrgID], fakeValue[RoleID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getRoleMembers",
      Seq(classOf[OrgID], classOf[RoleID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/members""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_OrganizationController_createRole21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role")))
  )
  private[this] lazy val controllers_OrganizationController_createRole21_invoker = createInvoker(
    OrganizationController_0.createRole(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "createRole",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_OrganizationController_patchRole22_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrganizationController_patchRole22_invoker = createInvoker(
    OrganizationController_0.patchRole(fakeValue[OrgID], fakeValue[RoleID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "patchRole",
      Seq(classOf[OrgID], classOf[RoleID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_OrganizationController_getRole23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrganizationController_getRole23_invoker = createInvoker(
    OrganizationController_0.getRole(fakeValue[OrgID], fakeValue[RoleID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "getRole",
      Seq(classOf[OrgID], classOf[RoleID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_OrganizationController_addRoleMember24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true), StaticPart("/member/"), DynamicPart("profileID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrganizationController_addRoleMember24_invoker = createInvoker(
    OrganizationController_0.addRoleMember(fakeValue[OrgID], fakeValue[RoleID], fakeValue[ProfileID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "addRoleMember",
      Seq(classOf[OrgID], classOf[RoleID], classOf[ProfileID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_OrganizationController_removeRoleMember25_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true), StaticPart("/member/"), DynamicPart("profileID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrganizationController_removeRoleMember25_invoker = createInvoker(
    OrganizationController_0.removeRoleMember(fakeValue[OrgID], fakeValue[RoleID], fakeValue[ProfileID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "removeRoleMember",
      Seq(classOf[OrgID], classOf[RoleID], classOf[ProfileID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_OrganizationController_roleInvite26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/role/"), DynamicPart("roleID", """[^/]+""",true), StaticPart("/invite")))
  )
  private[this] lazy val controllers_OrganizationController_roleInvite26_invoker = createInvoker(
    OrganizationController_0.roleInvite(fakeValue[OrgID], fakeValue[RoleID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "roleInvite",
      Seq(classOf[OrgID], classOf[RoleID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/role/""" + "$" + """roleID<[^/]+>/invite""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_OrganizationController_join27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("invite/"), DynamicPart("inviteID", """[^/]+""",true), StaticPart("/join")))
  )
  private[this] lazy val controllers_OrganizationController_join27_invoker = createInvoker(
    OrganizationController_0.join(fakeValue[RoleInviteID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrganizationController",
      "join",
      Seq(classOf[RoleInviteID]),
      "POST",
      this.prefix + """invite/""" + "$" + """inviteID<[^/]+>/join""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_MapController_getMyMaps28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/mymaps")))
  )
  private[this] lazy val controllers_MapController_getMyMaps28_invoker = createInvoker(
    MapController_1.getMyMaps(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getMyMaps",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/mymaps""",
      """ Maps""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_MapController_createMap29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/mymaps")))
  )
  private[this] lazy val controllers_MapController_createMap29_invoker = createInvoker(
    MapController_1.createMap(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createMap",
      Seq(classOf[OrgID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/mymaps""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_MapController_getFlashcardTypes30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/flashcardTypes")))
  )
  private[this] lazy val controllers_MapController_getFlashcardTypes30_invoker = createInvoker(
    MapController_1.getFlashcardTypes(fakeValue[OrgID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getFlashcardTypes",
      Seq(classOf[OrgID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/flashcardTypes""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_MapController_mapContentToJson31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/export")))
  )
  private[this] lazy val controllers_MapController_mapContentToJson31_invoker = createInvoker(
    MapController_1.mapContentToJson(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "mapContentToJson",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/export""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_MapController_forkMap32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/fork")))
  )
  private[this] lazy val controllers_MapController_forkMap32_invoker = createInvoker(
    MapController_1.forkMap(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "forkMap",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/fork""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_MapController_getMapAsBlogPage33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/page")))
  )
  private[this] lazy val controllers_MapController_getMapAsBlogPage33_invoker = createInvoker(
    MapController_1.getMapAsBlogPage(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getMapAsBlogPage",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/page""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_MapController_publishMap34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/publish")))
  )
  private[this] lazy val controllers_MapController_publishMap34_invoker = createInvoker(
    MapController_1.publishMap(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "publishMap",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/publish""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_MapController_getMapSettings35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/settings")))
  )
  private[this] lazy val controllers_MapController_getMapSettings35_invoker = createInvoker(
    MapController_1.getMapSettings(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getMapSettings",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/settings""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_MapController_patchMapSettings36_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/settings")))
  )
  private[this] lazy val controllers_MapController_patchMapSettings36_invoker = createInvoker(
    MapController_1.patchMapSettings(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "patchMapSettings",
      Seq(classOf[OrgID], classOf[MapID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/settings""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_MapController_uploadMapIcon37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/icon")))
  )
  private[this] lazy val controllers_MapController_uploadMapIcon37_invoker = createInvoker(
    MapController_1.uploadMapIcon(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "uploadMapIcon",
      Seq(classOf[OrgID], classOf[MapID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/icon""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_MapController_storeImageFile38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/image")))
  )
  private[this] lazy val controllers_MapController_storeImageFile38_invoker = createInvoker(
    MapController_1.storeImageFile(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "storeImageFile",
      Seq(classOf[OrgID], classOf[MapID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/image""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_MapController_validateCard39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/validate")))
  )
  private[this] lazy val controllers_MapController_validateCard39_invoker = createInvoker(
    MapController_1.validateCard(fakeValue[OrgID], fakeValue[MapID], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "validateCard",
      Seq(classOf[OrgID], classOf[MapID], classOf[String]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/card/validate""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_MapController_storeAudioFile40_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/audio")))
  )
  private[this] lazy val controllers_MapController_storeAudioFile40_invoker = createInvoker(
    MapController_1.storeAudioFile(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "storeAudioFile",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/audio""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_MapController_mapToJson41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_mapToJson41_invoker = createInvoker(
    MapController_1.mapToJson(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "mapToJson",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_MapController_getBreadcrumb42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/breadcrumb")))
  )
  private[this] lazy val controllers_MapController_getBreadcrumb42_invoker = createInvoker(
    MapController_1.getBreadcrumb(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getBreadcrumb",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/breadcrumb""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_MapController_createMapNode43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node")))
  )
  private[this] lazy val controllers_MapController_createMapNode43_invoker = createInvoker(
    MapController_1.createMapNode(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createMapNode",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_MapController_patchMapNode44_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_patchMapNode44_invoker = createInvoker(
    MapController_1.patchMapNode(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "patchMapNode",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_MapController_patchMapNodeAttributes45_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/attributes")))
  )
  private[this] lazy val controllers_MapController_patchMapNodeAttributes45_invoker = createInvoker(
    MapController_1.patchMapNodeAttributes(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "patchMapNodeAttributes",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/attributes""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_MapController_deleteNode46_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_deleteNode46_invoker = createInvoker(
    MapController_1.deleteNode(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "deleteNode",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_MapController_convertNodeToSubMap47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/makeSubMap")))
  )
  private[this] lazy val controllers_MapController_convertNodeToSubMap47_invoker = createInvoker(
    MapController_1.convertNodeToSubMap(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "convertNodeToSubMap",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/makeSubMap""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_MapController_createCard48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/card")))
  )
  private[this] lazy val controllers_MapController_createCard48_invoker = createInvoker(
    MapController_1.createCard(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createCard",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID], classOf[String]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_MapController_getCardAsJSON49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/card")))
  )
  private[this] lazy val controllers_MapController_getCardAsJSON49_invoker = createInvoker(
    MapController_1.getCardAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getCardAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_MapController_getCardTypeAsJSON50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/cardType")))
  )
  private[this] lazy val controllers_MapController_getCardTypeAsJSON50_invoker = createInvoker(
    MapController_1.getCardTypeAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getCardTypeAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/cardType""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_MapController_updateCard51_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/card")))
  )
  private[this] lazy val controllers_MapController_updateCard51_invoker = createInvoker(
    MapController_1.updateCard(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "updateCard",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID], classOf[String]),
      "PUT",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/card""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_MapController_createOrUpdatePost52_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/post")))
  )
  private[this] lazy val controllers_MapController_createOrUpdatePost52_invoker = createInvoker(
    MapController_1.createOrUpdatePost(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createOrUpdatePost",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""",
      """""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_MapController_createOrUpdatePost53_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/post")))
  )
  private[this] lazy val controllers_MapController_createOrUpdatePost53_invoker = createInvoker(
    MapController_1.createOrUpdatePost(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createOrUpdatePost",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "PUT",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_MapController_getPostAsJSON54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/post")))
  )
  private[this] lazy val controllers_MapController_getPostAsJSON54_invoker = createInvoker(
    MapController_1.getPostAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getPostAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""",
      """""",
      Seq()
    )
  )

  // @LINE:61
  private[this] lazy val controllers_MapController_deletePost55_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/node/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/post")))
  )
  private[this] lazy val controllers_MapController_deletePost55_invoker = createInvoker(
    MapController_1.deletePost(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "deletePost",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID], classOf[NodeID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/node/""" + "$" + """nodeID<[^/]+>/post""",
      """""",
      Seq()
    )
  )

  // @LINE:62
  private[this] lazy val controllers_MapController_getMapRights56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights")))
  )
  private[this] lazy val controllers_MapController_getMapRights56_invoker = createInvoker(
    MapController_1.getMapRights(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getMapRights",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights""",
      """""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_MapController_createMapRights57_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights")))
  )
  private[this] lazy val controllers_MapController_createMapRights57_invoker = createInvoker(
    MapController_1.createMapRights(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "createMapRights",
      Seq(classOf[OrgID], classOf[MapID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights""",
      """""",
      Seq()
    )
  )

  // @LINE:64
  private[this] lazy val controllers_MapController_mapRightsInvite58_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true), StaticPart("/invite")))
  )
  private[this] lazy val controllers_MapController_mapRightsInvite58_invoker = createInvoker(
    MapController_1.mapRightsInvite(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "mapRightsInvite",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/invite""",
      """""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_MapController_getMapRightsByID59_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_getMapRightsByID59_invoker = createInvoker(
    MapController_1.getMapRightsByID(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "getMapRightsByID",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:66
  private[this] lazy val controllers_MapController_deleteMapRightsByID60_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_deleteMapRightsByID60_invoker = createInvoker(
    MapController_1.deleteMapRightsByID(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "deleteMapRightsByID",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:67
  private[this] lazy val controllers_MapController_patchMapRights61_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_patchMapRights61_invoker = createInvoker(
    MapController_1.patchMapRights(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "patchMapRights",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID]),
      "PATCH",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:68
  private[this] lazy val controllers_MapController_addMapRightsMember62_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true), StaticPart("/member/"), DynamicPart("profileID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_addMapRightsMember62_invoker = createInvoker(
    MapController_1.addMapRightsMember(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID], fakeValue[ProfileID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "addMapRightsMember",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID], classOf[ProfileID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:69
  private[this] lazy val controllers_MapController_removeMapRightsMember63_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/map/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/rights/"), DynamicPart("rightsID", """[^/]+""",true), StaticPart("/member/"), DynamicPart("profileID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MapController_removeMapRightsMember63_invoker = createInvoker(
    MapController_1.removeMapRightsMember(fakeValue[OrgID], fakeValue[MapID], fakeValue[MapRightsID], fakeValue[ProfileID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MapController",
      "removeMapRightsMember",
      Seq(classOf[OrgID], classOf[MapID], classOf[MapRightsID], classOf[ProfileID]),
      "DELETE",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/map/""" + "$" + """mapID<[^/]+>/rights/""" + "$" + """rightsID<[^/]+>/member/""" + "$" + """profileID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_TrainController_cardsToJSON64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/segment/"), DynamicPart("segmentID", """[^/]+""",true), StaticPart("/cards")))
  )
  private[this] lazy val controllers_TrainController_cardsToJSON64_invoker = createInvoker(
    TrainController_3.cardsToJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[SegmentID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "cardsToJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[SegmentID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/segment/""" + "$" + """segmentID<[^/]+>/cards""",
      """ Training""",
      Seq()
    )
  )

  // @LINE:73
  private[this] lazy val controllers_TrainController_getPostsReadTimes65_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/postsReadTimes")))
  )
  private[this] lazy val controllers_TrainController_getPostsReadTimes65_invoker = createInvoker(
    TrainController_3.getPostsReadTimes(fakeValue[OrgID], fakeValue[MapID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "getPostsReadTimes",
      Seq(classOf[OrgID], classOf[MapID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/postsReadTimes""",
      """""",
      Seq()
    )
  )

  // @LINE:74
  private[this] lazy val controllers_TrainController_getPostAsJSON66_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/post/"), DynamicPart("nodeID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainController_getPostAsJSON66_invoker = createInvoker(
    TrainController_3.getPostAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "getPostAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/post/""" + "$" + """nodeID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:75
  private[this] lazy val controllers_TrainController_markPostRead67_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/post/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/markRead")))
  )
  private[this] lazy val controllers_TrainController_markPostRead67_invoker = createInvoker(
    TrainController_3.markPostRead(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "markPostRead",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/post/""" + "$" + """nodeID<[^/]+>/markRead""",
      """""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_TrainController_gradeCard68_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/grade")))
  )
  private[this] lazy val controllers_TrainController_gradeCard68_invoker = createInvoker(
    TrainController_3.gradeCard(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "gradeCard",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID], classOf[String]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/grade""",
      """""",
      Seq()
    )
  )

  // @LINE:77
  private[this] lazy val controllers_TrainController_submitCardQuality69_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/quality")))
  )
  private[this] lazy val controllers_TrainController_submitCardQuality69_invoker = createInvoker(
    TrainController_3.submitCardQuality(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "submitCardQuality",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "POST",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/quality""",
      """""",
      Seq()
    )
  )

  // @LINE:78
  private[this] lazy val controllers_TrainController_getCardAsJSON70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/"), DynamicPart("nodeID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainController_getCardAsJSON70_invoker = createInvoker(
    TrainController_3.getCardAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "getCardAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:79
  private[this] lazy val controllers_TrainController_getCardTypeAsJSON71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("org/"), DynamicPart("orgID", """[^/]+""",true), StaticPart("/train/"), DynamicPart("mapID", """[^/]+""",true), StaticPart("/card/"), DynamicPart("nodeID", """[^/]+""",true), StaticPart("/cardType")))
  )
  private[this] lazy val controllers_TrainController_getCardTypeAsJSON71_invoker = createInvoker(
    TrainController_3.getCardTypeAsJSON(fakeValue[OrgID], fakeValue[MapID], fakeValue[NodeID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainController",
      "getCardTypeAsJSON",
      Seq(classOf[OrgID], classOf[MapID], classOf[NodeID]),
      "GET",
      this.prefix + """org/""" + "$" + """orgID<[^/]+>/train/""" + "$" + """mapID<[^/]+>/card/""" + "$" + """nodeID<[^/]+>/cardType""",
      """""",
      Seq()
    )
  )

  // @LINE:82
  private[this] lazy val controllers_Assets_versioned72_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned72_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_MemberController_getProfile0_route(params@_) =>
      call { 
        controllers_MemberController_getProfile0_invoker.call(MemberController_2.getProfile)
      }
  
    // @LINE:3
    case controllers_MemberController_linkAccount1_route(params@_) =>
      call { 
        controllers_MemberController_linkAccount1_invoker.call(MemberController_2.linkAccount)
      }
  
    // @LINE:4
    case controllers_MemberController_logSignIn2_route(params@_) =>
      call { 
        controllers_MemberController_logSignIn2_invoker.call(MemberController_2.logSignIn)
      }
  
    // @LINE:5
    case controllers_MemberController_register3_route(params@_) =>
      call { 
        controllers_MemberController_register3_invoker.call(MemberController_2.register)
      }
  
    // @LINE:6
    case controllers_MemberController_getOrganizations4_route(params@_) =>
      call { 
        controllers_MemberController_getOrganizations4_invoker.call(MemberController_2.getOrganizations)
      }
  
    // @LINE:7
    case controllers_MemberController_getJWT5_route(params@_) =>
      call(params.fromPath[String]("walletID", None)) { (walletID) =>
        controllers_MemberController_getJWT5_invoker.call(MemberController_2.getJWT(walletID))
      }
  
    // @LINE:10
    case controllers_OrganizationController_createOrg6_route(params@_) =>
      call { 
        controllers_OrganizationController_createOrg6_invoker.call(OrganizationController_0.createOrg)
      }
  
    // @LINE:11
    case controllers_OrganizationController_getBlog7_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_getBlog7_invoker.call(OrganizationController_0.getBlog(orgID))
      }
  
    // @LINE:12
    case controllers_OrganizationController_createBlog8_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_createBlog8_invoker.call(OrganizationController_0.createBlog(orgID))
      }
  
    // @LINE:13
    case controllers_OrganizationController_patchBlog9_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_patchBlog9_invoker.call(OrganizationController_0.patchBlog(orgID))
      }
  
    // @LINE:14
    case controllers_OrganizationController_deleteBlog10_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_deleteBlog10_invoker.call(OrganizationController_0.deleteBlog(orgID))
      }
  
    // @LINE:15
    case controllers_OrganizationController_buildBlog11_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_buildBlog11_invoker.call(OrganizationController_0.buildBlog(orgID))
      }
  
    // @LINE:16
    case controllers_OrganizationController_publishBlog12_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_publishBlog12_invoker.call(OrganizationController_0.publishBlog(orgID))
      }
  
    // @LINE:17
    case controllers_OrganizationController_uploadSiteLogo13_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_uploadSiteLogo13_invoker.call(OrganizationController_0.uploadSiteLogo(orgID))
      }
  
    // @LINE:18
    case controllers_OrganizationController_getConfig14_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_getConfig14_invoker.call(OrganizationController_0.getConfig(orgID))
      }
  
    // @LINE:19
    case controllers_OrganizationController_patchConfig15_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_patchConfig15_invoker.call(OrganizationController_0.patchConfig(orgID))
      }
  
    // @LINE:20
    case controllers_OrganizationController_getMyPermissions16_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_getMyPermissions16_invoker.call(OrganizationController_0.getMyPermissions(orgID))
      }
  
    // @LINE:21
    case controllers_OrganizationController_getOrgMembers17_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_getOrgMembers17_invoker.call(OrganizationController_0.getOrgMembers(orgID))
      }
  
    // @LINE:22
    case controllers_OrganizationController_removeOrgMember18_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[ProfileID]("profileID", None)) { (orgID, profileID) =>
        controllers_OrganizationController_removeOrgMember18_invoker.call(OrganizationController_0.removeOrgMember(orgID, profileID))
      }
  
    // @LINE:23
    case controllers_OrganizationController_getRoles19_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_getRoles19_invoker.call(OrganizationController_0.getRoles(orgID))
      }
  
    // @LINE:24
    case controllers_OrganizationController_getRoleMembers20_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None)) { (orgID, roleID) =>
        controllers_OrganizationController_getRoleMembers20_invoker.call(OrganizationController_0.getRoleMembers(orgID, roleID))
      }
  
    // @LINE:25
    case controllers_OrganizationController_createRole21_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_OrganizationController_createRole21_invoker.call(OrganizationController_0.createRole(orgID))
      }
  
    // @LINE:26
    case controllers_OrganizationController_patchRole22_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None)) { (orgID, roleID) =>
        controllers_OrganizationController_patchRole22_invoker.call(OrganizationController_0.patchRole(orgID, roleID))
      }
  
    // @LINE:27
    case controllers_OrganizationController_getRole23_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None)) { (orgID, roleID) =>
        controllers_OrganizationController_getRole23_invoker.call(OrganizationController_0.getRole(orgID, roleID))
      }
  
    // @LINE:28
    case controllers_OrganizationController_addRoleMember24_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None), params.fromPath[ProfileID]("profileID", None)) { (orgID, roleID, profileID) =>
        controllers_OrganizationController_addRoleMember24_invoker.call(OrganizationController_0.addRoleMember(orgID, roleID, profileID))
      }
  
    // @LINE:29
    case controllers_OrganizationController_removeRoleMember25_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None), params.fromPath[ProfileID]("profileID", None)) { (orgID, roleID, profileID) =>
        controllers_OrganizationController_removeRoleMember25_invoker.call(OrganizationController_0.removeRoleMember(orgID, roleID, profileID))
      }
  
    // @LINE:30
    case controllers_OrganizationController_roleInvite26_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[RoleID]("roleID", None)) { (orgID, roleID) =>
        controllers_OrganizationController_roleInvite26_invoker.call(OrganizationController_0.roleInvite(orgID, roleID))
      }
  
    // @LINE:31
    case controllers_OrganizationController_join27_route(params@_) =>
      call(params.fromPath[RoleInviteID]("inviteID", None)) { (inviteID) =>
        controllers_OrganizationController_join27_invoker.call(OrganizationController_0.join(inviteID))
      }
  
    // @LINE:34
    case controllers_MapController_getMyMaps28_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_MapController_getMyMaps28_invoker.call(MapController_1.getMyMaps(orgID))
      }
  
    // @LINE:35
    case controllers_MapController_createMap29_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_MapController_createMap29_invoker.call(MapController_1.createMap(orgID))
      }
  
    // @LINE:36
    case controllers_MapController_getFlashcardTypes30_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None)) { (orgID) =>
        controllers_MapController_getFlashcardTypes30_invoker.call(MapController_1.getFlashcardTypes(orgID))
      }
  
    // @LINE:37
    case controllers_MapController_mapContentToJson31_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_mapContentToJson31_invoker.call(MapController_1.mapContentToJson(orgID, mapID))
      }
  
    // @LINE:38
    case controllers_MapController_forkMap32_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_forkMap32_invoker.call(MapController_1.forkMap(orgID, mapID))
      }
  
    // @LINE:39
    case controllers_MapController_getMapAsBlogPage33_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_getMapAsBlogPage33_invoker.call(MapController_1.getMapAsBlogPage(orgID, mapID))
      }
  
    // @LINE:40
    case controllers_MapController_publishMap34_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_publishMap34_invoker.call(MapController_1.publishMap(orgID, mapID))
      }
  
    // @LINE:41
    case controllers_MapController_getMapSettings35_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_getMapSettings35_invoker.call(MapController_1.getMapSettings(orgID, mapID))
      }
  
    // @LINE:42
    case controllers_MapController_patchMapSettings36_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_patchMapSettings36_invoker.call(MapController_1.patchMapSettings(orgID, mapID))
      }
  
    // @LINE:43
    case controllers_MapController_uploadMapIcon37_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_uploadMapIcon37_invoker.call(MapController_1.uploadMapIcon(orgID, mapID))
      }
  
    // @LINE:44
    case controllers_MapController_storeImageFile38_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_storeImageFile38_invoker.call(MapController_1.storeImageFile(orgID, mapID))
      }
  
    // @LINE:45
    case controllers_MapController_validateCard39_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromQuery[String]("cardType", None)) { (orgID, mapID, cardType) =>
        controllers_MapController_validateCard39_invoker.call(MapController_1.validateCard(orgID, mapID, cardType))
      }
  
    // @LINE:46
    case controllers_MapController_storeAudioFile40_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_MapController_storeAudioFile40_invoker.call(MapController_1.storeAudioFile(orgID, mapID, nodeID))
      }
  
    // @LINE:47
    case controllers_MapController_mapToJson41_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None)) { (orgID, mapID, segmentID) =>
        controllers_MapController_mapToJson41_invoker.call(MapController_1.mapToJson(orgID, mapID, segmentID))
      }
  
    // @LINE:48
    case controllers_MapController_getBreadcrumb42_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None)) { (orgID, mapID, segmentID) =>
        controllers_MapController_getBreadcrumb42_invoker.call(MapController_1.getBreadcrumb(orgID, mapID, segmentID))
      }
  
    // @LINE:49
    case controllers_MapController_createMapNode43_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None)) { (orgID, mapID, segmentID) =>
        controllers_MapController_createMapNode43_invoker.call(MapController_1.createMapNode(orgID, mapID, segmentID))
      }
  
    // @LINE:50
    case controllers_MapController_patchMapNode44_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_patchMapNode44_invoker.call(MapController_1.patchMapNode(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:51
    case controllers_MapController_patchMapNodeAttributes45_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_patchMapNodeAttributes45_invoker.call(MapController_1.patchMapNodeAttributes(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:52
    case controllers_MapController_deleteNode46_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_deleteNode46_invoker.call(MapController_1.deleteNode(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:53
    case controllers_MapController_convertNodeToSubMap47_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_convertNodeToSubMap47_invoker.call(MapController_1.convertNodeToSubMap(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:54
    case controllers_MapController_createCard48_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None), params.fromQuery[String]("cardType", None)) { (orgID, mapID, segmentID, nodeID, cardType) =>
        controllers_MapController_createCard48_invoker.call(MapController_1.createCard(orgID, mapID, segmentID, nodeID, cardType))
      }
  
    // @LINE:55
    case controllers_MapController_getCardAsJSON49_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_getCardAsJSON49_invoker.call(MapController_1.getCardAsJSON(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:56
    case controllers_MapController_getCardTypeAsJSON50_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_getCardTypeAsJSON50_invoker.call(MapController_1.getCardTypeAsJSON(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:57
    case controllers_MapController_updateCard51_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None), params.fromQuery[String]("cardType", None)) { (orgID, mapID, segmentID, nodeID, cardType) =>
        controllers_MapController_updateCard51_invoker.call(MapController_1.updateCard(orgID, mapID, segmentID, nodeID, cardType))
      }
  
    // @LINE:58
    case controllers_MapController_createOrUpdatePost52_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_createOrUpdatePost52_invoker.call(MapController_1.createOrUpdatePost(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:59
    case controllers_MapController_createOrUpdatePost53_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_createOrUpdatePost53_invoker.call(MapController_1.createOrUpdatePost(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:60
    case controllers_MapController_getPostAsJSON54_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_getPostAsJSON54_invoker.call(MapController_1.getPostAsJSON(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:61
    case controllers_MapController_deletePost55_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, segmentID, nodeID) =>
        controllers_MapController_deletePost55_invoker.call(MapController_1.deletePost(orgID, mapID, segmentID, nodeID))
      }
  
    // @LINE:62
    case controllers_MapController_getMapRights56_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_getMapRights56_invoker.call(MapController_1.getMapRights(orgID, mapID))
      }
  
    // @LINE:63
    case controllers_MapController_createMapRights57_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_MapController_createMapRights57_invoker.call(MapController_1.createMapRights(orgID, mapID))
      }
  
    // @LINE:64
    case controllers_MapController_mapRightsInvite58_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None)) { (orgID, mapID, rightsID) =>
        controllers_MapController_mapRightsInvite58_invoker.call(MapController_1.mapRightsInvite(orgID, mapID, rightsID))
      }
  
    // @LINE:65
    case controllers_MapController_getMapRightsByID59_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None)) { (orgID, mapID, rightsID) =>
        controllers_MapController_getMapRightsByID59_invoker.call(MapController_1.getMapRightsByID(orgID, mapID, rightsID))
      }
  
    // @LINE:66
    case controllers_MapController_deleteMapRightsByID60_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None)) { (orgID, mapID, rightsID) =>
        controllers_MapController_deleteMapRightsByID60_invoker.call(MapController_1.deleteMapRightsByID(orgID, mapID, rightsID))
      }
  
    // @LINE:67
    case controllers_MapController_patchMapRights61_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None)) { (orgID, mapID, rightsID) =>
        controllers_MapController_patchMapRights61_invoker.call(MapController_1.patchMapRights(orgID, mapID, rightsID))
      }
  
    // @LINE:68
    case controllers_MapController_addMapRightsMember62_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None), params.fromPath[ProfileID]("profileID", None)) { (orgID, mapID, rightsID, profileID) =>
        controllers_MapController_addMapRightsMember62_invoker.call(MapController_1.addMapRightsMember(orgID, mapID, rightsID, profileID))
      }
  
    // @LINE:69
    case controllers_MapController_removeMapRightsMember63_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[MapRightsID]("rightsID", None), params.fromPath[ProfileID]("profileID", None)) { (orgID, mapID, rightsID, profileID) =>
        controllers_MapController_removeMapRightsMember63_invoker.call(MapController_1.removeMapRightsMember(orgID, mapID, rightsID, profileID))
      }
  
    // @LINE:72
    case controllers_TrainController_cardsToJSON64_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[SegmentID]("segmentID", None)) { (orgID, mapID, segmentID) =>
        controllers_TrainController_cardsToJSON64_invoker.call(TrainController_3.cardsToJSON(orgID, mapID, segmentID))
      }
  
    // @LINE:73
    case controllers_TrainController_getPostsReadTimes65_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None)) { (orgID, mapID) =>
        controllers_TrainController_getPostsReadTimes65_invoker.call(TrainController_3.getPostsReadTimes(orgID, mapID))
      }
  
    // @LINE:74
    case controllers_TrainController_getPostAsJSON66_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_TrainController_getPostAsJSON66_invoker.call(TrainController_3.getPostAsJSON(orgID, mapID, nodeID))
      }
  
    // @LINE:75
    case controllers_TrainController_markPostRead67_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_TrainController_markPostRead67_invoker.call(TrainController_3.markPostRead(orgID, mapID, nodeID))
      }
  
    // @LINE:76
    case controllers_TrainController_gradeCard68_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None), params.fromQuery[String]("cardType", None)) { (orgID, mapID, nodeID, cardType) =>
        controllers_TrainController_gradeCard68_invoker.call(TrainController_3.gradeCard(orgID, mapID, nodeID, cardType))
      }
  
    // @LINE:77
    case controllers_TrainController_submitCardQuality69_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_TrainController_submitCardQuality69_invoker.call(TrainController_3.submitCardQuality(orgID, mapID, nodeID))
      }
  
    // @LINE:78
    case controllers_TrainController_getCardAsJSON70_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_TrainController_getCardAsJSON70_invoker.call(TrainController_3.getCardAsJSON(orgID, mapID, nodeID))
      }
  
    // @LINE:79
    case controllers_TrainController_getCardTypeAsJSON71_route(params@_) =>
      call(params.fromPath[OrgID]("orgID", None), params.fromPath[MapID]("mapID", None), params.fromPath[NodeID]("nodeID", None)) { (orgID, mapID, nodeID) =>
        controllers_TrainController_getCardTypeAsJSON71_invoker.call(TrainController_3.getCardTypeAsJSON(orgID, mapID, nodeID))
      }
  
    // @LINE:82
    case controllers_Assets_versioned72_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned72_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
