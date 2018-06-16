package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/LoginScreen.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
		//Testando a Trie
		Trie arvore = new Trie();
		
		arvore.insertMusic("casa", "1");
		arvore.insertMusic("casal", "2");
		arvore.insertMusic("casca", "3");
		
		char[] teste = new char[26];
		ArrayList<String> testearr = arvore.listMusics(arvore.getRoot(), teste, 0);

		for(int i=0; i<testearr.size(); i++)
		{
			System.out.println(testearr.get(i));
		}	
		
		//removendo casa
		arvore.removeMusic("casa");
		
		testearr.clear();
		System.out.println("Depois da remo��o de casa--------");
		testearr = arvore.listMusics(arvore.getRoot(), teste, 0);

		for(int i=0; i<testearr.size(); i++)
		{
			System.out.println(testearr.get(i));
		}
		
		//insere casa denovo
		arvore.insertMusic("casa", "1");
		
		testearr.clear();
		System.out.println("inseriu casa denovo casa--------");
		testearr = arvore.listMusics(arvore.getRoot(), teste, 0);

		for(int i=0; i<testearr.size(); i++)
		{
			System.out.println(testearr.get(i));
		}
		
		//removendo casca
		arvore.removeMusic("casca");
		
		testearr.clear();
		System.out.println("Depois da remo��o de casca--------");
		testearr = arvore.listMusics(arvore.getRoot(), teste, 0);

		for(int i=0; i<testearr.size(); i++)
		{
			System.out.println(testearr.get(i));
		}
		
		//Luciano Testando ----------------------------------------------------------
		User l = new User("luciano", "duduazul");
		User j = new User("joseh", "hesoj");
		User n = new User("natalia", "natamigadosanimais");
        BinarySearchTree lucianTree = new BinarySearchTree(l);
        lucianTree.insert(j);
        lucianTree.insert(n);
        //lucianTree.print();
        BinarySearchTreeNode luc = null;

        String x = "luciano";
        if(lucianTree.publicSearch(x) != null)
        {
             luc = lucianTree.publicSearch(x);
        }
        if(luc != null)
        {
            System.out.println(luc.getUser().getUserName());
        }
	}
}