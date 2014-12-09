package utils;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class FileUtilsTest {
    @Test
    public void readLines() {
        String currentDirectory = System.getProperty("user.dir");
        ArrayList<String> fileList = new ArrayList<>();
        FileUtils.readLines(currentDirectory + "/test_fixtures/test.txt", fileList::add);
        assertThat(fileList).isEqualTo(asList("haro", "bye"));
    }
}