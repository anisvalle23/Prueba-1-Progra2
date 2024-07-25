package prueba.pkg1.progra2;

import java.util.Scanner;

public class Movie extends RentItem {
    private String estado;

    public Movie(String codigoItem, String nombreItem, double precioRenta) {
        super(codigoItem, nombreItem, precioRenta);
        this.estado = "ESTRENO";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("""
                             *******************************
                             * C\u00f3digo: %s
                             * Nombre: %s
                             * Precio de Renta: %.2f
                             * Estado: %s
                             *******************************""",
            getCodigoItem(), getNombreItem(), getPrecioRenta(), estado
        );
    }

    @Override
    public double pagoRenta(int dias) {
        double pago = getPrecioRenta();
        if (estado.equals("ESTRENO") && dias > 2) {
            pago += (dias - 2) * 50;
        } else if (!estado.equals("ESTRENO") && dias > 5) {
            pago += (dias - 5) * 30;
        }
        return pago;
    }

    @Override
    public String submenu() {
        return super.submenu() + "\n2-Cambiar Estado";
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        Scanner read = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println(this);
                break;
            case 2:
                System.out.print("Ingrese el nuevo estado: ");
                String nuevoEstado = read.nextLine();
                setEstado(nuevoEstado);
                break;
            default:
                System.out.println("OPCION NO VALIDA");
                break;
        }
    }
}

