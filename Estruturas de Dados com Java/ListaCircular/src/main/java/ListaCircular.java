/*A Lista Circular é uma estrutura semelhante a uma lista encadeada, diferencia-se pela referencia do primeiro item da lista aponta para o objeto localizado no fim da lista.
        isEmpty(), size(), getNo(), get(), remove(), add(), toString()*/

public class ListaCircular<T> {

    No<T> cabeca; // é o apontador para o próximo
    No<T> cauda; //é o conteudo
    private int tamanho;

    public ListaCircular(){
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    /*Adiciona um novo elemento modificando a referencia dos elementos
     já existentes*/
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanho==0){
            this.cabeca=novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProxNo(cauda);
        }else{
            novoNo.setProxNo(this.cauda); //adiciona atrás da cauda
            this.cabeca.setProxNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanho++;
    }

    /*Remove o elemento modificando o apontador do item para o seguinte
    ao que quero remover, fazendo o elemento perder a referecia em memoria
    e ser excluido pela jvm*/
    public void remove(int index){
        if(index>= this.tamanho)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No<T> noAuxiliar = this.cauda;
        if(index==0){
            this.cauda = this.cauda.getProxNo();
            this.cabeca.setProxNo(cauda);
        } else if(index==1) {
            //setando com o nó seguinte ao próximo
            this.cauda.setProxNo(this.cauda.getProxNo().getProxNo());
        } else {
            for (int i=0; i<index-1;i++){
                noAuxiliar = noAuxiliar.getProxNo();
            }
            noAuxiliar.setProxNo(noAuxiliar.getProxNo().getProxNo());
        }
        this.tamanho--;
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia");

        if (index==0){
            return this.cauda;
        }

        No<T> noAux =  this.cauda;
        for(int i = 0; (i<index)&&(noAux!=null);i++){
            noAux = noAux.getProxNo();
        }
        return noAux;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0? true : false;
    }

    @Override
    public String toString() {
        String str = "";

        No<T> noAux = this.cauda;
        for (int i=0;i<this.size();i++){
            str += "[No{conteudo="+ noAux.getConteudo()+"}] --> ";
            noAux = noAux.getProxNo();
        }

         str += this.size() !=0 ? "(Retorno ao inicio)" : "[]";
        return str;
    }
}
