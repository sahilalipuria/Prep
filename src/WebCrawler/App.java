package WebCrawler;

public class App {

	public static void main(String[] args) {

		WebCrawler webCrawler = new WebCrawler();
		
		webCrawler.discoverWeb("http://www.github.com");
	}

}
