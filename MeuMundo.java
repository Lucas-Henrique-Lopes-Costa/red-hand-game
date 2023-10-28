import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MeuMundo here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MeuMundo extends World {

    private ArrayList<TroncoNormal> listaTroncos = new ArrayList<>();
    private ArrayList<TroncoGalho> listaTroncosGalho = new ArrayList<>();

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
    private void prepare() {

        Lenhador lenhador = new Lenhador();
        addObject(lenhador, 128, 465);
        TroncoNormal tronco = new TroncoNormal();
        addObject(tronco, 365, 476);
        TroncoNormal tronco2 = new TroncoNormal();
        addObject(tronco2, 365, 372);
        TroncoGalho troncoGalho = new TroncoGalho();
        addObject(troncoGalho, 284, 267);
        TroncoNormal tronco3 = new TroncoNormal();
        addObject(tronco3, 365, 162);
        TroncoGalho troncoGalho2 = new TroncoGalho();
        addObject(troncoGalho2, 445, 58);
        troncoGalho2.getImage().mirrorHorizontally();
        listaTroncos.add(tronco);
        listaTroncos.add(tronco2);
        listaTroncos.add(tronco3);
        listaTroncosGalho.add(troncoGalho);
        listaTroncosGalho.add(troncoGalho2);
    }

    public void act() {
        int aux = checarLado();
        if (aux == 2 && !listaTroncos.isEmpty()) {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(-300);/*
                                * removeObject(tronco0);
                                */
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                for (int j = 1; j < 25; j++) {
                    listaTroncos.get(i).setLocation(
                            listaTroncos.get(i).getX(),
                            listaTroncos.get(i).getY() + 2);
                }

            }
        }

        if (aux == 1 && !listaTroncos.isEmpty()) {
            TroncoNormal tronco0 = listaTroncos.get(0);
            tronco0.move(300);/*
                               * removeObject(tronco0);
                               */
            listaTroncos.remove(0);
            for (int i = 0; i < listaTroncos.size(); i++) {
                for (int j = 1; j < 25; j++) {
                    listaTroncos.get(i).setLocation(
                            listaTroncos.get(i).getX(),
                            listaTroncos.get(i).getY() + 2);
                }

            }
        }
    }

    public int checarLado() {
        String tecla = Greenfoot.getKey();
        if (tecla != null) {
            if (tecla.equals("left")) {
                return 1;
            } else if (tecla.equals("right")) {
                return 2;
            } else {
                return 0;
            }

        }
        return 0;
    }

    public boolean checarEsquerda() {
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

}
