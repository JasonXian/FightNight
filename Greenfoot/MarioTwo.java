import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Same comments as mario class
 * 
 * Adrian Wong Jason Xian
 * @version (June 15)
 */
public class MarioTwo extends CharacterTwo
{
    GreenfootImage mario = new GreenfootImage ("mario.png");
    GreenfootImage jump1 = new GreenfootImage ("mariojump1.png");
    GreenfootImage jump2 = new GreenfootImage ("mariojump2.png");
    GreenfootImage jump3 = new GreenfootImage ("mariojump3.png");
    GreenfootImage walk1 = new GreenfootImage ("mariowalk2.png");
    GreenfootImage walk2 = new GreenfootImage ("mariowalk3.png");
    GreenfootImage walk3 = new GreenfootImage ("mariowalk4.png");
    GreenfootImage walk4 = new GreenfootImage ("mariowalk5.png");
    GreenfootImage block = new GreenfootImage ("marioblock.png");    
    GreenfootImage crouch = new GreenfootImage ("mariocrouch.png");
    GreenfootImage punch = new GreenfootImage ("mariopunch.png");
    GreenfootImage kick = new GreenfootImage ("mariokick5.png");
    GreenfootImage crouchPunch = new GreenfootImage ("mariocrouchpunch.png");
    GreenfootImage crouchKick = new GreenfootImage ("mariocrouchkick.png");
    GreenfootImage death1 = new GreenfootImage ("mariodeath1.png");
    GreenfootImage death2 = new GreenfootImage ("mariodeath2.png");
    GreenfootImage death3 = new GreenfootImage ("mariodeath3.png");
    GreenfootImage death4 = new GreenfootImage ("mariodeath4.png");
    GreenfootImage victory1 = new GreenfootImage ("mariovictory1.png");
    GreenfootImage victory2 = new GreenfootImage ("mariovictory2.png");

    GreenfootImage marioFlipped = new GreenfootImage ("marioflipped.png");
    GreenfootImage jump1Flipped = new GreenfootImage ("mariojump1flipped.png");
    GreenfootImage jump2Flipped = new GreenfootImage ("mariojump2flipped.png");
    GreenfootImage jump3Flipped = new GreenfootImage ("mariojump3flipped.png");
    GreenfootImage walk1Flipped = new GreenfootImage ("mariowalk2flipped.png");
    GreenfootImage walk2Flipped = new GreenfootImage ("mariowalk3flipped.png");
    GreenfootImage walk3Flipped = new GreenfootImage ("mariowalk4flipped.png");
    GreenfootImage walk4Flipped = new GreenfootImage ("mariowalk5flipped.png");
    GreenfootImage blockFlipped = new GreenfootImage ("marioblockflipped.png");    
    GreenfootImage crouchFlipped = new GreenfootImage ("mariocrouchflipped.png");
    GreenfootImage punchFlipped = new GreenfootImage ("mariopunchflipped.png");
    GreenfootImage kickFlipped = new GreenfootImage ("mariokick5flipped.png");
    GreenfootImage crouchPunchFlipped = new GreenfootImage ("mariocrouchpunchflipped.png");
    GreenfootImage crouchKickFlipped = new GreenfootImage ("mariocrouchkickflipped.png");
    GreenfootImage death1Flipped = new GreenfootImage ("mariodeath1flipped.png");
    GreenfootImage death2Flipped = new GreenfootImage ("mariodeath2flipped.png");
    GreenfootImage death3Flipped = new GreenfootImage ("mariodeath3flipped.png");
    GreenfootImage death4Flipped = new GreenfootImage ("mariodeath4flipped.png");

    int jumpCount = 0;
    int walkCount = 0;
    int deathCount = 0;
    int victoryCount = 0;
    /**
     * Act - do whatever the mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MarioTwo(int game){
        super(game);
    }
    
    public void act() 
    {
        super.act();
        isTouching();
        if (super.playerOneDead){
            victoryAnimation(super.flipped());
        }
        if (super.jumped && super.walked && !super.death && !super.playerOneDead){
            walkCount = 0;
            if (super.flipped() == 0){
                setImage(jump3);
            }else{
                setImage (jump3Flipped);
            }
        }
        if (super.jumped && !super.walked && !super.death && !super.playerOneDead){
            jumpAnimation(super.flipped());
        }
        if (super.walked && !super.jumped && !super.death && !super.playerOneDead){
            walkAnimation(super.flipped());
        }
        if (super.crouched && !super.walked && !super.jumped && !super.death && !super.playerOneDead){
            crouchAnimation(super.flipped());
        }
        if (super.blocked && !super.jumped && !super.death && !super.playerOneDead){
            blockAnimation(super.flipped());
        }
        if (super.punched && !super.death && !super.playerOneDead && !super.walked){
            punchAnimation(super.flipped());
        }
        if (super.kicked && !super.death && !super.playerOneDead && !super.walked){
            kickAnimation(super.flipped());
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
            reset(super.flipped());
        }
    }  

    public void reset(int n){
        if (n == 0){
            setImage (mario);
        }else{
            setImage (marioFlipped);
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
            jumpCount++;
        }else{
            if (jumpCount == 0){
                setImage(jump1Flipped);
            }
            if (jumpCount == 3){
                setImage(jump2Flipped);
            }
            if (jumpCount == 6){
                setImage(jump3Flipped);
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
            setImage(kickFlipped);
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
            }
            if (deathCount == 30){
                setImage (death4);
                setLocation(getX(), getY()+40);
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
                setLocation(getX(), getY()+40);
            }
            if (deathCount <= 35)deathCount++;
        }
    }

    public void victoryAnimation(int n){
        if (n == 0){
            if (victoryCount == 5){
                setImage (victory1);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount == 10){
                setImage (victory2);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount <= 15)victoryCount++;
        }else{
            if (victoryCount == 5){
                setImage (victory1);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount == 10){
                setImage (victory2);
                setLocation(getX(), getY()-10);
            }
            if (victoryCount <= 15)victoryCount++;
        }
    }
}
