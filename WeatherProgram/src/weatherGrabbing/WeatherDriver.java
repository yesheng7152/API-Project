package weatherGrabbing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Scanner;

import org.json.JSONException;

public class WeatherDriver {
	public static void main(String[] args)throws MalformedURLException,
    ProtocolException, IOException, JSONException  {
		String userCity;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Where are you? ");
		userCity= userInput.next();
		System.out.println(userCity+" weather: ");
		WeatherGrabbing weather = new WeatherGrabbing();
		weather.getTemp(weather.connecting(userCity));
		

	}
}
