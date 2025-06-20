package org.springframework.samples.petclinic.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface PetRepoService extends JpaRepository<Pet, String>
{
	
	Collection<PetType> findPetTypes();
	  Pet findPetById(int id);
	  void savePet(Pet pet);
	Pet findById(int id);
	

}
