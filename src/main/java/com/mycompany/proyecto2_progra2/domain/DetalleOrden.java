package com.mycompany.proyecto2_progra2.domain;

import java.util.ArrayList;

public class DetalleOrden {

    private String id, observaciones;
    private double manoObra, precioTotal;
    private ArrayList<Repuesto> repuestos;

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

    @Override
    public String toString() {
        return "DetalleOrden{" + "id=" + id + ", observaciones=" + observaciones + ", manoObra=" + manoObra + ", precioTotal=" + precioTotal + ", repuestos=" + repuestos + '}';
    }
    
    

}
