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
	 * @param user: Usuário para a raiz
	 */
	public BinarySearchTree(User user) {
		root = insertInterno(root, user);	
	}
	
	/**
	 * Método público para inserir usuário na árvore 
	 * @param user: usuário a ser inserido
	 */
	public void insert(User user) {
		root = insertInterno(root, user);
	}
	
	/**
	 * Método privado para inserir na árvore
	 * @param node: Nó da árvore onde deve-se começar o processo de inserção (por padrão deve ser a raiz).
	 * @param user: Usuário a ser inserido na árvore.
	 */
	private BinarySearchTreeNode insertInterno(BinarySearchTreeNode root, User user) {
		if(root == null) {
			root = new BinarySearchTreeNode(user);
		}
		else if(root.getUser().getUserName().compareTo(user.getUserName())==0){
			System.out.println("Username já existe nos nossos registros");
		}
		else if(root.getUser().getUserName().compareTo(user.getUserName())>0){
			root.left = insertInterno(root.left, user);
		}
		else if(root.getUser().getUserName().compareTo(user.getUserName())<0) {
			root.right = insertInterno(root.right, user);
		}
		return root;
	}
	
	public BinarySearchTreeNode publicSearch(String username) {
		return search(root, username);
	}
	
	/**
	 * Método para buscar na árvore
	 * @param node: Nó da árvore onde deve-se começar o processo de busca (por padrão deve ser a raiz).
	 * @param username: Nome do usuário a ser buscado na árvore.
	 * @return retorna o nó que contém a palavra buscada ou o nó raiz em caso de não encontrá-la
	 */
	private BinarySearchTreeNode search(BinarySearchTreeNode node, String username) {
		if(node != null) {
			if(node.getUser().getUserName().compareTo(username)==0) {
				return node;
			}
			else if(node.getUser().getUserName().compareTo(username)>0){
				return search(node.left, username);
			}
			else if(node.getUser().getUserName().compareTo(username)<0) {
				return search(node.right, username);
			}
		}
		System.out.println("Usuário não encontrado");
		return null;
	}
	/**
	 * Método público para imprimir árvores
	 */
	public void print() {
		treePrint(this.root);
	}
	
	/**
	 * Método para imprimir a árvore (ou sub-árvore)
	 * @param node: especifica a partir de onde imprimir
	 */
	
	private void treePrint(BinarySearchTreeNode node){
		if(node!=null){
			System.out.println(node.getUser().getUserName());
			treePrint(node.left);
			treePrint(node.right);
		}
	}
}
