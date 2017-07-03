import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Introduction world 
 * 
 * Adrian Wong Jason Xian
 * @version (7.0 June 15)
 */
public class Instructions extends World
{
    int ArrowCounterOne = 1;
    ArrowButton arrow = new ArrowButton();
    
    public Instructions()
    {    
        super(1000, 600, 1); 
    }

    public void act(){
        addArrow();
        removeArrow();
        Advance();
    }

    /**
     * This method checks where the location of the mouse is and adds an arrow button if hovering over the "RETURN" text
     */
    private void addArrow(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (ArrowCounterOne == 1){ // check if arrow exists for the "new game", so the remove method will not remove an object that does not exist
            if (mouse!=null&&mouse.getX() > 850 && mouse.getX() < 975 && mouse.getY()> 545 && mouse.getY() < 575){ // check mouse location
                addObject(arrow,845,558);  
                ArrowCounterOne = 0;
            }
        }
    }
    
    /**
     * This method removes the arrow if outside the "RETURN" text
     */
    private void removeArrow(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (ArrowCounterOne == 0){ // check if arrow exists for the "new game", so the remove method will not remove an object that does not exist
            if (mouse!=null&&mouse.getX() < 850 || mouse.getX() > 975 || mouse.getY() < 545 || mouse.getY() > 575){ // check mouse location
                removeObject(arrow);
                ArrowCounterOne = 1;
            }
        }
    }

    /**
     * This method returns the user back to the title screen if they click the "RETURN" button
     */
    private void Advance(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse!=null&&mouse.getX() > 850 && mouse.getX() < 975 && mouse.getY()> 545 && mouse.getY() < 575){ // check mouse location
            if (Greenfoot.mouseClicked(null)){
                Greenfoot.setWorld(new TitleScreen());
            }
        }
    }
}
