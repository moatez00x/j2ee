
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.mail.*; 
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import produitservice.Produitser;
import entities.SalesPoints;


@ManagedBean(name = "salespointsBean")
@SessionScoped
public class SalesPointsBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idsales;
	private String location;
	private Integer phone;
	private String  horaire;
	private List<SalesPoints> ls;
	
	@EJB
	Produitser salespointsService;

	public Integer getIdsales() {
		return idsales;
	}

	public void setIdsales(Integer idsales) {
		this.idsales = idsales;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public List<SalesPoints> getLs() {
		return salespointsService.listesellpoints();
	}

	public void setLs(List<SalesPoints> ls) {
		this.ls = ls;
	}
	
	
	
	


   
	
	
	
	
	
}