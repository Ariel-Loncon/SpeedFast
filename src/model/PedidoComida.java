package model;

/**
 * SubClase de Pedido encargada de gestionar los pedidos de Comida
 */

public class PedidoComida extends Pedido{
    private String nombreRestaurante;


    //////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param idPedido Número identificador del pedido
     * @param direccionEntrega Dirección del restaurante del cual se entregara el pedido
     * @param tipoEntrega Se asigna un tipo de entrega a disposición en este caso "Comida"
     * @param distanciaKm Distancia en km del punto de despacho al punto de entrega al restaurante
     * @param repartidor Nombre del repartidor asignado
     * @param estado Estado del pedido Despachado o Cancelado
     * @param nombreRestaurante Nombre del restaurante del cual se despachara el pedido
     */

    public PedidoComida(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm, String repartidor, String estado, String nombreRestaurante) {
        super(idPedido, direccionEntrega, tipoEntrega, distanciaKm, repartidor, estado);
        if (nombreRestaurante == null || nombreRestaurante.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del restaurante no puede estar vacío.");
        }
        this.nombreRestaurante = nombreRestaurante;
    }

    ///////////////////////////////////////////////////////////////////////

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    ////////////////////////////////////////////////////////////////////////

    @Override
    public void mostrarResumen(){
        System.out.printf("[Pedido Comida]"+ "\n" +
                "Pedido #%03d%n", getIdPedido());
        super.mostrarResumen();
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int)(15 + (2 * getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        setRepartidor("Repartidor Comida");
    }


}
