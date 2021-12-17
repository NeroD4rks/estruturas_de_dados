package busca;

public class main {

	public static void main(String[] args) {
		
		int vetor[]= {10,12,14,15,22,37};
		int procurar = 37;
		int indice = busca_binaria(vetor,procurar,0, vetor.length-1);
		
		if(indice ==-1) System.out.println("Elemento não encontrado");
		else System.out.println("elemento "+ procurar+" encontrado no indice: "+indice);
	}
	
	public static int busca_binaria(int dados[], int x, int inicio, int fim) {
		int media = (inicio+fim)/2;	
		if(inicio>fim) return -1;
		else if(x == dados[media])return media;
		else if (x>dados[media]) return busca_binaria(dados,x,media+1, fim);
		else return busca_binaria(dados,x,inicio, media-1);			
	}
	
}


