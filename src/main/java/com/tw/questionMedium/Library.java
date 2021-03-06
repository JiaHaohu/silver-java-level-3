package com.tw.questionMedium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addAll(Book... books) {
        this.books.addAll(Arrays.asList(books));
    }

    /**
     * Find all the books which satisfy conditions specified by predicate.
     *
     * @param predicate The matching condition.
     * @return The matched books. The returned books should be ordered by their ISBN
     * number.
     */
    public List<Book> findBooksBy(Predicate<Book> predicate) {
        // TODO:
        //   Please implement the method
        // <-start-
        List<Book> selectBooks = books.stream().filter(predicate).collect(Collectors.toList());
        selectBooks.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
        return selectBooks;
        // --end-->
    }

    /**
     * Find all the books whose price is lower than or equal to maxPriceInclusive.
     *
     * @param maxPriceInclusive The maximum price (inclusive).
     * @return The matched books. Sorted by ISBN number.
     */
    public List<Book> findBooksCheaperThan(int maxPriceInclusive) {
        // TODO:
        //   Please complete the method
        // <-start-
        ArrayList<Book> list = new ArrayList<>();
        Predicate<Book> isPriceLowerThanOrEqualTo = book -> book.getPrice() <= maxPriceInclusive;

        // --end-->

        // You cannot change this line.
        return findBooksBy(isPriceLowerThanOrEqualTo);
    }

    /**
     * Find all the books which contains one of the specified tags.
     *
     * @param tags The tag list.
     * @return The books which contains one of the specified tags. The returned books
     * should be ordered by their ISBN number.
     */
    public List<Book> findBooksByTag(String... tags) {
        // TODO:
        //   Please implement the method. You must use `findBooksBy` method
        // <-start-
        ArrayList<Book> selectBooks = new ArrayList<>();

        if (tags.length == 0 || tags ==null){
            return selectBooks;
        }

        tags = Arrays.stream(tags).distinct().toArray(String[]::new);

        for (String tag : tags) {
            selectByOneTag(selectBooks,tag);
        }

        selectBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getIsbn().compareTo(o2.getIsbn());
            }
        });

        return selectBooks.stream().distinct().collect(Collectors.toList());
        // --end-->
    }


    // TODO:
    //   You can add additional methods here if you want.
    // <-start-

    private void selectByOneTag(ArrayList<Book> selectBooks, String tag) {
        Predicate<Book> isContainTag = book -> book.getTags().contains(tag);
        List<Book> selectByTagBooks = books.stream().filter(isContainTag).collect(Collectors.toList());
        selectBooks.addAll(selectByTagBooks);
    }


    // --end-->
}
