package Pilha;
/*Uma pilha é uma estrutura de dados onde o ultimo elemento inserido será sempre o primeiro
 a ser removido, LIFO (Last In First Out), seguindo como regra que o ultimo elemento será
 sempre o que estará sendo trabalhado. Em uma pilha o encadeamento dos nós é feito maneira
 inversa, onde a referência do nó aponta para o ultimo antes do que está sendo inserido.
 A referencia da base (primeiro) será nula e a do topo da pilha (ultimo elemento) será o
 penultimo.
 Para uma pilha é necessário implementar um método Top, que indicará o topo da pilha, um
  método PUSH para inserir um elemento novo e um método POP para remover o ultimo elemento
  da pilha.*/

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha; //Guarda o ultimo nó em uma var aux
        refNoEntradaPilha = novoNo; //Preenche o ultimo com o novo nó
        refNoEntradaPilha.setRefNo(refAuxiliar ); //seta a referencia com o ultimo, q foi inserido no aux.
    }

    public No pop(){
        if(!isEmpty()){ //confere se a pilha não está vazia
             No noPoped = refNoEntradaPilha; //coloca o ultimo elemento num objeto separado
             refNoEntradaPilha = refNoEntradaPilha.getRefNo();//preenche o objeto com o objeto alocado na referencia de sí mesmo
             return noPoped;//retorna o que foi removido

        } return null;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        if (refNoEntradaPilha == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        String auxiliar = "---------------\n";
        System.out.println(auxiliar);
        No noAuxiliar =  refNoEntradaPilha;

        while(true){
            if(noAuxiliar != null){
                auxiliar = "[No[ ="+ noAuxiliar.getDado()+"}]";
                System.out.println(auxiliar);
                noAuxiliar = noAuxiliar.getRefNo();

            } else {
                break;
            }
        }
        System.out.println("---------------\n");
        return "Pilha\n ";
    }
}
