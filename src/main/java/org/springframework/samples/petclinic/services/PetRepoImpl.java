package org.springframework.samples.petclinic.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.PetTypeRepository;
import org.springframework.transaction.annotation.Transactional;

public class PetRepoImpl implements PetRepoService{


	private PetTypeRepository petRepository;
	
	@Autowired
	PetRepoImpl(PetTypeRepository petRepository)
	{
		this.petRepository = petRepository;
	}
	
	
	@Override
    @Transactional(readOnly = true)
	public List<PetType> findPetTypes() {
		 return petRepository.findPetTypes();
	}

	@Override
	@Transactional
	public void save(Pet pet) {
		petRepository.save(pet);
		
	}

	@Override
	 @Transactional(readOnly = true)
	public Pet findById(int id) {
		 return petRepository.findById(id);
	}

}
