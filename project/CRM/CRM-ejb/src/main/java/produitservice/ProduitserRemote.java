package produitservice;

import java.util.List;

import javax.ejb.Remote;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import entities.Client;
import entities.Operator;
import entities.Parcours;
import entities.Product;
import entities.Rating;
import entities.SalesPoints;

@Remote
public interface ProduitserRemote {
	void addProducts (Product p);
	boolean removeProduct(int id);
	boolean updateProduct(int id,int quant);
	List<Product> listeproducts();
	
	Operator findOperatorbyid(int id);
	Product findProductbyUrl(String url);
	SalesPoints findSellpointbyId(int id);
	List<Client> findClientbyAddress(String ad,Operator Op);
	List<SalesPoints> listesellpoints();
	void addSalePoints (SalesPoints s);
	boolean removeSalesPoints(int id);
	boolean updateSalesPoints(int id,String l);
	
	
	List <Parcours> parcourspossibles (String clientlocation);
	List <Parcours> shortestparcours (List parcourspossibles);
	List <String> closelocations(List parcours);
	List <SalesPoints> closestsellpoints (List<String> closelocation);
	
	List <Product> filter (int prix , String type);
	void rateproduct (Rating r);
	
	
}
