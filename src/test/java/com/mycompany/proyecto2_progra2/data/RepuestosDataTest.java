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

    @Test
    public void insertar_Repuestos() {
        Repuesto repuesto1 = new Repuesto("A17", "Frenos", 4, 100.0);
        Repuesto repuesto2 = new Repuesto("B18", "Baterias", 5, 75.0);
        Repuesto repuesto3 = new Repuesto("C19", "Radiador", 6, 145.0);
        
        try {
            RepuestosData repuestosData = new RepuestosData();
            repuestosData.insertar(repuesto1);
            repuestosData.insertar(repuesto2);
            repuestosData.insertar(repuesto3);
            
            ArrayList<Repuesto> repuestos = repuestosData.findAll();
            
            for(Repuesto repuestoActual: repuestos){
                System.out.println(repuestoActual);
            }
            
            int tamano = repuestos.size();
            
            assertEquals(tamano, 6);
           
            
        } catch (IOException | JDOMException ex) {
            Logger.getLogger(RepuestosDataTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
