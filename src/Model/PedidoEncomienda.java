package Model;

/**
 * SubClase de Pedido encargada de gestionar los pedidos de Encomienda
 */

public class PedidoEncomienda extends Pedido{

    private double peso;
    private String tipoEncomienda;
    private String embalaje;

    /**
     *
     * @param id Número identificador del pedido
     * @param direccionEntrega Dirección del cliente al cual se le entregara la encomienda
     * @param tipoEntrega se asigna un tipo de entrega a disposición en este caso "Encomienda"
     * @param peso Peso de la encomienda
     * @param tipoEncomienda Tipo de encomienda, sobres o paquetes
     * @param embalaje Tipo de embalaje que se seleccionara según tipo de encomienda
     */

    public PedidoEncomienda(int id, String direccionEntrega, String tipoEntrega, double peso, String tipoEncomienda, String embalaje) {
        super(id, direccionEntrega, tipoEntrega);

        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0.0 kg.");
        }
        if (tipoEncomienda == null || tipoEncomienda.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de encomienda no puede estar vacía.");
        }
        if (embalaje == null || embalaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El embalaje no puede estar vacía.");
        }

        this.peso = peso;
        this.tipoEncomienda = tipoEncomienda;
        this.embalaje = embalaje;
    }

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

    @Override
    public void asignarRepartidor() {
        super.asignarRepartidor();
        System.out.println("Validando peso y embalaje... OK");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor();
        System.out.println("→ Dirección: "+ getDireccionEntrega() + "\n" +
                           "→ Tipo de encomienda: "+ tipoEncomienda);
        System.out.println("→ Validando peso y embalaje... OK");
        System.out.println("→ Pedido asignado a: " + nombreRepartidor);
    }

}
