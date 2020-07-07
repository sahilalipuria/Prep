import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.io.utils.IOUtils;

class CopyTask implements Runnable {
	
	String sourceFile;
	String destFile;
	
	public CopyTask(String sourceFile, String destFile) {
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}
	
	public void run() {
		try {
			IOUtils.copyFile(sourceFile, destFile);
			System.out.println("Copied from - " + sourceFile + " to " + destFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		
		String sourceFile1 = "a.txt";
		String sourceFile2 = "b.txt";
		
		String destFile1 = "c.txt";
		String destFile2 = "d.txt";
		
		// 100 files -> 10 threads
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new CopyTask(sourceFile1, destFile1));
		executor.execute(new CopyTask(sourceFile2, destFile2));
		
	}

}
