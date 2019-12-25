package servicefacture;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Abonnement;
import entities.Bills;
import entities.Client;
import entities.Operator;
import entities.Product;
import entities.Purchse;



/**
 * Session Bean implementation class Facture
 */
@Stateless
public class Facture implements FactureRemote, FactureLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="CRM-ejb")
	EntityManager em;
    public Facture() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addBill(Bills b) {
		// TODO Auto-generated method stub
		em.persist(b);
		em.flush();
	}

	@Override
	public List<Bills> listefacture(Operator Operator) {
		// TODO Auto-generated method stub
		TypedQuery<Bills> query = em.createQuery("select c from Bills c where c.Operator=:Operator",Bills.class);
		query.setParameter("Operator", Operator);
		return query.getResultList();
	}
	@Override
	public List<Client> listeclient() {
		// TODO Auto-generated method stub
		TypedQuery<Client> query = em.createQuery("select e from Client e",Client.class);
		
		return query.getResultList();
	}

	

	@Override
	public Bills findBillbyid(int id) {
		// TODO Auto-generated method stub
	
		return em.find(Bills.class, id);
	}

	@Override
	public boolean removebill(int id) {
		// TODO Auto-generated method stub
		Bills b=em.find(Bills.class, id);
		em.remove(b);
		em.flush();
		return true;
		
	}

	@Override
	public void addPurchase(Purchse p) {
		// TODO Auto-generated method stub
		em.persist(p);
		em.flush();
	}

	@Override
	public List<Product> listproduit() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = em.createQuery("select p from Product p",Product.class);
		
		return query.getResultList();
	}

	@Override
	public Client findClientbyCin(int cin,Operator Operator) {
		// TODO Auto-generated method stub
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.cin =:cin and c.Operator=:Operator ",Client.class);
		query.setParameter("cin", cin);
		query.setParameter("Operator", Operator);
		Client client = null;
		try
		{
			client = query.getSingleResult();	
		}
		catch (Exception e) {
			System.out.println("no client found with this cin"+cin);
		}
		return client;
	}

	@Override
	public Operator findOperatorbyid(int id) {
		// TODO Auto-generated method stub
		return em.find(Operator.class, id);
	}

	@Override
	public boolean updateProduit(String name, int q) {
		// TODO Auto-generated method stub
		/*Product produit=new Product();
		TypedQuery<Product> query = em.createQuery("select p from Product p where p.name =:name ",Product.class);
		query.setParameter("name", name);
		produit=query.getSingleResult();	
		em.getTransaction().begin();
		  produit.setQuantity(quantity);
		  em.getTransaction().commit();*/
		  Query query = em.createQuery("UPDATE Product SET quantity = :q WHERE name = :name");
		  query.setParameter("q", q);
			query.setParameter("name", name);
			  int updateCount = query.executeUpdate();
		return true;
	}

	@Override
	public List<Purchse> listpurchase() {
		// TODO Auto-generated method stub
TypedQuery<Purchse> query = em.createQuery("select p from Purchse p",Purchse.class);
		
		return query.getResultList();
	}

	@Override
	public boolean removepurchase(int id) {
		// TODO Auto-generated method stub
		Purchse b=em.find(Purchse.class, id);
		em.remove(b);
		em.flush();
		return true;
		
	}

	@Override
	public boolean updateBill(int id,String type) {
		// TODO Auto-generated method stub
		  Query query = em.createQuery("UPDATE Bills SET etat = true , paymentdate = now() , paymenttype = :type WHERE idbill = :id");
		  query.setParameter("id", id);
		  query.setParameter("type", type);
			
			  int updateCount = query.executeUpdate();
		return true;
		
	}

	@Override
	public Bills findBillbyCin(Client c) {
		// TODO Auto-generated method stub
		TypedQuery<Bills> query = em.createQuery("select c from Bills c where c.Client =:c ",Bills.class);
		
		query.setParameter("c", c);
		Bills b = null;
		try
		{
			b = query.getSingleResult();	
		}
		catch (Exception e) {
			System.out.println("no Bill found with this cin"+c.toString());
		}
		return b ;
	}

	@Override
	public List<Bills> paidlist(Client c) {
		// TODO Auto-generated method stub
		TypedQuery<Bills> query = em.createQuery("select c from Bills c where c.etat = 1 and c.client =:c ",Bills.class);
		query.setParameter("c", c);
		
		return query.getResultList();
	}

	@Override
	public List<Bills> notpaidlist(Client c) {
		// TODO Auto-generated method stub
		TypedQuery<Bills> query = em.createQuery("select c from Bills c where c.etat = 0 and c.client =:c",Bills.class);
		query.setParameter("c", c);
	
		return query.getResultList();	
	}

	@Override
	public boolean updateBills(int reference, String type) {
		// TODO Auto-generated method stub
		 Query query = em.createQuery("UPDATE Bills SET etat = true , paymentdate = now() , paymenttype = :type WHERE reference = :reference");
		  query.setParameter("reference", reference);
		  query.setParameter("type", type);
			
			  int updateCount = query.executeUpdate();
		return true;
	}

	@Override
	public List<Abonnement> listeabonnement() {
		// TODO Auto-generated method stub
TypedQuery<Abonnement> query = em.createQuery("select e from Abonnement e",Abonnement.class);
		
		return query.getResultList();
	}

	@Override
	public List<Bills> listebills() {
		// TODO Auto-generated method stub
TypedQuery<Bills> query = em.createQuery("select e from Bills e",Bills.class);
		
		return query.getResultList();
	}

	@Override
	public Bills findBillbyreference(int reference) {
		// TODO Auto-generated method stub
		TypedQuery<Bills> query = em.createQuery("select c from Bills c where c.reference = :reference",Bills.class);
		query.setParameter("reference", reference);
		Bills b = null;
		try
		{
			b = query.getSingleResult();	
		}
		catch (Exception e) {
			System.out.println("no Bill found with this cin"+reference);
		}
		return b ;
		
	}


	


}
