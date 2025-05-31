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

import java.util.ArrayList;
import java.util.Scanner;

class Destinatario {
    private String nombre;
    private String correo;
    public Destinatario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String toString() { return nombre + " <" + correo + ">"; }
}

public class EnvioNotificaciones extends FuncionBase {
    private static ArrayList<Destinatario> destinatarios = new ArrayList<>();
    private static ArrayList<String> notificaciones = new ArrayList<>();
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- Envío de Notificaciones Automáticas ---");
            System.out.println("1. Registrar destinatario manualmente");
            System.out.println("2. Importar destinatarios de otras funciones");
            System.out.println("3. Enviar notificación a todos");
            System.out.println("4. Ver historial de notificaciones");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt(); sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nombre del destinatario: ");
                    String nombre = sc.nextLine();
                    System.out.print("Correo electrónico: ");
                    String correo = sc.nextLine();
                    if (!datosValidos(nombre, correo)) {
                        System.out.println("Datos inválidos. Intente de nuevo.");
                        break;
                    }
                    if (existeDestinatario(nombre, correo)) {
                        System.out.println("El destinatario ya está registrado.");
                        break;
                    }
                    destinatarios.add(new Destinatario(nombre, correo));
                    System.out.println("Destinatario registrado.");
                    break;
                case 2:
                    importarDestinatarios();
                    break;
                case 3:
                    if (destinatarios.isEmpty()) {
                        System.out.println("No hay destinatarios registrados.");
                        break;
                    }
                    System.out.print("Mensaje de notificación: ");
                    String mensaje = sc.nextLine();
                    for (Destinatario d : destinatarios) {
                        String noti = "[SIMULADO] Enviado a: " + d.getNombre() + " <" + d.getCorreo() + "> - Mensaje: " + mensaje;
                        notificaciones.add(noti);
                        System.out.println(noti);
                    }
                    break;
                case 4:
                    if (notificaciones.isEmpty()) System.out.println("No hay notificaciones enviadas.");
                    else for (int i = 0; i < notificaciones.size(); i++)
                        System.out.println((i+1)+". "+notificaciones.get(i));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }

    private void importarDestinatarios() {
        int total = 0;
        // Importar de citas
        for (Cita c : GestionCitas.getCitas()) {
            if (datosValidos(c.getNombre(), c.getCorreo()) && !existeDestinatario(c.getNombre(), c.getCorreo())) {
                destinatarios.add(new Destinatario(c.getNombre(), c.getCorreo()));
                total++;
            }
        }
        // Importar de pagos
        for (String[] pago : ProcesamientoPagos.getPagos()) {
            if (pago.length >= 2 && datosValidos(pago[0], pago[1]) && !existeDestinatario(pago[0], pago[1])) {
                destinatarios.add(new Destinatario(pago[0], pago[1]));
                total++;
            }
        }
        // Importar de inventario
        for (Producto p : GestionInventarios.getInventario()) {
            if (datosValidos(p.getResponsable(), p.getCorreo()) && !existeDestinatario(p.getResponsable(), p.getCorreo())) {
                destinatarios.add(new Destinatario(p.getResponsable(), p.getCorreo()));
                total++;
            }
        }
        // Importar de reclamos
        for (Reclamo r : GestionReclamos.getReclamos()) {
            if (datosValidos(r.getCliente(), r.getCorreo()) && !existeDestinatario(r.getCliente(), r.getCorreo())) {
                destinatarios.add(new Destinatario(r.getCliente(), r.getCorreo()));
                total++;
            }
        }
        System.out.println("Se importaron " + total + " destinatarios de otras funciones.");
    }

    private boolean existeDestinatario(String nombre, String correo) {
        if (!datosValidos(nombre, correo)) return false;
        String nombreTrim = nombre.trim();
        String correoTrim = correo.trim();
        for (Destinatario d : destinatarios) {
            if (d.getNombre().trim().equalsIgnoreCase(nombreTrim) && d.getCorreo().trim().equalsIgnoreCase(correoTrim)) {
                return true;
            }
        }
        return false;
    }

    private boolean datosValidos(String nombre, String correo) {
        return nombre != null && correo != null && !nombre.trim().isEmpty() && !correo.trim().isEmpty();
    }
}
