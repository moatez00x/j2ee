package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SalesPoints
 *
 */
@Entity

public class SalesPoints implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idsales;
	private String location;
	private Integer phone;
	private String  horaire;

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;

	
	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator operator) {
		Operator = operator;
	}
	public SalesPoints() {
		super();
	}   
	public Integer getIdsales() {
		return this.idsales;
	}

	public void setIdsales(Integer idsales) {
		this.idsales = idsales;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	

	
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	@Override
	public String toString() {
		return "SalesPoints [idsales=" + idsales + ", location=" + location + ", phone=" + phone + ", Operator="
				+ Operator + "]";
	}
   
}
