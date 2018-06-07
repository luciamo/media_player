package application;

import java.util.ArrayList;

public class PlayList {
	
	private String name;
	private ArrayList<String> musics;
	
	/**
	 * Método construtor da classe
	 * @param name: o nome da playlist
	 */
	PlayList(String name){
		this.name = name;
		musics = new ArrayList<String>();
	}
	
	/**
	 * Método para se adicionar uma musica a lista
	 * @param music: nome da musica
	 */
	public void addMusic(String music){
		musics.add(music);
	}
	
	/**
	 * Método para se remover uma musica a lista
	 * @param music: nome da musica
	 */
	public void removeMusic(String music) {
		for(int i = 0; i < musics.size(); i++) { 
			if(musics.get(i).equals(music)) {
				musics.remove(i);
			}
		}
	}
	
	/**
	 * Método para acessar o nome da musica
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método para acessar a lista de musicas
	 */
	public ArrayList<String> getMusics() {
		return musics;
	}
	
}