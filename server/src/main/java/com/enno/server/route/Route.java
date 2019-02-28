package com.enno.server.route;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.enno.server.stop.Stop;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long _id;
	private String name;
	private String description;
	private String addDate;
	
	@ManyToMany(mappedBy = "routes")
	private List<Stop> stop = new ArrayList<>();
	
	public Route() {
		super();
	}

	public Route(Long _id, String name, String description, String addDate, List<Stop> stop) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
		this.addDate = addDate;
		this.stop = stop;
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
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
		return stop;
	}

	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}
}
