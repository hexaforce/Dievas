'use strict';
/*******************************************************************************
 * MailDistributionListController
 ******************************************************************************/
app.controller('MailDistributionListController', ['MailDistributionListService', '$scope', function (MailDistributionListService, $scope) {
  
  $scope.init = function () {
    console.log('MailDistributionListController.js: init()');
    MailDistributionListService.init();
    $scope.serviceName = MailDistributionListService.getInitResult()[0].message;
  }
  
}]);