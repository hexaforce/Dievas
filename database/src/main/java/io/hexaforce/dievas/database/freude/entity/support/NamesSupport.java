package io.hexaforce.dievas.database.freude.entity.support;

/**
 * @author T.Tantaka
 *
 */
public interface NamesSupport {

	String getFirstname();

	String getLastname();

	default String getFullName() {
		return getLastname().concat(" ").concat(getFirstname());
	}
	
}