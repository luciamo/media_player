package application;

public class TrieNode {

	TrieNode[] childs;
	private boolean isEnd;
	private String musicPath;
	
	/**
	 * M�todo construtor do N� da arvore
	 */
	TrieNode(){
		this.childs = new TrieNode[26];
		this.isEnd = false; 
	}

	/**
	 * M�todo para acessar a infor��o fim de palavra
	 * @return isEnd: booleano que indica se o n� for fim de palavra
	 */
	public boolean isEnd() {
		return isEnd;
	}
	
	/**
	 * M�todo para setar o estado do n�
	 * @param isEnd: booleano que diz se o n� e fim de palavra
	 */
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	/**
	 * M�todo para acessar o caminho da musica guardada no n�
	 * @return musicPath: o caminho da musica
	 */
	public String getMusicPath() {
		return musicPath;
	}
	
	/**
	 * M�todo para setar o caminho da musica a ser guardada no n�
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
