package weatherGrabbing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Scanner;

import org.json.JSONException;

public class WeatherDriver {
	public static void main(String[] args)throws MalformedURLException,
    ProtocolException, IOException, JSONException  {
		String UserCity;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Where are you? ");
		UserCity= userInput.next();
		
		WeatherGrabbing weather = new WeatherGrabbing();
		System.out.println(UserCity+" weather: ");
		WeatherGrabbing.GetJSONfile(UserCity);
	}
}
