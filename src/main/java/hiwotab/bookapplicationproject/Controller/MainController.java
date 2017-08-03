package hiwotab.bookapplicationproject.Controller;
import hiwotab.bookapplicationproject.Models.Book;
import hiwotab.bookapplicationproject.repositories.BookRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class MainController {

    @Autowired
    BookRepostory bookRepostory;

    @GetMapping("/main")
    public String showIndex(Model model) {
        String myMessage = "Welcome to the Book Application";
        model.addAttribute("message", myMessage);
        return "main";
    }

    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBookForm(@Valid @ModelAttribute("newBook") Book books, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addbook";
        }
        bookRepostory.save(books);
        return "result";
    }

    @GetMapping("/showAllBooks")
    public @ResponseBody  String showAllBooks( ) {

        Iterable<Book> booklists = bookRepostory.findAll();
        ArrayList<Book> myList = new ArrayList<Book>();
        for (Book books:booklists) {
            myList.add(books);
            Iterator iterator=myList.iterator();
              while(iterator.hasNext()){
                  myList.iterator().next();
                  return myList.toString();
              }

        }

        return "main";
    }




}