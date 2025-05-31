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

public class ProcesamientoPagos extends FuncionBase {
    private static double saldoTotal = 0;
    private static ArrayList<String[]> pagos = new ArrayList<>(); // [nombre, correo, monto]
    public static ArrayList<String[]> getPagos() { return pagos; }
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n--- Procesamiento de Pagos ---");
            System.out.println("1. Registrar pago");
            System.out.println("2. Consultar saldo total");
            System.out.println("3. Listar pagos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt(); sc.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Correo del cliente: ");
                    String correo = sc.nextLine();
                    System.out.print("Monto del pago: $");
                    double monto = sc.nextDouble(); sc.nextLine();
                    saldoTotal += monto;
                    pagos.add(new String[]{cliente, correo, String.valueOf(monto)});
                    System.out.println("Pago registrado para " + cliente + ".");
                    break;
                case 2:
                    System.out.println("Saldo total: $" + saldoTotal);
                    break;
                case 3:
                    if (pagos.isEmpty()) System.out.println("No hay pagos registrados.");
                    else for (int i = 0; i < pagos.size(); i++)
                        System.out.println((i+1)+". Cliente: "+pagos.get(i)[0]+", Correo: "+pagos.get(i)[1]+", Monto: $"+pagos.get(i)[2]);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(op != 0);
    }
}
