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
import java.util.List;

public class GestionCitas {
    private List<Cliente> clientes;
    private List<Cita> citas;

    public GestionCitas() {
        clientes = new ArrayList<>();
        citas = new ArrayList<>();
    }    
    
    // Registrar un nuevo cliente
    public void registrarCliente(String nombre, String telefono, String correo) {
        Cliente nuevoCliente = new Cliente(nombre, telefono, correo);
        clientes.add(nuevoCliente);
        System.out.println("El cliente fue registrado: ID: " + nuevoCliente.getId() + ", Nombre: " + nuevoCliente.getNombre() + ", Teléfono: " + nuevoCliente.getTelefono() + ", Correo: " + nuevoCliente.getCorreo());
    }    
    
    // Registrar una nueva cita
    public void registrarCita(int idCliente, String fechaHora) {
        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente != null) {
            Cita nuevaCita = new Cita(cliente, fechaHora);
            citas.add(nuevaCita);

            System.out.println("Cita registrada para " + cliente.getNombre() + " (ID: " + cliente.getId() + ") en " + nuevaCita.getFechaHora());
            Notificaciones.enviarNotificacion(cliente.getCorreo(), nuevaCita.getFechaHora());
        } else {
            System.out.println("El cliente indicado no existe en el sistema.");
        }
    }    
    
    // Cancelar una cita existente
    public void cancelarCita(int idCliente, String fechaHora) {
        Cita cita = buscarCita(idCliente, fechaHora);

        if (cita != null) {
            citas.remove(cita);
            System.out.println("Cita cancelada para " + cita.getCliente().getNombre() + " (ID: " + cita.getCliente().getId() + ") en " + cita.getFechaHora());
            Notificaciones.enviarNotificacion(cita.getCliente().getCorreo(), null);
        } else {
            System.out.println("La cita indicada no existe en el sistema.");
        }
    }    
    
    // Reprogramar una cita existente
    public void reprogramarCita(int idCliente, String fechaHoraActual, String nuevaFechaHora) {
        Cita cita = buscarCita(idCliente, fechaHoraActual);
        if (cita != null) {
            cita.setFechaHora(nuevaFechaHora);
            System.out.println("Cita reprogramada para " + cita.getCliente().getNombre() + " (ID: " + cita.getCliente().getId() + ") a " + nuevaFechaHora);
            Notificaciones.enviarNotificacion(cita.getCliente().getCorreo(), nuevaFechaHora);
        } else {
            System.out.println("La cita indicada no existe en el sistema.");
        }
    }    
    
    // Notificación automática mejorada: solo notifica si el cliente y al menos una cita existen
    public void notificacionAutomatica(int idCliente) {
        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente != null) {
            boolean tieneCita = false;

            for (Cita cita : citas) {
                if (cita.getCliente().getId() == idCliente) {
                    tieneCita = true;
                    // Notifica por cada cita activa
                    Notificaciones.enviarNotificacion(cliente.getCorreo(), cita.getFechaHora());
                }
            }

            if (!tieneCita) {
                System.out.println("El cliente no tiene citas registradas para notificar.");
            } else {
                System.out.println("El cliente " + cliente.getNombre() + " (ID: " + cliente.getId() + ") ha sido notificado por todas sus citas activas.");
            }
        } else {
            System.out.println("El ID de cliente indicado no existe.");
        }
    }

    public void notificarCancelacion(int idCliente, String fechaHora) {
        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente != null) {
            Cita cita = buscarCita(idCliente, fechaHora);

            if (cita != null) {
                Notificaciones.enviarNotificacion(cliente.getCorreo(), null);
                System.out.println("El cliente " + cliente.getNombre() + " (ID: " + cliente.getId() + ") ha sido notificado de la cancelación de la cita en " + fechaHora + ".");
            
            } else {
                System.out.println("La cita indicada no existe para este cliente.");
            }

        } else {
            System.out.println("El ID de cliente indicado no existe.");
        }
    }

    // Método para listar todos los clientes registrados
    public void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Clientes registrados:");

            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono() + ", Correo: " + c.getCorreo());
            }
        }
    }

    // Método para listar todas las citas creadas y el ID de cliente asociado
    public void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("Citas registradas:");

            for (Cita c : citas) {
                System.out.println("Cliente ID: " + c.getCliente().getId() + ", Nombre: " + c.getCliente().getNombre() + ", Fecha y hora: " + c.getFechaHora());
            }
        }
    }

    public Cliente getClientePorId(int idCliente) {
        return buscarClientePorId(idCliente);
    }

    public List<Cita> getCitasDeCliente(int idCliente) {
        List<Cita> citasCliente = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getCliente().getId() == idCliente) {
                citasCliente.add(c);
            }
        }
        return citasCliente;
    }

    private Cliente buscarClientePorId(int idCliente) {

        for (Cliente c : clientes) {
            if (c.getId() == idCliente) return c;
        }
        return null;
    }

    private Cita buscarCita(int idCliente, String fechaHora) {

        for (Cita c : citas) {
            if (c.getCliente().getId() == idCliente && c.getFechaHora().equals(fechaHora)) return c;
        }
        return null;
    }
}
