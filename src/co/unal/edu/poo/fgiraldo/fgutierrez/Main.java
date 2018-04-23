/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unal.edu.poo.fgiraldo.fgutierrez;

import java.util.Date;

/**
 *
 * @author Flexxo333
 */
public class Main {
    public static void main(String[] args) {
        
        Date date = new Date();
        
        System.out.println(date);
        Administrador admin = new Administrador("Antonio", "Perez", "4490545");
        
        Panaderia elTriunfo = new Panaderia("El Triunfo", admin);
        Empleado e1 = new Empleado(1, "Juan", "P");
        Empleado e2 = new Empleado(2, "Diana", "Q");
        Empleado e3 = new Empleado(3, "Alicia", "R");
        
        System.out.println(elTriunfo.getAdmin().informacionAdmin());
        

        
        elTriunfo.crearProducto("Pan Baggette", "Harina", 1500, 1200, 0);
        elTriunfo.crearProducto("Pan Rollo", "Harina", 200, 180, 0);
        elTriunfo.anadirCantidadProducto(elTriunfo.getListaproductos().get(0), 30);
        elTriunfo.anadirCantidadProducto(elTriunfo.getListaproductos().get(1), 30);
        
        System.out.println("ANTES VENTA");
        System.out.println(elTriunfo.listarProductos());
        
//        elTriunfo.cambiarPrecioProductos(elTriunfo.getListaproductos().get(0), 1000, 5000);        
//        elTriunfo.cambiarPorcentajeDescuentoProducto(elTriunfo.getListaproductos().get(0), 1);
        
        
        
        elTriunfo.crearFactura(e3, date, "Camila");
        elTriunfo.getListafacturas().get(0).anadirVenta(elTriunfo.getListaproductos().get(0), 5, "Mayor");
        elTriunfo.getListafacturas().get(0).anadirVenta(elTriunfo.getListaproductos().get(1), 10, "Menor");
        
        elTriunfo.crearFactura(e2, date, "Andrea");
        elTriunfo.getListafacturas().get(1).anadirVenta(elTriunfo.getListaproductos().get(0), 5, "Mayor");
        elTriunfo.getListafacturas().get(1).anadirVenta(elTriunfo.getListaproductos().get(1), 15, "Menor");


        System.out.println( elTriunfo.getListafacturas().get(0).informacionFactura());
        System.out.println( elTriunfo.getListafacturas().get(1).informacionFactura());
        
        System.out.println("GANANCIAS");
        System.out.println(elTriunfo.ganaciasTotalesVentas());
        
        
        System.out.println("DESPUES VENTA");        
        System.out.println(elTriunfo.listarProductos());
        
    }
    
}
