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

	
	/**
	 * Takes the cityName provided and generate a new URL that will be used for connecting to 
	 * OpenWeatherWeb
	 * @param cityName	a string, name of the city
	 * @return			a string of the new url with cityName 
	 */
	public static String structURL(String cityName) {
		return baseurl + cityName + "&appid=" + apiKey + units;
	}
	
	
	/**
	 * Extract the temperature element from the JSON object 
	 * @param jsonData		a string of JSON with specific format, such that "temp" JSONobject is followed 
	 * 						by a number value that represent the current temperature, and "temp" 
	 * 						JSONobject is inside the array of the "main" JSONobject
	 * @return				a string, the current temperature value provided by jsonData
	 * @throws JSONException
	 */
	public static String getTemp(String jsonData) throws JSONException {
		//create JSONObject parsing 
        JSONObject data = new JSONObject(jsonData);
        //extract the information
		String weatherinfo = data.getJSONObject("main").get("temp").toString();
		System.out.println(weatherinfo + " degrees Fahrenheit");
		return weatherinfo;
	}
	
	/**
	 * Connect and send get request to OpenWeatherWeb(OWW) using API, read the JSON file provided
	 * by the OWW, then store it.
	 * @param cityName		a string, for the parameter of the structURL method
	 * @return				a string, the JSON file received will be converted to string
	 * @throws IOException
	 * @throws JSONException
	 */
	public static String connecting (String cityName) throws IOException, JSONException {
		try {
			URL myurl = new URL(structURL(cityName));
			//to open the connection
			connect = 
					(HttpURLConnection) myurl.openConnection();
			//get request send
			connect.setRequestMethod("GET");
			//reading and storing the JSON file 
			 StringBuilder content= new StringBuilder();
			 try (BufferedReader received = new BufferedReader(
	                 new InputStreamReader(connect.getInputStream()))) {
	             String tempStoring;
	             while ((tempStoring = received.readLine()) != null) {
	                 content.append(tempStoring + "\n");
	             }
	         }
			 return content.toString();
			 //to close the connection 
			}finally {
				connect.disconnect();
			}
		}
}
	