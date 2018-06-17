package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PlayerController implements Initializable{
	
	private Trie userMusics = new Trie();
	private User user;
	private String currentSelectedPlaylist;
	private MediaPlayer player;
	
	@FXML
	private Text userName;
	
	@FXML
	private Text currentPlayList;
	
	@FXML
	private ListView<String> listViewMusicas; 
	
	@FXML
	private ListView<String> listViewMusicasPlyList;
	
	@FXML
	private ListView<String> listViewPlaylists;
	
	@FXML
	private TextField playlistNome;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	/**
	 * Método para carregar as informações do usuario 
	 */
	public void initData(User user) {
		this.user = user;
		userName.setText(user.getUserName());
		loadUserMusics();
		loadListViewMusics();
		loadListViewPlaylists();
	}
	
	/**
	 * Método utilizado para adicionar uma musica na arvore de musicas do usuario
	 */
	public void addMusic(){		
		FileChooser filechooser = new FileChooser();
		File file = filechooser.showOpenDialog(null);
		String fileName = file.getName().toLowerCase().replaceAll("\\s","");
		String filePath = file.toURI().toString();
		
		if(filePath != null) {
			int index = fileName.indexOf(".");
			fileName = fileName.substring(0, index);
			userMusics.insertMusic(fileName, filePath);
			loadListViewMusics();
			saveUserMusics();
		}
	}
	
	/**
	 * Método utilizado para remover uma musica na arvore de musicas do usuario
	 */
	public void removeMusic() {
		String musica = listViewMusicas.getSelectionModel().getSelectedItem();
		if(musica != null) {
			userMusics.removeMusic(musica);
			loadListViewMusics();
			saveUserMusics();
		}
	}
	
	/**
	 * Método para carregar as musicas do usuario
	 */
	public void loadUserMusics() {
		JsonReader loader = new JsonReader();
		try {
			userMusics = loader.openMusicFile(user.getUserName());
		} catch (FileNotFoundException e) {
			saveUserMusics();
		}
	}
	
	/**
	 * Método para salvar as musicas do usuario
	 */
	public void saveUserMusics() {
		JsonWriter writer = new JsonWriter();
		try {
			writer.write(userMusics, user.getUserName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para listar as musicas do usuario no ListViewMusicas
	 */
	public void loadListViewMusics() {
		char[] out = new char[26];
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> musicas = userMusics.listMusics(userMusics.getRoot(), out, 0, result);
		ObservableList<String> observableListMusicas = FXCollections.observableArrayList(musicas);
		listViewMusicas.setItems(observableListMusicas);
	}
	
	/**
	 * Método para listar as playlists do usuario no ListViewPlaylists
	 */
	public void loadListViewPlaylists() {
		ArrayList<PlayList> playlists = new ArrayList<PlayList>();
		ArrayList<String> playlistsNames = new ArrayList<String>();
		playlists = user.getPlayLists();
		for(int i = 0; i < playlists.size(); i++) {
			playlistsNames.add(playlists.get(i).getName());
		}
		
		ObservableList<String> observableListPlaylists = FXCollections.observableArrayList(playlistsNames);
		listViewPlaylists.setItems(observableListPlaylists);
		
	}
	
	/**
	 * Método para salvar as alterações feitas nas playlists do usuario
	 */
	public void saveUserAlteration() {
		BinarySearchTree users = new BinarySearchTree();
		JsonReader reader = new JsonReader();
		try {
			users = reader.openUsersFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		users.publicSearch(user.getUserName()).setUser(user);
		
		JsonWriter writer = new JsonWriter();
		try {
			writer.write(users);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para carregar a playlist selecionada  
	 */
	public void loadListViewPlaylistsMusics() {
		if(currentSelectedPlaylist != null) {
			currentPlayList.setText("Playlist: " + currentSelectedPlaylist);
			ArrayList<String> musicasDaPlaylist = new ArrayList<String>();
			
			musicasDaPlaylist = user.getPlayLists().get(searchPlaylist(currentSelectedPlaylist)).getMusics();
			
			ObservableList<String> observableListPlaylistsMusics = FXCollections.observableArrayList(musicasDaPlaylist);
			listViewMusicasPlyList.setItems(observableListPlaylistsMusics);
		}
	}
	
	/**
	 * Método para adicionar uma musica a playlist selecionada  
	 */
	public void addToCurrentPlaylist() {
		if(currentSelectedPlaylist != null) {
			int index = searchPlaylist(currentSelectedPlaylist);
			user.getPlayLists().get(index).addMusic(listViewMusicas.getSelectionModel().getSelectedItem());
			loadListViewPlaylistsMusics();
			saveUserAlteration();
		}
	}
	
	/**
	 * Método para buscar a posição da playlist selecionada na lista de playlists do usuario
	 */
	public int searchPlaylist(String playlistName) {
		for(int i = 0; i <  user.getPlayLists().size(); i++) {
			if(user.getPlayLists().get(i).getName().equals(playlistName)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método para remover uma musica da playlist selecionada  
	 */
	public void removeFromCurrentPlayList() {
		String playlistName = listViewPlaylists.getSelectionModel().getSelectedItem();
		if(playlistName != null) {
		}
		
		loadListViewPlaylistsMusics();
		saveUserAlteration();
	}
	
	/**
	 * Método para tocar uma musica selecionada (melhorar para tocar uma playlist inteira)
	 */
	public void playMusic(){
		String musica = listViewMusicas.getSelectionModel().getSelectedItem();
		if(musica != null) {
			String path = userMusics.searchMusic(musica).getMusicPath();
			Media media = new Media(path);
			player = new MediaPlayer(media);
			player.play();
		}
	}
	
	/**
	 * Método para pausar e continuar a musica selecionada
	 */
	public void pause() {
		Status currentStatus = player.getStatus();

	    if(currentStatus == Status.PLAYING)
	        player.pause();
	    else if(currentStatus == Status.PAUSED || currentStatus == Status.STOPPED) {
	        player.play();
	    }
	}
	
	/**
	 * Método para parar a musica selecionada de tocar
	 */
	public void Stop() {
		player.stop();
	}
	
	/**
	 * Método para criar uma playlist para o usuario
	 */
	public void criarplayList() {
		String name = playlistNome.getText();	
		if(name != null) {
			user.createPlayList(name);
			loadListViewPlaylists();
		}
		playlistNome.setText(null);
		saveUserAlteration();
	}
	
	/**
	 * Método para remover uma playlist selecionada da lista de playlists do usuario
	 */
	public void removerPlaylist() {
		String name = listViewPlaylists.getSelectionModel().getSelectedItem();
		if(name != null) {
			user.removePlayList(name);
		}
		saveUserAlteration();
	}
	
	/**
	 * Método para carregar as musicas de uma playlist no listViewMusicasPlaylist
	 */
	public void selectedPlaylist(){
		String playlistName = listViewPlaylists.getSelectionModel().getSelectedItem();
		if(playlistName != null) {
			currentSelectedPlaylist = playlistName;
			loadListViewPlaylistsMusics();
		}
	}
	
	public void addUser() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/NewUserScreen.fxml"));
		Parent root;
		try {
			root = loader.load();
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
