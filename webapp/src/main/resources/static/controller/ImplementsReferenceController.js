'use strict';
/*******************************************************************************
 * ImplementsReferenceController
 ******************************************************************************/
app.controller('ImplementsReferenceController', ['ImplementsReferenceService', '$scope', function (ImplementsReferenceService, $scope) {

  angular.element(document).ready(function () {
    console.log('$(document).ready(function(){?}');
    
    
    $('.collapse-link').on('click', function () {
        var $BOX_PANEL = $(this).closest('.x_panel'),
          $ICON = $(this).find('i'),
          $BOX_CONTENT = $BOX_PANEL.find('.x_content');
        // fix for some div with hardcoded fix class
        if ($BOX_PANEL.attr('style')) {
          $BOX_CONTENT.slideToggle(200, function () {
            $BOX_PANEL.removeAttr('style');
          });
        } else {
          $BOX_CONTENT.slideToggle(200);
          $BOX_PANEL.css('height', 'auto');
        }
        $ICON.toggleClass('fa-chevron-up fa-chevron-down');
      });
    
      $('.close-link').click(function () {
        var $BOX_PANEL = $(this).closest('.x_panel');
        $BOX_PANEL.remove();
      });
      
      var countries = {
        AD: "Andorra",
        A2: "Andorra Test",
        AE: "United Arab Emirates",
        AF: "Afghanistan",
        AG: "Antigua and Barbuda",
        AI: "Anguilla",
        AL: "Albania",
        AM: "Armenia",
        AN: "Netherlands Antilles",
        AO: "Angola",
        AQ: "Antarctica",
        AR: "Argentina",
        AS: "American Samoa",
        AT: "Austria",
        AU: "Australia",
        AW: "Aruba",
        AX: "Åland Islands",
        AZ: "Azerbaijan"
      };
      
      var countriesArray = $.map(countries, function (value, key) {
        return {
          value: value,
          data: key
        };
      });
      // initialize autocomplete with custom appendTo
      $('#autocomplete-custom-append').autocomplete({
        lookup: countriesArray
      });
      // iCheck
      if ($("input.flat")[0]) {
        $('input.flat').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass: 'iradio_flat-green'
        });
      }
      
      if ($(".js-switch")[0]) {
        var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
        elems.forEach(function (html) {
          var switchery = new Switchery(html, {
            color: '#26B99A'
          });
        });
      }

});
  
  $scope.init = function () {
    console.log('ng-init="init()');
    ImplementsReferenceService.init($scope);
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