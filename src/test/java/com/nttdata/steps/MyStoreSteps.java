package com.nttdata.steps;


import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MyStoreSteps {
    WebDriver driver;
    MyStorePage page;

    public MyStoreSteps(WebDriver driver){
        this.driver = driver;
        page = new MyStorePage(driver);
    }

    public void navegarA(String url){
        driver.get(url);
    }
    public void iniciarSesion(String user,String pass){
        page.registro();
        page.iniciarSesion(user,pass);
    }

    public void navegarCategorias(String categoria, String subcategoria) {
        page.navegarCategoria(categoria,subcategoria);
    }

    public void irPrimerProducto() {
        page.compraPrimerProducto();
    }

    public void compraCantidadProductos(int cantidad) {
        page.comprarProductos(cantidad);
    }


    public void agregarAlCarrito() {
        page.anadirProducto();
    }

    public void validarConfirmacion() {
        Assertions.assertNotNull(page.getTituloConfirmacionProductoAgregado(), "El título del primer producto es nulo");
        Assertions.assertFalse(page.getTituloConfirmacionProductoAgregado().trim().isEmpty(), "El título del primer producto está vacío");
        System.out.println(page.getTituloConfirmacionProductoAgregado());
    }

    public void validaPrecio(){
       float valor = page.precioUnitario() * page.cantidaProducto();
       System.out.println(valor);
       System.out.println(page.precioTotal());
       Assertions.assertEquals(valor,page.precioTotal());
    }

    public void finalizarCompra() {
        page.finalizarCompra();
    }

    public void validarTituloCarrito() {
        Assertions.assertNotNull(page.getTituloConfirmacionCarrito(), "El título del carrito es nulo");
        Assertions.assertFalse(page.getTituloConfirmacionCarrito().trim().isEmpty(), "El título del carrito está vacío");
        System.out.println(page.getTituloConfirmacionCarrito());
    }

    public void validarPreciosCarrito() {
        float valorCarrito = page.cantidaUnitarioCarrito() * page.cantidadProductoCarrito();
        System.out.println(valorCarrito);
        System.out.println(page.precioTotalCarrito());
        Assertions.assertEquals(valorCarrito,page.precioTotalCarrito());
    }
}
