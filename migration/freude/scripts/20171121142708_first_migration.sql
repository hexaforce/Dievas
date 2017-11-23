--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // First migration.
-- Migration SQL that makes the change goes here.

CREATE TABLE `admin_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '楽観ロック用。初期値0から更新毎にインクリメント。',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `email` varchar(256) NOT NULL COMMENT 'メールアドレス',
  `password` varchar(200) NOT NULL COMMENT 'パスワード（ダイジェスト）',
  `name` varchar(200) NOT NULL COMMENT '名前',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理ユーザー';

CREATE TABLE `application` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `application_no` varchar(200) DEFAULT NULL COMMENT '出願受付番号',
  `reference_number` varchar(100) NOT NULL COMMENT '整理番号',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT '試験種別ID',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `cart_id` int(11) NOT NULL COMMENT 'カートID',
  `management_status` char(4) NOT NULL COMMENT '管理ステータス（0100：出願済み（入金前）　0200：志願済み（入金後）　0300：書類確認中　0400：不備なし　0500：仮付番済み　0600：受験番号付番済み）',
  `applied_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出願日時',
  `total_fee` bigint(20) unsigned NOT NULL COMMENT 'この出願の受験料合計額',
  `gpa` varchar(200) DEFAULT NULL COMMENT '評定平均値',
  `ticket_issued_at` datetime DEFAULT NULL COMMENT '受験票発行日付',
  `csv_exported` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未出力(新規)、1:出力済み、2:変更有り',
  `paid` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '1:支払い済み、0:支払い待ち、9:キャンセル',
  `examinees_number_issued` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '（1:受験番号付番済み 0：未付番 9：付番除外）',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽専修実技区分',
  `specific_license_code` tinyint(3) unsigned DEFAULT NULL COMMENT '特定資格コード',
  `handicapped_person_code` varchar(200) DEFAULT NULL COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `disaster_victim_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:被災者受験特別措置',
  `high_school_notification_consented` tinyint(1) unsigned DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  PRIMARY KEY (`id`),
  KEY `application_index01` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=881004 DEFAULT CHARSET=utf8 COMMENT='出願';
CREATE TABLE `application_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT '名前',
  `value` text NOT NULL COMMENT '値',
  `description` text NOT NULL COMMENT 'この値の説明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='アプリケーション設定';
CREATE TABLE `application_defect` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `application_id` int(11) unsigned NOT NULL COMMENT '出願ID',
  `defect_id` int(11) unsigned NOT NULL COMMENT '出願者不備番号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='出願不備';
CREATE TABLE `application_exam` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `application_id` int(11) unsigned NOT NULL COMMENT 'application.id',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `examinees_number` varchar(200) DEFAULT NULL COMMENT '受験番号',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT 'exam_type.id',
  `exam_type_external_code` varchar(100) NOT NULL COMMENT 'exam_type.external_code',
  `department_id` int(11) unsigned DEFAULT NULL COMMENT 'department.id',
  `department_external_code` varchar(100) DEFAULT NULL COMMENT 'department.external_code',
  `division_id` int(11) unsigned DEFAULT NULL COMMENT 'division.id',
  `division_external_code` varchar(100) DEFAULT NULL COMMENT 'division.external_code',
  `course_id` int(11) unsigned DEFAULT NULL COMMENT 'course.id',
  `course_external_code` varchar(100) DEFAULT NULL COMMENT 'course.external_code',
  `picked_form_code` varchar(100) DEFAULT NULL COMMENT '選抜区分コード',
  `selected_course_code` varchar(100) DEFAULT NULL COMMENT '選択科目コード',
  `exam_result` tinyint(3) unsigned DEFAULT NULL COMMENT '合否結果コード',
  `gpa_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未評価、1:評定OK、2:評定NG',
  `site_id` int(11) unsigned NOT NULL COMMENT 'site.id',
  `practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '実技コード',
  `practical_exam_number` int(4) unsigned DEFAULT NULL COMMENT '実技試験番号',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽実技区分',
  `musical_grammar_code` tinyint(3) unsigned DEFAULT NULL COMMENT '楽典選択',
  `examinees_number_mail_sent` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '受験番号メール通知',
  PRIMARY KEY (`id`),
  KEY `application_exam_index01` (`application_id`)
) ENGINE=InnoDB AUTO_INCREMENT=880998 DEFAULT CHARSET=utf8 COMMENT='出願試験';
CREATE TABLE `application_grade_point` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `application_id` int(11) unsigned NOT NULL COMMENT '出願ID',
  `orderNo` int(11) NOT NULL COMMENT '順',
  `course_name` varchar(200) NOT NULL COMMENT '科目名',
  `gp` varchar(200) NOT NULL COMMENT '成績評価点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=906 DEFAULT CHARSET=utf8 COMMENT='出願評定';
CREATE TABLE `application_no_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `exam_type_id` int(11) unsigned DEFAULT NULL COMMENT '入試種別ID',
  `site_id` int(11) unsigned DEFAULT NULL COMMENT '試験会場ID',
  `min_application_no` varchar(200) NOT NULL COMMENT '受付番号最小値',
  `max_application_no` varchar(200) NOT NULL COMMENT '受付番号最大値',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
CREATE TABLE `application_nps_form` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `cart_id` int(11) unsigned NOT NULL COMMENT 'カートID',
  `application_id` int(11) unsigned DEFAULT NULL COMMENT '出願ID',
  `user_id` int(11) unsigned DEFAULT NULL COMMENT 'ユーザーID',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:予約実行中、10:予約結果OK、11:予約結果NG、20:登録状況確認中、21:登録状況確認結果OK、22:登録状況確認結果NG''、30:削除中、31:削除結果OK、32:削除結果NG',
  `expires_at` datetime DEFAULT NULL COMMENT 'ファイル有効期限',
  `store` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0:セブンイレブン、1:サークルKサンクス、2:セイコーマート、3:FamilyMart、4:LAWSON',
  `auth_token` varchar(200) DEFAULT NULL COMMENT '（シャープ）認証トークン',
  `user_code` varchar(200) DEFAULT NULL COMMENT '（シャープ）ユーザー番号',
  `file_id` varchar(200) DEFAULT NULL COMMENT '（シャープ）ファイル識別子',
  `auth_user` varchar(200) DEFAULT NULL COMMENT '（ゼロックス）認証ユーザー',
  `session_id` varchar(200) DEFAULT NULL COMMENT '（ゼロックス）WEBサービスセッションID',
  `accessKey` varchar(200) DEFAULT NULL COMMENT '（ゼロックス）アクセスキー',
  `file_location` varchar(200) DEFAULT NULL COMMENT 'ファイルロケーション',
  `form_types` varchar(200) DEFAULT NULL COMMENT '選択帳票（カンマ区切りで選択した帳票を保持する。1:宛名ラベル、2:受験票、3:志願票、4:コンビニ払込票、5:支払手順書）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='出願ネットプリント帳票';
CREATE TABLE `application_user_defect` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `defect_id` int(11) unsigned NOT NULL COMMENT '出願ユーザー不備番号',
  `defect_level_type` tinyint(3) unsigned NOT NULL COMMENT '出願ユーザー不備レベルタイプ 1:Error、2:Warning',
  `defect_content` varchar(400) DEFAULT NULL COMMENT '出願ユーザー不備内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出願ユーザー不備';
CREATE TABLE `application_user_profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '楽観ロック用。初期値0から更新毎にインクリメント。',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `cart_id` int(11) NOT NULL COMMENT 'カートID',
  `management_status` char(4) NOT NULL COMMENT '管理ステータス（0100：出願済み（入金前）　0200：志願済み（入金後）　0300：書類確認中　0400：不備なし　0500：仮付番済み　0600：受験番号付番済み　0700：受験生データ出力済み）',
  `first_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名）',
  `first_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・カナ）',
  `first_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・英字）',
  `last_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓）',
  `last_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・カナ）',
  `last_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・英字）',
  `middle_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（ミドルネーム）',
  `birthday` date DEFAULT NULL COMMENT '生年月日',
  `gender` tinyint(3) DEFAULT NULL COMMENT '性別、0:女性、1:男性、2:その他',
  `country_code` char(2) NOT NULL COMMENT '志願者住所（国コード・ISO 3166-1・alpha-2）',
  `postcode` varchar(7) DEFAULT NULL COMMENT '志願者住所（郵便番号）',
  `prefecture_code` char(2) DEFAULT NULL COMMENT '志願者住所（都道府県コード）',
  `prefecture` varchar(200) DEFAULT NULL COMMENT '志願者住所（都道府県名・海外用）',
  `municipality` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村）',
  `municipality_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村カナ）',
  `town_area` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地）',
  `town_area_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地カナ）',
  `building` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名）',
  `building_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名カナ）',
  `care_of_address` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方）',
  `care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方カナ）',
  `phone` varchar(200) DEFAULT NULL COMMENT '志願者自宅電話番号',
  `mobile_phone` varchar(200) DEFAULT NULL COMMENT '志願者携帯電話番号',
  `high_school_code` char(6) DEFAULT NULL COMMENT '出身高校コード',
  `high_school_course_code` tinyint(3) DEFAULT NULL COMMENT '出身高校課程コード（1:全日制、2:定時制、3:通信制、4:その他）',
  `high_school_branch_code` tinyint(3) DEFAULT NULL COMMENT '出身高校学科コード（1:普通科、2:商業科、3:工学科、4:その他）',
  `high_school_graduated_year_month` char(6) DEFAULT NULL COMMENT '出身高校卒業年月',
  `high_school_notification_consented` tinyint(1) DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  `cram_school_code` varchar(200) DEFAULT NULL COMMENT '在籍予備校',
  `cram_school_notification_consented` tinyint(1) DEFAULT '0' COMMENT '在籍予備校への入試結果通知同意フラグ',
  `center_score_request_number` varchar(45) DEFAULT NULL COMMENT 'センター試験成績請求番号',
  `parent_first_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字名）',
  `parent_first_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ名）',
  `parent_first_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字名）',
  `parent_last_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字姓）',
  `parent_last_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ姓）',
  `parent_last_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字姓）',
  `parent_postcode` varchar(7) DEFAULT NULL COMMENT '保護者住所（郵便番号）',
  `parent_prefecture_code` char(2) DEFAULT NULL COMMENT '保護者住所（都道府県コード）',
  `parent_municipality` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村）',
  `parent_municipality_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村カナ）',
  `parent_town_area` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地）',
  `parent_town_area_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地カナ）',
  `parent_building` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名）',
  `parent_building_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名カナ）',
  `parent_care_of_address` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方）',
  `parent_care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方カナ）',
  `parent_relation` varchar(200) DEFAULT NULL COMMENT '志願者との続柄',
  `parent_phone` varchar(200) DEFAULT NULL COMMENT '保護者自宅電話番号',
  `parent_mobile_phone` varchar(200) DEFAULT NULL COMMENT '保護者携帯電話番号',
  `university_belonged` tinyint(3) unsigned DEFAULT NULL COMMENT '所属大学フラグ',
  `university_code` varchar(200) DEFAULT NULL COMMENT '大学コード',
  `university_graduated_year_month` char(6) DEFAULT NULL COMMENT '大学卒業年月',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `handicapped_person_code` varchar(200) DEFAULT NULL COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `disaster_victim_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:被災者受験特別措置',
  `portrait_file_name` varchar(200) DEFAULT NULL COMMENT '顔写真ファイル名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cart_id` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1175 DEFAULT CHARSET=utf8 COMMENT='出願ユーザープロフィール';
