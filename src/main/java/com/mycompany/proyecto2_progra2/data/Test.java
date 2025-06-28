/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jeffr
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ClienteData clienteData = new ClienteData();
            VehiculoData vehiculoData = new VehiculoData();
//            clienteData.eliminar("25896");
//            clienteData.insertar(new Cliente("101", "Juan", "Aguirre", "Perez", 71694987, "Turrialba", "Email"));
//            ArrayList<Cliente> cs = clienteData.findAll();
//            for (int i = 0; i < cs.size(); i++) {
//                System.out.println(cs.get(i).toString());
//            }
//            vehiculoData.insertar(new Vehiculo("202589", "Azul", "Toyota", "4X4", "74lo", "2500cc", 2021, clienteData.findOne("101")));
//            ArrayList<Vehiculo> vs = vehiculoData.findAll();
//            for (int i = 0; i < vs.size(); i++) {
//                System.out.println(vs.get(i).toString());
//            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
