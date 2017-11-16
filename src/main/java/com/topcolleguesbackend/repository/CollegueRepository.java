package com.topcolleguesbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topcolleguesbackend.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {
	Optional<Collegue> findById(Integer id);
	Optional<Collegue> findByNom(String nom);
}
