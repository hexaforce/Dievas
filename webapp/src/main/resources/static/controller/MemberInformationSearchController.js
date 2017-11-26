'use strict';
/*******************************************************************************
 * MemberInformationSearchController
 ******************************************************************************/
app.controller('MemberInformationSearchController', ['MemberInformationSearchService', '$scope', function (MemberInformationSearchService, $scope) {
  
  $scope.init = function () {
    console.log('MemberInformationSearchController.js: init()');
    MemberInformationSearchService.init();
    $scope.serviceName = MemberInformationSearchService.getInitResult()[0].message;
  }
  
}]);