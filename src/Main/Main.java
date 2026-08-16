package Main;
import Model.*;

public class Main {

    public static void main(String[] args) {
            Pedido p1 = new PedidoComida(1,"Av. Providencia 1234","Pedido Comida","Dragón de oro");
            Pedido p2 = new PedidoEncomienda(2, "Huérfanos 432","Pedido Encomienda",5,"Paquete grande","Caja");
            Pedido p3 = new PedidoExpress(3, "Condel 789","Pedido Express");

            p1.asignarRepartidor("Juan Pérez");
            System.out.println();

            p2.asignarRepartidor("Camila Soto");
            System.out.println();

            p3.asignarRepartidor("Luis Díaz");
    }
}