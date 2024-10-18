/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herrera_gonzalo_parcial1;

import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Servicio> servicios = new ArrayList<>();
        Sistema sistema = new Sistema(servicios);
        Map<LocalDate, Boolean> disponibilidad2_1 = new HashMap<>();
        disponibilidad2_1.put(LocalDate.of(2020, 10, 28), true);
        disponibilidad2_1.put(LocalDate.of(2020, 10, 29), true);
        disponibilidad2_1.put(LocalDate.of(2020, 10, 30), false);
        System.out.println("1-1");
        try {
            Map<LocalDate, Boolean> disponibilidadGastronomia1 = new HashMap<>();
            disponibilidadGastronomia1.put(LocalDate.of(2020, 10, 28), true);
            disponibilidadGastronomia1.put(LocalDate.of(2020, 10, 29), true);
            disponibilidadGastronomia1.put(LocalDate.of(2020, 10, 30), false);
            Gastronomia Gastronomia1 = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4, disponibilidadGastronomia1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("1-2");
        try {
            Map<LocalDate, Boolean> disponibilidadGastronomia2 = new HashMap<>();
            disponibilidadGastronomia2.put(LocalDate.of(2020, 10, 28), true);
            disponibilidadGastronomia2.put(LocalDate.of(2020, 10, 29), false);
            disponibilidadGastronomia2.put(LocalDate.of(2020, 10, 30), true);
            Gastronomia Gastronomia2 = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4, disponibilidadGastronomia2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("1-3");
        try {
            Map<LocalDate, Boolean> disponibilidad3 = new HashMap<>();
            disponibilidad3.put(LocalDate.of(2020, 10, 28), true);
            disponibilidad3.put(LocalDate.of(2020, 10, 29), true);
            disponibilidad3.put(LocalDate.of(2020, 10, 30), false);
            Hospedaje Hospedaje1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0, disponibilidad3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("1-4");
        try {
            Map<LocalDate, Boolean> disponibilidadHospedaje2 = new HashMap<>();
            disponibilidadHospedaje2.put(LocalDate.of(2020, 10, 28), true);
            disponibilidadHospedaje2.put(LocalDate.of(2020, 10, 29), false);
            disponibilidadHospedaje2.put(LocalDate.of(2020, 10, 30), true);
            Hospedaje Hospedaje2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0, disponibilidadHospedaje2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Hospedaje: " + e.getMessage());

        }
        System.out.println("2-1");
        LocalDate date1 = LocalDate.of(2020, 10, 28);
        try {
            Gastronomia validGastronomia = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4, disponibilidad2_1);
            System.out.println("Precio final Gastronomia: " + validGastronomia.calcularPrecioFinal(date1));
        } catch (Exception e) {
            System.out.println("Error al calcular precio final de Gastronomia: " + e.getMessage());
        }
        System.out.println("2-2");
        try {
            LocalDate date2 = LocalDate.of(2020, 10, 27);
            Servicio servicio2 = sistema.traerServicio("287282");
            if (servicio2 != null) {
                System.out.println("Precio final Hospedaje: " + servicio2.calcularPrecioFinal(date2));
            } else {
                System.out.println("Servicio no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("3");
        Map<LocalDate, Boolean> disponibilidad3 = new HashMap<>();
        disponibilidad3.put(LocalDate.of(2020, 10, 28), true);
        disponibilidad3.put(LocalDate.of(2020, 10, 29), true);

        Map<LocalDate, Boolean> disponibilidad3_ = new HashMap<>();
        disponibilidad3_.put(LocalDate.of(2020, 10, 28), true);
        disponibilidad3_.put(LocalDate.of(2020, 10, 29), false);
        
        try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3, disponibilidad3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0, disponibilidad3);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3, disponibilidad3_);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0, disponibilidad3_);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("4-1");
        List<Servicio> serviciosPromocion = sistema.traerServicio(true);
        System.out.println("Servicios en promoción:");
        for (Servicio servicio : serviciosPromocion) {
            System.out.println("Código: " + servicio.getCodServicio());
        
        }
        System.out.println("4-2");
        LocalDate date3 = LocalDate.of(2020, 10, 28);
        List<Servicio> serviciosPromocionFecha = sistema.traerServicio(true, date3);
        System.out.println("Servicios en promoción el " + date3 + ":");
        for (Servicio servicio : serviciosPromocionFecha) {
            System.out.println("Código: " + servicio.getCodServicio());
        }
    }
}
