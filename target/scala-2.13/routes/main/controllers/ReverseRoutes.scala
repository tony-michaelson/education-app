// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.io.masterypath.slick.{MapID, NodeID, ProfileID, MapRightsID, RoleID, RoleInviteID, OrgID, SegmentID}

// @LINE:2
package controllers {

  // @LINE:82
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:2
  class ReverseMemberController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getJWT(walletID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "member/jwt/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("walletID", walletID)))
    }
  
    // @LINE:6
    def getOrganizations: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "member/organizations")
    }
  
    // @LINE:2
    def getProfile: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "member/profile")
    }
  
    // @LINE:5
    def register: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "member/register")
    }
  
    // @LINE:3
    def linkAccount: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "member/linkAccount")
    }
  
    // @LINE:4
    def logSignIn: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "member/logSignIn")
    }
  
  }

  // @LINE:10
  class ReverseOrganizationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def createRole(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role")
    }
  
    // @LINE:15
    def buildBlog(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog/build")
    }
  
    // @LINE:28
    def addRoleMember(orgID:OrgID, roleID:RoleID, profileID:ProfileID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)) + "/member/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[ProfileID]].unbind("profileID", profileID)))
    }
  
    // @LINE:14
    def deleteBlog(orgID:OrgID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog")
    }
  
    // @LINE:21
    def getOrgMembers(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/members")
    }
  
    // @LINE:19
    def patchConfig(orgID:OrgID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/config")
    }
  
    // @LINE:10
    def createOrg: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org")
    }
  
    // @LINE:17
    def uploadSiteLogo(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog/logo")
    }
  
    // @LINE:11
    def getBlog(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog")
    }
  
    // @LINE:26
    def patchRole(orgID:OrgID, roleID:RoleID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)))
    }
  
    // @LINE:13
    def patchBlog(orgID:OrgID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog")
    }
  
    // @LINE:16
    def publishBlog(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog/publish")
    }
  
    // @LINE:29
    def removeRoleMember(orgID:OrgID, roleID:RoleID, profileID:ProfileID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)) + "/member/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[ProfileID]].unbind("profileID", profileID)))
    }
  
    // @LINE:22
    def removeOrgMember(orgID:OrgID, profileID:ProfileID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/member/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[ProfileID]].unbind("profileID", profileID)))
    }
  
    // @LINE:23
    def getRoles(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/roles")
    }
  
    // @LINE:20
    def getMyPermissions(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/mypermissions")
    }
  
    // @LINE:24
    def getRoleMembers(orgID:OrgID, roleID:RoleID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)) + "/members")
    }
  
    // @LINE:31
    def join(inviteID:RoleInviteID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "invite/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleInviteID]].unbind("inviteID", inviteID)) + "/join")
    }
  
    // @LINE:18
    def getConfig(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/config")
    }
  
    // @LINE:12
    def createBlog(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/blog")
    }
  
    // @LINE:27
    def getRole(orgID:OrgID, roleID:RoleID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)))
    }
  
    // @LINE:30
    def roleInvite(orgID:OrgID, roleID:RoleID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/role/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[RoleID]].unbind("roleID", roleID)) + "/invite")
    }
  
  }

  // @LINE:72
  class ReverseTrainController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:74
    def getPostAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/post/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)))
    }
  
    // @LINE:73
    def getPostsReadTimes(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/postsReadTimes")
    }
  
    // @LINE:78
    def getCardAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)))
    }
  
    // @LINE:75
    def markPostRead(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/post/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/markRead")
    }
  
    // @LINE:72
    def cardsToJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/cards")
    }
  
    // @LINE:77
    def submitCardQuality(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/quality")
    }
  
    // @LINE:79
    def getCardTypeAsJSON(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/cardType")
    }
  
    // @LINE:76
    def gradeCard(orgID:OrgID, mapID:MapID, nodeID:NodeID, cardType:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/train/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/grade" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("cardType", cardType)))))
    }
  
  }

  // @LINE:34
  class ReverseMapController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:67
    def patchMapRights(orgID:OrgID, mapID:MapID, rightsID:MapRightsID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)))
    }
  
    // @LINE:37
    def mapContentToJson(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/export")
    }
  
    // @LINE:42
    def patchMapSettings(orgID:OrgID, mapID:MapID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/settings")
    }
  
    // @LINE:56
    def getCardTypeAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/cardType")
    }
  
    // @LINE:53
    def convertNodeToSubMap(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/makeSubMap")
    }
  
    // @LINE:66
    def deleteMapRightsByID(orgID:OrgID, mapID:MapID, rightsID:MapRightsID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)))
    }
  
    // @LINE:39
    def getMapAsBlogPage(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/page")
    }
  
    // @LINE:55
    def getCardAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/card")
    }
  
    // @LINE:34
    def getMyMaps(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/mymaps")
    }
  
    // @LINE:69
    def removeMapRightsMember(orgID:OrgID, mapID:MapID, rightsID:MapRightsID, profileID:ProfileID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)) + "/member/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[ProfileID]].unbind("profileID", profileID)))
    }
  
    // @LINE:44
    def storeImageFile(orgID:OrgID, mapID:MapID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/image")
    }
  
    // @LINE:58
    def createOrUpdatePost(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
    
      (orgID: @unchecked, mapID: @unchecked, segmentID: @unchecked, nodeID: @unchecked) match {
      
        // @LINE:58
        case (orgID, mapID, segmentID, nodeID)  =>
          
          Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/post")
      
      }
    
    }
  
    // @LINE:61
    def deletePost(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/post")
    }
  
    // @LINE:46
    def storeAudioFile(orgID:OrgID, mapID:MapID, nodeID:NodeID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/audio")
    }
  
    // @LINE:41
    def getMapSettings(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/settings")
    }
  
    // @LINE:45
    def validateCard(orgID:OrgID, mapID:MapID, cardType:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/card/validate" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("cardType", cardType)))))
    }
  
    // @LINE:65
    def getMapRightsByID(orgID:OrgID, mapID:MapID, rightsID:MapRightsID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)))
    }
  
    // @LINE:62
    def getMapRights(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights")
    }
  
    // @LINE:57
    def updateCard(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID, cardType:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/card" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("cardType", cardType)))))
    }
  
    // @LINE:68
    def addMapRightsMember(orgID:OrgID, mapID:MapID, rightsID:MapRightsID, profileID:ProfileID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)) + "/member/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[ProfileID]].unbind("profileID", profileID)))
    }
  
    // @LINE:48
    def getBreadcrumb(orgID:OrgID, mapID:MapID, segmentID:SegmentID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/breadcrumb")
    }
  
    // @LINE:50
    def patchMapNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)))
    }
  
    // @LINE:36
    def getFlashcardTypes(orgID:OrgID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/flashcardTypes")
    }
  
    // @LINE:49
    def createMapNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node")
    }
  
    // @LINE:60
    def getPostAsJSON(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/post")
    }
  
    // @LINE:52
    def deleteNode(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)))
    }
  
    // @LINE:63
    def createMapRights(orgID:OrgID, mapID:MapID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights")
    }
  
    // @LINE:51
    def patchMapNodeAttributes(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/attributes")
    }
  
    // @LINE:38
    def forkMap(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/fork")
    }
  
    // @LINE:47
    def mapToJson(orgID:OrgID, mapID:MapID, segmentID:SegmentID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)))
    }
  
    // @LINE:35
    def createMap(orgID:OrgID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/mymaps")
    }
  
    // @LINE:40
    def publishMap(orgID:OrgID, mapID:MapID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/publish")
    }
  
    // @LINE:64
    def mapRightsInvite(orgID:OrgID, mapID:MapID, rightsID:MapRightsID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/rights/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapRightsID]].unbind("rightsID", rightsID)) + "/invite")
    }
  
    // @LINE:54
    def createCard(orgID:OrgID, mapID:MapID, segmentID:SegmentID, nodeID:NodeID, cardType:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/segment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[SegmentID]].unbind("segmentID", segmentID)) + "/node/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[NodeID]].unbind("nodeID", nodeID)) + "/card" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("cardType", cardType)))))
    }
  
    // @LINE:43
    def uploadMapIcon(orgID:OrgID, mapID:MapID): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "org/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[OrgID]].unbind("orgID", orgID)) + "/map/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[MapID]].unbind("mapID", mapID)) + "/icon")
    }
  
  }


}
