package login;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

class LoginTest {
    private String email;
    private String senha;


    @Test
    @DisplayName("O sistema não permite logar sem preencher os campos obrigatórios")
    public void testNaoEPermitidoCampoSemPreenchimento() {

        //Abrir o Navegador

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\ChomeDriver\\91\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Comando para Maximizar a tela
        navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrao de 5 segundos
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Verifivar a pagina de login do site da BLIP

        navegador.get("https://app.testdome.com/t/aa8c5f362b9e44e1876eedd84d0b023c");


        //Fazer Login
        navegador.findElement(By.id("Email")).sendKeys("");
        navegador.findElement(By.id("senha")).sendKeys("");
        navegador.findElement(By.cssSelector("button")).click();

        String mensagenToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();

        Assertions.assertEquals("Favor preencher os campo obrigatórios", mensagenToast);

        //Vou fechar o navegador

        navegador.quit();




    }



}