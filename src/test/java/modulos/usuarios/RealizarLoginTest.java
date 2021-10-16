package modulos.usuarios;

import modulos.constants.Dados;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RealizarPesquisaPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Realizar Login com sucesso")
public class RealizarLoginTest {
    private WebDriver navegador;
    private LoginPage loginPage;
    private RealizarPesquisaPage realizarLogin;
    private String email = "teste.teste@teste.com";
    private String senha = "12345";

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://phptravels.net/");
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        realizarLogin = new RealizarPesquisaPage(navegador);
    }

    @Test
    @DisplayName("Realizar Login")
    public void testRealizarLogin() {
        String mensagemBoasVindas = realizarLogin
                .clicarPopUp()
                .clicarLogin()
                .informarEmail(email)
                .informarSenha(senha)
                .clicarBotaoLoginComSucesso()
                .conferirMensagemBoasVindas();
        assertEquals(Dados.MENSAGEM_BOAS_VINDAS, mensagemBoasVindas);
    }

    @Test
    @DisplayName("Informar dados inválidos no login")
    public void testInformarDadosInvalidosLogin() {
       String msgDadosInvalidos = realizarLogin
                .clicarPopUp()
                .clicarLogin()
                .informarEmail("fasfsda@fafd.com")
                .informarSenha("jfçkjah5")
                .clicarBotaoLoginDadosInvalidos()
                .msgLoginInvalido();
       assertEquals(Dados.DADOS_INVALIDOS_PARA_LOGIN, msgDadosInvalidos);
    }

    @AfterEach
    public void fecharNavegador() {
        navegador.quit();
    }

}

