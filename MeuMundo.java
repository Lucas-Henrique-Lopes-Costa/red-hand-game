import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MeuMundo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MeuMundo extends World
{
    private int contador;
    private ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    private Lenhador lenhador = new Lenhador();

    /**
     * Constructor for objects of class MeuMundo.
     * 
     */
    public MeuMundo() {
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
        addObject(lenhador,215,663);

        BaseTronco baseTronco = new BaseTronco();
        addObject(baseTronco,378,713);

        TroncoNormal tronco1 = new TroncoNormal("normal");
        addObject(tronco1,377,614);

        TroncoNormal tronco2 = new TroncoNormal("esquerda");
        addObject(tronco2,314,454);

        TroncoNormal tronco3 = new TroncoNormal("normal");
        addObject(tronco3,377,294);

        TroncoNormal tronco4 = new TroncoNormal("direita");
        addObject(tronco4,439,134);

        TroncoNormal tronco5 = new TroncoNormal("normal");
        addObject(tronco5,377,-26);

        listaTroncos.add(tronco1);
        listaTroncos.add(tronco2);
        listaTroncos.add(tronco3);
        listaTroncos.add(tronco4);
        listaTroncos.add(tronco5);
    }
    
    public void act()
    {
        //Lenhador está/vai para a direita e bate
        // E o tronco voa para a esquerda
        String aux = checarLado();
        if(aux.equals("direita") && !listaTroncos.isEmpty())
        {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(-300);
            for(int i =0; i<100; i++)
            {
                tronco0.turn(1);
            }
            if(listaTroncos.get(1).getLado().equals("direita"))
            {
                //gera o mundo de game over caso o lenhador tenha contato com o tronco
                LoseWorld w = new LoseWorld();
                Greenfoot.setWorld(w);
            }
            removeObject(tronco0);
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                for (int j = 1; j < 160; j++) {
                    listaTroncos.get(i).setLocation(
                            listaTroncos.get(i).getX(),
                            listaTroncos.get(i).getY() + 1);
                }

            }
            criaTronco();
            addContador();
        }
        
        
        //Lenhador está/vai para a esquerda e bate
        // E o tronco voa para a direita
        if(aux.equals("esquerda") && !listaTroncos.isEmpty())
        {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(300);
            for(int i =0; i<100; i++)
            {
                tronco0.turn(1);
            }
            if(listaTroncos.get(1).getLado().equals("esquerda"))
            {
                LoseWorld w = new LoseWorld();
                Greenfoot.setWorld(w);
            }
            removeObject(tronco0);
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                for (int j = 1; j < 160; j++) {
                    listaTroncos.get(i).setLocation(
                            listaTroncos.get(i).getX(),
                            listaTroncos.get(i).getY() + 1);
                }

            }
            criaTronco();
            addContador();
            
        }
    }
    
    public String checarLado()
    {
        String tecla = Greenfoot.getKey();
        if(tecla!=null)
        {
            if(tecla.equals("left"))
            {
                return "esquerda";
            }
            else if (tecla.equals("right"))
            {
                return "direita";
            }
            else
            {
                return "nulo";
            }

        }
        return "0";
    }
    
    public boolean checarEsquerda()
    {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("left")) {
                return true;
            }
        }

        return false;
    }

    public boolean checarDireita() {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("right")) {
                return true;
            }
        }

        return false;
    }
    
    public void criaTronco()
    {
        int random = Greenfoot.getRandomNumber(11);
        {
            if(random<2)
            {
                TroncoNormal tronco = new TroncoNormal("esquerda");
                addObject(tronco,317,-40);
                listaTroncos.add(tronco);
            }
            else if(random>8)
            {
                TroncoNormal tronco = new TroncoNormal("direita");
                addObject(tronco,442,-40);
                listaTroncos.add(tronco);
            }
            else
            {
                TroncoNormal tronco = new TroncoNormal("normal");
                addObject(tronco,380,-40);
                listaTroncos.add(tronco);
            }
        }
    }
    
    public void addContador()
    {
        contador++;
    }
    
    public int getContador()
    {
        return contador;
    }
}

