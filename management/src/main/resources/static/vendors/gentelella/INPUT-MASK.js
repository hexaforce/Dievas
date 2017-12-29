/* INPUT MASK */
function init_InputMask() {
  if (typeof ($.fn.inputmask) === 'undefined') {
    return;
  }
  console.log('init_InputMask');
  $(":input").inputmask();
};