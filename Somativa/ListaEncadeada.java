package Somativa;

public class ListaEncadeada {
	private Node lista;
	
	public ListaEncadeada() {
		lista=null;
	}
	
	public boolean vazia() {
		if(lista == null) {
			return true;
		}
		return false;
	}
	
	public Node inserePrimeiro(int info) {
		Node node = new Node();
		node.setInformacao(info);
		node.setProximo(lista);
		lista = node;
		return node;
	}
	
	public void insereDepois(Node node, int i) {
		if(!vazia()) {
		
			Node node_aux = lista;
			
			while(node_aux != null) {
				if(node_aux.equals(node)) {
					Node new_node = new Node();
					new_node.setInformacao(i);
					new_node.setProximo(node_aux.getProximo());
					node_aux.setProximo(new_node);
					break;
				}
				
				node_aux = node_aux.getProximo();
			}
		}else {
			System.out.println("Fila está vazia");
		}
	}
	
	public void insereOrdenado(int i) {
		if(!vazia()) {
			Node node = lista;
			Node node_aux = null;
			
			while(node != null) {
				if(node.getInformacao() <= i) {
					node_aux = node;
				}
				node = node.getProximo();
			}
			
			if (node_aux == null) {
				inserePrimeiro(i);
			}else {
				insereDepois(node_aux, i);
			}
		}else {
			inserePrimeiro(i);
		}
	}
	
	
	public Node insereUltimo(int info) {
		Node node = new Node();
		node.setInformacao(info);
		if(!vazia()) {
			Node node_aux = lista;
			while(node_aux.getProximo() != null) {
				node_aux = node_aux.getProximo();
			}
			node_aux.setProximo(node);
			node.setProximo(null);
		}else {
			node = inserePrimeiro(info);
		}
		
		return node;
	}
	
	public void imprime() {
		if(vazia()) {
			System.out.println("Fila está vazia");
		}
		Node node = lista;
		
		while(node != null) {
			System.out.print(" "+ node.getInformacao());
			node = node.getProximo();
		}
		
	}
	
	
	public Node removePrimeiro() {
		if(vazia()) {
			return null;
		}
		Node node = lista.getProximo();
		lista = lista.getProximo();
		return node;
	}
	
	public Node removeUltimo() {
		if(vazia()) {
			return null;
		}
		Node node = lista;
		
		while(node.getProximo()!= null) {
			
			Node aux = node;
			node = node.getProximo();
			if (node.getProximo() == null) {
				aux.setProximo(null);
				return node.getProximo();
			}
		}
		lista = null;
		return node;
	}
	
	
	public Node remove(Node node) {
		if(vazia()) {
			System.out.println("Fila está vazia");
			return null;
		}
		Node node_aux = lista;
		
		while(node_aux.getProximo()!= null) {
			if (node_aux.getProximo().equals(node)) {
				Node new_node = new Node();
				new_node = node_aux.getProximo().getProximo();
				node_aux.setProximo(new_node);
				return node_aux.getProximo();
			}else if(node_aux.equals(node)) {
				removePrimeiro();
				return node_aux.getProximo();
				
			}
			
			node_aux = node_aux.getProximo();
		}
		return node;
	}
	
	public Node getUltimo() {
		Node node_aux = null;
		if(!vazia()) {
			node_aux = lista;
			while(node_aux.getProximo() != null) {
				node_aux = node_aux.getProximo();
			}
		}
		return node_aux;
	}
	
	public Node getPrimeiro() {
		return lista;
	}
}
