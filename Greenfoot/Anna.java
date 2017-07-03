import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same Comments as Mario class
 *
 * Adrian Wong
 * @version (June 15)
 */
public class Anna extends Character
{
    GreenfootImage anna = new GreenfootImage ("anna.png");
    GreenfootImage jump1 = new GreenfootImage ("annajump1.png");
    GreenfootImage jump2 = new GreenfootImage ("annajump2.png");
    GreenfootImage jump3 = new GreenfootImage ("annajump3.png");
    GreenfootImage jump4 = new GreenfootImage ("annajump4.png"); 
    GreenfootImage jump5 = new GreenfootImage ("annajump5.png"); 
    GreenfootImage jump6 = new GreenfootImage ("annajump6.png"); 
    GreenfootImage walk1 = new GreenfootImage ("annawalk1.png");  
    GreenfootImage walk2 = new GreenfootImage ("annawalk2.png");  
    GreenfootImage walk3 = new GreenfootImage ("annawalk3.png");  
    GreenfootImage walk4 = new GreenfootImage ("annawalk4.png"); 
    GreenfootImage block = new GreenfootImage ("annablock.png");    
    GreenfootImage crouch = new GreenfootImage ("annacrouch.png");
    GreenfootImage punch = new GreenfootImage ("annapunch.png");
    GreenfootImage kick = new GreenfootImage ("annakick.png");
    GreenfootImage crouchPunch = new GreenfootImage ("annacrouchpunch.png");
    GreenfootImage crouchKick = new GreenfootImage ("annacrouchkick.png");
    GreenfootImage death1 = new GreenfootImage ("annadeath1.png");
    GreenfootImage death2 = new GreenfootImage ("annadeath2.png");
    GreenfootImage death3 = new GreenfootImage ("annadeath3.png");
    GreenfootImage death4 = new GreenfootImage ("annadeath4.png");
    GreenfootImage victory1 = new GreenfootImage ("annavictory1.png");
    GreenfootImage victory2 = new GreenfootImage ("annavictory2.png");
    GreenfootImage victory3 = new GreenfootImage ("annavictory3.png");

    GreenfootImage annaFlipped = new GreenfootImage ("annaflipped.png");
    GreenfootImage jump1Flipped = new GreenfootImage ("annajump1flipped.png");
    GreenfootImage jump2Flipped = new GreenfootImage ("annajump2flipped.png");
    GreenfootImage jump3Flipped = new GreenfootImage ("annajump3flipped.png");
    GreenfootImage jump4Flipped = new GreenfootImage ("annajump5flipped.png"); 
    GreenfootImage jump5Flipped = new GreenfootImage ("annajump6flipped.png"); 
    GreenfootImage jump6Flipped = new GreenfootImage ("annajump4flipped.png"); 
    GreenfootImage walk1Flipped = new GreenfootImage ("annawalk1flipped.png");  
    GreenfootImage walk2Flipped = new GreenfootImage ("annawalk2flipped.png");  
    GreenfootImage walk3Flipped = new GreenfootImage ("annawalk3flipped.png");  
    GreenfootImage walk4Flipped = new GreenfootImage ("annawalk4flipped.png"); 
    GreenfootImage blockFlipped = new GreenfootImage ("annablockflipped.png");    
    GreenfootImage crouchFlipped = new GreenfootImage ("annacrouchflipped.png");
    GreenfootImage punchFlipped = new GreenfootImage ("annapunchflipped.png");
    GreenfootImage kickFlipped = new GreenfootImage ("annakickflipped.png");
    GreenfootImage crouchPunchFlipped = new GreenfootImage ("annacrouchpunchflipped.png");
    GreenfootImage crouchKickFlipped = new GreenfootImage ("annacrouchkickflipped.png");
    GreenfootImage death1Flipped = new GreenfootImage ("annadeath1flipped.png");
    GreenfootImage death2Flipped = new GreenfootImage ("annadeath2flipped.png");
    GreenfootImage death3Flipped = new GreenfootImage ("annadeath3flipped.png");
    GreenfootImage death4Flipped = new GreenfootImage ("annadeath4flipped.png");
    GreenfootImage victory1Flipped = new GreenfootImage ("annavictory1flipped.png");
    GreenfootImage victory2Flipped = new GreenfootImage ("annavictory2flipped.png");
    GreenfootImage victory3Flipped = new GreenfootImage ("annavictory3flipped.png");

