import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same comments as Mario Class
 * 
 * Adrian Wong Jason Xian 
 * @version (June 15)
 */
public class Abobo extends Character
{
    GreenfootImage abobo = new GreenfootImage ("abobo.png");
    GreenfootImage jump1 = new GreenfootImage ("abobojump1.png");
    GreenfootImage jump2 = new GreenfootImage ("abobojump2.png");
    GreenfootImage jump3 = new GreenfootImage ("abobojump3.png");
    GreenfootImage jump4 = new GreenfootImage ("abobojump4.png"); 
    GreenfootImage walk1 = new GreenfootImage ("abobowalk1.png");  
    GreenfootImage walk2 = new GreenfootImage ("abobowalk2.png");  
    GreenfootImage walk3 = new GreenfootImage ("abobowalk3.png");  
    GreenfootImage walk4 = new GreenfootImage ("abobowalk4.png"); 
    GreenfootImage block = new GreenfootImage ("aboboblock.png");    
    GreenfootImage crouch = new GreenfootImage ("abobocrouch.png");
    GreenfootImage punch = new GreenfootImage ("abobopunch2.png");
    GreenfootImage kick = new GreenfootImage ("abobokick.png");
    GreenfootImage crouchPunch = new GreenfootImage ("abobocrouchpunch.png");
    GreenfootImage crouchKick = new GreenfootImage ("abobocrouchkick.png");
    GreenfootImage death1 = new GreenfootImage ("abobodeath1.png");
    GreenfootImage death2 = new GreenfootImage ("abobodeath2.png");
    GreenfootImage death3 = new GreenfootImage ("abobodeath3.png");
    GreenfootImage victory = new GreenfootImage ("abobovictory.png");

    GreenfootImage aboboFlipped = new GreenfootImage ("aboboflipped.png");
    GreenfootImage jump1Flipped = new GreenfootImage ("abobojump1flipped.png");
    GreenfootImage jump2Flipped = new GreenfootImage ("abobojump2flipped.png");
    GreenfootImage jump3Flipped = new GreenfootImage ("abobojump3flipped.png");
    GreenfootImage jump4Flipped = new GreenfootImage ("abobojump4flipped.png"); 
    GreenfootImage walk1Flipped = new GreenfootImage ("abobowalk1flipped.png");  
    GreenfootImage walk2Flipped = new GreenfootImage ("abobowalk2flipped.png");  
    GreenfootImage walk3Flipped = new GreenfootImage ("abobowalk3flipped.png");  
    GreenfootImage walk4Flipped = new GreenfootImage ("abobowalk4flipped.png"); 
    GreenfootImage blockFlipped = new GreenfootImage ("aboboblockflipped.png");    
    GreenfootImage crouchFlipped = new GreenfootImage ("abobocrouchflipped.png");
    GreenfootImage punchFlipped = new GreenfootImage ("abobopunch2flipped.png");
    GreenfootImage kickFlipped = new GreenfootImage ("abobokickflipped.png");
    GreenfootImage crouchPunchFlipped = new GreenfootImage ("abobocrouchpunchflipped.png");
    GreenfootImage crouchKickFlipped = new GreenfootImage ("abobocrouchkickflipped.png");
    GreenfootImage death1Flipped = new GreenfootImage ("abobodeath1flipped.png");
    GreenfootImage death2Flipped = new GreenfootImage ("abobodeath2flipped.png");
    GreenfootImage death3Flipped = new GreenfootImage ("abobodeath3flipped.png");
    GreenfootImage victoryFlipped = new GreenfootImage ("abobovictory.png");

    int jumpCount = 0;
    int walkCount = 0;
    int deathCount = 0;
    int victoryCount = 0;
    /**
     * Act - do whatever the Adobo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Abobo(int game){
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
                    setImage(jump4);
                }else{
                    setImage (jump4Flipped);
                }
            }
            if (super.jumped && !super.walked && !super.death && !super.playerTwoDead){
                jumpAnimation(super.flipped());
            }
            if (super.walked && !super.jumped && !super.death && !super.playerTwoDead){
                walkAnimation(super.flipped());
            }
            if (super.crouched && !super.walked && !super.jumped && !super.death && !super.playerTwoDead){
                crouchAnimation(super.flipped());
            }
            if (super.blocked && !super.jumped && !super.death && !super.playerTwoDead){
                blockAnimation(super.flipped());
            }
            if (super.punched && !super.death && !super.playerTwoDead && !super.walked){
                punchAnimation(super.flipped());
            }
            if (super.kicked && !super.death && !super.playerTwoDead && !super.walked){
                kickAnimation(super.flipped());
            }
            if (super.punched && super.crouched && !super.death && !super.playerTwoDead && !super.walked){
                crouchPunch(super.flipped());
            }
            if (super.kicked && super.crouched && !super.death && !super.playerTwoDead && !super.walked){
                crouchKick(super.flipped());
            }
            if (super.death && !super.playerTwoDead){
                deathAnimation(super.flipped()); 
            }
            if (!super.jumped && !super.walked && !super.crouched && !super.blocked && !super.punched && !super.kicked && !super.death && !super.playerTwoDead){
                jumpCount = 0;
                reset(super.flipped());
            }
        }    
    }

    public void reset(int n){
        if (n == 0){
            setImage (abobo);
        }else{
            setImage (aboboFlipped);
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
        }else{
            setImage (crouchFlipped);
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
                setLocation(getX(), getY()+30);
            }
            if (deathCount <= 25)deathCount++;
        }else{
            if (deathCount == 0){
                setImage (death1Flipped);
            }
            if (deathCount == 10){
                setImage (death2Flipped);
            }
            if (deathCount == 20){
                setImage (death3Flipped);
                setLocation(getX(), getY()+30);
            }
            if (deathCount <= 25)deathCount++;
        }
    }

    public void victoryAnimation(int n){
        if (n == 0){
            if (victoryCount == 5){
                setImage (victory);
                setLocation(getX(), getY()-30);
            }
            if (victoryCount <= 10)victoryCount++;
        }else{
            if (victoryCount == 5){
                setImage (victoryFlipped);
                setLocation(getX(), getY()-30);
            }
            if (victoryCount <= 10)victoryCount++;
        }
    }
}
