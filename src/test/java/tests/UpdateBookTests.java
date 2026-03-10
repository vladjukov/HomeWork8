package tests;

import dto.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specs.BookStoreSpecs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;

public class UpdateBookTests {

    private Book addBook() {
        return Book.builder()
                .id(1002)
                .title("Mosckow dont sea")
                .description("bla bla lba lba")
                .pageCount(98)
                .excerpt("hz")
                .publishDate("2026-02-19T20:18:03.591Z").build();
    }
    @Test
    public void updateSingleBook() {
        Book book = addBook();
        String oldDescription = book.getDescription();

        book.setDescription("Blya blo blo blO");
        Book updateBook = given()
                .spec(BookStoreSpecs.baseSpec())
                .when()
                .body(book)
                .put("/api/v1/Books/" + book.getId())
                .then()
                .spec(BookStoreSpecs.responseSuccess())
                .extract().as(Book.class);

        Assertions.assertNotEquals(updateBook.getDescription(), oldDescription);
    }
}
