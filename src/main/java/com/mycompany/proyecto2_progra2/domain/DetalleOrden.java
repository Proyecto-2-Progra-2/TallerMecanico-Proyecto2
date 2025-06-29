package com.mycompany.proyecto2_progra2.domain;

import java.util.ArrayList;

public class DetalleOrden {

    private String id, observaciones;
    private double manoObra, precioTotal;
    private ArrayList<Repuesto> repuestos;
    private ArrayList<Servicio> servicios;  // nuevo atributo para servicios

    public DetalleOrden(String id, String observaciones, double manoObra, ArrayList<Repuesto> repuestos, ArrayList<Servicio> servicios) {
        this.id = id;
        this.observaciones = observaciones;
        this.repuestos = repuestos;
        this.servicios = servicios;
        this.manoObra = manoObra;
        this.precioTotal = calcularPrecioTotal();
    }

    public DetalleOrden() {
        this.repuestos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }
public DetalleOrden(String id, String observaciones, double manoObra, ArrayList<Repuesto> repuestos) {
    this.id = id;
    this.observaciones = observaciones;
    this.manoObra = manoObra;
    this.repuestos = repuestos;
    this.precioTotal = calcularPrecioTotal();
}


   private double calcularPrecioTotal() {
    double precioTotalCalculado = 0;
    
    if (this.repuestos != null) {
        for (Repuesto repuesto : this.repuestos) {
            precioTotalCalculado += repuesto.getPrecio();
        }
    }
    
    return precioTotalCalculado + this.manoObra;
}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getManoObra() {
        return manoObra;
    }

    public void setManoObra(double manoObra) {
        this.manoObra = manoObra;
    }

    public double getPrecioTotal() {
        // recalcular total antes de devolver
        this.precioTotal = calcularPrecioTotal();
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList<Repuesto> getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(ArrayList<Repuesto> repuestos) {
        this.repuestos = repuestos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" + "id=" + id + ", observaciones=" + observaciones + ", manoObra=" + manoObra +
               ", precioTotal=" + precioTotal + ", repuestos=" + repuestos + ", servicios=" + servicios + '}';
    }
<<<<<<< HEAD
    
}
=======
}
>>>>>>> 555b2b8c19e16bb7f743b704ae6994a667e49b08
