package prueba.pkg1.progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<RentItem> itemsMN = new ArrayList<>();
    private static Scanner scannerMN = new Scanner(System.in);

    public static void main(String[] args) {
        menuMN();
    }

    public static void menuMN() {
        System.out.println("1- Agregar Item");
        System.out.println("2- Consultar Item");
        System.out.println("3- Ejecutar Sub Menú");
        System.out.println("4- Imprimir Todo");
        System.out.println("5- Salir");
        System.out.print("Seleccione una opción: ");
        int opcionMN = scannerMN.nextInt();
        scannerMN.nextLine(); // Limpiar buffer

        if (opcionMN == 1) {
            agregarItemMN();
        } else if (opcionMN == 2) {
            consultarItemMN();
        } else if (opcionMN == 3) {
            ejecutarSubMenuMN();
        } else if (opcionMN == 4) {
            imprimirTodoMN();
        } else if (opcionMN == 5) {
            System.exit(0);
        } else {
            System.out.println("Opción no válida");
        }
        menuMN(); // Llamar recursivamente al menú
    }

    public static void agregarItemMN() {
        System.out.print("Ingrese el tipo de item (MOVIE/PS3): ");
        String tipoMN = scannerMN.nextLine();
        if (tipoMN.equalsIgnoreCase("MOVIE")) {
            System.out.print("Ingrese el código del item: ");
            String codigoMN = scannerMN.nextLine();
            System.out.print("Ingrese el nombre del item: ");
            String nombreMN = scannerMN.nextLine();
            System.out.print("Ingrese el precio de renta del item: ");
            double precioMN = scannerMN.nextDouble();
            itemsMN.add(new Movie(codigoMN, nombreMN, precioMN));
        } else if (tipoMN.equalsIgnoreCase("PS3")) {
            System.out.print("Ingrese el código del item: ");
            String codigoMN = scannerMN.nextLine();
            System.out.print("Ingrese el nombre del item: ");
            String nombreMN = scannerMN.nextLine();
            itemsMN.add(new PS3Game(codigoMN, nombreMN));
        } else {
            System.out.println("TIPO INCORRECTO");
        }
    }

    public static void consultarItemMN() {
        System.out.print("Ingrese el código del item: ");
        String codigoMN = scannerMN.nextLine();
        RentItem itemMN = null;
        for (RentItem i : itemsMN) {
            if (i.getCodigoItem().equals(codigoMN)) {
                itemMN = i;
                break;
            }
        }
        if (itemMN != null) {
            System.out.println(itemMN);
            System.out.print("Ingrese los días de renta: ");
            int diasMN = scannerMN.nextInt();
            System.out.println("Monto a pagar: " + itemMN.pagoRenta(diasMN));
        } else {
            System.out.println("Item No Existe");
        }
    }

    public static void ejecutarSubMenuMN() {
        System.out.print("Ingrese el código del item: ");
        String codigoMN = scannerMN.nextLine();
        RentItem itemMN = null;
        for (RentItem i : itemsMN) {
            if (i.getCodigoItem().equals(codigoMN)) {
                itemMN = i;
                break;
            }
        }
        if (itemMN != null) {
            System.out.println(itemMN.submenu() + "\nEscoja Opción: ");
            int subOpcionMN = scannerMN.nextInt();
            itemMN.ejecutarOpcionRI(subOpcionMN);
        } else {
            System.out.println("Item No Existe");
        }
    }

    public static void imprimirTodoMN() {
        for (RentItem i : itemsMN) {
            System.out.println(i);
        }
    }
}
