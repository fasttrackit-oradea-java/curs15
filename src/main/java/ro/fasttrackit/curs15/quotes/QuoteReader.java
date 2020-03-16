package ro.fasttrackit.curs15.quotes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteReader {
    private final String filePath;

    public QuoteReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Quote> readFile() {
        List<Quote> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            int id = 1;
            while (scanner.hasNextLine()) {
                result.add(fetchQuote(id++, scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Quote fetchQuote(int id, String line) {
        String[] tokens = line.split("~");
        return new Quote(id, tokens[0], tokens[1]);
    }

}
