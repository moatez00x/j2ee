package interfaces;




import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Abonnement;
import entities.Bills;
import entities.Client;
import entities.Contract;
import entities.Operator;
import entities.Product;
import entities.SalesPoints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import produitservice.ProduitserRemote;
import servicefacture.FactureRemote;
import services.AhmedRemote;


public class Main {

	public static void main(String[] args) throws NamingException{
		// TODO Auto-generated method stub
	
		
			Context context =  new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		
		/*//--------------------------------------------------
		
		o.setPhone(52525252);
	
	
		//-------------------------------
				Client c= new Client();
				c.setIdclient(1);
				c.setName("Ahmed");
				c.setOperator(o);
		//----------------------------------------------------------------------
		Bills b2=new Bills();
		b2.setAmount(120);
		b2.setName("offre");
		b2.setPaymenttype("cache");
		b2.setReference(125);
		String str2="2015-03-31";
		Date date2=Date.valueOf(str2);
		String str3="2019-01-31";
		Date date3=Date.valueOf(str3);	
		b2.setDate(date2);
		b2.setPaymentdate(date3);
		b2.setEtat(true);
		b2.setClient(c);
		b2.setOperator(o);
		
		s.addBill(b2);
		//----------------------------------------------------------------
		
		String s1="2019-04-04";
		Date d=Date.valueOf(s1);
		String s2="2019-04-04";
		Date d2=Date.valueOf(s2);	
		Contract ct=new Contract();
		ct.setIdcontrat(1);
		ct.setDatedebut(d);
		ct.setDatefin(d2);
		ct.setType("gold");
		ct.setPrice(150);
		//----------------------------------------------
		
		Operator o=new Operator();
		
		o.setAddress("dddd");
		o.setPasswordop("dd");
		
		o.setUsernameop("ddd");
		o.setName("dd");
		Bills b2=new Bills();
		b2.setAmount(120);
		b2.setName("offre");
		b2.setPaymenttype("cache");
		b2.setReference(125);
		String str2="2015-03-31";
		Date date2=Date.valueOf(str2);
		String str3="2019-01-31";
		Date date3=Date.valueOf(str3);	
		b2.setDate(date2);
		b2.setPaymentdate(date3);
		b2.setEtat(true);
		s.addBill(b2);
		 
		//System.out.println(s.listefacture().toString());
		Client c=new Client();
		c.setIdclient(2);
		c.setName("malek");
		
		List l=new ArrayList();
		List d=new ArrayList();
		d=s.listefacture();
		l=s.listeclient();
		List all =new ArrayList();
		all.add(d.addAll(l));
		
		System.out.println(d);*/
		
		/*List<String> a=new ArrayList();
		
		   for(Bills l :s.listefacture()){
               // libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie
         
			   Client c= new Client();
			   if (l.getIdbill()==4)
			   {
				   c=l.getClient();
			   
			System.out.println(c.getCin()+" "+c.getName());
			   }
		/*/
			
		
	
		

		
		  
		  
		
}
}
