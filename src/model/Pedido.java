package model;
import model.interfaces.*;

/**
 * Clase principal, que lega atributos y métodos a las subclases
 */

public abstract class Pedido implements despachable, cancelable{
    private int idPedido;
    private String direccionEntrega;
    private String tipoEntrega;
    private double distanciaKm;
    private String repartidor;
    private String estado;

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param idPedido Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición
     * @param distanciaKm Distancia en km del punto de despacho al punto de entrega al cliente
     * @param repartidor Nombre del repartidor asignado
     * @param estado Estado del pedido Despachado o Cancelado
     */

    public Pedido(int idPedido, String direccionEntrega, String tipoEntrega, double distanciaKm, String repartidor, String estado) {
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
        this.repartidor = repartidor;
        this.estado = estado;
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

    public String getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public void mostrarResumen(){
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor asignado:" + repartidor);
        System.out.println("Tiempo estimado de entrega: "+ calcularTiempoEntrega() + " minutos");
    }

    public abstract int calcularTiempoEntrega();

    public abstract void asignarRepartidor();

    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
    }

    @Override
    public void despachar() {
        this.estado = "Despachado";
        System.out.println("Pedido despachado correctamente.");
    }
    @Override
    public void cancelar() {
        this.estado = "Cancelado";
        System.out.println("→ Pedido cancelado exitosamente.");
    }

}
