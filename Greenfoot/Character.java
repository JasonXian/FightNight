import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Character class for player 1. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    int vspeed = 0;
    int gravity = 1;
    boolean jumped = false;
    boolean walked = false;
    boolean punched = false;
    boolean kicked = false;
    boolean blocked = false;
    boolean playerTwoBlocked = false;
    boolean playerTwoDead = false;
    boolean crouched = false;
    boolean death = false;
    boolean victory = false;  
    HealthBar playerTwoHealth;
    HealthBar playerOneHealth;
    Text text;
    int jumpTimer = 0;
    int punchTimer = 0;
    int kickTimer = 0;
    boolean online = false;

    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    //game type 0 = local, 1 = online
    public Character(int game){
        if(game == 1) online = true;
    }

    public void act() 
    {
        if (!(getWorld()instanceof CharacterSelection)){
            jumpTimer ();
            punchTimer();
            kickTimer();
            getPlayerOneHealthBar();
            getPlayerTwoHealthBar();
            dead();
            fall();
            isTouching();
            movement();
            jumping();
            crouching();
            blocking();
            punching();
            kicking();
            if(online && !walked && !blocked && !crouched && !jumped && !kicked && !punched){
                output("");
            }
        }
    }    

    /**
     * controls left and right movement of the character. Also sets the "walked" boolean to true so it can be accessed from subclasses to determine whether to 
     * animate the character to walk
     */
    public void movement(){
        if (Greenfoot.isKeyDown("left") && getX() > 120 && death == false && !playerTwoDead){
            if(online) output("d"); 
            walked = true;
            move(-5); 
        }else if (Greenfoot.isKeyDown("right") && getX() < 870 && death == false && !playerTwoDead){
            if(online) output("a");
            walked = true;
            move(5); 
        }else{
            walked = false;
        }
    }

    public void fall(){
        setLocation (getX(), getY() + gravity());
    }

    /**
     * controls the jumping of a character. Also sets the "jumped" boolean to true so subclasses can determine whether to animate the jump
     */
    public void jumping(){
        if (Greenfoot.isKeyDown("up") && jumped == false && jumpTimer == 0 && death == false && !playerTwoDead){
            if(online) output("w");
            jumped = true;
            vspeed = -20;
            gravity = 1;
            jumpTimer = 45;
            fall();
        }
    }

    public int gravity(){
        vspeed += gravity;
        return vspeed;
    }

    /**
     * checks if the character is touching the platform
     */
    public void isTouching(){
        if (getY() > 470){
            vspeed = 0;
            gravity = 0;
            jumped = false;
        }
    }

    /**
     * checks if user is clicking the crouch button. also sets "crouched" boolean to true so subclasses can determine whether to animate the crouch
     */
    public void crouching(){
        if (Greenfoot.isKeyDown("down") && death == false && !playerTwoDead){
            if(online) output("s");
            crouched = true;
        }else {
            crouched = false;
        }
    }

    /**
     * checks if user is clicking the block button. also sets "crouched" boolean to true so subclasses can determine whether to animate the crouch
     */
    public void blocking(){
        if (Greenfoot.isKeyDown("b") && death == false && !playerTwoDead){
            if(online) output("t");
            blocked = true;
        }else{
            blocked = false;
        }
    }

    /**
     * Punching method. If the character is clicking the punch button, it sets the "punched" boolean for subclasses to know to animate the character.
     * Also checks if character is punching, while touching Character Two. If so, player twos health decreases. Player two's health is accessed in another method
     * by getting their healthbar. If player two's health is <= 0, player One wins.
     * Also checks if character is punching but player two is blocking, which causes less health to be taken off. 
     */
    public void punching(){
        if (Greenfoot.isKeyDown("n") && death == false && !playerTwoDead){
            if(online) output("y");
            punched = true;
            if (isTouching(CharacterTwo.class) && punchTimer == 0 && !checkBlocked()){
                playerTwoHealth.loseHealth(2);
                if (playerTwoHealth.getHealth() <= 0){
                    gameoverText();
                    playerTwoDead = true;
                }
                punchTimer = 20;
            }
            if (isTouching(CharacterTwo.class) && punchTimer == 0 && checkBlocked()){
                playerTwoHealth.loseHealth(1);
                if (playerTwoHealth.getHealth() <= 0){
                    gameoverText();
                    playerTwoDead = true;
                }
                punchTimer = 20;
            }
        }else{
            punched = false;
        }
    }

    /**
     * same as punching but with kicking
     */
    public void kicking(){
        if (Greenfoot.isKeyDown("m") && death == false && !playerTwoDead){
            if(online) output("u");
            kicked = true;
            if (isTouching(CharacterTwo.class) && kickTimer == 0 && !checkBlocked()){
                playerTwoHealth.loseHealth(3);
                if (playerTwoHealth.getHealth() <= 0){
                    gameoverText();
                    playerTwoDead = true;
                }
                kickTimer = 20;
            }
            if (isTouching(CharacterTwo.class) && kickTimer == 0 && checkBlocked()){
                playerTwoHealth.loseHealth(1);
                if (playerTwoHealth.getHealth() <= 0){
                    gameoverText();
                    playerTwoDead = true;
                }
                kickTimer = 20;
            }
        }else{
            kicked = false;
        }
    }

    /**
     * This method checks if the two players cross each other. If they do, it returns a value of 0 or 1. This value can be used by subclasses to determine 
     * whether to setImage to the original image or the reversed image
     */
    public int flipped(){
        if (!getWorld().getObjects(CharacterTwo.class).isEmpty()){
            Actor characterTwo = getWorld().getObjects(CharacterTwo.class).get(0);
            if (getX() > characterTwo.getX()){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    /**
     * this method checks if player one is dead, so the subclasses can see whether or not to animate their death
     */
    public void dead(){
        if (playerOneHealth.getHealth() <= 0){
            death = true;  
        }
    }

    public void gameoverText(){
        text = new Text ("Player 1 Wins");
        getWorld().addObject(text, 500, 200);
    }

    public boolean returnBlocked(){
        return blocked;
    }

    /**
     * gets players two health bar so this class can call their lose health meathod
     */
    public void getPlayerTwoHealthBar(){
        playerTwoHealth = ((GameWorld)getWorld()).getPlayerTwoHealthBar();
    }

    public void getPlayerOneHealthBar(){
        playerOneHealth = ((GameWorld)getWorld()).getPlayerOneHealthBar();
    }

    /**
     * accesses CharacterTwo class and check if they are blocking
     */
    public boolean checkBlocked(){
        playerTwoBlocked = ((CharacterTwo)getWorld().getObjects(CharacterTwo.class).get(0)).returnBlocked();
        return playerTwoBlocked;
    }

    /**
     * In place so user cannot spam the jump
     */
    public void jumpTimer(){
        if (jumpTimer > 0){
            jumpTimer--;
        }
    }

    /**
     * In place so user cannot spam the jump
     */
    public void punchTimer (){
        if (punchTimer > 0){
            punchTimer--;
        }
    }

    public void output(String input){
        if(online){
            GameWorld world = (GameWorld) getWorld();
            world.sendOutput(input);
        }
    }

    /**
     * In place so user cannot spam the jump
     */
    private void kickTimer(){
        if (kickTimer > 0){
            kickTimer--;
        }
    }
}
