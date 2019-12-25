package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deals
 *
 */
@Entity

public class Deals implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddeals;
	private String description;
	private Date datedebut;
	private Date datefin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;

	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator operator) {
		Operator = operator;
	}
	
	public Deals() {
		super();
	}   
	public Integer getIddeals() {
		return this.iddeals;
	}

	public void setIddeals(Integer iddeals) {
		this.iddeals = iddeals;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}   
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
   
}
