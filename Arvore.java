import java.util.*;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arvore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arvore
{
    // instance variables - replace the example below with your own
    private  ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    private World mundo;
    /**
     * Constructor for objects of class Arvore
     */
    public Arvore(World mundo)
    {
        this.mundo=mundo;
    }
    
    public void addTronco(TroncoNormal tronco)
    {
        listaTroncos.add(tronco);
    }
    
    public TroncoNormal getTronco(int id)
    {
        return listaTroncos.get(id);
    }
    
    public void removeTronco(int id)
    {
        listaTroncos.remove(id);
    }
    
    public int tamanho()
    {
        return listaTroncos.size();
    }
    
    public void limpa()
    {
        listaTroncos.clear();
    }
    
    public void cair()
    {
        for(TroncoNormal tronco : listaTroncos)
        {
            tronco.cair160();
        }
    }
    
    
    public void criaTronco()
    {
        int random = Greenfoot.getRandomNumber(11); // Gera um número aleatório entre 0 e 10
        
        if (random < 2) 
        { // 20% de chance de cair um tronco com galho para a esquerda
            TroncoNormal tronco = new TroncoNormal("esquerda");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,314,-40);
        } 
        else if (random > 8) 
        { // 20% de chance de cair um tronco com galho para a direita
            TroncoNormal tronco = new TroncoNormal("direita");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,439,-40);
        } 
        else 
        { // 60% de chance de cair um tronco normal
            TroncoNormal tronco = new TroncoNormal("normal");
            listaTroncos.add(tronco);
            mundo.addObject(tronco,377,-40);
        }
    }
}
