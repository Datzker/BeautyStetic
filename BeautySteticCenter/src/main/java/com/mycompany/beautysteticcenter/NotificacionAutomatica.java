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

public class NotificacionAutomatica {

    public static void ejecutar(GestionCitas sistema, Scanner scanner) {

        try {
            System.out.print("Ingresa el ID del cliente para enviar la notificación: ");
            int idCliente = Integer.parseInt(scanner.nextLine());
            Cliente cliente = sistema.getClientePorId(idCliente);


            if (cliente != null) {
                boolean tieneCita = false;

                for (Cita cita : sistema.getCitasDeCliente(idCliente)) {
                    Notificaciones.enviarNotificacion(cliente.getCorreo(), cita.getFechaHora());
                    tieneCita = true;
                }

                if (!tieneCita) {
                    System.out.println("El cliente no tiene citas registradas para notificar.");
                } else {
                    System.out.println("El cliente " + cliente.getNombre() + " (ID: " + cliente.getId() + ") ha sido notificado por todas sus citas activas.");
                }

            } else {
                System.out.println("El ID de cliente indicado no existe.");
            }

        } catch (NumberFormatException e) {
            System.out.println("El ID ingresado no es válido, por favor inténtalo nuevamente.");
        }
    }
}
