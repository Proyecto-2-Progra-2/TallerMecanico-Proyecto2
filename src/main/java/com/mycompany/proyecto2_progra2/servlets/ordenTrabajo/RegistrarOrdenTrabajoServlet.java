package com.mycompany.proyecto2_progra2.servlets.ordenTrabajo;

import com.mycompany.proyecto2_progra2.data.OrdenDetalleData;
import com.mycompany.proyecto2_progra2.data.OrdenTrabajoData;
import com.mycompany.proyecto2_progra2.data.VehiculoData;
import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.JDOMException;

public class RegistrarOrdenTrabajoServlet extends HttpServlet {

    private OrdenTrabajoData ordenTrabajoData;
    private OrdenDetalleData detalleData;
    private DetalleOrden detalleOrden;
    private String id, idDetalle;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.ordenTrabajoData = new OrdenTrabajoData();
            this.detalleData = new OrdenDetalleData();
            do {
                this.id = generarID();
            } while (this.ordenTrabajoData.existe(this.id));
            
            do {
                this.idDetalle = generarID();
            } while (this.detalleData.existe(this.idDetalle));
            
            LocalDate fechaIngreso = LocalDate.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fechaIngreso.format(formato);

            if (this.detalleOrden != null) {
                req.setAttribute("precio", this.detalleOrden.getPrecioTotal());
            }
            
            req.setAttribute("fechaIngreso", fechaFormateada);
            req.setAttribute("id", this.id);
            req.setAttribute("idDetalle", this.idDetalle);
            req.getRequestDispatcher("registrar_orden_trabajo.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.detalleData = new OrdenDetalleData();
            ArrayList<Repuesto> repuestos = new ArrayList<>();
            repuestos.add(new Repuesto("1", "repuesto1", 2, 25000));
            repuestos.add(new Repuesto("2", "repuesto2", 1, 75000));
            this.ordenTrabajoData = new OrdenTrabajoData();
            
            this.detalleOrden = new DetalleOrden(req.getParameter("idOrden"), 
                    req.getParameter("observaciones"), Double.parseDouble(req.getParameter("precioManoObra")), 
                    repuestos);
            this.detalleData.insertar(this.detalleOrden);

            String fechaDevolucion = req.getParameter("fechaDevolucion");
            LocalDate fecha = LocalDate.parse(fechaDevolucion);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fecha.format(formato);

            OrdenTrabajo orden = new OrdenTrabajo(req.getParameter("id"), req.getParameter("descripcion"),
                    req.getParameter("fechaIngreso"), req.getParameter("estado"), req.getParameter("detalleRecepcion"),
                    fechaFormateada, new VehiculoData().findOne(req.getParameter("vehiculo")), this.detalleOrden);
            this.ordenTrabajoData.insertar(orden);

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (JDOMException ex) {
            Logger.getLogger(RegistrarOrdenTrabajoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String generarID() {
        SecureRandom secureRandom = new SecureRandom();
        int numero = secureRandom.nextInt(1_000_000);
        String id = String.format("%06d", numero);
        return id;
    }
}
