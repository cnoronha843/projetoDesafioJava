import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class TesteElementos {

    //    @BeforeClass
    @Test
    public void textBox() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/text-box");
        Navegador.getNavegadorAberto ().acessarSite ();
        String nome = "Carlos André Trigueiro Noronha Santanna";
        String email = "carlosanoronha@hotmail.com";
        String currentAddress = "Rua Farmamceutico Reinaldo Pfau";
        String permanentAddress = "Rua Van Erven";

        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("userName")).sendKeys (nome);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("userEmail")).sendKeys (email);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("currentAddress")).sendKeys (currentAddress);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("permanentAddress")).sendKeys (permanentAddress);
        Thread.sleep (2000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("userForm")).findElement (By.id ("submit")).click ();

//        System.out.println(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("output")).findElement(By.id("currentAddress")).getText().substring(17) +
//                Navegador.getNavegadorAberto().instanciaChrome().findElement(By.id("output")).findElement(By.id("permanentAddress")).getText().substring(20));
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("output")).findElement (By.id ("name")).getText ().substring (5).equals (nome) &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("output")).findElement (By.id ("email")).getText ().substring (6).equals (email) &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("output")).findElement (By.id ("currentAddress")).getText ().substring (17).equals (currentAddress) &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("output")).findElement (By.id ("permanentAddress")).getText ().substring (20).equals (permanentAddress));

    }

    @Test
    public void checkbox() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/checkbox");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.className ("rct-icon-expand-close")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//label[@for='tree-node-desktop']//span[@class='rct-node-icon']")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//span[contains(text(),'Documents')]")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//span[contains(text(),'Downloads')]")).click ();
        Thread.sleep (1000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[@id='result']/span[2]")).getText ().equals ("home"));
        // check box marcado = //label[@for='tree-node-home']//span[@class='rct-checkbox']
        //      Check box desmarcado = //label[@for='tree-node-home']//span[@class='rct-checkbox']


    }

    @Test
    public void radioButton() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/radio-button");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[@id='app']/div/div/div[2]/div[2]/div/div[3]/label")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[@id='app']/div/div/div[2]/div[2]/div/div[4]/label")).click ();
        Thread.sleep (1000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//span[@class='text-success']")).getText ().equals ("Impressive"));
    }

    @Test
    public void webTables() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/webtables");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//span[@id='delete-record-1']//*[name()='svg']//*[name()='path' and contains(@d,'M864 256H7')]")).click ();
        Thread.sleep (1000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Alden']")).getText () != "Cierra");
    }

    @Test
    public void webTablesEdit() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/webtables");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//span[@id='edit-record-2']//*[name()='svg']//*[name()='path' and contains(@d,'M880 836H1')]")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='firstName']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='firstName']")).sendKeys ("Carlos André");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='submit']")).click ();
        Thread.sleep (1000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Carlos André']")).getText ().equals ("Carlos André"));
    }

    @Test
    public void webTablesAdd() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/webtables");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='addNewRecordButton']")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='firstName']")).sendKeys ("Carlos André");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='lastName']")).sendKeys ("Noronha");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='userEmail']")).sendKeys ("carlosanoronha@hotmail.com");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='age']")).sendKeys ("33");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='salary']")).sendKeys ("1500");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='department']")).sendKeys ("QA");
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='submit']")).click ();
        Thread.sleep (1000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Carlos André']")).getText ().equals ("Carlos André"));
    }

    @Test
    public void webTablesBuscaCampos() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/webtables");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("Alden");
        Thread.sleep (1000);
        Assert.assertEquals ("Alden", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Alden']")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("Cantrell");
        Thread.sleep (1000);
        Assert.assertEquals ("Cantrell", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Cantrell']")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("45");
        Thread.sleep (1000);
        Assert.assertEquals ("45", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='45']")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("alden@example.com");
        Thread.sleep (1000);
        Assert.assertEquals ("alden@example.com", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='alden@example.com']")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("12000");
        Thread.sleep (1000);
        Assert.assertEquals ("12000", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='12000']")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).clear ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//input[@id='searchBox']")).sendKeys ("Compliance");
        Thread.sleep (1000);
        Assert.assertEquals ("Compliance", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//div[normalize-space()='Compliance']")).getText ());//
    }

    @Test
    public void buttons() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/buttons");
        Navegador.getNavegadorAberto ().acessarSite ();
        Actions act = new Actions (Navegador.getNavegadorAberto ().instanciaChrome ());

        act.doubleClick (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='doubleClickBtn']"))).build ().perform ();
        act.contextClick (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("rightClickBtn"))).perform ();
        act.click (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button"))).perform ();
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("doubleClickMessage")).getText ().equals ("You have done a double click") &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("rightClickMessage")).getText ().equals ("You have done a right click") &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("dynamicClickMessage")).getText ().equals ("You have done a dynamic click"));
    }

    @Test
    public void followingLinks() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/links");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[3]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("201", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'201')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[4]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("204", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'204')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[5]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("301", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'301')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[6]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("400", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'400')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[7]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("401", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'401')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[8]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("403", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'403')]")).getText ());
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[9]/a[1]")).click ();
        Thread.sleep (1000);
        Assert.assertEquals ("404", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//b[contains(.,'404')]")).getText ());
//        System.out.println(Navegador.getNavegadorAberto().instanciaChrome().findElement(By.xpath("//b[contains(.,'201')]")).getText());
    }

    @Test
    public void dynamicProperties() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/dynamic-properties");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (5000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[3]")).getText ().equals ("Visible After 5 Seconds"));

    }

    @Test
    public void dynamicPropertiesColor() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/dynamic-properties");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (5000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[2]")).getCssValue ("color").equals ("rgba(220, 53, 69, 1)"));

    }

    @Test
    public void dynamicPropertiesElementos() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/dynamic-properties");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (5000);
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")).isEnabled () &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[2]")).isDisplayed () &&
                Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/button[3]")).isDisplayed ()
        );
    }

    @Test
    public void alerts() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/alerts");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]")).click ();
        boolean result = false;

        try {
            Thread.sleep (5000);
            Navegador.getNavegadorAberto ().instanciaChrome ().switchTo ().alert ().accept ();
            result = true;
        } catch (Exception e) {
        }

        Assert.assertTrue (result);


    }

    @Test
    public void alerts5segundos() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/alerts");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='timerAlertButton']")).click ();
        boolean result = false;

        try {
            Thread.sleep (8000);
            Navegador.getNavegadorAberto ().instanciaChrome ().switchTo ().alert ().accept ();
            result = true;
        } catch (Exception e) {
        }

        Assert.assertTrue (result);


    }

    @Test
    public void alertsCancel() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/alerts");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='confirmButton']")).click ();
        boolean result = false;

        try {
            Thread.sleep (1000);
            Navegador.getNavegadorAberto ().instanciaChrome ().switchTo ().alert ().dismiss ();
            result = true;
        } catch (Exception e) {
        }

        Assert.assertTrue (result);
    }

    @Test
    public void alertsSendKeys() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/alerts");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("//button[@id='promtButton']")).click ();
        Thread.sleep (1000);
        Navegador.getNavegadorAberto ().instanciaChrome ().switchTo ().alert ().sendKeys ("Carlos André");
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().switchTo ().alert ().accept ();
        System.out.println (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("promptResult")).getText ().substring (12));
        Assert.assertEquals ("Carlos André", Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("promptResult")).getText ().substring (12));
    }

    @Test
    public void smallModal() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/modal-dialogs");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]")).click ();
        String titulo = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("example-modal-sizes-title-sm")).getText ();
        String texto = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.className ("modal-body")).getText ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("closeSmallModal")).click ();
        Assert.assertTrue (texto.contains ("small modal") &&
                titulo.contains ("Small Modal"));
    }

    @Test
    public void largeModal() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/modal-dialogs");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (3000);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button[2]")).click ();
        String titulo = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("example-modal-sizes-title-lg")).getText ();
        String texto = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.className ("modal-body")).getText ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("closeLargeModal")).click ();
        Assert.assertTrue (texto.contains ("unchanged") &&
                titulo.contains ("Large Modal"));
    }

    @Test
    public void accordian() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/accordian");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (1000);
        String[] str1 = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("section1Content")).getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (3000);
        System.out.println (str1);
        Navegador.getNavegadorAberto ().instanciaChrome ().executeScript ("scroll(0, +250);");
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("section2Heading")).click ();
        String[] str2 = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/p[1]")).getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (1000);
        System.out.println (str2);
        Navegador.getNavegadorAberto ().instanciaChrome ().executeScript ("scroll(0, +300);");
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("section3Heading")).click ();
        String[] str3 = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/p[1]")).getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (1000);
        System.out.println (str3);
        int result = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals (str2[j])) {
                    for (int k = 0; k < str3.length; k++) {
                        if (str2[j].equals (str3[k])) {
                            System.out.println (str2[j]);
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println (result);
        Assert.assertTrue (result >= 5);

    }

    //"11.1 - link: https://demoqa.com/auto-complete .
    // Filtrar no campo TYPE MULTIPLES COLOR NAMES as cores ""Blue"", ""Magenta"" e ""Yellow""
    //        Assert: Passa se no campo tiver as 3 informações selecionadas."
    @Test
    public void autoComplete() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/auto-complete");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);

        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("autoCompleteMultipleInput")).sendKeys ("bl");
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("react-select-2-option-0")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("autoCompleteMultipleInput")).sendKeys ("ma");
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("react-select-2-option-0")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("autoCompleteMultipleInput")).sendKeys ("ye");
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("react-select-2-option-0")).click ();
        System.out.println (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText ());
        String cores = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText ();
        Assert.assertTrue (cores.contains ("Blue") && cores.contains ("Magenta") && cores.contains ("Yellow"));
    }

    @Test
    public void autoCompleteSingleColor() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/auto-complete");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);

        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("autoCompleteSingleInput")).sendKeys ("b");
        String saida = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.className ("auto-complete__menu")).getText ();
        System.out.println (saida);
