import org.openqa.selenium.chrome.ChromeDriver;

public class Navegador {

    static String url;
    static private ChromeDriver chrome;
    static private Navegador instance;

    private Navegador() {

    }

    static public Navegador getNavegadorAberto() {
        if (instance == null) {
            instance = new Navegador();
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            chrome = new ChromeDriver();

        }
        return instance;
    }

    public ChromeDriver instanciaChrome() {
        return chrome;
    }

    public void acessarSite() {
        chrome.get(this.getUrl());
        chrome.manage().window().maximize();
    }

    public static void  fecharSite(){
        chrome.close();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Navegador{" +
                "url='" + url + '\'' +
                '}';
    }

//    public static void scrollDown(String url){
//        ChromeDriver navegador = chrome;
//        JavascriptExecutor jse = navegador;
//        jse.executeScript("window.scrollBy(0,400)");
//    }

}

