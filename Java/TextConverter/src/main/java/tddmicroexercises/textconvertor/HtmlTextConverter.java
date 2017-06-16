package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;
	private BufferedReader reader;

	public HtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException{

		readerCreateFrom(fullFilenameWithPath);

		String line = readerReadLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = readerReadLine();
	    }
	    return html;

    }

	protected String readerReadLine() throws IOException {
		return reader.readLine();
	}

	protected void readerCreateFrom(String filePath) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(filePath));
	}

	public String getFilename() {
		return this.fullFilenameWithPath;
	}
}
