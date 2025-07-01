/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
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
public class VehiculoDataTest {
    
//    @Test
//    void insertar_Vehiculo(){
//        Cliente cliente1 = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//        Vehiculo vehiculo1 = new Vehiculo("C3L0Fa8", "Azul", "Toyota", "4X4", "74lo", "2500cc", 2025, cliente1);
//
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            vehiculoData.insertar(vehiculo1);
//            
//            ArrayList<Vehiculo> vehiculos = vehiculoData.findAll();
//            
//            for(Vehiculo vehiculoActual: vehiculos){
//                System.out.println(vehiculoActual);
//            }
//            
//            int tamano = vehiculos.size();
//            
//            assertEquals(tamano, 6);        
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
    
//    @Test
//    void insertar_Vehiculo_existe() {
//        Cliente cliente1 = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//        Vehiculo vehiculo1 = new Vehiculo("C3L0Fa8", "Azul", "Toyota", "4X4", "74lo", "2500cc", 2025, cliente1);
//        
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            vehiculoData.insertar(vehiculo1);
//                
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }

//    @Test
//    void findOne_Vehiculo_existe() {
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            
//            Vehiculo vehiculo = vehiculoData.findOne("C3L0Fa8");
//           
//            assertNotNull(vehiculo);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void findOne_Cliente_no_existe() {
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            
//            Vehiculo vehiculo = vehiculoData.findOne("C3AS0Fa8");
//           
//            assertNull(vehiculo);
//   
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void actualizar_Vehiculo(){
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            Vehiculo vehiculoSinActualizadar = vehiculoData.findOne("C3L0Fa8");
//            
//            Cliente cliente = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//            Vehiculo vehiculoActualizado = new Vehiculo("C3L0Fa8", "Amarillo", "Nissan", "4X4", "74lo", "2500cc", 2023, cliente);
//            vehiculoData.actualizar(vehiculoActualizado);
//
//            assertNotEquals(vehiculoSinActualizadar,vehiculoActualizado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    @Test
//    void eliminar_Vehiculo(){
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            vehiculoData.eliminar("C3L0F98");
//            Vehiculo vehiculoEliminado = vehiculoData.findOne("C3L0F98");
//            
//            assertEquals(null,vehiculoEliminado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    @Test
//    void obtenerDuenno(){
//        try {
//            VehiculoData vehiculoData = new VehiculoData();
//            Cliente dueno = vehiculoData.obtenerDuenno("A12");
//            ClienteData clienteData = new ClienteData();
//            Cliente cliente = clienteData.findOne("A12");            
//            assertEquals(dueno.getId(),cliente.getId()); 
//            assertEquals(dueno.toString(),cliente.toString());           
//
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(VehiculoDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
}
