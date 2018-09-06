package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/books")
public class Controller {
    private BookService service;

    @Autowired
    public Controller(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> get() {
        return service.getAll();
    }

    @GetMapping("/{title}")
    public Book getByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @GetMapping("/id/{id}")
    public Book getById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok(200);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity create(@RequestBody Book book) {
        service.save(book);
        return ResponseEntity.ok(200);
    }
}
