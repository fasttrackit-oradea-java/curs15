package ro.fasttrackit.curs15.quotes;

import java.util.Objects;

public class Quote {
    private final int id;
    private final String author;
    private final String text;
    private boolean favourite;

    public Quote(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return id == quote.id &&
                Objects.equals(author, quote.author) &&
                Objects.equals(text, quote.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}
