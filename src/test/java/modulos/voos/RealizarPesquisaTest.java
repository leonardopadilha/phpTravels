package modulos.voos;

import modulos.constants.Dados;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RealizarPesquisaPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Realizar pesquisa de voo")
public class RealizarPesquisaTest {

    private WebDriver navegador;
    private RealizarPesquisaPage realizarPesquisaPage;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://phptravels.net/");
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        realizarPesquisaPage = new RealizarPesquisaPage(navegador);
    }

    @Test
    @DisplayName("Pesquisar voo apenas ida com 1 adulto")
    public void testRealizarPesquisaVooApenasIdaComUmAdulto() {
        String msgAlterarDados =
        realizarPesquisaPage
                .clicarPopUp()
                .selecionarTipoVoo()
                .selecionarTipo("One Way")
                .selecionarOrigem("BSB")
                .selecionarDestino("SAO")
                .informarDataViagem("15-11-2021")
                .clicarRealizarBusca()
                .msgAlterarDadosViagem();
        assertEquals(Dados.ALTERAR_DADOS_VIAGEM, msgAlterarDados);
    }

    @Test
    @DisplayName("Pesquisar voo apenas ida com 2 adultos")
    public void testRealizarPesquisaVooApenasIdaComDoisAdultos() {
        String msgAlterarDados = realizarPesquisaPage
                .clicarPopUp()
                .selecionarTipoVoo()
                .selecionarTipo("One Way")
                .selecionarOrigem("SSA")
                .selecionarDestino("RIO")
                .informarDataViagem("25-12-2021")
                .informarQtdAdultos("2")
                .clicarRealizarBusca()
                .msgAlterarDadosViagem();
        assertEquals(Dados.ALTERAR_DADOS_VIAGEM, msgAlterarDados);
    }

    @Test
    @DisplayName("Pesquisar voo apenas ida com 3 adultos e 3 crianças")
    public void testRealizarPesquisaVooApenasIdaComTresAdultosETresCriancas() {
        String msgAlterarDados = realizarPesquisaPage
                .clicarPopUp()
                .selecionarTipoVoo()
                .selecionarTipo("One Way")
                .selecionarOrigem("SSA")
                .selecionarDestino("RIO")
                .informarDataViagem("25-11-2021")
                .informarQtdAdultos("3")
                .informarQtdCriancas("3")
                .clicarRealizarBusca()
                .msgAlterarDadosViagem();
        assertEquals(Dados.ALTERAR_DADOS_VIAGEM, msgAlterarDados);
    }

    @AfterEach
    public void fecharNavegador() {
        navegador.quit();
    }
}
