package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileUtils {
    public static void readLines(String fileName, Consumer<String> block) {
        try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while((line = br.readLine()) != null) {
                block.accept(line);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
