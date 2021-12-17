package primeiro;

public class Node {
	private int info;
	private Node esquerda;
	private Node direita;
	
	public Node(int valor) {
		this.info = valor;
		this.esquerda = null;
		this.direita = null;
	}
	
	public void setEsquerda(Node node) {
		this.esquerda = node;
	}
	
	public void setDireita(Node node) {
		this.direita = node;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	
	public Node getEsquerda() {
		return this.esquerda;
	}
	
	public Node getDireita() {
		return this.direita;
	}
	
	public int getInfo() {
		return this.info;
	}
}
