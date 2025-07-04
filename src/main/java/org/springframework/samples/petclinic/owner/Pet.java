package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.Visit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * Simple business object representing a pet.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Wick Dynex
 */
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
	
	@Column(name = "pet_wt")
	@NotBlank
	private double petweight;
	
	@Column(name = "pet_length")
	@NotBlank
	private double petlength;
	
	@Column(name = "pet_aggressiveness")
	@NotBlank
	private String petaggressiveness;
	
	@Column(name = "pet_playfulness")
	@NotBlank
	private String petPlayfulness;
	
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	public double getPetweight() {
		return petweight;
	}

	public void setPetweight(double petweight) {
		this.petweight = petweight;
	}

	public double getPetlength() {
		return petlength;
	}

	public void setPetlength(double petlength) {
		this.petlength = petlength;
	}

	public String getPetaggressiveness() {
		return petaggressiveness;
	}

	public void setPetaggressiveness(String petaggressiveness) {
		this.petaggressiveness = petaggressiveness;
	}

	public String getPetPlayfulness() {
		return petPlayfulness;
	}

	public void setPetPlayfulness(String petPlayfulness) {
		this.petPlayfulness = petPlayfulness;
	}

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_id")
	@OrderBy("date ASC")
	private final Set<Visit> visits = new LinkedHashSet<>();

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public PetType getType() {
		return this.type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Collection<Visit> getVisits() {
		return this.visits;
	}

	public void addVisit(Visit visit) {
		getVisits().add(visit);
	}

}
