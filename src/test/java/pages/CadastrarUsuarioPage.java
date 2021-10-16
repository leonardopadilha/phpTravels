package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioPage {
    private WebDriver navegador;

    public CadastrarUsuarioPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CadastrarUsuarioPage informarNome(String nome) {
        navegador.findElement(By.cssSelector("input[name='first_name']")).sendKeys(nome);
        return this;
    }

    public CadastrarUsuarioPage informarSobrenome(String sobrenome) {
        navegador.findElement(By.cssSelector("input[name='last_name']")).sendKeys(sobrenome);
        return this;
    }

    public CadastrarUsuarioPage informarNumeroTelefone(String telefone) {
        navegador.findElement(By.cssSelector("input[name='phone']")).sendKeys(telefone);
        return this;
    }

    public CadastrarUsuarioPage informarEmail(String email) {
        navegador.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        return this;
    }

    public LoginPage informarSenha(String senha) {
        navegador.findElement(By.cssSelector("input[name='password']")).sendKeys(senha, Keys.ENTER);
        return new LoginPage(navegador);
    }
}
