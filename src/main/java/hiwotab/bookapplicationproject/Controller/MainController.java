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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class MainController {
    private int[]  loadId={10,11,12,13,14,15};
    private String[] loadSkus = {"Java1001", "Java2002", "Orcl1003", "Python1004", "Zombie1005", "Rasp1006"};
    private String[] loadTitles = {"Head First Java", "Thinking in Java", "OCP: Oracle Certified Professional Java SE", "Automate the Boring Stuff with Python", "The Maker's Guide to the Zombie Apocalypse", "Raspberry Pi Projects for the Evil Genius"};
    private String[] loadAuthors = {"Kathy Sierra and Bert Bates", "Bruce Eckel", "Jeanne Boyarsky", "Al Sweigart", "Simon Monk", "Donald Norris"};
    private String[] loadDescription = {"Easy to read Java workbook", "Details about Java under the hood", "Everything you need to know in one place","Fun with Python","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi","A dozen fiendishly fun projects for the Raspberry Pi!"};
    private String[] loadCategory ={"Programming", "Programming ", "Oracle", "Programming", "Programming", "Recipe"};
    private double[] loadPrice = {47.50, 20.00, 45.00, 10.50, 16.50, 14.75};
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
    public String showAllBooks(Model model ) {
        Iterable<Book> booklists = bookRepostory.findAll();
        model.addAttribute("searchBook", booklists);

        return "list";

    }
    @GetMapping("/loadNewBooks")
    public String showloadBooks()
    {
        bookRepostory.save(showBooksLoad());

        return "main";
    }

    private ArrayList<Book> showBooksLoad() {

        ArrayList<Book> newBookList = new ArrayList<Book>();


        for (int i = 0; i < loadId.length; i++) {
            Book newBook = new Book();
            newBook.setId(loadId[i]);
            newBook.setSku(loadSkus[i]);
            newBook.setBookTitle(loadTitles[i]);
            newBook.setBookAuthor(loadAuthors[i]);
            newBook.setBookCategories(loadCategory[i]);
            newBook.setBookDescr(loadDescription[i]);
            newBook.setBookPrice(loadPrice[i]);
            newBookList.add(newBook);
        }
        return newBookList;

        }
   /* @GetMapping("/showByAuthor")
    public String showAuthor(@ModelAttribute String names, Model model){
        model.addAttribute("searchBook", bookRepostory.getProductById(id));
        return "list";
    }*/
    }
