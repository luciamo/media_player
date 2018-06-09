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
	 * Método construtor inicializado com uma palavra
	 * @param word: palavra para a raiz
	 */
	public BinarySearchTree(String word) {
		root = new BinarySearchTreeNode(word);	
	}
	
	public void insert(String word) {
		root = insertInterno(root, word);
	}
	
	/**
	 * Método para inserir na árvore
	 * @param node: Nó da árvore onde deve-se começar o processo de inserção (por padrão deve ser a raiz).
	 * @param word: Palavra a ser inserida na árvore.
	 */
	private BinarySearchTreeNode insertInterno(BinarySearchTreeNode root, String word) {
		if(root == null) {
			root = new BinarySearchTreeNode(word);
		}
		else if(root.getValue().compareTo(word)==0){
			System.out.println("A palavra já está associada a um nó existente");
		}
		else if(root.getValue().compareTo(word)>0){
			root.left = insertInterno(root.left, word);
		}
		else if(root.getValue().compareTo(word)<0) {
			root.right = insertInterno(root.right, word);	
		}
		return root;
	}
	
	/**
	 * Método para buscar na árvore
	 * @param node: Nó da árvore onde deve-se começar o processo de busca (por padrão deve ser a raiz).
	 * @param word: Palavra a ser buscada na árvore.
	 * @return retorna o nó que contém a palavra buscada
	 */
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
	
	public void print() {
		treePrint(this.root);
	}
	
	/**
	 * Método para imprimir a árvore (ou sub-árvore)
	 * @param node: especifica a partir de onde imprimir
	 */
	
	private void treePrint(BinarySearchTreeNode node){
		if(node!=null){
			
			System.out.print(node.getValue());
			treePrint(node.left);
			treePrint(node.right);
			
		}
	}
}
