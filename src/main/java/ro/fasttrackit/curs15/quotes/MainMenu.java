package ro.fasttrackit.curs15.quotes;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final QuoteService service;

    public MainMenu(QuoteService service) {
        this.service = service;
    }

    public void run() {
        int input;
        do {
            printMainMenu();
            input = getInput();
            executeInput(input);
        } while (input != 0);
    }

    private void printMainMenu() {
        System.out.println("=====================================");
        System.out.println("1) Get all quotes");
        System.out.println("2) Get quotes for author");
        System.out.println("3) Get all authors");
        System.out.println("4) Set favourite quote ");
        System.out.println("5) Get favourite quotes ");
        System.out.println("6) Random quote ");
        System.out.println("0) Exit");
        System.out.println("=====================================");
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select your option: ");
        return scanner.nextInt();
    }

    private void executeInput(int input) {
        switch (input) {
            case 1:
                handleGetAllQuotes();
                break;
            case 2:
                handleGetQuotesForAuthor();
                break;
            case 3:
                handlerGetAllAuthors();
                break;
            case 4:
                handleSetFavourite();
                break;
            case 5:
                handleGetFavouriteQuotes();
                break;
            case 6:
                handleRandomQuote();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void handleRandomQuote() {
        printQuote(service.getRandomQuote());
    }

    private void handleGetFavouriteQuotes() {
        List<Quote> quotes = service.getFavourites();
        for (Quote quote : quotes) {
            printQuote(quote);
        }
    }

    private void printQuote(Quote quote) {
        System.out.println(quote.getText() + " - " + quote.getAuthor() + " - " + quote.getId());
    }

    private void handleSetFavourite() {
        System.out.print("What's your favourite quote? ");
        int fav = new Scanner(System.in).nextInt();
        service.setFavourite(fav);
        System.out.println("Quote " + fav + " was set to favourite");
    }

    private void handlerGetAllAuthors() {
        for (String author : service.getAuthors()) {
            System.out.println(author);
        }
    }

    private void handleGetQuotesForAuthor() {
        System.out.print("Input the author: ");
        String author = new Scanner(System.in).nextLine();
        List<Quote> quotes = service.getQuotesForAuthor(author);
        for (Quote quote : quotes) {
            System.out.println(quote.getText());
        }
    }

    private void handleGetAllQuotes() {
        for (String text : service.getAllQuotes()) {
            System.out.println(text);
        }
    }
}
