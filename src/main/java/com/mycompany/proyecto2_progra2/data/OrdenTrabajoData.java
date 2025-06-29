/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.data;

import com.mycompany.proyecto2_progra2.domain.DetalleOrden;
import com.mycompany.proyecto2_progra2.domain.OrdenTrabajo;
import com.mycompany.proyecto2_progra2.domain.Repuesto;
import com.mycompany.proyecto2_progra2.domain.Vehiculo;
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
public class OrdenTrabajoData {

    private Document document;
    private Element raiz;
    private String rutaDocumento;

     //public static final String RUTA_ARCHIVO = "C:\\Users\\jeffr\\OneDrive\\Documentos\\Proyecto2-Progra2\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\ordenes.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\Taller\\TallerMecanico-Proyecto2\\xml\\ordenTrabajo";

  //  public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\ordenes.xml";

    
    public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\TallerMecanico\\TallerMecanico-Proyecto2\\xml\\ordenTrabajo";

   // public static final String RUTA_ARCHIVO = "C:\\Repositorios\\Proyecto2-Programación2\\Original\\TallerMecanico-Proyecto2\\src\\main\\java\\com\\mycompany\\proyecto2_progra2\\xml\\ordenes.xml";
    //public static final String RUTA_ARCHIVO = "C:\\Users\\jimen\\OneDrive\\Escritorio\\TallerMecanico\\TallerMecanico-Proyecto2\\xml\\ordenTrabajo";
    

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

     public ArrayList<OrdenTrabajo> findAll() throws JDOMException, IOException {
        ArrayList<OrdenTrabajo> ordenes = new ArrayList<>();

        if (this.raiz == null) {
            System.err.println("Raiz es null, no se pudo cargar el XML o no existe contenido.");
            return ordenes; // lista vacía
        }

        // Datos dummy para repuestos (puedes cambiar esto para que traiga los reales)
        ArrayList<Repuesto> repuestos = new ArrayList<>();
        repuestos.add(new Repuesto("1", "repuesto1", 2, 25000));
        repuestos.add(new Repuesto("2", "repuesto2", 1, 75000));

        List<Element> elementos = this.raiz.getChildren();

        for (Element elemento : elementos) {
            try {
                String id = elemento.getAttributeValue("id");
                String descripcion = elemento.getChildText("descripcion");
                String fechaIngreso = elemento.getChildText("fechaIngreso");
                String estado = elemento.getChildText("estado");
                String detalleRecepcion = elemento.getChildText("detalleRecepcion");
                String fechaDevolucion = elemento.getChildText("fechaDevolucion");
                String vehiculoId = elemento.getChildText("vehiculo");
                String precioStr = elemento.getChildText("precio");

                Vehiculo vehiculo = new VehiculoData().findOne(vehiculoId);
                if (vehiculo == null) {
                    System.err.println("Vehículo no encontrado para ID: " + vehiculoId);
                    vehiculo = new Vehiculo("N/A", "Desconocido", "Desconocido", "Desconocido"); // Vehículo por defecto
                    // o con el constructor que ya teniamos vehiculo = new Vehiculo("N/A", "Desconocido", "Desconocido", "Desconocido", "", "", 0, null);

                }

                DetalleOrden detalleOrden = new DetalleOrden("123", "Sin observacion", 20000, repuestos);

                OrdenTrabajo o = new OrdenTrabajo(id, descripcion, fechaIngreso, estado,
                        detalleRecepcion, fechaDevolucion, vehiculo, detalleOrden);

                if (precioStr != null && !precioStr.isEmpty()) {
                    try {
                        o.setPrecio(Double.parseDouble(precioStr));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al parsear precio para orden " + id + ": " + nfe.getMessage());
                        o.setPrecio(0);
                    }
                }

                ordenes.add(o);
            } catch (Exception e) {
                System.err.println("Error leyendo un elemento de orden: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return ordenes;
    }

    
    public OrdenTrabajo findOne(String id) throws JDOMException, IOException {
        ArrayList<OrdenTrabajo> ordenes = findAll();
        
        for (OrdenTrabajo orden : ordenes) {
            if (orden.getId().equalsIgnoreCase(id)) {
                return orden;
            }
        }
        
        return null;
    }
    
    public void modificar(OrdenTrabajo orden) throws IOException {
        boolean encontrado = false;
        List<Element> elementos = this.raiz.getChildren();
        for (Element elemento : elementos) {
            if (elemento.getAttributeValue("id").equalsIgnoreCase(orden.getId())) {
                elemento.getChild("descripcion").setText(orden.getDescripcion());
                elemento.getChild("estado").setText(orden.getEstado());
                elemento.getChild("detalleRecepcion").setText(orden.getDetalleRecepcionVehiculo());
                elemento.getChild("fechaDevolucion").setText(orden.getFechaDevolucion());
                
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            guardar();
        } else {
            throw new IOException("La orden con el ID: " + orden.getId() + ", no se encontró!");

        }
    }
    
    public void eliminar(String id) throws IOException {
        List<Element> elementos = this.raiz.getChildren();
        boolean eliminado = false;
        
        Iterator<Element> iterator = elementos.iterator();
        while (iterator.hasNext()) {
            Element eOrden = iterator.next();
            if (eOrden.getAttributeValue("id").equalsIgnoreCase(id)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }
        
        if (eliminado) {
            guardar();
        } else {
            System.out.println("La orden con el id: " + id + ", no encontrada.");
        }
    }
  
public ArrayList<Repuesto> findRepuestosPorOrden(String idOrden) {
    ArrayList<Repuesto> repuestos = new ArrayList<>();

    try {
        List<Element> elementos = this.raiz.getChildren();

        for (Element elemento : elementos) {
            String id = elemento.getAttributeValue("id");
            if (id.equalsIgnoreCase(idOrden)) {
                Element detalleOrden = elemento.getChild("detalleOrden");
                if (detalleOrden != null) {
                    // Aquí asumimos que dentro de detalleOrden hay elementos <repuesto>
                    List<Element> repuestosElems = detalleOrden.getChildren("repuesto");

                    for (Element repuestoElem : repuestosElems) {
                        String repuestoId = repuestoElem.getChildText("id");
                        String nombre = repuestoElem.getChildText("nombre");
                        int cantidad = 0;
                        double precio = 0;

                        try {
                            cantidad = Integer.parseInt(repuestoElem.getChildText("cantidad"));
                        } catch (NumberFormatException e) {
                            // Manejo de error, cantidad = 0
                        }
                        try {
                            precio = Double.parseDouble(repuestoElem.getChildText("precio"));
                        } catch (NumberFormatException e) {
                            // Manejo de error, precio = 0
                        }

                        Repuesto repuesto = new Repuesto();
                        repuesto.setId(repuestoId);
                        repuesto.setNombre(nombre);
                        repuesto.setCantidad(cantidad);
                        repuesto.setPrecio(precio);

                        repuestos.add(repuesto);
                    }
                }
                break; // Ya encontramos la orden, salimos del ciclo
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return repuestos;
}

}
