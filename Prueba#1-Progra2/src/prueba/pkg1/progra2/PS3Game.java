package prueba.pkg1.progra2;

import java.util.Calendar;
import java.util.Scanner;

public class PS3Game extends RentItem {
    private Calendar fechaPublicacion;

    public PS3Game(String codigoItem, String nombreItem) {
        super(codigoItem, nombreItem, 30); 
        this.fechaPublicacion = Calendar.getInstance();
    }

    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int year, int mes, int dia) {
        fechaPublicacion.set(year, mes, dia);
    }

    @Override
    public String toString() {
        return String.format(
            "*******************************\n" +
            "* Código: %s\n" +
            "* Nombre: %s\n" +
            "* Precio de Renta: %.2f\n" +
            "* Fecha de Publicación: %s\n" +
            "*******************************",
            getCodigoItem(), getNombreItem(), getPrecioRenta(), fechaPublicacion.getTime()
        );
    }

    @Override
    public double pagoRenta(int dias) {
        return getPrecioRenta() * dias;
    }

    @Override
    public String submenu() {
        return super.submenu() + "\n2-Actualizar Fecha de Publicacion";
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        if (opcion == 1) {
            System.out.println(this);
        } else if (opcion == 2) {
            System.out.print("Ingrese el año de publicación: ");
            int year = scanner.nextInt();
            System.out.print("Ingrese el mes de publicación: ");
            int mes = scanner.nextInt();
            System.out.print("Ingrese el día de publicación: ");
            int dia = scanner.nextInt();
            setFechaPublicacion(year, mes, dia);
        } else {
            System.out.println("OPCION NO VALIDA");
        }
    }
}
