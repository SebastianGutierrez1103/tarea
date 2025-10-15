/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.IFacturable;
import dominio.Ticket;
import dominio.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Jairo F
 */
public class ParkingManager {
    
    private static int ticket=0;
    
    
    
    public Ticket generarTicket(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo){
        
        double costo = this.facturarCostoParqueo(hEntrada, hSalida, vehiculo);
        
        Ticket ticket = new Ticket();
        ticket.sethInicio(hEntrada.toString());
        ticket.sethFinal(hSalida.toString());
        ticket.setDuracion(String.valueOf(this.duracionHoras(hEntrada, hSalida)));
        ticket.setPlaca(((Vehiculo)vehiculo).getPlaca());
        ticket.setTipo(vehiculo.getType());
        ticket.setTarifa(String.valueOf(vehiculo.getTarifa()));
        ticket.setRecrago(String.valueOf(vehiculo.getRecargo()));
        ticket.setCostoTotal(String.valueOf(costo));
        
        return ticket;
    }
    
    public double facturarCostoParqueo(LocalDateTime hEntrada, LocalDateTime hSalida, IFacturable vehiculo) {
        return this.duracionHoras(hEntrada, hSalida) * vehiculo.getTarifa() + vehiculo.getRecargo();
    }
    
    public long duracionHoras(LocalDateTime hEntrada, LocalDateTime hSalida){
        Duration duracion = Duration.between(hEntrada, hSalida);
        long horas = duracion.toHours();
        return horas;
    }
    
    public void imprimirTicket(Ticket ticket){
        ParkingManager.ticket ++;
        
        System.out.println( "No Ticket: " + ParkingManager.ticket + "\n"+
                       "Hora Inicio: " + ticket.gethInicio() + "\n" +
                       "Hora salida: " + ticket.gethFinal()  + "\n" +
                       "Horas Facturadas: " + ticket.getDuracion() + "\n" +
                       "Vehiculo: " + ticket.getTipo() + "\n" +
                       "Placa: " + ticket.getPlaca() + "\n" +
                       "Recargo: " + ticket.getRecargo() + "\n" +
                       "Costo total: " + ticket.getCostoTotal() +"\n" +
                       "---------------------------\n"
        );
        
    
    }
    
    
}
