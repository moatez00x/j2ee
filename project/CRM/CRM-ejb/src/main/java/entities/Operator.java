package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import java.util.List;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Operator
 *
 */
@Entity

public class Operator implements Serializable {

	   
	@Override
	public String toString() {
		return "Operator [idoperator=" + idoperator + ", usernameop=" + usernameop + ", passwordop=" + passwordop
				+ ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idoperator;
	private String usernameop;
	private String passwordop;
	private String name;
	private Integer phone;
	private String address;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Client> clients;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Claims> claims;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Deals> deals;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Offre> offre;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Promotion> promotion;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Product> product;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<SalesPoints> salespoints;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Bills> bills;
	@OneToMany( fetch=FetchType.EAGER)
	private List<Purchse> purchase;
	@OneToMany(mappedBy="Operator", fetch=FetchType.EAGER)
	private List<Abonnement> abonnement;
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
	public List<SalesPoints> getSalespoints() {
		return salespoints;
	}
	public void setSalespoints(List<SalesPoints> salespoints) {
		this.salespoints = salespoints;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public List<Promotion> getPromotion() {
		return promotion;
	}
	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}
	public List<Offre> getOffre() {
		return offre;
	}
	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}
	public List<Deals> getDeals() {
		return deals;
	}
	public void setDeals(List<Deals> deals) {
		this.deals = deals;
	}
	public List<Claims> getClaims() {
		return claims;
	}
	public void setClaims(List<Claims> claims) {
		this.claims = claims;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@OneToOne
	private Contract contract;
	public Contract getContact(){
		return contract;
	}
	public void setContact(Contract contract){
		this.contract=contract;
	}
	public Operator() {
		super();
	}   
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Integer getIdoperator() {
		return this.idoperator;
	}

	public void setIdoperator(Integer idoperator) {
		this.idoperator = idoperator;
	}   
	public String getUsernameop() {
		return this.usernameop;
	}

	public void setUsernameop(String usernameop) {
		this.usernameop = usernameop;
	}   
	public String getPasswordop() {
		return this.passwordop;
	}

	public void setPasswordop(String passwordop) {
		this.passwordop = passwordop;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   
}
