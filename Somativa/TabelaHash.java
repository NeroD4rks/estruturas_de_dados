package Somativa;
import java.util.Random;

public class TabelaHash {
    private int colisao;
    private NodeTabela[] tabela;
    
    public TabelaHash(int tamanho){
        this.colisao = 0;
        tabela = new NodeTabela[tamanho];
        preencheVetorTabela();
        preencheTabela();
    }
    
    public void preencheVetorTabela(){
        for(int i=0; i < tabela.length;i++){
            NodeTabela nodeTabela = new NodeTabela();
            nodeTabela.setChave(-1);
            tabela[i] = nodeTabela;      
        }     
     }
    
    public int getColisao() {
    	return this.colisao;
    }
    
    public void preencheTabela(){
        Random r = new Random();
        for(int v = 0; v < (tabela.length * 0.9); v++){
           int chave = r.nextInt(1000000);
           insere(chave);
        }
    }
    
    
    public void insere(int chave){
    	int key = funcaoHash(chave);
    	if(tabela[key].getChave() == -1){
            tabela[key].setChave(chave);
        }else{
            tabela[key].addLista(chave);
            colisao++;
        }
    	
    }
    
    public int funcaoHash(int chave){
        return chave % this.tabela.length;
    }
    
    public void imprimeElementos(){
        for(int i=0; i < tabela.length; i++) {
        	System.out.print(i +" " +tabela[i].getChave());
        	
        	if(tabela[i].getLista()!= null)tabela[i].getLista().imprime();
        	System.out.println("");
        	
        }
    }
    
    public boolean busca(int chave) {
    	for(int i=0; i < tabela.length; i++) {
        	if (tabela[i].getChave() == chave)return true;
       
        	if(tabela[i].getLista() == null)continue;
        	
    		Node node_aux = tabela[i].getLista().getPrimeiro();
			while(node_aux != null) {
				if(chave == node_aux.getInformacao())return true;
				node_aux = node_aux.getProximo();
			}
        }
    	return false;
    }   
}
