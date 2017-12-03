'use strict';
/*******************************************************************************
 * UI-Router routing template configuration see also >>
 * https://github.com/angular-ui/ui-router/wiki see also >>
 * https://ui-router.github.io/ng1/docs/latest/modules/injectables.html#_stateprovider
 ******************************************************************************/
app.config(['$stateProvider', '$urlRouterProvider',
  function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    var ImplementsReference = { name : 'ImplementsReference', url : '/implements-reference', templateUrl : 'content/implements-reference', controller : 'ImplementsReferenceController', controllerAs : 'ctrl' };
    var MemberInformationSearch = { name : 'MemberInformationSearch', url : '/member-information-search', templateUrl : 'content/member-information-search', controller : 'MemberInformationSearchController', controllerAs : 'ctrl' };
    var PersonalInformationChangeRequest = { name : 'PersonalInformationChangeRequest', url : '/personal-information-change-request', templateUrl : 'content/personal-information-change-request', controller : 'PersonalInformationChangeRequestController', controllerAs : 'ctrl' };
    var DuplicateSamePerson = { name : 'DuplicateSamePerson', url : '/duplicate-same-person', templateUrl : 'content/duplicate-same-person', controller : 'DuplicateSamePersonController', controllerAs : 'ctrl' };
    var ExamScheduleGanttChart = { name : 'ExamScheduleGanttChart', url : '/exam-schedule-gantt-chart', templateUrl : 'content/exam-schedule-gantt-chart', controller : 'ExamScheduleGanttChartController', controllerAs : 'ctrl' };
    var ExamRelated = { name : 'ExamRelated', url : '/exam-related', templateUrl : 'content/exam-related', controller : 'ExamRelatedController', controllerAs : 'ctrl' };
    var ExamVoucherPassRejection = { name : 'ExamVoucherPassRejection', url : '/exam-voucher-pass-rejection', templateUrl : 'content/exam-voucher-pass-rejection', controller : 'ExamVoucherPassRejectionController', controllerAs : 'ctrl' };
    var SystemRelatedList = { name : 'SystemRelatedList', url : '/system-related-list', templateUrl : 'content/system-related-list', controller : 'SystemRelatedListController', controllerAs : 'ctrl' };
    var ExamLocationManagement = { name : 'ExamLocationManagement', url : '/exam-location-management', templateUrl : 'content/exam-location-management', controller : 'ExamLocationManagementController', controllerAs : 'ctrl' };
    var FacePhotographs = { name : 'FacePhotographs', url : '/face-photographs', templateUrl : 'content/face-photographs', controller : 'FacePhotographsController', controllerAs : 'ctrl' };
    var FacePhotographsConfirmation = { name : 'FacePhotographsConfirmation', url : '/face-photographs-confirmation', templateUrl : 'content/face-photographs-confirmation', controller : 'FacePhotographsConfirmationController', controllerAs : 'ctrl' };
    var ImportRatingAverage = { name : 'ImportRatingAverage', url : '/import-rating-average-', templateUrl : 'content/import-rating-average-', controller : 'ImportRatingAverageController', controllerAs : 'ctrl' };
    var ExaminationNumberTemporaryProcess = { name : 'ExaminationNumberTemporaryProcess', url : '/examination-number-temporary-process', templateUrl : 'content/examination-number-temporary-process', controller : 'ExaminationNumberTemporaryProcessController', controllerAs : 'ctrl' };
    var ExaminationNumberBooking = { name : 'ExaminationNumberBooking', url : '/examination-number-booking', templateUrl : 'content/examination-number-booking', controller : 'ExaminationNumberBookingController', controllerAs : 'ctrl' };
    var ExaminationNumberReservationCancellation = { name : 'ExaminationNumberReservationCancellation', url : '/examination-number-reservation-cancellation', templateUrl : 'content/examination-number-reservation-cancellation', controller : 'ExaminationNumberReservationCancellationController', controllerAs : 'ctrl' };
    var ExamineeReport = { name : 'ExamineeReport', url : '/examinee-report', templateUrl : 'content/examinee-report', controller : 'ExamineeReportController', controllerAs : 'ctrl' };
    var AcceptanceImportPassRejection = { name : 'AcceptanceImportPassRejection', url : '/acceptance-import-pass-rejection', templateUrl : 'content/acceptance-import-pass-rejection', controller : 'AcceptanceImportPassRejectionController', controllerAs : 'ctrl' };
    var ExaminationNumberNumberingParameter = { name : 'ExaminationNumberNumberingParameter', url : '/examination-number-numbering-parameter', templateUrl : 'content/examination-number-numbering-parameter', controller : 'ExaminationNumberNumberingParameterController', controllerAs : 'ctrl' };
    var ExaminationNumberCancellation = { name : 'ExaminationNumberCancellation', url : '/examination-number-cancellation', templateUrl : 'content/examination-number-cancellation', controller : 'ExaminationNumberCancellationController', controllerAs : 'ctrl' };
    var PracticalExaminationNumberManagement = { name : 'PracticalExaminationNumberManagement', url : '/practical-examination-number-management', templateUrl : 'content/practical-examination-number-management', controller : 'PracticalExaminationNumberManagementController', controllerAs : 'ctrl' };
    var DailySchedule = { name : 'DailySchedule', url : '/daily-schedule', templateUrl : 'content/daily-schedule', controller : 'DailyScheduleController', controllerAs : 'ctrl' };
    var ApplicantPreliminaryReport = { name : 'ApplicantPreliminaryReport', url : '/applicant-preliminary-report', templateUrl : 'content/applicant-preliminary-report', controller : 'ApplicantPreliminaryReportController', controllerAs : 'ctrl' };
    var ChangeLog = { name : 'ChangeLog', url : '/change-log', templateUrl : 'content/change-log', controller : 'ChangeLogController', controllerAs : 'ctrl' };
    var AcceptanceReport = { name : 'AcceptanceReport', url : '/acceptance-report', templateUrl : 'content/acceptance-report', controller : 'AcceptanceReportController', controllerAs : 'ctrl' };
    var ProcessingStatusReport = { name : 'ProcessingStatusReport', url : '/processing-status-report', templateUrl : 'content/processing-status-report', controller : 'ProcessingStatusReportController', controllerAs : 'ctrl' };
    var PaymentAndDocumentArrived = { name : 'PaymentAndDocumentArrived', url : '/payment-and-document-arrived-', templateUrl : 'content/payment-and-document-arrived-', controller : 'PaymentAndDocumentArrivedController', controllerAs : 'ctrl' };
    var DocumentConfirmation = { name : 'DocumentConfirmation', url : '/document-confirmation', templateUrl : 'content/document-confirmation', controller : 'DocumentConfirmationController', controllerAs : 'ctrl' };
    var BatchJobExecutionHistory = { name : 'BatchJobExecutionHistory', url : '/batch-job-execution-history', templateUrl : 'content/batch-job-execution-history', controller : 'BatchJobExecutionHistoryController', controllerAs : 'ctrl' };
    var ExaminationMailTransmissionExamVoucher = { name : 'ExaminationMailTransmissionExamVoucher', url : '/examination-mail-transmission-exam-voucher', templateUrl : 'content/examination-mail-transmission-exam-voucher', controller : 'ExaminationMailTransmissionExamVoucherController', controllerAs : 'ctrl' };
    var OperatorList = { name : 'OperatorList', url : '/operator-list', templateUrl : 'content/operator-list', controller : 'OperatorListController', controllerAs : 'ctrl' };
    var OperatorRegistration = { name : 'OperatorRegistration', url : '/operator-registration', templateUrl : 'content/operator-registration', controller : 'OperatorRegistrationController', controllerAs : 'ctrl' };
    var MailDistributionList = { name : 'MailDistributionList', url : '/mail-distribution-list', templateUrl : 'content/mail-distribution-list', controller : 'MailDistributionListController', controllerAs : 'ctrl' };
    var MailDeliveryRegistration = { name : 'MailDeliveryRegistration', url : '/mail-delivery-registration', templateUrl : 'content/mail-delivery-registration', controller : 'MailDeliveryRegistrationController', controllerAs : 'ctrl' };
    var NoticeList = { name : 'NoticeList', url : '/notice-list', templateUrl : 'content/notice-list', controller : 'NoticeListController', controllerAs : 'ctrl' };
    var NoticeRegistration = { name : 'NoticeRegistration', url : '/notice-registration', templateUrl : 'content/notice-registration', controller : 'NoticeRegistrationController', controllerAs : 'ctrl' };
    $stateProvider.state('index', {
      url: '/',
      templateUrl: 'content/dashboard',
      controller: 'DashboardController',
      controllerAs: 'ctrl'
    })
    .state(ImplementsReference)
    .state(MemberInformationSearch)
    .state(PersonalInformationChangeRequest)
    .state(DuplicateSamePerson)
    .state(ExamScheduleGanttChart)
    .state(ExamRelated)
    .state(ExamVoucherPassRejection)
    .state(SystemRelatedList)
    .state(ExamLocationManagement)
    .state(FacePhotographs)
    .state(FacePhotographsConfirmation)
    .state(ImportRatingAverage)
    .state(ExaminationNumberTemporaryProcess)
    .state(ExaminationNumberBooking)
    .state(ExaminationNumberReservationCancellation)
    .state(ExamineeReport)
    .state(AcceptanceImportPassRejection)
    .state(ExaminationNumberNumberingParameter)
    .state(ExaminationNumberCancellation)
    .state(PracticalExaminationNumberManagement)
    .state(DailySchedule)
    .state(ApplicantPreliminaryReport)
    .state(ChangeLog)
    .state(AcceptanceReport)
    .state(ProcessingStatusReport)
    .state(PaymentAndDocumentArrived)
    .state(DocumentConfirmation)
    .state(BatchJobExecutionHistory)
    .state(ExaminationMailTransmissionExamVoucher)
    .state(OperatorList)
    .state(OperatorRegistration)
    .state(MailDistributionList)
    .state(MailDeliveryRegistration)
    .state(NoticeList)
    .state(NoticeRegistration);
  }
]);