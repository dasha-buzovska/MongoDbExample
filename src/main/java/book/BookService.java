package book;

import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookDao dao;

    @Autowired
    public BookService(BookDao dao) {
        this.dao = dao;
    }

    public void save(Book book) {
        BsonDocument bsonBook = BookConverter.convertBookToBsonDocument(book);
        dao.save(bsonBook);
    }

    public void save(List<Book> books) {
        List<BsonDocument> bsonBooks = BookConverter.getBooksInBsonFormat(books);
        dao.save(bsonBooks);
    }

    public Book getByTitle(String title) {
        BsonDocument bsonBook = dao.getByTitle(title);
        return  BookConverter.convertBsonDocumentToBook(bsonBook);
    }

    public Book getById(String id) {
        BsonDocument bsonBook = dao.getById(id);
        return  BookConverter.convertBsonDocumentToBook(bsonBook);
    }

    public List<Book> getAll() {
        return BookConverter.getBooksFromBson(dao.getAll());
    }

    public List<Book> getByYear(int year) {
        return BookConverter.getBooksFromBson(dao.getByYear(year));
    }

    public void update(Book book) {
        dao.update(BookConverter.convertBookToBsonDocument(book));
    }

    public void delete(String id) {
        dao.delete(id);
    }

}
