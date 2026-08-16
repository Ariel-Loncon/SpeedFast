package Main;
import Model.*;

public class Main {

    public static void main(String[] args) {
            Pedido p1 = new PedidoComida(1,"Av. Providencia 1234","Comida","Dragón de oro");
            Pedido p2 = new PedidoEncomienda(2, "Calle Los Leones 432","Encomienda",5,"Paquete grande","Caja");
            Pedido p3 = new PedidoExpress(3, "Alameda 789","Express");

            p1.asignarRepartidor("Juan Pérez");
            System.out.println();

            p2.asignarRepartidor("Camila Soto");
            System.out.println();

            p3.asignarRepartidor("Luis Díaz");
    }
}