package com.amazon.mobile.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    private static Properties p;

    public static Properties getProperties(String s) {

        if(p == null) {
            loadProperties(s);
        }

        return p;
    }

    public static void clear() {
        p = null;
    }

    private static void loadProperties(String s) {
        try {
            InputStream input = new FileInputStream(s);
            p = new Properties();
            p.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}