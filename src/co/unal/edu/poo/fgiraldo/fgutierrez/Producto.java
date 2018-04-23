/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unal.edu.poo.fgiraldo.fgutierrez;

/**
 *
 * @author Flexxo333
 */
public class Producto {
    private int id;
    private String nombre;
    private String tipo;
    private double precioBaseUnidad;
    private double precioBasePorMayor;
    private double precioConDctoBaseUnidad;
    private double precioConDctoBasePorMayor;
    private int cantidad;
    private int porcentajeOferta;

    public Producto(String nombre, String tipo, double precioBaseUnidad, double precioBasePorMayor, int prcjOferta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.porcentajeOferta = prcjOferta;
        this.precioBaseUnidad = precioBaseUnidad;
        this.precioBasePorMayor = precioBasePorMayor;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioBaseUnidad() {
        return precioBaseUnidad;
    }

    public void setPrecioBaseUnidad(double precioBaseUnidad) {
        this.precioBaseUnidad = precioBaseUnidad;
    }

    public double getPrecioBasePorMayor() {
        return precioBasePorMayor;
    }

    public void setPrecioBasePorMayor(double precioBasePorMayor) {
        this.precioBasePorMayor = precioBasePorMayor;
    }

    public int getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(int porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    public double getPrecioConDctoBaseUnidad() {
        return precioConDctoBaseUnidad;
    }

    public void setPrecioConDctoBaseUnidad(double precioConDctoBaseUnidad) {
        this.precioConDctoBaseUnidad = precioConDctoBaseUnidad;
    }

    public double getPrecioConDctoBasePorMayor() {
        return precioConDctoBasePorMayor;
    }

    public void setPrecioConDctoBasePorMayor(double precioConDctoBasePorMayor) {
        this.precioConDctoBasePorMayor = precioConDctoBasePorMayor;
    }    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String informacionProducto(){
        return "Id: " + this.id +" Nombre: " + this.getNombre() + " Tipo: " + this.getTipo() + " Precio unitario base: "+ this.getPrecioBaseUnidad() +
                " Precio por mayor base: "+ this.getPrecioBasePorMayor()+" Cantidad: " + this.getCantidad() + " Porcentaje oferta: "+ this.getPorcentajeOferta() +
                " Precio unidad con descuento: "+ this.getPrecioConDctoBaseUnidad() + " Precio al mayor con descuento: " + this.getPrecioConDctoBasePorMayor();
    };
    
    
    
    
}
