package com.enno.server.stop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enno.server.route.Route;
import com.enno.server.route.RouteService;

@Service
public class StopService {
	
	@Autowired
	private StopRepository stopRepository;
	
	@Autowired 
	private RouteService routeService;

	public List<Stop> getStops() {
		List<Stop> stops = new ArrayList<>();
		stopRepository.findAll().forEach(stops::add);
		return stops;
	}
	
	public Optional<Stop> getStop(Long id) {
		return stopRepository.findById(id);
	}
	
	public Stop addStop(Stop stop) {
		return stopRepository.save(stop);
	}
	
	public void updateStop(Stop stop) {
		stopRepository.save(stop);
	}
	
	// delete stop from all route.stop[] (delete relations) lists and then delete stop
	public void deleteStop(Long id) {
		Stop stop = this.getStop(id).orElse(null);
		if (stop.getRoutes().size() != 0) {
			for (Route route : stop.getRoutes()) {
				route.deleteStop(stop);
				routeService.updateRoute(route);
			}
		}
		stopRepository.deleteById(id);
	}
	
	public void addStopToRoute(long routeId, Stop[] stops) {
		Route route = routeService.getRoute(routeId).orElse(null);
		for (Stop stop : stops) {
			route.addStop(stop);
		}		
		routeService.updateRoute(route);
	}

	public List<Stop> getStopsOnRoute(Long routeId) {
		List<Stop> stops = new ArrayList<>();
		stopRepository.findByRoutesId(routeId).forEach(stops::add);
		return stops;
	}
	
	public void deleteStopFromRoute(long stopId, long routeId) {
		Route route = routeService.getRoute(routeId).orElse(null);
		Stop stop = this.getStop(stopId).orElse(null);
		route.deleteStop(stop);
		routeService.updateRoute(route);
	}
	
}
