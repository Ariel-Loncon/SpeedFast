package model;

/**
 * SubClase de Pedido encargado de gestionar los pedidos Express
 */

public class PedidoExpress extends Pedido{

    /**
     *
     * @param idPedido Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición en este caso "Express"
     * @param distanciaKm Distancia en km del punto de despacho al punto de entrega al cliente
     * @param repartidor Nombre del repartidor asignado
     * @param estado Estado del pedido Despachado o Cancelado
     */

    public PedidoExpress(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm, String repartidor, String estado) {
        super(idPedido, direccionEntrega, tipoEntrega, distanciaKm, repartidor, estado);
    }

    ////////////////////////////////////////////////////////////////////////////////

    @Override
    public void mostrarResumen(){
        System.out.printf("[Pedido Express]"+ "\n" +
                            "Pedido #%03d%n", getIdPedido());
        super.mostrarResumen();
    }

    @Override
    public int calcularTiempoEntrega() {
        return getDistanciaKm() > 5 ? 15 : 10;
    }

    @Override
    public void asignarRepartidor() {
        setRepartidor("Repartidor Express");
    }
}
