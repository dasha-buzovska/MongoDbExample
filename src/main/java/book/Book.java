package book;

import java.util.List;

public class Book {
    private String name;
    private List<String> authors;
    private int year;
    private String link;
    private String ISBN;
    private String id;

    public Book() {}

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, List<String> authors, int year, String link, String ISBN) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.link = link;
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book authors(List<String> authors) {
        this.authors = authors;

        return this;
    }

    public Book year(int year) {
        this.year = year;

        return this;
    }

    public Book link(String link) {
        this.link = link;

        return this;
    }

    public Book ISBN(String ISBN) {
        this.ISBN = ISBN;

        return this;
    }

    public Book id(String id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public String getLink() {
        return link;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getId() {
        return id;
    }
}
