package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class TextFileReaderFactory {
    public static TextFileReader createFrom(String filePath) throws FileNotFoundException {
        Reader fileReader = new FileReader(filePath);
        return new TextFileReader(new BufferedReader(fileReader));
    }
}
