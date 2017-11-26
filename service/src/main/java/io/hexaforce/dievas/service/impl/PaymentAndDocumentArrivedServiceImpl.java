package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.PaymentAndDocumentArrivedService;
import lombok.extern.slf4j.Slf4j;

/**
 * PaymentAndDocumentArrived service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("paymentAndDocumentArrivedService")
public class PaymentAndDocumentArrivedServiceImpl implements PaymentAndDocumentArrivedService {
	
	@Override
	public String init() {
		log.info("PaymentAndDocumentArrivedServiceImpl.java init()");
		return "paymentAndDocumentArrivedService";
	}

}
