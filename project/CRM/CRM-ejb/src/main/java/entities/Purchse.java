package entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Purchse
 *
 */
@Entity

public class Purchse implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpurchase;
	private String item;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	private Integer quantity;
	private float amountbeforetaxe;
	private float total;
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator operator;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Purchse() {
		super();
	}   
	public Integer getIdpurchase() {
		return this.idpurchase;
	}

	public void setIdpurchase(Integer idpurchase) {
		this.idpurchase = idpurchase;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}   
	public float getAmountbeforetaxe() {
		return this.amountbeforetaxe;
	}

	public void setAmountbeforetaxe(float amountbeforetaxe) {
		this.amountbeforetaxe = amountbeforetaxe;
	}   
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Purchse [idpurchase=" + idpurchase + ", quantity=" + quantity + ", amountbeforetaxe=" + amountbeforetaxe
				+ ", total=" + total + "]";
	}
   
}
