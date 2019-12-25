package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idclient;
	private Integer cin;
	private String password;
	private String name;
	private String email;
	private Integer phone;
	private String addresse;
	private String prenom;
	
	private static final long serialVersionUID = 1L;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Operator Operator;
	
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Claims> claims;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Bills> bills;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Abonnement> abonnement;
	@OneToMany( fetch=FetchType.EAGER)
	private List<Purchse> purchase;

	public List<Abonnement> getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(List<Abonnement> abonnement) {
		this.abonnement = abonnement;
	}
	public List<Purchse> getPurchase() {
		return purchase;
	}
	public void setPurchase(List<Purchse> purchase) {
		this.purchase = purchase;
	}
	public List<Bills> getBills() {
		return bills;
	}
	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}
	public List<Claims> getClaims() {
		return claims;
	}
	public void setClaims(List<Claims> claims) {
		this.claims = claims;
	}

	public Client() {
		super();
	}   
	public Integer getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}   
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}   
	public String getAddresse() {
		return this.addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   

	public Operator getOperator() {
		return Operator;
	}
	public void setOperator(Operator doctor) {
		this.Operator = doctor;
	}
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", cin=" + cin + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", addresse=" + addresse + ", prenom=" + prenom + "]";
	}

   
}
