/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.mycompany.beautysteticcenter;

import java.util.Scanner;

/**
* EQUIPO:
*       Isabella Gomez Parra.																
*       Yorlando Montiel Guerra.																	
*       Carlos Mario Montes Rua.																	
*       Daniel Eduardo González Palacio.																
*/

public class Menu {
    public static void main(String[] args) {

        GestionCitas sistema = new GestionCitas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gestión de Citas - Beauty Stetic Center ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Cita");
            System.out.println("3. Cancelar Cita");
            System.out.println("4. Reprogramar Cita");
            System.out.println("5. Notificaciones Automáticas");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Listar Citas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción (0, 1-7): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    RegistrarCliente.ejecutar(sistema, scanner);
                    break;
                case "2":
                    RegistrarCita.ejecutar(sistema, scanner);
                    break;
                case "3":
                    CancelarCita.ejecutar(sistema, scanner);
                    break;
                case "4":
                    ReprogramarCita.ejecutar(sistema, scanner);
                    break;
                case "5":
                    NotificacionAutomatica.ejecutar(sistema, scanner);
                    break;
                case "6":
                    sistema.listarClientes();
                    break;
                case "7":
                    ListarCitas.ejecutar(sistema);
                    break;
                case "0":
                    System.out.println("Saliste del sistema!");
                    scanner.close();
                    return;
                default:
                    System.out.println("La opción digitada no es válida. Inténtalo de nuevo.");
            }
        }
    }
}
