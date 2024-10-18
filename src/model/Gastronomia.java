/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author gonza
 */
public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;
    private Map<LocalDate, Boolean> disponibilidad;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc, Map<LocalDate, Boolean> disponibilidad) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
        this.disponibilidad = new HashMap<>();
    }
    @Override
    public Map<LocalDate, Boolean> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(LocalDate dia, boolean disponible) {
        this.disponibilidad.put(dia, disponible);
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precio;

        if (this.isEnPromocion() && dia.getDayOfWeek().getValue() == this.diaSemDesc) {
            precioFinal -= precioFinal * (getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }
}
