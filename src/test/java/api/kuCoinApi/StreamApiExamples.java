package api.kuCoinApi;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class StreamApiExamples {

    public List<TickerData> getTickers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.kucoin.com/api/v1/market/allTickers")
                .then()
                .extract().jsonPath().getList("data.ticker", TickerData.class);
    }
    @Test
    public void checkCrypto() {
        List<TickerData> usdTickers = getTickers().stream().filter(x->x.getSymbol().endsWith("USDT")).collect(Collectors.toList());
        Assertions.assertTrue(usdTickers.stream().allMatch(x->x.getSymbol().endsWith("USDT")));
        int a = 0;
    }

    @Test
    public void sortHighToLow(){
        List<TickerData> highToLow = getTickers().stream().filter(x->x.getSymbol().endsWith("USDT")).sorted(new Comparator<TickerData>() {
            @Override
            public int compare(TickerData o1, TickerData o2) {
                return o2.getChangeRate().compareTo(o1.getChangeRate());
            }
        }).collect(Collectors.toList());
        int a = 9;
    }
}
