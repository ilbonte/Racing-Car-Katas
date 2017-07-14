package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class TextFileReaderFactoryTest {

    @Test(expected = FileNotFoundException.class)
    public void throws_file_not_found_exception_when_file_is_missing() throws FileNotFoundException {
        TextFileReaderFactory.createFrom("a_missing_file");
    }

    @Test
    public void create_a_text_file_reader_from_a_file() throws IOException {
        TextFileReader reader = TextFileReaderFactory.createFrom("full.txt");

        assertNotNull(reader.readLine());
    }

}