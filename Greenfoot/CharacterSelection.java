import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * CharacterSelection World 
 * 
 * Adrian Wong Jason Xian
 * @version (7.0 June 15)
 */
public class CharacterSelection extends World
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    ArrowButton arrow = new ArrowButton();
    private Abobo abobo = new Abobo(0);
    private Moshu moshu = new Moshu(0);
    private Mario mario = new Mario(0);
    private Anna anna = new Anna(0);
    private boolean playerOneClicked = false;
    Text text;
    int characterOne = 0;
    int characterTwo = 0;
    int gameMode;
    
    /**
     * Constructor for objects of class CharacterSelection.
     * 
     */
    public CharacterSelection(int n)
    {    
        super(1000, 600, 1);
        text = new Text ("Player 1 Select");
        addObject(abobo, 350, 200);
        addObject(moshu, 650, 200);
        addObject(mario, 350, 400);
        addObject(anna, 650, 400);
        addObject(text, 200, 200);
        gameMode = n;
        //displayText();
    }

    public void act(){
        //draw();
        checkMouse();
    }

    /**
     * Checks which character the player clicks. Player 1 clicks first, player 2 clicks second. Once both characters are chosen, the world switches to the GameWorld
     */
    public void checkMouse (){
        // 0 == adobo, 1 == moshu, 2 == mario, 3 == anna
        if (Greenfoot.mouseClicked (abobo) && !playerOneClicked){
            playerOneClicked = true;
            removeObject(abobo);
            characterOne = 0;
            removeObject(text);
            text = new Text ("Player 2 Select");
            addObject (text, 200, 200);
        }else if (Greenfoot.mouseClicked (abobo) && playerOneClicked){
            characterTwo = 0;
            Greenfoot.setWorld (new GameWorld (characterOne, characterTwo,0));
        }
        if (Greenfoot.mouseClicked (moshu) && !playerOneClicked){
            playerOneClicked = true;
            removeObject(moshu);
            characterOne = 1;
            removeObject(text);
            text = new Text ("Player 2 Select");
            addObject (text, 200, 200);
        }else if (Greenfoot.mouseClicked (moshu) && playerOneClicked){
            characterTwo = 1;
            Greenfoot.setWorld (new GameWorld (characterOne, characterTwo,0));
        }
        if (Greenfoot.mouseClicked (mario) && !playerOneClicked){
            playerOneClicked = true;
            removeObject(mario);
            characterOne = 2;
            removeObject(text);
            text = new Text ("Player 2 Select");
            addObject (text, 200, 200);
        }else if (Greenfoot.mouseClicked (mario) && playerOneClicked){
            characterTwo = 2;
            Greenfoot.setWorld (new GameWorld (characterOne, characterTwo,0));
        }
        if (Greenfoot.mouseClicked (anna) && !playerOneClicked){
            playerOneClicked = true;
            removeObject(anna);
            characterOne = 3;
            removeObject(text);
            text = new Text ("Player 2 Select");
            addObject (text, 200, 200);
        }else if (Greenfoot.mouseClicked (anna) && playerOneClicked){
            characterTwo = 3;
            Greenfoot.setWorld (new GameWorld (characterOne, characterTwo,0));
        }
        if(playerOneClicked && gameMode == 1){
            serverStuff(characterOne);
        }
    }
    
    public void serverStuff(int n){
        Greenfoot.setWorld(new ServerWorld(n));
    }
}
