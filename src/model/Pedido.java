package model;

/**
 * Clase principal, que lega atributos y métodos a las subclases
 */

public abstract class Pedido {
    private int idPedido;
    private String direccionEntrega;
    private String tipoEntrega;
    private double distanciaKm;

    /**
     *
     * @param idPedido Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición
     * @param distanciaKm Distancia en km del punto de despacho al punto de entrega al cliente
     */

    public Pedido(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm) {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El ID del pedido debe ser un número positivo.");
        }
        if (direccionEntrega == null || direccionEntrega.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección de entrega no puede estar vacía.");
        }
        if (tipoEntrega == null || tipoEntrega.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de entrega no puede estar vacía.");
        }
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("La distancia del pedido debe ser un número positivo.");
        }
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoEntrega = tipoEntrega;
        this.distanciaKm = distanciaKm;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public void mostrarResumen(){
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Tiempo estimado de entrega: "+ calcularTiempoEntrega() + " minutos");
    }

    public abstract int calcularTiempoEntrega();

}
