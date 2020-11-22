package examenu3_colas2;

public class Cola {

    Nodo inicioComun, finComun;
    Nodo inicioVip, finVip;
    Nodo M[];

    public Cola() {
        this.inicioComun = null;
        this.finComun = null;
        this.inicioVip = null;
        this.finVip = null;
        this.M = new Nodo[3];
    }

    public boolean isEmpty() {
        return VipIsEmpty() && ComunIsEmpty();
    }

    private boolean VipIsEmpty() {
        return inicioVip == null;
    }

    private boolean ComunIsEmpty() {
        return inicioComun == null;
    }

    public void Cliente(String tipo, boolean vip, int i) {
        if (vip) {
            AgregarVip(tipo, vip, i);
        } else {
            AgregarComun(tipo, vip, i);
        }
    }

    private void AgregarVip(String tipo, boolean vip, int i) {
        Nodo nuevo = new Nodo(tipo, vip, i);
        if (VipIsEmpty()) {
            inicioVip = nuevo;
        } else {
            finVip.siguiente = nuevo;
        }
        finVip = nuevo;
    }

    private void AgregarComun(String tipo, boolean vip, int i) {
        Nodo nuevo = new Nodo(tipo, vip, i);
        if (ComunIsEmpty()) {
            inicioComun = nuevo;
        } else {
            finComun.siguiente = nuevo;
        }
        finComun = nuevo;
    }

    private Nodo QuitarVip() {
        Nodo aux = inicioVip;
        inicioVip = inicioVip.siguiente;
        return aux;
    }

    private Nodo QuitarComun() {
        Nodo aux = inicioComun;
        inicioComun = inicioComun.siguiente;
        return aux;
    }

    public void Pasar() {
        int i = 0;
        for (; i < M.length; i++) {
            if (!VipIsEmpty()) {
                M[i] = QuitarVip();
                System.out.println("Ventanilla[" + (i + 1) + "] [" + M[i].tipo + " " + M[i].i + "]");
                M[i] = null;
            } else {
                break;
            }
        }
        if (i < M.length) {
            for (; i < M.length; i++) {
                if (!ComunIsEmpty()) {
                    M[i] = QuitarComun();
                    System.out.println("Ventanilla[" + (i + 1) + "] [" + M[i].tipo + " " + M[i].i + "]");
                    M[i] = null;
                } else {
                    break;
                }
            }
        }
    }

    public void Ventanilla(int i) {
        if (i >= 0 && i < M.length) {
            if (!VipIsEmpty()) {
                M[i] = QuitarVip();
                System.out.println("Ventanilla[" + (i + 1) + "] [" + M[i].tipo + " " + M[i].i + "]");
                M[i] = null;
            } else if (!ComunIsEmpty()) {
                M[i] = QuitarComun();
                System.out.println("Ventanilla[" + (i + 1) + "] [" + M[i].tipo + " " + M[i].i + "]");
                M[i] = null;
            }
        }
    }

    public void MostrarColaVip() {
        if (!VipIsEmpty()) {
            Nodo r1 = inicioVip;
            System.out.println("Clientes: ");
            while (r1 != null) {
                System.out.print("[" + r1.tipo + " " + r1.i + "]");
                r1 = r1.siguiente;
            }
        } else {
            System.out.println("La cola vip esta vacia");
        }
    }

    public void MostrarColaComun() {
        if (!ComunIsEmpty()) {
            Nodo r2 = inicioComun;
            System.out.println("Clientes: ");
            while (r2 != null) {
                System.out.print("[" + r2.tipo + " " + r2.i + "]");
                r2 = r2.siguiente;
            }
            System.out.println("");
        } else {
            System.out.println("La cola comun esta vacia");
        }
    }

}

