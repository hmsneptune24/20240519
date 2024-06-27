package to.msn.wings.selfjava.chap01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class timer{
	public static void main(String[] args){
		System.out.print("Stop at [s] = ");
		/*
        Scanner myNum = new Scanner(System.in);
  		int userInput = myNum.nextInt();
        */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				clearConsole();
				LocalDateTime date = LocalDateTime.now();
				String text = date.format(formatter);
				System.out.println(text);
			}
		};

        timer.scheduleAtFixedRate(task, 0, 1000);

        /*
		TimerTask stopTask = new TimerTask(){
			@Override
			public void run(){
				timer.cancel();
				LocalDateTime date = LocalDateTime.now();
				String text = date.format(formatter);
				System.out.println("Timer stopped at: " + text);
			}
		};
		
		timer.schedule(stopTask, 1000*userInput);
        */
	}

	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else{
				System.out.print("\033[H\033[2J"); //Unix
				System.out.flush();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}