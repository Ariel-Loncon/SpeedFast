package Model;

/**
 * SubClase de Pedido encargada de gestionar los pedidos de Encomienda
 */

public class PedidoEncomienda extends Pedido{

    private int peso;
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

    public PedidoEncomienda(int id, String direccionEntrega, String tipoEntrega, int peso, String tipoEncomienda, String embalaje) {
        super(id, direccionEntrega, tipoEntrega);
        this.peso = peso;
        this.tipoEncomienda = tipoEncomienda;
        this.embalaje = embalaje;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
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

    @Override
    public String toString() {
        return "PedidoEncomienda{" +
                "peso=" + peso +
                ", tipoEncomienda='" + tipoEncomienda + '\'' +
                ", embalaje='" + embalaje + '\'' +
                '}';
    }
}
