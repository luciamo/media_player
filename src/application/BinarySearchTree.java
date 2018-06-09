package application;

public class BinarySearchTree {
	private BinarySearchTreeNode root;
	
	/**
	 * Método construtor da classe
	 */
	public BinarySearchTree() {
		root = null;	
	}
	
	/**
	 * Método para inserir na árvore
	 * @param node: Nó da árvore onde deve-se começar o processo de inserção (por padrão deve ser a raiz).
	 * @param word: Palavra a ser inserida na árvore.
	 */
	public void insert(BinarySearchTreeNode node, String word) {
		if(node == null) {
			node = new BinarySearchTreeNode(word);
			return;
		}
		else if(node.getValue().compareTo(word)==0){
			System.out.println("A palavra já está associada a um nó existente");
			return;
		}
		else if(node.getValue().compareTo(word)>0){
			insert(node.left, word);
		}
		else if(node.getValue().compareTo(word)<0) {
			insert(node.right, word);
		}
	}
	
	public BinarySearchTreeNode search(BinarySearchTreeNode node, String word) {
		if(node.getValue().compareTo(word)==0) {
			return node;
		}
		else if(node.getValue().compareTo(word)>0){
			search(node.left, word);
		}
		else if(node.getValue().compareTo(word)<0) {
			search(node.right, word);
		}
		System.out.println("Palavra não encontrada");
		return null;
	}
}
