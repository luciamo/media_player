package application;

public class BinarySearchTreeNode {
	private String value; //nome do usuário
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	
	/**
	 * Método construtor do Nó da arvore
	 */
	public BinarySearchTreeNode(String nome) {
		value = nome;
		left = null;
		right = null;
	}
	
	/**
	 * Método para retornar o valor de um nó
	 */
	public String getValue() {
		return this.value;
	}
	
}
