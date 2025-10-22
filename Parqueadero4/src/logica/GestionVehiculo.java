package logica;


import datos.*;
import dominio.*;
import java.util.List;

public class GestionVehiculo {

    private IBDVehiculo bd;

    public GestionVehiculo() {
        this.bd = new MapVehiculo();
        
    }

    public void adicionarVehiculo(Vehiculo v) {
        this.bd.adicionarVehiculo(v);
    }

    public List<Vehiculo> listarTodos() {
        return this.bd.listarTodos();
    }

    public Vehiculo buscar(String placa) {
        return this.bd.buscar(placa);
    }

    public void eliminar(String placa) {
        this.bd.eliminar(placa);
    }

    public List<Vehiculo> getListaVehiculos() {
        return this.bd.listarTodos();
    }

}