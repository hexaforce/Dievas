package io.hexaforce.dievas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hexaforce.dievas.service.MemberInformationSearchService;
import lombok.extern.slf4j.Slf4j;

/**
 * MemberInformationSearch service implement.
 * 
 * @version 1.0.0.BUILD-SNAPSHOT
 * @author T.Tantaka <relics9@gmail.com>
 */

@Slf4j
@Transactional
@Service("memberInformationSearchService")
public class MemberInformationSearchServiceImpl implements MemberInformationSearchService {
	
	@Override
	public String init() {
		log.info("MemberInformationSearchServiceImpl.java init()");
		return "memberInformationSearchService";
	}

}
