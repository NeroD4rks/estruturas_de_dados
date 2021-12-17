package Somativa;

public class Fila {
	private ListaEncadeada dados= null;
	
	public Fila() {
		dados = new ListaEncadeada();
	}
	
	public boolean vazia() {
		return dados.vazia();
	}

	public void insere(int dado) {
		dados.insereUltimo(dado);
	}
	
	public Integer remove() {	
		Node node = dados.removePrimeiro();
		if(node!=null) {
			return node.getInformacao();	
		}
		return null;	
	}
	
	public void mostra_fila() {
		dados.imprime();
	}
	
	public Integer getPrimeiro() {
		if(!vazia()) {
			Node node = dados.getPrimeiro();
			return node.getInformacao();
		}
		return null;
	}
	
}
