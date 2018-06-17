package application;

import java.util.ArrayList;

public class User {
	
	private String userName;
	private String password;
	private ArrayList<PlayList> playLists;
	
	/**
	 * Método construtor da classe
	 * @param userName: o nome do usuario, usado no login 
	 * @param password: a senha do usuario
	 */
	User(String userName, String password){
		this.userName = userName;
		this.password = password;
		playLists = new ArrayList<PlayList>();
	}
	
	/**
	 * Método para acessar o nome do usuario
	 * @return userName: o nome do usuario
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Método para comparar se a senha esta correta
	 * @param password: senha usada para fazer o login
	 * @return true: se a senha estiver correta
	 */
	public boolean comparePassword(String password) {
		return this.password.equals(password);
	}

	public void createPlayList(String playListName) {
		PlayList playlist = new PlayList(playListName);
		this.playLists.add(playlist);
	}
	
	public void removePlayList(String playListName) {
		for(int i = 0; i < playLists.size(); i++) { 
			if( playLists.get(i).getName().equals(playListName)) {
				playLists.remove(i);
			}
		}
	}

	public ArrayList<PlayList> getPlayLists() {
		return playLists;
	}
}
