package weatherGrabbing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Scanner;

import org.json.JSONException;

public class WeatherDriver {
	public static void main(String[] args)throws MalformedURLException,
    ProtocolException, IOException, JSONException  {
		System.out.print("Where are you? ");
		//prep for scanning information
		Scanner userInput = new Scanner(System.in);
		//scan and store user input
		String temp = userInput.nextLine();
		StringBuilder userCity = new StringBuilder();
		//cleaning out the state abbr.
		String[] splited = temp.split("\\s+");
		for (int i=0; i < splited.length ; i++ ) {
			if (splited[i].length() !=2) {
				userCity.append(splited[i]+ " ");
			}
		}
		System.out.println(userCity+" weather: ");
		//prep for extracting data
		WeatherGrabbing weather = new WeatherGrabbing();
		//extract and print data
		weather.getTemp(weather.connecting(userCity.toString()));
	
	}
}
