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

public class Notificaciones {

    //  solo imprime notificación si hay cita y cliente válidos
    public static void enviarNotificacion(String correo, String fechaHora) {

        if (fechaHora != null) {
            System.out.println("[EMAIL] Enviando notificación al correo: " + correo);
            System.out.println("[EMAIL] Notificación: Recordatorio de cita para el " + fechaHora);
            System.out.println("[SMS] Enviando notificación al celular asociado al correo: " + correo);
            System.out.println("[SMS] Notificación: Recordatorio de cita para el " + fechaHora);

        } else {
            System.out.println("[EMAIL] Enviando notificación al correo: " + correo);
            System.out.println("[EMAIL] Notificación: La cita ha sido cancelada.");
            System.out.println("[SMS] Enviando notificación al celular asociado al correo: " + correo);
            System.out.println("[SMS] Notificación: La cita ha sido cancelada.");
        }
    }
}
