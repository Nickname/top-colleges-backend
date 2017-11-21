package com.topcolleguesbackend;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.topcolleguesbackend.entite.Collegue;
import com.topcolleguesbackend.repository.CollegueRepository;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(path = "/collegues")
public class CollegueController {

	@Autowired CollegueRepository repoCollegue;
	
	@GetMapping
	public List<Collegue> getAll() {
		return repoCollegue.findAll();
	}
	
	@GetMapping("/{id}")
	public Collegue getById(@PathVariable Integer id) {
		Optional<Collegue> collegue = repoCollegue.findById(id);
		
		if (collegue.isPresent()) {
			return collegue.get();
		} else {
			return null;
		}
	}
	
	@PostMapping
	public Collegue save(@RequestBody Collegue collegue) {
		repoCollegue.save(collegue);
		return collegue;
	}
	
	@Transactional
	@PutMapping("/{id}")
	public Collegue noter(@RequestBody Map<String, Boolean> params, @PathVariable Integer id) {
		Boolean avis = params.get("avis");
		
		Optional<Collegue> leCollegue = repoCollegue.findById(id);
		
		if (leCollegue.isPresent()) {
			if (avis) {
				Integer jaime = leCollegue.get().getScore() + new Integer(10);
				leCollegue.get().setScore(jaime);
			} else {
				Integer jedeteste = leCollegue.get().getScore() - new Integer(5);
				leCollegue.get().setScore(jedeteste);
			}
			repoCollegue.save(leCollegue.get());
			return leCollegue.get();
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public Collegue delete(@PathVariable Integer id) {
		Optional<Collegue> leCollegue = repoCollegue.findById(id);
		if (leCollegue.isPresent()) {
			repoCollegue.delete(leCollegue.get());
			return leCollegue.get();
		} else {
			return null;
		}
	}
}
