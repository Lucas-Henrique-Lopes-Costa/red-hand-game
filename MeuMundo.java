import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MeuMundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeuMundo extends World
{

    private ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    /**
     * Constructor for objects of class MeuMundo.
     * 
     */
    public MeuMundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        prepare();
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        Lenhador lenhador = new Lenhador();
        addObject(lenhador,128,465);
        TroncoNormal tronco1 = new TroncoNormal();
        addObject(tronco1,393,500);
        TroncoNormal tronco2 = new TroncoNormal();
        addObject(tronco2,393,450);
        TroncoNormal tronco3 = new TroncoNormal();
        addObject(tronco3,393,400);
        TroncoNormal tronco4 = new TroncoNormal();
        addObject(tronco4,393,350);
        TroncoNormal tronco5 = new TroncoNormal();
        addObject(tronco5,393,300);
        TroncoNormal tronco6 = new TroncoNormal();
        addObject(tronco6,393,250);
        TroncoNormal tronco7 = new TroncoNormal();
        addObject(tronco7,393,200);
        TroncoNormal tronco8 = new TroncoNormal();
        addObject(tronco8,393,150);
        
        listaTroncos.add(tronco1);
        listaTroncos.add(tronco2);
        listaTroncos.add(tronco3);
        listaTroncos.add(tronco4);
        listaTroncos.add(tronco5);
        listaTroncos.add(tronco6);
        listaTroncos.add(tronco7);
        listaTroncos.add(tronco8);
    }
    
    public void act()
    {
        int aux = checarLado();
        if(aux==2 && !listaTroncos.isEmpty())
        {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(-300);/*
            removeObject(tronco0);*/
            listaTroncos.remove(0);
            
        }
        
        if(aux==1 && !listaTroncos.isEmpty())
        {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(300);/*
            removeObject(tronco0);*/
            listaTroncos.remove(0);
        }
    }
    
    public int checarLado()
    {
        String tecla = Greenfoot.getKey();
        if(tecla!=null)
        {
            if(tecla.equals("left"))
            {
                return 1;
            }
            else if (tecla.equals("right"))
            {
                return 2;
            }
            else
            {
                return 0;
            }
            
        }
        return 0;
    }
    public boolean checarEsquerda()
    {
        String tecla = Greenfoot.getKey();
        if(tecla!=null)
        {
            if(tecla.equals("left"))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checarDireita()
    {
        String tecla = Greenfoot.getKey();
        if(tecla!=null)
        {
            if(tecla.equals("right"))
            {
                return true;
            }
        }
        
        return false;
    }

}

