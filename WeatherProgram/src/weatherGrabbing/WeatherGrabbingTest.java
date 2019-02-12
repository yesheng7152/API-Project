package weatherGrabbing;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.Before;

class WeatherGrabbingTest {

	@Test
	public void testStructURL() {
		assertEquals(
				"http://api.openweathermap.org/data/2.5/weather?q=Grinnell"
				+ "&appid=f49d16d1bd98e2e85425e79c3a85eabe&units=imperial",
				WeatherGrabbing.structURL("Grinnell"), "Grinnell as the city");
	}
	

	@Test
	public void testGetTemp() throws JSONException {
		String mockJSON ="{\"coord\":"
				+ "{\"lon\":-87.62,\"lat\":41.88},"
				+ "\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"},"
				+ "{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"},"
				+ "{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],"
				+ "\"base\":\"stations\",\"main\":{\"pressure\":999,\"temp\":-33.42,\"humidity\":88,\"temp_min\":32,\"temp_max\":35.96},"
				+ "\"visibility\":12874,\"wind\":{\"speed\":12.75,\"deg\":250},\"rain\":{\"1h\":0.25},\"clouds\":{\"all\":90},\"dt\":1549995720,"
				+ "\"sys\":{\"type\":1,\"id\":5228,\"message\":0.0047,\"country\":\"US\",\"sunrise\":1549975764,\"sunset\":1550013632},"
				+ "\"id\":4887398,\"name\":\"Chicago\",\"cod\":200}";
		String mockJSON2 ="{\"coord\":"
				+ "{\"lon\":-87.62,\"lat\":41.88},"
				+ "\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"},"
				+ "{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"},"
				+ "{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],"
				+ "\"base\":\"stations\",\"main\":{\"pressure\":999,\"temp\":0,\"humidity\":88,\"temp_min\":32,\"temp_max\":35.96}}";
		
		assertEquals("-33.42", WeatherGrabbing.getTemp(mockJSON), "temp at a different position in the array and negative");
		assertEquals("0", WeatherGrabbing.getTemp(mockJSON2), "temp is 0");
	}

}
