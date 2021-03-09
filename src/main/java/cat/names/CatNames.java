package cat.names;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CatNames {
    private static String[] names = null;

    private static void loadCatName() throws IOException {
        File file = new File("src/main/java/cat/names/resources/CatNames.txt");
        var is = new FileInputStream(file);
        String str = new String(is.readAllBytes());
        names = str.split(", ");
        is.close();
    }

    public static String getCatName() throws IOException {
        if(null == names) loadCatName();
        return names[(int)(Math.random() * names.length)];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getCatName());
    }
}
