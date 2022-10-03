package utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    public static Properties loadProp(String filePath)  {
        File file = new File(filePath);

        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties() ;
            properties.load(inputStream);
            inputStream.close();
            return properties ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Found Please Check The Path ");
        } catch (IOException e) {
            throw new RuntimeException(" Cannot Find The Properties Inside ");
        }


    }
}
