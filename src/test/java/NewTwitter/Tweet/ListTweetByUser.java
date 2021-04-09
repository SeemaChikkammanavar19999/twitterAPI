package NewTwitter.Tweet;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListTweetByUser extends Base {
	private static Logger log=(Logger) LogManager.getLogger(ListTweetByUser.class.getName());
	 @Test
	    public void getUserTweet() throws IOException
	    {
		 Initial();
	        RestAssured.baseURI=prop.getProperty("TWITTERHOST");
			Response res=given().auth().oauth(prop.getProperty("consumer"),prop.getProperty("consumerKey"),prop.getProperty("Token"),prop.getProperty("TokenKey")  ).
	        when().queryParam("exclude_replies","true").queryParam("include_rts","false").get("user_timeline.json").then().assertThat().statusCode(200).extract().response();
	        String response=res.asString();
	        log.info(response);
	        JsonPath js=new JsonPath(response);
	        List<String> ac=js.get("text");
	        log.info(ac);
	 

	}
}
