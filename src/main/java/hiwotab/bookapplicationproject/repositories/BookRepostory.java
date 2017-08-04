package hiwotab.bookapplicationproject.repositories;

import hiwotab.bookapplicationproject.Models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepostory extends CrudRepository<Book,Long>{
    //Iterable<Book>findByBookCategoriesContainsAndBookCategories;
    Iterable<Book>findByBookAuthor(String listAuthor);
}

