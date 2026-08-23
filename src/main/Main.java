package main;
import model.*;

public class Main {

    public static void main(String[] args) {
        Pedido[] pedidos = new Pedido[3];

        try {
            pedidos[0] = new PedidoComida(1, "Av. Providencia 1234", "Pedido Comida", 4.0, "Dragón de Oro");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido de Comida: " + e.getMessage());
        }
        try {
            pedidos[1] = new PedidoEncomienda(2, "Huérfanos 432", "Pedido Encomienda", 6.0, 5.6, "Paquete grande", "Caja");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido de Encomienda: " + e.getMessage());
        }
        try {
            pedidos[2] = new PedidoExpress(3, "Condel 789", "Pedido Express", 15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear pedido Express: " + e.getMessage());
        }

        for (Pedido p : pedidos) {
            if (p != null) {
                try {
                    p.mostrarResumen();
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Error al procesar el pedido #" + p.getIdPedido() + ": " + e.getMessage());
                }
            }
        }
    }
}

