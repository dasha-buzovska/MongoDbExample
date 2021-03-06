package book;

import org.bson.*;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {

    public static List<BsonDocument> getBooksInBsonFormat(List<Book> books) {
        return books
                .stream()
                .map(BookConverter::convertBookToBsonDocument)
                .collect(Collectors.toList());
    }

    public static List<Book> getBooksFromBson(List<BsonDocument> bsonBooks) {
        return bsonBooks
                .stream()
                .map(BookConverter::convertBsonDocumentToBook)
                .collect(Collectors.toList());
    }

    public static Book convertBsonDocumentToBook(BsonDocument bsonBook) {
        Book book = new Book(bsonBook.getString("name").getValue());
        BsonObjectId bson = bsonBook.getObjectId("_id");

        book.id(bson.getValue().toHexString());
        book.authors(
                bsonBook.getArray("authors", null)
                        .stream()
                        .map(author -> author.asString().getValue())
                        .collect(Collectors.toList())
        );
        book.year(bsonBook.getInt32("year", new BsonInt32(0)).getValue());
        book.link(bsonBook.getString("link", null).getValue());
        book.ISBN(bsonBook.getString("ISBN").getValue());

        return book;
    }

    public static BsonDocument convertBookToBsonDocument(Book book) {
        BsonString name = new BsonString(book.getName());
        BsonDocument document = new BsonDocument()
                .append("name", name);

        if (book.getAuthors() != null) {
            BsonArray authors = book.getAuthors()
                    .stream()
                    .map(BsonString::new)
                    .collect(Collectors.toCollection(BsonArray::new));
            document.append("authors", authors);
        }

        if (book.getYear() != 0) {
            document.append("year", new BsonInt32(book.getYear()));
        }

        if (book.getLink() != null)  {
            document.append("link", new BsonString(book.getLink()));
        }

        if (book.getISBN() != null) {
            document.append("ISBN", new BsonString(book.getISBN()));
        }

        return document;
    }

}
