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

class Reclamo {
    private String cliente;
    private String correo;
    private String descripcion;
    public Reclamo(String cliente, String correo, String descripcion) {
        this.cliente = cliente;
        this.correo = correo;
        this.descripcion = descripcion;
    }
    public String getCliente() { return cliente; }
    public String getCorreo() { return correo; }
    public String toString() {
        return "Cliente: " + cliente + ", Correo: " + correo + ", Descripción: " + descripcion;
    }
}

public class GestionReclamos extends FuncionBase {
    private static ArrayList<Reclamo> reclamos = new ArrayList<>();
    public static ArrayList<Reclamo> getReclamos() { return reclamos; }
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- Gestión de Reclamos y Quejas ---");
            System.out.println("1. Registrar reclamo/queja");
            System.out.println("2. Listar reclamos/quejas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt(); sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Correo del cliente: ");
                    String correo = sc.nextLine();
                    System.out.print("Descripción del reclamo/queja: ");
                    String desc = sc.nextLine();
                    reclamos.add(new Reclamo(cliente, correo, desc));
                    System.out.println("Reclamo registrado.");
                    break;
                case 2:
                    if (reclamos.isEmpty()) System.out.println("No hay reclamos registrados.");
                    else for (int i = 0; i < reclamos.size(); i++)
                        System.out.println((i+1)+". "+reclamos.get(i));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }
}
