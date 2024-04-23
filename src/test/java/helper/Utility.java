package helper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {
    //fucntion ini mengembalikan jsonshcema berupa file yang mana path nya harus sesuai dengan
    //path dari tempat json schemanya

    public static WebDriver driver;
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail(){
        String allowedChars = "adsfasdfasdf"+"12342353"+"_+=.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); //panjang email 10 karakter
        email = temp+"@testdata.com";
        return email;
    }

    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox"); //chrome bukan versi beta/alpa tapi versi production
        options.addArguments("--disable-dev-shm-usage"); //menghindari kegagalan akibat memori
        options.addArguments("--remote-allow-origins=*"); //chrome bisa kita remote dari selenium nya
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // ini untuk maximize window nya waktu selenium berjalan
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //untuk menunggu elemennya selama 3 detik

    }

    public static void quitDriver(){
        driver.quit();
    }
}
