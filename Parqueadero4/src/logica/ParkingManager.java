package logica;


import datos.IBDRegistroParking;
import datos.ListRegistroParking;
import dominio.IFacturable;
import dominio.RegistroParking;
import dominio.Ticket;
import dominio.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ParkingManager {

    private static int ticket = 0;
    private IBDRegistroParking bdParking;

    public ParkingManager() {
        this.bdParking = new ListRegistroParking();
    }

    public void registroIngreso(IFacturable vehiculo) {
        RegistroParking registro = new RegistroParking(vehiculo);
        registro.setId(this.bdParking.size() + 1);
        this.bdParking.registrarIngreso(registro);
    }

    public Ticket registrarSalida(String placa) {
        RegistroParking registro = this.bdParking.registrarSalida(placa);
        registro.sethFinal(LocalDateTime.now());
        this.duracionHoras(registro);
        this.facturarCostoParqueo(registro);
        registro.setActivo(false);
        return this.generarTicket(registro);
    }

    public void printRegistro() {
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.printf("%-5s %-22s %-22s %-10s %-10s %-12s %-8s%n",
                "ID", "Hora Entrada", "Hora Salida", "Duracion", "Placa", "Costo Total", "Activo");
        System.out.println("--------------------------------------------------------------------------------------");

        for (RegistroParking r : this.bdParking.listAll()) {
            System.out.printf("%-5d %-22s %-22s %-10.2f %-10s %-12.2f %-8s%n",
                    r.getId(),
                    format.format(r.gethInicio()),
                    (r.gethFinal() != null ? format.format(r.gethFinal()) : "En curso"),
                    r.getDuracion(),
                    r.getVehiuclo().getPlaca(),
                    r.getCostoTotal(),
                    r.isActivo());
        }
    }

    public Ticket generarTicket(RegistroParking registro) {
        return this.generarTicket(registro.gethInicio(), registro.gethFinal(), registro.getVehiuclo());
    }

    public Ticket generarTicket(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo) {
        double costo = this.facturarCostoParqueo(hEntrada, hSalida, vehiculo);
        Ticket ticket = new Ticket();
        ticket.sethInicio(hEntrada.toString());
        ticket.sethFinal(hSalida.toString());
        ticket.setDuracion(String.valueOf(this.duracionHoras(hEntrada, hSalida)));
        ticket.setPlaca(((Vehiculo) vehiculo).getPlaca());
        ticket.setTipo(vehiculo.getType());
        ticket.setTarifa(String.valueOf(vehiculo.getTarifa()));
        ticket.setRecrago(String.valueOf(vehiculo.getRecargo()));
        ticket.setCostoTotal(String.valueOf(costo));
        return ticket;
    }

    public void facturarCostoParqueo(RegistroParking registro) {
        double costo = this.facturarCostoParqueo(registro.gethInicio(), registro.gethFinal(), registro.getVehiuclo());
        registro.setCostoTotal(costo);
    }

    public double facturarCostoParqueo(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo) {
        return this.duracionHoras(hEntrada, hSalida) * vehiculo.getTarifa() + vehiculo.getRecargo();
    }

    public void duracionHoras(RegistroParking registro) {
        double duracion = this.duracionHoras(registro.gethInicio(), registro.gethFinal());
        registro.setDuracion(duracion);
    }

    public double duracionHoras(LocalDateTime hEntrada, LocalDateTime hSalida) {
        Duration duracion = Duration.between(hEntrada, hSalida);
        long segundos = duracion.toSeconds();
        return segundos;
    }

    public void imprimirTicket(Ticket ticket) {
        ParkingManager.ticket++;
        System.out.println("No Ticket: " + ParkingManager.ticket + "\n"
                + "Hora Inicio: " + ticket.gethInicio() + "\n"
                + "Hora salida: " + ticket.gethFinal() + "\n"
                + "Duracion (segundos): " + ticket.getDuracion() + "\n"
                + "Vehiculo: " + ticket.getTipo() + "\n"
                + "Placa: " + ticket.getPlaca() + "\n"
                + "Recargo: " + ticket.getRecargo() + "\n"
                + "Costo total: " + ticket.getCostoTotal() + "\n"
                + "---------------------------\n");
    }
}
