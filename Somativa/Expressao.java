package Somativa;

public class Expressao {
	private String expressao;

	public boolean validarExpressao(String exp) {
		Pilha pilha = new Pilha();
		this.expressao = exp;

		for (int i = 0; i < expressao.length(); i++) {
			char aux = expressao.charAt(i);
			if (aux == '{') {
				pilha.empilha(1);
			}
			else if(aux == '[') {
				pilha.empilha(2);
			}else if(aux == '(') {
				pilha.empilha(3);
			}

			if (aux == ')' || aux == ']' || aux == '}') {
				Integer last_abertura = pilha.topo();
				if (last_abertura == null) {
					last_abertura = 0;
				}
				
				if (aux == ')') {
					if (last_abertura == 3) {
						pilha.desempilha();
					}else {
						System.out.println("A expressão '" + expressao + "' é invalida");
						return false;
					}
				} else if (aux == ']') {
					if (last_abertura == 2) {
						pilha.desempilha();
					}else {
						System.out.println("A expressão '" + expressao + "' é invalida");
						return false;
					}
				} else if (aux == '}') {
					if (last_abertura == 1) {
						pilha.desempilha();
					}else {
						System.out.println("A expressão '" + expressao + "' é invalida");
						return false;
					}
				}

			}

		}

		if (pilha.vazia()) {
			System.out.println("A expressão '" + expressao + "' é valida");
			return true;
		} else {
			System.out.println("A expressão '" + expressao + "' é invalida");
			return false;
		}

	}

}
