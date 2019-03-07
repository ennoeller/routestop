package com.enno.server.route;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enno.server.stop.Stop;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;

	public List<Route> getRoutes() {
		List<Route> routes = new ArrayList<>();
		routeRepository.findAll().forEach(routes::add);
		return routes;
	}
	
	public Optional<Route> getRoute(Long id) {
		return routeRepository.findById(id);
	}
	
	public Route addRoute(Route route) {
		return routeRepository.save(route);
	}
	
	public void updateRoute(Route route) {
		routeRepository.save(route);
	}
	
	// take Stop[] from old route and add it to updated route, otherwise new route will have no Stops
	public void updateRoute(Route route, long id) {
		Route oldRoute = this.getRoute(id).orElse(null);
		route.setStop(oldRoute.getStop());
		routeRepository.save(route);
	}
	
	public void deleteRoute(Long id) {
		routeRepository.deleteById(id);
	}
}
