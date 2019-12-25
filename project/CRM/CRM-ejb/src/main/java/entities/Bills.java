package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bills
 *
 */
@Entity

public class Bills implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idbill;
	private Integer reference;
	private float amount;
	private boolean etat;
	private String paymenttype;
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	private Date date;
	private Date paymentdate;
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
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
	public Bills() {
		super();
	}   
	public Integer getIdbill() {
		return this.idbill;
	}

	public void setIdbill(Integer idbill) {
		this.idbill = idbill;
	}   
	public Integer getReference() {
		return this.reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}   
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}   
	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}   
	public String getPaymenttype() {
		return this.paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Bills [idbill=" + idbill + ", reference=" + reference + ", amount=" + amount + ", etat=" + etat
				+ ", paymenttype=" + paymenttype + ", Name=" + Name + ", date=" + date + ", paymentdate=" + paymentdate
				+ ", Operator=" + Operator + ", client=" + client + "]";
	}
	
   
}