CREATE TABLE `application_user_survey_answer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `survey_id` int(11) unsigned NOT NULL COMMENT 'アンケートID',
  `answer` text NOT NULL COMMENT '回答',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='出願ユーザーアンケート回答';
CREATE TABLE `batch_job_condition` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `batch_job_history_id` int(11) unsigned NOT NULL COMMENT 'バッチジョブ実行履歴ID',
  `name` text NOT NULL COMMENT '実行条件項目名',
  `value` text NOT NULL COMMENT '実行条件コード',
  `display_text` text NOT NULL COMMENT '実行条件表示名',
  PRIMARY KEY (`id`),
  KEY `batch_job_condition_batch_job_history_id_idx` (`batch_job_history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8 COMMENT='バッチジョブ実行条件';
CREATE TABLE `batch_job_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `batch_name` varchar(200) NOT NULL COMMENT 'バッチ名',
  `batch_status_type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT 'バッチステータス（1:受付 2：実行中 3：正常終了 4：正常終了（対象なし） 5：異常終了 6：キャンセル）',
  `success_count` int(10) unsigned DEFAULT '0' COMMENT '成功件数',
  `failed_count` int(10) unsigned DEFAULT '0' COMMENT '失敗件数',
  `received_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '受付日時',
  `exam_category_id` int(11) unsigned DEFAULT NULL COMMENT '試験カテゴリーID',
  `received_operator_id` int(11) unsigned DEFAULT NULL COMMENT '受付オペレーターID',
  `started_at` datetime DEFAULT NULL COMMENT '実行開始日時',
  `ended_at` datetime DEFAULT NULL COMMENT '実行終了日時',
  `location` varchar(400) NOT NULL COMMENT 'S3のロケーション',
  `original_name` varchar(400) NOT NULL COMMENT '元のファイル名',
  `file_key` varchar(200) NOT NULL COMMENT '一意なファイルのキー',
  PRIMARY KEY (`id`),
  KEY `batch_job_history_batch_name_idx` (`batch_name`)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8 COMMENT='バッチジョブ実行履歴';
CREATE TABLE `cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `total_fee` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'この出願の受験料合計額',
  PRIMARY KEY (`id`),
  KEY `cart_index01` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1309 DEFAULT CHARSET=utf8 COMMENT='出願';
