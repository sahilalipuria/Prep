package mazeSolving;

import java.io.File;
import java.util.Scanner;

public class FileReader {

	private int numOfRows;
	private int numOfColumns;
	private int startRowPos;
	private int startColPos;
	private String fileName;
	private int[][] map;
	public FileReader(int numOfRows, int numOfColumns, String fileName) {
		//super();
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		this.fileName = fileName;
		this.map = new int[numOfRows][numOfColumns];
	}
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getNumOfColumns() {
		return numOfColumns;
	}
	public void setNumOfColumns(int numOfColumns) {
		this.numOfColumns = numOfColumns;
	}
	public int getStartRowPos() {
		return startRowPos;
	}
	public void setStartRowPos(int startRowPos) {
		this.startRowPos = startRowPos;
	}
	public int getStartColPos() {
		return startColPos;
	}
	public void setStartColPos(int startColPos) {
		this.startColPos = startColPos;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public void parseFile() {
		try {
			Scanner sc = new Scanner(new File(this.fileName));
			for(int i=0;i<this.numOfRows;i++) {
				for(int j=0;j<this.numOfColumns;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==2) {
						this.startRowPos = i;
						this.startColPos = j;
					}
				}
			}
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
