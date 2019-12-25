package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproduct;
	private String name;
	private String type;
	private Integer price;
	private Integer quantity;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;

	public Operator getOperator() {
		return Operator;
	}

	public void setOperator(Operator operator) {
		Operator = operator;
	}

	public Product() {
		super();
	}

	public Integer getIdproduct() {
		return this.idproduct;
	}

	public void setIdproduct(Integer idproduct) {
		this.idproduct = idproduct;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
