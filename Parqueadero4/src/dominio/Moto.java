package dominio;

public class Moto extends Vehiculo {

    private String marca;
    private int cilindraje;

    public Moto(String placa, String marca, int cilindraje) {
        super(placa);
        this.marca = marca;
        this.cilindraje = cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString() + ", marca=" + marca + ", cilindraje=" + cilindraje + '}';
    }

    @Override
    public String getType() {
        return "Moto";
    }

    @Override
    public double getRecargo() {

        return (this.cilindraje > 500) ? 500 : 0;

    }

    @Override
    public double getTarifa() {
        return 1000;
    }

}
