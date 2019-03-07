package com.enno.server.route;

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
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	// return all routes
	@RequestMapping("/routes")
	public List<Route> getRoutes() {
		return routeService.getRoutes();
	}
	
	// return a route with the given id
	@RequestMapping("/routes/{id}")
	public Optional<Route> getRoute(@PathVariable Long id) {
		return routeService.getRoute(id);
	}
	
	// add a route given the route body
	@RequestMapping(method=RequestMethod.POST, value="/routes")
	public Route addRoute(@RequestBody Route route) {
		return routeService.addRoute(route);
	}

	// update route given the route body and route id
	@RequestMapping(method=RequestMethod.PUT, value="/routes/{id}")
	public void updateRoute(@RequestBody Route route, @PathVariable long id) {
		routeService.updateRoute(route, id);
	}
	
	// delete route given the route id
	@RequestMapping(method=RequestMethod.DELETE, value="/routes/{id}")
	public void deleteRoute(@PathVariable Long id) {
		routeService.deleteRoute(id);
	}
}
