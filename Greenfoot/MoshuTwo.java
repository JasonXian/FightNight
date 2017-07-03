import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same comments as mario class
 * 
 * Adrian Wong Jason Xian
 * @version (June 15)
 */
public class MoshuTwo extends CharacterTwo
{
    GreenfootImage moshu = new GreenfootImage ("moshu.png");
    GreenfootImage jump1 = new GreenfootImage ("moshujump1.png");
    GreenfootImage jump2 = new GreenfootImage ("moshujump2.png");
    GreenfootImage jump3 = new GreenfootImage ("moshujump3.png");
    GreenfootImage jump4 = new GreenfootImage ("moshujump4.png"); 
    GreenfootImage jump5 = new GreenfootImage ("moshujump5.png");
    GreenfootImage walk1 = new GreenfootImage ("moshuwalk1.png");  
    GreenfootImage walk2 = new GreenfootImage ("moshuwalk2.png");  
    GreenfootImage block = new GreenfootImage ("moshublock.png");    
    GreenfootImage crouch = new GreenfootImage ("moshucrouch.png");
    GreenfootImage punch = new GreenfootImage ("moshupunch2.png");
    GreenfootImage kick1 = new GreenfootImage ("moshukick1.png");
    GreenfootImage kick2 = new GreenfootImage ("moshukick2.png");
    GreenfootImage crouchPunch = new GreenfootImage ("moshucrouchpunch2.png");
    GreenfootImage crouchKick = new GreenfootImage ("moshucrouchkick.png");
    GreenfootImage death1 = new GreenfootImage ("moshudeath1.png");
    GreenfootImage death2 = new GreenfootImage ("moshudeath2.png");
    GreenfootImage death3 = new GreenfootImage ("moshudeath3.png");
    GreenfootImage death4 = new GreenfootImage ("moshudeath4.png");
    GreenfootImage victory1 = new GreenfootImage ("moshuvictory1.png");
    GreenfootImage victory2 = new GreenfootImage ("moshuvictory2.png");
    GreenfootImage victory3 = new GreenfootImage ("moshuvictory3.png");

    GreenfootImage moshuFlipped = new GreenfootImage ("moshuflipped.png");
    GreenfootImage jump1Flipped = new GreenfootImage ("moshujump1flipped.png");
    GreenfootImage jump2Flipped = new GreenfootImage ("moshujump2flipped.png");
    GreenfootImage jump3Flipped = new GreenfootImage ("moshujump3flipped.png");
    GreenfootImage jump4Flipped = new GreenfootImage ("moshujump4flipped.png"); 
    GreenfootImage jump5Flipped = new GreenfootImage ("moshujump5flipped.png");
    GreenfootImage walk1Flipped = new GreenfootImage ("moshuwalk1flipped.png");  
    GreenfootImage walk2Flipped = new GreenfootImage ("moshuwalk2flipped.png");  
    GreenfootImage blockFlipped = new GreenfootImage ("moshublockflipped.png");    
    GreenfootImage crouchFlipped = new GreenfootImage ("moshucrouchflipped.png");
    GreenfootImage punchFlipped = new GreenfootImage ("moshupunch2flipped.png");
    GreenfootImage kick1Flipped = new GreenfootImage ("moshukick1flipped.png");
    GreenfootImage kick2Flipped = new GreenfootImage ("moshukick2flipped.png");
    GreenfootImage crouchPunchFlipped = new GreenfootImage ("moshucrouchpunch2flipped.png");
    GreenfootImage crouchKickFlipped = new GreenfootImage ("moshucrouchkickflipped.png");
    GreenfootImage death1Flipped = new GreenfootImage ("moshudeath1flipped.png");
    GreenfootImage death2Flipped = new GreenfootImage ("moshudeath2flipped.png");
    GreenfootImage death3Flipped = new GreenfootImage ("moshudeath3flipped.png");
    GreenfootImage death4Flipped = new GreenfootImage ("moshudeath4flipped.png");
    GreenfootImage victory1Flipped = new GreenfootImage ("moshuvictory1flipped.png");
    GreenfootImage victory2Flipped = new GreenfootImage ("moshuvictory2flipped.png");
    GreenfootImage victory3Flipped = new GreenfootImage ("moshuvictory3flipped.png");

