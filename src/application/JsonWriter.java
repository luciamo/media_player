package application;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {
	
	public void write(Trie trie, String userName) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(trie);
		FileWriter fileWriter = new FileWriter("usersMusics/" + userName + "Musics.json");
        fileWriter.write(jsonString);
        fileWriter.close();
	}
	
	public void write(BinarySearchTree bst) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(bst);
		FileWriter fileWriter = new FileWriter("users/usersTree.json");
        fileWriter.write(jsonString);
        fileWriter.close();
	}
}
