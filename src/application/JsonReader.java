package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonReader {

	public Trie openMusicFile(String userName) throws FileNotFoundException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		BufferedReader br = new BufferedReader(new FileReader("userMusics/"+ userName +"Musics.json"));
		Trie userMusics = gson.fromJson(br, Trie.class);
		return userMusics;
	}
	
	public BinarySearchTree openUsersFiles() throws FileNotFoundException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		BufferedReader br = new BufferedReader(new FileReader("users/usersTree.json"));
		BinarySearchTree user = gson.fromJson(br, BinarySearchTree.class);
		return user;
	}
}
