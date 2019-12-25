package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpromotion;
	private String description;
	private Date datedebut;
	private Date datefin;
	private float reduction;
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;
	@OneToOne
	private Product product;
	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator operator) {
		Operator = operator;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Promotion() {
		super();
	}   
	public Integer getIdpromotion() {
		return this.idpromotion;
	}

	public void setIdpromotion(Integer idpromotion) {
		this.idpromotion = idpromotion;
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
	public float getReduction() {
		return this.reduction;
	}

	public void setReduction(float reduction) {
		this.reduction = reduction;
	}
   
}
