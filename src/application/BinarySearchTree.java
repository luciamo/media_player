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
	 * M�todo construtor inicializado com uma palavra
	 * @param word: palavra para a raiz
	 */
	public BinarySearchTree(String word) {
		root = new BinarySearchTreeNode(word);	
	}
	
	public void insert(String word) {
		root = insertInterno(root, word);
	}
	
	/**
	 * M�todo para inserir na �rvore
	 * @param node: N� da �rvore onde deve-se come�ar o processo de inser��o (por padr�o deve ser a raiz).
	 * @param word: Palavra a ser inserida na �rvore.
	 */
	private BinarySearchTreeNode insertInterno(BinarySearchTreeNode root, String word) {
		if(root == null) {
			root = new BinarySearchTreeNode(word);
		}
		else if(root.getValue().compareTo(word)==0){
			System.out.println("A palavra j� est� associada a um n� existente");
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
	 * M�todo para buscar na �rvore
	 * @param node: N� da �rvore onde deve-se come�ar o processo de busca (por padr�o deve ser a raiz).
	 * @param word: Palavra a ser buscada na �rvore.
	 * @return retorna o n� que cont�m a palavra buscada
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
		System.out.println("Palavra n�o encontrada");
		return null;
	}
	
	public void print() {
		treePrint(this.root);
	}
	
	/**
	 * M�todo para imprimir a �rvore (ou sub-�rvore)
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
