package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUserController implements Initializable{

	@FXML
	private TextField nome;
	
	@FXML
	private TextField senha;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	public void Cadastrar() {
		BinarySearchTree users = new BinarySearchTree();
		JsonReader reader = new JsonReader();
		try {
			users = reader.openUsersFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String name = nome.getText();
		String pass = senha.getText();
		nome.setText(null);
		senha.setText(null);
		
		if(name != null && pass != null) {
			User user = new User(name, pass);
			users.insert(user);
		}
		
		JsonWriter writer = new JsonWriter();
		try {
			writer.write(users);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
