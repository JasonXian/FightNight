import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Connects to Server of other GreenFoot Game
 * 
 * @Jason Xian and Adrian Wong 
 * @June 9
 */
public class ServerWorld extends World{
    Client client;
    Server server;
    ScreenText text;
    ScreenText text2;
    String serverIP = null;
    int portNum = 100000;
    TextField textRead;
    String infoText;
    boolean gotInfo = false;
    boolean clientAdded = false;
    boolean clientConnected = false;
    boolean serverConnected = false;
    Thread serverThread;
    Thread clientThread;
    int characterNum1;
    int characterNum2 = 100;    
    boolean recieved = false;
    GameWorld game;
    boolean gameStart = false;

    //Takes a number for the character currently used, 0 == adobo, 1 == moshu, 2 == mario, 3 == anna
    public ServerWorld(int n){    
        super(1000, 600, 1); 
        characterNum1 = n;
        server = new Server();
        addObject(server, 0, 0);
        serverThread = new Thread(server);
        serverThread.start();
        infoText = "Please type in an IP";
        textRead = new TextField(250,30,true);
    }

    public void connectionInfo(){
        addObject(textRead, 478, 345);
        addText(infoText, 472, 262);
        if(Greenfoot.isKeyDown("enter")){
            if(serverIP != null){
                portNum = Integer.parseInt(textRead.getText());
                if(portNum != 100000){
                    gotInfo = true;
                }
            }else{
                serverIP = textRead.getText();
                infoText = "Please type in the portNumber \n And click Enter at the same time as your partner";
                textRead = new TextField(250,30,true);
                Greenfoot.delay(10);
            }
        }
    }

    public void addText(String words, int x, int y){
        removeObject(text);
        text = new ScreenText(new GreenfootImage(words, 40, Color.blue, null));
        addObject(text,x,y);
    }

    public void addText2(String words, int x, int y){
        removeObject(text2);
        text2 = new ScreenText(new GreenfootImage(words, 40, Color.blue, null));
        addObject(text2,x,y);
    }

    public void gotInput(String input){
        if(!recieved){
            characterNum2 = Integer.parseInt(input);
            if(characterNum2 != 100){
                recieved = true;
            }
        }
        if(gameStart){
            game.gotInput(input);
        }
    }

    public void gameStart(){
        Greenfoot.delay(25);
        game = new GameWorld(characterNum1, characterNum2, 1, client, server);
        Greenfoot.setWorld(game);
        gameStart = true;
    }

    public void act(){
        if(!gotInfo){
            connectionInfo();
        }else{
            if(!clientAdded){
                try{
                    client = new Client(serverIP, portNum, characterNum1);
                    addObject(client,0,0);
                    clientThread = new Thread(client);
                    clientThread.start();
                }catch(NullPointerException e){
                    e.printStackTrace();
                }finally{
                    clientAdded = true;
                    Greenfoot.delay(25);
                    for(int i = 0; i < 50; i++){
                        client.sendData("" + characterNum1);
                    }
                }
            }
        }
        if(recieved){
            gameStart();
        }
    }
}
