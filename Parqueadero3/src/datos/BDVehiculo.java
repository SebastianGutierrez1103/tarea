/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Jairo F
 */
public class BDVehiculo implements IBDVehiculo {
    
    private ArrayList<Vehiculo> registro;

    public BDVehiculo() {
        
        this.registro = new ArrayList();
        
    }
    
       
    @Override
    public ArrayList<Vehiculo> listarTodos(){
        
        return new ArrayList(this.registro);
        
    }
    
    @Override
    public Vehiculo buscar(String placa){
        
        for(Vehiculo v: this.registro){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        
        return null;
    }

    @Override
    public void adicionarVehiculo(Vehiculo v) {
        this.registro.add(v);
    }
    
    
    
}
