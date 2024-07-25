package prueba.pkg1.progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<RentItem> items = new ArrayList<>();
    private static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("*******************************");
        System.out.println("* 1- Agregar Item             *");
        System.out.println("* 2- Consultar Item           *");
        System.out.println("* 3- Ejecutar Sub Menú        *");
        System.out.println("* 4- Imprimir Todo            *");
        System.out.println("* 5- Salir                    *");
        System.out.println("*******************************");
        System.out.print("Seleccione una opción: ");
        int opcion = read.nextInt();
        read.nextLine(); 

        switch (opcion) {
            case 1:
                agregarItem();
                break;
            case 2:
                consultarItem();
                break;
            case 3:
                ejecutarSubMenu();
                break;
            case 4:
                imprimirTodo();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Opción no válida");
                break;
        }
        menu(); 
    }

    public static void agregarItem() {
        System.out.print("Ingrese el tipo de item (MOVIE/PS3): ");
        String tipo = read.nextLine();
        if (tipo.equalsIgnoreCase("MOVIE")) {
            System.out.print("Ingrese el código del item: ");
            String codigo = read.nextLine();
            System.out.print("Ingrese el nombre del item: ");
            String nombre = read.nextLine();
            System.out.print("Ingrese el precio de renta del item: ");
            double precio = read.nextDouble();
            items.add(new Movie(codigo, nombre, precio));
        } else if (tipo.equalsIgnoreCase("PS3")) {
            System.out.print("Ingrese el código del item: ");
            String codigo = read.nextLine();
            System.out.print("Ingrese el nombre del item: ");
            String nombre = read.nextLine();
            items.add(new PS3Game(codigo, nombre));
        } else {
            System.out.println("TIPO INCORRECTO");
        }
    }

    public static void consultarItem() {
        System.out.print("Ingrese el código del item: ");
        String codigo = read.nextLine();
        RentItem item = null;
        for (RentItem i : items) {
            if (i.getCodigoItem().equals(codigo)) {
                item = i;
                break;
            }
        }
        if (item != null) {
            System.out.println(item);
            System.out.print("Ingrese los días de renta: ");
            int dias = read.nextInt();
            System.out.println("Monto a pagar: " + item.pagoRenta(dias));
        } else {
            System.out.println("Item No Existe");
        }
    }

    public static void ejecutarSubMenu() {
        System.out.print("Ingrese el código del item: ");
        String codigo = read.nextLine();
        RentItem item = null;
        for (RentItem i : items) {
            if (i.getCodigoItem().equals(codigo)) {
                item = i;
                break;
            }
        }
        if (item != null) {
            System.out.println(item.submenu() + "\nEscoja Opción: ");
            int subOpcion = read.nextInt();
            item.ejecutarOpcion(subOpcion);
        } else {
            System.out.println("Item No Existe");
        }
    }

    public static void imprimirTodo() {
        for (RentItem i : items) {
            System.out.println(i);
       
        }
    }
}