CREATE TABLE `cart_exam` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `cart_id` int(11) unsigned NOT NULL COMMENT 'cart.id',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT 'exam_type.id',
  `exam_type_external_code` varchar(100) NOT NULL COMMENT 'exam_type.external_code',
  `department_id` int(11) unsigned DEFAULT NULL COMMENT 'department.id',
  `department_external_code` varchar(100) DEFAULT NULL COMMENT 'department.external_code',
  `division_id` int(11) unsigned DEFAULT NULL COMMENT 'division.id',
  `division_external_code` varchar(100) DEFAULT NULL COMMENT 'division.external_code',
  `course_id` int(11) unsigned DEFAULT NULL COMMENT 'course.id',
  `course_external_code` varchar(100) DEFAULT NULL COMMENT 'course.external_code',
  `picked_form_code` varchar(100) DEFAULT NULL COMMENT '選抜区分コード',
  `selected_course_code` varchar(100) DEFAULT NULL COMMENT '選択科目コード',
  `site_id` int(11) unsigned NOT NULL COMMENT 'site.id',
  `practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '実技コード',
  `practical_exam_number` int(11) unsigned DEFAULT NULL COMMENT '実技試験番号',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽実技区分',
  `musical_grammar_code` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cart_id` (`cart_id`,`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2268 DEFAULT CHARSET=utf8 COMMENT='出願試験';
CREATE TABLE `cart_user_profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '楽観ロック用。初期値0から更新毎にインクリメント。',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `cart_id` int(11) unsigned NOT NULL COMMENT 'cart.id',
  `first_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名）',
  `first_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・カナ）',
  `first_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・英字）',
  `last_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓）',
  `last_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・カナ）',
  `last_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・英字）',
  `middle_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（ミドルネーム）',
  `birthday` date DEFAULT NULL COMMENT '生年月日',
  `gender` tinyint(3) DEFAULT NULL COMMENT '性別、0:女性、1:男性、2:その他',
  `country_code` char(2) NOT NULL COMMENT '志願者住所（国コード・ISO 3166-1・alpha-2）',
  `postcode` varchar(7) DEFAULT NULL COMMENT '志願者住所（郵便番号）',
  `prefecture_code` char(2) DEFAULT NULL COMMENT '志願者住所（都道府県コード）',
  `prefecture` varchar(200) DEFAULT NULL COMMENT '志願者住所（都道府県名・海外用）',
  `municipality` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村）',
  `municipality_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村カナ）',
  `town_area` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地）',
  `town_area_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地カナ）',
  `building` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名）',
  `building_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名カナ）',
  `care_of_address` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方）',
  `care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方カナ）',
  `phone` varchar(200) DEFAULT NULL COMMENT '志願者自宅電話番号',
  `mobile_phone` varchar(200) DEFAULT NULL COMMENT '志願者携帯電話番号',
  `high_school_code` char(6) DEFAULT NULL COMMENT '出身高校コード',
  `high_school_course_code` tinyint(3) DEFAULT NULL COMMENT '出身高校課程コード（1:全日制、2:定時制、3:通信制、4:その他）',
  `high_school_branch_code` tinyint(3) DEFAULT NULL COMMENT '出身高校学科コード（1:普通科、2:商業科、3:工学科、4:その他）',
  `high_school_graduated_year_month` char(6) DEFAULT NULL COMMENT '出身高校卒業年月',
  `high_school_notification_consented` tinyint(1) DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  `cram_school_code` varchar(200) DEFAULT NULL COMMENT '在籍予備校',
  `cram_school_notification_consented` tinyint(1) DEFAULT '0' COMMENT '在籍予備校への入試結果通知同意フラグ',
  `center_score_request_number` varchar(45) DEFAULT NULL COMMENT 'センター試験成績請求番号',
  `parent_first_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字名）',
  `parent_first_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ名）',
  `parent_first_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字名）',
  `parent_last_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字姓）',
  `parent_last_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ姓）',
  `parent_last_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字姓）',
  `parent_postcode` varchar(7) DEFAULT NULL COMMENT '保護者住所（郵便番号）',
  `parent_prefecture_code` char(2) DEFAULT NULL COMMENT '保護者住所（都道府県コード）',
  `parent_municipality` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村）',
  `parent_municipality_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村カナ）',
  `parent_town_area` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地）',
  `parent_town_area_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地カナ）',
  `parent_building` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名）',
  `parent_building_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名カナ）',
  `parent_care_of_address` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方）',
  `parent_care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方カナ）',
  `parent_relation` varchar(200) DEFAULT NULL COMMENT '志願者との続柄',
  `parent_phone` varchar(200) DEFAULT NULL COMMENT '保護者自宅電話番号',
  `parent_mobile_phone` varchar(200) DEFAULT NULL COMMENT '保護者携帯電話番号',
  `university_belonged` tinyint(3) unsigned DEFAULT NULL COMMENT '所属大学フラグ',
  `university_code` varchar(200) DEFAULT NULL COMMENT '大学コード',
  `university_graduated_year_month` char(6) DEFAULT NULL COMMENT '大学卒業年月',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `handicapped_person_code` varchar(200) DEFAULT NULL COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `disaster_victim_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:被災者受験特別措置',
  `portrait_file_name` varchar(200) DEFAULT NULL COMMENT '顔写真ファイル名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cart_id` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1309 DEFAULT CHARSET=utf8 COMMENT='出願ユーザープロフィール';
CREATE TABLE `cart_user_survey_answer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `survey_id` int(11) unsigned NOT NULL COMMENT 'アンケートID',
  `answer` text NOT NULL COMMENT '回答',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='カートユーザーアンケート回答';
CREATE TABLE `course` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT 'コース名',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='学科マスタ';
CREATE TABLE `csv_export` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT 'ページのタイトル',
  `convert_func` text NOT NULL COMMENT 'CSV変換JavaScript関数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='CSVエクスポート';
CREATE TABLE `csv_export_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `csv_export_id` int(11) unsigned NOT NULL COMMENT 'csv_export.id',
  `exported_at` datetime DEFAULT NULL COMMENT 'エクスポート実行日時',
  `location` varchar(400) NOT NULL COMMENT 'S3のロケーション',
  `original_name` varchar(400) NOT NULL COMMENT '元のファイル名',
  `file_key` varchar(200) NOT NULL COMMENT '一意なファイルのキー',
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_key` (`file_key`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8 COMMENT='CSVエクスポート履歴';
CREATE TABLE `csv_import` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `path` varchar(200) NOT NULL COMMENT 'パス',
  `name` varchar(200) NOT NULL COMMENT 'ページのタイトル',
  `convert_func` text NOT NULL COMMENT 'CSV変換JavaScript関数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='CSVインポート';
CREATE TABLE `csv_import_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `csv_import_id` int(11) unsigned NOT NULL COMMENT 'csv_import.id',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:テストインポート、1:インポート',
  `imported_at` datetime DEFAULT NULL COMMENT 'インポート実行日時',
  `location` varchar(400) NOT NULL COMMENT 'S3のロケーション',
  `original_name` varchar(400) NOT NULL COMMENT '元のファイル名',
  `file_key` varchar(200) NOT NULL COMMENT '一意なファイルのキー',
  `log_id` int(11) unsigned DEFAULT NULL COMMENT 'ログID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_key` (`file_key`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 COMMENT='CSVインポート履歴';
CREATE TABLE `department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '学部名',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学部マスタ';



CREATE TABLE `designated_high_school` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `department_id` int(11) unsigned NOT NULL COMMENT 'department_id',
  `division_external_code` varchar(100) DEFAULT NULL COMMENT '学科コード',
  `high_school_code` char(6) NOT NULL COMMENT '高校コード',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3586 DEFAULT CHARSET=utf8 COMMENT='指定校マスタ';



CREATE TABLE `division` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '学科名',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='学科マスタ';



CREATE TABLE `dual_applications_advisability` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `bad_exam_id` int(11) unsigned NOT NULL COMMENT '併願できない試験のid(exam.id)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1132 DEFAULT CHARSET=utf8 COMMENT='併願可否マスタ';



CREATE TABLE `exam` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT '試験名',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT 'exam_type.id',
  `exam_fee` int(11) unsigned NOT NULL COMMENT '単願時の受験料',
  `department_id` int(11) unsigned NOT NULL COMMENT 'department.id',
  `division_id` int(11) unsigned DEFAULT NULL COMMENT 'division.id',
  `course_id` int(11) unsigned DEFAULT NULL COMMENT 'course.id',
  `exam_date_id` int(11) unsigned DEFAULT NULL COMMENT 'exam_date.id',
  `entry_opened_at` datetime DEFAULT NULL COMMENT '出願開始日時',
  `entry_closed_at` datetime DEFAULT NULL COMMENT '出願終了日時',
  `payment_limit` datetime DEFAULT NULL COMMENT '支払い期限日時',
  `payment_effective_days` int(11) DEFAULT NULL COMMENT '支払有効日数',
  `document_reception_limit` datetime DEFAULT NULL COMMENT '書類の郵送受付期限',
  `ticket_opened_at` datetime DEFAULT NULL COMMENT 'オンライン受験票公開開始日',
  `ticket_closed_at` datetime DEFAULT NULL COMMENT 'オンライン受験票公開終了日',
  `result_opened_at` datetime DEFAULT NULL COMMENT '合否結果公開開始日',
  `result_closed_at` datetime DEFAULT NULL COMMENT '合否結果公開終了日',
  `record_opened_at` datetime DEFAULT NULL COMMENT '成績照会の公開開始日',
  `record_closed_at` datetime DEFAULT NULL COMMENT '成績照会の公開終了日',
  `exam_prop_form_id` int(11) unsigned DEFAULT NULL COMMENT '試験プロパティ入力フォームID',
  `mailinglabel_template_name` varchar(200) DEFAULT NULL COMMENT '宛名ラベルテンプレート名',
  `examination_ticket_template_name` varchar(200) DEFAULT NULL COMMENT '受験票テンプレート名',
  `early_decision` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:専願入試',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8 COMMENT='入試マスタ';



CREATE TABLE `exam_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '試験種別名',
  `display_name` varchar(200) DEFAULT NULL COMMENT '表示名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='試験カテゴリーマスタ';



CREATE TABLE `exam_date` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='試験日マスタ';



CREATE TABLE `exam_date_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_date_id` int(11) unsigned NOT NULL COMMENT 'exam_date.id',
  `exam_date` date NOT NULL COMMENT '試験日',
  `external_code` varchar(100) NOT NULL COMMENT '外部コード',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='試験日詳細マスタ';



CREATE TABLE `exam_fee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `description` varchar(200) NOT NULL COMMENT '説明',
  `fee` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '検定料',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='入試検定料';



CREATE TABLE `exam_initial` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `exam_id` int(11) unsigned NOT NULL COMMENT '試験ID',
  `entry_opened_at` datetime DEFAULT NULL COMMENT '出願開始日時',
  `entry_closed_at` datetime DEFAULT NULL COMMENT '出願終了日時',
  `payment_limit` datetime DEFAULT NULL COMMENT '支払期限日時',
  `payment_effective_days` int(11) DEFAULT NULL COMMENT '支払有効日数',
  `document_reception_limit` datetime DEFAULT NULL COMMENT '書類の郵送受付期限',
  `ticket_opened_at` datetime DEFAULT NULL COMMENT 'オンライン受験票公開開始日',
  `ticket_closed_at` datetime DEFAULT NULL COMMENT 'オンライン受験票公開終了日',
  `result_opened_at` datetime DEFAULT NULL COMMENT '合否結果公開開始日',
  `result_closed_at` datetime DEFAULT NULL COMMENT '合否結果公開終了日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=511 DEFAULT CHARSET=utf8 COMMENT='試験初期マスタ';



CREATE TABLE `exam_prop_form` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(100) NOT NULL COMMENT 'フォーム名（識別用）',
  `template_name` varchar(100) DEFAULT NULL COMMENT 'フォームテンプレート名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='試験プロパティ入力フォーム';



CREATE TABLE `exam_prop_input` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_prop_form_id` int(11) unsigned NOT NULL COMMENT '入力フォームID',
  `group_name` varchar(100) DEFAULT NULL COMMENT '入力グループ名（識別用）',
  `name` varchar(100) NOT NULL COMMENT '入力項目名（識別用）',
  `type` varchar(10) NOT NULL COMMENT '入力形式',
  `value` varchar(100) DEFAULT NULL COMMENT '入力項目値/初期値',
  `required` tinyint(1) DEFAULT NULL COMMENT '1:必須',
  `checked` tinyint(1) DEFAULT NULL COMMENT '1:チェック済み（radio/checkbox）',
  PRIMARY KEY (`id`),
  KEY `idx_exam_prop_form_id` (`exam_prop_form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='試験プロパティ入力項目';



CREATE TABLE `exam_prop_option` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_prop_input_id` int(11) unsigned NOT NULL COMMENT '入力項目ID（親SELECT）',
  `name` varchar(100) NOT NULL COMMENT '項目名（識別用）',
  `label` varchar(100) NOT NULL COMMENT '項目ラベル',
  `value` varchar(100) NOT NULL COMMENT '値',
  `selected` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:選択済み',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`),
  KEY `idx_exam_prop_input_id` (`exam_prop_input_id`,`display_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='試験プロパティ選択項目';



CREATE TABLE `exam_result` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `exam_result` tinyint(3) unsigned NOT NULL COMMENT '合否結果コード',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `result_comment` text COMMENT '合否コメント',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='合否結果区分マスタ';



CREATE TABLE `exam_site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `site_id` int(11) unsigned NOT NULL COMMENT 'site.id',
  `capacity_count` int(11) unsigned DEFAULT NULL COMMENT '定員数',
  `threshold_count` int(11) unsigned DEFAULT NULL COMMENT '定員数閾値',
  `commuted_place_id_to` int(11) unsigned DEFAULT NULL COMMENT '振替先会場',
  `entry_stopped` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:受付可能、1：受付停止',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=520 DEFAULT CHARSET=utf8 COMMENT='試験・試験会場マスタ';



CREATE TABLE `exam_subject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `subject_id` int(11) unsigned NOT NULL COMMENT 'subject.id',
  PRIMARY KEY (`id`),
  KEY `exam_id` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='試験・科目マスタ';



CREATE TABLE `exam_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) DEFAULT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '試験種別名',
  `display_name` varchar(200) NOT NULL COMMENT '表示名',
  `exam_category_id` int(11) unsigned DEFAULT NULL COMMENT '試験カテゴリーID',
  `exam_prop_form_id` int(11) unsigned DEFAULT NULL COMMENT '試験プロパティフ入力ォームID（試験種別共通）',
  `early_decision` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:専願入試',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 COMMENT='試験種別マスタ';



CREATE TABLE `examinees_number` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `examinees_number` int(10) unsigned DEFAULT NULL COMMENT '受験番号(CDなし)',
  `application_id` int(11) unsigned NOT NULL COMMENT 'application_id',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'application_exam_id',
  `pre_application_id` int(11) unsigned NOT NULL COMMENT 'application_id(仮)',
  `pre_exam_id` int(11) unsigned NOT NULL COMMENT 'application_exam_id(仮)',
  `handicapped` tinyint(1) NOT NULL COMMENT '障害者フラグ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `examinees_number` (`examinees_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9096870 DEFAULT CHARSET=utf8 COMMENT='受験番号管理';



CREATE TABLE `examinees_number_issue_paramater` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_type_code` varchar(10) DEFAULT NULL COMMENT '入試種別コード',
  `exam_date_code` varchar(10) DEFAULT NULL COMMENT '日付コー�?',
  `site_code` varchar(10) DEFAULT NULL COMMENT '試験会場コード',
  `division_code` varchar(10) DEFAULT NULL COMMENT '学科コード',
  `course_code` varchar(10) DEFAULT NULL COMMENT 'コースコード',
  `picked_form_code` varchar(10) DEFAULT NULL COMMENT '選抜区分コード',
  `other_code` tinyint(3) unsigned DEFAULT NULL COMMENT 'その他のコード',
  `selected_course_code` varchar(10) DEFAULT NULL COMMENT '選択科目コード',
  `examinees_number_from` int(7) unsigned DEFAULT NULL COMMENT '受験番号範囲（自）',
  `examinees_number_to` int(7) unsigned DEFAULT NULL COMMENT '受験番号範囲（至）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78183 DEFAULT CHARSET=utf8 COMMENT='受付番号付番パラメータ';



CREATE TABLE `examinees_ticket` (
  `application_id` int(11) unsigned NOT NULL COMMENT 'application.id',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `examinees_number` varchar(200) NOT NULL COMMENT '受験番号',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `ticket_issue` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '受験票生成フラグ',
  `ticket_issue_date` datetime DEFAULT NULL COMMENT '受験票生成日時',
  `notice_success` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '受験票メールの送信ステータス（0:送信失敗 1:未確認 2:成功 3:送信エラー 4:迷惑メール）',
  `notice_send_date` datetime DEFAULT NULL COMMENT '受験票メール日時',
  PRIMARY KEY (`application_id`,`user_id`,`examinees_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='受験票通知ステータス';



CREATE TABLE `free_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `free_item_kbn` char(3) NOT NULL COMMENT '例（1:選考方法、2:集合時間・・・）',
  `free_item_1` varchar(200) DEFAULT NULL COMMENT '自由項目1',
  `free_item_2` varchar(200) DEFAULT NULL COMMENT '自由項目2',
  `free_item_3` varchar(200) DEFAULT NULL COMMENT '自由項目3',
  `free_item_4` varchar(200) DEFAULT NULL COMMENT '自由項目4',
  `free_item_5` varchar(200) DEFAULT NULL COMMENT '自由項目5',
  `free_item_6` varchar(200) DEFAULT NULL COMMENT '自由項目6',
  `free_item_7` varchar(200) DEFAULT NULL COMMENT '自由項目7',
  `free_item_8` varchar(200) DEFAULT NULL COMMENT '自由項目8',
  `free_item_9` varchar(200) DEFAULT NULL COMMENT '自由項目9',
  `free_item_10` varchar(200) DEFAULT NULL COMMENT '自由項目10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=892 DEFAULT CHARSET=utf8 COMMENT='自由項目マスタ';



CREATE TABLE `high_school` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `high_school_code` char(6) NOT NULL COMMENT '高校コード',
  `prefecture_code` char(2) NOT NULL COMMENT '都道府県コード',
  `name` varchar(20) NOT NULL COMMENT '高等学校等名',
  `establish_organization_type` tinyint(3) unsigned NOT NULL COMMENT '設置者タイプ（1:国立、2:都道府県立、3:市立、4:町立、5:村立、6:組合立、7:私立、9:その他）',
  `educational_institute_type` tinyint(3) unsigned NOT NULL COMMENT '教育機関タイプ（1:高等学校、2:中等教育学校、3:特別支援学校、6:高等専門学校、8:その他、9:その他',
  PRIMARY KEY (`id`),
  UNIQUE KEY `high_school_code` (`high_school_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6004 DEFAULT CHARSET=utf8 COMMENT='高校マスタ';



CREATE TABLE `high_school_branch` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `code` tinyint(3) unsigned NOT NULL COMMENT '出身高校学科コード',
  `external_code` varchar(100) NOT NULL COMMENT '外部コード',
  `name` varchar(200) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='出身高校学科マスタ';



CREATE TABLE `high_school_course` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `code` tinyint(3) unsigned NOT NULL COMMENT '出身高校課程コード',
  `name` varchar(200) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='出身高校課程マスタ';



CREATE TABLE `information` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:大学からのお知らせ、1:システムからのお知らせ',
  `title` varchar(200) NOT NULL COMMENT 'お知らせタイトル',
  `text` text NOT NULL COMMENT 'お知らせ本文',
  `opened_at` datetime NOT NULL COMMENT '公開開始日時',
  `closed_at` datetime NOT NULL COMMENT '公開終了日時',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  `new_disp_at` datetime NOT NULL COMMENT 'NEW表示終了日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8 COMMENT='お知らせ';



CREATE TABLE `inquiry` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `staff_name` varchar(512) DEFAULT NULL COMMENT '担当者',
  `operate_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '対応日時',
  `status` varchar(60) DEFAULT NULL COMMENT 'ステータス',
  `title` varchar(512) DEFAULT NULL COMMENT '問い合わせ内容',
  `text` varchar(512) DEFAULT NULL COMMENT '対応内容',
  `note` varchar(512) DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`id`),
  KEY `inquiry_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='問い合わせ情報';



CREATE TABLE `interim_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `email` varchar(256) NOT NULL COMMENT 'メールアドレス',
  `register_nonce` varchar(256) NOT NULL COMMENT '仮登録時のワンタイムトークン',
  `register_nonce_expires_at` datetime NOT NULL COMMENT '仮登録トークンの有効期限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=535 DEFAULT CHARSET=utf8 COMMENT='仮登録会員';



CREATE TABLE `interim_user_edit` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT '会員ID',
  `email` varchar(256) NOT NULL COMMENT 'メールアドレス',
  `modify_nonce` varchar(256) NOT NULL COMMENT 'ワンタイムトークン',
  `modify_nonce_expires_at` datetime NOT NULL COMMENT '有効期限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='会員変更予定';



CREATE TABLE `log_output_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作�??日�?',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日�?',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `log_output_id` int(11) unsigned NOT NULL COMMENT 'ログ出力id',
  `output_at` datetime DEFAULT NULL COMMENT 'ログ生�??日�?',
  `location` varchar(400) NOT NULL COMMENT 'S3のロケーション',
  `original_name` varchar(400) NOT NULL COMMENT '�????ファイル�?',
  `file_key` varchar(200) NOT NULL COMMENT '�?意なファイルのキー',
  `approve_or_refuse` int(11) DEFAULT NULL COMMENT '承認ステータス（１：承認済み　２：否認済み　それ以外：未設定）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='ログ出力履歴';



CREATE TABLE `mail_api_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `request_url` varchar(256) NOT NULL COMMENT 'リクエストURL',
  `request_body` text COMMENT 'リクエストボディ',
  `response_body` text COMMENT 'レスポンスボディ',
  `response_headers` text COMMENT 'レスポンスヘッダー',
  `response_status` int(11) DEFAULT NULL COMMENT 'レスポンスステータス',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='メール配信API実行結果ログ';



CREATE TABLE `mail_magazine` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `subject` varchar(200) NOT NULL COMMENT 'メール件名',
  `text` text NOT NULL COMMENT 'メール本文',
  `delivery_at` datetime NOT NULL COMMENT '送信予定時刻。nullなら即時配信。',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:下書き、10:配信済み、20:配信予約実行待ち、21:配信予約実行中、22:配信予約済み、23:配信予約失敗、30:配信中、90:配信キャンセル、91:配信キャンセル失敗、99:配信失敗',
  `delivery_id` varchar(200) DEFAULT NULL COMMENT '配信ID',
  `mail_id` varchar(200) DEFAULT NULL COMMENT 'メールID',
  `adbook_id` varchar(200) DEFAULT NULL COMMENT 'アドレス帳ID',
  `import_id` varchar(200) DEFAULT NULL COMMENT 'インポートID',
  `delivery_condition` text COMMENT '配信ユーザー絞り込み条件JSON',
  `count_all` int(11) unsigned DEFAULT NULL COMMENT '配信総数',
  `count_success` int(11) unsigned DEFAULT NULL COMMENT '配信成功数',
  `count_failure` int(11) unsigned DEFAULT NULL COMMENT '配信失敗数',
  `count_deferral` int(11) unsigned DEFAULT NULL COMMENT '配信延期数',
  `csv_key` varchar(200) DEFAULT NULL COMMENT 'S3に置くCSVのキー名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='メルマガ';



CREATE TABLE `mail_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(45) NOT NULL COMMENT 'メールテンプレート名',
  `email_from` varchar(256) DEFAULT NULL COMMENT '送信元アドレス',
  `email_to_info` varchar(200) DEFAULT NULL COMMENT '送信先の情報',
  `email_subject` text COMMENT '件名',
  `email_text` text COMMENT '本文',
  PRIMARY KEY (`id`),
  UNIQUE KEY `format_type` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='システム送信用メールテンプレートマスタ';



CREATE TABLE `modified_application` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '履歴ID',
  `application_id` int(11) unsigned NOT NULL COMMENT '出願ID',
  `application_no` varchar(200) DEFAULT NULL COMMENT '出願受付番号',
  `reference_number` varchar(100) NOT NULL COMMENT '整理番号',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT '試験種別ID',
  `user_id` int(11) unsigned NOT NULL COMMENT 'user.id',
  `cart_id` int(11) NOT NULL COMMENT 'カートID',
  `management_status` char(4) NOT NULL COMMENT '管理ステータス（0100：出願済み（入金前）　0200：志願済み（入金後）　0300：書類確認中　0400：不備なし　0500：仮付番済み　0600：受験番号付番済み）',
  `applied_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出願日時',
  `total_fee` bigint(20) unsigned NOT NULL COMMENT 'この出願の受験料合計額',
  `gpa` varchar(200) DEFAULT NULL COMMENT '評定平均値',
  `ticket_issued_at` datetime DEFAULT NULL COMMENT '受験票発行日付',
  `csv_exported` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未出力(新規)、1:出力済み、2:変更有り',
  `paid` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:支払い待ち、1:支払い済み、2:免除、9:キャンセル',
  `examinees_number_issued` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '（1:受験番号付番済み 0：未付番 9：付番除外）',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽専修実技区分',
  `specific_license_code` tinyint(3) unsigned DEFAULT NULL COMMENT '特定資格コード',
  `handicapped_person_code` varchar(200) DEFAULT NULL COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `disaster_victim_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:被災者受験特別措置',
  `high_school_notification_consented` tinyint(1) DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1875 DEFAULT CHARSET=utf8 COMMENT='出願履歴';



CREATE TABLE `modified_application_exam` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '履歴ID',
  `application_exum_id` int(11) unsigned NOT NULL COMMENT '出願試験ID',
  `application_id` int(11) unsigned NOT NULL COMMENT 'application.id',
  `exam_id` int(11) unsigned NOT NULL COMMENT 'exam.id',
  `examinees_number` varchar(200) DEFAULT NULL COMMENT '受験番号',
  `exam_type_id` int(11) unsigned NOT NULL COMMENT 'exam_type.id',
  `exam_type_external_code` varchar(100) NOT NULL COMMENT 'exam_type.external_code',
  `department_id` int(11) unsigned DEFAULT NULL COMMENT 'department.id',
  `department_external_code` varchar(100) DEFAULT NULL COMMENT 'department.external_code',
  `division_id` int(11) unsigned DEFAULT NULL COMMENT 'division.id',
  `division_external_code` varchar(100) DEFAULT NULL COMMENT 'division.external_code',
  `course_id` int(11) unsigned DEFAULT NULL COMMENT 'course.id',
  `course_external_code` varchar(100) DEFAULT NULL COMMENT 'course.external_code',
  `picked_form_code` varchar(100) DEFAULT NULL COMMENT '選抜区分コード',
  `selected_course_code` varchar(100) DEFAULT NULL COMMENT '選択科目コード',
  `exam_result` tinyint(3) unsigned DEFAULT NULL COMMENT '合否結果コード',
  `gpa_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0:未評価、1:評定OK、2:評定NG',
  `site_id` int(11) unsigned NOT NULL COMMENT 'site.id',
  `practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '実技コード',
  `practical_exam_number` int(4) unsigned DEFAULT NULL COMMENT '実技試験番号',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽実技区分',
  `musical_grammar_code` tinyint(3) unsigned DEFAULT NULL COMMENT '楽典選択',
  `examinees_number_mail_sent` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '受験番号メール通知',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1857 DEFAULT CHARSET=utf8 COMMENT='出願試験履歴';



CREATE TABLE `modified_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `modified_user_id` int(11) unsigned NOT NULL COMMENT '変更ユーザーID',
  `modified_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '変更日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=630 DEFAULT CHARSET=utf8 COMMENT='変更履歴';



CREATE TABLE `modified_payment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '履歴ID',
  `payment_id` int(11) unsigned NOT NULL COMMENT '支払いID',
  `cart_id` int(11) NOT NULL COMMENT 'カートID',
  `body_amount` bigint(20) unsigned NOT NULL COMMENT '請求額本体',
  `charge` bigint(20) unsigned NOT NULL COMMENT '手数料',
  `tax` bigint(20) unsigned NOT NULL COMMENT '税金',
  `payment_method_id` int(11) unsigned NOT NULL COMMENT 'payment_method.id',
  `bill_no` bigint(16) unsigned NOT NULL COMMENT '請求番号',
  `payment_limit_at` datetime DEFAULT NULL COMMENT '支払期限',
  `order_id` bigint(12) unsigned DEFAULT NULL COMMENT '申込番号',
  `sej_haraikomi_no` bigint(13) unsigned DEFAULT NULL COMMENT 'SEJ払込番号',
  `sej_haraikomihyo_url` varchar(200) DEFAULT NULL COMMENT 'SEJ払込票URL',
  `sej_haraikomihyo_no` varchar(32) DEFAULT NULL COMMENT 'SEJ払込票番号',
  `wn_conf_no` varchar(4) DEFAULT NULL COMMENT 'WN確認番号',
  `wn_kessai_no` varchar(11) DEFAULT NULL COMMENT 'WN決済番号',
  `wn_kessai_url` varchar(200) DEFAULT NULL COMMENT 'WN決済URL',
  `wn_syunokikan_no` varchar(5) DEFAULT NULL COMMENT 'WN収納機関番号',
  `payment_at` datetime DEFAULT NULL COMMENT '支払日',
  `paid_at` datetime DEFAULT NULL COMMENT '決済日時',
  `paid_amount` bigint(20) unsigned DEFAULT NULL COMMENT '決済額',
  `exemption_reason_code` tinyint(3) unsigned DEFAULT NULL COMMENT '検定料免除理由コード',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8 COMMENT='支払い履歴';



CREATE TABLE `modified_reasen` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '出願履歴ID',
  `modified_term_name` varchar(200) NOT NULL COMMENT '出願変更項目名',
  `modified_reasen` text NOT NULL COMMENT '変更理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=638 DEFAULT CHARSET=utf8 COMMENT='出願変更理由';



CREATE TABLE `modified_term` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT '項目名(Enumで定義)',
  `description` varchar(200) NOT NULL COMMENT '項目の説明文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COMMENT='出願変更項目マスタ';



CREATE TABLE `modified_user_profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '履歴ID',
  `user_profile_id` int(11) unsigned NOT NULL COMMENT 'ユーザー標準個人情報テンプレートID',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `first_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名）',
  `first_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・カナ）',
  `first_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・英字）',
  `last_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓）',
  `last_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・カナ）',
  `last_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・英字）',
  `middle_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（ミドルネーム）',
  `birthday` date DEFAULT NULL COMMENT '生年月日',
  `gender` tinyint(3) DEFAULT NULL COMMENT '性別、0:女性、1:男性、2:その他',
  `country_code` char(2) NOT NULL COMMENT '志願者住所（国コード・ISO 3166-1・alpha-2）',
  `postcode` varchar(7) DEFAULT NULL COMMENT '志願者住所（郵便番号）',
  `prefecture_code` char(2) DEFAULT NULL COMMENT '志願者住所（都道府県コード）',
  `prefecture` varchar(200) DEFAULT NULL COMMENT '志願者住所（都道府県名・海外用）',
  `municipality` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村）',
  `municipality_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村カナ）',
  `town_area` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地）',
  `town_area_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地カナ）',
  `building` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名）',
  `building_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名カナ）',
  `care_of_address` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方）',
  `care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方カナ）',
  `phone` varchar(200) DEFAULT NULL COMMENT '志願者自宅電話番号',
  `mobile_phone` varchar(200) DEFAULT NULL COMMENT '志願者携帯電話番号',
  `portrait_file_name` varchar(200) DEFAULT NULL COMMENT '顔写真ファイル名',
  `high_school_code` char(6) DEFAULT NULL COMMENT '出身高校コード',
  `high_school_course_code` tinyint(3) DEFAULT NULL COMMENT '出身高校課程コード（1:全日制、2:定時制、3:通信制、4:その他）',
  `high_school_branch_code` tinyint(3) DEFAULT NULL COMMENT '出身高校学科コード（1:普通科、2:商業科、3:工学科、4:その他）',
  `high_school_graduated_year_month` char(6) DEFAULT NULL COMMENT '出身高校卒業年月',
  `high_school_notification_consented` tinyint(1) DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  `cram_school_code` varchar(200) DEFAULT NULL COMMENT '在籍予備校',
  `cram_school_notification_consented` tinyint(1) DEFAULT '0' COMMENT '在籍予備校への入試結果通知同意フラグ',
  `center_score_request_number` varchar(45) DEFAULT NULL COMMENT 'センター試験成績請求番号',
  `parent_first_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字名）',
  `parent_first_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ名）',
  `parent_first_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字名）',
  `parent_last_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字姓）',
  `parent_last_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ姓）',
  `parent_last_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字姓）',
  `parent_postcode` varchar(7) DEFAULT NULL COMMENT '保護者住所（郵便番号）',
  `parent_prefecture_code` char(2) DEFAULT NULL COMMENT '保護者住所（都道府県コード）',
  `parent_municipality` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村）',
  `parent_municipality_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村カナ）',
  `parent_town_area` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地）',
  `parent_town_area_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地カナ）',
  `parent_building` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名）',
  `parent_building_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名カナ）',
  `parent_care_of_address` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方）',
  `parent_care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方カナ）',
  `parent_relation` varchar(200) DEFAULT NULL COMMENT '志願者との続柄',
  `parent_phone` varchar(200) DEFAULT NULL COMMENT '保護者自宅電話番号',
  `parent_mobile_phone` varchar(200) DEFAULT NULL COMMENT '保護者携帯電話番号',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `handicapped_person_code` varchar(200) DEFAULT '0' COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `university_code` varchar(200) DEFAULT NULL COMMENT '大学コード',
  `university_graduated_year_month` char(6) DEFAULT NULL COMMENT '大学卒業年月',
  `portrait_file_state` varchar(1) NOT NULL DEFAULT '0' COMMENT '顔写真の状態 (0:不備なし 1:不備あり)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=629 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='ユーザー標準個人情報テンプレート履歴';



CREATE TABLE `modified_user_survey_answer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `history_id` int(11) unsigned NOT NULL COMMENT '履歴ID',
  `user_survey_answer_id` int(11) unsigned NOT NULL COMMENT 'ユーザーアンケート回答ID',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `survey_id` int(11) unsigned NOT NULL COMMENT 'アンケートID',
  `answer` text NOT NULL COMMENT '回答',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ユーザーアンケート回答履歴';



CREATE TABLE `module` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT 'モジュール名。Enumに定義されている。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='モジュール定義';



CREATE TABLE `nps_api_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `request_url` varchar(256) NOT NULL COMMENT 'リクエストURL',
  `request_body` text COMMENT 'リクエストボディ',
  `response_body` text COMMENT 'レスポンスボディ',
  `response_headers` text COMMENT 'レスポンスヘッダー',
  `response_status` int(11) DEFAULT NULL COMMENT 'レスポンスステータス',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2280 DEFAULT CHARSET=utf8 COMMENT='ネットプリントAPI実行結果ログ';



CREATE TABLE `operator` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `login_id` varchar(256) NOT NULL COMMENT 'ログインID。メアドを登録されることを想定します。',
  `name` varchar(256) NOT NULL COMMENT 'オペレータ名',
  `password` varchar(200) NOT NULL COMMENT 'パスワードのダイジェスト値',
  `email` varchar(200) NOT NULL COMMENT 'メールアドレス',
  `opened_at` datetime NOT NULL COMMENT '利用開始可能日時',
  `closed_at` datetime NOT NULL COMMENT '利用終了期限日時',
  `disabled` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '無効化済みフラグ 1:無効',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='オペレーター';



CREATE TABLE `operator_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `operator_id` int(11) unsigned NOT NULL COMMENT 'operator.id',
  `role_id` int(11) unsigned NOT NULL COMMENT 'role.id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_id_2` (`operator_id`,`role_id`),
  KEY `t_user_id` (`operator_id`),
  KEY `t_role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='オペレータロール';



CREATE TABLE `page_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `lang` varchar(4) NOT NULL COMMENT 'ISO639-1の言語コード',
  `page_code` varchar(100) NOT NULL COMMENT 'jp.co.ixit.freude.common.Path.Entry',
  `message_no` int(11) unsigned NOT NULL COMMENT 'メッセージ番号',
  `message` text NOT NULL COMMENT '表示されるメッセージ',
  `description` text NOT NULL COMMENT 'メッセージの説明文（表示されません）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lang` (`lang`,`page_code`,`message_no`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='ページ文言マスタ';



CREATE TABLE `parent_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `parent_relation_code` char(2) NOT NULL COMMENT '志願者との続柄コード',
  `parent_relation_name` varchar(4) NOT NULL COMMENT '志願者との続柄名',
  `display_order` int(11) unsigned NOT NULL COMMENT '大きい順に表示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `parent_relation_code` (`parent_relation_code`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='志願者との続柄マスタ';



CREATE TABLE `payment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `cart_id` int(11) NOT NULL COMMENT 'カートID',
  `body_amount` bigint(20) unsigned NOT NULL COMMENT '請求額本体',
  `charge` bigint(20) unsigned NOT NULL COMMENT '手数料',
  `tax` bigint(20) unsigned NOT NULL COMMENT '税金',
  `payment_method_id` int(11) unsigned NOT NULL COMMENT 'payment_method.id',
  `bill_no` bigint(16) unsigned NOT NULL COMMENT '請求番号',
  `payment_limit_at` datetime DEFAULT NULL COMMENT '支払期限',
  `order_id` bigint(12) unsigned DEFAULT NULL COMMENT '申込番号',
  `sej_haraikomi_no` bigint(13) unsigned DEFAULT NULL COMMENT 'SEJ払込番号',
  `sej_haraikomihyo_url` varchar(200) DEFAULT NULL COMMENT 'SEJ払込票URL',
  `sej_haraikomihyo_no` varchar(32) DEFAULT NULL COMMENT 'SEJ払込票番号',
  `wn_conf_no` varchar(4) DEFAULT NULL COMMENT 'WN確認番号',
  `wn_kessai_no` varchar(11) DEFAULT NULL COMMENT 'WN決済番号',
  `wn_kessai_url` varchar(200) DEFAULT NULL COMMENT 'WN決済URL',
  `wn_syunokikan_no` varchar(5) DEFAULT NULL COMMENT 'WN収納機関番号',
  `payment_at` datetime DEFAULT NULL COMMENT '支払日',
  `paid_at` datetime DEFAULT NULL COMMENT '決済日時',
  `paid_amount` bigint(20) unsigned DEFAULT NULL COMMENT '決済額',
  `exemption_reason_code` tinyint(3) unsigned DEFAULT NULL COMMENT '検定料免除理由コード',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cart_id` (`cart_id`),
  KEY `payment_index01` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106139 DEFAULT CHARSET=utf8 COMMENT='支払い';



CREATE TABLE `payment_canceled` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `application_no` varchar(200) NOT NULL COMMENT '出願番号',
  `payment_id` int(11) unsigned NOT NULL COMMENT 'payment.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='キャンセル済み支払';



CREATE TABLE `payment_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `payment_id` int(11) unsigned DEFAULT NULL,
  `payment_kind` tinyint(3) unsigned NOT NULL COMMENT '種別。1:支払申込リクエスト送信(GMO) 2:支払申込リクエスト送信(SEJ・WN) 3:入金通知リクエスト受信(SEJ・WN) 4:支払結果確認リクエスト送信(GMO)',
  `req` text COMMENT 'リクエスト',
  `res` text COMMENT 'レスポンス',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3649 DEFAULT CHARSET=utf8 COMMENT='支払いログ';



CREATE TABLE `payment_method` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `method` varchar(200) NOT NULL COMMENT '支払方法。AMEX、JCB、Master等の値が入る。',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `charge` bigint(20) unsigned NOT NULL COMMENT '手数料',
  `max_amount` bigint(20) unsigned NOT NULL COMMENT '支払限度額',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='支払い方法マスタ';



CREATE TABLE `permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT '権限名(Enumで定義)',
  `description` varchar(200) NOT NULL COMMENT '権限の説明文',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='オペレータ権限マスタ';



CREATE TABLE `postcode` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `postcode` varchar(7) NOT NULL COMMENT '郵便番号',
  `prefecture_code` char(2) NOT NULL COMMENT '都道府県コード 01-47',
  `municipality` varchar(200) NOT NULL COMMENT '市区町村名',
  `municipality_kana` varchar(200) NOT NULL COMMENT '市区町村名カナ',
  `town_area` varchar(200) DEFAULT NULL COMMENT '町域名',
  `town_area_kana` varchar(200) DEFAULT NULL COMMENT '町域名カナ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123603 DEFAULT CHARSET=utf8 COMMENT='郵便番号マスタ';



CREATE TABLE `practical_examinees_number` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `exam_type_code` varchar(10) DEFAULT NULL COMMENT '入試種別コード',
  `practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '実技コード',
  `division_code` varchar(10) DEFAULT NULL COMMENT '学科コード',
  `course_code` varchar(10) DEFAULT NULL COMMENT 'コースコード',
  `picked_form_code` varchar(10) DEFAULT NULL COMMENT '選抜区分コード',
  `gender_code` tinyint(3) unsigned DEFAULT NULL COMMENT '性別コード',
  `music_practical_code` tinyint(3) unsigned DEFAULT NULL COMMENT '音楽実技区分',
  `musical_grammar_code` tinyint(3) unsigned DEFAULT NULL COMMENT '楽典選択',
  `examinees_number_from` int(4) unsigned DEFAULT NULL COMMENT '初期番号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='実技試験番号管理';



CREATE TABLE `prefecture` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `prefecture_code` char(2) NOT NULL COMMENT '都道府県コード',
  `prefecture_name` varchar(4) NOT NULL COMMENT '都道府県名',
  `prefecture_name_kana` varchar(200) DEFAULT NULL COMMENT '都道府県名(カナ)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `prefecture_code` (`prefecture_code`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='都道府県マスタ';



CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `name` varchar(200) NOT NULL COMMENT 'ロール名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='ロール';



CREATE TABLE `role_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `role_id` int(11) unsigned NOT NULL COMMENT 'ロールID',
  `permission_id` int(11) unsigned NOT NULL COMMENT '権限ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_role_id` (`role_id`,`permission_id`),
  UNIQUE KEY `role_id` (`role_id`,`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='オペレータロール権限';



CREATE TABLE `site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) NOT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '会場名',
  `display_order` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='試験会場マスタ';



CREATE TABLE `subject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `external_code` varchar(100) NOT NULL COMMENT '外部コード',
  `name` varchar(100) NOT NULL COMMENT '科目名',
  `display_order` int(11) unsigned NOT NULL COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='科目マスタ';



CREATE TABLE `survey` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `question` text NOT NULL COMMENT '質問',
  `input_type` tinyint(3) NOT NULL COMMENT '0:input(type:text)、1:input(type:checkbox)、2:textarea、3:select',
  `display_order` int(11) unsigned NOT NULL COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='管理ユーザー';



CREATE TABLE `survey_option` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `survey_id` int(11) unsigned NOT NULL COMMENT 'アンケートID',
  `survey_option` text NOT NULL COMMENT '選択肢',
  `display_order` int(11) unsigned NOT NULL COMMENT '大きい順に表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='管理ユーザー';



CREATE TABLE `university` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `university_code` char(6) NOT NULL COMMENT '大学コード',
  `prefecture_code` char(2) DEFAULT NULL COMMENT '都道府県コード',
  `name` varchar(20) NOT NULL COMMENT '大学名',
  `establish_organization_type` char(1) NOT NULL COMMENT '設置者タイプ（1:国立、2:公立、3:私立、4:国立短期、5:公立短期、6:私立短期、7:専門、9:その他）',
  `educational_institute_type` tinyint(3) unsigned NOT NULL COMMENT '教育機関タイプ（1:大学、2:短大、3:専門学校等）',
  PRIMARY KEY (`id`),
  KEY `university_code` (`university_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1540 DEFAULT CHARSET=utf8 COMMENT='大学マスタ';



CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `email` varchar(256) NOT NULL COMMENT 'メールアドレス',
  `password` varchar(200) NOT NULL COMMENT 'パスワードのハッシュ値',
  `registered_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
  `password_changed_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'パスワード変更日時',
  `locked` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:ロックされたユーザー',
  `unlock_at` datetime DEFAULT NULL COMMENT 'ロック解除日時',
  `login_failure_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'ログイン失敗回数',
  `suspended` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:利用停止',
  `operational_registered` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:オペレーターによる代理登録',
  `password_reminder_nonce` varchar(200) DEFAULT NULL COMMENT 'パスワード再発行時のワンタイムトークン',
  `password_reminder_nonce_expires_at` datetime DEFAULT NULL COMMENT 'パスワード再発行トークンの有効期限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=880362 DEFAULT CHARSET=utf8 COMMENT='ユーザー';



CREATE TABLE `user_profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `first_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名）',
  `first_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・カナ）',
  `first_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（名・英字）',
  `last_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓）',
  `last_name_kana` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・カナ）',
  `last_name_roman` varchar(200) DEFAULT NULL COMMENT '志願者氏名（姓・英字）',
  `middle_name` varchar(200) DEFAULT NULL COMMENT '志願者氏名（ミドルネーム）',
  `birthday` date DEFAULT NULL COMMENT '生年月日',
  `gender` tinyint(3) DEFAULT NULL COMMENT '性別、0:女性、1:男性、2:その他',
  `country_code` char(2) NOT NULL COMMENT '志願者住所（国コード・ISO 3166-1・alpha-2）',
  `postcode` varchar(7) DEFAULT NULL COMMENT '志願者住所（郵便番号）',
  `prefecture_code` char(2) DEFAULT NULL COMMENT '志願者住所（都道府県コード）',
  `prefecture` varchar(200) DEFAULT NULL COMMENT '志願者住所（都道府県名・海外用）',
  `municipality` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村）',
  `municipality_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（市区町村カナ）',
  `town_area` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地）',
  `town_area_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（町域番地カナ）',
  `building` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名）',
  `building_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（建物名カナ）',
  `care_of_address` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方）',
  `care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '志願者住所（様方カナ）',
  `phone` varchar(200) DEFAULT NULL COMMENT '志願者自宅電話番号',
  `mobile_phone` varchar(200) DEFAULT NULL COMMENT '志願者携帯電話番号',
  `portrait_file_name` varchar(200) DEFAULT NULL COMMENT '顔写真ファイル名',
  `high_school_code` char(6) DEFAULT NULL COMMENT '出身高校コード',
  `high_school_course_code` tinyint(3) DEFAULT NULL COMMENT '出身高校課程コード（1:全日制、2:定時制、3:通信制、4:その他）',
  `high_school_branch_code` tinyint(3) DEFAULT NULL COMMENT '出身高校学科コード（1:普通科、2:商業科、3:工学科、4:その他）',
  `high_school_graduated_year_month` char(6) DEFAULT NULL COMMENT '出身高校卒業年月',
  `high_school_notification_consented` tinyint(1) DEFAULT '1' COMMENT '高校への入試結果通知同意フラグ',
  `cram_school_code` varchar(200) DEFAULT NULL COMMENT '在籍予備校',
  `cram_school_notification_consented` tinyint(1) DEFAULT '0' COMMENT '在籍予備校への入試結果通知同意フラグ',
  `center_score_request_number` varchar(45) DEFAULT NULL COMMENT 'センター試験成績請求番号',
  `parent_first_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字名）',
  `parent_first_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ名）',
  `parent_first_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字名）',
  `parent_last_name` varchar(200) DEFAULT NULL COMMENT '保護者氏名（漢字姓）',
  `parent_last_name_kana` varchar(200) DEFAULT NULL COMMENT '保護者氏名（カナ姓）',
  `parent_last_name_roman` varchar(200) DEFAULT NULL COMMENT '保護者氏名（英字姓）',
  `parent_postcode` varchar(7) DEFAULT NULL COMMENT '保護者住所（郵便番号）',
  `parent_prefecture_code` char(2) DEFAULT NULL COMMENT '保護者住所（都道府県コード）',
  `parent_municipality` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村）',
  `parent_municipality_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（市区町村カナ）',
  `parent_town_area` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地）',
  `parent_town_area_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（町域番地カナ）',
  `parent_building` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名）',
  `parent_building_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（建物名カナ）',
  `parent_care_of_address` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方）',
  `parent_care_of_address_kana` varchar(200) DEFAULT NULL COMMENT '保護者住所（様方カナ）',
  `parent_relation` varchar(200) DEFAULT NULL COMMENT '志願者との続柄',
  `parent_phone` varchar(200) DEFAULT NULL COMMENT '保護者自宅電話番号',
  `parent_mobile_phone` varchar(200) DEFAULT NULL COMMENT '保護者携帯電話番号',
  `handicapped_person_special_measures` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:身体障害者受験特別措置',
  `handicapped_person_code` varchar(200) DEFAULT '0' COMMENT '障害者コード',
  `accident_code` varchar(200) DEFAULT '0' COMMENT '事故コード',
  `university_code` varchar(200) DEFAULT NULL COMMENT '大学コード',
  `university_graduated_year_month` char(6) DEFAULT NULL COMMENT '大学卒業年月',
  `portrait_file_state` varchar(1) NOT NULL DEFAULT '0' COMMENT '顔写真の状態 (0:不備なし 1:不備あり)',
  PRIMARY KEY (`id`),
  KEY `user_profile_index01` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110652 DEFAULT CHARSET=utf8 COMMENT='ユーザー標準個人情報テンプレート';



CREATE TABLE `user_profile_reflection_request` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `application_user_profile_id` int(11) unsigned NOT NULL COMMENT '出願ユーザープロフィールID',
  `reflection_type` tinyint(3) unsigned NOT NULL COMMENT '反映タイプ:1:未対応、2:反映済み、3:差戻し',
  `requesuted_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '依頼日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='ユーザープロフィール反映依頼';



CREATE TABLE `user_survey_answer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `user_id` int(11) unsigned NOT NULL COMMENT 'ユーザーID',
  `survey_id` int(11) unsigned NOT NULL COMMENT 'アンケートID',
  `answer` text NOT NULL COMMENT '回答',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理ユーザー';



CREATE TABLE `validation_rule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:論理削除',
  `form_class_name` varchar(200) NOT NULL COMMENT 'Formクラスの完全修飾名',
  `field_name` varchar(200) NOT NULL COMMENT 'Formのフィールド名',
  `required` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:必須項目',
  `size_min` int(11) unsigned DEFAULT NULL COMMENT '文字列の長さの最小値',
  `size_max` int(11) unsigned DEFAULT NULL COMMENT '文字列の長さの最大値',
  `size_error_message` text COMMENT 'サイズチェックエラーメッセージ',
  `min` int(11) unsigned DEFAULT NULL COMMENT '数値の最小値',
  `max` int(11) unsigned DEFAULT NULL COMMENT '数値の最大値',
  `email` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1:Emailとして正しいかチェック',
  `pattern` varchar(200) DEFAULT NULL COMMENT '正規表現チェック',
  `pattern_error_message` text COMMENT '正規表現チェックエラーメッセージ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='バリデーションルールマスタ';



-- //@UNDO
-- SQL to undo the change goes here.


