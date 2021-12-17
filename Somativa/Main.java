package Somativa;
import java.util.Scanner; 

public class Main {	
		
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int n;
		
		System.out.printf("Informe o tamanho da tabela hash: ");
    	n = ler.nextInt();
		TabelaHash tabela = new TabelaHash(n);
		
		System.out.println("Tabela Hash: ");
		tabela.imprimeElementos();
		
		System.out.println("n colisoes: " + tabela.getColisao());
		
	    while(true) {
	    System.out.printf("Informe o número que deseja procurar: ");
	    	n = ler.nextInt();
	    	if(n == -1) {
	    		break;
	    	}
			if(tabela.busca(n)) {
				System.out.println("Elemento encontrado");
			}else{
				System.out.println("Elemento  n existe na tabela");			
			}
	    }
	}

}
