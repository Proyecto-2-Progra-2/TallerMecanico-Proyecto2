/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.Cliente;
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

public class ClienteData {

    private Document document;
    private Element raiz;
    private String rutaDocumento;

    // => Se tiene que cambiar la ruta
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\2025\\Progra\\Proyecto-2\\TallerMecanico-Proyecto2\\xml\\clientes.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\xml\\clientes.xml";
    public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\clientes.xml";

    public ClienteData() throws IOException, JDOMException {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            this.document = saxBuilder.build(archivo);
            this.raiz = document.getRootElement();
            this.rutaDocumento = RUTA_ARCHIVO;
        } else {
            this.rutaDocumento = RUTA_ARCHIVO;
            this.raiz = new Element("clientes");
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

    public void insertar(Cliente cliente) throws IOException {
        Element eCliente = new Element("cliente");
        eCliente.setAttribute("id", cliente.getId());

        Element nombre = new Element("nombre");
        nombre.addContent(cliente.getNombre());
        Element primerApellido = new Element("primerApellido");
        primerApellido.addContent(cliente.getPrimerApellido());
        Element segundoApellido = new Element("segundoApellido");
        segundoApellido.addContent(cliente.getSegundoApellido());
        Element telefono = new Element("telefono");
        telefono.addContent(String.valueOf(cliente.getTelefono()));
        Element direccion = new Element("direccion");
        direccion.addContent(cliente.getDireccion());
        Element email = new Element("email");
        email.addContent(cliente.getEmail());

        eCliente.addContent(nombre);
        eCliente.addContent(primerApellido);
        eCliente.addContent(segundoApellido);
        eCliente.addContent(telefono);
        eCliente.addContent(direccion);
        eCliente.addContent(email);

        raiz.addContent(eCliente);

        guardar();
    }

    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        List eClientes = this.raiz.getChildren();
        for (Object objActual : eClientes) {
            Element eActual = (Element) objActual;
            Cliente c = new Cliente(eActual.getAttributeValue("id"), eActual.getChildText("nombre"),
                    eActual.getChildText("primerApellido"), eActual.getChildText("segundoApellido"),
                    Integer.parseInt(eActual.getChildText("telefono")), eActual.getChildText("direccion"),
                    eActual.getChildText("email"));
            clientes.add(c);
        }

        return clientes;
    }

    public Cliente findOne(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("ID nulo o vacío en búsqueda de cliente.");
            return null;
        }

        ArrayList<Cliente> clientes = findAll();

        // Ordenar por ID para búsqueda binaria:AQUI ES DONDE SE USA 
        clientes.sort((c1, c2) -> c1.getId().compareToIgnoreCase(c2.getId()));

        int left = 0;
        int right = clientes.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Cliente midCliente = clientes.get(mid);
            int compare = midCliente.getId().compareToIgnoreCase(id);

            if (compare == 0) {
                System.out.println("Cliente encontrado con ID: " + id);
                return midCliente;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(" Cliente no encontrado con ID: " + id);
        return null;
    }

    public void actualizar(Cliente actualizado) throws IOException {

        List<Element> listarClientes = raiz.getChildren("cliente");

        for (Element eCliente : listarClientes) {
            if (eCliente.getAttributeValue("id").equals(actualizado.getId())) {
                eCliente.getChild("nombre").setText(actualizado.getNombre());
                eCliente.getChild("primerApellido").setText(actualizado.getPrimerApellido());
                eCliente.getChild("segundoApellido").setText(actualizado.getSegundoApellido());
                eCliente.getChild("telefono").setText(String.valueOf(actualizado.getTelefono()));
                eCliente.getChild("direccion").setText(actualizado.getDireccion());
                eCliente.getChild("email").setText(actualizado.getEmail());

                guardar(); // Guardar los cambios en el archivo XML
                break;
            }
        }
    }

    public void eliminar(String id) throws IOException {
        List<Element> eClientes = this.raiz.getChildren();
        boolean eliminado = false;

        Iterator<Element> iterator = eClientes.iterator();
        while (iterator.hasNext()) {
            Element eCliente = iterator.next();
            if (eCliente.getAttributeValue("id").equals(id)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardar();
        } else {
            System.out.println("Cliente con identificacion: " + id + " no encontrado.");
        }
    }
}
