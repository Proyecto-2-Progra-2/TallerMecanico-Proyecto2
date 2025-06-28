/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
public class OrdenTrabajoData {

    private Document document;
    private Element raiz;
    private String rutaDocumento;

    public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\ordenes.xml";

    public OrdenTrabajoData() throws IOException, JDOMException {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo);
            this.raiz = document.getRootElement();
            this.rutaDocumento = RUTA_ARCHIVO;
        } else {
            this.rutaDocumento = RUTA_ARCHIVO;
            this.raiz = new Element("ordenes");
            this.document = new Document(raiz);
            guardar();
        }
    }

    private void guardar() throws IOException, FileNotFoundException {
        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8"); //es buena practica especificar la codificacion

        XMLOutputter xmlOutputter = new XMLOutputter();
        PrintWriter printWriter = new PrintWriter(this.rutaDocumento);
        xmlOutputter.output(this.document, printWriter);
        //imprimir en la consola el DOM
        xmlOutputter.output(this.document, System.out);
        printWriter.close();//cierra el xml
    }

    public void insertar(OrdenTrabajo ordenTrabajo) throws IOException {
        Element eOrden = new Element("orden");
        eOrden.setAttribute("id", ordenTrabajo.getId());

        Element descripcion = new Element("descripcion");
        descripcion.addContent(ordenTrabajo.getDescripcion());

        Element fechaIngreso = new Element("fechaIngreso");
        fechaIngreso.addContent(ordenTrabajo.getFechaIngreso());

        Element estado = new Element("estado");
        estado.addContent(ordenTrabajo.getEstado());

        Element detRecepcion = new Element("detalleRecepcion");
        detRecepcion.addContent(ordenTrabajo.getDetalleRecepcionVehiculo());

        Element fechaDevolucion = new Element("fechaDevolucion");
        fechaDevolucion.addContent(ordenTrabajo.getFechaDevolucion());

        Element vehiculo = new Element("vehiculo");
        vehiculo.addContent(ordenTrabajo.getVehiculo().getPlaca());

        Element detalleOrden = new Element("detalleOrden");
        detalleOrden.addContent(ordenTrabajo.getDetalleOrden().getId());
        
        Element precio = new Element("precio");
        precio.addContent(String.valueOf(ordenTrabajo.getPrecio()));

        eOrden.addContent(descripcion);
        eOrden.addContent(fechaIngreso);
        eOrden.addContent(estado);
        eOrden.addContent(detRecepcion);
        eOrden.addContent(fechaDevolucion);
        eOrden.addContent(vehiculo);
        eOrden.addContent(detalleOrden);
        eOrden.addContent(precio);

        this.raiz.addContent(eOrden);
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

}
