/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Repuesto;
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
public class RepuestosDataTest {
//
//    @Test
//    public void insertar_Repuestos() {
//        Repuesto repuesto1 = new Repuesto("A17", "Frenos", 40, 150.0);
//        Repuesto repuesto2 = new Repuesto("B18", "Baterias", 5, 75.0);
//        Repuesto repuesto3 = new Repuesto("C19", "Radiador", 6, 145.0);
//        
//        try {
//            RepuestosData repuestosData = new RepuestosData();
//            repuestosData.insertar(repuesto1);
//            repuestosData.insertar(repuesto2);
//            repuestosData.insertar(repuesto3);
//            
//            ArrayList<Repuesto> repuestos = repuestosData.findAll();
//            
//            for(Repuesto repuestoActual: repuestos){
//                System.out.println(repuestoActual);
//            }
//            
//            int tamano = repuestos.size();
//            
//            assertEquals(tamano, 3);
//           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    public void insertar_Vehiculo_existe() {
//        Repuesto repuesto = new Repuesto("A17", "Frenos", 4, 100.0);
//        //tira la excepcion
//        try {
//            RepuestosData repuestosData = new RepuestosData();
//            repuestosData.insertar(repuesto);
//                
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//
//    @Test
//    public void findOne_Repuesto_existe() {
//        try {
//            RepuestosData repuestoData = new RepuestosData();
//            
//            Repuesto repuesto = repuestoData.findOne("A17");
//           
//            assertNotNull(repuesto);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    public void findOne_Cliente_no_existe() {
//        try {
//            RepuestosData repuestoData = new RepuestosData();
//            
//            Repuesto repuesto = repuestoData.findOne("A27");
//           
//            assertNull(repuesto);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    public void actualizar_Vehiculo(){
//        try {
//            RepuestosData repuestoData = new RepuestosData();
//            Repuesto repuestoSinActualizadar = repuestoData.findOne("A17");
//            
//            Repuesto repuestoActualizado = new Repuesto("A17", "Frenos", 40, 150.0);      
//            repuestoData.actualizar(repuestoActualizado);
//
//            assertNotEquals(repuestoSinActualizadar,repuestoActualizado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    @Test
//    public void eliminar_Vehiculo(){
//        try {
//            RepuestosData repuestoData = new RepuestosData();
//            repuestoData.eliminar("A17");
//            Repuesto repuestoEliminado = repuestoData.findOne("A17");
//            
//            assertEquals(null,repuestoEliminado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
