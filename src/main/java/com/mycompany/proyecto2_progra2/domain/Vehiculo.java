/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_progra2.domain;

/**
 *
 * @author jeffr
 */
public class Vehiculo {
    
    private String placa, color, marca, estilo, vin, cilindraje;
    private int annio;
    private Cliente duenno;

    public Vehiculo(String placa, String color, String marca, String estilo, String vin, String cilindraje, int annio, Cliente duenno) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.estilo = estilo;
        this.vin = vin;
        this.cilindraje = cilindraje;
        this.annio = annio;
        this.duenno = duenno;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }

    public Cliente getDuenno() {
        return duenno;
    }

    public void setDuenno(Cliente duenno) {
        this.duenno = duenno;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", color=" + color + ", marca=" + marca + ", estilo=" + estilo + ", vin=" + vin + ", cilindraje=" + cilindraje + ", annio=" + annio + ", duenno=" + duenno + '}';
    }
    
}
