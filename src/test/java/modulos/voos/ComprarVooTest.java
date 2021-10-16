package modulos.voos;

import com.github.javafaker.Faker;
import modulos.constants.Dados;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RealizarPesquisaPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ComprarVooTest {
    private WebDriver navegador;
    private RealizarPesquisaPage realizarPesquisaPage;

    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String phone = String.valueOf(faker.phoneNumber());
    private String email = faker.internet().emailAddress();
    private String address = String.valueOf(faker.address());

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
    @DisplayName("Selecionar idioma inglês")
    public void testSelecionarIngles() {

    }

    @Test
    @DisplayName("Realizar compra de voo")
    public void testRealizarCompraDeVoo() {
        String tituloAba =
                realizarPesquisaPage
                .clicarPopUp()
                .selecionarIdiomaIngles()
                .selecionarTipoVoo()
                .selecionarTipo("One Way")
                .selecionarOrigem("SAO")
                .selecionarDestino("LON")
                .informarDataViagem("15-01-2022")
                .informarQtdAdultos("1")
                .clicarRealizarBusca()
                .selecionarVoo()
                .informarNomePassageiro(firstName)
                .informarSobrenomePassageiro(lastName)
                .informarEmailPassageiro(email)
                .informarTelefonePassageiro(phone)
                .informarEnderecoPassageiro(address)
                .selecionarPais()
                .selecionarNacionalidade("Brazil")
                .informarNomeViajante(firstName)
                .informarSobrenomeViajante(lastName)
                .selecionarNacionalidadeViajante("Brazil")
                .mesAniversario("October")
                .informarDiaNascimento("31")
                .informarAnoNascimento("1955")
                .informarNumeroPassaporte("1234567898")
                .informarMesPassaporte("August")
                .informarDiaPassaporte("10")
                .informarAnoPassaporte("2025")
                .selecionarTipoPagamento()
                .aceitarTermos()
                .clickBotaoFinalizarPedido()
                .capturarMensagem();
        assertEquals(Dados.FLIGHT_INVOICE, tituloAba);
    }

    @AfterEach
    public void fecharNavegador() {
        navegador.quit();
    }
}
