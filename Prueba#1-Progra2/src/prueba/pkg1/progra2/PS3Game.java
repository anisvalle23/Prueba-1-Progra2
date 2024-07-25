
package prueba.pkg1.progra2;

import java.util.Calendar;
import java.util.Scanner;


public class PS3Game extends RentItem {
    private Calendar fechaPublicacionPS;

    public PS3Game(String codigoItem, String nombreItem) {
        super(codigoItem, nombreItem, 30);
        this.fechaPublicacionPS = Calendar.getInstance();
    }

    public Calendar getFechaPublicacionPS() {
        return fechaPublicacionPS;
    }

    public void setFechaPublicacionPS(int year, int mes, int dia) {
        fechaPublicacionPS.set(year, mes, dia);
    }

    @Override
    public String toString() {
        return super.toString() + ", Fecha de Publicación: " + fechaPublicacionPS.getTime() + " – PS3 Game";
    }

    @Override
    public double pagoRenta(int dias) {
        return getPrecioRenta() * dias;
    }

    public String submenuRI() {
        return super.submenu() + "\n2-Actualizar Fecha de Publicacion";
    }

    @Override
    public void ejecutarOpcionRI(int opcion) {
        Scanner scannerPS = new Scanner(System.in);
        if (opcion == 1) {
            System.out.println(this);
        } else if (opcion == 2) {
            System.out.print("Ingrese el año de publicación: ");
            int yearPS = scannerPS.nextInt();
            System.out.print("Ingrese el mes de publicación: ");
            int mesPS = scannerPS.nextInt();
            System.out.print("Ingrese el día de publicación: ");
            int diaPS = scannerPS.nextInt();
            setFechaPublicacionPS(yearPS, mesPS, diaPS);
        } else {
            System.out.println("OPCION NO VALIDA");
        }
    }
}



