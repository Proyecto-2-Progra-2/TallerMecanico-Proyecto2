/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author jeffr
 */
public class OrdenDetalleData {

    private Document document;
    private Element raiz;
    private String rutaDocumento;

    //public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\detallesOrden.xml";

        public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\ProyectoProgra\\TallerMecanico-Proyecto2\\xml\\ordenDetalle.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\detallesOrden.xml";

    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\Taller\\TallerMecanico-Proyecto2\\xml\\ordenDetalle";
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\TallerMecanico\\TallerMecanico-Proyecto2\\xml\\ordenDetalle";
   // public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\detallesOrden.xml";


    
    public OrdenDetalleData() throws IOException, JDOMException {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo);
            this.raiz = document.getRootElement();
            this.rutaDocumento = RUTA_ARCHIVO;
        } else {
            this.rutaDocumento = RUTA_ARCHIVO;
            this.raiz = new Element("detallesOrden");
            this.document = new Document(raiz);
            guardar();
        }
    }

    private void guardar() throws IOException, FileNotFoundException {
        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");

        XMLOutputter xmlOutputter = new XMLOutputter();
        PrintWriter printWriter = new PrintWriter(this.rutaDocumento);
        xmlOutputter.output(this.document, printWriter);
        xmlOutputter.output(this.document, System.out); // Para imprimir en consola
        printWriter.close();
    }

    public void insertar(DetalleOrden detalleOrden) throws IOException {
        Element eDetalleOrden = new Element("detalleOrden");
        eDetalleOrden.setAttribute("id", detalleOrden.getId());

        Element observaciones = new Element("observaciones");
        observaciones.addContent(detalleOrden.getObservaciones());

        Element manoObra = new Element("manoObra");
        manoObra.addContent(String.valueOf(detalleOrden.getManoObra()));

        // Guardar los repuestos asociados a este DetalleOrden
        Element repuestosElement = new Element("repuestos");
        for (Repuesto repuesto : detalleOrden.getRepuestos()) {
            Element eRepuesto = new Element("repuesto");
            eRepuesto.setAttribute("id", repuesto.getId());
            eRepuesto.addContent(new Element("nombre").addContent(repuesto.getNombre()));
            eRepuesto.addContent(new Element("cantidad").addContent(String.valueOf(repuesto.getCantidad())));
            eRepuesto.addContent(new Element("precio").addContent(String.valueOf(repuesto.getPrecio())));
            repuestosElement.addContent(eRepuesto);
        }

        Element precioTotal = new Element("precioTotal");
        precioTotal.addContent(String.valueOf(detalleOrden.getPrecioTotal()));

        eDetalleOrden.addContent(observaciones);
        eDetalleOrden.addContent(manoObra);
        eDetalleOrden.addContent(repuestosElement);
        eDetalleOrden.addContent(precioTotal);

        this.raiz.addContent(eDetalleOrden);
        guardar();
    }

    public boolean existe(String id) {
        List<Element> elementos = this.raiz.getChildren();
        for (Element elemento : elementos) {
            if (elemento.getAttributeValue("id").equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<DetalleOrden> findAll() throws JDOMException, IOException {
        ArrayList<DetalleOrden> detallesOrden = new ArrayList<>();
        List<Element> elementos = this.raiz.getChildren();

        for (Element elemento : elementos) {
            String id = elemento.getAttributeValue("id");
            String observaciones = elemento.getChildText("observaciones");
            double manoObra = Double.parseDouble(elemento.getChildText("manoObra"));
            
            ArrayList<Repuesto> repuestos = new ArrayList<>();
            Element repuestosElement = elemento.getChild("repuestos");
            if (repuestosElement != null) {
                List<Element> repuestoElements = repuestosElement.getChildren("repuesto");
                for (Element eRepuesto : repuestoElements) {
                    String repuestoId = eRepuesto.getAttributeValue("id");
                    String nombre = eRepuesto.getChildText("nombre");
                    int cantidad = Integer.parseInt(eRepuesto.getChildText("cantidad"));
                    double precio = Double.parseDouble(eRepuesto.getChildText("precio"));
                    repuestos.add(new Repuesto(repuestoId, nombre, cantidad, precio));
                }
            }
            
            // El precioTotal se calcula automáticamente en el constructor de DetalleOrden
            DetalleOrden detalle = new DetalleOrden(id, observaciones, manoObra, repuestos);
            detallesOrden.add(detalle);
        }
        return detallesOrden;
    }

    public DetalleOrden findOne(String id) throws JDOMException, IOException {
        ArrayList<DetalleOrden> detallesOrden = findAll();
        for (DetalleOrden detalle : detallesOrden) {
            if (detalle.getId().equalsIgnoreCase(id)) {
                return detalle;
            }
        }
        return null;
    }

    public void modificar(DetalleOrden detalleOrden) throws IOException {
        boolean encontrado = false;
        List<Element> elementos = this.raiz.getChildren();
        for (Element elemento : elementos) {
            if (elemento.getAttributeValue("id").equalsIgnoreCase(detalleOrden.getId())) {
                elemento.getChild("observaciones").setText(detalleOrden.getObservaciones());
                elemento.getChild("manoObra").setText(String.valueOf(detalleOrden.getManoObra()));

                // Actualizar los repuestos
                Element repuestosElement = elemento.getChild("repuestos");
                repuestosElement.removeContent(); // Eliminar los repuestos existentes
                for (Repuesto repuesto : detalleOrden.getRepuestos()) {
                    Element eRepuesto = new Element("repuesto");
                    eRepuesto.setAttribute("id", repuesto.getId());
                    eRepuesto.addContent(new Element("nombre").addContent(repuesto.getNombre()));
                    eRepuesto.addContent(new Element("cantidad").addContent(String.valueOf(repuesto.getCantidad())));
                    eRepuesto.addContent(new Element("precio").addContent(String.valueOf(repuesto.getPrecio())));
                    repuestosElement.addContent(eRepuesto);
                }
                elemento.getChild("precioTotal").setText(String.valueOf(detalleOrden.getPrecioTotal())); // Recalcular y actualizar

                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            guardar();
        } else {
            throw new IOException("El Detalle de Orden con el ID: " + detalleOrden.getId() + ", no se encontró!");
        }
    }

    public void eliminar(String id) throws IOException {
        List<Element> elementos = this.raiz.getChildren();
        boolean eliminado = false;

        Iterator<Element> iterator = elementos.iterator();
        while (iterator.hasNext()) {
            Element eDetalleOrden = iterator.next();
            if (eDetalleOrden.getAttributeValue("id").equalsIgnoreCase(id)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardar();
        } else {
            System.out.println("El Detalle de Orden con el id: " + id + ", no encontrado.");
        }
    }
}