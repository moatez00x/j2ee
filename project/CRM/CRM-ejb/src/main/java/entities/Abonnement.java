package entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Abonnement
 *
 */
@Entity

public class Abonnement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idabonnement;
	private Float amount;
	private Date date;
	private Integer reference;
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
	@Override
	public String toString() {
		return "Abonnement [idabonnement=" + idabonnement + ", amount=" + amount + ", date=" + date + ", reference="
				+ reference + "]";
	}
	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator operator) {
		Operator = operator;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Abonnement() {
		super();
	}   
	public Integer getIdabonnement() {
		return this.idabonnement;
	}

	public void setIdabonnement(Integer idabonnement) {
		this.idabonnement = idabonnement;
	}   
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public Integer getReference() {
		return this.reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}
   
}
