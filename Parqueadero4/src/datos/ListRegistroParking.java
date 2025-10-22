package datos;

import dominio.RegistroParking;
import java.util.ArrayList;
import java.util.List;

public class ListRegistroParking implements IBDRegistroParking {

    private List<RegistroParking> db;

    public ListRegistroParking() {
        this.db = new ArrayList();

    }

    @Override
    public void registrarIngreso(RegistroParking registro) {
        this.db.add(registro);
    }

    @Override
    public RegistroParking registrarSalida(String placa) {

        for (RegistroParking r : this.db) {
            if (r.isActivo() && r.getVehiuclo().getPlaca().equals(placa)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.db.size();
    }

    @Override
    public List<RegistroParking> listAll() {
        return new ArrayList(this.db);
    }

}
