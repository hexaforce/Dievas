package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.ExaminationMailTransmissionExamVoucherService;

/**
 * ExaminationMailTransmissionExamVoucher service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Transactional
@Service("examinationMailTransmissionExamVoucherService")
public class ExaminationMailTransmissionExamVoucherServiceImpl
		implements ExaminationMailTransmissionExamVoucherService {
	@Override
	public String serviceName() {
		return "examinationMailTransmissionExamVoucher";
	}
}
