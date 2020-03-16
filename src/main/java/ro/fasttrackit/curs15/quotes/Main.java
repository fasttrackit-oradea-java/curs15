package ro.fasttrackit.curs15.quotes;

public class Main {
    public static void main(String[] args) {
        QuoteReader reader = new QuoteReader("src/main/resources/quotes.txt");
        QuoteService service = new QuoteService(reader.readFile());
        MainMenu menu = new MainMenu(service);
        menu.run();
    }
}
