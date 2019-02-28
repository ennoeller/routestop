package com.enno.server.stop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.enno.server.route.Route;

@Entity
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private int stopId;
	private String name;
	private String coordinates;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "route_stop", 
		joinColumns = @JoinColumn(name = "route_id"), 
		inverseJoinColumns = @JoinColumn(name = "stop_id"))
	private List<Route> routes = new ArrayList<>();

	public Stop(Long _id, int stopId, String name, String coordinates, List<Route> routes) {
		super();
		this._id = _id;
		this.stopId = stopId;
		this.name = name;
		this.coordinates = coordinates;
		this.routes = routes;
	}

	public Stop() {
		super();
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
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

	public String getDescription() {
		return coordinates;
	}

	public void setDescription(String description) {
		this.coordinates = description;
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
}
