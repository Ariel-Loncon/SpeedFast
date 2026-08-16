package Model;

/**
 * SubClase de Pedido encargado de gestionar los pedidos Express
 */

public class PedidoExpress extends Pedido{

    /**
     *
     * @param id Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición en este caso "Express"
     */

    public PedidoExpress(int id, String direccionEntrega, String tipoEntrega) {
        super(id, direccionEntrega, tipoEntrega);
    }

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata encontrado.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor();
        System.out.println("→ Repartidor más cercano con disponibilidad inmediata encontrado.");
        System.out.println("→ Pedido asignado a " + nombreRepartidor);
    }
}
