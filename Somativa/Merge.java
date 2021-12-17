package Somativa;

public class Merge{

	private int[] dados;
	
	
	public Fila makeMerge(Fila f1, Fila f2) {
		Fila new_fila = new Fila();
		int vl_fila1 = 0;
		int vl_fila2 = 0;
		
		while (!f1.vazia() || !f2.vazia()) {
		
			if(!f1.vazia() && !f2.vazia()) {
				vl_fila1 = f1.getPrimeiro();
				vl_fila2 = f2.getPrimeiro();
				if(vl_fila1 < vl_fila2) {
					new_fila.insere(vl_fila1);
					f1.remove();
				}else if(vl_fila2 < vl_fila1) {
					new_fila.insere(vl_fila2);
					f2.remove();
				}else if(vl_fila2 == vl_fila1) {
					new_fila.insere(vl_fila1);
					f1.remove();
				}
			}else if(!f1.vazia()) {
				vl_fila1 = f1.getPrimeiro();
				new_fila.insere(vl_fila1);
				f1.remove();
			}else if(!f2.vazia()) {
				vl_fila2 = f2.getPrimeiro();
				new_fila.insere(vl_fila2);
				f2.remove();
			}
		}
		return new_fila;
	}
	
}
