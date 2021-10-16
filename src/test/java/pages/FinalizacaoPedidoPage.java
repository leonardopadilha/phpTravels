package pages;

import org.openqa.selenium.WebDriver;

public class FinalizacaoPedidoPage {
    private WebDriver navegador;

    public FinalizacaoPedidoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarMensagem() {
        return navegador.getTitle();
    }
}
