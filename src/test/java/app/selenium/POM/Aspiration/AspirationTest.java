package app.selenium.POM.Aspiration;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AspirationTest {
    static private List<String> getCredentials(){
        List<String> cred = new ArrayList<>();

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/application.properties"));
            cred.add(properties.getProperty("an.user"));
            cred.add(properties.getProperty("an.pwd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cred;
    }
    private static final String PageUrl="https://my.aspiration.com/auth/login/";

}
