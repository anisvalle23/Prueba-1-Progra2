
package prueba.pkg1.progra2;
import java.util.Scanner;
  

public class Movie extends RentItem {
    private String estadoMV;

    public Movie(String codigoItem, String nombreItem, double precioRenta) {
        super(codigoItem, nombreItem, precioRenta);
        this.estadoMV = "ESTRENO";
    }

    public String getEstadoMV() {
        return estadoMV;
    }

    public void setEstadoMV(String estado) {
        this.estadoMV = estado;
    }
    
    public String toString() {
        return super.toString() + ", Estado: " + estadoMV + " – Movie";
    }

    public double pagoRenta(int dias) {
        double pago = getPrecioRenta();
        if (estadoMV.equals("ESTRENO") && dias > 2) {
            pago += (dias - 2) * 50;
        } else if (!estadoMV.equals("ESTRENO") && dias > 5) {
            pago += (dias - 5) * 30;
        }
        return pago;
    }

    public String submenu() {
        return super.submenu() + "\n2-Cambiar Estado";
    }

    public void ejecutarOpcion(int opcion) {
        Scanner scannerMV = new Scanner(System.in);
        if (opcion == 1) {
            System.out.println(this);
        } else if (opcion == 2) {
            System.out.print("Ingrese el nuevo estado: ");
            String nuevoEstadoMV = scannerMV.nextLine();
            setEstadoMV(nuevoEstadoMV);
        } else {
            System.out.println("OPCION NO VALIDA");
        }
    }
}        
