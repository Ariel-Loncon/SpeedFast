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
     */

    public PedidoExpress(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, tipoEntrega, distanciaKm);
    }

    ////////////////////////////////////////////////////////////////////////////////

    @Override
    public void mostrarResumen(){
        System.out.printf("Pedido Express #%03d%n", getIdPedido());
        super.mostrarResumen();
    }

    @Override
    public int calcularTiempoEntrega() {
        int base = 10;
        int tiempoExtra = (int) (getDistanciaKm() / 5); // División entera
        return base + (tiempoExtra * 5);
    }
}
