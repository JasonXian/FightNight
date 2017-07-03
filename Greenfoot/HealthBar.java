import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * HealthBar class for gameworld and characters
 * 
 * @Jason Xian and Adrian Wong
 * @June 15
 */
public class HealthBar extends Actor
{
    private int health = 100;
    private int healthWidth = 300;
    private int healthHeight = 30;
    private int pixelsPerHealth = (int)healthWidth/health;
    private int red = 0;
    private int green = 255;

    public HealthBar(){
        display();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (red > 255){
            red = 255;
        }
        if (green < 0){
            green = 0;
        }
        display();
    }    

    public void display(){
        // creates healthBar based on given variables above 
        setImage (new GreenfootImage(healthWidth + 2, healthHeight + 2)); 
        GreenfootImage img = getImage();
        img.setColor (Color.WHITE);
        img.drawRect(0, 0, healthWidth + 1, healthHeight + 1);
        img.setColor(new Color(red, green, 0));
        img.fillRect(1, 1, health*pixelsPerHealth, healthHeight);
    }

    public void loseHealth(int n){
        //decrease health and changes colour of health 
        health = health - n;
        if (red >= 255){
            red = 255;
        }else{
            red += n + 30;
        }

        if (green <= 0){
            green = 0;
        }else{
            green -= n + 20;
        }
    }

    public int getHealth(){
        // returns health so health can be accessed from other classes using this method 
        return health;
    }
}