package Somativa;

public class Pilha {
	private Integer topo;
	private ListaEncadeada dados = null;
	
	public Pilha() {
		dados = new ListaEncadeada();
	}
	
	public Integer topo() {	
		return this.topo;
	}

	public boolean vazia() {
		return dados.vazia();
	}

	public void empilha(int dado) {
			Node node = this.dados.insereUltimo(dado);
			this.topo = node.getInformacao();
	}

	public Integer desempilha() {
		dados.removeUltimo();
		if (!vazia()) {
			Node node = dados.getUltimo();
			this.topo = node.getInformacao();
			return this.topo;
		} else {
			this.topo = null;
		}
		return this.topo;
	}
	
	public void mostra_pilha() {
		dados.imprime();
	}
	
}