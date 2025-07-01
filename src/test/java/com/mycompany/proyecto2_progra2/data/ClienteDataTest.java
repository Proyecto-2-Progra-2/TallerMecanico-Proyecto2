/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
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
public class ClienteDataTest {
    
//    @Test
//    void insertar_Cliente() {
//        Cliente cliente1 = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//        Cliente cliente2 = new Cliente("B12","Axel","Ramirez","Hernandes",12312312,"San Jose","axel@gmail.com");
//        Cliente cliente3 = new Cliente("C12","Maria","Hernandez","Castro",12365323,"Alajuela","maria@gmail.com");
//        
//        try {
//            ClienteData clienteData = new ClienteData();
//            
//            clienteData.insertar(cliente1);
//            clienteData.insertar(cliente2);
//            clienteData.insertar(cliente3);
//           
//            ArrayList<Cliente> clientes = clienteData.findAll();
//            
//            for(Cliente clienteActual: clientes){
//                System.out.println(clienteActual);
//            }
//            
//            int tamano = clientes.size();
//            
//            assertEquals(tamano, 3);
//            
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(ClienteDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void no_insertar_Cliente() {
//        Cliente cliente1 = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
//        Cliente cliente2 = new Cliente("A12","Axel","Ramirez","Hernandes",12312312,"San Jose","axel@gmail.com");
//        Cliente cliente3 = new Cliente("C12","Maria","Hernandez","Castro",12365323,"Alajuela","maria@gmail.com");
//        
//        try {
//            ClienteData clienteData = new ClienteData();
//            
//            clienteData.insertar(cliente1);
//            clienteData.insertar(cliente2);
//            clienteData.insertar(cliente3);
//           
//            ArrayList<Cliente> clientes = clienteData.findAll();
//            
//            for(Cliente clienteActual: clientes){
//                System.out.println(clienteActual);
//            }
//            
//            int tamano = clientes.size();
//            
//            assertEquals(tamano, 3);
//            
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(ClienteDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void findOne_Cliente_existe() {
//        try {
//            ClienteData clienteData = new ClienteData();
//            
//            Cliente cliente = clienteData.findOne("BV12");
//           
//            assertNotNull(cliente);
//                        
//            String clienteEsperado = "Cliente{id=BV12, nombre=Luis , primerApellido=Sibaja, segundoApellido=Otárola, direccion=San José, Escazu, email=carlos@hotmail.com, telefono=78542152}";
//            
//            assertEquals(clienteEsperado, cliente.toString());
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(ClienteDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void findOne_Cliente_no_existe() {
//        try {
//            ClienteData clienteData = new ClienteData();
//            
//            Cliente cliente = clienteData.findOne("A12C");
//           
//            assertNull(cliente);           
//            
//            assertEquals(null, cliente);
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    @Test
//    void actualizar_cliente(){
//        try {
//            ClienteData clienteData = new ClienteData();   
//            Cliente clienteSinActualizadar = clienteData.findOne("A12");
//            
//            Cliente clienteActualizado = new Cliente("A12","Luis","Sibaja","Otarola",78904567,"Alajuela","sibaja@gmail.com");
//            clienteData.actualizar(clienteActualizado);
//
//            assertNotEquals(clienteSinActualizadar,clienteActualizado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(ClienteDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    void eliminar_cliente(){
//        try {
//            ClienteData clienteData = new ClienteData();   
//            clienteData.eliminar("BV");
//            Cliente clienteEliminado = clienteData.findOne("BV");
//            
//            assertEquals(null,clienteEliminado);           
//            
//        } catch (IOException | JDOMException ex) {
//            Logger.getLogger(ClienteDataTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
