package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileWriter {
	
	public void write(Trie trie) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(trie);
	}
}
