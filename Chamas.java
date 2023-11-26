import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chamas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chamas extends Actor
{
    private String direcao;
    
    /**
     * Construtor da Classe chamas. Recebe um inteiro como ângulo para
     * se direcionar.
     */
    public Chamas(String direcao)
    {
        this.direcao=direcao;
    }
    
    /**
     * Act - do whatever the Chamas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        World mundo = getWorld();
       
        if(direcao.equals("direita"))
        {
            turnTowards(mundo.getWidth()*6/10, mundo.getHeight());
        }
        else if(direcao.equals("esquerda"))
        {
            turnTowards(mundo.getWidth()*4/10, mundo.getHeight());
        }
        else
        {
            turnTowards(mundo.getWidth()/2, mundo.getHeight());
        }
        move(3);
        
        if(getY()>mundo.getHeight()*4/5)
        {
            mundo.removeObject(this);
        }
        else if(getIntersectingObjects(Guerreiro.class).size()==1)
        {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new LoseWorld());
        }/*
        else if(getY()==mundo.getHeight()*9/10  || isAtEdge())
        {
            mundo.removeObject(this);
        }*/
    }
}
