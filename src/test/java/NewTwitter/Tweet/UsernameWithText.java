package NewTwitter.Tweet;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import io.restassured.path.json.JsonPath;

 

public class UsernameWithText extends Base{
    
    String    Consumerkey="ZCv5DH34VvpkqAoTAmyo7z6C2";
    String    ConsumerSecret="tkJB4gAM3R2ZGuoQdLWNubLCLmIIGqTLz0OV4z4Q5SaQe2bdxY";
    String    Token="1364996528578854913-x55lA6iHxbeOnebnHUwWeIlKKvrcGY";
    String    TokenSecret="i2V7CLZfDbP0051d28ct8d1be0csro8Z7kQgiwxZm8yzv";
    
    @Test
    public void displayusername_tweet() throws IOException {
        
        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
        Response res=given().auth().oauth(Consumerkey,ConsumerSecret,Token,TokenSecret).
                queryParam("q", "#Qualitest").when().
                get("tweets.json").then().extract().response();
        String response=res.asString();
        JsonPath jp=new JsonPath(response);
        ArrayList<Object> arr=new ArrayList<Object>();
        ArrayList<Object> arr1=new ArrayList<Object>();
        arr.addAll(jp.getList("statuses.text"));
        arr1.addAll(jp.getList("statuses.user.name"));
    
        Iterator itr=arr.iterator();
        Iterator itr1=arr1.iterator();
        
        while(itr.hasNext())
        {        
            System.out.println("Tweet:"+itr.next()+" UserName"+itr1.next());
        }
    
}
}