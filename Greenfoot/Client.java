import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.net.*;
import java.awt.Color;

/**
 * Client class to connect to server
 * 
 * @Jason Xian and Adrian Wong
 * @June 15
 */
public class Client extends Actor implements Runnable{
    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private int port;
    private String serverIP;
    private String inputData;
    private GreenfootImage text;
    private boolean setUp = false;
    private int characterNum;
    
    public Client(String server, int portNum, int n){
        port = portNum;
        serverIP = server;
        characterNum = n;
    }
    
    public void run(){
        while(true){
            try{
                if(!setUp){
                    connection = new Socket(InetAddress.getByName(serverIP), port);
                    setUpStreams();
                }
                sendData();
            }catch(IOException e){
                System.out.println("Can't connect to server");
                break;
            }
        }
    }
    
    private void setUpStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        setUp = true;
    }
    
    private void getData() throws IOException{
        try{
            inputData = (String) input.readObject();
            ServerWorld world = (ServerWorld) getWorld();
            world.addText(inputData, 200, 300);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    private void sendData() throws IOException{
        
    }
    
    public void sendData(String info){
        try{
            output.writeObject(info);
            output.flush();
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
