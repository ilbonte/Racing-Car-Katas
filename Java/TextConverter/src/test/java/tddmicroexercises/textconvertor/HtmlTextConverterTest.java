package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    public static final String MISSING_FILE = "missing_file";

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("foo", converter.getFilename());
    }

    @Test(expected = FileNotFoundException.class)
    public void throws_file_not_found_exception_when_file_does_not_exists() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter(MISSING_FILE);

        converter.convertToHtml();
    }

    @Test
    public void returns_empty_html_when_file_is_empty() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverterThatReturnsEmptyContent("empty.txt");

        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void returns_an_html_when_file_is_not_empty() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverterThatReturnsContent("full.txt");

        assertEquals("first<br />first<br />first<br />", converter.convertToHtml());
    }

    private class HtmlTextConverterThatReturnsContent extends HtmlTextConverter {
        private int counter = 0;
        public HtmlTextConverterThatReturnsContent(String fileName) {
            super(fileName);
        }

        @Override
        protected String readerReadLine() throws IOException {
            counter++;
            if(counter<4){
                return "first";
            }
            return null;

        }

        @Override
        protected void readerCreateFrom(String filePath) throws FileNotFoundException {

        }


    }

    private class HtmlTextConverterThatReturnsEmptyContent extends HtmlTextConverter {
        public HtmlTextConverterThatReturnsEmptyContent(String fileName) {
            super(fileName);
        }

        @Override
        protected String readerReadLine() throws IOException {
          return  null;
        }

        @Override
        protected void readerCreateFrom(String filePath) throws FileNotFoundException {
        }

    }
}
