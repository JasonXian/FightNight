import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Platform Actor
 * 
 * Adrian Wong Jason Xian
 * @version (June 15)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Platform() 
    {
        GreenfootImage img = getImage();
        img.scale (img.getWidth()+500, img.getHeight());
        setImage (img);
    }    
}
