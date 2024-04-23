import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestSelenium {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options); // Menginisialisasi ChromeDriver
        driver.manage().window().maximize(); // Memperbesar jendela
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Menetapkan waktu tunggu implisit
        driver.get("https://pintu.co.id");
        Thread.sleep(5000);
        driver.quit();
    }
}
