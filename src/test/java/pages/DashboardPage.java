package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver navegador;

    public DashboardPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String conferirMensagemBoasVindas() {
        return navegador.findElement(By.cssSelector("span[class='author__meta']")).getText();
    }
}
