/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
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
 * @author luiss
 */
public class RepuestosData {

    private Document document;
    private Element raiz;
    private String rutaDocumento;
    // => Se tiene que cambiar la ruta
   // public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\repuestos.xml";

    public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\repuestos.xml";
    //Jime 
// public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\Progra2_TallerMecanico\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\repuestos.xml";

    

    public RepuestosData() throws IOException, JDOMException {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo); // ✅ CAMBIO AQUÍ
            this.raiz = document.getRootElement();
            this.rutaDocumento = RUTA_ARCHIVO;
        } else {
            this.rutaDocumento = RUTA_ARCHIVO;
            this.raiz = new Element("repuestos");
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

    public void insertar(Repuesto repuesto) throws IOException {
        
        List<Element> repuestos = this.raiz.getChildren();
        for (Element eRepuesto : repuestos) {
            String id = eRepuesto.getAttributeValue("id");
            if (id != null && id.equalsIgnoreCase(repuesto.getId())) {
                throw new IOException("No se puede insertar el repuesto. Ya existe un repuesto con el id: " + repuesto.getId());
            }
        } 
         
        Element eRepuesto = new Element("repuesto");
        eRepuesto.setAttribute("id", repuesto.getId());

        Element nombre = new Element("nombre");
        nombre.addContent(repuesto.getNombre());
        Element cantidad = new Element("cantidad");
        cantidad.addContent(String.valueOf(repuesto.getCantidad()));
        Element precio = new Element("precio");
        precio.addContent(String.valueOf(repuesto.getPrecio()));

        eRepuesto.addContent(nombre);
        eRepuesto.addContent(cantidad);
        eRepuesto.addContent(precio);

        raiz.addContent(eRepuesto);

        guardar();
    }

    public ArrayList<Repuesto> findAll() {
        ArrayList<Repuesto> repuestos = new ArrayList<>();

        List eClientes = this.raiz.getChildren();
        for (Object objActual : eClientes) {
            Element eActual = (Element) objActual;
            Repuesto c = new Repuesto(eActual.getAttributeValue("id"), eActual.getChildText("nombre"),
                    Integer.parseInt(eActual.getChildText("cantidad")), Double.parseDouble(eActual.getChildText("precio")));
            repuestos.add(c);
        }

        return repuestos;
    }

    public Repuesto findOne(String id) {
        ArrayList<Repuesto> repuestos = findAll();

        // => Clonar y ordenar la lista por id
        repuestos.sort((c1, c2) -> c1.getId().compareToIgnoreCase(c2.getId()));

        int left = 0;
        int right = repuestos.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Repuesto midRepuesto = repuestos.get(mid);
            int compare = midRepuesto.getId().compareToIgnoreCase(id);

            if (compare == 0) {
                return midRepuesto;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void actualizar(Repuesto actualizado) throws IOException {

        List<Element> listarRepuestos = raiz.getChildren("repuesto");

        for (Element eRepuesto : listarRepuestos) {
            if (eRepuesto.getAttributeValue("id").equals(actualizado.getId())) {
                eRepuesto.getChild("nombre").setText(actualizado.getNombre());
                eRepuesto.getChild("cantidad").setText(String.valueOf(actualizado.getCantidad()));
                eRepuesto.getChild("precio").setText(String.valueOf(actualizado.getPrecio()));

                guardar(); // Guardar los cambios en el archivo XML
                break;
            }
        }
    }

    public void eliminar(String id) throws IOException {
        List<Element> eRepuestos = this.raiz.getChildren();
        boolean eliminado = false;

        Iterator<Element> iterator = eRepuestos.iterator();
        while (iterator.hasNext()) {
            Element eRepuesto = iterator.next();
            if (eRepuesto.getAttributeValue("id").equals(id)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardar();
        } else {
            System.out.println("Repuesto con identificacion: " + id + " no encontrado.");
        }
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
