package application;

public class BinarySearchTreeNode {
	private String value; //nome do usuário
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	/**
	 * Método construtor do Nó da arvore
	 */
	public BinarySearchTreeNode(String nome) {
		this.value = nome;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Método para retornar o valor de um nó
	 */
	public String getValue() {
		return this.value;
	}
	
}
