package dominio;

public class Bicicleta extends Vehiculo {

    private String tipo;
    private boolean tieneCambios;

    public Bicicleta(String placa, String tipo, boolean tieneCambios) {
        super(placa);
        this.tipo = tipo;
        this.tieneCambios = tieneCambios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneCambios() {
        return tieneCambios;
    }

    public void setTieneCambios(boolean tieneCambios) {
        this.tieneCambios = tieneCambios;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + super.toString() + ", tipo=" + tipo + ", tieneCambios=" + tieneCambios + '}';
    }

    @Override
    public String getType() {
        return "Bicicleta";
    }

    @Override
    public double getRecargo() {
        return 0;
    }

    @Override
    public double getTarifa() {
        return 300;
    }

}
