package hiwotab.bookapplicationproject.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Entity
public class Book {

    @NotNull
    @Min(1)
    @Id
    long id;
    @NotNull
    String sku;
    @NotNull
    String bookTitle;
    @NotNull
    String bookAuthor;
    @NotNull
    String bookCategories;
    @NotNull
    String bookDescr;
    @NotNull
    double bookPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(String bookCategories) {
        this.bookCategories = bookCategories;
    }

    public String getBookDescr() {
        return bookDescr;
    }

    public void setBookDescr(String bookDescr) {
        this.bookDescr = bookDescr;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    @Override
    public String toString() {

        return "\nLists of Books are:" +
                "\nBook ID=" + id +
                "\nBook SKU=" + sku +
                "\nBook Title=" + bookTitle +
                "\nBook Author=" + bookAuthor +
                "\nBook Categories=" + bookCategories +
                "\nBook Description=" + bookDescr +
                "\nBook Price=" + bookPrice;
    }



}