package modulos.usuarios;

import com.github.javafaker.Faker;
import modulos.constants.Dados;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RealizarPesquisaPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cadastrar Usuários")
public class CadastrarUsuariosTest{
    private WebDriver navegador;
    private RealizarPesquisaPage realizarPesquisaPage;

    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phone = String.valueOf(faker.phoneNumber());
    private String email = faker.internet().emailAddress();
    private String senha = "12345";


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navegador.get("https://phptravels.net/");
        realizarPesquisaPage = new RealizarPesquisaPage(navegador);
    }

    @Test
    @DisplayName("Cadastrar novo usuário utilizando a API Faker sem selecionar tipo de conta")
    public void testCadastrarUsuarioSemSelecionarTipoConta() {
        String msgCadastroComSucesso = realizarPesquisaPage
                .clicarPopUp()
                .clickSignUp()
                .informarNome(firstName)
                .informarSobrenome(lastName)
                .informarNumeroTelefone(phone)
                .informarEmail(email)
                .informarSenha(senha)
                .capturarMensagemCadastro();
        assertEquals(Dados.TITULO_ABA_LOGIN, msgCadastroComSucesso);
    }

    @AfterEach
    public void fecharNavegador() {
        navegador.quit();
    }
}
