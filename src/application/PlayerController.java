package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class PlayerController implements Initializable{

	User user;
	
	@FXML
	private Text userName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void initData(User user) {
		this.user = user;
		userName.setText(user.getUserName());
	}
}
