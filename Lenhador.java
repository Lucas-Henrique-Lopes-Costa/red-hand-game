import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esse é o ator que representa o lenhador
 * Ele é responsável por fazer a animação do lenhador e movimentação
 * 
 * @author Lucas, Pedro, Guilherme e Alex
 * @version (a version number or a date)
 */
public class Lenhador extends Actor {
    private int contAnimacao;
    private boolean atacando;
    private Arvore arvore;
    private MeuMundo mundo;
    private int quantidadeTempo;

    /**
     * Construtor da classe Lenhador
     */
    public Lenhador(Arvore arvore, MeuMundo mundo) {
        this.arvore = arvore;
        this.mundo = mundo;
        atacando = false;
        contAnimacao = 0;
        quantidadeTempo = 25;
    }

    /**
     * Executa a ação do ator.
     * Se estiver atacando, verifica a posição do ator e anima de acordo.
     * Caso contrário, verifica a tecla pressionada e realiza a ação correspondente.
     */
    public void act() {
        if (atacando) {
            if (getX() == 215) {
                animar("");
            } else {
                animar("Invertido");
            }
        } else {
            String tecla = Greenfoot.getKey();
            if (tecla != null) {
                if (tecla.equals("left")) {
                    atacando = true;
                    posicionarEsquerda();
                } else if (tecla.equals("right")) {
                    atacando = true;
                    posicionarDireita();
                }
            }
        }

    }

    /**
     * Executa os acontecimentos quando o lenhador se move para a esquerda.
     * Verifica a morte do lenhador, aciona as ações necessárias para o
     * funcionamento da árvore,
     * adiciona tempo e um ponto, e verifica a chance de obter uma espada.
     */
    private void acontecimentosEsquerda() {
        // Verifica a morte do lenhador
        arvore.direcaoGalho("esquerda");

        // Aciona as ações necessárias para o funcionamento da arvore
        arvore.bater(true);

        // Adiciona tempo e um ponto
        mundo.aumentaPontos();
        mundo.aumentaTempo(quantidadeTempo);
        mundo.chanceEspada();
    }

    /**
     * Executa uma série de ações quando o lenhador se move para a direita.
     * Verifica a morte do lenhador, aciona as ações necessárias para o
     * funcionamento da árvore,
     * aumenta os pontos e o tempo, e verifica a chance de obter uma espada.
     */
    private void acontecimentosDireita() {
        // Verifica a morte do lenhador
        arvore.direcaoGalho("direita");

        // Aciona as ações necessárias para o funcionamento da arvore
        arvore.bater(false);

        // Adiciona tempo e um ponto
        mundo.aumentaPontos();
        mundo.aumentaTempo(quantidadeTempo);
        mundo.chanceEspada();
    }

    /**
     * Posiciona o lenhador na esquerda da tela.
     */
    private void posicionarEsquerda() {
        setLocation(215, getY());
    }

    /**
     * Posiciona o lenhador na direita da tela.
     */
    private void posicionarDireita() {
        setLocation(530, getY());
    }

    /**
     * Anima o lenhador com base no complemento fornecido.
     * 
     * @param complemento o complemento para a imagem do lenhador
     */
    private void animar(String complemento) {
        if (contAnimacao < 3) {
            contAnimacao++;
            setImage("lenhador" + complemento + "0.png");
        } else if (contAnimacao < 6) {
            contAnimacao++;
            setImage("lenhador" + complemento + "1.png");
        } else if (contAnimacao < 9) {
            contAnimacao++;
            setImage("lenhador" + complemento + "2.png");
        } else if (contAnimacao < 12) {
            contAnimacao++;
            setImage("lenhador" + complemento + "1.png");
        } else if (contAnimacao < 15) {
            contAnimacao++;
            setImage("lenhador" + complemento + "0.png");
        } else {
            if (complemento == "") {
                acontecimentosEsquerda();
            } else {
                acontecimentosDireita();
            }
            atacando = false;
            contAnimacao = 0;
        }
    }

    /**
     * Diminui a quantidade de tempo.
     * Se a quantidade de tempo for maior que 17, decrementa em 1.
     */
    public void diminiuQuantidadeTempo() {
        if (quantidadeTempo > 17)
            quantidadeTempo--;
    }
}