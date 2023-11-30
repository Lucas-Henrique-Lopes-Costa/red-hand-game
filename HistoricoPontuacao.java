import java.util.ArrayList;
import java.util.List;

public class HistoricoPontuacao {
    private static List<Jogador> jogadores;

    /**
     * Classe responsável por armazenar o histórico de pontuações dos jogadores.
     */
    public HistoricoPontuacao() {
        jogadores = new ArrayList<>();
    }

    /**
     * Método responsável por retornar o tamanho da lista de jogadores.
     * 
     * @return int
     */
    public static int obterTamanho() {
        ordenarJogadores();
        return jogadores.size();
    }

    /**
     * Método responsável por adicionar um jogador na lista de jogadores.
     * 
     * @param jogador
     */
    public static void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    /**
     * Método responsável por retornar o jogador na posição informada.
     * 
     * @param posicao
     * @return Jogador
     */
    public static String consultarNomeJogadorPorId(int id) {
        return jogadores.get(id).getNome();
    }

    /**
     * Método responsável por retornar a pontuação do jogador na posição informada.
     * 
     * @param posicao
     * @return int
     */
    public static int consultarPontuacaoJogadorPorId(int id) {
        return jogadores.get(id).getPontuacao();
    }

    /**
     * Método responsável por retornar o tempo do jogador na posição informada.
     * 
     * @param posicao
     * @return int
     */
    public static int consultarTempoJogadorPorId(int id) {
        return jogadores.get(id).getTempo();
    }

    /**
     * Método responsável por ordenar os jogadores por pontuação.
     * Utiliza o algoritmo Bubble Sort.
     */
    private static void ordenarJogadores() {
        int tamanho = jogadores.size();
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (jogadores.get(j).getPontuacao() < jogadores.get(j + 1).getPontuacao()) {
                    Jogador aux = jogadores.get(j);
                    jogadores.set(j, jogadores.get(j + 1));
                    jogadores.set(j + 1, aux);
                }
            }
        }
    }

    /**
     * Método responsável por retornar o último jogador da lista.
     * 
     * @return Jogador
     */
    public static Jogador pegaUltimoJogador() {
        int tamanho = jogadores.size();
        return jogadores.get(tamanho - 1);
    }

    /**
     * Método responsável por remover o último jogador da lista.
     */
    public static void removeJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}
