import java.net.*;
import java.io.*;
import java.util.Date;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String [] args)
            throws Exception {
        int c;
        URL hp = new URL("https://sch1354uz.mskobr.ru/#/");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if (d == 0)
            System.out.println("Сведения о дате отсутствуют!");
        else
            System.out.println(new Date(d));

        System.out.println("Тип содержимого: " + hpCon.getContentType());

        d = hpCon.getExpiration();
        if (d == 0)
            System.out.println("Сведения о сроке действия отсутствуют!");
        else
            System.out.println(new Date(d));

        long len = hpCon.getContentLengthLong();
        if (len == -1)
            System.out.println("Длина содержимого недоступна!");
        else
            System.out.println("Длина содержимого: "+len);

        if (len!=0) {
            System.out.println("==== Содержимое ====");
            InputStream input = hpCon.getInputStream();
            while (((c = input.read()) != -1)) {
                System.out.print((char) c);
            }
            input.close();
        } else
            System.out.println("Содержимое недоступно!");

    }

}