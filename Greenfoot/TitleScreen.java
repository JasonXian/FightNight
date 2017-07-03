import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen World/Main Menu 
 * 
 * @Adrian Wong Jason Xian 
 * @version (7.0, June 15)
 */
public class TitleScreen extends World
{
    int ArrowCounterOne = 1;
    int ArrowCounterTwo = 3;
    int ArrowCounterThree = 5;
    ArrowButton arrow = new ArrowButton();
    ArrowButton arrow2 = new ArrowButton();
    ArrowButton arrow3 = new ArrowButton();
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(1000, 600, 1); 
    }

    public void act(){
        addArrow();
        removeArrow();
        Advance();
    }

    /**
     * This method checks if the mouse is over a certain area on the screen and adds 
     * an arrow actor according to where the mouse is hovering
     */
    private void addArrow(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (ArrowCounterOne == 1){ // check if arrow exists for the "new game", so the remove method will not remove an object that does not exist
            if (mouse!=null&&mouse.getX() > 400 && mouse.getX() < 536 && mouse.getY()> 400 && mouse.getY() <430){ // check mouse location
                addObject(arrow,380,416);  
                ArrowCounterOne = 0;
            }
        }
        if (ArrowCounterTwo == 3){ // check if arrow exists for the "controls", so the remove method will not remove an object that does not exist
            if (mouse!=null&&mouse.getX() > 400 && mouse.getX() < 598 && mouse.getY()> 448 && mouse.getY() <478){
                addObject(arrow2,380,462); 
                ArrowCounterTwo = 2 ;
            }
        }
        if (ArrowCounterThree == 5){
            if (mouse!= null && mouse.getX() > 400 && mouse.getX() < 645 && mouse.getY() > 355 && mouse.getY() < 385){
                addObject (arrow3, 380, 370);
                ArrowCounterThree = 4;
            }
        }
    }

    /**
     * This method removes the arrow actor if the mouse leaves the respective space
     */
    private void removeArrow(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (ArrowCounterOne == 0){ // check if arrow exists, so that the remove method can be accessed
            if (mouse!= null && mouse.getX() < 400 || mouse.getX() > 536 || mouse.getY()< 400 || mouse.getY() > 430){
                removeObject(arrow);
                ArrowCounterOne = 1; // resets arrow check so that the arrow can be added back
            }
        }
        if (ArrowCounterTwo ==2){ // check if arrow exists, so that the remove method can be accessed
            if (mouse!= null && mouse.getX() < 400 || mouse.getX() > 598 || mouse.getY()< 448 || mouse.getY() > 478){
                removeObject(arrow2);
                ArrowCounterTwo = 3; // resets arrow check so that the arrow can be added back
            }
        }
        if (ArrowCounterThree == 4){
            if (mouse!= null && mouse.getX() < 400 || mouse.getX() > 645 || mouse.getY() < 355 || mouse.getY() > 385){
                removeObject(arrow3);
                ArrowCounterThree = 5;
            }
        }
    }

    /**
     * This method checks if the mouse if hovering over an option and checks if the user clicks the mouse.
     * It then changes the world depending on what the user clicks
     */
    private void Advance(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse!=null&&mouse.getX() > 400 && mouse.getX() < 536 && mouse.getY()> 400 && mouse.getY() < 430){
            if (Greenfoot.mouseClicked(null)){ // start a new game
                Greenfoot.setWorld(new CharacterSelection(0));
            }
        }
        if (mouse!=null&&mouse.getX() > 400 && mouse.getX() < 598 && mouse.getY()> 448 && mouse.getY() < 478){
            if (Greenfoot.mouseClicked(null)){ // go to controls screen
                Greenfoot.setWorld(new Instructions());
            }
        }
        if (mouse!= null && mouse.getX() > 400 && mouse.getX() < 645 && mouse.getY() > 355 && mouse.getY() < 385){
            if (Greenfoot.mouseClicked(null)){
                Greenfoot.setWorld(new CharacterSelection(1));
            }
        }
    }
}
