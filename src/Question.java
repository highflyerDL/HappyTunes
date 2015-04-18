import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class Question {
	private String path;
 	private int[] id =new int[100];
 	private String[] nameSong = new String[100];
 	private String[] adSong = new String[100];
 	private String[] nameArtist = new String[100];
 	private int numOfLines;
 	
 	//constructor
	public Question(String file_path){
		path=file_path;
	}
	
	//methods
	public String getNameArtist(int k){
		return nameArtist[k];
	}
	
	public String getName(int k){
		return nameSong[k];
	}
	
	public String getAd(int k){
		return adSong[k];
	}
	
	public int getId(int k){
		return id[k];
	}
	
	
	public void OpenFile(){
		FileReader fr;
		try {
		
		fr = new FileReader(path);		
		BufferedReader textReader = new BufferedReader(fr);		
		
			this.numOfLines = numLines();
		
		String[ ] textData = new String[this.numOfLines];
		int i;
		for (i=0; i < this.numOfLines; i++) {
		textData[ i ] = textReader.readLine();
		this.id[i]= Integer.parseInt(textData[i].substring(0,2));
		this.nameSong[i]=textData[i].substring(4,20).replaceAll("\\s","");
		this.adSong[i]=textData[i].substring(41).replaceAll("\\s","");
		this.nameArtist[i]=textData[i].substring(20,37).replaceAll("\\s","");
		}
		
		textReader.close( );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	public int numLines() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines=0;
		
		while ((aLine=bf.readLine()) !=null){
			numberOfLines++;
		}
		bf.close();
		
		return numberOfLines;
	
	}


}
