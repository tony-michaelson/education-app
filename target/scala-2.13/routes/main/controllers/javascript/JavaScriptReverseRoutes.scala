// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.io.masterypath.slick.{MapID, NodeID, ProfileID, MapRightsID, RoleID, RoleInviteID, OrgID, SegmentID}

// @LINE:2
package controllers.javascript {

  // @LINE:82
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseMemberController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getJWT: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.getJWT",
      """
        function(walletID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "member/jwt/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("walletID", walletID0))})
        }
      """
    )
  
    // @LINE:6
    def getOrganizations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.getOrganizations",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "member/organizations"})
        }
      """
    )
  
    // @LINE:2
    def getProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.getProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "member/profile"})
        }
      """
    )
  
    // @LINE:5
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "member/register"})
        }
      """
    )
  
    // @LINE:3
    def linkAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.linkAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "member/linkAccount"})
        }
      """
    )
  
    // @LINE:4
    def logSignIn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MemberController.logSignIn",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "member/logSignIn"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseOrganizationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def createRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.createRole",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role"})
        }
      """
    )
  
    // @LINE:15
    def buildBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.buildBlog",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog/build"})
        }
      """
    )
  
    // @LINE:28
    def addRoleMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.addRoleMember",
      """
        function(orgID0,roleID1,profileID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1)) + "/member/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[ProfileID]].javascriptUnbind + """)("profileID", profileID2))})
        }
      """
    )
  
    // @LINE:14
    def deleteBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.deleteBlog",
      """
        function(orgID0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog"})
        }
      """
    )
  
    // @LINE:21
    def getOrgMembers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getOrgMembers",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/members"})
        }
      """
    )
  
    // @LINE:19
    def patchConfig: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.patchConfig",
      """
        function(orgID0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/config"})
        }
      """
    )
  
    // @LINE:10
    def createOrg: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.createOrg",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org"})
        }
      """
    )
  
    // @LINE:17
    def uploadSiteLogo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.uploadSiteLogo",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog/logo"})
        }
      """
    )
  
    // @LINE:11
    def getBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getBlog",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog"})
        }
      """
    )
  
    // @LINE:26
    def patchRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.patchRole",
      """
        function(orgID0,roleID1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1))})
        }
      """
    )
  
    // @LINE:13
    def patchBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.patchBlog",
      """
        function(orgID0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog"})
        }
      """
    )
  
    // @LINE:16
    def publishBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.publishBlog",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog/publish"})
        }
      """
    )
  
    // @LINE:29
    def removeRoleMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.removeRoleMember",
      """
        function(orgID0,roleID1,profileID2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1)) + "/member/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[ProfileID]].javascriptUnbind + """)("profileID", profileID2))})
        }
      """
    )
  
    // @LINE:22
    def removeOrgMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.removeOrgMember",
      """
        function(orgID0,profileID1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/member/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[ProfileID]].javascriptUnbind + """)("profileID", profileID1))})
        }
      """
    )
  
    // @LINE:23
    def getRoles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getRoles",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/roles"})
        }
      """
    )
  
    // @LINE:20
    def getMyPermissions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getMyPermissions",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/mypermissions"})
        }
      """
    )
  
    // @LINE:24
    def getRoleMembers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getRoleMembers",
      """
        function(orgID0,roleID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1)) + "/members"})
        }
      """
    )
  
    // @LINE:31
    def join: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.join",
      """
        function(inviteID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "invite/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleInviteID]].javascriptUnbind + """)("inviteID", inviteID0)) + "/join"})
        }
      """
    )
  
    // @LINE:18
    def getConfig: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getConfig",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/config"})
        }
      """
    )
  
    // @LINE:12
    def createBlog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.createBlog",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/blog"})
        }
      """
    )
  
    // @LINE:27
    def getRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.getRole",
      """
        function(orgID0,roleID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1))})
        }
      """
    )
  
    // @LINE:30
    def roleInvite: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrganizationController.roleInvite",
      """
        function(orgID0,roleID1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/role/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[RoleID]].javascriptUnbind + """)("roleID", roleID1)) + "/invite"})
        }
      """
    )
  
  }

  // @LINE:72
  class ReverseTrainController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:74
    def getPostAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.getPostAsJSON",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/post/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2))})
        }
      """
    )
  
    // @LINE:73
    def getPostsReadTimes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.getPostsReadTimes",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/postsReadTimes"})
        }
      """
    )
  
    // @LINE:78
    def getCardAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.getCardAsJSON",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2))})
        }
      """
    )
  
    // @LINE:75
    def markPostRead: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.markPostRead",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/post/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2)) + "/markRead"})
        }
      """
    )
  
    // @LINE:72
    def cardsToJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.cardsToJSON",
      """
        function(orgID0,mapID1,segmentID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/cards"})
        }
      """
    )
  
    // @LINE:77
    def submitCardQuality: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.submitCardQuality",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2)) + "/quality"})
        }
      """
    )
  
    // @LINE:79
    def getCardTypeAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.getCardTypeAsJSON",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2)) + "/cardType"})
        }
      """
    )
  
    // @LINE:76
    def gradeCard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainController.gradeCard",
      """
        function(orgID0,mapID1,nodeID2,cardType3) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/train/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2)) + "/grade" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("cardType", cardType3)])})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseMapController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:67
    def patchMapRights: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.patchMapRights",
      """
        function(orgID0,mapID1,rightsID2) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2))})
        }
      """
    )
  
    // @LINE:37
    def mapContentToJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.mapContentToJson",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/export"})
        }
      """
    )
  
    // @LINE:42
    def patchMapSettings: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.patchMapSettings",
      """
        function(orgID0,mapID1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/settings"})
        }
      """
    )
  
    // @LINE:56
    def getCardTypeAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getCardTypeAsJSON",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/cardType"})
        }
      """
    )
  
    // @LINE:53
    def convertNodeToSubMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.convertNodeToSubMap",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/makeSubMap"})
        }
      """
    )
  
    // @LINE:66
    def deleteMapRightsByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.deleteMapRightsByID",
      """
        function(orgID0,mapID1,rightsID2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2))})
        }
      """
    )
  
    // @LINE:39
    def getMapAsBlogPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getMapAsBlogPage",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/page"})
        }
      """
    )
  
    // @LINE:55
    def getCardAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getCardAsJSON",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/card"})
        }
      """
    )
  
    // @LINE:34
    def getMyMaps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getMyMaps",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/mymaps"})
        }
      """
    )
  
    // @LINE:69
    def removeMapRightsMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.removeMapRightsMember",
      """
        function(orgID0,mapID1,rightsID2,profileID3) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2)) + "/member/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[ProfileID]].javascriptUnbind + """)("profileID", profileID3))})
        }
      """
    )
  
    // @LINE:44
    def storeImageFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.storeImageFile",
      """
        function(orgID0,mapID1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/image"})
        }
      """
    )
  
    // @LINE:58
    def createOrUpdatePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.createOrUpdatePost",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/post"})
          }
        
        }
      """
    )
  
    // @LINE:61
    def deletePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.deletePost",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/post"})
        }
      """
    )
  
    // @LINE:46
    def storeAudioFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.storeAudioFile",
      """
        function(orgID0,mapID1,nodeID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID2)) + "/audio"})
        }
      """
    )
  
    // @LINE:41
    def getMapSettings: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getMapSettings",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/settings"})
        }
      """
    )
  
    // @LINE:45
    def validateCard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.validateCard",
      """
        function(orgID0,mapID1,cardType2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/card/validate" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("cardType", cardType2)])})
        }
      """
    )
  
    // @LINE:65
    def getMapRightsByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getMapRightsByID",
      """
        function(orgID0,mapID1,rightsID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2))})
        }
      """
    )
  
    // @LINE:62
    def getMapRights: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getMapRights",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights"})
        }
      """
    )
  
    // @LINE:57
    def updateCard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.updateCard",
      """
        function(orgID0,mapID1,segmentID2,nodeID3,cardType4) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/card" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("cardType", cardType4)])})
        }
      """
    )
  
    // @LINE:68
    def addMapRightsMember: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.addMapRightsMember",
      """
        function(orgID0,mapID1,rightsID2,profileID3) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2)) + "/member/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[ProfileID]].javascriptUnbind + """)("profileID", profileID3))})
        }
      """
    )
  
    // @LINE:48
    def getBreadcrumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getBreadcrumb",
      """
        function(orgID0,mapID1,segmentID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/breadcrumb"})
        }
      """
    )
  
    // @LINE:50
    def patchMapNode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.patchMapNode",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3))})
        }
      """
    )
  
    // @LINE:36
    def getFlashcardTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getFlashcardTypes",
      """
        function(orgID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/flashcardTypes"})
        }
      """
    )
  
    // @LINE:49
    def createMapNode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.createMapNode",
      """
        function(orgID0,mapID1,segmentID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node"})
        }
      """
    )
  
    // @LINE:60
    def getPostAsJSON: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.getPostAsJSON",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/post"})
        }
      """
    )
  
    // @LINE:52
    def deleteNode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.deleteNode",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3))})
        }
      """
    )
  
    // @LINE:63
    def createMapRights: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.createMapRights",
      """
        function(orgID0,mapID1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights"})
        }
      """
    )
  
    // @LINE:51
    def patchMapNodeAttributes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.patchMapNodeAttributes",
      """
        function(orgID0,mapID1,segmentID2,nodeID3) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/attributes"})
        }
      """
    )
  
    // @LINE:38
    def forkMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.forkMap",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/fork"})
        }
      """
    )
  
    // @LINE:47
    def mapToJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.mapToJson",
      """
        function(orgID0,mapID1,segmentID2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2))})
        }
      """
    )
  
    // @LINE:35
    def createMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.createMap",
      """
        function(orgID0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/mymaps"})
        }
      """
    )
  
    // @LINE:40
    def publishMap: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.publishMap",
      """
        function(orgID0,mapID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/publish"})
        }
      """
    )
  
    // @LINE:64
    def mapRightsInvite: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.mapRightsInvite",
      """
        function(orgID0,mapID1,rightsID2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/rights/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapRightsID]].javascriptUnbind + """)("rightsID", rightsID2)) + "/invite"})
        }
      """
    )
  
    // @LINE:54
    def createCard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.createCard",
      """
        function(orgID0,mapID1,segmentID2,nodeID3,cardType4) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/segment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[SegmentID]].javascriptUnbind + """)("segmentID", segmentID2)) + "/node/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[NodeID]].javascriptUnbind + """)("nodeID", nodeID3)) + "/card" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("cardType", cardType4)])})
        }
      """
    )
  
    // @LINE:43
    def uploadMapIcon: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MapController.uploadMapIcon",
      """
        function(orgID0,mapID1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "org/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[OrgID]].javascriptUnbind + """)("orgID", orgID0)) + "/map/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[MapID]].javascriptUnbind + """)("mapID", mapID1)) + "/icon"})
        }
      """
    )
  
  }


}
