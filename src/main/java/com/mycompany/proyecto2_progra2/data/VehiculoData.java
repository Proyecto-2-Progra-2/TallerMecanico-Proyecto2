/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class VehiculoData {
    
    private Document document;
    private Element raiz;
    private String rutaDocumento;
    // => Se tiene que cambiar la ruta
    public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Progra2-2025\\Proyecto2\\Proyecto2_Progra2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\vehiculos.xml";

    public VehiculoData() throws IOException, JDOMException, FileNotFoundException {
        if (new File(RUTA_ARCHIVO).exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(RUTA_ARCHIVO);
            this.raiz = document.getRootElement();
            this.rutaDocumento = RUTA_ARCHIVO;
        } else {
            this.rutaDocumento = RUTA_ARCHIVO;
            this.raiz = new Element("vehiculos");
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
    
    public void insertar(Vehiculo vehiculo) throws IOException {
        Element eVehiculo = new Element("vehiculo");
        eVehiculo.setAttribute("placa", vehiculo.getPlaca());
        Element color = new Element("color");
        color.addContent(vehiculo.getColor());
        Element marca = new Element("marca");
        marca.addContent(vehiculo.getMarca());
        Element estilo = new Element("estilo");
        estilo.addContent(vehiculo.getEstilo());
        Element vin = new Element("VIN");
        vin.addContent(vehiculo.getVin());
        Element cilindraje = new Element("cilindraje");
        cilindraje.addContent(vehiculo.getCilindraje());
        Element annio = new Element("annio");
        annio.addContent(String.valueOf(vehiculo.getAnnio()));
        Element duennio = new Element("duennio");
        duennio.addContent(vehiculo.getDuenno().getId());
        
        eVehiculo.addContent(color);
        eVehiculo.addContent(marca);
        eVehiculo.addContent(estilo);
        eVehiculo.addContent(vin);
        eVehiculo.addContent(cilindraje);
        eVehiculo.addContent(annio);
        eVehiculo.addContent(duennio);
        
        this.raiz.addContent(eVehiculo);
        
        guardar();
    }
    
    public ArrayList<Vehiculo> findAll() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        List eVehiculos = this.raiz.getChildren();
        for (Object objActual : eVehiculos) {
            try {
                Element eActual = (Element) objActual;
                Vehiculo v = new Vehiculo(eActual.getAttributeValue("placa"), eActual.getChildText("color"),
                        eActual.getChildText("marca"), eActual.getChildText("estilo"), eActual.getChildText("VIN"),
                        eActual.getChildText("cilindraje"), Integer.parseInt(eActual.getChildText("annio")),
                        new ClienteData().findOne(eActual.getChildText("duennio")));
                vehiculos.add(v);
            } catch (IOException ex) {
                Logger.getLogger(VehiculoData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JDOMException ex) {
                Logger.getLogger(VehiculoData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return vehiculos;
    }
    
}
