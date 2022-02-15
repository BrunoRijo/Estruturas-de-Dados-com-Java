
public class No<T> {

    private T objeto;
    private No<T> refNo;

    public No(){}

    public No(T objeto) {
        this.refNo = null;
        this.objeto = objeto;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public No getRefNextNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "objeto=" + objeto +
                '}';
    }
}
