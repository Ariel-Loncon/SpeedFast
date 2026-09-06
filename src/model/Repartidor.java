package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa a un repartidor que procesa pedidos
 */

public class Repartidor implements Runnable{
    private String nombreRep;
    private List<Pedido> pedidosAsignados;
    private Random random;

    /**
     *
      * @param nombreRep Nombre del repartidor asignado
     */
    public Repartidor(String nombreRep) {
        if (nombreRep == null || nombreRep.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor no puede estar vacío.");
        }
        this.nombreRep = nombreRep;
        this.pedidosAsignados = new ArrayList<>();
        this.random = new Random();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            pedido.asignarRepartidor(this.nombreRep);
            this.pedidosAsignados.add(pedido);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNombreRep() {
        return nombreRep;
    }

    public void setNombreRep(String nombreRep) {
        this.nombreRep = nombreRep;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    public void setPedidosAsignados(List<Pedido> pedidosAsignados) {
        this.pedidosAsignados = pedidosAsignados;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void run() {
        for (Pedido pedido : pedidosAsignados) {
            try {
                System.out.printf("[Repartidor: %s] Entregando %s #%d...%n",
                        nombreRep, pedido.getClass().getSimpleName(), pedido.getIdPedido());

                int tiempoSimuladoMs = 1000 + random.nextInt(2000);
                Thread.sleep(tiempoSimuladoMs);

                pedido.despachar();
                System.out.printf("[Repartidor: %s] Pedido #%d entregado.%n", nombreRep, pedido.getIdPedido());

            } catch (InterruptedException e) {
                System.err.printf("[Repartidor: %s] La entrega del pedido #%d fue interrumpida: %s%n",
                        nombreRep, pedido.getIdPedido(), e.getMessage());
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                System.err.printf("[Repartidor: %s] Error inesperado en el pedido #%d: %s%n",
                        nombreRep, pedido.getIdPedido(), e.getMessage());
            }
        }
    }


}
