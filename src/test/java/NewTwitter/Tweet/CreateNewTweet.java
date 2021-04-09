package NewTwitter.Tweet;

import org.apache.logging.log4j.*;

	
	import static io.restassured.RestAssured.given;
	import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;
    import Resources.Base;
    import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	
	public class CreateNewTweet extends Base{
		private static Logger log=(Logger) LogManager.getLogger(CreateNewTweet.class.getName());
		@Test 
		public void tweet1() throws IOException {
			
			Initial();
			RestAssured.baseURI=prop.getProperty("TWITTERHOST");
			Response res=given().auth().oauth(prop.getProperty("consumer"),prop.getProperty("consumerKey"),prop.getProperty("Token"),prop.getProperty("TokenKey")  ).
			queryParam("status","I am learning APIl testing using RestAssured Jav #Qualitest").
			when().post("/update.json").then().extract().response();
			
			String response=res.asString();
			log.info(response);
			JsonPath js=new JsonPath(response);
			String id=js.get("id").toString();
			log.info(id);
            String text=js.get("text").toString();
			log.info(text);
		}
	}

