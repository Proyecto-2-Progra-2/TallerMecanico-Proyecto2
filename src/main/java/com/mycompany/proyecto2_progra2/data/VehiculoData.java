/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
    //public static final String RUTA_ARCHIVO ="C:\\Users\\jimen\\OneDrive\\Escritorio\\2025\\Progra\\Proyecto-2\\TallerMecanico-Proyecto2\\xml\\vehiculos.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\vehiculos.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\vehiculos.xml";
<<<<<<< HEAD
    public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\ProyectoProgra\\TallerMecanico-Proyecto2\\xml\\vehiculos.xml";
=======
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\TallerMecanico\\TallerMecanico-Proyecto2\\xml\\vehiculos";
>>>>>>> 555b2b8c19e16bb7f743b704ae6994a667e49b08
    
    public VehiculoData() throws IOException, JDOMException {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo);
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
        format.setEncoding("UTF-8");

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

    public Vehiculo findOne(String placa) throws IOException, JDOMException {

        if (placa == null || placa.isEmpty()) {
            return null;
        }

        List eVehiculos = this.raiz.getChildren();

        for (Object objectActual : eVehiculos) {
            Element eActual = (Element) objectActual;

            String placaActual = eActual.getAttributeValue("placa");

            if (placa.equalsIgnoreCase(placaActual)) {

                // crea y devulev el ibjeto vehiculo
                return new Vehiculo(
                        eActual.getAttributeValue("placa"),
                        eActual.getChildText("color"),
                        eActual.getChildText("marca"),
                        eActual.getChildText("estilo"),
                        eActual.getChildText("VIN"),
                        eActual.getChildText("cilindraje"),
                        Integer.parseInt(eActual.getChildText("annio")),
                        new ClienteData().findOne(eActual.getChildText("duennio")) // Obtener  el dueño

                );
            }
        }

        return null; // xq no se encontro
    }

    public Cliente obtenerDuenno(String idDuenno) throws IOException, JDOMException {

        if (idDuenno == null || idDuenno.isEmpty()) {
            return null;
        }
        ClienteData clienteData = new ClienteData();
        return clienteData.findOne(idDuenno);
    }

    public void actualizar(Vehiculo vehiculo) throws IOException {

        List<Element> vehiculos = this.raiz.getChildren();

        boolean enocntrado = false;// con centinela 

        for (Element eVehiculo : vehiculos) {
            if (eVehiculo.getAttributeValue("placa").equalsIgnoreCase(vehiculo.getPlaca())) // actualizar los datos si son iguales
            {
                eVehiculo.getChild("color").setText(vehiculo.getColor());

                eVehiculo.getChild("marca").setText(vehiculo.getMarca());
                eVehiculo.getChild("estilo").setText(vehiculo.getEstilo());
                eVehiculo.getChild("VIN").setText(vehiculo.getVin());
                eVehiculo.getChild("cilindraje").setText(vehiculo.getCilindraje());
                eVehiculo.getChild("annio").setText(String.valueOf(vehiculo.getAnnio()));
                eVehiculo.getChild("duennio").setText(vehiculo.getDuenno().getId());

                enocntrado = true; // cierro centinela 

                break;// salir del ciclo 
            }
        }
        if (enocntrado) {
            guardar();// guarad la info 
        } else {
            throw new IOException("El vehiculo con la placa" + vehiculo.getPlaca() + "no se encontro!");

        }
    }

    public void eliminar(String placa) throws IOException {
        List<Element> vehiculos = this.raiz.getChildren("vehiculo");
        boolean eliminado = false;

        Iterator<Element> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Element eVehiculo = iterator.next();
            if (eVehiculo.getAttributeValue("placa").equals(placa)) {
                iterator.remove(); // elimina del documento
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardar(); // guarda el XML actualizado
        } else {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
    }

}
