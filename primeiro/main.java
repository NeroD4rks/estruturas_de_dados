package primeiro;

public class main {

	public static void main(String[] args) {
		
		ArvoreBinaria tree = new ArvoreBinaria();
		tree.insere(95);
		tree.insere(65);
		tree.insere(125);
		tree.insere(35);
		tree.insere(5);
		
		tree.inOrdem();
		
		
		if (tree.buscar(125) != null) {
			System.out.println("Valor encontrado");
		}else {
			System.out.println("Valor não encontrado");
		}
	}

}
