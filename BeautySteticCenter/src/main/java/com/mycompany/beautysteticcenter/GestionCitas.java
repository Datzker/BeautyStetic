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

class Cita {
    private String nombre;
    private String correo;
    private String fecha;
    private String hora;

    public Cita(String nombre, String correo, String fecha, String hora) {
        this.nombre = nombre;
        this.correo = correo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String toString() {
        return "Nombre: " + nombre + ", Correo: " + correo + ", Fecha: " + fecha + ", Hora: " + hora;
    }
}

public class GestionCitas extends FuncionBase {
    private static ArrayList<Cita> citas = new ArrayList<>();
    public static ArrayList<Cita> getCitas() { return citas; }

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- Gestión de Citas ---");
            System.out.println("1. Agendar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Cancelar cita");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt(); sc.nextLine();

            switch(op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    System.out.print("Fecha (dd/mm/yyyy): ");
                    String fecha = sc.nextLine();

                    System.out.print("Hora (hh:mm): ");
                    String hora = sc.nextLine();

                    citas.add(new Cita(nombre, correo, fecha, hora));
                    System.out.println("Cita agendada.");
                    break;
                case 2:
                    if (citas.isEmpty()) System.out.println("No hay citas.");
                    else for (int i = 0; i < citas.size(); i++)
                        System.out.println((i+1)+". "+citas.get(i));
                    break;
                case 3:
                    if (citas.isEmpty()) { System.out.println("No hay citas para cancelar."); break; }

                    for (int i = 0; i < citas.size(); i++)
                        System.out.println((i+1)+". "+citas.get(i));
                        
                    System.out.print("Ingrese el número de cita a cancelar: ");
                    int idx = sc.nextInt(); sc.nextLine();

                    if (idx > 0 && idx <= citas.size()) {
                        citas.remove(idx-1);
                        System.out.println("Cita cancelada.");
                    } else System.out.println("Índice inválido.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }
}
