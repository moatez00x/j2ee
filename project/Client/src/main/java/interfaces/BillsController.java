package interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Abonnement;
import entities.Bills;
import entities.Client;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javassist.tools.Callback;
import servicefacture.FactureRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class BillsController implements Initializable  {
	@FXML
	private TextField searchbill;
	@FXML
	private TextField cin;
	@FXML
	private TextField clientname;
	@FXML
	private TableView<Bills> bills;
	@FXML
	private TableColumn<Bills,Integer> reference;
	@FXML
	private TableColumn<Bills, String> paymenttype;
	@FXML
	private TableColumn<Bills,Date> paymentdate;
	@FXML
	private TableColumn<Bills,Date> date;
	@FXML
	private TableColumn<Bills,Float> amount;
	@FXML
	private TableColumn<Bills,String> bill;
	@FXML
	private TableColumn<Bills,Boolean> state;
	@FXML
	private Button cashpay;
	@FXML
	private Button cardpay;
	@FXML
	private Button print;
	@FXML
	private ImageView back;
	@FXML
	private ImageView billsmenu;
	@FXML
	private ImageView sales;
	@FXML
	private ImageView reload;
	@FXML
	private ComboBox<String> type;
	@FXML
	private Label idoperator;
	
	
	  ObservableList<String> T =FXCollections.observableArrayList("Cash","Card","Check");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			List billiste= new ArrayList();
			List clientliste;
			
			type.setItems(T);
			//---------------context--------------------
			Context context;
			
			context = new InitialContext();
			String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
			FactureRemote s= (FactureRemote) context.lookup(j2);
			//-----------------------------------------------
			
			billiste=s.listefacture(s.findOperatorbyid(Integer.parseInt(idoperator.getText())));
			
			ObservableList<Bills> OL = FXCollections.observableArrayList(billiste);
			
			bills.setItems(OL);
			reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
			paymenttype.setCellValueFactory(new PropertyValueFactory<>("paymenttype"));
			paymentdate.setCellValueFactory(new PropertyValueFactory<>("paymentdate"));
			date.setCellValueFactory(new PropertyValueFactory<>("date"));
			amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
			bill.setCellValueFactory(new PropertyValueFactory<>("name"));
			state.setCellValueFactory(new PropertyValueFactory<>("etat"));
			
			//-----------------------------------
		
			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
	        FilteredList<Bills> filteredData = new FilteredList<>(OL, p -> true);
	        
	        // 2. Set the filter Predicate whenever the filter changes.
	        searchbill.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(Bill -> {
	                // If filter text is empty, display all persons.
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }
	                
	                // Compare 
	               
	                String lowerCaseFilter = newValue.toLowerCase();
	                
	                if (String.valueOf(Bill.getReference()).toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } 
	             
	                 return false;
	            });
	        });
	        
	        // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<Bills> sortedData = new SortedList<>(filteredData);
	        
	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(bills.comparatorProperty());
	        
	        // 5. Add sorted (and filtered) data to the table.
	        bills.setItems(sortedData);
			System.out.println(OL);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	// Event Listener on TableView[#bills].onMouseClicked
	@FXML
	public void selectbill(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		//------------------context-----------------------
		Context context;
		
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
		FactureRemote s= (FactureRemote) context.lookup(j2);
		//----------------selected bill---------------------
		int ref =bills.getSelectionModel().getSelectedItem().getIdbill();
		
		Bills b= new Bills();
		Client c= new Client();
		b=s.findBillbyid(ref);
		c=b.getClient();
		cin.setText(String.valueOf(c.getCin()));
		clientname.setText(c.getName());
	
		
	}
	// Event Listener on Button[#cashpay].onMouseClicked
	@FXML
	public void cashpayement(MouseEvent event) throws NamingException, IOException {
		// TODO Autogenerated
		//------------------context-----------------------
		Context context;
		
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
		FactureRemote s= (FactureRemote) context.lookup(j2);
		//----------------update bill---------------------
		boolean state =bills.getSelectionModel().getSelectedItem().getEtat();
		if(state==true)
		{
			 Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Bill already been paid!");
			   alert.showAndWait();
		}
		else{
		
		int ref =bills.getSelectionModel().getSelectedItem().getIdbill();
		s.updateBill(ref, type.getValue());
		 Alert alert = new Alert(AlertType.INFORMATION);
		   alert.setTitle("Information Dialog");
		   alert.setHeaderText(null);
		   alert.setContentText("Bill had been paid!");
		   alert.showAndWait();
		   Parent root = FXMLLoader.load(getClass().getResource("Bills.fxml"));
		   cashpay.getScene().setRoot(root);}
	}
	// Event Listener on Button[#cardpay].onMouseClicked
	@FXML
	public void cardpayment(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#print].onMouseClicked
	@FXML
	public void printbill(MouseEvent event) throws IOException {
		// TODO Autogenerated
		if(bills.getSelectionModel().getSelectedItem().getEtat()==false)
		{
			 Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Bill is not paid yet!");
			   alert.showAndWait();
		}
		else
		{int data =bills.getSelectionModel().getSelectedItem().getReference();
		String billname =bills.getSelectionModel().getSelectedItem().getName();
		Float montant =bills.getSelectionModel().getSelectedItem().getAmount();
		String paytype =bills.getSelectionModel().getSelectedItem().getPaymenttype();
		Date payday =bills.getSelectionModel().getSelectedItem().getPaymentdate();
		String clientn=clientname.getText();
		String cinn=cin.getText();
		String sampleText="reference: \n" + String.valueOf(data) +"\n"
				+"\n Bill: \n "+ billname +"\n"
				+"\n Client name: \n" + clientn +"\n"
				+"\n client cin: \n" + String.valueOf(cinn) +"\n"
				+"\n Amount: \n" + String.valueOf(montant)+ "\n"
				+"\n payment Type: \n"+ paytype +"\n"
				+"\n payment Day: \n"+ String.valueOf(payday)+"\n";
		 Text sample = new Text(sampleText);
	        sample.setFont(new Font(14));
	        FileChooser fileChooser = new FileChooser();
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
 
            //Show save file dialog
            
            Stage primaryStage=new Stage();
            
            primaryStage.setTitle("Bills and Sales management");
	    
            File file = fileChooser.showSaveDialog(primaryStage);
 
            if (file != null) {
                saveTextToFile(sampleText, file);
            }
		}
	}
	// Event Listener on ImageView[#back].onMouseClicked
	@FXML
	public void back(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ImageView[#billsmenu].onMouseClicked
	@FXML
	public void billsredirection(MouseEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("FusedBills.fxml"));
		   billsmenu.getScene().setRoot(root);
	}
	// Event Listener on ImageView[#sales].onMouseClicked
	@FXML
	public void salesredirection(MouseEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("Devis.fxml"));
		   sales.getScene().setRoot(root);
	}
    private void saveTextToFile(String content, File file) throws FileNotFoundException {
        
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        
    }
    @FXML
	public void refresh(MouseEvent event) throws NamingException
	{
    	//------------------context-----------------------
    			Context context;
    			
    			context = new InitialContext();
    			String j2 = "/CRM-ear/CRM-ejb/Facture!servicefacture.FactureRemote";
    			FactureRemote s= (FactureRemote) context.lookup(j2);
    			//----------------update bill---------------------
    	List<Bills> bill= new ArrayList();
		  Bills b=new Bills();
		  for(Abonnement l :s.listeabonnement()){
            // libsNoms.add(Integer.toString(l.getNum_vol())+l.getCompagnie

			
				  
			
				 
				 if(s.findBillbyreference(l.getReference())==null)
				 
				 {
				  b.setAmount(l.getAmount());
				  b.setReference(l.getReference());
				  b.setClient(l.getClient());
				  b.setOperator(l.getOperator());
				  b.setEtat(false);
				  b.setDate(l.getDate());
				  s.addBill(b);
				System.out.println(b.toString());
				 }
			
			  //System.out.println(s.listeabonnement());
			
		   		}
		
	}
}
