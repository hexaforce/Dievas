package io.hexaforce.dievas.commons.utiles;

import io.hexaforce.util.amazonaws.SimpleStorageService;
import io.hexaforce.util.amazonaws.dto.StorageObject;

public class DievasUtiles {
	
	public static String example() {
		SimpleStorageService.getObject(new StorageObject());
		return "AAAA";
	}

}