//        String cores = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText ();
        Assert.assertTrue (saida.contains ("Blue") && saida.contains ("Black"));
    }

    @Test
    public void datePicker() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/date-picker");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);

        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("datePickerMonthYearInput")).click ();

        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__year-select")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__year-select")).sendKeys ("1989", (ENTER));
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__month-select")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__month-select")).sendKeys ("January", (ENTER));
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__day--007:nth-child(7)")).click ();
//        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector ("#datePickerMonthYearInput")).click ();

        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("datePickerMonthYearInput")).getAttribute ("value").equals ("01/07/1989"));
    }

    @Test
    public void datePickerTime() {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/date-picker");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("dateAndTimePickerInput")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__month-read-view--selected-month")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__month-option:nth-child(1)")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__year-read-view--down-arrow")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().executeScript ("scroll(0, +250);");
        for (int i =0; i <= 27; i++){
            Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__year-option:nth-child(13)")).click ();
        }
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__year-option:nth-child(12)")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__day--007")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.cssSelector (".react-datepicker__time-list-item:nth-child(10)")).click ();
        Assert.assertTrue (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("dateAndTimePickerInput")).getAttribute ("value").equals ("January 7, 1989 2:15 AM"));
    }
    @Test
    public void slider (){
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/slider");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);
        WebElement slider = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]/input[1]"));
        WebElement saida = Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("sliderValue"));
        Actions act = new Actions (Navegador.getNavegadorAberto ().instanciaChrome ());
        int saidaInt =Integer.parseInt (saida.getAttribute ("value")) ;
        for (int i = 0; !saida.getAttribute ("value").equals ("71") ; i+=4){
            act.dragAndDropBy (slider, i, 0).build ().perform ();
        }

        System.out.println (saidaInt);
        Assert.assertTrue (saida.getAttribute ("value").equals ("71"));

    }
    @Test
    public void progressBar() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/progress-bar");
        Navegador.getNavegadorAberto ().acessarSite ();
        Navegador.getNavegadorAberto ().instanciaChrome ().manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.id ("startStopButton")).click ();
        Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath
                ("//div[@role='progressbar']")).getAttribute ("style").substring (7);
        int i =0 ;
     while(i < 9){
         i = Integer.parseInt (Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath
                 ("//div[@role='progressbar']")).getAttribute ("style").substring (7,8));
         Thread.sleep ( 1000);
         System.out.println (i);
     }
            Assert.assertEquals ("100%",Navegador.getNavegadorAberto ().instanciaChrome ().findElement (By.xpath
                    ("//div[@role='progressbar']")).getAttribute ("style").substring (7,11));

    }

    @Test
    public void tabs() throws InterruptedException {
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/tabs");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (1000);

        String[] str1 = Navegador.getNavegadorAberto ().instanciaChrome ().
                findElement (By.xpath ("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/p[1]")).
                getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (3000);


        Navegador.getNavegadorAberto ().instanciaChrome ().
                findElement (By.id ("demo-tab-origin")).click ();
        String[] str2 = Navegador.getNavegadorAberto ().instanciaChrome ().
                findElement (By.id ("demo-tabpane-origin")).getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (1000);


        Navegador.getNavegadorAberto ().instanciaChrome ().
                findElement (By.id ("demo-tab-use")).click ();
        String[] str3 = Navegador.getNavegadorAberto ().instanciaChrome ().findElement
                (By.id ("demo-tabpane-use")).getText ().replace (", ", " ").replace (". ", " ").split (" ");
        Thread.sleep (1000);

        int result = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i].equals (str2[j])) {
                    for (int k = 0; k < str3.length; k++) {
                        if (str2[j].equals (str3[k])) {
                            System.out.println (str2[j]);
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println (result);
        Assert.assertTrue (result >= 5);
    }
    @Test
    public void toolTips() throws InterruptedException {
        //"16 - link: https://demoqa.com/tool-tips .
        //        Assert: Passa se você conseguir pegar os 4 tooltips da tela"
        Navegador.getNavegadorAberto ().setUrl ("https://demoqa.com/tool-tips");
        Navegador.getNavegadorAberto ().acessarSite ();
        Thread.sleep (1000);

    }



}

