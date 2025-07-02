/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.servlets.repuesto;

import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author jimen
 */
// esta clase quita el repuesto pero solo de la lista no del xml 
public class QuitarRepuestoServlet extends HttpServlet {

  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        ArrayList<Repuesto> repuestosAgregados = (ArrayList<Repuesto>) session.getAttribute("repuestosAgregados");
        
        if (repuestosAgregados != null && id != null) {
            repuestosAgregados.removeIf(rep -> rep.getId().equalsIgnoreCase(id));
            session.setAttribute("repuestosAgregados", repuestosAgregados);
        }
        
        // Ahora recargamos  para que la tabla se muestre de nuevo 
        RepuestosData repuestosData = new RepuestosData();
        try {
            ArrayList<Repuesto> repuestos = repuestosData.findAll();
            request.setAttribute("repuestos", repuestos);
        } catch (Exception e) {
         
            e.printStackTrace();
        }
        
        //vyleve a cargar
        request.getRequestDispatcher("/agregar_repuestos.jsp").forward(request, response);
    } catch (JDOMException ex) {
          Logger.getLogger(QuitarRepuestoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}

