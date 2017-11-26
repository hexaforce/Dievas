'use strict';
/*******************************************************************************
 * Restaangulr customize setting see also >>
 * https://github.com/mgonto/restangular#configuring-in-the-config
 ******************************************************************************/
app.config(function (RestangularProvider) {
  // BaseUrl
  RestangularProvider.setBaseUrl('/rest');
  // Request interceptor.
  RestangularProvider.setFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {
	  console.log('[Request] Restangular:' + operation + ' URL:' + url);
    return {
      element: element,
      params: params,
      headers: headers,
      httpConfig: httpConfig
    };
  });
  // Response interceptor.
  RestangularProvider.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
	  console.log('[Response] Restangular:' + operation + ' URL:' + url + '(' + response.config.method + ')' + ' response:' + response.status + '(' + response.statusText + ') xhr:' + response.xhrStatus);
    return response.data.content;
  });
});
/******************************************************************************
 * Dievas implement REST
 ******************************************************************************/
app.factory('AdminUser', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {
    RestangularConfigurer.setBaseUrl('/api');
  }).service('admin_user');
}]);
/******************************************************************************
 * Spring Data REST
 ******************************************************************************/
app.factory('AdminUser', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('admin_user');
}]).factory('Application', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application');
}]).factory('ApplicationConfig', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_config');
}]).factory('ApplicationDefect', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_defect');
}]).factory('ApplicationExam', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_exam');
}]).factory('ApplicationGradePoint', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_grade_point');
}]).factory('ApplicationNoConfig', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_no_config');
}]).factory('ApplicationNpsForm', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_nps_form');
}]).factory('ApplicationUserDefect', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_user_defect');
}]).factory('ApplicationUserProfile', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_user_profile');
}]).factory('ApplicationUserSurveyAnswer', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('application_user_survey_answer');
}]).factory('BatchJobCondition', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('batch_job_condition');
}]).factory('BatchJobHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('batch_job_history');
}]).factory('Cart', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('cart');
}]).factory('CartExam', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('cart_exam');
}]).factory('CartUserProfile', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('cart_user_profile');
}]).factory('CartUserSurveyAnswer', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('cart_user_survey_answer');
}]).factory('Course', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('course');
}]).factory('CsvExport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('csv_export');
}]).factory('CsvExportHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('csv_export_history');
}]).factory('CsvImport', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('csv_import');
}]).factory('CsvImportHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('csv_import_history');
}]).factory('Department', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('department');
}]).factory('DesignatedHighSchool', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('designated_high_school');
}]).factory('Division', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('division');
}]).factory('DualApplicationsAdvisability', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('dual_applications_advisability');
}]).factory('Exam', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam');
}]).factory('ExamCategory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_category');
}]).factory('ExamDate', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_date');
}]).factory('ExamDateDetail', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_date_detail');
}]).factory('ExamFee', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_fee');
}]).factory('ExamineesNumber', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('examinees_number');
}]).factory('ExamineesNumberIssueParamater', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('examinees_number_issue_paramater');
}]).factory('ExamineesTicket', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('examinees_ticket');
}]).factory('ExamInitial', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_initial');
}]).factory('ExamPropForm', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_prop_form');
}]).factory('ExamPropInput', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_prop_input');
}]).factory('ExamPropOption', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_prop_option');
}]).factory('ExamResult', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_result');
}]).factory('ExamSite', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_site');
}]).factory('ExamSubject', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_subject');
}]).factory('ExamType', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('exam_type');
}]).factory('FreeItem', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('free_item');
}]).factory('FreudeChangelog', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('freude_changelog');
}]).factory('HighSchool', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('high_school');
}]).factory('HighSchoolBranch', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('high_school_branch');
}]).factory('HighSchoolCourse', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('high_school_course');
}]).factory('Information', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('information');
}]).factory('Inquiry', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('inquiry');
}]).factory('InterimUser', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('interim_user');
}]).factory('InterimUserEdit', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('interim_user_edit');
}]).factory('LogOutputHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('log_output_history');
}]).factory('MailApiLog', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('mail_api_log');
}]).factory('MailMagazine', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('mail_magazine');
}]).factory('MailTemplate', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('mail_template');
}]).factory('ModifiedApplication', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_application');
}]).factory('ModifiedApplicationExam', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_application_exam');
}]).factory('ModifiedHistory', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_history');
}]).factory('ModifiedPayment', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_payment');
}]).factory('ModifiedReasen', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_reasen');
}]).factory('ModifiedTerm', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_term');
}]).factory('ModifiedUserProfile', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_user_profile');
}]).factory('ModifiedUserSurveyAnswer', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('modified_user_survey_answer');
}]).factory('Module', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('module');
}]).factory('NpsApiLog', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('nps_api_log');
}]).factory('Operator', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('operator');
}]).factory('OperatorRole', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('operator_role');
}]).factory('PageMessage', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('page_message');
}]).factory('ParentRelation', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('parent_relation');
}]).factory('Payment', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('payment');
}]).factory('PaymentCanceled', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('payment_canceled');
}]).factory('PaymentLog', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('payment_log');
}]).factory('PaymentMethod', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('payment_method');
}]).factory('Permission', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('permission');
}]).factory('Postcode', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('postcode');
}]).factory('PracticalExamineesNumber', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('practical_examinees_number');
}]).factory('Prefecture', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('prefecture');
}]).factory('Role', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('role');
}]).factory('RolePermission', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('role_permission');
}]).factory('Site', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('site');
}]).factory('Subject', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('subject');
}]).factory('Survey', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('survey');
}]).factory('SurveyOption', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('survey_option');
}]).factory('University', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('university');
}]).factory('User', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('user');
}]).factory('UserProfile', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('user_profile');
}]).factory('UserProfileReflectionRequest', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('user_profile_reflection_request');
}]).factory('UserSurveyAnswer', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('user_survey_answer');
}]).factory('ValidationRule', ['Restangular', function (Restangular) {
  return Restangular.withConfig(function (RestangularConfigurer) {}).service('validation_rule');
}]);