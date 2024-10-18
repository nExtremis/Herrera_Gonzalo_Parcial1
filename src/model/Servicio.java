/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Map;
/**
 *
 * @author gonza
 */
public abstract class Servicio {

    private String codServicio;
    private double porcentajeDescuento;
    private boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        //falta la exepcion aca
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        
        
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }
    
    public abstract double calcularPrecioFinal(LocalDate dia);
    public abstract Map<LocalDate, Boolean> getDisponibilidad();
    
}
