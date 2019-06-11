package BloonsTowerDefense;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class BloonsRunner {

	public static final int WIDTH = 1000, HEIGHT = 550, PATH_WIDTH = 50;

	public static String phase = "pregame";
	public static String gamePhase = "pregame";
	public static int round = 0;
	public static ArrayList<Bloon> currentBloons;
	public static int lastRound = 0;
	public static int health = 50;
	public static int money = 100;
	public static GameMap map;

	public static ArrayList<ArrayList<Bloon>> maps = createBloonTracks();


	public static LinkedHashMap<String, Integer> parseHashFromString(String input){
		LinkedHashMap<String ,Integer> parsedString = new LinkedHashMap<String ,Integer>();

		String[] parsedList = input.split(",");
		for(int i = 0; i < parsedList.length; i+=2){
			parsedString.put(parsedList[i], Integer.parseInt(parsedList[i+1]));
		}
		return parsedString;
	}

	public static ArrayList<Bloon> createBloonTrack(LinkedHashMap<String, Integer> bloonColorCounts){
		ArrayList<Bloon> track = new ArrayList<Bloon>();
		for (String key : bloonColorCounts.keySet()){
			for (int i = 0; i < bloonColorCounts.get(key); i++){
				track.add(new Bloon(key));
			}
		}
		return track;
	}

	public static ArrayList<ArrayList<Bloon>> createBloonTracks(){
		ArrayList<ArrayList<Bloon>> trackList = new ArrayList<ArrayList<Bloon>>();
		// Round 1 -- 20 Red
		trackList.add(createBloonTrack(parseHashFromString("red,20")));

		// Round 2 -- 20 Red, 5 Blue
		trackList.add(createBloonTrack(parseHashFromString("red,20,blue,5")));

		// Round 3 -- 5 Red, 25 Blue
		trackList.add(createBloonTrack(parseHashFromString("red,5,blue,25")));

		// Round 4 -- 20 Red, 25 Blue, 5 Green
		trackList.add(createBloonTrack(parseHashFromString("red,20,blue,25,green,5")));

		// Round 5 -- 30 Green
		trackList.add(createBloonTrack(parseHashFromString("green,30")));

		// Round 6 -- 10 Red, 10 Blue, 12 Green, 2 Yellow
		trackList.add(createBloonTrack(parseHashFromString("red,10,blue,10,green,12,yellow,2")));

		// Round 7 -- 100 Red, 23 Green, 4 Yellow
		trackList.add(createBloonTrack(parseHashFromString("red,100,green,23,yellow,4")));

		// Round 8 -- 20 Red, 12 Green, 5 Yellow, 3 Pink
		trackList.add(createBloonTrack(parseHashFromString("red,20,green,12,yellow,3,pink,3")));

		// Round 9 -- 20 Yellow
		trackList.add(createBloonTrack(parseHashFromString("yellow,20")));

		// Round 10 -- 10 Green, 15 Yellow, 10 Pink
		trackList.add(createBloonTrack(parseHashFromString("green,10,yellow,15,pink,10")));

		// Round 11 -- 20 Pink
		trackList.add(createBloonTrack(parseHashFromString("pink,10")));

		// Round 12 -- 5 Black, 4 Cyan
		trackList.add(createBloonTrack(parseHashFromString("black,5,cyan,4")));

		// Round 13 -- 50 Yellow
		trackList.add(createBloonTrack(parseHashFromString("yellow,50")));

		// Round 14 -- 25 Yellow, 20 Pink
		trackList.add(createBloonTrack(parseHashFromString("yellow,25,pink,20")));

		// Round 15 -- 120 Red, 55 Blue, 45 Green, 45 Yellow
		trackList.add(createBloonTrack(parseHashFromString("red,120,blue,55,green,45,yellow,45")));

		// Round 16 -- 10 Clay
		trackList.add(createBloonTrack(parseHashFromString("clay,10")));

		// Round 17 -- 20 Lead
		trackList.add(createBloonTrack(parseHashFromString("lead,20")));

		// Round 18 -- 35 Pink, 25 Cyan, 10 Clay
		trackList.add(createBloonTrack(parseHashFromString("pink,35,cyan,25,clay,10")));

		// Round 19 -- 20 Black, 30 Cyan, 15 Lead, 10 Clay
		trackList.add(createBloonTrack(parseHashFromString("black,20,cyan,30,lead,15,clay,10")));

		// Round 20 -- 10 Black, 10 Cyan, 20 Yellow, 20 Clay, 20 Lead
		trackList.add(createBloonTrack(parseHashFromString("black,10,cyan,10,yellow,20,clay,20,lead,20")));

		// Round 21 -- 60 Black, 60 Cyan
		trackList.add(createBloonTrack(parseHashFromString("black,60,cyan,60")));

		// Round 22 -- 100 Clay
		trackList.add(createBloonTrack(parseHashFromString("clay,100")));

		// Round 23 -- 200 Pink, 10 Lead, 25 Clay
		trackList.add(createBloonTrack(parseHashFromString("pink,200,lead,10,clay,25")));

		// Round 24 -- 70 Black, 200 Lead
		trackList.add(createBloonTrack(parseHashFromString("black,70,lead,200")));

		// Round 25 -- 100 Pink, 200 Clay, 400 Lead
		trackList.add(createBloonTrack(parseHashFromString("pink,100,clay,200,lead,400")));

		return trackList;
	}


	public static void main(String[] args) {
		JFrame f = new JFrame("Bloons Tower Defense");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BloonsWindow w = new BloonsWindow();
		f.add(w);
		f.setSize(WIDTH, HEIGHT);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
