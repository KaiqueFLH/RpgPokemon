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
            if (!treinadorLog.getListaPoke().isEmpty()) {
                indice = sc.nextInt();
            }
        } while (indice < 0 || indice > 2);


        System.out.println("Seu Pokemon:\n" + treinadorLog.getListaPoke().get(indice).toString() + "\n");
        int aux = indiceValido(indice);

        System.out.println("Pokemon adversário:\n" + treinadorLog.getListaPokeAdversario().get(aux).toString());

        menuDeCombate(indice);
    }

    private static void trocarPokemon() {
        int indice = 0;

        do {
            for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
                System.out.println("Pokemon " + (i) + " :" + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (!treinadorLog.getListaPoke().isEmpty()) {
                indice = sc.nextInt();
            }
        } while (indice < 0 || indice > 2);


        System.out.println("O seu Pokemon agora é o:\n" + treinadorLog.getListaPoke().get(indice).toString() + "\n");

        menuDeCombate(indice);
    }


    private static int indiceValido(int indice) {
        if (indice >= treinadorLog.getListaPokeAdversario().size()) {
            return indice - 1;
        }
        return indice;
    }

    public static void exibirAtaques(int indice2) {
        int aux = indiceValido(indice2);
        int indice = 0;
        Pokemons meuPokemon = treinadorLog.getListaPoke().get(indice2);
        Pokemons pokemonAdversario = treinadorLog.getListaPokeAdversario().get(aux);

        // Pergurtar para o usuário, que ataque ele quer.
        do {
            System.out.println("\nEscolha um ataque presente na lista abaixo:\n" + meuPokemon.mostraMovimentos());
            indice = sc.nextInt();
        } while (indice < 0 || indice >= meuPokemon.getMovimentosPoke().size());

        // Escolhendo meus ataques e definindo o ataque do adversário.
        System.out.println("O Ataque que você escolheu foi:\n" + (meuPokemon.getMovimentosPoke().get(indice)));
        meuPokemon.atacar(pokemonAdversario, meuPokemon.getMovimentosPoke().get(indice).getDano());
        System.out.println("A vida do " + pokemonAdversario.getNome() + " Diminuiu para: " + pokemonAdversario.getVida());
        System.out.println("\nO Ataque do adversário foi:\n" + (pokemonAdversario.getMovimentosPoke().get(indice)));
        pokemonAdversario.atacar(meuPokemon, pokemonAdversario.getMovimentosPoke().get(indice).getDano());
        System.out.println("A vida do " + meuPokemon.getNome() + " Diminuiu para: " + meuPokemon.getVida());

        // Verifica se o seu pokemon foi derrotado e se você ganhou a partida
        if (pokemonAdversario.getVida() <= 0) {
            System.out.println("\n===============================\nO pokemon do seu adversário foi derrotado.");

            if (!treinadorLog.getListaPokeAdversario().isEmpty()) {
                treinadorLog.getListaPokeAdversario().remove(aux);
            }

            if (treinadorLog.getListaPokeAdversario().isEmpty()) {
                System.out.println("Você Venceu o seu Adversário e ganhou a liga Pokemon !!! Parabéns.");
            }

            if (!treinadorLog.getListaPokeAdversario().isEmpty()){
                System.out.println("O treinador adversário joga:\n" + treinadorLog.getListaPokeAdversario().get(aux).toString());
                menuDeCombate(indice2);
            }

        }
        // Verifica se o pokemon do Adversário foi derrotado e se ele ganhou a partida
        else if (meuPokemon.getVida() <= 0) {
            System.out.println("\n===============================\nO seu Pokemon foi derrotado.");

            if (!treinadorLog.getListaPoke().isEmpty()) {
                treinadorLog.getListaPoke().remove(indice2);
                if (!treinadorLog.getListaPoke().isEmpty()){
                    System.out.println("O treinador continua com:\n" + treinadorLog.getListaPokeAdversario().get(aux).toString());
                    System.out.println("\n Escolha seu novo pokemon para continuar jogando.");
                    exibirPokemons();
                }
            }

            if (treinadorLog.getListaPoke().isEmpty()) {
                System.out.println("Você Perdeu :(");
            }
        } else {
            menuDeCombate(indice2);
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
            case 2 -> trocarPokemon();
            case 3 -> desistir(indice2);
        }
    }

    public static void desistir(int indice2) {
        System.out.println("Você tem certeza que deseja fugir da batalha?");
        System.out.println("""
                [1] - Sim
                [2] - Não
                """);
        int indice = sc.nextInt();

        switch (indice) {
            case 1:
                System.exit(0);
                break;
            case 2:
                menuDeCombate(indice2);
                break;
        }

    }
}
