package weatherGrabbing;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class WeatherGrabbing {
	private static HttpURLConnection connect;
	private static String baseurl = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static String apiKey = "f49d16d1bd98e2e85425e79c3a85eabe";
	private static String units = "&units=imperial";

//	public static String cityNameGet(){
//		Scanner userInput = new Scanner(System.in);
//		//StringBuilder tempcity = new StringBuilder(); 
//		System.out.print("Where are you? ");
//		cityName = userInput.next();
//		// still trying to figure out how would the user input the city, if they want to enter state 
//		// or not 
////		while (userInput.next()!= "\n") {
////		String temp=userInput.next();
////		if (temp.length()!=2) {
////		.concat(temp);
////		}
//		return cityName;
//	}
	
	public static String structURL(String cityName) {
		return baseurl + cityName + "&appid=" + apiKey+units;
	}
	
	/**
	 * Extract the specific temperature element from the JSON file provided by the Open Weather Web 
	 * @param jsonData		JSONOject that contains JSONObject "main" which contains JSONObject "temp"
			
	 * @return
	 * @throws JSONException
	 */
	public static String getTemp(String jsonData) throws JSONException {
        JSONObject data = new JSONObject(jsonData);
		String weatherinfo = data.getJSONObject("main").get("temp").toString();
		System.out.println(weatherinfo + " degrees Fahrenheit");
		return weatherinfo;
	}
	
	public static String connecting (String cityName) throws IOException, JSONException {
		try {
			URL myurl = new URL(structURL(cityName));
			connect = 
					(HttpURLConnection) myurl.openConnection();
			connect.setRequestMethod("GET");
			
			 StringBuilder content;
			 try (BufferedReader in = new BufferedReader(
	                 new InputStreamReader(connect.getInputStream()))) {

	             String line;
	             content = new StringBuilder();

	             while ((line = in.readLine()) != null) {
	                 content.append(line + "\n");
	             }
	         }
			 return content.toString();
			}finally {
				connect.disconnect();
			}
		}
}
	