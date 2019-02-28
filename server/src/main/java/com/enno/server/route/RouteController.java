package com.enno.server.route;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping("/routes")
	public List<Route> getRoutes() {
		return routeService.getRoutes();
	}
	
	@RequestMapping("/routes/{id}")
	public Optional<Route> getRoute(@PathVariable Long id) {
		return routeService.getRoute(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/routes")
	public void addRoute(@RequestBody Route route) {
		routeService.addRoute(route);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/routes/{id}")
	public void updateRoute(@RequestBody Route route) {
		routeService.updateRoute(route);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/routes/{id}")
	public void deleteRoute(@PathVariable Long id) {
		routeService.deleteRoute(id);
	}
}
