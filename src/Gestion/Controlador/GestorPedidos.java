package Gestion.Controlador;

import Gestion.Modelo.ModeloPedido;
import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {
    private List<ModeloPedido> listaPedidos;
    
    public GestorPedidos() {
        this.listaPedidos = new ArrayList<>();
    }
}
