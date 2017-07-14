package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    @Test
    public void returns_empty_html_when_file_is_empty() throws IOException {
        TextFileReader reader = new TextFileReaderThatReturnsNoContent();
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void returns_an_html_when_file_is_not_empty() throws IOException {
        TextFileReader reader = new TextFileReaderThatReturnsContent();
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("first<br />first<br />first<br />", converter.convertToHtml());
    }


    private class TextFileReaderThatReturnsContent extends TextFileReader {
        private int counter = 0;

        @Override
        public String readLine() throws IOException {
            counter++;
            if (counter < 4) {
                return "first";
            }
            return null;
        }
    }

    private class TextFileReaderThatReturnsNoContent extends TextFileReader {
        @Override
        public String readLine() throws IOException {
            return null;
        }
    }

}
