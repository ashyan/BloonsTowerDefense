package BloonsTowerDefense;

import java.awt.Color;

public class Bloon {
	private int[] coordinates;
	public int layers;
	public int currentDelay;
	public String needsToSummonNextBloon = "not started";
	public String direction;
	
	// Red: 1 layer, speed 1000
	// Blue: 2 layers, speed 900
	// Green: 3 layers, speed 800
	// Yellow: 4 layers, speed 700
	// Pink: 5 layers, speed 600
	// Cyan (small): 6 layers, speed 500
	// Black (small): 7 layers, speed 400
	// Clay: 8 layers, speed 1000
	// Lead: 9 layers, speed 1500
	
	public Bloon(String s) {
		layers=-1;
		if (s.equals("red")) layers = 1;
		if (s.equals("blue")) layers = 2;
		if (s.equals("green")) layers = 3;
		if (s.equals("yellow")) layers = 4;
		if (s.equals("pink")) layers = 5;
		if (s.equals("cyan")) layers = 6;
		if (s.equals("black")) layers = 7;
		if (s.equals("clay")) layers = 8;
		if (s.equals("lead")) layers = 9;
	}
	
	public Color getColor() {
		switch (layers) {
			case (1): return Color.RED;
			case (2): return Color.BLUE;
			case (3): return Color.GREEN;
			case (4): return Color.YELLOW;
			case (5): return Color.PINK;
			case (6): return Color.CYAN;
			case (7): return Color.BLACK;
			case (8): return new Color(224, 155, 76);
			case (9): return Color.GRAY;
			default: return null;
		}
	}
	
	public int getSpeed() {
		switch (layers) {
			case (1): return 750;
			case (2): return 650;
			case (3): return 550;
			case (4): return 450;
			case (5): return 350;
			case (6): return 250;
			case (7): return 150;
			case (8): return 1000;
			case (9): return 1500;
			default: return -1;
		}
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}

	public int[] calculateTileOffset(String inputDirection) {
		int[] results = new int[]{0,0};
		int xCoordAdd = ((int) (( ((float) currentDelay) / ((float) getSpeed()) ) * BloonsRunner.PATH_WIDTH)) - 25;
		int yCoordAdd = ((int) (( ((float) currentDelay) / ((float) getSpeed()) ) * BloonsRunner.PATH_WIDTH)) - 25;

		if(inputDirection.equals("up")) {
			xCoordAdd = 0;
			yCoordAdd *= -1;
		} else if(inputDirection.equals("down")) {
			xCoordAdd = 0;
		}  else if(inputDirection.equals("left")) {
			xCoordAdd *= -1;
			yCoordAdd = 0;
		}  else if(inputDirection.equals("right")) {
			yCoordAdd = 0;
		}

		if(inputDirection.contains(" ")) {
			int spaceInd = inputDirection.indexOf(' ');
			String firstDir = inputDirection.substring(0, spaceInd);
			String nextDir = inputDirection.substring(spaceInd + 1);
			int[] nextResult;
			if(currentDelay > getSpeed()/2) {
				nextResult = calculateTileOffset(nextDir);
			} else {
				nextResult = calculateTileOffset(firstDir);
			}

			xCoordAdd = nextResult[0];
			yCoordAdd = nextResult[1];
		}

		results[0] = xCoordAdd;
		results[1] = yCoordAdd;

		return results;
	}

	public String calculateDirection(int[][] coords, int i, boolean recursive) {
		String newDirection = direction;
		if(i != coords.length - 1) {
			int xDir = 0;
			int yDir = 0;
			xDir = coords[i + 1][0] - coords[i][0];
			yDir = coords[i + 1][1] - coords[i][1];
			if(xDir != 0) {
				newDirection = xDir > 0 ? "right" : "left";
			} else if(yDir != 0) {
				newDirection = yDir > 0 ? "down" : "up";
			}

			if(recursive) {
				String nextDirection = calculateDirection(coords, i + 1, false);
				if (!newDirection.equals(nextDirection)) {
					newDirection = newDirection + " " + nextDirection;
				}
			}
		}

		return newDirection;
	}

	public void initiate(int[][] coordinatesParam) {
		if (coordinates == null) {
			coordinates = coordinatesParam[0];
			direction = calculateDirection(coordinatesParam, 0, true);
			return;
		}
	}
	
	public void move(int[][] coordinatesParam) {
		if (coordinates == null) return;
		
		currentDelay += BloonsWindow.FPSDelay;
		if (currentDelay >= getSpeed()) {
			currentDelay = 0;
			
			if (needsToSummonNextBloon == "not started") {
				needsToSummonNextBloon = "true";
			} else if (needsToSummonNextBloon.equals("true")) {
				needsToSummonNextBloon = "false";
			}
			
			for (int i = 0; i < coordinatesParam.length; i ++) {
				if (coordinatesParam[i] == coordinates) {
					if (i + 1 == coordinatesParam.length) {
						BloonsRunner.health -= layers;
						coordinates = new int[] {-1, -1};
					} else {
						coordinates = coordinatesParam[i + 1];
					}

					direction = calculateDirection(coordinatesParam, i, true);

					return;
				}
			}
		}
	}
	
	public void pop() {
		layers --;
		BloonsRunner.money ++;
		if (layers == 0) coordinates = new int[]{-1, -1};
	}
}
