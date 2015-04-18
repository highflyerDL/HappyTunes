import java.util.Scanner;
public class UserInput {
	private boolean right;
	private String userAnswer;
	private int points,i;
	
	//constructor
	public UserInput(){
	points=10;
	i=0;
	}
	
	//methods
	public boolean answer(String songName,String nameArtist){
		Scanner checker = new Scanner(System.in);
		while(checker.hasNext()){
			userAnswer = checker.nextLine().replaceAll("\\s","");
			if(songName.equalsIgnoreCase(userAnswer))
				break;		
			
			//HELP1
			else if("HELP1".equalsIgnoreCase(userAnswer)){
				if(this.points>=10){
					i++;
					System.out.println("You used 10 points for Help 1, "+(this.points-10)+" points left! "+ "The answer will reveal "+i*2+" starting letters :");
					System.out.println(songName.substring(0,i*2));
					this.points = this.points - 10;			
				}else System.out.println("Insufficient points to use any help!");}
			
			//HELP3
			
			else if("HELP3".equalsIgnoreCase(userAnswer)){
				if(this.points>=10){
				this.points = this.points - 10;
				System.out.println("You used 10 points for Help 3. "+(this.points)+" points left! ");
				System.out.println("The singer is: ");
				System.out.println(nameArtist);
				} else System.out.println("Insufficient points to use any help!");}
			
			//HELP2
			else if("HELP2".equalsIgnoreCase(userAnswer)){
				if(this.points>=10){
				this.points = this.points - 10;
				System.out.println("You used 10 points for Help 2, "+(this.points)+" points left! ");
				return false;
			}else System.out.println("Insufficient points to use any help!");}
				else System.out.println("Try again !. Remember: type HELP1, HELP2 or HELP3 for helps");
			
			
			}
		i=0;
		this.points=this.points+10;
		System.out.println("Congratulations! You got 10 points! The key is : "+songName+" .Your total points right now are "+this.points);
		return true; }

	public int getPoints(){
		return this.points;
	}
	
	public boolean getStarted(){
		Scanner checker1 = new Scanner(System.in);
		while(checker1.hasNext()){
			String string1 = checker1.nextLine();
			if("START".equalsIgnoreCase(string1))
				break;
			else if("GAMEPLAY".equalsIgnoreCase(string1)){
				System.out.println("You will listen to 15 seconds of a piece of song. Enter the name of the song to get 10 points. ");
				System.out.println("You may use 10 points to get hints. You can use as many helps as possible if you have enough points.");
				System.out.println("Type HELP1 to reveal 2 starting letter of the answer.");
				System.out.println("Type HELP2 to change the song.");
				System.out.println("Type HELP3 to get the artist's name.");
					}}
		System.out.println("Game's now started! You first have 10 points. Use it wisely !");
		return true;}
}