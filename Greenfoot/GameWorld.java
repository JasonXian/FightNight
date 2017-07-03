import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameWorld world 
 * 
 * Jason Xian Adrian Wong 
 * @version (7.0 June 15)
 */
public class GameWorld extends World
{
    private Platform platform = new Platform();
    private HealthBar health1 = new HealthBar();
    private HealthBar health2 = new HealthBar();
    private Character character;
    private CharacterTwo character2;
    private Client client;
    private Server server;
    private Thread serverThread;
    private Thread clientThread;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(int n, int m, int game){    
        // Game is the game mode type, 0 is local, 1 is the server
        super(1000, 600, 1); 
        GreenfootImage background = getBackground();
        background.scale (background.getWidth()-1000, background.getHeight()-500);
        setBackground (background);
        addObject (platform,getWidth()/2, 590);
        setUp(n,m, game);
    }
    
    public GameWorld(int n, int m, int game, Client ct, Server sr){
        super(1000, 600, 1); 
        GreenfootImage background = getBackground();
        background.scale (background.getWidth()-1000, background.getHeight()-500);
        setBackground (background);
        addObject (platform,getWidth()/2, 590);
        client = ct;
        server = sr;
        setUp(n,m, game);
    }
    
    /**
     * This method determines which character player 1 and player 2 selects and adds 
     * the character onto the GameWorld
     */
    public void setUp(int n, int m, int game){
        if (n == 0){
            character = new Abobo(game);
        }
        if (n == 1){
            character = new Moshu(game);
        }
        if (n == 2){
            character = new Mario(game);
        }
        if (n == 3){
            character = new Anna(game);
        }
        addObject (character, 200, 200);
        addObject (health1, 170, 20);
        if (m == 0){
            character2 = new AboboTwo(game);
        }
        if (m == 1){
            character2 = new MoshuTwo(game);
        }
        if (m == 2){
            character2 = new MarioTwo(game);
        }
        if (m == 3){
            character2 = new AnnaTwo(game);
        }
        addObject (character2, 800, 200);
        addObject (health2, 830, 20);
    }
    
    public void sendOutput(String input){
        client.sendData(input);
    }
    
    public void gotInput(String input){
        character2.setInput(input);
    }
    
    /**
     * returns player one's healthbar so its methods can be called elsewhere
     */
    public HealthBar getPlayerOneHealthBar(){ 
       return health1;
    }
    
    /**
     * returns player two's healthbar so its methods can be called elsewhere
     */
    public HealthBar getPlayerTwoHealthBar(){
        return health2;
    }
}
