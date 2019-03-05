package com.enno.server.stop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.enno.server.route.Route;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int stopId;
	private String name;
	private String coordinates;

	@JsonIgnore
	@ManyToMany(mappedBy = "stops", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Route> routes = new ArrayList<>();

	public Stop(Long id, int stopId, String name, String coordinates, List<Route> routes) {
		super();
		this.id = id;
		this.stopId = stopId;
		this.name = name;
		this.coordinates = coordinates;
		this.routes = routes;
	}

	public Stop() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
	public void deleteRoute(Route route) {
		this.routes.remove(route);
	}
}
