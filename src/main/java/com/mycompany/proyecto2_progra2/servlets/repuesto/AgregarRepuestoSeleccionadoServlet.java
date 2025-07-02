package com.mycompany.proyecto2_progra2.servlets.repuesto;

import com.mycompany.proyecto2_progra2.data.RepuestosData;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class AgregarRepuestoSeleccionadoServlet extends HttpServlet {

    private RepuestosData repuestosData;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String cantidadStr = request.getParameter("cantidad");

        if (id == null || cantidadStr == null) {
            response.sendRedirect("agregar_repuestos.jsp"); // O donde tengas tu JSP
            return;
        }

        int cantidadSeleccionada;
        try {
            cantidadSeleccionada = Integer.parseInt(cantidadStr);
            if (cantidadSeleccionada < 1) cantidadSeleccionada = 1;
        } catch (NumberFormatException e) {
            cantidadSeleccionada = 1;
        }

        // Obtener la sesión y la lista actual de repuestos agregados
        HttpSession session = request.getSession();
        ArrayList<Repuesto> repuestosAgregados = (ArrayList<Repuesto>) session.getAttribute("repuestosAgregados");
        if (repuestosAgregados == null) {
            repuestosAgregados = new ArrayList<>();
        }

        try {
            repuestosData = new RepuestosData();
            // Buscar el repuesto completo por id
            Repuesto repuestoBuscado = repuestosData.findOne(id);

            if (repuestoBuscado == null) {
                // No existe ese repuesto
                request.setAttribute("error", "No se encontró el repuesto con ID: " + id);
            } else {
                // Verificar stock
                if (cantidadSeleccionada > repuestoBuscado.getCantidad()) {
                    cantidadSeleccionada = repuestoBuscado.getCantidad(); // Limitar cantidad al stock
                }

                // Verificar si ya está agregado, si sí, sumar cantidades
                boolean encontrado = false;
                for (Repuesto r : repuestosAgregados) {
                    if (r.getId().equalsIgnoreCase(id)) {
                        int nuevaCantidad = r.getCantidad() + cantidadSeleccionada;
                        // No superar stock
                        if (nuevaCantidad > repuestoBuscado.getCantidad()) {
                            nuevaCantidad = repuestoBuscado.getCantidad();
                        }
                        r.setCantidad(nuevaCantidad);
                        encontrado = true;
                        break;
                    }
                }

                // Si no estaba agregado, agregarlo con la cantidad seleccionada
                if (!encontrado) {
                    Repuesto repuestoParaAgregar = new Repuesto(
                        repuestoBuscado.getId(),
                        repuestoBuscado.getNombre(),
                        cantidadSeleccionada,
                        repuestoBuscado.getPrecio()
                    );
                    repuestosAgregados.add(repuestoParaAgregar);
                }
            }

            // Guardar lista actualizada en sesión
            session.setAttribute("repuestosAgregados", repuestosAgregados);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al procesar el repuesto seleccionado.");
        }

        // Volver al JSP de agregar repuestos (ajusta el nombre si es distinto)
        request.getRequestDispatcher("agregar_repuestos.jsp").forward(request, response);
    }
}
