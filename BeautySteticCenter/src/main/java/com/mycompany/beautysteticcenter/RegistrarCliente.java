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

public class RegistrarCliente {

    public static void ejecutar(GestionCitas sistema, Scanner scanner) {

        System.out.print("Ingresa el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingresa el correo electrónico del cliente: ");
        String correo = scanner.nextLine();

        sistema.registrarCliente(nombre, telefono, correo);
    }
}
