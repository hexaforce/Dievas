package io.hexaforce.dievas.service.logic;

import io.hexaforce.dievas.commons.logic.GlobalLogicS3;

public class LocalLogicCsv extends GlobalLogicS3 {

	protected String getLocalMessage() {
		return getGlobalMessage() + "LocalLogic";
	}
}
