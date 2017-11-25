'use strict';
/*******************************************************************************
 * UI-Router routing template configuration see also >>
 * https://github.com/angular-ui/ui-router/wiki see also >>
 * https://ui-router.github.io/ng1/docs/latest/modules/injectables.html#_stateprovider
 ******************************************************************************/
app.config(['$stateProvider', '$urlRouterProvider',
  function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    var ApplicationCsvExport = {
      name: 'ApplicationCsvExport',
      url: '/application-csv-export',
      templateUrl: 'content/application-csv-export',
      controller: 'ApplicationCsvExportController',
      controllerAs: 'ctrl'
    };
    var ApplicationDailySummaryExport = {
      name: 'ApplicationDailySummaryExport',
      url: '/application-daily-summary-export',
      templateUrl: 'content/application-daily-summary-export',
      controller: 'ApplicationDailySummaryExportController',
      controllerAs: 'ctrl'
    };
    var ApplicationDefectExport = {
      name: 'ApplicationDefectExport',
      url: '/application-defect-export',
      templateUrl: 'content/application-defect-export',
      controller: 'ApplicationDefectExportController',
      controllerAs: 'ctrl'
    };
    var ApplicationHandicappedOrNotNumberedExport = {
      name: 'ApplicationHandicappedOrNotNumberedExport',
      url: '/application-handicapped-or-not-numbered-export',
      templateUrl: 'content/application-handicapped-or-not-numbered-export',
      controller: 'ApplicationHandicappedOrNotNumberedExportController',
      controllerAs: 'ctrl'
    };
    var ApplicationPreliminaryExport = {
      name: 'ApplicationPreliminaryExport',
      url: '/application-preliminary-export',
      templateUrl: 'content/application-preliminary-export',
      controller: 'ApplicationPreliminaryExportController',
      controllerAs: 'ctrl'
    };
    var BatchJobHistory = {
      name: 'BatchJobHistory',
      url: '/batch-job-history',
      templateUrl: 'content/batch-job-history',
      controller: 'BatchJobHistoryController',
      controllerAs: 'ctrl'
    };
    var ChangeLog = {
      name: 'ChangeLog',
      url: '/change-log',
      templateUrl: 'content/change-log',
      controller: 'ChangeLogController',
      controllerAs: 'ctrl'
    };
    var CsvImport = {
      name: 'CsvImport',
      url: '/csv-import',
      templateUrl: 'content/csv-import',
      controller: 'CsvImportController',
      controllerAs: 'ctrl'
    };
    var Dashboard = {
      name: 'Dashboard',
      url: '/dashboard',
      templateUrl: 'content/dashboard',
      controller: 'DashboardController',
      controllerAs: 'ctrl'
    };
    var ExamDateGantt = {
      name: 'ExamDateGantt',
      url: '/exam-date-gantt',
      templateUrl: 'content/exam-date-gantt',
      controller: 'ExamDateGanttController',
      controllerAs: 'ctrl'
    };
    var ExamDateList = {
      name: 'ExamDateList',
      url: '/exam-date-list',
      templateUrl: 'content/exam-date-list',
      controller: 'ExamDateListController',
      controllerAs: 'ctrl'
    };
    var ExamDateSystem = {
      name: 'ExamDateSystem',
      url: '/exam-date-system',
      templateUrl: 'content/exam-date-system',
      controller: 'ExamDateSystemController',
      controllerAs: 'ctrl'
    };
    var ExamDateTicketResult = {
      name: 'ExamDateTicketResult',
      url: '/exam-date-ticket-result',
      templateUrl: 'content/exam-date-ticket-result',
      controller: 'ExamDateTicketResultController',
      controllerAs: 'ctrl'
    };
    var ExamPlaceCapacitiesEdit = {
      name: 'ExamPlaceCapacitiesEdit',
      url: '/exam-place-capacities-edit',
      templateUrl: 'content/exam-place-capacities-edit',
      controller: 'ExamPlaceCapacitiesEditController',
      controllerAs: 'ctrl'
    };
    var ExamPlaceCapacitiesList = {
      name: 'ExamPlaceCapacitiesList',
      url: '/exam-place-capacities-list',
      templateUrl: 'content/exam-place-capacities-list',
      controller: 'ExamPlaceCapacitiesListController',
      controllerAs: 'ctrl'
    };
    var ExamResult = {
      name: 'ExamResult',
      url: '/exam-result',
      templateUrl: 'content/exam-result',
      controller: 'ExamResultController',
      controllerAs: 'ctrl'
    };
    var ExamineesNumberedMail = {
      name: 'ExamineesNumberedMail',
      url: '/examinees-numbered-mail',
      templateUrl: 'content/examinees-numbered-mail',
      controller: 'ExamineesNumberedMailController',
      controllerAs: 'ctrl'
    };
    var ExamineesNumbering = {
      name: 'ExamineesNumbering',
      url: '/examinees-numbering',
      templateUrl: 'content/examinees-numbering',
      controller: 'ExamineesNumberingController',
      controllerAs: 'ctrl'
    };
    var ExamineesReservation = {
      name: 'ExamineesReservation',
      url: '/examinees-reservation',
      templateUrl: 'content/examinees-reservation',
      controller: 'ExamineesReservationController',
      controllerAs: 'ctrl'
    };
    var GpaCsvExport = {
      name: 'GpaCsvExport',
      url: '/gpa-csv-export',
      templateUrl: 'content/gpa-csv-export',
      controller: 'GpaCsvExportController',
      controllerAs: 'ctrl'
    };
    var InformationAdd = {
      name: 'InformationAdd',
      url: '/information-add',
      templateUrl: 'content/information-add',
      controller: 'InformationAddController',
      controllerAs: 'ctrl'
    };
    var InformationEdit = {
      name: 'InformationEdit',
      url: '/information-edit',
      templateUrl: 'content/information-edit',
      controller: 'InformationEditController',
      controllerAs: 'ctrl'
    };
    var Information = {
      name: 'Information',
      url: '/information',
      templateUrl: 'content/information',
      controller: 'InformationController',
      controllerAs: 'ctrl'
    };
    var Informations = {
      name: 'Informations',
      url: '/informations',
      templateUrl: 'content/informations',
      controller: 'InformationsController',
      controllerAs: 'ctrl'
    };
    var MailMagazineAdd = {
      name: 'MailMagazineAdd',
      url: '/mail-magazine-add',
      templateUrl: 'content/mail-magazine-add',
      controller: 'MailMagazineAddController',
      controllerAs: 'ctrl'
    };
    var MailMagazineEdit = {
      name: 'MailMagazineEdit',
      url: '/mail-magazine-edit',
      templateUrl: 'content/mail-magazine-edit',
      controller: 'MailMagazineEditController',
      controllerAs: 'ctrl'
    };
    var MailMagazineList = {
      name: 'MailMagazineList',
      url: '/mail-magazine-list',
      templateUrl: 'content/mail-magazine-list',
      controller: 'MailMagazineListController',
      controllerAs: 'ctrl'
    };
    var MailMagazine = {
      name: 'MailMagazine',
      url: '/mail-magazine',
      templateUrl: 'content/mail-magazine',
      controller: 'MailMagazineController',
      controllerAs: 'ctrl'
    };
    var OperatorAdd = {
      name: 'OperatorAdd',
      url: '/operator-add',
      templateUrl: 'content/operator-add',
      controller: 'OperatorAddController',
      controllerAs: 'ctrl'
    };
    var OperatorEdit = {
      name: 'OperatorEdit',
      url: '/operator-edit',
      templateUrl: 'content/operator-edit',
      controller: 'OperatorEditController',
      controllerAs: 'ctrl'
    };
    var Operator = {
      name: 'Operator',
      url: '/operator',
      templateUrl: 'content/operator',
      controller: 'OperatorController',
      controllerAs: 'ctrl'
    };
    var Operators = {
      name: 'Operators',
      url: '/operators',
      templateUrl: 'content/operators',
      controller: 'OperatorsController',
      controllerAs: 'ctrl'
    };
    var PasswordEdit = {
      name: 'PasswordEdit',
      url: '/password-edit',
      templateUrl: 'content/password-edit',
      controller: 'PasswordEditController',
      controllerAs: 'ctrl'
    };
    var PaymentConfirmation = {
      name: 'PaymentConfirmation',
      url: '/payment-confirmation',
      templateUrl: 'content/payment-confirmation',
      controller: 'PaymentConfirmationController',
      controllerAs: 'ctrl'
    };
    var PhotosConfirmationPdfExport = {
      name: 'PhotosConfirmationPdfExport',
      url: '/photos-confirmation-pdf-export',
      templateUrl: 'content/photos-confirmation-pdf-export',
      controller: 'PhotosConfirmationPdfExportController',
      controllerAs: 'ctrl'
    };
    var PhotosPdfExport = {
      name: 'PhotosPdfExport',
      url: '/photos-pdf-export',
      templateUrl: 'content/photos-pdf-export',
      controller: 'PhotosPdfExportController',
      controllerAs: 'ctrl'
    };
    var ReportProcessingResult = {
      name: 'ReportProcessingResult',
      url: '/report-processing-result',
      templateUrl: 'content/report-processing-result',
      controller: 'ReportProcessingResultController',
      controllerAs: 'ctrl'
    };
    var ReportProcessingStatus = {
      name: 'ReportProcessingStatus',
      url: '/report-processing-status',
      templateUrl: 'content/report-processing-status',
      controller: 'ReportProcessingStatusController',
      controllerAs: 'ctrl'
    };
    var ReportReceivedTotal = {
      name: 'ReportReceivedTotal',
      url: '/report-received-total',
      templateUrl: 'content/report-received-total',
      controller: 'ReportReceivedTotalController',
      controllerAs: 'ctrl'
    };
    var TicketCheck = {
      name: 'TicketCheck',
      url: '/ticket-check',
      templateUrl: 'content/ticket-check',
      controller: 'TicketCheckController',
      controllerAs: 'ctrl'
    };
    var TicketMail = {
      name: 'TicketMail',
      url: '/ticket-mail',
      templateUrl: 'content/ticket-mail',
      controller: 'TicketMailController',
      controllerAs: 'ctrl'
    };
    var UserApplicationModification = {
      name: 'UserApplicationModification',
      url: '/user-application-modification',
      templateUrl: 'content/user-application-modification',
      controller: 'UserApplicationModificationController',
      controllerAs: 'ctrl'
    };
    var UserEdit = {
      name: 'UserEdit',
      url: '/user-edit',
      templateUrl: 'content/user-edit',
      controller: 'UserEditController',
      controllerAs: 'ctrl'
    };
    var UserModificationComparison = {
      name: 'UserModificationComparison',
      url: '/user-modification-comparison',
      templateUrl: 'content/user-modification-comparison',
      controller: 'UserModificationComparisonController',
      controllerAs: 'ctrl'
    };
    var UserModifications = {
      name: 'UserModifications',
      url: '/user-modifications',
      templateUrl: 'content/user-modifications',
      controller: 'UserModificationsController',
      controllerAs: 'ctrl'
    };
    var UserSameExport = {
      name: 'UserSameExport',
      url: '/user-same-export',
      templateUrl: 'content/user-same-export',
      controller: 'UserSameExportController',
      controllerAs: 'ctrl'
    };
    var UserSearch = {
      name: 'UserSearch',
      url: '/user-search',
      templateUrl: 'content/user-search',
      controller: 'UserSearchController',
      controllerAs: 'ctrl'
    };
    var User = {
      name: 'User',
      url: '/user',
      templateUrl: 'content/user',
      controller: 'UserController',
      controllerAs: 'ctrl'
    };
    var Users = {
      name: 'Users',
      url: '/users',
      templateUrl: 'content/users',
      controller: 'UsersController',
      controllerAs: 'ctrl'
    };
    $stateProvider.state('index', {
      url: '/',
      templateUrl: 'content/dashboard',
      controller: 'UserController',
      controllerAs: 'ctrl'
    }).state(ApplicationCsvExport).state(ApplicationDailySummaryExport).state(ApplicationDefectExport).state(ApplicationHandicappedOrNotNumberedExport).state(ApplicationPreliminaryExport).state(BatchJobHistory).state(ChangeLog).state(CsvImport).state(Dashboard).state(ExamDateGantt).state(ExamDateList).state(ExamDateSystem).state(ExamDateTicketResult).state(ExamPlaceCapacitiesEdit).state(ExamPlaceCapacitiesList).state(ExamResult).state(ExamineesNumberedMail).state(ExamineesNumbering).state(ExamineesReservation).state(GpaCsvExport).state(InformationAdd).state(InformationEdit).state(Information).state(Informations).state(MailMagazineAdd).state(MailMagazineEdit).state(MailMagazineList).state(MailMagazine).state(OperatorAdd).state(OperatorEdit).state(Operator).state(Operators).state(PasswordEdit).state(PaymentConfirmation).state(PhotosConfirmationPdfExport).state(PhotosPdfExport).state(ReportProcessingResult).state(ReportProcessingStatus).state(ReportReceivedTotal).state(TicketCheck).state(TicketMail).state(UserApplicationModification).state(UserEdit).state(UserModificationComparison).state(UserModifications).state(UserSameExport).state(UserSearch).state(User).state(Users);
  }
]);