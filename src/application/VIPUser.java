package application;

import java.util.ArrayList;

//Por enquanto nunca vai ser usada... muitos bugs no player controler por causa que tem
//que saber se o usuario e do tipo User ou VIPUser... (isso era mais facil no inici do semestre!)

public class VIPUser extends User {
	
	private ArrayList<PlayList> playLists; 
	
	VIPUser(String userName, String password){
		super(userName, password);
		playLists = new ArrayList<PlayList>();
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
