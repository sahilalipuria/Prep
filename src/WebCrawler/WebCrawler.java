package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Queue<String> queue;
	private List<String> discoveredWebList;
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebList = new ArrayList<>();
	}
	
	public void discoverWeb(String root) {
		this.queue.add(root);
		this.discoveredWebList.add(root);
		
		while(!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHtml = readUrl(v);
			System.out.println("rawHtml: " +rawHtml);
			String regexp = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()) {
				String actualUrl = matcher.group();
				if(!this.discoveredWebList.contains(actualUrl)) {
					this.discoveredWebList.add(actualUrl);
					System.out.println("Website Found with url : " + actualUrl);
					this.queue.add(actualUrl);
				}
			}
		}
	}

	private String readUrl(String v) {
		
		String rawHtml = "";
		try {
			URL url = new URL(v);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			while((inputLine=bufferedReader.readLine())!=null) {
				rawHtml += inputLine;
			}
			bufferedReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rawHtml;
	}
	
	

}
