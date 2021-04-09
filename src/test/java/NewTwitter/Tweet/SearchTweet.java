package NewTwitter.Tweet;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SearchTweet extends Base{
	private static Logger log=(Logger) LogManager.getLogger(CreateNewTweet.class.getName());
	@Test 
	public void tweet1() throws IOException {
		
		Initial();
		RestAssured.baseURI=prop.getProperty("Searchhost");
		Response res=given().auth().oauth(prop.getProperty("consumer"),prop.getProperty("consumerKey"),prop.getProperty("Token"),prop.getProperty("TokenKey")  ).
				queryParam("q","#Qualitest_In").
				queryParam("geocode","23424848").
				when().get("/tweets.json").then().extract().response();
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		ArrayList<Object> arr=new ArrayList<>();
        arr.addAll(js.getList("statuses"));
        Iterator itr=arr.iterator();
        while(itr.hasNext())
        {
            log.info(itr.next());
        }
		
       
	}
}