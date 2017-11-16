package com.topcolleguesbackend.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcolleguesbackend.entite.Collegue;
import com.topcolleguesbackend.repository.CollegueRepository;

@Service
public class InitialiserDonneesService {
	@Autowired CollegueRepository repoCollegue;
	
	public void init() {
		Stream.of(new Collegue("Benjamin", "https://goo.gl/oCqLbL", 30),
				new Collegue("Julien", "https://goo.gl/SpBxiM", 20),
				new Collegue("Thomas", "https://goo.gl/JRQnQ1", 80),
				new Collegue("Emilie", "https://goo.gl/my9NTh", 50),
				new Collegue("Lucile", "https://goo.gl/xAc3MN", 90))
				.forEach((collegue) -> repoCollegue.save(collegue));
	}
}
