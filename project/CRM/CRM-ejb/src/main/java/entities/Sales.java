package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sales
 *
 */
@Entity

public class Sales implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idsales;
	private String items;
	private Integer quantity;
	private float unitprice;
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Operator operator;
	@OneToOne
	private Product product;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Sales() {
		super();
	}   
	public Integer getIdsales() {
		return this.idsales;
	}

	public void setIdsales(Integer idsales) {
		this.idsales = idsales;
	}   
	public String getItems() {
		return this.items;
	}

	public void setItems(String items) {
		this.items = items;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}   
	public float getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
   
}
