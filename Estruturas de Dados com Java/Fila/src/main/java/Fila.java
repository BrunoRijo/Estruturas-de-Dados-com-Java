/*
Uma Fila é uma estrutura de dados onde o primeiro elemento inserido será sempre o primeiro
 a ser removido, FIFO (First In First Out), seguindo como regra que o primeiro elemento será
 sempre o que estará sendo trabalhado. Em uma fila o encadeamento dos nós é feito maneira
 onde a referência do nó aponta para o ultimo que está foi inserido.
 A referencia da base (primeiro) será nula e o ultimo elemento será uma refeência para
o ultimo. Os prinicpais métodos são:
.enqueue() -> Insere na fila, a referencia de entrada da filha é modificada para apontar para o novo elemento que está sendo inserido.
dequeue() -> Desenfileirar, remover da fila, o elemento é removido e a referencia do
novo primeiro elemento é modificada para null.
isEmpty -> Verificar se está vazia
first() -> Indica quem é o primeiro da fila
*/

public class Fila<T> {

    private No<T> refNoEntradaFila;
    //A entrada na fila é feita pelo final dela

    public Fila() {
        this.refNoEntradaFila = null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null? true : false;
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    public T first(){
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoEntradaFila;
            while(true){ //percorre todos os objetos para chegar até o primeiro
                if(primeiroNo.getRefNextNo() != null){ //enquanto a referencia não for nula
                    primeiroNo = primeiroNo.getRefNextNo();//preencha com o objeto do prox;
                } else{
                    break;//quando encontrar ele sai do while e termina a func.
                }
            }
            return (T) primeiroNo.getObjeto();
        }
        return null;
    }

    public T dequeue(){
        //Esse metodo precisa mudar a referencia do nó imediatamente anterior para null
        if(!isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){ //percorre todos os objetos para chegar até o primeiro
                if(primeiroNo.getRefNextNo()!=null){ //enquanto a referencia não for nula
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNextNo();//preencha com o objeto do prox;
                } else{
                    noAuxiliar.setRefNo(null);
                    // quando encontrar o primeiro nó, set a referencia do imediatmente
                    // anterior para null, agora este sera o primeiro.
                    break;
                }
            }
            return (T )primeiroNo.getObjeto();
        }
        return null;
    }

    @Override
    public String toString() {
        String retorno = "";
        No noAux = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                retorno += "[Nó{objeto="+ noAux.getObjeto() +"}] --> ";
                if(noAux.getRefNextNo()!=null){

                    noAux = noAux.getRefNextNo();
                } else{
                    retorno += "null";
                    break;
                }
            }
        }else {
            return retorno;
        }
        return retorno;
    }
}
