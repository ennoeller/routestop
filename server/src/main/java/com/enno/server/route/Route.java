package com.enno.server.route;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.enno.server.stop.Stop;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String addDate;
	
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "route_stop", 
		joinColumns = @JoinColumn(name = "route_id"), 
		inverseJoinColumns = @JoinColumn(name = "stop_id"))
	private List<Stop> stops = new ArrayList<>();
	
	public Route() {
		super();
	}

	public Route(Long id, String name, String description, String addDate, List<Stop> stops) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.addDate = addDate;
		this.stops = stops;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public List<Stop> getStop() {
		return stops;
	}

	public void setStop(List<Stop> stop) {
		this.stops = stop;
	}
	
	public void addStop(Stop stop) {
		this.stops.add(stop);
	}

	public void deleteStop(Stop stop) {
		this.stops.remove(stop);
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", description=" + description + ", addDate=" + addDate + "]";
	}	
}