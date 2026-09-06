package main;
import model.*;
import model.interfaces.*;
import data.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

        public static void main(String[] args) {
            ControladorDeEnvios controlador = new ControladorDeEnvios();

            Pedido p1 = new PedidoComida(101, "Av. Providencia 1234", "Comida", 4.0, "", "Pendiente", "Dragón de Oro");
            Pedido p2 = new PedidoExpress(102, "Condell 789", "Express", 3.0, "", "Pendiente");
            Pedido p3 = new PedidoEncomienda(103, "Av. Santa Rosa 567", "Encomienda", 7.0, "", "Pendiente", 5.6, "Paquete", "Caja");
            Pedido p4 = new PedidoComida(104, "Ahumada 432", "Comida", 2.5, "", "Pendiente", "Sushi House");
            Pedido p5 = new PedidoExpress(105, "Alameda 900", "Express", 8.0, "", "Pendiente");
            Pedido p6 = new PedidoEncomienda(106, "Vitacura 1100", "Encomienda", 12.0, "", "Pendiente", 2.1, "Sobre", "Sobre Manila");

            Repartidor r1 = new Repartidor("Camila");
            Repartidor r2 = new Repartidor("Luis");
            Repartidor r3 = new Repartidor("Carlos");

            r1.agregarPedido(p1);
            r1.agregarPedido(p4);

            r2.agregarPedido(p2);
            r2.agregarPedido(p5);

            r3.agregarPedido(p3);
            r3.agregarPedido(p6);

            controlador.agregarAlHistorial(p1);
            controlador.agregarAlHistorial(p2);
            controlador.agregarAlHistorial(p3);
            controlador.agregarAlHistorial(p4);
            controlador.agregarAlHistorial(p5);
            controlador.agregarAlHistorial(p6);

            System.out.println("=== INICIANDO SIMULACIÓN DE ENTREGAS CONCURRENTES ===\n");

            ExecutorService executor = Executors.newFixedThreadPool(3);

            executor.execute(r1);
            executor.execute(r2);
            executor.execute(r3);

            executor.shutdown();

            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                System.err.println("La simulación fue interrumpida: " + e.getMessage());
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }

            System.out.println("\n=== TODAS LAS ENTREGAS HAN FINALIZADO ===");
            System.out.println("\n=== HISTORIAL DE ENVÍOS ===");
            controlador.verHistorial();
        }
}
