package io.hexaforce.dievas.database.freude.entity.support;

public interface NamesOnly {

	String getFirstname();

	String getLastname();

	default String getFullName() {
		return getLastname().concat(" ").concat(getFirstname());
	}
	
}