package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Field;
import java.util.Random;

public class Helper {

    public static String randomString(final int length) {
        StringBuilder b = new StringBuilder();
        Random r = new Random();
        String subset = "0123456789abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int index = r.nextInt(subset.length());
            char c = subset.charAt( index );
            b.append( c );
        }
        return b.toString();
    }
}
