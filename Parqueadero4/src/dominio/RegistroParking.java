package dominio;

import java.time.LocalDateTime;

public class RegistroParking {

    private int id;
    private LocalDateTime hInicio;
    private LocalDateTime hFinal;
    private double duracion;
    private IFacturable vehiuclo;
    private double costoTotal;
    private boolean activo;

    public RegistroParking(IFacturable vehiuclo) {
        this.hInicio = LocalDateTime.now();
        this.vehiuclo = vehiuclo;
        this.activo = true;
    }

    public RegistroParking() {
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public LocalDateTime gethInicio() {
        return hInicio;
    }

    
    public void sethInicio(LocalDateTime hInicio) {
        this.hInicio = hInicio;
    }

    public LocalDateTime gethFinal() {
        return hFinal;
    }

    public void sethFinal(LocalDateTime hFinal) {
        this.hFinal = hFinal;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public IFacturable getVehiuclo() {
        return vehiuclo;
    }

    public void setVehiuclo(IFacturable vehiuclo) {
        this.vehiuclo = vehiuclo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
