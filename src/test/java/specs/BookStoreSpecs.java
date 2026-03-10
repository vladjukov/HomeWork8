package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BookStoreSpecs {

    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://fakerestapi.azurewebsites.net")
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static ResponseSpecification responseSuccess() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }


    public static ResponseSpecification responseWithError() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(404)
                .build();
    }
}