    int jumpCount = 0;
    int kickCount = 0;
    int walkCount = 0;
    int deathCount = 0;
    int victoryCount = 0;
    int crouchCount = 0;

    /**
     * Act - do whatever the Adobo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MoshuTwo(int game){
        super(game);
    }

    public void act() 
    {
        if (!(getWorld()instanceof CharacterSelection)){
            super.act();
            if (super.playerOneDead){
                victoryAnimation(super.flipped());
            }
            if (super.jumped && super.walked && !super.death && !super.playerOneDead){
                walkCount = 0;
                if (super.flipped() == 0){
                    setImage(jump5);
                }else{
                    setImage (jump5Flipped);
                }
            }
            if (super.jumped && !super.walked && !super.death && !super.playerOneDead){
                jumpAnimation(super.flipped());
            }
            if (super.walked && !super.jumped && !super.death && !super.playerOneDead){
                setY();
                crouchCount = 0;
                walkAnimation(super.flipped());
            }
            if (super.blocked && !super.jumped && !super.death && !super.playerOneDead){
                blockAnimation(super.flipped());
            }
            if (super.kicked && !super.death && !super.playerOneDead && !super.crouched && !super.walked){
                kickAnimation(super.flipped());
            }
            if (super.punched && !super.death && !super.playerOneDead && !super.crouched && !super.walked){
                punchAnimation(super.flipped());
            }
            if (super.crouched && !super.walked && !super.jumped && !super.death && !super.playerOneDead && !super.punched && !super.kicked){
                crouchAnimation(super.flipped());
            }
            if (super.punched && super.crouched && !super.death && !super.playerOneDead && !super.walked){
                crouchPunch(super.flipped());
            }
            if (super.kicked && super.crouched && !super.death && !super.playerOneDead && !super.walked){
                crouchKick(super.flipped());
            }
            if (super.death && !super.playerOneDead){
                deathAnimation(super.flipped()); 
            }
            if (!super.jumped && !super.walked && !super.crouched && !super.blocked && !super.punched && !super.kicked && !super.death && !super.playerOneDead){
                jumpCount = 0;
                kickCount = 0;
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
            setImage (moshu);
        }else{
            setImage (moshuFlipped);
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
            if (jumpCount == 12){
                setImage(jump5);
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
            if (jumpCount == 12){
                setImage(jump5Flipped);
            }
            jumpCount++;
        }
    }

    public void walkAnimation(int n){
        if (n == 0){
            if (walkCount == 0){
                setImage (walk2);
            }
            if (walkCount == 10){
                setImage (moshu);
            }
            walkCount++;
            if (walkCount == 20)walkCount = 0;
        }else{
            if (walkCount == 0){
                setImage (walk2Flipped);
            }
            if (walkCount == 10){
                setImage (moshuFlipped);
            }
            walkCount++;
            if (walkCount == 20)walkCount = 0;
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
            if (kickCount == 0){
                setImage(kick1);
            }
            if (kickCount == 2){
                setImage(kick2);
            }
            kickCount++;
        }else{
            if (kickCount == 0){
                setImage (kick1Flipped);
            }
            if(kickCount == 2){
                setImage (kick2Flipped);
            }
            kickCount++;
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
                setLocation(getX(), getY() + 20);
            }
            if (crouchCount <= 2) crouchCount++;
        }else{
            setImage(crouchFlipped);
            if (crouchCount == 0){
                setLocation(getX(), getY() + 20);
            }
            if (crouchCount <= 2) crouchCount++;
        }
    }

    public void crouchPunch(int n){
        if (n == 0){
            setImage(crouchPunch);
        }else{
            setImage(crouchPunchFlipped);
        }
    }

    public void crouchKick(int n){
        if (n == 0){
            setImage(crouchKick);
        }else{
            setImage(crouchKickFlipped);            
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
                setLocation(getX(), getY()+ 20);
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
                setLocation(getX(), getY() + 20);
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
