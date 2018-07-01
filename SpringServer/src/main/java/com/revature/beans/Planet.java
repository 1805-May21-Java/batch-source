package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Planet {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="planetSequence")
	@SequenceGenerator(allocationSize=1,name="planetSequence",sequenceName="SQ_PLANET_PK")
	private Integer planetId;
	
	@Column
	private String name;
	
	@Column
	private Double period; //In earth days
	
	@Column
	private Double radius; //orbital radius, by semi-major axis, in A.U.
	
	@Column
	private Double eccentricity; //eccentricity of orbit

	public Planet() {
		super();
	}

	public Planet(Integer planetId, String name, Double period, Double radius, Double eccentricity) {
		super();
		this.planetId = planetId;
		this.name = name;
		this.period = period;
		this.radius = radius;
		this.eccentricity = eccentricity;
	}

	public Integer getPlanetId() {
		return planetId;
	}

	public void setPlanetId(Integer planetId) {
		this.planetId = planetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPeriod() {
		return period;
	}

	public void setPeriod(Double period) {
		this.period = period;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public void setEccentricity(Double eccentricity) {
		this.eccentricity = eccentricity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eccentricity == null) ? 0 : eccentricity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((planetId == null) ? 0 : planetId.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (eccentricity == null) {
			if (other.eccentricity != null)
				return false;
		} else if (!eccentricity.equals(other.eccentricity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (planetId == null) {
			if (other.planetId != null)
				return false;
		} else if (!planetId.equals(other.planetId))
			return false;
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planet [planetId=" + planetId + ", name=" + name + ", period=" + period + ", radius=" + radius
				+ ", eccentricity=" + eccentricity + "]";
	}
	
	

	
}
