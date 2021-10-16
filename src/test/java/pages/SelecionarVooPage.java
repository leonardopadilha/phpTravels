package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelecionarVooPage {
    private WebDriver navegador;

    public SelecionarVooPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String msgAlterarDadosViagem() {
        return navegador.findElement(By.cssSelector("div[class='card-header']")).getText();
    }

    public CheckoutVooPage selecionarVoo() {
        navegador.findElements(By.cssSelector("button[type='submit']")).get(0).click();
        return new CheckoutVooPage(navegador);
    }
}
