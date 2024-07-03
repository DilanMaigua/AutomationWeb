package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyStorePage {
    private WebDriver driver;
    private By btnIniciarsesionRegistro = By.xpath("//body[1]/main[1]/header[1]/nav[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[1]/span[1]");
    private By txtCorreo = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/section[1]/form[1]/div[1]/div[1]/div[1]/input[1]");
    private By txtContrasenia = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/section[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
    private By btnIniciarSesion = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/section[1]/form[1]/footer[1]/button[1]");
    private By btnClothes = By.xpath("//body[1]/main[1]/header[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private By btnMen = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
    private By btnProducto = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
    private By btnSumarProducto = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/span[3]/button[1]/i[1]");
    private By btnAgregarCarrito = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]");
    private By txtConfirmacionAgreadoProducto = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/h4[1]");
    private By txtPrecioUnitario = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[1]");
    private By txtCantidad = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/span[3]/strong[1]");
    private By txtPrecioTotal = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/p[4]/span[2]");
    private By btnFinalizarCompra = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");
    private By txtTituloCarrito = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/h1[1]");
    private By txtConfirmacionPrecioUnitario = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/div[2]/span[1]");
    private By txtConfirmacionPrecioTotal = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
    private By txtConfimacionCantidad = By.xpath("//body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]");
    private WebDriverWait wait;


    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void registro() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnIniciarsesionRegistro));
        WebElement botonRegistro = driver.findElement(btnIniciarsesionRegistro);
        botonRegistro.click();
    }

    public void iniciarSesion(String usuario, String contra) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCorreo));

        WebElement ingresarUser = driver.findElement(txtCorreo);
        ingresarUser.sendKeys(usuario);

        WebElement ingresarContra = driver.findElement(txtContrasenia);
        ingresarContra.sendKeys(contra);

        WebElement botonIniciarSesion = driver.findElement(btnIniciarSesion);
        botonIniciarSesion.click();
    }


    public void navegarCategoria(String categoria, String subcategoria) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnClothes));
        WebElement botonCategoria = driver.findElement(btnClothes);
        botonCategoria.click();

        WebElement botonSubCategoria = driver.findElement(btnMen);
        botonSubCategoria.click();
    }

    public void compraPrimerProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProducto));
        WebElement botonPrimerProducto = driver.findElement(btnProducto);
        botonPrimerProducto.click();
    }

    public void comprarProductos(int cantidad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSumarProducto));
        WebElement botonSumarProducto = driver.findElement(btnSumarProducto);
        for (int i = 0; i < cantidad - 1; i++) {
            botonSumarProducto.click();
        }
    }

    public void anadirProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAgregarCarrito));
        WebElement botonAnadirProducto = driver.findElement(btnAgregarCarrito);
        botonAnadirProducto.click();
    }

    public String getTituloConfirmacionProductoAgregado() {
        WebElement primerElemento;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmacionAgreadoProducto));
            primerElemento = driver.findElement(txtConfirmacionAgreadoProducto);
            return primerElemento.getText();
        } catch (Exception e) {
            return "No se pudo obtener el texto";
        }

        }

    public float precioUnitario(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPrecioUnitario));
        WebElement valorUnitario = driver.findElement(txtPrecioUnitario);
        String textoValorUnitario = valorUnitario.getText();
        float valorNumericoUnitario = extraerValorNumerico(textoValorUnitario);
        return valorNumericoUnitario;
    }

    public float cantidaProducto(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtCantidad));
        WebElement valorCantidad = driver.findElement(txtCantidad);
        String textoCantidad = valorCantidad.getText();
        float valorNumericoCantidad = extraerValorNumerico(textoCantidad);
        return valorNumericoCantidad;
    }

    public float precioTotal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPrecioTotal));
        WebElement valorTotal = driver.findElement(txtPrecioTotal);
        String textoPrecioTotal = valorTotal.getText();
        float valorNumericoTotal = extraerValorNumerico(textoPrecioTotal);
        return valorNumericoTotal;
    }




    public void finalizarCompra() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnFinalizarCompra));
        WebElement botonFinalizarCompra = driver.findElement(btnFinalizarCompra);
        botonFinalizarCompra.click();
    }

    public String getTituloConfirmacionCarrito() {
        WebElement Titulo;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txtTituloCarrito));
            Titulo = driver.findElement(txtTituloCarrito);
            return Titulo.getText();
        } catch (Exception e) {
            return "No se pudo obtener el texto";
        }
    }


    public float cantidadProductoCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfimacionCantidad));
        WebElement valorCantidadCarrito = driver.findElement(txtConfimacionCantidad);
        String textoCantidadCarrito = valorCantidadCarrito.getText();
        int cantidadArticulos = extraerCantidadArticulos(textoCantidadCarrito);
        return cantidadArticulos;
    }


    public float cantidaUnitarioCarrito(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmacionPrecioUnitario));
        WebElement valorUnitarioCarrito = driver.findElement(txtConfirmacionPrecioUnitario);
        String textoCantidad = valorUnitarioCarrito.getText();
        float valorNumericoUnitario = extraerValorNumerico(textoCantidad);
        return valorNumericoUnitario;
    }

    public float precioTotalCarrito(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmacionPrecioTotal));
        WebElement valorTotalCarrito = driver.findElement(txtConfirmacionPrecioTotal);
        String textoPrecioTotal = valorTotalCarrito.getText();
        float valorNumericoTotal = extraerValorNumerico(textoPrecioTotal);
        return valorNumericoTotal;
    }


    private float extraerValorNumerico(String texto) {
        String valorNumericoStr = texto.replace("S/ ", "").trim();
        return Float.parseFloat(valorNumericoStr);
    }

    private int extraerCantidadArticulos(String texto) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            String numeroStr = matcher.group();
            return Integer.parseInt(numeroStr);
        } else {
            return 0;
        }
    }

}
