package book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {

    public static List<Book> createBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("A Year in Provence",
                Collections.singletonList("Peter Mayle"),
                1991,
                "https://www.amazon.com/Year-Provence-Peter-Mayle/dp/0679731148",
                "0-679-73114-8")
        );
        books.add(new Book("Sapiens: A Brief History of Humankind")
                .authors(Collections.singletonList("Yuval Noah Harari"))
        );
        books.add(new Book("Clean Code")
                .authors(Collections.singletonList("Robert C. Martin"))
                .year(1995)
        );

        return books;
    }

}
