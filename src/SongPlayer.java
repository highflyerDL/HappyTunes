import javazoom.jl.player.*;
import javazoom.jl.player.advanced.AdvancedPlayer;


import java.io.FileInputStream;
public class SongPlayer extends Thread{
	private FileInputStream fis;
	private AdvancedPlayer playMP3;
	private boolean loop;
	private String song;
	
	//constructor
	public SongPlayer(String song,boolean loop){
		this.song= song;
		this.loop= loop;
	}
	
	//methods
	// thread run
		public void run() {

			    try{
			   do{
			    fis = new FileInputStream(song);
			    playMP3 = new AdvancedPlayer(fis);

			    playMP3.play();
			   }while(loop);
			    }catch(Exception e){System.out.println(e);}			
}
		
		
		public void close(){
			loop = false;
			playMP3.close();
			this.interrupt();
}
}




