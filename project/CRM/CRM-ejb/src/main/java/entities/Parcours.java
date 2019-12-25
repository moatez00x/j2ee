package entities;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Parcours
 *
 */
@Entity

public class Parcours implements Serializable {

	   
	@Id
	private String parcour;
	private Integer distance;
	private static final long serialVersionUID = 1L;

	public Parcours() {
		super();
	}   
	public String getParcour() {
		return this.parcour;
	}

	public void setParcour(String parcour) {
		this.parcour = parcour;
	}   
	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Parcours [parcour=" + parcour + ", distance=" + distance + "]";
	}
   
}
