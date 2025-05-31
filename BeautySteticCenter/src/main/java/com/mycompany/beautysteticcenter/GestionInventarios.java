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

class Producto {
    private String nombre;
    private int cantidad;
    private String responsable;
    private String correo;
    public Producto(String nombre, int cantidad, String responsable, String correo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.responsable = responsable;
        this.correo = correo;
    }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public String getResponsable() { return responsable; }
    public String getCorreo() { return correo; }
    public String toString() { return nombre + " (Cantidad: " + cantidad + ", Responsable: " + responsable + ", Correo: " + correo + ")"; }
}

public class GestionInventarios extends FuncionBase {
    private static ArrayList<Producto> inventario = new ArrayList<>();
    public static ArrayList<Producto> getInventario() { return inventario; }
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- Gestión de Inventarios ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar inventario");
            System.out.println("3. Actualizar cantidad");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt(); sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt(); sc.nextLine();
                    System.out.print("Responsable: ");
                    String responsable = sc.nextLine();
                    System.out.print("Correo del responsable: ");
                    String correo = sc.nextLine();
                    inventario.add(new Producto(nombre, cantidad, responsable, correo));
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    if (inventario.isEmpty()) System.out.println("Inventario vacío.");
                    else for (int i = 0; i < inventario.size(); i++)
                        System.out.println((i+1)+". "+inventario.get(i));
                    break;
                case 3:
                    if (inventario.isEmpty()) { System.out.println("Inventario vacío."); break; }
                    for (int i = 0; i < inventario.size(); i++)
                        System.out.println((i+1)+". "+inventario.get(i));
                    System.out.print("Ingrese el número de producto a actualizar: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    if (idx > 0 && idx <= inventario.size()) {
                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = sc.nextInt(); sc.nextLine();
                        inventario.get(idx-1).setCantidad(nuevaCantidad);
                        System.out.println("Cantidad actualizada.");
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
