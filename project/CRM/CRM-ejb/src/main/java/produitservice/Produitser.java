package produitservice;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.mail.*;


import entities.Bills;
import entities.Client;
import entities.Operator;
import entities.Parcours;
import entities.Product;
import entities.Rating;
import entities.SalesPoints;

/**
 * Session Bean implementation class Produitser
 */
@Stateless
public class Produitser implements ProduitserRemote, ProduitserLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "CRM-ejb")
	EntityManager em;

	public Produitser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Operator findOperatorbyid(int id) {
		// TODO Auto-generated method stub
		return em.find(Operator.class, id);
	}
	
	@Override
	public void addProducts(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);
		em.flush();

	}

	@Override
	public boolean removeProduct(int id) {
		Product p=em.find(Product.class, id);
		em.remove(p);
		em.flush();
		return true;
	}

	@Override
	public boolean updateProduct(int id, int quant) {
		// TODO Auto-generated method stub
		 Query query = em.createQuery("UPDATE Product SET quantity = :q WHERE idproduct = :i");
		  query.setParameter("q",quant );
			query.setParameter("i", id);
			  int updateCount = query.executeUpdate();
		return true;
	}


	@Override
	public List<Product> listeproducts() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);

		return query.getResultList();
	}

	@Override
	public SalesPoints findSellpointbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findClientbyAddress(String ad, Operator Op) {
		// TODO Auto-generated method stub
		TypedQuery<Client> query = em.createQuery("select c from Client c where addresse =:a AND Operator =:o",
				Client.class);
		
		query.setParameter("a", ad);
		query.setParameter("o", Op);
		
		
		return query.getResultList();
	}

	@Override
	public List<SalesPoints> listesellpoints() {
		// TODO Auto-generated method stub
		TypedQuery<SalesPoints> query = em.createQuery("select s from SalesPoints s",SalesPoints.class);
		
		return query.getResultList();
	}

	@Override
	public void addSalePoints(SalesPoints s) {
		// TODO Auto-generated method stub
		em.persist(s);
		em.flush();

	}

	@Override
	public boolean removeSalesPoints(int id) {
		// TODO Auto-generated method stub
		SalesPoints s=em.find(SalesPoints.class, id);
		em.remove(s);
		em.flush();
		return true;
	}

	@Override
	public boolean updateSalesPoints(int id, String l) {
		// TODO Auto-generated method stub
		  Query query = em.createQuery("UPDATE SalesPoints SET location = :q WHERE idsales = :i");
		  query.setParameter("q", l);
			query.setParameter("i", id);
			  int updateCount = query.executeUpdate();
		return true;
	}

	@Override
	public Product findProductbyUrl(String url) {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = em.createQuery("select p from Product p where p.image =:i  ",Product.class);
		query.setParameter("i", url);
			Product product = null;
		
			product = query.getSingleResult();	
		
		return product;
	}


	@Override
	public List<Parcours> parcourspossibles(String clientlocation) {
		List<Parcours> par = new ArrayList<>() ;
		List<Parcours> parposs = new ArrayList<>() ;
		
		TypedQuery<Parcours> query = em.createQuery("select p from Parcours p  ",Parcours.class);
		par= query.getResultList();
		for(int i=0; i<par.size(); i++) {
			int index;
			index= par.get(i).getParcour().toString().indexOf("-");			
			String parp = par.get(i).getParcour().substring(0,index-1);
			if (parp == clientlocation){
				parposs.add(par.get(i));				
			} 			
			
	}
		
	return parposs;
	}

	@Override
	public List<Parcours> shortestparcours(List parcourspossibles) {
		List<Parcours> parposs = parcourspossibles ;
		List<Parcours> shortestpar =new ArrayList<>();
		for(int i=0; i<parposs.size(); i++) {
			if (parposs.get(i).getDistance()<5){
				shortestpar.add(parposs.get(i));
				}
			}

		return shortestpar ;
	}

	@Override
	public List<String> closelocations(List parcours) {
		List<Parcours> shortestpar =parcours;
		List<String> locations =new ArrayList<>() ;
		for (int i=0; i<shortestpar.size(); i++) {
			int index;
			index= shortestpar.get(i).getParcour().toString().indexOf("-");			
			String parp = shortestpar.get(i).getParcour().substring(index+1);
			locations.add(parp);
				}
	
		
		return locations;
	}

	@Override
	public List<SalesPoints> closestsellpoints(List<String> closelocation) {
		List<SalesPoints> closesales = new ArrayList<>() ;			

		for(int i=0; i<closelocation.size(); i++) {
		
			TypedQuery<SalesPoints> query = em.createQuery("select s from SalesPoints s  where location=l",SalesPoints.class);
			query.setParameter("l", closelocation.get(i));
			SalesPoints sp= query.getSingleResult();	
			closesales.add(sp);
			
		}
		
		return	closesales;	
	}

	@Override
	public List<Product> filter(int prix, String type) {
		TypedQuery<Product> query = em.createQuery("select p from Product p where price =:a AND type =:o  ",Product.class);
		query.setParameter("a", prix);
		query.setParameter("o", type);
		
		return query.getResultList();
	}

	@Override
	public void rateproduct(Rating r) {
		// TODO Auto-generated method stub
		em.persist(r);
		em.flush();
		
		
	}

	
}
