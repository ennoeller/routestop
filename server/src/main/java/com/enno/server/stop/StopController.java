package com.enno.server.stop;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StopController {
	
	@Autowired
	private StopService stopService;
	
	@RequestMapping("/stops")
	public List<Stop> getStop() {
		return stopService.getStops();
	}
	
	@RequestMapping("/stops/{id}")
	public Optional<Stop> getRoute(@PathVariable Long id) {
		return stopService.getStop(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stops")
	public void addStop(@RequestBody Stop stop) {
		stopService.addStop(stop);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/stops/{id}")
	public void updateRoute(@RequestBody Stop route) {
		stopService.updateStop(route);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/stops/{id}")
	public void deleteRoute(@PathVariable Long id) {
		stopService.deleteStop(id);
	}
}
