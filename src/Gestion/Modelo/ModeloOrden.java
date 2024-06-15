    package Gestion.Modelo;

    import java.util.ArrayList;
    import java.util.List;

    public class ModeloOrden {
        private int numeroOrden;
        private int mesaId;
        private List<ModeloPedido> pedidos;
        private String estado; // Estado de la orden (en preparación, sin preparar, listo, entregado)
        private boolean cancelado; // Indica si la orden está cancelada
        private boolean terminado; // Indica si la orden está terminada

        // Constructor
        
        public ModeloOrden(int numeroOrden, String estado) {
            this.numeroOrden = numeroOrden;
            this.mesaId = -1;
            this.pedidos = new ArrayList<>();
            this.estado = estado;
            this.cancelado = false;
            this.terminado = false;
        }
        
        public ModeloOrden(int numeroOrden, int mesaId, String estado) {
            this.numeroOrden = numeroOrden;
            this.mesaId = mesaId;
            this.pedidos = new ArrayList<>();
            this.estado = estado;
            this.cancelado = false;
            this.terminado = false;
        }

        // Getters y setters
        public int getNumeroOrden() {
            return numeroOrden;
        }

        public void setNumeroOrden(int numeroOrden) {
            this.numeroOrden = numeroOrden;
        }

        public int getMesaId() {
            return mesaId;
        }

        public void setMesaId(int mesaId) {
            this.mesaId = mesaId;
        }

        public List<ModeloPedido> getPedidos() {
            return pedidos;
        }

        public void setPedidos(List<ModeloPedido> pedidos) {
            this.pedidos = pedidos;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public boolean isCancelado() {
            return cancelado;
        }

        public void setCancelado(boolean cancelado) {
            this.cancelado = cancelado;
        }

        public boolean isTerminado() {
            return terminado;
        }

        public void setTerminado(boolean terminado) {
            this.terminado = terminado;
        }

        // Método para agregar un pedido a la orden
        public void agregarPedido(ModeloPedido pedido) {
            pedidos.add(pedido);
        }

        // Método toString para representación textual de la orden
        @Override
        public String toString() {
            return "ModeloOrden{" +
                    "numeroOrden=" + numeroOrden +
                    ", mesaId=" + mesaId +
                    ", pedidos=" + pedidos +
                    ", estado='" + estado + '\'' +
                    ", cancelado=" + cancelado +
                    ", terminado=" + terminado +
                    '}';
        }
    }