    int jumpCount = 0;
    int walkCount = 0;
    int deathCount = 0;
    int victoryCount = 0;
    int crouchCount = 0;
    /**
     * Act - do whatever the Adobo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Anna(int game){
        super(game);
    }
    
    public void act() 
    {
        if (!(getWorld()instanceof CharacterSelection)){
            super.act();
            if (super.playerTwoDead){
                victoryAnimation(super.flipped());
            }
            if (super.jumped && super.walked && !super.death && !super.playerTwoDead){
                walkCount = 0;
                if (super.flipped() == 0){
                    setImage(jump1);
                }else{
                    setImage (jump1Flipped);
                }
            }
            if (super.jumped && !super.walked && !super.death && !super.playerTwoDead){
                jumpAnimation(super.flipped());
            }
            if (super.walked && !super.jumped && !super.death && !super.playerTwoDead){
                crouchCount = 0;
                setY();
                walkAnimation(super.flipped());
            }
            if (super.crouched && !super.walked && !super.jumped && !super.death && !super.playerTwoDead && !super.punched && !super.kicked){
                crouchAnimation(super.flipped());
            }
            if (super.punched && super.crouched && !super.death && !super.playerTwoDead && !super.walked){
                crouchPunch(super.flipped());
            }
            if (super.kicked && super.crouched && !super.death && !super.playerTwoDead && !super.walked){
                crouchKick(super.flipped());
            }
            if (super.blocked && !super.jumped && !super.death && !super.playerTwoDead){
                blockAnimation(super.flipped());
            }
            if (super.punched && !super.death && !super.playerTwoDead && !super.crouched && !super.walked){
                punchAnimation(super.flipped());
            }
            if (super.kicked && !super.death && !super.playerTwoDead && !super.crouched && !super.walked){
                kickAnimation(super.flipped());
            }
            if (super.death && !super.playerTwoDead){
                deathAnimation(super.flipped()); 
            }
            if (!super.jumped && !super.walked && !super.crouched && !super.blocked && !super.punched && !super.kicked && !super.death && !super.playerTwoDead){
                jumpCount = 0;
                crouchCount = 0;
                if (isTouching(Platform.class)){
                    setY();
                }
                reset(super.flipped());
            }
        }    
    }

    public void setY(){
        setLocation(getX(), 476);
    }

    public void reset(int n){
        if (n == 0){
            setImage (anna);
        }else{
            setImage (annaFlipped);
        }
    }

    public void jumpAnimation(int n){
        if (n == 0){
            if (jumpCount == 0){
                setImage(jump1);
            }
            if (jumpCount == 3){
                setImage(jump2);
            }
            if (jumpCount == 6){
                setImage(jump3);
            }
            if (jumpCount == 8){
                setImage(jump4);
            }
            if (jumpCount == 10){
                setImage(jump5);
            }
            if (jumpCount == 12){
                setImage(jump6);
            }
            if (jumpCount == 14){
                setImage(jump1);
            }
            jumpCount++;
        }else {
            if (jumpCount == 0){
                setImage(jump1Flipped);
            }
            if (jumpCount == 3){
                setImage(jump2Flipped);
            }
            if (jumpCount == 6){
                setImage(jump3Flipped);
            }
            if (jumpCount == 8){
                setImage(jump4Flipped);
            }
            if(jumpCount == 10){
                setImage(jump5Flipped);
            }
            if(jumpCount == 12){
                setImage(jump6Flipped);
            }
            if(jumpCount == 14){
                setImage (jump1Flipped);
            }
            jumpCount++;
        }
    }

    public void walkAnimation(int n){
        if (n == 0){
            if (walkCount == 0){
                setImage (walk1);
            }
            if (walkCount == 10){
                setImage (walk2);
            }
            if (walkCount == 20){
                setImage (walk3);
            }
            if (walkCount == 30){
                setImage (walk4);
            }
            walkCount++;
            if (walkCount == 30)walkCount = 0;
        }else{
            if (walkCount == 0){
                setImage (walk1Flipped);
            }
            if (walkCount == 10){
                setImage (walk2Flipped);
            }
            if (walkCount == 20){
                setImage (walk3Flipped);
            }
            if (walkCount == 30){
                setImage (walk4Flipped);
            }
            walkCount++;
            if (walkCount == 30)walkCount = 0;
        }
    }

    public void punchAnimation(int n){
        if (n == 0){
            setImage(punch);
        }else{
            setImage(punchFlipped);
        }
    }

    public void kickAnimation(int n){
        if (n == 0){
            setImage(kick);
        }else{
            setImage (kickFlipped);
        }
    }

    public void blockAnimation(int n){
        if (n == 0){
            setImage(block);
        }else{
            setImage(blockFlipped);
        }
    }

    public void crouchAnimation(int n){
        if (n == 0){
            setImage(crouch);
            if (crouchCount == 0){
                setLocation (getX(), getY() + 20);
            }
            if (crouchCount <= 2) crouchCount++;
        }else{
            setImage (crouchFlipped);
            if (crouchCount == 0){
                setLocation (getX(), getY() + 20);
            }
            if (crouchCount <= 2)crouchCount++;
        }
    }

    public void crouchPunch(int n){
        if (n == 0){
            setImage (crouchPunch);
        }   else{
            setImage (crouchPunchFlipped);
        }
    }

    public void crouchKick(int n){
        if (n == 0){
            setImage (crouchKick);
        }else{
            setImage (crouchKickFlipped);
        }
    }

    public void deathAnimation(int n){
        if (n == 0){
            if (deathCount == 0){
                setImage (death1);
            }
            if (deathCount == 10){
                setImage (death2);
            }
            if (deathCount == 20){
                setImage (death3);
            }
            if (deathCount == 30){
                setImage (death4);
                setLocation (getX(), getY() + 30);
            }
            if (deathCount <= 35)deathCount++;
        }else{
            if (deathCount == 0){
                setImage (death1Flipped);
            }
            if (deathCount == 10){
                setImage (death2Flipped);
            }
            if (deathCount == 20){
                setImage (death3Flipped);
            }
            if (deathCount == 30){
                setImage (death4Flipped);
                setLocation (getX(), getY() + 30);
            }
            if (deathCount <= 35)deathCount++;
        }
    }

    public void victoryAnimation(int n){
        if (n == 0){
            if (victoryCount == 5){
                setImage (victory1);
            }
            if (victoryCount == 10){
                setImage (victory2);
            }
            if (victoryCount == 15){
                setImage (victory3);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount <= 20)victoryCount++;
        }else{
            if (victoryCount == 5){
                setImage (victory1Flipped);
            }
            if (victoryCount == 10){
                setImage (victory2Flipped);
            }
            if (victoryCount == 15){
                setImage (victory3Flipped);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount <= 20)victoryCount++;
        }
    }
}
