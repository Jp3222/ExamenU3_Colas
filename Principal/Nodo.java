package examenu3_colas2;

public class Nodo {

    String tipo;
    boolean vip;
    int i;
    Nodo siguiente;

    public Nodo(String t, boolean v, int i) {
        this.tipo = t;
        this.vip = v;
        this.i = i;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return " [" + tipo + " " + i + "]";
    }

}
