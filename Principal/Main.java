package examenu3_colas2;

import java.util.Scanner;

public class ExamenU3_Colas2 {

    public static void main(String[] args) {
        Scanner V = new Scanner(System.in);
        Cola c = new Cola();
        int opc, i = 0;
        do {
            System.out.println("--- Banco xD ---"
                    + "\n[1]Nuevo cliente"
                    + "\n[2]Pasar a ventanilla"
                    + "\n[3]Terminar ventanilla"
                    + "\n[4]Mostrar Colas"
                    + "\n[5]Salir\n");
            opc = V.nextInt();
            switch (opc) {
                case 1:
                    boolean vip = vip();
                    if (vip) {
                        i++;
                        System.out.println("Cliente" + i + " Vip");
                        c.Cliente("Vip", vip, i);
                    } else {
                        i++;
                        System.out.println("Cliente" + i + " Comuns");
                        c.Cliente("Comun", vip, i);
                    }
                    break;
                case 2:
                    if (!c.isEmpty()) {
                        c.Pasar();
                    } else {
                        System.out.println("Las colas estan vacias");

                    }
                    break;
                case 3:
                    if (!c.isEmpty()) {
                        int n = (int) (Math.random() * 3);
                        c.Ventanilla(n);
                    } else {
                        System.out.println("Las colas estan vacias");

                    }
                    break;
                case 4:
                    if (!c.isEmpty()) {
                        c.Mostrar();
                    } else {
                        System.out.println("Las colas estan vacias");
                    }
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion Erronea");
            }
        } while (opc != 5);
    }

    public static boolean vip() {
        int r = (int) (Math.random() * 2);
        return r == 0;
    }

}
