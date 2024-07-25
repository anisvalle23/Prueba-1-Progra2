
package prueba.pkg1.progra2;


public class RentItem {
     private String codigoItem;
    private String nombreItem;
    private double precioRenta;
    private int cantidadCopias;
    
     public RentItem(String codigoItem, String nombreItem, double precioRenta) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.precioRenta = precioRenta;
        this.cantidadCopias = 0;
    }
  @Override
    public String toString() {
        return "CODIGO: " + codigoItem + ", NOMBRE: " + nombreItem + ", PRECIO DE RENTA: " + precioRenta;
    }

    public double pagoRenta(int dias) {
        return 0;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public String submenu() {
        return "1-Imprimir";
    }

   
    public void ejecutarOpcionRI(int opcion) {
        if (opcion == 1) {
            System.out.println(this);
        } else {
            System.out.println("Opcion No Valida");
        }
    }
}