package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarMensagemCadastro() {
        return navegador.getTitle();
    }

    public LoginPage informarEmail(String email) {
        navegador.findElement(By.cssSelector("input[type='Email']")).sendKeys(email);
        return this;
    }

    public LoginPage informarSenha(String senha) {
        navegador.findElement(By.cssSelector("input[type='Password']")).sendKeys(senha);
        return this;
    }

    public DashboardPage clicarBotaoLoginComSucesso() {
        navegador.findElements(By.cssSelector("button[type='submit']")).get(0).click();
        return new DashboardPage(navegador);
    }

    public LoginPage clicarBotaoLoginDadosInvalidos() {
        navegador.findElements(By.cssSelector("button[type='submit']")).get(0).click();
        return this;
    }

    public String msgLoginInvalido() {
        return navegador.findElement(By.cssSelector("div > h5 + p")).getText();
    }
}

