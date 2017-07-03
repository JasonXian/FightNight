import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same comments as Character Class
 * 
 * Adrian Wong Jason Xian
 * @version (June 15)
 */
public class CharacterTwo extends Actor
{
    int vspeed = 0;
    int gravity = 1;
    boolean jumped = false;
    boolean walked = false;
    boolean punched = false;
    boolean kicked = false;
    boolean blocked = false;
    boolean playerOneBlocked = false;
    boolean playerOneDead = false;
    boolean crouched = false;
    boolean death = false;
    boolean victory = false;
    HealthBar playerOneHealth;
    HealthBar playerTwoHealth;
    Text text;
    int jumpTimer = 0;
    int punchTimer = 0;
    int kickTimer = 0;
    boolean online = false;
    private String input = "";

    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CharacterTwo(int game){
        if(game == 1) online = true;
    }

    public void act() 
    {
        if (!(getWorld()instanceof CharacterSelection)){
            getPlayerOneHealthBar();
            getPlayerTwoHealthBar();
            dead();
            jumpTimer ();
            punchTimer();
            kickTimer();
            fall();
            isTouching();
            movement();
            jumping();
            crouching();
            blocking();
            punching();
            kicking();
        }
    }    

    public void movement(){
        if (((Greenfoot.isKeyDown("a") && !online)|| input.equals("a"))&& getX() > 120 && death == false && !playerOneDead){
            walked = true;
            move(-5); 
        }else if (((Greenfoot.isKeyDown("d")&& !online)|| input.equals("d")) && getX() < 870 && death == false && !playerOneDead){
            walked = true;
            move(5); 
        }else{
            walked = false;
        }
    }

    public void fall(){
        setLocation (getX(), getY() + gravity());
    }

    public void jumping(){
        if (((Greenfoot.isKeyDown("w") && !online)|| input.equals("w")) && jumped == false && jumpTimer == 0 && death == false && !playerOneDead){
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

    public void isTouching(){
        if (getY() > 470){
            vspeed = 0;
            gravity = 0;
            jumped = false;
        }
    }

    public void crouching(){
        if (((Greenfoot.isKeyDown("s") && !online)|| input.equals("s"))&& death == false && !playerOneDead){
            crouched = true;
        }else {
            crouched = false;
        }
    }

    public void blocking(){
        if (((Greenfoot.isKeyDown("t") && !online)|| input.equals("t")) && death == false && !playerOneDead){
            blocked = true;
        }else{
            blocked = false;
        }
    }

    public void punching(){
        if (((Greenfoot.isKeyDown("y") && !online)|| input.equals("y")) && death == false && !playerOneDead){
            punched = true;
            if (isTouching(Character.class) && punchTimer == 0 && !checkBlocked()){
                playerOneHealth.loseHealth(2);
                if (playerOneHealth.getHealth() <= 0){
                    gameoverText();
                    playerOneDead = true;
                }
                punchTimer = 20;
            }
            if (isTouching(Character.class) && punchTimer == 0 && checkBlocked()){
                playerOneHealth.loseHealth(1);
                if (playerOneHealth.getHealth() <= 0){
                    gameoverText();
                    playerOneDead = true;
                }
                punchTimer = 20;
            }
        }else{
            punched = false;
        }
    }

    public void kicking(){
        if (((Greenfoot.isKeyDown("u") && !online)|| input.equals("a")) && death == false && !playerOneDead){
            kicked = true;
            if (isTouching(Character.class) && kickTimer == 0 && !checkBlocked()){
                playerOneHealth.loseHealth(3);
                if (playerOneHealth.getHealth() <= 0){
                    gameoverText();
                    playerOneDead = true;
                }
                kickTimer = 20;
            }
            if (isTouching(Character.class) && kickTimer == 0 && checkBlocked()){
                playerOneHealth.loseHealth(1);
                if (playerOneHealth.getHealth() <= 0){
                    gameoverText();
                    playerOneDead = true;
                }
                kickTimer = 20;
            }
        }else{
            kicked = false;
        }
    }

    public int flipped(){
        if (!getWorld().getObjects(Character.class).isEmpty()){
            Actor characterTwo = getWorld().getObjects(Character.class).get(0);
            if (getX() > characterTwo.getX()){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public void dead(){
        if (playerTwoHealth.getHealth() <= 0){
            death = true;  
        }
    }

    public void gameoverText(){
        text = new Text ("Player 2 Wins");
        getWorld().addObject(text, 500, 200);
    }

    public boolean returnBlocked(){
        return blocked;
    }

    public void getPlayerOneHealthBar(){
        playerOneHealth = ((GameWorld)getWorld()).getPlayerOneHealthBar();
    }

    public void getPlayerTwoHealthBar(){
        playerTwoHealth = ((GameWorld)getWorld()).getPlayerTwoHealthBar();
    }

    private boolean checkBlocked(){
        playerOneBlocked = ((Character)getWorld().getObjects(Character.class).get(0)).returnBlocked();
        return playerOneBlocked;
    }

    public void jumpTimer(){
        if (jumpTimer > 0){
            jumpTimer--;
        }
    }

    public void setInput(String move){
        if(online){
            input = move;
        }
    }

    public void punchTimer(){
        if (punchTimer > 0){
            punchTimer--;
        }
    }

    private void kickTimer(){
        if (kickTimer > 0){
            kickTimer--;
        }
    }
}
