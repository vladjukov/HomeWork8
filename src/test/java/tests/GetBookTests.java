package tests;

import dto.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specs.BookStoreSpecs;

import static io.restassured.RestAssured.given;

public class GetBookTests {
    @Test
    public void getAllBooks() {
        given().spec(BookStoreSpecs.baseSpec())
                .when()
                .get("/api/v1/Books/")
                .then()
                .spec(BookStoreSpecs.responseSuccess());
    }

    @Test
    public void getSingleBook() {
        int bookId = 5;
        Book response = given()
                .spec(BookStoreSpecs.baseSpec())
                .when()
                .pathParam("bookId", bookId)
                .get("/api/v1/Books/{bookId}")
                .then()
                .spec(BookStoreSpecs.responseSuccess())
                .extract().as(Book.class);

        Assertions.assertEquals(bookId, response.getId());
        Assertions.assertTrue(response.getTitle().matches("\\w+\\s+\\d+"));
    }


}
