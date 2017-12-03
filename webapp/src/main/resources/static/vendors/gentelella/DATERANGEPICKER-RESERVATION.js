function init_daterangepicker_reservation() {
  if (typeof ($.fn.daterangepicker) === 'undefined') {
    return;
  }
  console.log('init_daterangepicker_reservation');
  $('#reservation').daterangepicker(null, function (start, end, label) {
    console.log(start.toISOString(), end.toISOString(), label);
  });
  $('#reservation-time').daterangepicker({
    timePicker: true,
    timePickerIncrement: 30,
    locale: {
      format: 'MM/DD/YYYY h:mm A'
    }
  });
}