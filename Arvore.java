import java.util.*;

/**
 * Write a description of class Arvore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arvore  
{
    // instance variables - replace the example below with your own
    private static ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    /**
     * Constructor for objects of class Arvore
     */
    public Arvore()
    {
    }
    
    public static void addTronco(TroncoNormal tronco)
    {
        listaTroncos.add(tronco);
    }
    
    public static TroncoNormal getTronco(int id)
    {
        return listaTroncos.get(id);
    }
    
    public static void removeTronco(int id)
    {
        listaTroncos.remove(id);
    }
    
    public static int tamanho()
    {
        return listaTroncos.size();
    }
    
    public static void limpa()
    {
        listaTroncos.clear();
    }
}
