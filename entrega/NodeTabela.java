package ultima.entrega;

public class NodeTabela {
	int chave;
	ListaEncadeada lista;
	
	public void setChave(int n) {
		this.chave = n;
	}
	
	public int getChave() {
		return this.chave;
	}
	
	public ListaEncadeada getLista() {
		return this.lista;
	}
	
	public void addLista(int chave) {
		if (lista == null)this.lista = new ListaEncadeada();
		this.lista.insereOrdenado(chave);
	}
	
}
