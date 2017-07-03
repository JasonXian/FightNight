import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Text Actor to be used when drawing text images on the screen
 * 
 * @Adrian Wong Jason Xian
 * @version (June 15)
 */
public class Text extends Actor
{
    private String text;
    private GreenfootImage image;
    private Font font = new Font("Matura MT Script Capitals",Font.PLAIN,20);
    private Color fontW = Color.GREEN;
    private Color fontB = new Color(0,0,0,0);
    public Text(String str){
        text = str;
        image = new GreenfootImage (text, 40, Color.WHITE, fontB);
        image.setFont(font);
        setImage (image);
    }

    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
