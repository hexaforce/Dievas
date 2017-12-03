'use strict';
/*******************************************************************************
 * ImplementsReferenceController
 ******************************************************************************/
app.controller('ImplementsReferenceController', ['ImplementsReferenceService', '$scope', function (ImplementsReferenceService, $scope) {
  $scope.init = function () {
    console.log('Controller(js): init()');
    ImplementsReferenceService.init();
    $scope.serviceName = ImplementsReferenceService.getStorageData()[0].message;
  }
  $scope.DefaultAction = function () {
    console.log('DefaultAction');
  }
  $scope.PrimaryAction = function () {
    console.log('PrimaryAction');
  }
  $scope.SuccessAction = function () {
    console.log('SuccessAction');
  }
  $scope.InfoAction = function () {
    console.log('InfoAction');
  }
  $scope.WarningAction = function () {
    console.log('WarningAction');
  }
  $scope.DangerAction = function () {
    console.log('DangerAction');
  }
  $scope.DarkAction = function () {
    console.log('DarkAction');
  }
  $scope.LinkAction = function () {
    console.log('LinkAction');
  }
}]);