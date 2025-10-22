package dominio;

public class Ticket {

    private static int id = 0;
    private String idTicket;
    private String hInicio;
    private String hFinal;
    private String duracion;
    private String placa;
    private String tipo;
    private String tarifa;
    private String recargo;
    private String costoTotal;

    public Ticket() {
        Ticket.id++;
        this.idTicket = String.valueOf(Ticket.id);
    }

    public Ticket(String hInicio, String hFinal, String duracion, String placa, String tipo, String tarifa, String recargo, String costoTotal) {
        this();
        this.hInicio = hInicio;
        this.hFinal = hFinal;
        this.duracion = duracion;
        this.placa = placa;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.recargo = recargo;
        this.costoTotal = costoTotal;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String gethInicio() {
        return hInicio;
    }

    public void sethInicio(String hInicio) {
        this.hInicio = hInicio;
    }

    public String gethFinal() {
        return hFinal;
    }

    public void sethFinal(String hFinal) {
        this.hFinal = hFinal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getRecargo() {
        return recargo;
    }

    public void setRecrago(String recargo) {
        this.recargo = recargo;
    }

    public String getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(String costoTotal) {
        this.costoTotal = costoTotal;
    }

}
