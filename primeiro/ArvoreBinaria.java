package primeiro;

public class ArvoreBinaria {
	private Node raiz;
	
	public ArvoreBinaria(){
		raiz = null;
	}
	
	public void mostrar() {
		System.out.println(" raiz " + raiz.getInfo());
	}
	public void insere(int n) {
		if (raiz == null) {
			Node novo = new Node(n);
			this.raiz = novo;
		}else {
			insere(n, this.raiz, null);
		}
	}
	
	public Node buscar(int n) {
		return buscar(n, this.raiz);
	}
	
	public void remover(int n) {
	    remover(n, this.raiz, null);
	}
	
	public void inOrdem() {
		inOrdem(raiz);
	}
	
	private Node insere(int valor, Node atual, Node pai) {
		if(valor < atual.getInfo()) {
			if (atual.getEsquerda() != null)return insere(valor, atual.getEsquerda(), atual);
			Node novo = new Node(valor);
			atual.setEsquerda(novo);
			if(pai != null) balanceamento(atual, pai);
			return atual;
		}
		if (atual.getDireita() != null)return insere(valor, atual.getDireita(), atual); 
		
		Node novo = new Node(valor);
		atual.setDireita(novo);
		if(pai != null) balanceamento(atual, pai);
		return atual;
	}
	
	private void inOrdem(Node atual) {
		if(atual!= null) {
			inOrdem(atual.getEsquerda());
			System.out.println(atual.getInfo());
			inOrdem(atual.getDireita());
		}
	}
	
	private Node buscar(int valor, Node atual) {
		if (valor == atual.getInfo()) return atual;
		if(valor < atual.getInfo()) {
			if (atual.getEsquerda() != null)return buscar(valor, atual.getEsquerda());
		}
		if (atual.getDireita() != null)return buscar(valor, atual.getDireita()); 
		return null;
	}
	
	
	
	private Node getMaiorValor(Node node) {
	    while (node.getDireita() != null) {
	        node = node.getDireita();
	    }
	    return node;
	}

	private Node remover(int n, Node atual, Node pai) {
	    if (atual == null) {
	        return atual;
	    }
	    if (n < atual.getInfo()) {
	        atual.setEsquerda(remover(n, atual.getEsquerda(), atual));
	    } else if (n > atual.getInfo()) {
	        atual.setDireita(remover(n, atual.getDireita(), atual));
	    } else {
	    	if (atual.getEsquerda() == null && atual.getDireita() == null) {
	            return null;
	        } else if (atual.getEsquerda() != null && atual.getDireita() != null) {
	        	
	            Node mAtc = getMaiorValor(atual.getEsquerda());
	            atual.setInfo(mAtc.getInfo());
	            atual.setEsquerda(remover(mAtc.getInfo(), atual.getEsquerda(), atual));
	        } else {
	            if(atual.getEsquerda() != null) {
	            	atual = atual.getEsquerda();
	            }else {
	            	atual = atual.getDireita();
	            }
	        }
	    }
	    if(pai != null) balanceamento(atual, pai);
	    return atual;
	}
	

	
	
	public void balanceamento(Node filho, Node pai) {
		int fb = altura(pai.getEsquerda()) - altura(pai.getDireita()); 
		int fb_filho = altura(filho.getEsquerda()) - altura(filho.getDireita()); 
		if (fb == -2) {
			if(fb_filho == -1) {
				System.out.println("Mudou "+ pai.getInfo() + "  " + filho.getInfo());
				rotacaoEsquerda(pai);
			}else if(fb_filho == 1) {
				System.out.println("Mudou "+ pai.getInfo() + "  " + filho.getInfo());
				rotacaoDireita(filho);
				rotacaoEsquerda(pai);
			}
		}
		if (fb == 2) {
			if(fb_filho == -1) {
				System.out.println("Mudou "+ pai.getInfo() + "  " + filho.getInfo());
				rotacaoEsquerda(filho);
				rotacaoDireita(pai);				
			}else if(fb_filho == 1) {
				System.out.println("Mudou "+ pai.getInfo() + "  " + filho.getInfo());
				rotacaoDireita(pai);
			}
		}
		
	}
	
	private void mudarRaiz(Node novaRaiz, Node noChange) {
		Node change = raiz;
		while(change != null && change.getInfo() != noChange.getInfo()) {
			if (change.getEsquerda() != null) {
				if (change.getEsquerda().getInfo() == noChange.getInfo()) {
					change.setEsquerda(novaRaiz);
					break;
				}
			}
			if (change.getDireita() != null) {	
				if (change.getDireita().getInfo() == noChange.getInfo()) {
					change.setDireita(novaRaiz);
					break;
				}
			}
			
			if(change.getInfo()> noChange.getInfo()) change = change.getEsquerda();
			else change = change.getDireita();
		}
		
	}
	
	public Node rotacaoDireita(Node atual) {
		Node novaRaiz = atual.getEsquerda();
		Node temp = novaRaiz.getDireita();
		novaRaiz.setDireita(atual);
		
		atual.setEsquerda(temp);
		mudarRaiz(novaRaiz, atual);
		return novaRaiz;
	}
	
	public Node rotacaoEsquerda(Node atual) {
		Node novaRaiz = atual.getDireita();
		Node temp = novaRaiz.getEsquerda();
		novaRaiz.setEsquerda(atual);
		atual.setDireita(temp);
		mudarRaiz(novaRaiz, atual);
		return novaRaiz;
	}
	 
	 public static int altura(Node no) {
		 if (no == null)return -1;
		 int esquerda = altura(no.getEsquerda());
		 int direita = altura(no.getDireita());
		 if (esquerda > direita)return 1+esquerda;
		 return 1 + direita;
		 
	 }
}
