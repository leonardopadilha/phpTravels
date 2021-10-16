package modulos.suite;

import modulos.usuarios.CadastrarUsuariosTest;
import modulos.usuarios.RealizarLoginTest;
import modulos.voos.ComprarVooTest;
import modulos.voos.RealizarPesquisaTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        CadastrarUsuariosTest.class,
        RealizarLoginTest.class,
        ComprarVooTest.class,
        RealizarPesquisaTest.class
})

public class SuitTest {
}
