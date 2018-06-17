package application;

import java.util.ArrayList;
import java.util.Stack;

public class Trie {
	
	private TrieNode root;	
	
	/**
	 * Método construtor da classe
	 */
	Trie(){
		this.root = new TrieNode();
	}
	
	/**
	 * Método para retornar a raiz da árvore
	 * @return root: o nó raiz da árvore
	 */
	public TrieNode getRoot() {
		return this.root;
	}
	
	/**
	 * Método para inserir uma musica na arvore
	 * @param musicName: Nome da musica
	 * @param musicPath: Caminho da musica
	 */
	public void insertMusic(String musicName, String musicPath) {
		TrieNode node = root;
		for (int i=0; i<musicName.length(); i++)
		{
			char c = musicName.charAt(i);
			int index = c -'a';
			//Se a no daquela letra estiver vazio crie e se mova para la
			if (node.childs[index]==null)
			{
				TrieNode temp = new TrieNode();
				node.childs[index] = temp;
				node = node.childs[index];
			}//Caso contrario apenas se mova para la 
			else {
				node = node.childs[index];
			}
		}
		node.setEnd(true); 
		node.setMusicPath(musicPath);
	}
	
	/**
	 * Método para buscar por uma musica
	 * @param musicName: o nome da musica 
	 * @return node: o TrieNode que possui o caminho da musica
	 */
	public TrieNode searchMusic(String musicName)
	{
		TrieNode node = root;
		for (int i=0; i<musicName.length(); i++)
		{
			char c = musicName.charAt(i);
			int index = c -'a';
			if(node.childs[index]!=null)
			{
				node = node.childs[index];
			} else {
				return null;
			}
		}
		return node;
	}
	
	/**
	 * Método para listar as musicas da árvore
	 * @param node: a raiz da árvore
	 * @param out: array que armazena a palavra
	 * @param index: indice utilizado para navegar a arvore
	 * @return musicsList: arraylist contendo os nomes das musicas
	 */
	public ArrayList<String> listMusics(TrieNode node,char[] out, int index, ArrayList<String> musicas)
	{
		ArrayList<String> musicsList = musicas;
		for(int i=0 ; i < 26; i++)
		{	
			if( node.childs[i] != null )
			{
				out[index] = (char) ('a'+i);
				listMusics(node.childs[i] ,out,index+1, musicsList);
			}
		}
		if(node.isEnd())
		{	
			int i = 0;
			String musicName = "";
			out[index]='\0';
			while(out[i] != '\0') {
				musicName = musicName+out[i];
				i++;
			}
			musicsList.add(musicName);
		}
		return musicsList;
	}
		
	public boolean removeMusic(String musicName) {
		Stack<TrieNode> stack = new Stack<TrieNode>();
		TrieNode node = root;
		stack.add(node);
		int index = 0;
		for (char c : musicName.toCharArray()) {
			index = c -'a';
			if ( node.childs[index] == null ){
				return false;
			}
			stack.add(node.childs[index]);
			node = node.childs[index];
		}
		if (!node.isEnd()){
			return false;
		}

		node.setEnd(false);
		if (!node.childsArrayIsEmpty()){
			return true;
		}

		//word is not a prefix
		stack.pop();
		node = stack.pop();
		while (!stack.isEmpty() && node.childs.length == 1) {
			node.clearchildsInNode();
			if ( node.isEnd() ) {
				return true;
			}
			node = stack.pop();
		}
		return true;
	}
}
