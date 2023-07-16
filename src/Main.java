import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Treinador treinadorLog = new Treinador("Ash");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        escolhaPokemon();

    }

    public static void escolhaPokemon() {

        System.out.println("\nSeja bem vindo ao nosso sistema de batalha Pokemon!\nSeparamos um time pokemon perfeito para você!");

        System.out.println("Selecione o Pokemon que iniciará lutando:");
        exibirPokemons();


    }

    public static void exibirPokemons() {
        int indice = 0;

        do {
            for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
                System.out.println("Pokemon " + (i) + " :" + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (treinadorLog.getListaPoke() != null) {
                indice = sc.nextInt();
            }
        } while (indice < 0 || indice > 2);


        for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
            if (indice == i) {
                System.out.println("O Pokemon que Você escolheu foi:\n" + treinadorLog.getListaPoke().get(i).toString() + "\n");
                System.out.println("O Pokemon do Seu Adversário é:\n" + treinadorLog.getListaPokeAdversario().get(i).toString());

            }
        }

        menuDeCombate(indice);
    }

    public static void exibirAtaques(int indice2) {
        int indice = 0;
        Pokemons ataqueE = treinadorLog.getListaPoke().get(indice2);
        Pokemons ataqueEAdv = treinadorLog.getListaPokeAdversario().get(indice2);

        for (int i = 0; ataqueE.getVida() != 0 || treinadorLog.getListaPokeAdversario().get(indice2).getVida() != 0; ) {
            do {
                for (int b = 0; b < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); b++) {
                    if (indice2 == b) {
                        System.out.println("\nEscolha um ataque presente na lista abaixo:\n" + treinadorLog.getListaPoke().get(b).mostraMovimentos());
                    }
                }
                if (treinadorLog.getListaPoke() != null) {
                    indice = sc.nextInt();
                }
            } while (indice < 0 || indice > 3);


            for (int b = 0; b < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); b++) {
                if (indice2 == b) {
                    System.out.println("O Ataque que você escolheu foi:\n" + (ataqueE.getMovimentosPoke().get(indice)));
                    ataqueE.atacar(treinadorLog.getListaPokeAdversario().get(indice2), ataqueE.getMovimentosPoke().get(indice).getDano());
                    System.out.println("A vida do " + treinadorLog.getListaPokeAdversario().get(indice2).getNome() + " Diminuiu para: " + treinadorLog.getListaPokeAdversario().get(indice2).getVida());
                    System.out.println("\nO Ataque do adversário foi:\n" + (ataqueEAdv.getMovimentosPoke().get(indice)));
                    ataqueEAdv.atacar(treinadorLog.getListaPoke().get(indice2), ataqueEAdv.getMovimentosPoke().get(indice).getDano());
                    System.out.println("A vida do " + treinadorLog.getListaPoke().get(indice2).getNome() + " Diminuiu para: " + treinadorLog.getListaPoke().get(indice2).getVida());

                }

                if (treinadorLog.getListaPokeAdversario().get(indice2).getVida() <= 0){
                    System.out.println("\n===============================\nO pokemon do seu adversário morreu.");
                    if (treinadorLog.getListaPokeAdversario().size() !=0){
                        treinadorLog.getListaPokeAdversario().remove(indice2);
                    }
                    if (treinadorLog.getListaPokeAdversario().size() == 0) {
                        System.out.println("Você Venceu o seu Adversário e ganhou a liga Pokemon !!! Parabéns.");
                    }
                    System.out.println("O treinador adversário joga:\n" + treinadorLog.getListaPokeAdversario().get(indice2).toString());
                    menuDeCombate(indice2);
                    System.out.println("O Ataque que você escolheu foi:\n" + (ataqueE.getMovimentosPoke().get(indice)));
                    ataqueE.atacar(treinadorLog.getListaPokeAdversario().get(indice2+1), ataqueE.getMovimentosPoke().get(indice).getDano());
                    System.out.println("A vida do " + treinadorLog.getListaPokeAdversario().get(indice2+1).getNome() + " Diminuiu para: " + treinadorLog.getListaPokeAdversario().get(indice2+1).getVida());
                }

                else if (ataqueE.getVida() <= 0) {
                    System.out.println("\n===============================\nO seu Pokemon acabou Morrendo.\nEscolha outro Pokemon agora mesmo!");
                    treinadorLog.getListaPoke().remove(indice2);
                    exibirPokemons();
                }
            }
        }



    }


    public static void menuDeCombate(int indice2) {
        int indice = 0;
        do {
            System.out.println("\n==============================================================================================================================================");
            System.out.println("\nEscolha um dos Itens Abaixo para Continuar Jogando:");

            System.out.println("""
                    =========Menu=========
                    [1] - Atacar
                    [2] - Trocar Pokemon
                    [3] - Fugir da Batalha
                    """);
            indice = sc.nextInt();
        } while (indice < 1 || indice > 3);

        switch (indice) {
            case 1 -> exibirAtaques(indice2);
            case 2 -> exibirPokemons();
            case 3 -> treinadorLog.desistir();
        }
    }
}
