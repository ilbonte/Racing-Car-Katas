package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;

public class TextFileReader {
    private BufferedReader reader;

    public TextFileReader(BufferedReader reader) {
        this.reader = reader;
    }

    public TextFileReader() {

    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
