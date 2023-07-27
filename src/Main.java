import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Treinador treinadorLog = new Treinador("Kaique");
    static Pokemons pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        escolhaPokemon();
    }

    public static void escolhaPokemon() {
        System.out.println("\nBem vindo "+treinadorLog.getNome()+"!\nSeparamos um time pokemon perfeito para você!");

        System.out.println("Selecione o Pokemon que iniciará lutando:");
        exibirPokemons();
    }

    public static void exibirPokemons() {
        int indice = 0;
        Pokemons meuPokemon;

        do {
            for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
                System.out.println("Pokemon " + (i) + " :" + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (!treinadorLog.getListaPoke().isEmpty()) {
                indice = sc.nextInt();
            }

            meuPokemon = treinadorLog.getListaPoke().get(indice);
            pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);

        } while (indice < 0 || indice > 2);


        System.out.println("Seu Pokemon:\n" + meuPokemon.getNome() + "\n");
        System.out.println("Pokemon Adversário:\n" + pokemonAdversario.getNome());

        menuDeCombate(meuPokemon);
    }

    public static void exibirAtaques(Pokemons meuPokemon, Pokemons pokemonAdversario) {
        int indice = 0;

        // Pergurtar para o usuário, que ataque ele quer.
        do {
            System.out.println("\nEscolha um ataque presente na lista abaixo:\n" + meuPokemon.mostraMovimentos());
            indice = sc.nextInt();
        } while (indice < 0 || indice >= meuPokemon.getMovimentosPoke().size());

        // Escolhendo meus ataques e definindo meus ataques.
        System.out.println("O Ataque que você escolheu foi:\n" + (meuPokemon.getMovimentosPoke().get(indice)));
        meuPokemon.atacar(pokemonAdversario, meuPokemon.getMovimentosPoke().get(indice).getDano());
        System.out.println("A vida do " + pokemonAdversario.getNome() + " Diminuiu para: " + pokemonAdversario.getVida());

        // Escolhendo e definindo os ataques que o adversário vai usar.
        System.out.println("\nO Ataque do adversário foi:\n" + (pokemonAdversario.getMovimentosPoke().get(indice)));
        pokemonAdversario.atacar(meuPokemon, pokemonAdversario.getMovimentosPoke().get(indice).getDano());
        System.out.println("A vida do " + meuPokemon.getNome() + " Diminuiu para: " + meuPokemon.getVida());

        // Verifica se o seu pokemon foi derrotado e se você ganhou a partida
        if (pokemonAdversario.getVida() <= 0) {
            System.out.println("\n===============================\nO pokemon do seu adversário foi derrotado.");

            if (!treinadorLog.getListaPokeAdversario().isEmpty()) {
                treinadorLog.getListaPokeAdversario().remove(pokemonAdversario);
            }

            if (treinadorLog.getListaPokeAdversario().isEmpty()) {
                System.out.println("Você Venceu o seu Adversário e ganhou a liga Pokemon !!! Parabéns.");
            }

            if (!treinadorLog.getListaPokeAdversario().isEmpty()) {
                pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);
                System.out.println("O treinador adversário joga:\n" + pokemonAdversario.toString());
                menuDeCombate(meuPokemon);
            }

        }
        // Verifica se o pokemon do Adversário foi derrotado e se ele ganhou a partida
        else if (meuPokemon.getVida() <= 0) {
            System.out.println("\n===============================\nO seu Pokemon foi derrotado.");

            if (!treinadorLog.getListaPoke().isEmpty()) {
                treinadorLog.getListaPoke().remove(meuPokemon);
                if (!treinadorLog.getListaPoke().isEmpty()) {
                    System.out.println("O treinador continua com:\n" + pokemonAdversario.toString());
                    System.out.println("\n Escolha seu novo pokemon para continuar jogando.");
                    exibirPokemons();
                }
            }

            if (treinadorLog.getListaPoke().isEmpty()) {
                System.out.println("Você Perdeu :(");
            }
        } else {
            menuDeCombate(meuPokemon);
        }
    }


    public static void menuDeCombate(Pokemons meuPokemon) {
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
            case 1 -> exibirAtaques(meuPokemon, pokemonAdversario);
            case 2 -> exibirPokemons();
            case 3 -> desistir(meuPokemon);
        }
    }

    public static void desistir(Pokemons meuPokemon) {
        System.out.println("Você tem certeza que deseja fugir da batalha?");
        System.out.println("""
                [1] - Sim
                [2] - Não
                """);
        int indice = sc.nextInt();

        switch (indice) {
            case 1 -> System.exit(0);
            case 2 -> menuDeCombate(meuPokemon);
        }

    }
}