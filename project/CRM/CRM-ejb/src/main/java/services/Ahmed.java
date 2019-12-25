package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Product;

/**
 * Session Bean implementation class Ahmed
 */
@Stateless
@LocalBean
public class Ahmed implements AhmedRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="CRM-ejb")
	EntityManager em;
    public Ahmed() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);
		em.flush();
	
	}

}
