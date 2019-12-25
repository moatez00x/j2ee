package servicefacture;


import java.util.List;

import javax.ejb.Remote;

import entities.Abonnement;
import entities.Bills;
import entities.Client;
import entities.Operator;
import entities.Product;
import entities.Purchse;


@Remote
public interface FactureRemote {
	void addBill (Bills b);
	void addPurchase (Purchse p);
	List<Bills> listefacture(Operator Operator);

	List<Client> listeclient();
	List<Bills> listebills();
	List<Abonnement> listeabonnement();
	List<Product> listproduit();
	List<Purchse> listpurchase();
	Bills findBillbyid(int id);
	Bills findBillbyreference(int reference);
	boolean removebill(int id);
	boolean removepurchase(int id);
	Client findClientbyCin(int cin,Operator Operator);
	Operator findOperatorbyid(int id);
	boolean updateProduit(String name,int q);
	boolean updateBill(int id,String type);
	boolean updateBills(int reference,String type);
	Bills findBillbyCin(Client c);
	List<Bills> paidlist(Client c);
	List<Bills> notpaidlist(Client c);
}
