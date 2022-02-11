package Pilha;

public class No {

    private int dado;
    private No refNo = null;

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }

    public No(){}

    public No(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }
}
