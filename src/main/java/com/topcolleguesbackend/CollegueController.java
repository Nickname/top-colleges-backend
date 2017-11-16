package com.topcolleguesbackend;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.topcolleguesbackend.entite.Collegue;
import com.topcolleguesbackend.repository.CollegueRepository;

@RestController("/collegues")
public class CollegueController {

	@Autowired CollegueRepository repoCollegue;
	
	@GetMapping
	public List<Collegue> getAll() {
		return repoCollegue.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Collegue getById(@PathVariable Integer id) {
		Optional<Collegue> collegue = repoCollegue.findById(id);
		
		if (collegue.isPresent()) {
			return collegue.get();
		} else {
			return null;
		}
	}*/
	
	@PostMapping
	public Collegue save(@RequestBody Collegue collegue) {
		repoCollegue.save(collegue);
		return collegue;
	}
	
	@Transactional
	@PutMapping("/{id}")
	public Collegue update(@RequestBody Collegue collegue, @PathVariable Integer id) {
		Optional<Collegue> leCollegue = repoCollegue.findByNom(collegue.getNom());
		
		if (leCollegue.isPresent()) {
			collegue.setId(leCollegue.get().getId());
			repoCollegue.save(collegue);
			
			return collegue;
		} else {
			return null;
		}
	}
}
