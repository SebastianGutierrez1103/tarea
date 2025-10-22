package presentacion;

import datos.ListVehiculo;
import datos.IBDVehiculo;
import dominio.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import logica.GestionVehiculo;
import logica.ParkingManager;

public class Main {

    public static void main(String[] args) {

        GestionVehiculo logicaVehiculo = new GestionVehiculo();
        ParkingManager parqueadero = new ParkingManager();
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Adicionar vehiculo");
            System.out.println("2. Registrar ingreso");
            System.out.println("3. Registrar salida");
            System.out.println("4. Ver registro del parqueadero");
            System.out.println("5. Listar todos los vehiculos registrados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Seleccione tipo de vehiculo:");
                    System.out.println("1. Auto");
                    System.out.println("2. Moto");
                    System.out.println("3. Bicicleta");
                    System.out.print("Tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese placa o codigo: ");
                    String placa = sc.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Ingrese modelo (anio): ");
                        int modelo = sc.nextInt();
                        System.out.print("Ingrese numero de puertas: ");
                        int puertas = sc.nextInt();
                        Vehiculo auto = new Auto(placa, marca, modelo, puertas);
                        logicaVehiculo.adicionarVehiculo(auto);
                        System.out.println("Auto registrado correctamente.");
                    } else if (tipo == 2) {
                        System.out.print("Ingrese cilindraje: ");
                        int cilindraje = sc.nextInt();
                        Vehiculo moto = new Moto(placa, marca, cilindraje);
                        logicaVehiculo.adicionarVehiculo(moto);
                        System.out.println("Moto registrada correctamente.");
                    } else if (tipo == 3) {
                        System.out.print("Es electrica? (true/false): ");
                        boolean electrica = sc.nextBoolean();
                        Vehiculo bici = new Bicicleta(placa, marca, electrica);
                        logicaVehiculo.adicionarVehiculo(bici);
                        System.out.println("Bicicleta registrada correctamente.");
                    } else {
                        System.out.println("Tipo no valido");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese placa o codigo del vehiculo para registrar ingreso: ");
                    String ing = sc.nextLine();
                    Vehiculo vIng = logicaVehiculo.buscar(ing);
                    if (vIng != null) {
                        parqueadero.registroIngreso(vIng);
                        String horaIngreso = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        System.out.println("Hora de ingreso: " + horaIngreso);
                        System.out.println("Ingreso registrado correctamente.");
                    } else {
                        System.out.println("Vehiculo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese placa o codigo del vehiculo para registrar salida: ");
                    String sal = sc.nextLine();
                    Ticket ticket = parqueadero.registrarSalida(sal);
                    if (ticket != null) {
                        String horaSalida = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        System.out.println("Hora de salida: " + horaSalida);
                        parqueadero.imprimirTicket(ticket);
                    } else {
                        System.out.println("Vehiculo no encontrado o no esta en el parqueadero.");
                    }
                    break;

                case 4:
                    System.out.println("\n==== REGISTRO DEL PARQUEADERO ====");
                    parqueadero.printRegistro();
                    System.out.println("==================================\n");
                    break;

                case 5:
                    System.out.println("\n==== LISTA DE VEHICULOS REGISTRADOS ====");
                    List<Vehiculo> lista = logicaVehiculo.listarTodos(); // ✅ ahora usa la BD real
                    if (lista != null && !lista.isEmpty()) {
                        for (Vehiculo v : lista) {
                            System.out.println(v);
                        }
                    } else {
                        System.out.println("No hay vehiculos registrados.");
                    }
                    System.out.println("========================================\n");
                    break;

                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close();
    }
}
