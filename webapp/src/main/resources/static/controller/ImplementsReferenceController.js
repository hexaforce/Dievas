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
    ImplementsReferenceService.DefaultAction($scope);
  }
  $scope.PrimaryAction = function () {
    console.log('PrimaryAction');
    ImplementsReferenceService.PrimaryAction($scope);
  }
  $scope.SuccessAction = function () {
    console.log('SuccessAction');
    ImplementsReferenceService.SuccessAction($scope);
  }
  $scope.InfoAction = function () {
    console.log('InfoAction');
    ImplementsReferenceService.InfoAction($scope);
  }
  $scope.WarningAction = function () {
    console.log('WarningAction');
    ImplementsReferenceService.WarningAction($scope);
  }
  $scope.DangerAction = function () {
    console.log('DangerAction');
    ImplementsReferenceService.DangerAction($scope);
  }
  $scope.DarkAction = function () {
    console.log('DarkAction');
    ImplementsReferenceService.DarkAction($scope);
  }
  $scope.LinkAction = function () {
    console.log('LinkAction');
    ImplementsReferenceService.LinkAction($scope);
  }
}]);