package pl.drobinki;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExampleTest {

    @Test
    public void name() throws Exception {
        get("/greeting").then().body("name", equalTo("Name"));
    }
}
