/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author gonza
 */
public class Hospedaje extends Servicio{
    private String hospedaje;
    private double precioPorNoche;
    private Map<LocalDate, Boolean> disponibilidad;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche, Map<LocalDate, Boolean> disponibilidad) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
        this.disponibilidad = new HashMap<>();
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    @Override
    public Map<LocalDate, Boolean> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(LocalDate dia, boolean disponible) {
        this.disponibilidad.put(dia, disponible);
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia){
        double precioFinal = this.precioPorNoche;
        
        if (this.isEnPromocion() && dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY){
            precioFinal -= precioFinal * (getPorcentajeDescuento() /100);
        }
        return precioFinal;
    }
}
