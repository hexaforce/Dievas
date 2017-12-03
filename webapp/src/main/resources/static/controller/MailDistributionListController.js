'use strict';
/*******************************************************************************
 * MailDistributionListController
 ******************************************************************************/
app.controller('MailDistributionListController', ['MailDistributionListService', '$scope', function (MailDistributionListService, $scope) {
  
  $scope.init = function () {
    console.log('Controller(js): init()');
    MailDistributionListService.init();
    $scope.serviceName = MailDistributionListService.getStorageData();
  }
  
}]);