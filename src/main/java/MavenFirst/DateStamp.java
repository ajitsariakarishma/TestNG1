package MavenFirst;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStamp {

    public static void main(String[] args) {

        //DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        // format.(new Date());
        String email = "karishma_".concat(new Date().toString().replaceAll("[^a-zA-Z0-9]",""));
        String email1= "micky_".concat(new Date().toString().replaceAll(" ","").replaceAll(":",""));
        System.out.println(email);
        System.out.println(email1);

    }
}

