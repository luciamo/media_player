package application;

public class BinarySearchTree {
	private BinarySearchTreeNode root;
	
	/**
	 * M�todo construtor da classe
	 */
	public BinarySearchTree() {
		root = null;	
	}
	
	/**
	 * M�todo para inserir na �rvore
	 * @param node: N� da �rvore onde deve-se come�ar o processo de inser��o (por padr�o deve ser a raiz).
	 * @param word: Palavra a ser inserida na �rvore.
	 */
	public void insert(BinarySearchTreeNode node, String word) {
		if(node == null) {
			node = new BinarySearchTreeNode(word);
			return;
		}
		else if(node.getValue().compareTo(word)==0){
			System.out.println("A palavra j� est� associada a um n� existente");
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
		System.out.println("Palavra n�o encontrada");
		return null;
	}
}
