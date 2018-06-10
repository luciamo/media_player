package application;

public class BinarySearchTreeNode {
	private User user; // usu�rio
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	/**
	 * M�todo construtor do N� da arvore
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
	 * M�todo para retornar o valor de um n�
	 */
	public User getUser() {
		return this.user;
	}
	
}
