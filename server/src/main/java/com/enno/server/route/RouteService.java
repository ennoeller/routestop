package com.enno.server.route;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addRoute(Route route) {
		routeRepository.save(route);
	}
	
	public void updateRoute(Route route) {
		routeRepository.save(route);
	}
	
	public void deleteRoute(Long id) {
		routeRepository.deleteById(id);
	}
}
