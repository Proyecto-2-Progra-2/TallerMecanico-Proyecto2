/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luiss
 */
public class OrdenTrabajoDataTest {
    
    
//    @Test
//    void insertar_OrdenTrabajo() {
//        Repuesto repuesto1 = new Repuesto("A17", "Frenos", 40, 150.0);
//        Repuesto repuesto2 = new Repuesto("B18", "Baterias", 58, 75.0);        
//        Repuesto repuesto3 = new Repuesto("C19", "Radiador", 62, 145.0);
//        
//        ArrayList<Repuesto> repuestos = new ArrayList<>();
//        repuestos.add(repuesto1);
//        repuestos.add(repuesto2);
//        repuestos.add(repuesto3);
//        
//        DetalleOrden ordenDetalle = new DetalleOrden(
//                "A123BDF",
//                "Revisión y cambio de frenos",
//                15000.0,
//                repuestos
//        );
//        
//        Cliente cliente = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//        Vehiculo vehiculo = new Vehiculo("C3L0Fa8", "Azul", "Toyota", "4X4", "74lo", "2500cc", 2025, cliente);
//        
//        OrdenTrabajo ordenTrabajo = new OrdenTrabajo(
//                "LO1921",
//                "Decra",
//                "01/07/2025",
//                "Revisión",
//                "Revisión del Vehiculo Anual",
//                "03/07/2025",
//                vehiculo,
//                ordenDetalle
//        );
//        
//        try {
//            OrdenTrabajoData ordenTrabajoData = new OrdenTrabajoData();
//            ordenTrabajoData.insertar(ordenTrabajo);
//            
//            ArrayList<OrdenTrabajo> ordenesTrabajo = ordenTrabajoData.findAll();
//            
//            for(OrdenTrabajo ordenActual: ordenesTrabajo){
//                System.out.println(ordenActual);
//            }
//            
//            int tamano = ordenesTrabajo.size();
//            
//            assertEquals(tamano, 7);   
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenTrabajoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//
//    @Test
//    void findOne_OrdenTrabajo_existe() {
//        try {
//            OrdenTrabajoData ordenTrabajoData = new OrdenTrabajoData();
//            
//            OrdenTrabajo orden = ordenTrabajoData.findOne("LO1921");
//           
//            assertNotNull(orden);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenTrabajoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void findOne_OrdenTrabajo_no_existe() {
//        try {
//            OrdenTrabajoData ordenTrabajoData = new OrdenTrabajoData();
//            
//            OrdenTrabajo orden = ordenTrabajoData.findOne("1");
//           
//            assertNull(orden);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenTrabajoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void modificar_OrdenTrabajo(){
//        try {
//            OrdenTrabajoData ordenTrabajoData = new OrdenTrabajoData();
//            OrdenTrabajo ordenSinActualizadar = ordenTrabajoData.findOne("LO1921");
//            
//            Repuesto repuesto1 = new Repuesto("A17", "Frenos", 40, 150.0);
//            Repuesto repuesto2 = new Repuesto("C19", "Radiador", 62, 145.0);
//
//            ArrayList<Repuesto> repuestos = new ArrayList<>();
//            repuestos.add(repuesto1);
//            repuestos.add(repuesto2);
//
//            DetalleOrden ordenDetalle = new DetalleOrden(
//                    "A123BDF",
//                    "Revisión y cambio de frenos",
//                    15000.0,
//                    repuestos
//            );
//
//            Cliente cliente = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//            Vehiculo vehiculo = new Vehiculo("C3L0Fa8", "Azul", "Toyota", "4X4", "74lo", "2500cc", 2025, cliente);
//
//            OrdenTrabajo ordenTrabajoActualizado = new OrdenTrabajo(
//                    "LO1921",
//                    "Decra y Revisión Tecnica",
//                    "01/07/2025",
//                    "Entrega",
//                    "Entrega del Vehiculo Mesual",
//                    "10/07/2025",
//                    vehiculo,
//                    ordenDetalle
//            );          
//            
//            ordenTrabajoData.modificar(ordenTrabajoActualizado);
//
//            assertNotEquals(ordenSinActualizadar,ordenTrabajoActualizado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenTrabajoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    void eliminar_OrdenTrabajo(){
//        try {
//            OrdenTrabajoData ordenTrabajoData = new OrdenTrabajoData();
//            ordenTrabajoData.eliminar("LO1921");
//            OrdenTrabajo ordenEliminado = ordenTrabajoData.findOne("LO1921");
//            
//            assertEquals(null,ordenEliminado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenTrabajoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
