package tests;

import dto.Book;
import org.junit.jupiter.api.Test;
import specs.BookStoreSpecs;

import static io.restassured.RestAssured.given;

public class AddBookTests {

    @Test
    public void addNewBook() {
        Book book = Book.builder()
                .id(1002)
                .title("Mosckow dont sea")
                .description("bla bla lba lba")
                .pageCount(98)
                .excerpt("hz")
                .publishDate("2026-02-19T20:18:03.591Z").build();

        given()
                .spec(BookStoreSpecs.baseSpec())
                .when()
                .body(book)
                .post("/api/v1/Books")
                .then()
                .spec(BookStoreSpecs.responseSuccess());

    }
}
