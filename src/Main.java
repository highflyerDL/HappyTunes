
import java.io.IOException;
import java.util.Random;
public class Main {
	public static void main(String[] args)throws Exception{
		Question aQuestion = new Question("Database.txt");
		Random rand=new Random();
		int[] k= new int[aQuestion.numLines()];
		boolean[] isUsed = new boolean[aQuestion.numLines()];
		aQuestion.OpenFile();
		boolean isStarted =false;
		UserInput user = new UserInput();
		int timesofhelp2 = 0;
		SongPlayer mp32= null;
		boolean help2used=false;
		int p =0;
		
		
		//start
		System.out.println("Type START to play, GAMEPLAY to learn how to play.");
		while(user.getStarted()!=true){
		}
		isStarted=true;
		
		
		//mix questions
			for(int m=0;m<aQuestion.numLines();m++){
			while(true){
				k[m] = rand.nextInt(aQuestion.numLines());
					if(isUsed[k[m]]==false)		
						break ;
							else continue;
						}
						isUsed[k[m]]=true;
}
		
			//play
			while(isStarted == true){
			for(int i =0; i<aQuestion.numLines();i++){
				System.out.println("Question " +(i+1));
				SongPlayer mp3=new SongPlayer(aQuestion.getAd(k[i]),true);
				mp3.start();
				while(user.answer(aQuestion.getName(k[i]),aQuestion.getNameArtist(k[i]))!=true){
					
					
					//help2
					if(help2used==true){
						mp32.close();
					}
					System.out.println("You used HELP2. The song is changed.");
					mp3.close();
					//avoid overlapping songs when using too many help2
					if((aQuestion.numLines()-timesofhelp2-1)==i){
						timesofhelp2=0;
					}
					//change index -> change song
					p=k[i];
					k[i]=k[aQuestion.numLines()-timesofhelp2-1];
					k[aQuestion.numLines()-timesofhelp2-1]=p;
					
					//generate new song
					mp32=new SongPlayer(aQuestion.getAd(k[i]),true);
					mp32.start();
					timesofhelp2++;
					help2used=true;
					}
				
			//close threads playing mp3
			mp3.close();
			if(help2used==true){
			mp32.close();
			help2used=false;}
			}
		break;
		
		}	
			System.out.println("Congratulations! You won the game, your score is : "+user.getPoints());
	} 
}
