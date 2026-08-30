package model;

/**
 * SubClase de Pedido encargada de gestionar los pedidos de Encomienda
 */

public class PedidoEncomienda extends Pedido{

    private double peso;
    private String tipoEncomienda;
    private String embalaje;



    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param idPedido Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara la encomienda
     * @param tipoEntrega se asigna un tipo de entrega a disposición en este caso "Encomienda"
     * @param distanciaKm Distancia en km del punto de despacho al punto de entrega al cliente
     * @param repartidor Nombre del repartidor asignado
     * @param estado Estado del pedido Despachado o Cancelado
     * @param peso Peso de la encomienda
     * @param tipoEncomienda Tipo de encomienda, sobres o paquetes
     * @param embalaje Tipo de embalaje que se seleccionara según tipo de encomienda
     */

    public PedidoEncomienda(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm, String repartidor, String estado, double peso, String tipoEncomienda, String embalaje) {
        super(idPedido, direccionEntrega, tipoEntrega, distanciaKm, repartidor, estado);
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso del pedido debe ser un número positivo.");
        }
        if (tipoEncomienda == null || tipoEncomienda.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de encomienda no puede estar vacío.");
        }
        if (embalaje == null || embalaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El embalaje de la encomienda no puede estar vacío.");
        }
        this.peso = peso;
        this.tipoEncomienda = tipoEncomienda;
        this.embalaje = embalaje;
    }

    //////////////////////////////////////////////////////////////

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(String tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    //////////////////////////////////////////////////////////////

    @Override
    public void mostrarResumen(){
        System.out.printf("[Pedido Encomienda]"+ "\n" +
                           "Pedido #%03d%n", getIdPedido());
        super.mostrarResumen();
    }

    public int calcularTiempoEntrega(){
        return (int)(20+(1.5*getDistanciaKm()));
    }

    @Override
    public void asignarRepartidor() {
        setRepartidor("Repartidor Encomiendas ");
    }

}
