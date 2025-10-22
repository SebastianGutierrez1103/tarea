package datos;

import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListVehiculo implements IBDVehiculo {

    private List<Vehiculo> registro;

    public ListVehiculo() {

        this.registro = new ArrayList();

    }

    @Override
    public List<Vehiculo> listarTodos() {

        return new ArrayList(this.registro);

    }

    @Override
    public Vehiculo buscar(String placa) {

        for (Vehiculo v : this.registro) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }

        return null;
    }

    @Override
    public void adicionarVehiculo(Vehiculo v) {
        this.registro.add(v);
    }

    @Override
    public void eliminar(String placa) {

        Vehiculo v = this.buscar(placa);
        if (v != null) {
            this.registro.remove(v);
        }

    }

}
