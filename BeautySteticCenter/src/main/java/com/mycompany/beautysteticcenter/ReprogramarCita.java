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

public class ReprogramarCita {
    public static void ejecutar(GestionCitas sistema, Scanner scanner) {

        try {
            System.out.print("Ingresa el ID del cliente: ");
            int idCliente = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingresa la fecha y hora de la cita actual (YYYY-MM-DD HH:MM): ");
            String fechaHoraActual = scanner.nextLine();

            System.out.print("Ingresa la nueva fecha y hora de la cita (YYYY-MM-DD HH:MM): ");
            String nuevaFechaHora = scanner.nextLine();

            sistema.reprogramarCita(idCliente, fechaHoraActual, nuevaFechaHora);

        } catch (NumberFormatException e) {

            System.out.println("El ID ingresado no es válido, por favor inténtalo nuevamente.");
        }
    }
}
