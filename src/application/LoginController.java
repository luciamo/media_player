package application;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	BinarySearchTree users = new BinarySearchTree();
	
	@FXML
	private TextField textUser;
	
	@FXML
	private TextField textPassWord;

	public void login(ActionEvent e)
	{
		String userName = textUser.getText();
		String passWord = textPassWord.getText();		
		
		if(userExist(userName)){
			if(users.publicSearch(userName).comparePassword(passWord)) {
				try {
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/PlayerScreen.fxml"));
					Parent root = loader.load();
					
					PlayerController player = loader.getController();
					player.initData(users.publicSearch(userName));
					
					Stage primaryStage = new Stage();
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					((Stage) ((Node) e.getSource()).getScene().getWindow()).close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			} else {
				System.out.println("Senha incorreta!");
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadUsers();
	}
	
	public void loadUsers() {
		JsonReader reader = new JsonReader();
		try {
			users = reader.openUsersFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userExist(String userName) {
		User user = users.publicSearch(userName);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}
}
