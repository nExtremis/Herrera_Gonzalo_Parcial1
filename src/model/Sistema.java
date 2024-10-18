/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gonza
 */
public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio) {
        Servicio servicioEncontrado = null;
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicioEncontrado;
            }
        }
        return servicioEncontrado;

    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromo = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromo.add(servicio);
            }
        }
        return serviciosEnPromo;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEncontrados = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion && servicio.getDisponibilidad().getOrDefault(dia, false)) {
                serviciosEncontrados.add(servicio);
            }
        }
        return serviciosEncontrados;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc, Map<LocalDate, Boolean> disponibilidad) {
        if (traerServicio(codServicio)!= null){
            throw new IllegalArgumentException("El servicio con este código ya existe.");
        }
        Gastronomia nuevoGastronomia = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc, disponibilidad);
        return lstServicio.add(nuevoGastronomia);
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche, Map<LocalDate, Boolean> disponibilidad) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con este código ya existe.");
        }
        Hospedaje nuevoHospedaje = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche, disponibilidad);
        
        return lstServicio.add(nuevoHospedaje);
    }
}
