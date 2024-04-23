import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WebDriverSetup {
    private static WebDriver driver;

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup(); // Mengatur chromedriver

        // Cobalah untuk membuat instance ChromeDriver
        try {
            driver = new ChromeDriver(options); // Menginisialisasi ChromeDriver
            driver.manage().window().maximize(); // Memperbesar jendela
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Menetapkan waktu tunggu implisit
        } catch (Exception e) {
            System.err.println("Error initializing ChromeDriver: " + e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            startDriver(); // Inisialisasi jika driver belum ada
        }
        return driver;
    }

    public static void main(String[] args) {
        getDriver();
    }
}
