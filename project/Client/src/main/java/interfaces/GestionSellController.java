package interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Product;
import entities.SalesPoints;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import produitservice.ProduitserRemote;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class GestionSellController {
	@FXML
	private ImageView gotosell_butt;
	@FXML
	private ImageView back;
	@FXML
	private AnchorPane ajoutPane;
	@FXML
	private TextField newprod_nom;
	@FXML
	private TextField newprod_type;
	@FXML
	private Button prodadd_butt;
	@FXML
	private TextField newprod_price;
	@FXML
	private TextField newprod_quantity;
	@FXML
	private TextField newprod_image;
	@FXML
	private TextField prodecuid_del;
	@FXML
	private Button deleteprod_butt;
	@FXML
	private TextField productid_upd;
	@FXML
	private TextField productquantity_upd;
	@FXML
	private Button produpdate_butt;

	// Event Listener on ImageView[#gotosell_butt].onMouseClicked
	@FXML
	public void gotosell(MouseEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("sellPoints.fxml"));
	     
		 gotosell_butt.getScene().setRoot(root);
	}

	// Event Listener on ImageView[#back].onMouseClicked
	@FXML
	public void backtoprod(MouseEvent event) throws IOException {
		// TODO Autogenerated
		Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
	     
		back.getScene().setRoot(root);
	}

	// Event Listener on Button[#prodadd_butt].onMouseClicked
	@FXML
	public void product_add(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s = (ProduitserRemote) context.lookup(j2);
	
		List products = new ArrayList();
		Boolean exist = true;
		
		for (Product l : s.listeproducts()) {
			if (l.getName().equals( newprod_nom.getText())) {
				exist = false;

			} else
				exist = true;
		}

		if (exist == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Product already exists");
			alert.showAndWait();
		} else {
			Product p = new Product();
			
			p.setName(newprod_nom.getText());
			p.setType(newprod_type.getText());
			int price = Integer.parseInt(newprod_price.getText());
			p.setPrice(price);
			int quant = Integer.parseInt(newprod_quantity.getText());
			p.setQuantity(quant);
			p.setImage(newprod_image.getText());
			p.setOperator(s.findOperatorbyid(1));
			s.addProducts(p);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Product successfully added");
			alert.showAndWait();
		}

	}

	// Event Listener on Button[#deleteprod_butt].onMouseClicked
	@FXML
	public void delete_prod(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		int i = Integer.parseInt(prodecuid_del.getText());
		s.removeProduct(i);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Product successfully removed");
		alert.showAndWait();
		
		
	}

	// Event Listener on Button[#produpdate_butt].onMouseClicked
	@FXML
	public void prod_update(MouseEvent event) throws NamingException {
		// TODO Autogenerated
		Context context;
		context = new InitialContext();
		String j2 = "/CRM-ear/CRM-ejb/Produitser!produitservice.ProduitserRemote";
		ProduitserRemote s= (ProduitserRemote) context.lookup(j2);
		int i = Integer.parseInt(productid_upd.getText());
		int j= Integer.parseInt(productquantity_upd.getText());
		s.updateProduct(i,j);	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Product successfully updated");
		alert.showAndWait();
	
	}
}