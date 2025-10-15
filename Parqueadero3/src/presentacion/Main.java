package presentacion;


import datos.BDVehiculo;
import datos.IBDVehiculo;
import dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import logica.ParkingManager;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IBDVehiculo bd = new BDVehiculo();
        ParkingManager parqueadero = new ParkingManager();

        int opcion;

        do {
            System.out.println("\n===== MENU PARQUEADERO =====");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Generar ticket");
            System.out.println("3. Listar todos los vehiculos");
            System.out.println("4. Buscar vehiculo por placa");
            System.out.println("5. Mostrar total de vehiculos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- AGREGAR VEHICULO ---");
                    System.out.print("Tipo (auto/moto/bici): ");
                    String tipo = sc.nextLine().toLowerCase();

                    System.out.print("Placa o ID: ");
                    String placa = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    Vehiculo v = null;

                    switch (tipo) {
                        case "auto":
                            System.out.print("Anio: ");
                            int anio = sc.nextInt();
                            System.out.print("Numero de puertas: ");
                            int puertas = sc.nextInt();
                            v = new Auto(placa, marca, anio, puertas);
                            break;
                        case "moto":
                            System.out.print("Cilindraje: ");
                            int cilindraje = sc.nextInt();
                            v = new Moto(placa, marca, cilindraje);
                            break;
                        case "bici":
                            System.out.print("Tiene motor? (true/false): ");
                            boolean motor = sc.nextBoolean();
                            v = new Bicicleta(placa, marca, motor);
                            break;
                        default:
                            System.out.println("Tipo no valido.");
                    }

                    if (v != null) {
                        bd.adicionarVehiculo(v);
                        System.out.println("Vehiculo agregado correctamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- GENERAR TICKET ---");
                    System.out.print("Ingrese la placa del vehiculo: ");
                    String placaBuscada = sc.nextLine();
                    Vehiculo vehiculo = bd.buscar(placaBuscada);

                    if (vehiculo != null) {
                        System.out.print("Horas de estacionamiento: ");
                        int horas = sc.nextInt();
                        Ticket ticket = parqueadero.generarTicket(
                                LocalDateTime.now(),
                                LocalDateTime.now().plusHours(horas),
                                vehiculo
                        );
                        parqueadero.imprimirTicket(ticket);
                    } else {
                        System.out.println("Vehiculo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE VEHICULOS ---");
                    imprimir(bd.listarTodos());
                    break;

                case 4:
                    System.out.println("\n--- BUSCAR VEHICULO ---");
                    System.out.print("Ingrese la placa del vehiculo: ");
                    String buscarPlaca = sc.nextLine();
                    Vehiculo encontrado = bd.buscar(buscarPlaca);
                    if (encontrado != null) {
                        System.out.println("Vehiculo encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No se encontro ningun vehiculo con esa placa.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- TOTAL DE VEHICULOS ---");
                    System.out.println("Cantidad total de vehiculos: " + bd.listarTodos().size());
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }

        } while (opcion != 6);
    }

    public static void imprimir(ArrayList<Vehiculo> lista) {
        for (Vehiculo v : lista) {
            System.out.println(v);
        }
    }
}
