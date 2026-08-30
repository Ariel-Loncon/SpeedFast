package data;
import model.*;
import model.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class controladorDeEnvios implements rastreable {
    private List<Pedido> historial;

    public controladorDeEnvios() {
        this.historial = new ArrayList<>();
    }

    public void agregarAlHistorial(Pedido p) {
        historial.add(p);
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial:");
        for (Pedido p : historial) {
            try {
                if ("Cancelado".equalsIgnoreCase(p.getEstado())) {
                    System.out.println("- " + p.getClass().getSimpleName() + " #" + p.getIdPedido() +  " (" + p.getEstado() + ")" );

                } else if ("Despachado".equalsIgnoreCase(p.getEstado())) {
                    System.out.println("- " + p.getClass().getSimpleName() + " #" + p.getIdPedido()
                            + " (" + p.getEstado() + ") - entregado/gestionado por " + p.getRepartidor());
                }
                }catch (Exception e) {
                System.out.println("Error al procesar el pedido #" + p.getIdPedido() + ": " + e.getMessage());
            }

        }
    }
}
