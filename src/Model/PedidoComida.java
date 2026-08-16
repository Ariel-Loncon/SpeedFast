package Model;

/**
 * SubClase de Pedido encargada de gestionar los pedidos de Comida
 */

public class PedidoComida extends Pedido{
    private String nombreRestaurante;

    /**
     *
     * @param id Número identificador del pedido
     * @param direccionEntrega Dirección del restaurante del cual se entregara el pedido
     * @param tipoEntrega se asigna un tipo de entrega a disposición en este caso "Comida"
     * @param nombreRestaurante Nombre del restaurante del cual se despachara el pedido
     */

    public PedidoComida(int id, String direccionEntrega, String tipoEntrega, String nombreRestaurante) {
        super(id, direccionEntrega, tipoEntrega);

        if (nombreRestaurante == null || nombreRestaurante.trim().isEmpty()) {
            throw new IllegalArgumentException("El Nombre del restaurante no puede estar vacía.");
        }
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    @Override
    public void asignarRepartidor(){
        super.asignarRepartidor();
        System.out.println(" Con mochila térmica");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor){
        super.asignarRepartidor();
        System.out.println("→ Dirección: "+ getDireccionEntrega() + "\n" +
                           "→ Nombre restaurante: " + nombreRestaurante);
        System.out.println("→ Verificando mochila térmica... OK");
        System.out.println("→ Pedido asignado a: " + nombreRepartidor);
    }
}
