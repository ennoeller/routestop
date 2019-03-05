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

import com.enno.server.route.Route;
import com.enno.server.route.RouteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StopController {
	
	@Autowired
	private StopService stopService;
	
	@Autowired 
	private RouteService routeService;
	
	// view all stops
	@RequestMapping("/stops")
	public List<Stop> getStops() {
		return stopService.getStops();
	}
	
	// view a single stop
	@RequestMapping("/stops/{id}")
	public Optional<Stop> getStop(@PathVariable Long id) {
		return stopService.getStop(id);
	}
	
	// add a new stop
	@RequestMapping(method=RequestMethod.POST, value="/stops")
	public void addStop(@RequestBody Stop stop) {
		stopService.addStop(stop);
	}

	// update a stop
	@RequestMapping(method=RequestMethod.PUT, value="/stops/{id}")
	public void updateRoute(@RequestBody Stop route) {
		stopService.updateStop(route);
	}
	
	// delete a stop
	@RequestMapping(method=RequestMethod.DELETE, value="/stops/{id}")
	public void deleteRoute(@PathVariable Long id) {
		stopService.deleteStop(id);
	}
	
	// view all stops on a route
	@RequestMapping("/routes/{routeId}/stops")
	public List<Stop> getStopsOnRoute(@PathVariable long routeId) {
		return stopService.getStopsOnRoute(routeId);
	}
	
	// add a stop to route
	@RequestMapping(method=RequestMethod.POST, value = "/routes/{routeId}/stops/{stopId}")
	public void addStopToRoute(@PathVariable long routeId, @PathVariable long stopId) {
		stopService.addStopToRoute(routeId, stopId);
	}
	
	// delete a stop from a route
	@RequestMapping(method=RequestMethod.DELETE, value="/routes/{routeId}/stops/{stopId}")
	public void deleteStopFromRoute(@PathVariable long routeId, @PathVariable long stopId) {
		stopService.deleteStopFromRoute(stopId, routeId);
	}
}