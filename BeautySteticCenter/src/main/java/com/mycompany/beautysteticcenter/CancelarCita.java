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

public class CancelarCita {
    public static void ejecutar(GestionCitas sistema, Scanner scanner) {

        try {
            System.out.print("Ingresa el ID del cliente: ");
            int idCliente = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingresa la fecha y hora de la cita a cancelar (YYYY-MM-DD HH:MM): ");
            String fechaHora = scanner.nextLine();

            sistema.cancelarCita(idCliente, fechaHora);
        } catch (NumberFormatException e) {
            System.out.println("El ID ingresado no es válido, por favor inténtalo nuevamente.");
        }
    }
}
