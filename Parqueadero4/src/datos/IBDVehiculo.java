package datos;

import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public interface IBDVehiculo {

    public void adicionarVehiculo(Vehiculo v);

    public List<Vehiculo> listarTodos();

    public Vehiculo buscar(String placa);

    public void eliminar(String placa);

}
