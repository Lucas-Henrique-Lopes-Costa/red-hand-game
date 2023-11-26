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
    private MeuMundo mundo;
    /**
     * Constructor for objects of class Arvore
     */
    public Arvore(MeuMundo mundo)
    {
        this.mundo=mundo;
    }
    
    public void bater(boolean moverDireita)
    {
        TroncoNormal tronco0 = getTronco(0);
        
        tronco0.som();
        tronco0.mover();
        if(moverDireita)
        {
            tronco0.moverDireita();
        }
        removeTronco(0);
         
        //Move todos os troncos da árvore para baixo
        cair();
        
        // Cria um novo tronco no topo
        criaTronco(); 
    }
    
    public void addTronco(TroncoNormal tronco)
    {
        listaTroncos.add(tronco);
    }
    
    private TroncoNormal getTronco(int id)
    {
        return listaTroncos.get(id);
    }
    
    private void removeTronco(int id)

    {
        listaTroncos.remove(id);
    }
    
    private int tamanho()
    {
        return listaTroncos.size();
    }
    
    public void limpa()
    {
        listaTroncos.clear();
    }
    
    private void cair()
    {
        for(TroncoNormal tronco : listaTroncos)
        {
            tronco.cair160();
        }
    }
    
    private void criaTronco()
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
    
    public void direcaoGalho(String lado)
    {
        if (getTronco(1).getLado().equals(lado)) 
        {
            mundo.gameOver(true); 
        }
    }
}
