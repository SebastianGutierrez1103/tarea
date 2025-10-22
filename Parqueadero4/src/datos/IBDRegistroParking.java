package datos;

import dominio.RegistroParking;
import java.util.List;

public interface IBDRegistroParking {

    public void registrarIngreso(RegistroParking registro);

    public RegistroParking registrarSalida(String placa);

    public int size();

    public List<RegistroParking> listAll();

}
