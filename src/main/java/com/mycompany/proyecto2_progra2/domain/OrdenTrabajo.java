package com.mycompany.proyecto2_progra2.domain;

public class OrdenTrabajo {
    
    private String id, descripcion, fechaIngreso, estado, detalleRecepcionVehiculo,
            fechaDevolucion;
    private Vehiculo vehiculo;
    private DetalleOrden detalleOrden;
    private double precio;

    public OrdenTrabajo(String id, String descripcion, String fechaIngreso, String estado, 
            String detalleRecepcionVehiculo, String fechaDevolucion, Vehiculo vehiculo, DetalleOrden detalleOrden) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.detalleRecepcionVehiculo = detalleRecepcionVehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.vehiculo = vehiculo;
        this.detalleOrden = detalleOrden;
        this.precio = this.detalleOrden.getPrecioTotal();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalleRecepcionVehiculo() {
        return detalleRecepcionVehiculo;
    }

    public void setDetalleRecepcionVehiculo(String detalleRecepcionVehiculo) {
        this.detalleRecepcionVehiculo = detalleRecepcionVehiculo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public DetalleOrden getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(DetalleOrden detalleOrden) {
        this.detalleOrden = detalleOrden;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "OrdenTrabajo{" + "id=" + id + ", descripcion=" + descripcion + ", fechaIngreso=" + fechaIngreso + ", estado=" + estado + ", detalleRecepcionVehiculo=" + detalleRecepcionVehiculo + ", fechaDevolucion=" + fechaDevolucion + ", vehiculo=" + vehiculo + ", detalleOrden=" + detalleOrden + ", precio=" + precio + '}';
    }
    
}
