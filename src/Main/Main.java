package Main;
import Model.*;

public class Main {

    public static void main(String[] args) {
        try {
            Pedido p1 = new PedidoComida(1, "Av. Providencia 1234", "Pedido Comida", "Dragón de oro");
            p1.asignarRepartidor("Juan Pérez");
            System.out.println();
        }catch (IllegalArgumentException e) {
            System.out.println("Error al procesar pedido de Comida: " + e.getMessage());
        }
        try{
            Pedido p2 = new PedidoEncomienda(2, "Huérfanos 432", "Pedido Encomienda", 5.6, "Paquete grande", "Caja");
            p2.asignarRepartidor("Camila Soto");
            System.out.println();
        }catch (IllegalArgumentException e) {
            System.out.println("Error al procesar pedido de Encomienda: " + e.getMessage());
        }
        try{
            Pedido p3 = new PedidoExpress(3, "Condel 789", "Pedido Express");
            p3.asignarRepartidor("Luis Díaz");
        }catch (IllegalArgumentException e) {
            System.out.println("Error al procesar pedido Express: " + e.getMessage());
        }
    }
}