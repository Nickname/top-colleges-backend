package com.topcolleguesbackend;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController()
public class PingController {
	
	@GetMapping
	public String ping() {
		// Just ping to the server
		return "ok";
	}

}