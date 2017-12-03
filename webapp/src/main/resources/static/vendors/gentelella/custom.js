/**
 * Resize function without multiple trigger
 * 
 * Usage:
 * $(window).smartresize(function(){  
 *     // code here
 * });
 */
(function ($, sr) {
  // debouncing function from John Hann
  // http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
  var debounce = function (func, threshold, execAsap) {
    var timeout;
    return function debounced() {
      var obj = this,
        args = arguments;

      function delayed() {
        if (!execAsap) func.apply(obj, args);
        timeout = null;
      }
      if (timeout) clearTimeout(timeout);
      else if (execAsap) func.apply(obj, args);
      timeout = setTimeout(delayed, threshold || 100);
    };
  };
  // smartresize 
  jQuery.fn[sr] = function (fn) {
    return fn ? this.bind('resize', debounce(fn)) : this.trigger(sr);
  };
})(jQuery, 'smartresize');
/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var CURRENT_URL = window.location.href.split('#')[0].split('?')[0],
  $BODY = $('body'),
  $MENU_TOGGLE = $('#menu_toggle'),
  $SIDEBAR_MENU = $('#sidebar-menu'),
  $SIDEBAR_FOOTER = $('.sidebar-footer'),
  $LEFT_COL = $('.left_col'),
  $RIGHT_COL = $('.right_col'),
  $NAV_MENU = $('.nav_menu'),
  $FOOTER = $('footer');

//NProgress
if (typeof NProgress != 'undefined') {
  $(document).ready(function () {
    NProgress.start();
  });
  $(window).load(function () {
    NProgress.done();
  });
}

var randNum = function () {
  return (Math.floor(Math.random() * (1 + 40 - 20))) + 20;
};

// Panel toolbox
$(document).ready(function () {
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
});
// /Panel toolbox

// Tooltip
$(document).ready(function () {
  $('[data-toggle="tooltip"]').tooltip({
    container: 'body'
  });
});
// /Tooltip

// Progressbar
if ($(".progress .progress-bar")[0]) {
  $('.progress .progress-bar').progressbar();
}
// /Progressbar

// Switchery
$(document).ready(function () {
  if ($(".js-switch")[0]) {
    var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
    elems.forEach(function (html) {
      var switchery = new Switchery(html, {
        color: '#26B99A'
      });
    });
  }
});
// /Switchery

// iCheck
$(document).ready(function () {
  if ($("input.flat")[0]) {
    $(document).ready(function () {
      $('input.flat').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
      });
    });
  }
});
// /iCheck

// Table
$('table input').on('ifChecked', function () {
  checkState = '';
  $(this).parent().parent().parent().addClass('selected');
  countChecked();
});

$('table input').on('ifUnchecked', function () {
  checkState = '';
  $(this).parent().parent().parent().removeClass('selected');
  countChecked();
});

var checkState = '';
$('.bulk_action input').on('ifChecked', function () {
  checkState = '';
  $(this).parent().parent().parent().addClass('selected');
  countChecked();
});
$('.bulk_action input').on('ifUnchecked', function () {
  checkState = '';
  $(this).parent().parent().parent().removeClass('selected');
  countChecked();
});

$('.bulk_action input#check-all').on('ifChecked', function () {
  checkState = 'all';
  countChecked();
});

$('.bulk_action input#check-all').on('ifUnchecked', function () {
  checkState = 'none';
  countChecked();
});

function countChecked() {
  if (checkState === 'all') {
    $(".bulk_action input[name='table_records']").iCheck('check');
  }
  if (checkState === 'none') {
    $(".bulk_action input[name='table_records']").iCheck('uncheck');
  }
  var checkCount = $(".bulk_action input[name='table_records']:checked").length;
  if (checkCount) {
    $('.column-title').hide();
    $('.bulk-actions').show();
    $('.action-cnt').html(checkCount + ' Records Selected');
  } else {
    $('.column-title').show();
    $('.bulk-actions').hide();
  }
}

// Accordion
$(document).ready(function () {
  $(".expand").on("click", function () {
    $(this).next().slideToggle(200);
    $expand = $(this).find(">:first-child");
    if ($expand.text() == "+") {
      $expand.text("-");
    } else {
      $expand.text("+");
    }
  });
});

//hover and retain popover when on popover content
var originalLeave = $.fn.popover.Constructor.prototype.leave;
$.fn.popover.Constructor.prototype.leave = function (obj) {
  var self = obj instanceof this.constructor ? obj : $(obj.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type);
  var container, timeout;
  originalLeave.call(this, obj);
  if (obj.currentTarget) {
    container = $(obj.currentTarget).siblings('.popover');
    timeout = self.timeout;
    container.one('mouseenter', function () {
      //We entered the actual popover - call off the dogs
      clearTimeout(timeout);
      //Let's monitor popover content instead
      container.one('mouseleave', function () {
        $.fn.popover.Constructor.prototype.leave.call(self, self);
      });
    });
  }
};

$('body').popover({
  selector: '[data-popover]',
  trigger: 'click hover',
  delay: {
    show: 50,
    hide: 400
  }
});

function gd(year, month, day) {
  return new Date(year, month - 1, day).getTime();
}

/* INPUTS */
function onAddTag(tag) {
  alert("Added a tag: " + tag);
}

function onRemoveTag(tag) {
  alert("Removed a tag: " + tag);
}

function onChangeTag(input, tag) {
  alert("Changed a tag: " + tag);
}

$(document).ready(function () {
  init_sparklines();
  init_flot_chart();
  init_sidebar();
  init_wysiwyg();
  init_InputMask();
  init_JQVmap();
  init_cropper();
  init_knob();
  init_IonRangeSlider();
  init_ColorPicker();
  init_TagsInput();
  init_parsley();
  init_daterangepicker();
  init_daterangepicker_right();
  init_daterangepicker_single_call();
  init_daterangepicker_reservation();
  init_SmartWizard();
  init_EasyPieChart();
  init_charts();
  init_echarts();
  init_morris_charts();
  init_skycons();
  init_select2();
  init_validator();
  init_DataTables();
  init_chart_doughnut();
  init_gauge();
  init_PNotify();
  init_starrr();
  init_calendar();
  init_compose();
  init_CustomNotification();
  init_autosize();
  init_autocomplete();
});