import java.util.ArrayList;
import java.util.List;

public class HistoricoPontuacao {
    private static List<Jogador> jogadores;

    public HistoricoPontuacao() {
        jogadores = new ArrayList<>();
    }

    public static int obterTamanho() {
        ordenarJogadores();
        return jogadores.size();
    }

    public static void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public static String consultarNomeJogadorPorId(int id) {
        return jogadores.get(id).getNome();
    }

    public static int consultarPontuacaoJogadorPorId(int id) {
        return jogadores.get(id).getPontuacao();
    }

    public static int consultarTempoJogadorPorId(int id) {
        return jogadores.get(id).getTempo();
    }

    // função de ordernar unsado bubble sort
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

    public static Jogador pegaUltimoJogador() {
        int tamanho = jogadores.size();
        return jogadores.get(tamanho - 1);
    }

    public static void removeJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }
}
