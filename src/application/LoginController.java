package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {

	@FXML
	private TextField textUser;
	
	@FXML
	private TextField textPassWord;

	public void login(ActionEvent e)
	{
		if(textUser.getText().equals("user") && textPassWord.getText().equals("pass")) {
			try {
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/PlayerScreen.fxml"));
				Scene scene = new Scene(root,800,600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}
