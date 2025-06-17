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
    
    @Test
    public void insertar_Cliente() {
        Cliente cliente1 = new Cliente("A12","Luis","Sibaja","Otarola",90878908,"Cartago","luis@gmail.com");
        Cliente cliente2 = new Cliente("B12","Axel","Ramirez","Hernandes",12312312,"San Jose","axel@gmail.com");
        Cliente cliente3 = new Cliente("C12","Maria","Hernandez","Castro",12365323,"Alajuela","maria@gmail.com");

        
        try {
            ClienteData clienteData = new ClienteData();
            clienteData.insertar(cliente1);
            clienteData.insertar(cliente2);
            clienteData.insertar(cliente3);

            
            ArrayList<Cliente> clientes = clienteData.findAll();
            
            for(Cliente clienteActual: clientes){
                System.out.println(clienteActual);
            }
            
            int tamano = clientes.size();
            
            assertEquals(tamano, 9);
            
            
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
