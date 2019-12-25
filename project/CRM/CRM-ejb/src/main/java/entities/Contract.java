package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcontrat;
	private String type;
	private float price;
	private Date datedebut;
	private Date datefin;
	private static final long serialVersionUID = 1L;

	public Contract() {
		super();
	}   
	public Integer getIdcontrat() {
		return this.idcontrat;
	}

	public void setIdcontrat(Integer idcontrat) {
		this.idcontrat = idcontrat;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
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
