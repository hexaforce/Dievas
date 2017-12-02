'use strict';
/*******************************************************************************
 * MemberInformationSearchController
 ******************************************************************************/
app.controller('MemberInformationSearchController', ['MemberInformationSearchService', '$scope', function (MemberInformationSearchService, $scope) {
  
  $scope.init = function () {
    console.log('MemberInformationSearchController.js: init()');
    MemberInformationSearchService.init();
    $scope.serviceName = MemberInformationSearchService.getLocalData()[0].message;
  }
  
}]);