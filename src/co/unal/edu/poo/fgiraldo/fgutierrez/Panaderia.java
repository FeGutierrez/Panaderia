/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unal.edu.poo.fgiraldo.fgutierrez;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Flexxo333
 */
public class Panaderia {
    
    private String nombre;
    private ArrayList<Producto> listaproductos;
    private ArrayList<Factura> listafacturas;
    private Administrador admin;

    public Panaderia(String nombre, Administrador admin) {
        this.nombre = nombre;
        this.admin = admin;
        this.listaproductos = new ArrayList<>();
        this.listafacturas = new ArrayList<>();
    }    
    
    public ArrayList<Producto> getListaproductos() {
        return listaproductos;
    }

    public ArrayList<Factura> getListafacturas() {
        return listafacturas;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean anadirCantidadProducto(Producto producto, int cantidad){
        producto.setCantidad(producto.getCantidad()+cantidad);
        return true;
    }
    
    public boolean crearProducto(String nombre, String tipo, double precioUnidad, double precioPorMayor, int prcOferta){
        Producto p = new Producto(nombre, tipo, precioUnidad, precioPorMayor, prcOferta);
        p.setId(this.listaproductos.size()+1);
        if (prcOferta!=0) {
            p.setPrecioConDctoBaseUnidad(precioUnidad - ((precioUnidad/100)*prcOferta));
            p.setPrecioConDctoBasePorMayor(precioPorMayor - ((precioPorMayor/100)*prcOferta));
        }
        if (prcOferta==0) {
            p.setPrecioConDctoBaseUnidad(precioUnidad);
            p.setPrecioConDctoBasePorMayor(precioPorMayor);
        }   
        this.listaproductos.add(p);
        return true;
    }
    
    public boolean eliminarProducto (Producto producto){
        if (this.listaproductos.contains(producto)) {
            this.listaproductos.remove(producto);
            return true;
        }
        return false;
    }
    
    public String listarProductos(){
        String info = "\nInformación de los productos registrados: \n";
        for (int i = 0; i < this.listaproductos.size(); i++) {
            info += this.listaproductos.get(i).informacionProducto() + "\n"; 
        }
        return info;
    }
    
    public boolean cambiarPrecioProductos(Producto producto, double precioUnitario, double PrecioMayor){
        producto.setPrecioBaseUnidad(precioUnitario);
        producto.setPrecioBasePorMayor(PrecioMayor);
        producto.setPrecioConDctoBaseUnidad(producto.getPrecioBaseUnidad() - (producto.getPrecioBaseUnidad()/100)*producto.getPorcentajeOferta());
        producto.setPrecioConDctoBasePorMayor(producto.getPrecioBasePorMayor() - (producto.getPrecioBasePorMayor()/100)*producto.getPorcentajeOferta());
        return true;
    }
    
    public boolean cambiarPorcentajeDescuentoProducto(Producto producto, int porcentaje){
        producto.setPorcentajeOferta(porcentaje);
        if (porcentaje==0) {
            producto.setPrecioConDctoBaseUnidad(producto.getPrecioBaseUnidad());
            producto.setPrecioConDctoBasePorMayor(producto.getPrecioBasePorMayor());
        } else {
            producto.setPrecioConDctoBaseUnidad(producto.getPrecioBaseUnidad() - (producto.getPrecioBaseUnidad()/100)*porcentaje);
            producto.setPrecioConDctoBasePorMayor(producto.getPrecioBasePorMayor() - (producto.getPrecioBasePorMayor()/100)*porcentaje);
        }
        
        
        return true;
    }
    
    public boolean crearFactura(Empleado empleado, Date date, String cliente){
        Factura factura = new Factura(empleado, date, cliente);
        this.listafacturas.add(factura);
        return true;
    }
    
    public double ganaciasTotalesVentas(){
        double a = 0;
        for (int i = 0; i < this.listafacturas.size(); i++) {
            a += this.listafacturas.get(i).getPrecioFinal();
        }
        return a;
    }
    
    public double gananciasDelMes(int mes){
        double a = 0;
        
        for (int i = 0; i < this.listafacturas.size(); i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.listafacturas.get(i).getFechaFactura());
            if (calendar.get(calendar.MONTH)==mes) {
                a += this.listafacturas.get(i).getPrecioFinal();                
            }           
            
        }
        return a;
    }
//    
//        public Date sumarDias(Date fecha, int dias){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(fecha);
//        calendar.add(Calendar.DAY_OF_YEAR, dias);
//        return calendar.getTime();
//    }
//    
//    public Date sumarHoras(Date fecha, int horas){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(fecha);
//        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)+ horas);        
//        return calendar.getTime();
//    }
//    
//    public void fechaFinalDeDevolucion(Date fecha, Copia copia){
//        fecha = this.fechaPrestamo;
//        int horas = copia.getLibro().getCategoria().getHorasPrestamo();
//        Date fechaFinal = sumarHoras(fecha, horas);
//        setFechaDevolucion(fechaFinal);        
//    }
    
    
}
