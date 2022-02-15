
public class No {

    private Object objeto = new Object();
    private No refNo = new No();

    public No(){
    }

    public No(Object objeto) {
        this.refNo = null;
        this.objeto = objeto;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
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
