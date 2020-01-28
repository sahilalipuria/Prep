package test.jersey.series.headerparam;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class TestHeaderParam {

	public static void main(String[] args) {

		// setting & invoking first request
		System.out.println("Using @HeaderParam");
		System.out.println("---------------------");
		String url = "http://localhost:8080/Jersey-HeaderParam/rest/bookservice/getheader";
		String responseString1 = testGetHeaders(url);
		System.out.println("Response String for First Service : \n\n" + responseString1);

		// setting & invoking second request
		System.out.println("\n\nUsing @Context");
		System.out.println("---------------------");
		String url2 = "http://localhost:8080/Jersey-HeaderParam/rest/bookservice/getallheader";
		String responseString2 = testGetHeaders(url2);
		System.out.println("Response String for Second Service : \n\n" + responseString2);
	}

	public static String testGetHeaders(String httpURL) {

		// local variables
		ClientConfig clientConfig = null;
		Client client = null;
		WebTarget webTarget = null;
		Builder builder = null;
		Response response = null;
		int responseCode;
		String responseMessageFromServer = null;
		String responseString = null;

		try{
			// invoke service after setting necessary parameters
			clientConfig = new ClientConfig();
			client =  ClientBuilder.newClient(clientConfig);
			//			client.property("Content-Type", MediaType.TEXT_PLAIN);
			//			client.property("accept", MediaType.TEXT_PLAIN);
			webTarget = client.target(httpURL);

			// invoke service
			builder = webTarget.request(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN);
			response = builder.get();

			// get response code
			responseCode = response.getStatus();
			System.out.println("Response code: " + responseCode);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + responseCode);
			}

			// get response message
			responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
			System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

			// get response string
			responseString = response.readEntity(String.class);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			// release resources, if any
			response.close();
			client.close();
		}
		return responseString;
	}
}