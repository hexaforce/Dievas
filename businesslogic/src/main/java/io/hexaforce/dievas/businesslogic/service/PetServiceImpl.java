package io.hexaforce.dievas.businesslogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hexaforce.dievas.businesslogic.PetService;
import io.hexaforce.dievas.database.TagRepository;
import io.hexaforce.dievas.database.domain.Pet;
import io.hexaforce.dievas.database.service.OwnerRepository;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Override
	public Pet serach(Long id) {
		// tagRepository.findAll();
		ownerRepository.findById(id.intValue());

		return null;
	}

}
