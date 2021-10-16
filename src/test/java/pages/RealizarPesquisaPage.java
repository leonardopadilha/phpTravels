package pages;

import modulos.usuarios.RealizarLoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RealizarPesquisaPage {
    private WebDriver navegador;

    public RealizarPesquisaPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CadastrarUsuarioPage clickSignUp() {
        navegador.findElement(By.partialLinkText("Signup")).click();
        return new CadastrarUsuarioPage(navegador);
    }

    public RealizarPesquisaPage clicarPopUp() {
        navegador.findElements(By.id("cookie_stop")).get(0).click();
        return this;
    }

    public RealizarPesquisaPage selecionarTipoVoo() {
        navegador.findElement(By.cssSelector("ul[id='Tab'] > li[data-position='2']")).click();
        return this;
    }

    public RealizarPesquisaPage selecionarOrigem(String partida) {
        WebElement origem = navegador.findElement(By.cssSelector("input[placeholder='Flying From']"));
        origem.click();
        origem.clear();
        origem.sendKeys(partida, Keys.TAB);
        return this;
    }

    public RealizarPesquisaPage selecionarDestino(String chegada) {
        WebElement destino = navegador.findElement(By.cssSelector("input[placeholder='To Destination']"));
        destino.click();
        destino.clear();
        destino.sendKeys(chegada, Keys.TAB);
        return this;
    }

    public RealizarPesquisaPage informarDataViagem(String dataViagem) {
        navegador.findElements(By.cssSelector("input[id='departure']")).get(0).sendKeys(dataViagem);
        return this;
    }

    public RealizarPesquisaPage selecionarTipo(String tipoViagem){
        if (tipoViagem.equalsIgnoreCase("Round Trip") ||
                tipoViagem.equalsIgnoreCase("round trip")) {
            navegador.findElements(By.id("round-trip")).get(0).click();
        }else {
            navegador.findElements(By.id("one-way")).get(0).click();
        } return this;
    }

    public SelecionarVooPage clicarRealizarBusca() {
        navegador.findElements(By.id("flights-search")).get(0).click();
        return new SelecionarVooPage(navegador);
    }

    public LoginPage clicarLogin() {
        navegador.findElement(By.partialLinkText("Login")).click();
        return new LoginPage(navegador);
    }

    public RealizarPesquisaPage informarQtdAdultos(String qtdAdultos) {
        WebElement qtdAdulto = navegador.findElement(By.cssSelector("span[class='guest_flights d-block text-center']"));
        qtdAdulto.click();
        qtdAdulto = navegador.findElement(By.cssSelector("input[id='fadults']"));
        qtdAdulto.clear();
        qtdAdulto.sendKeys(qtdAdultos);
        return this;
    }

    public RealizarPesquisaPage informarQtdCriancas(String qtdCriancas) {
        WebElement qtdAdulto = navegador.findElement(By.cssSelector("span[class='guest_flights d-block text-center']"));
        qtdAdulto.click();
        qtdAdulto = navegador.findElement(By.cssSelector("input[id='fchilds']"));
        qtdAdulto.clear();
        qtdAdulto.sendKeys(qtdCriancas);
        return this;
    }

    public RealizarPesquisaPage selecionarIdiomaIngles() {
        navegador.findElement(By.cssSelector("div > button")).click();
        navegador.findElement(By.cssSelector("ul[class='dropdown-menu show'] > li:nth-child(7)")).click();
        return this;
    }
}
