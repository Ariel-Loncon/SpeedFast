package main;
import model.*;
import model.interfaces.*;
import data.*;

public class Main {

    public static void main(String[] args) {
        controladorDeEnvios controlador = new controladorDeEnvios();
        Pedido[] pedidos = new Pedido[3];

        try {
            pedidos[0] = new PedidoComida(101, "Av. Providencia 1234", "Comida", 4.0, " ", "Despachado", "Dragón de Oro");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido de Comida: " + e.getMessage());
        }
        try {
            pedidos[1] = new PedidoEncomienda(102, "Av. Santa Rosa 567", "Encomienda", 7.0, " ", "Despachado", 5.6, "Paquete grande", "Caja");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido de Encomienda: " + e.getMessage());
        }
        try {
            pedidos[2] = new PedidoExpress(103, "Condell 789", "Express", 15.0, " ", "Cancelado");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido Express: " + e.getMessage());
        }


        pedidos[0].asignarRepartidor("Luis Díaz");
        pedidos[1].asignarRepartidor("Daniela Tapia");
        pedidos[2].asignarRepartidor();


        for (Pedido p : pedidos) {
            if (p != null) {
                try {

                    if ("Cancelado".equalsIgnoreCase(p.getEstado())) {
                        System.out.println("Cancelando Pedido Express #" + p.getIdPedido() + "...");
                        p.cancelar();
                    } else if ("Despachado".equalsIgnoreCase(p.getEstado())) {
                        p.mostrarResumen();
                        p.despachar();
                    } else {
                        System.out.println("El pedido #" + p.getIdPedido() + " se encuentra en estado: " + p.getEstado());
                    }
                    controlador.agregarAlHistorial(p);
                    System.out.println();



                } catch (Exception e) {
                    System.out.println("Error al procesar el pedido #" + p.getIdPedido() + ": " + e.getMessage());
                }
            }
        }
        controlador.verHistorial();
    }
}
