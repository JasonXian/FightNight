import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.net.*;
import java.awt.Color;

/**
 * Server for connecting in multiplayer
 * 
 * @Jason Xian and Adrian Wong
 * @June 7
 */
public class Server extends Actor implements Runnable{
    private ServerSocket server;
    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String inputData;
    private String serverIp;
    private GreenfootImage text;
    private boolean setUp = false;
    
    public void displayIP() throws IOException{
        serverIp = InetAddress.getLocalHost().toString();
        for(int i = 0; i < serverIp.length(); i++){
           if(serverIp.substring(i,i + 1).equals("/")){
               serverIp = serverIp.substring(i+ 1,serverIp.length());
               break;
           }
        }
        inputData = "Your IP is: " + serverIp + " and Port is: " + server.getLocalPort();
        ServerWorld world = (ServerWorld) getWorld();
        world.addText2(inputData, 481, 68);
    }
    
    public void run(){
        while(true){
            try{
                if(!setUp){
                    try{
                        server = new ServerSocket(0,100);
                        displayIP();
                        setUpStreams();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                getData();
            }catch(IOException e){
               if(!setUp){
                   System.out.println("Can't start server");
               }
               break;
            }
        }
    }
    
    private void setUpStreams() throws IOException{
        connection = server.accept();
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        setUp = true;
    }
    
    private void getData() throws IOException{
        try{
            inputData = (String) input.readObject();
            ServerWorld world = (ServerWorld) getWorld();
            world.gotInput(inputData);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    private void sendData() throws IOException{
        
    }
}
