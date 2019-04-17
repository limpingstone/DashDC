package app.asset;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class AssetWeather extends DashboardAsset implements Serializable {
	
	// String to hold weather location
	private String location;

	// String to hold API key
	private String key;

	// String to hold retrieved API content
	private String apiContent;

	// String to determine the weather status 
	private String weather; 

	// String to indicate temperature in Celcius
	private int temperature; 

	// Constructor takes parameters id, name, location and key for the asset
    // Calls the parent constructor on id and name
    // Sets the other field variables as appropriate
	public AssetWeather(int id, String name, String location, String key) {
		super(id, name);
		this.location = location;
		this.key = key;
		try {
			this.apiContent = requestApiContent(location, key);
		}
		catch (Exception e) {
			System.out.println("Error requesting weather information from API");
		}
		
	}

	// Sets the location variable of the asset 
	public void setLocation(String location) {
		this.location = location;
	}

	// Returns the location variable of the asset 
	public String getLocation() {
		return location;
	}

	// Sets the key variable of the asset 
	public void setKey(String key) {
		this.key = key;
	}

	// Returns the key variable of the asset 
	public String getKey() {
		return key;
	}

	// Sets the API content variable of the asset 
	public void setApiContent(String apiContent) {
		this.apiContent = apiContent;
	}

	// Returns the API content variable of the asset 
	public String getApiContent() {
		return apiContent;
	}


	// Uses the OpenWeatherMap API to retrieve weather information
	// Returns string containing key value pairs
	public static String requestApiContent(String location, String key) throws Exception {
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + key;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		System.out.println("Sending 'GET' request to URL: " + url);
		System.out.println("Response Code: " +  con.getResponseCode());

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

    // Pulls new weather data from API
    public void refresh() {
	try {
	    setApiContent(requestApiContent(location, key));
	}
	catch (Exception e) {
	    System.out.println("Error requesting weather information from API");
	}
    }
    
	// Returns a String of the HTML code to display the weather asset
    @Override
    public String display() {
	refresh(); // update weather info
        String retStr = "<br>";
	// specify the weather text
	retStr += getApiContent();
	retStr += "<br>";
	retStr += "<form action='refresh' method='post'>";
	retStr += "<input type='submit' name='submit' value='Refresh'> <br>";
	retStr += "</form>";
	
	return retStr;
    }
}
