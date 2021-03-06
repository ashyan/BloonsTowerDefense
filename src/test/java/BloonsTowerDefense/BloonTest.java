package BloonsTowerDefense;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BloonTest {
    @Test
    public void testBloonsSpawn(){
        Bloon bloon1 = new Bloon("red");
        Bloon bloon2 = new Bloon("blue");
        Bloon bloon3 = new Bloon("green");
        Bloon bloon4 = new Bloon("yellow");
        Bloon bloon5 = new Bloon("pink");
        Bloon bloon6 = new Bloon("cyan");
        Bloon bloon7 = new Bloon("black");
        Bloon bloon8 = new Bloon("clay");
        Bloon bloon9 = new Bloon("lead");

        assertEquals(1, bloon1.layers);
        assertEquals(2, bloon2.layers);
        assertEquals(3, bloon3.layers);
        assertEquals(4, bloon4.layers);
        assertEquals(5, bloon5.layers);
        assertEquals(6, bloon6.layers);
        assertEquals(7, bloon7.layers);
        assertEquals(8, bloon8.layers);
        assertEquals(9, bloon9.layers);
    }

    @Test
    public void testBloonAttributes(){
        Bloon bloon1 = new Bloon("red");
        Bloon bloon2 = new Bloon("blue");
        Bloon bloon3 = new Bloon("green");
        Bloon bloon4 = new Bloon("yellow");
        Bloon bloon5 = new Bloon("pink");
        Bloon bloon6 = new Bloon("cyan");
        Bloon bloon7 = new Bloon("black");
        Bloon bloon8 = new Bloon("clay");
        Bloon bloon9 = new Bloon("lead");

        assertEquals(Color.RED, bloon1.getColor());
        assertEquals(Color.BLUE, bloon2.getColor());
        assertEquals(Color.GREEN, bloon3.getColor());
        assertEquals(Color.YELLOW, bloon4.getColor());
        assertEquals(Color.PINK, bloon5.getColor());
        assertEquals(Color.CYAN, bloon6.getColor());
        assertEquals(Color.BLACK, bloon7.getColor());
        assertEquals(new Color(224, 155, 76), bloon8.getColor());
        assertEquals(Color.GRAY, bloon9.getColor());

        assertEquals(750, bloon1.getSpeed());
        assertEquals(650, bloon2.getSpeed());
        assertEquals(550, bloon3.getSpeed());
        assertEquals(450, bloon4.getSpeed());
        assertEquals(350, bloon5.getSpeed());
        assertEquals(250, bloon6.getSpeed());
        assertEquals(150, bloon7.getSpeed());
        assertEquals(1000, bloon8.getSpeed());
        assertEquals(1500, bloon9.getSpeed());
    }

    @Test
    public void testBloonsPop(){
        Bloon bloon = new Bloon("lead");
        Color[] array = { null ,Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.CYAN, Color.BLACK, new Color(224, 155, 76), Color.GRAY};
        for (int i = 9; i >= 0; i--){
            assertEquals(i, bloon.layers);
            assertEquals(array[i], bloon.getColor());
            bloon.pop();
        }
      
        assertEquals(-1, bloon.getCoordinates()[0]);
        assertEquals(-1, bloon.getCoordinates()[1]);
        bloon.pop();
        assertEquals(-2,bloon.layers);

    }
  
    @Test
    public void testSpriteSpawn(){
        Sprite sprite1 = new Sprite(0, 0) {
            @Override
            public void shoot() {

            }

            @Override
            public void draw(Graphics g) {

            }
        };
        assertEquals(0,sprite1.getX());
        assertEquals(0,sprite1.getY());
        Sprite sprite2 = new Sprite(100, 100) {
            @Override
            public void shoot() {

            }

            @Override
            public void draw(Graphics g) {

            }
        };
        assertEquals(100,sprite2.getX());
        assertEquals(100,sprite2.getY());
        Sprite monkey1 = new MonkeySprite(3,4);
        assertEquals(3,monkey1.getX());
        assertEquals(4,monkey1.getY());
        Sprite ninja1 = new NinjaSprite(5,6);
        assertEquals(5,ninja1.getX());
        assertEquals(6,ninja1.getY());
        Sprite super1 = new SuperMonkeySprite(7,8);
        assertEquals(7,super1.getX());
        assertEquals(8,super1.getY());


    }

//    @Test
//    public void testWin() {
//        BloonsRunner.round = BloonsRunner.maps.size();
//        BloonsRunner.phase = "game";
//        BloonsRunner.gamePhase = "game";
//        BloonsRunner.currentBloons = BloonsRunner.maps.get(BloonsRunner.maps.size() - 1);
//        BloonsRunner w1 = new BloonsRunner();
//        w1.main(new String[]{""});
//        try { Thread.sleep(1000); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
////        try { Thread.sleep(100); }
////        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("won", BloonsRunner.gamePhase);
//
//        BloonsWindow w2 = new BloonsWindow();
//        BloonsRunner.round = BloonsRunner.lastRound - 1;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        w2.endRound();
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertNotEquals("won", BloonsRunner.gamePhase);
//
//        BloonsWindow w3 = new BloonsWindow();
//        BloonsRunner.round = 0;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        w3.endRound();
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertNotEquals("won", BloonsRunner.gamePhase);
//
//        BloonsWindow w4 = new BloonsWindow();
//        BloonsRunner.round = BloonsRunner.lastRound + 1;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        w4.endRound();
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("won", BloonsRunner.gamePhase);
//    }
//
//    @Test
//    public void testLoss() {
//        BloonsWindow w1 = new BloonsWindow();
//        BloonsRunner.health = 0;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("lost", BloonsRunner.gamePhase);
//
//        BloonsWindow w2 = new BloonsWindow();
//        BloonsRunner.health = -1;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("lost", BloonsRunner.gamePhase);
//
//        BloonsWindow w3 = new BloonsWindow();
//        BloonsRunner.health = 1;
//        try { Thread.sleep(100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("lost", BloonsRunner.gamePhase);
//
//        BloonsWindow w4 = new BloonsWindow();
//        BloonsRunner.health = 10;
//        int waitTime = 10 * (BloonsRunner.maps.get(0).size()) + (BloonsRunner.map.getPath().length * BloonsRunner.map.getPath()[0].length);
//        try { Thread.sleep(waitTime + 100); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("lost", BloonsRunner.gamePhase);
//
//        BloonsWindow w5 = new BloonsWindow();
////        Bloon[] newBloons = {};
//        BloonsRunner.health = 0;
////        BloonsRunner.currentBloons = newBloons;
//        try { Thread.sleep(10); }
//        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
//        assertEquals("lost", BloonsRunner.gamePhase);
//    }

    @Test
    public void testMoney() {
        int testMoney = BloonsRunner.money;

        Bloon red = new Bloon("red");
        Bloon blue = new Bloon("blue");
        Bloon green = new Bloon("green");
        Bloon black = new Bloon("black");
        Bloon lead = new Bloon("lead");

        while(red.layers != 0) {
            red.pop();
        }
        testMoney += 1;
        assertEquals(BloonsRunner.money, testMoney);


        while(blue.layers != 0) {
            blue.pop();
        }
        testMoney += 2;
        assertEquals(BloonsRunner.money, testMoney);

        while(green.layers != 0) {
            green.pop();
        }
        testMoney += 3;
        assertEquals(BloonsRunner.money, testMoney);

        while(black.layers != 0) {
            black.pop();
        }
        testMoney += 7;
        assertEquals(BloonsRunner.money, testMoney);

        while(lead.layers != 0) {
            lead.pop();
        }
        testMoney += 9;
        assertEquals(BloonsRunner.money, testMoney);

    }

}
