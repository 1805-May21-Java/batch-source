package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Pokemon {
	
	@Id
	@Column
	int id;
	
	@Column
	String name;
	
	@Column
	String type;
	
	@Column
	String evolutionStage;

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int id, String name, String type, String evolutionStage) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.evolutionStage = evolutionStage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEvolutionStage() {
		return evolutionStage;
	}

	public void setEvolutionStage(String evolutionStage) {
		this.evolutionStage = evolutionStage;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", evolutionStage=" + evolutionStage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evolutionStage == null) ? 0 : evolutionStage.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (evolutionStage == null) {
			if (other.evolutionStage != null)
				return false;
		} else if (!evolutionStage.equals(other.evolutionStage))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	

}
