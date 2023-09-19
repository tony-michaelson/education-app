// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMemberController MemberController = new controllers.ReverseMemberController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOrganizationController OrganizationController = new controllers.ReverseOrganizationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTrainController TrainController = new controllers.ReverseTrainController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMapController MapController = new controllers.ReverseMapController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMemberController MemberController = new controllers.javascript.ReverseMemberController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOrganizationController OrganizationController = new controllers.javascript.ReverseOrganizationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTrainController TrainController = new controllers.javascript.ReverseTrainController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMapController MapController = new controllers.javascript.ReverseMapController(RoutesPrefix.byNamePrefix());
  }

}
