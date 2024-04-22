package helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class Utility {
    //fucntion ini mengembalikan jsonshcema berupa file yang mana path nya harus sesuai dengan
    //path dari tempat json schemanya
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
}
