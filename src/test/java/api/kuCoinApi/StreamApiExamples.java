package api.kuCoinApi;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StreamApiExamples {

    @Test
    public void checkCrypto() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.kucoin.com/api/v1/market/allTickers")
                .then().log().body();
    }
}
