package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CheckoutVooPage {
    private WebDriver navegador;

    public CheckoutVooPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CheckoutVooPage informarNomePassageiro(String nome){
        navegador.findElement(By.name("firstname")).sendKeys(nome);
        return this;
    }

    public CheckoutVooPage informarSobrenomePassageiro(String sobrenome) {
        navegador.findElement(By.name("lastname")).sendKeys(sobrenome);
        return this;
    }

    public CheckoutVooPage informarEmailPassageiro(String email) {
        navegador.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public CheckoutVooPage informarTelefonePassageiro(String telefone) {
        navegador.findElement(By.name("phone")).sendKeys(telefone);
        return this;
    }

    public CheckoutVooPage informarEnderecoPassageiro(String endereco) {
        navegador.findElement(By.name("address")).sendKeys(endereco);
        return this;
    }

    public CheckoutVooPage selecionarPais(){
        navegador.findElement(By.cssSelector("span[class='select2-selection select2-selection--single'] span")).click();
        navegador.findElements(By.cssSelector("span[class='select2-results'] > ul > li")).get(32).click();
        return this;
    }

    public CheckoutVooPage selecionarNacionalidade(String nacionalidade) {
        navegador.findElements(By.cssSelector("span[class='select2-selection select2-selection--single'] span")).get(2).click();
        navegador.findElement(By.cssSelector("span[class='select2-search select2-search--dropdown'] input")).sendKeys(nacionalidade, Keys.ENTER);
        return this;
    }

    public CheckoutVooPage informarNomeViajante(String nomeViajante) {
        navegador.findElement(By.name("firstname_1")).sendKeys(nomeViajante);
        return this;
    }

    public CheckoutVooPage informarSobrenomeViajante(String sobrenomeViajante) {
        navegador.findElement(By.name("lastname_1")).sendKeys(sobrenomeViajante);
        return this;
    }

    public CheckoutVooPage selecionarNacionalidadeViajante(String nacionalidade) {
        WebElement combo = navegador.findElement(By.name("nationality_1"));
        Select comboNacionalidadeViajante = new Select(combo);
        comboNacionalidadeViajante.selectByVisibleText(nacionalidade);
        return this;
    }

    public CheckoutVooPage mesAniversario(String mes) {
        WebElement combo = navegador.findElement(By.name("dob_month_1"));
        Select comboMesAniversario = new Select(combo);
        comboMesAniversario.selectByVisibleText(mes);
        return this;
    }

    public CheckoutVooPage informarDiaNascimento(String dia) {
        navegador.findElement(By.name("dob_day_1")).sendKeys(dia);
        return this;
    }

    public CheckoutVooPage informarAnoNascimento(String ano) {
        navegador.findElement(By.name("dob_year_1")).sendKeys(ano);
        return this;
    }

    public CheckoutVooPage informarNumeroPassaporte(String numero) {
        navegador.findElement(By.name("passport_1")).sendKeys(numero);
        return this;
    }

    public CheckoutVooPage informarMesPassaporte(String mes) {
        WebElement mesPassaporte = navegador.findElement(By.name("passport_month_1"));
        Select comboMesPassaporte = new Select(mesPassaporte);
        comboMesPassaporte.selectByVisibleText(mes);
        return this;
    }

    public CheckoutVooPage informarDiaPassaporte(String dia) {
        navegador.findElement(By.name("passport_day_1")).sendKeys(dia);
        return this;
    }

    public CheckoutVooPage informarAnoPassaporte(String ano) {
        navegador.findElement(By.name("passport_year_1")).sendKeys(ano);
        return this;
    }

    public CheckoutVooPage selecionarTipoPagamento() {
        WebElement radio = navegador.findElements(By.name("payment_gateway")).get(0);
        JavascriptExecutor clickCheck = (JavascriptExecutor) navegador;
        clickCheck.executeScript("arguments[0].click()", radio);
        return this;
    }

    public CheckoutVooPage aceitarTermos() {
        WebElement check = navegador.findElement(By.cssSelector("input[type='checkbox'] + label"));
        JavascriptExecutor clickCheck = (JavascriptExecutor) navegador;
        clickCheck.executeScript("arguments[0].click()", check);
        return this;
    }

    public FinalizacaoPedidoPage clickBotaoFinalizarPedido() {
        navegador.findElement(By.cssSelector("button[type='submit']")).submit();
        return new FinalizacaoPedidoPage(navegador);
    }
}
