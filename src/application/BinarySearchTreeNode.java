package application;

public class BinarySearchTreeNode {
	private User user; // usuário
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	/**
	 * Método construtor do Nó da arvore
	 */
	public BinarySearchTreeNode(User u) {
		this.user = u;
		this.left = null;
		this.right = null;
	}
	
	public BinarySearchTreeNode() {
		this.user = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Método para retornar o valor de um nó
	 */
	public User getUser() {
		return this.user;
	}
	
}
