/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author luiss
 */
public class OrdenDetalleDataTest {
    
    

//    @Test
//    void insertar_DetalleOrden() {
//        Repuesto repuesto1 = new Repuesto("A17", "Frenos", 40, 150.0);
//        Repuesto repuesto2 = new Repuesto("B18", "Baterias", 58, 75.0);        
//        Repuesto repuesto3 = new Repuesto("C19", "Radiador", 62, 145.0);
//        
//        ArrayList<Repuesto> repuestos = new ArrayList<>();
//        repuestos.add(repuesto1);
//        repuestos.add(repuesto2);
//        repuestos.add(repuesto3);
//
//        DetalleOrden orden = new DetalleOrden(
//                "A123BDF",
//                "Revisión y cambio de frenos",
//                15000.0,
//                repuestos
//        );
//        
//        try {
//            OrdenDetalleData ordenDetalleData = new OrdenDetalleData();
//            //ordenDetalleData.insertar(orden);
//            
//            ArrayList<DetalleOrden> ordenesDetalle = ordenDetalleData.findAll();
//            
//            for(DetalleOrden ordenActual: ordenesDetalle){
//                System.out.println(ordenActual);
//            }
//            
//            int tamano = ordenesDetalle.size();
//            
//            assertEquals(tamano, 7);   
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenDetalleDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

//    @Test
//    void findOne_DetalleOrden_existe() {
//        try {
//            OrdenDetalleData ordenDetalleData = new OrdenDetalleData();
//            
//            DetalleOrden orden = ordenDetalleData.findOne("A123BDF");
//           
//            assertNotNull(orden);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenDetalleDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void findOne_DetalleOrden_no_existe() {
//        try {
//            OrdenDetalleData ordenDetalleData = new OrdenDetalleData();
//            
//            DetalleOrden orden = ordenDetalleData.findOne("1");
//           
//            assertNull(orden);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenDetalleDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
    
//    @Test
//    void modificar_DetalleOrden(){
//        try {
//            OrdenDetalleData ordenDetalleData = new OrdenDetalleData();
//            DetalleOrden ordenSinActualizadar = ordenDetalleData.findOne("A123BDF");
//            
//            Repuesto repuesto1 = new Repuesto("S17", "Frenos", 410, 150.0);
//            Repuesto repuesto2 = new Repuesto("T18", "Baterias", 58, 75.0);        
//            Repuesto repuesto3 = new Repuesto("CJ19", "Radiador", 82, 145.0);
//
//            ArrayList<Repuesto> repuestos = new ArrayList<>();
//            repuestos.add(repuesto1);
//            repuestos.add(repuesto2);
//            repuestos.add(repuesto3);
//            
//            DetalleOrden ordenActualizada = new DetalleOrden(
//                "A123BDF",
//                "Revisióna y cambio de aceite",
//                12000.0,
//                repuestos
//            );            
//            
//            ordenDetalleData.modificar(ordenActualizada);
//
//            assertNotEquals(ordenSinActualizadar,ordenActualizada);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenDetalleDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    void eliminar_OrdenDetalle(){
//        try {
//            OrdenDetalleData ordenDetalleData = new OrdenDetalleData();
//            ordenDetalleData.eliminar("A123BDF");
//            DetalleOrden detalleOrdenEliminado = ordenDetalleData.findOne("A123BDF");
//            
//            assertEquals(null,detalleOrdenEliminado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(OrdenDetalleDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
}
