package application;

public class TrieNode {

	TrieNode[] childs;
	private boolean isEnd;
	private String musicPath;
	
	/**
	 * Método construtor do Nó da arvore
	 */
	TrieNode(){
		this.childs = new TrieNode[26];
		this.isEnd = false; 
	}

	/**
	 * Método para acessar a inforção fim de palavra
	 * @return isEnd: booleano que indica se o nó for fim de palavra
	 */
	public boolean isEnd() {
		return isEnd;
	}
	
	/**
	 * Método para setar o estado do nó
	 * @param isEnd: booleano que diz se o nó e fim de palavra
	 */
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	/**
	 * Método para acessar o caminho da musica guardada no nó
	 * @return musicPath: o caminho da musica
	 */
	public String getMusicPath() {
		return musicPath;
	}
	
	/**
	 * Método para setar o caminho da musica a ser guardada no nó
	 * @param musicPath: o caminho da musica
	 */
	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	public boolean childsArrayIsEmpty() {
		return false;
	}

	public void clearchildsInNode() {
		for (int i = 0 ; i < childs.length ; i++ ) {
			childs[i] = null;
		}		
	}
	
	
}
