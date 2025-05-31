/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.mycompany.beautysteticcenter;

/**
* EQUIPO:
*       Isabella Gomez Parra.																
*       Yorlando Montiel Guerra.																	
*       Carlos Mario Montes Rua.																	
*       Daniel Eduardo González Palacio.																
*/

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FuncionBase[] funciones = {
            new GestionCitas(),
            new ProcesamientoPagos(),
            new GestionInventarios(),
            new EnvioNotificaciones(),
            new GestionReclamos()
        };

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión de citas");
            System.out.println("2. Procesamiento de pagos");
            System.out.println("3. Gestión de Inventarios");
            System.out.println("4. Envío de Notificaciones automáticas");
            System.out.println("5. Gestión de reclamos y quejas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                funciones[opcion - 1].ejecutar();
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
            
        } while (opcion != 0);
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
