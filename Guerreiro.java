import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guerreiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guerreiro extends Actor
{
    private boolean atacando;
    private int contAtaque;
    private Dragao dragao;
    
    public Guerreiro (Dragao dragao)
    {
        atacando=false;
        contAtaque=0;
        getImage().scale(130, 130);
        
        this.dragao=dragao;
    }
    
    /**
     * Act - do whatever the Guerreiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(atacando)
        {
            World mundo = getWorld();
            if(getX() == mundo.getWidth()*4/10
                || getX() == mundo.getWidth()*8/10)
            {
                animar("");
            }
            else
            {
                animar("Invertido");
            }
        }
        else
        {
            //Posiciona o guerreiro corretamente
            arrumarDirecao();
            
            String tecla = Greenfoot.getKey();
            if(tecla!=null)
            {
                if(tecla.equals("space"))
                {
                    atacar();
                }
                else if(tecla.equals("right"))
                {
                    moverDireita();
                }
                else if(tecla.equals("left"))
                {
                    moverEsquerda();
                }
            } 
        }
    }
    
    private void atacar()
    {
        dragao.perderVida();
        atacando=true;
    }
    
    private void moverDireita()
    {
        if(getX() != getWorld().getWidth()*8/10)
        {
            setLocation(getX()+ getWorld().getWidth()*2/10, getY());
        }
    }
    
    private void moverEsquerda()
    {
        if(getX() != getWorld().getWidth()*2/10)
        {
            setLocation(getX() - getWorld().getWidth()*2/10, getY());
        }
    }
    
    private void arrumarDirecao()
    {
        World mundo = getWorld();
        if(getX() == mundo.getWidth()*4/10
            || getX() == mundo.getWidth()*8/10)
        {
            setImage("guerreiro0.png");
            getImage().scale(130, 130);
        }
        else
        {
            setImage("guerreiroInvertido0.png");
            getImage().scale(130, 130);
        }
    }
    
    private void animar(String complemento)
    {
        if(contAtaque<5)
        {
            contAtaque++;
            setImage("guerreiro" + complemento + "0.png");
            getImage().scale(130, 130);
        }
        else if(contAtaque<10)
        {
            contAtaque++;
            setImage("guerreiro" + complemento + "1.png");
            getImage().scale(130, 130);
        }
        else if(contAtaque<15)
        {
            contAtaque++;
            setImage("guerreiro" + complemento + "2.png");
            getImage().scale(130, 130);
        }
        else if(contAtaque<20)
        {
            contAtaque++;
            setImage("guerreiro" + complemento + "1.png");
            getImage().scale(130, 130);
        }
        else if(contAtaque<25)
        {
            contAtaque++;
            setImage("guerreiro" + complemento + "0.png");
            getImage().scale(130, 130);
        }
        else
        {
            contAtaque=0;
            atacando=false;
        }
    }
}
