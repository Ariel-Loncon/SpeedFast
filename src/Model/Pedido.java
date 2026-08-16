package Model;

/**
 * Clase principal, que lega atributos y métodos a las subclases
 */

public class Pedido {
    private int id;
    private String direccionEntrega;
    private String tipoEntrega;

    /**
     *
     * @param id Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición
     */

    public Pedido(int id, String direccionEntrega, String tipoEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.tipoEntrega = tipoEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void asignarRepartidor(){
        System.out.println("|" + tipoEntrega + "|");
        System.out.println("Asignado repartidor");
    }

    public void asignarRepartidor(String nombreRepartidor){
        asignarRepartidor();
        System.out.println("Pedido asignado a: "+ nombreRepartidor);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", tipoEntrega='" + tipoEntrega + '\'' +
                '}';
    }
}
