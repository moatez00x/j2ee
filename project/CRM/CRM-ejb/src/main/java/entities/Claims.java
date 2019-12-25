package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claims
 *
 */
@Entity

public class Claims implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClaims;
	private String object;
	private String contenu;
	private boolean state;
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator operator) {
		Operator = operator;
	}

	public TypeClaim getType() {
		return type;
	}
	public void setType(TypeClaim type) {
		this.type = type;
	}

	private TypeClaim type;
	private static final long serialVersionUID = 1L;

	public Claims() {
		super();
	}   
	public Integer getIdClaims() {
		return this.idClaims;
	}

	public void setIdClaims(Integer idClaims) {
		this.idClaims = idClaims;
	}   
	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}   
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}   
	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
