package NewTwitter.Tweet;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import io.restassured.path.json.JsonPath;
public class BlockUser extends Base {
	 String    Consumerkey="ZCv5DH34VvpkqAoTAmyo7z6C2";
	    String    ConsumerSecret="tkJB4gAM3R2ZGuoQdLWNubLCLmIIGqTLz0OV4z4Q5SaQe2bdxY";
	    String    Token="1364996528578854913-x55lA6iHxbeOnebnHUwWeIlKKvrcGY";
	    String    TokenSecret="i2V7CLZfDbP0051d28ct8d1be0csro8Z7kQgiwxZm8yzv";
                
    
    @Test
    public void block_user() throws IOException {
        RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
        Response res=given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
        queryParam("screen_name","NiloorC").when().post("create.json").then().extract().response();
        String response=res.asString();
        JsonPath jp=new JsonPath(response);
        String name=jp.get("name");
        System.out.println(name);
    }

 

}