package application;

public class BinarySearchTreeNode {
	private String value; //nome do usu�rio
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	/**
	 * M�todo construtor do N� da arvore
	 */
	public BinarySearchTreeNode(String nome) {
		this.value = nome;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * M�todo para retornar o valor de um n�
	 */
	public String getValue() {
		return this.value;
	}
	
}
