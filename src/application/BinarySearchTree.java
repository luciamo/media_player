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
	 * @param user: Usu�rio para a raiz
	 */
	public BinarySearchTree(User user) {
		root = insertInterno(root, user);	
	}
	
	/**
	 * M�todo p�blico para inserir usu�rio na �rvore 
	 * @param user: usu�rio a ser inserido
	 */
	public void insert(User user) {
		root = insertInterno(root, user);
	}
	
	/**
	 * M�todo privado para inserir na �rvore
	 * @param node: N� da �rvore onde deve-se come�ar o processo de inser��o (por padr�o deve ser a raiz).
	 * @param user: Usu�rio a ser inserido na �rvore.
	 */
	private BinarySearchTreeNode insertInterno(BinarySearchTreeNode root, User user) {
		if(root == null) {
			root = new BinarySearchTreeNode(user);
		}
		else if(root.getUser().getUserName().compareTo(user.getUserName())==0){
			System.out.println("Username j� existe nos nossos registros");
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
	 * M�todo para buscar na �rvore
	 * @param node: N� da �rvore onde deve-se come�ar o processo de busca (por padr�o deve ser a raiz).
	 * @param username: Nome do usu�rio a ser buscado na �rvore.
	 * @return retorna o n� que cont�m a palavra buscada ou o n� raiz em caso de n�o encontr�-la
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
		System.out.println("Usu�rio n�o encontrado");
		return null;
	}
	/**
	 * M�todo p�blico para imprimir �rvores
	 */
	public void print() {
		treePrint(this.root);
	}
	
	/**
	 * M�todo para imprimir a �rvore (ou sub-�rvore)
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
