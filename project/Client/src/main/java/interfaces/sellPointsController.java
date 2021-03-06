package interfaces;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Bills;
import entities.Client;
import entities.Product;
import entities.SalesPoints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import produitservice.ProduitserRemote;

import javafx.scene.input.KeyEvent;

import javafx.scene.control.TableView;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;

public class sellPointsController implements Initializable {
	@FXML
	private ImageView add_butt;
	@FXML
	private ImageView productbutt;
	@FXML
	private ImageView delete_butt;
	@FXML
	private ImageView refresh_butt;
	
	@FXML
	private TableView<SalesPoints> table_sell;
	@FXML
	private TableColumn<SalesPoints,Integer> saleid;
	@FXML
	private TableColumn<SalesPoints,String> salelocation;
	@FXML
	private TableColumn<SalesPoints,Integer> salephone;
	@FXML
	private TextField recherchefield;
	@FXML
	private TableView table_client;
	@FXML
	private TableColumn clientname;
	@FXML
	private TableColumn clientsurname;
	@FXML
	private TableColumn clientid;
	
	@FXML
	private TextField newsalelocation;
	@FXML
	private TextField newsalephone;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Context context;
		try {
			context = new InitialContext();
			String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
			ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
			
			//-----------------------------------------------
		
		List sellpoints= new ArrayList();
		sellpoints= s.listesellpoints();
		ObservableList<SalesPoints> OL = FXCollections.observableArrayList(sellpoints);
	    table_sell.setItems(OL);
		
	    saleid.setCellValueFactory(new PropertyValueFactory<>("idsales"));
		salelocation.setCellValueFactory(new PropertyValueFactory<>("location"));
		salephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<SalesPoints> filteredData = new FilteredList<>(OL, p -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        recherchefield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(sellpoint -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare 
               
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (sellpoint.getLocation().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } 
             
                 return false;
            });
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<SalesPoints> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table_sell.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        table_sell.setItems(sortedData);
		System.out.println(OL);
		
		//-----------------------------------------------
		
		
		//-----------------------------------------------
	
	
		
		} 
		
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Event Listener on ImageView[#add_butt].onMouseClicked
	@FXML
	public void add_sell(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		List sellpoints= new ArrayList();
		Boolean exist = true;
		SalesPoints sl = new SalesPoints();
		 for(SalesPoints l : s.listesellpoints()){
			 if(l.getLocation().equals(newsalelocation.getText())){
				 exist=false;
				 
			 }
			
		 }
		
     
         if(exist==false)
 		{
 			  Alert alert = new Alert(AlertType.INFORMATION);
 			   alert.setTitle("Information Dialog");
 			   alert.setHeaderText(null);
 			   alert.setContentText("Location already exists");
 			   alert.showAndWait();}
         else{
        	 
        	   int Phone=Integer.parseInt(newsalephone.getText());
               sl.setPhone(Phone);      
                sl.setLocation(newsalelocation.getText());
                sl.setOperator(s.findOperatorbyid(1));
        	  s.addSalePoints(sl);
        		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Dialog");
    			alert.setHeaderText(null);
    			alert.setContentText("SellPoint successfully added");
    			alert.showAndWait();
         }
         
 		
		
		
	}

	// Event Listener on ImageView[#productbutt].onMouseClicked
	@FXML
	public void gotoproduct(MouseEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
	     
		productbutt.getScene().setRoot(root);
	}

	// Event Listener on ImageView[#delete_butt].onMouseClicked
	@FXML
	public void delete_sell(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		
		
		int ref =((SalesPoints) table_sell.getSelectionModel().getSelectedItem()).getIdsales();
		s.removeSalesPoints(ref);
		
		}
	
	@FXML
    void clientup(MouseEvent event) throws NamingException {
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		
		List Clients=new ArrayList();
		String ref =((SalesPoints) table_sell.getSelectionModel().getSelectedItem()).getLocation();
		System.out.println(ref);
		Clients = s.findClientbyAddress(ref, s.findOperatorbyid(1));
		
		ObservableList<Client> OL1 = FXCollections.observableArrayList(Clients);
		table_client.setItems(OL1);
		
		clientname.setCellValueFactory(new PropertyValueFactory<>("name"));
		clientsurname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		clientid.setCellValueFactory(new PropertyValueFactory<>("idclient"));
    }

	// Event Listener on ImageView[#refresh_butt].onMouseClicked
	@SuppressWarnings("unchecked")
	@FXML
	public void refresh_page(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		
	
	
	List sellpoints= new ArrayList();
	sellpoints= s.listesellpoints();
	ObservableList<SalesPoints> OL = FXCollections.observableArrayList(sellpoints);
    table_sell.setItems(OL);
	
	//-----------------------------------------------
	saleid.setCellValueFactory(new PropertyValueFactory<>("idsales"));
	salelocation.setCellValueFactory(new PropertyValueFactory<>("location"));
	salephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	}


}
