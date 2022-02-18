/*

A estrutura de fila encadeada é semelhante a uma fila, onde uma série de
 nós que contem o dado e uma referencia para o próximo, a diferença são
 os métodos e as regras de inserção implementados.

Os métodos implementados em uma lista encadeada são:
 add(), get(), getNo(), remove(), toString(), isEmpty();*/

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada(){
        this.referenciaEntrada = null;
    }

    public void add(T conteudo_novoNo) {
        No<T> novoNo = new No<>(conteudo_novoNo);
        if (this.isEmpty()){ //Se a lista estiver vazia já insere diretamente
            referenciaEntrada = novoNo;
            return;
        }
        //Não estando vazia será necessário percorrer a lista ate o fim.
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i< this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    //Privado por que será usado somente internamente
    private No<T> getNo (int index){

        validaIndex(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for(int i = 0; i<=index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }


    public T remove(int index){
        No<T> noPivor = this.getNo(index);
        if(index ==0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    private void validaIndex(int index){
        if (index>= size()){
            int ultimoIndice = size()-1;
            throw  new IndexOutOfBoundsException("O indice informado não possui conteúdo, o ultimo indice da lista é:"+ultimoIndice);
        }
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;

        while(true){ //looping infinito
            if(referenciaAux != null){ //caso a lista não esteja vazia
                tamanhoLista++; // adiciona +1 na lista
                if(referenciaAux.getProximoNo() != null){ //enquanto a lista tiver um próximo entra aqui.
                    referenciaAux = referenciaAux.getProximoNo(); //substitui a referencia pela do prox item.
                }else{//quando não houver mais próximo, quebra esse looping com o tamanho da lista completo
                    break;
                }
            }else{ //caso esteja vazia já quebra o looping
                break;
            }
        }
        return tamanhoLista;
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno ="";
        No<T> noAuxiliar = referenciaEntrada;
        for (int i=0; i< this.size(); i++){
            strRetorno += "[No{conteudo = " + noAuxiliar.getConteudo() +"}] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
