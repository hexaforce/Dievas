'use strict';
/*******************************************************************************
 * MemberInformationSearchController
 ******************************************************************************/
app.controller('MemberInformationSearchController', ['MemberInformationSearchService', '$scope', function (MemberInformationSearchService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    MemberInformationSearchService.init();
    $scope.serviceName = MemberInformationSearchService.getStorageData();
  }
  
}]);