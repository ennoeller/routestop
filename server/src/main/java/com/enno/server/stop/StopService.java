package com.enno.server.stop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopService {
	
	@Autowired
	private StopRepository stopRepository;

	public List<Stop> getStops() {
		List<Stop> stops = new ArrayList<>();
		stopRepository.findAll().forEach(stops::add);
		return stops;
	}
	
	public Optional<Stop> getStop(Long id) {
		return stopRepository.findById(id);
	}
	
	public void addStop(Stop stop) {
		stopRepository.save(stop);
	}
	
	public void updateStop(Stop stop) {
		stopRepository.save(stop);
	}
	
	public void deleteStop(Long id) {
		stopRepository.deleteById(id);
	}
}
