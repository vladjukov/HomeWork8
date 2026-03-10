package tests;

import org.junit.jupiter.api.Test;
import specs.BookStoreSpecs;

import static io.restassured.RestAssured.given;

public class DeleteBookTests {
    @Test
    public void deleteBook() {
        int id = 5;
        given()
                .spec(BookStoreSpecs.baseSpec())
                .when()
                .pathParam("id", id)
                .delete("/api/v1/Books/{id}")
                .then()
                .statusCode(200);
    }
}
