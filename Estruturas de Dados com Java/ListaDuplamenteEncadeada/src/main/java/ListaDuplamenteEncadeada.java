/*
Uma lista duplamente encadeada é uma estrutura de dados diferenciada por conter duas referencias além de
seu conteúdo em cada nó, um apontando para o próximo e um apontando para o anterior.
A vantagem é um maior controle da lista, maior confiabilidade e e menor risco de perda acidental da lista.
A desvantagem é o tamanho dobrado em disco.
as funções implementadas devem ser: size(), get(), getNo(), add(), add(Index)
remove(), toString();
*/

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    //Adiciona elemento AO FINAL da lista
    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setRefProximo(null);
        novoNo.setRefAnterior(ultimoNo);

        if(primeiroNo==null){
            primeiroNo=novoNo;
        }
        if(ultimoNo!=null){
            ultimoNo.setRefProximo(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;
    }

    //Adiciona elemento indicando o indice em que ficará.
    public void addIndice(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        if(novoNo.getRefProximo()!= null){
            novoNo.setRefAnterior(noAuxiliar.getRefAnterior());
            novoNo.getRefProximo().setRefAnterior(novoNo);
        } else {
            novoNo.setRefAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index==0){
            primeiroNo = novoNo;
        }else{
            novoNo.getRefAnterior().setRefProximo(novoNo);
        }

        tamanhoLista++;
    }

    public void remove(int index){
        //caso o indice seja o primeiro da lista
        if(index==0){
            primeiroNo = primeiroNo.getRefProximo();
            if(primeiroNo!=null){
                primeiroNo.setRefAnterior(null);
            }
        }
        //Caso não seja o primeiro da lista
        else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getRefAnterior().setRefProximo(noAuxiliar.getRefProximo());
            if(noAuxiliar!= ultimoNo){
                noAuxiliar.getRefProximo().setRefAnterior(noAuxiliar.getRefAnterior());
            }else{
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; (i<index) && (noAuxiliar!= null) ;i++){
            noAuxiliar = noAuxiliar.getRefProximo();
        }
        return noAuxiliar;
    }

    //retorna o inteiro que é incrementado no add() e decrementado no remove()
    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String str ="";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i=0; i <size(); i++){
            str += "[Nó{conteudo="+noAuxiliar.getConteudo()+"}] -->";
            noAuxiliar = noAuxiliar.getRefProximo();
        }
        str += "null";
        return str;
    }
}
