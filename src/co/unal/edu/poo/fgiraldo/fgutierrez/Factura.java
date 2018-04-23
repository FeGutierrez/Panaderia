/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unal.edu.poo.fgiraldo.fgutierrez;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Flexxo333
 */
public class Factura {
    
    private int id;
    private Empleado empleado;
    private ArrayList<Venta> listaventas;
    private Date fechaFactura;
    private double precioFinal;
    private String cliente;

    public Factura(Empleado empleado, Date fechaFactura, String cliente) {
        this.empleado = empleado;
        this.listaventas = new ArrayList<>();
        this.fechaFactura = fechaFactura;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Venta> getListaventas() {
        return listaventas;
    }

    public void setListaventas(ArrayList<Venta> listaventas) {
        this.listaventas = listaventas;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
        
    public boolean anadirVenta(Producto producto, int cantidad, String tipoVenta){
        Venta venta = new Venta(producto, cantidad, tipoVenta);
        if ((producto.getCantidad()-cantidad)<0 ) {
            return false;
        }
        if (tipoVenta.equals("Mayor") || tipoVenta.equals("mayor") || tipoVenta.equals("MAYOR")) {
            venta.setSubTotal(producto.getPrecioConDctoBasePorMayor()*cantidad);
        }
        if (tipoVenta.equals("Menor") || tipoVenta.equals("menor") || tipoVenta.equals("MENOR")) {
            venta.setSubTotal(producto.getPrecioConDctoBaseUnidad()*cantidad);
        }
        producto.setCantidad(producto.getCantidad()-cantidad);
        this.listaventas.add(venta);
        return true;
    }
    
    public double montoTotalFactura(){
        double tot = 0;
        for (int i = 0; i < this.listaventas.size(); i++) {
            tot += this.listaventas.get(i).getSubTotal();
        }
        this.setPrecioFinal(tot);
        return this.getPrecioFinal();
    }
    
    public String informacionFactura(){
        String a = "\nInfo factura: " + "Cliente: "+ this.getCliente() +"\n";
        
        for (int i = 0; i < this.listaventas.size(); i++) {
            double precioFacturado = 0;
            if (this.listaventas.get(i).getTipoVenta().equals("Mayor") || this.listaventas.get(i).getTipoVenta().equals("mayor") || this.listaventas.get(i).getTipoVenta().equals("MAYOR")) {
                precioFacturado = this.listaventas.get(i).getProducto().getPrecioConDctoBasePorMayor();
            }
            if (this.listaventas.get(i).getTipoVenta().equals("Menor") || this.listaventas.get(i).getTipoVenta().equals("menor") || this.listaventas.get(i).getTipoVenta().equals("MENOR")) {
                precioFacturado = this.listaventas.get(i).getProducto().getPrecioConDctoBaseUnidad();
            }
            this.montoTotalFactura();
            a += "Producto vendido: " +this.listaventas.get(i).getProducto().getNombre() +" Precio de venta: " +  precioFacturado + " Cantidad vendida: " + this.listaventas.get(i).getCantidad() + " Tipo venta: "+ this.listaventas.get(i).getTipoVenta()
                    + " Subtotal: "+ this.listaventas.get(i).getSubTotal() + "\n";
        }
        return a + " \nPrecio total: " + this.getPrecioFinal();
    }
    
}
