package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;


import com.mycompany.proyecto2_progra2.data.OrdenDetalleData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;


@WebServlet(name = "MostrarDetalleOrdenServlet", urlPatterns = {"/mostrarDetalleOrden"})
public class MostrarDetalleOrdenServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idDetalleOrden = request.getParameter("idDetalleOrden");
        DetalleOrden detalleOrden = null;

        if (idDetalleOrden != null && !idDetalleOrden.isEmpty()) {
            try {
                OrdenDetalleData detalleOrdenData = new OrdenDetalleData();
                detalleOrden = detalleOrdenData.findOne(idDetalleOrden);
            } catch (JDOMException e) {
                // Manejo de excepción, por ejemplo, loggear el error o mostrar un mensaje al usuario
                e.printStackTrace();
                request.setAttribute("mensajeError", "Error al cargar el detalle de la orden: " + e.getMessage());
            }
        }

        request.setAttribute("detalleOrden", detalleOrden);
        request.getRequestDispatcher("mostrar_detalle_orden.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para mostrar el detalle de una orden de trabajo";
    }
}