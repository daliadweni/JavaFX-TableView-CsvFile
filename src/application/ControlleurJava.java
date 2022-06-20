package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class ControlleurJava implements Initializable {
	@FXML
	public Button bt1;
	@FXML
	public Button bt2;
	@FXML
	public TextField nom;
	@FXML
	public TextField prenom;
	@FXML
	public TextField tel;
	@FXML
	public TextField adresse;
	@FXML
	public TableView<Contact> lst;
	@FXML
	public TableColumn nomCol;
	@FXML
	public TableColumn prenomCol;
	@FXML
	public TableColumn telCol;
	@FXML
	public TableColumn adresseCol;
	private final ObservableList<Contact> data = FXCollections.observableArrayList();

	public void add() {
		if (nom.getText().isEmpty() == false && prenom.getText().isEmpty() == false && tel.getText().isEmpty() == false
				&& adresse.getText().isEmpty() == false) {
			Contact c = new Contact(nom.getText(), prenom.getText(), tel.getText(), adresse.getText());
			lst.getItems().add(c);
			data.add(c);
			nom.clear();
			prenom.clear();
			tel.clear();
			adresse.clear();

		}

	}

	public void writeExcel() throws Exception {
		Writer writer = null;


		try {
			File file = new File("E:\\Contact.csv.");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("Nom ; Prénom  ; Téléphone ; Adresse \n");
			for (Contact person : data) {

				String text = person.getNom() + ";" + person.getPrenom() + ";" + person.getTel() + ";"
						+ person.getAdresse() + "\n";

				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			writer.flush();
			writer.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
		adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

	}

}
