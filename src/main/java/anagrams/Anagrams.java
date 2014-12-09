package anagrams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class Anagrams {
    public static void main(final String[] args) {
        readLines(args[0], System.out::println);
    }

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