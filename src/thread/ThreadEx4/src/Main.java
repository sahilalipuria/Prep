import java.io.IOException;

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
		
		new Thread(new CopyTask(sourceFile1, destFile1)).start();
		
		new Thread(new CopyTask(sourceFile2, destFile2)).start();
	}

}
