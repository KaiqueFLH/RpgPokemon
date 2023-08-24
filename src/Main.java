import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Scanner scNome = new Scanner(System.in);
    static Treinador treinadorLog;
    static Pokemon pokemonAdversario;
    static Pokemon meuPokemon;
    static Jogo controlaJogo = new Jogo();


    public static void main(String[] args) {
        treinadorLog = new Treinador(escolhaNome(), escolhaDificuldade());
        pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);
        System.out.println("\n" + treinadorLog.getNome() + "!\nSeparamos um time pokemon perfeito para você!");

        System.out.println("Selecione o Pokemon que iniciará lutando:");
        escolherPokemons();
        menuDeCombate();
    }

    // Método para escolher o nome do jogador.

    public static String escolhaNome() {
        System.out.println("Bem Vindo ao nosso sistema de batalha pokemon!");
        System.out.println("Informe o seu Nome:");
        String nome = scNome.nextLine();

        return nome;
    }

    // Método para escolher a dificuldade do adversário.
    public static int escolhaDificuldade() {
        int indice = 0;
        System.out.println("\nAgora, escolha a dificuldade do treinador que você irá lutar:");
        do {
            System.out.println("""
                    [0] - Treinador Iniciante
                    [1] - Treinador Intermediário
                    [2] - Treinador Lendário
                    """);
            indice = sc.nextInt();

            if (indice < 0 || indice > 2) {
                System.out.println("Opção Inválida, Tente Novamente.");
            }
        } while (indice < 0 || indice > 2);

        controlaJogo.startMusicaBatalha();
        return indice;
    }

    public static Pokemon escolherPokemons() {
        int indice = 0;

        // Pergunta ao usuário que pokemon ele quer.
        do {
            for (int i = 0; i < treinadorLog.getListaPoke().size(); i++) {
                System.out.println("Pokemon " + (i) + " :" + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (!treinadorLog.getListaPoke().isEmpty()) {
                indice = sc.nextInt();
            }

//            int aux = indiceValido(indice);

            switch (indice) {
                case 0, 1, 2 -> meuPokemon = treinadorLog.getListaPoke().get(indice);
                default -> System.out.println("Opção Inválida, Tente Novamente.");
            }
        } while (indice < 0 || indice > 2);
        //Mostra o Pokemon do usuário e da máquina.
        System.out.println("Seu Pokemon:\n" + meuPokemon.getNome() + "\n");
        System.out.println("Pokemon Adversário:\n" + pokemonAdversario.getNome());

        return meuPokemon;
    }

    //    private static int indiceValido(int indice) {
    //        if (indice >= treinadorLog.getListaPoke().size()) {
    //            return indice - 1;
    //        }
    //        return indice;
    //    }

    public static int escolherAtaque(Pokemon meuPokemon) {
        int indiceAtq = 0;

        // Pergurtar para o usuário, que ataque ele quer.
        do {
            System.out.println("\nEscolha um ataque presente na lista abaixo:\n" + meuPokemon.mostraMovimentos());
            indiceAtq = sc.nextInt();
        } while (indiceAtq < 0 || indiceAtq >= meuPokemon.getMovimentosPoke().size());

        return indiceAtq;
    }



    public static void exibirAtaques() {
        int indice = escolherAtaque(meuPokemon);
        int ataqueAleatorio = controlaJogo.geraAleatorio();


        // Mostra o ataque que escolhi e ataca o adversário.
        System.out.println("O Ataque que você escolheu foi:\n" + (meuPokemon.getMovimentosPoke().get(indice)));
        meuPokemon.atacar(pokemonAdversario, meuPokemon.getMovimentosPoke().get(indice).getDano(),indice);
        pokemonAdversario.setVidaPokemonIgual0();

        // Mostra o ataque que o adversário escolheu e ataca meus pokemons.
        System.out.println("\nO Ataque do adversário foi:\n" + (pokemonAdversario.getMovimentosPoke().get(ataqueAleatorio)));
        pokemonAdversario.atacar(meuPokemon, pokemonAdversario.getMovimentosPoke().get(ataqueAleatorio).getDano(),indice);
        meuPokemon.setVidaPokemonIgual0();

        controlaJogo.verificaParalizia(meuPokemon,pokemonAdversario);

        validaVitoria();
    }

    public static boolean validaVitoria() {
        // Verifica se o seu pokemon foi derrotado e se você ganhou a partida
        if (pokemonAdversario.getVida() <= 0) {
            // Remove o pokemon da lista do adversário caso ele tenha ganho.
            if (!treinadorLog.getListaPokeAdversario().isEmpty()) {
                System.out.println("\n===============================\nO pokemon do seu adversário foi derrotado.");
                treinadorLog.getListaPokeAdversario().remove(pokemonAdversario);

                // Teste para saber se o usuário venceu.
                if (treinadorLog.getListaPokeAdversario().isEmpty()) {
                    controlaJogo.stopmusicaBatalha();
                    System.out.println("Você Venceu o seu Adversário e ganhou a liga Pokemon !!! Parabéns.");
                    controlaJogo.startMusicaVitoria();
                    System.exit(0);
                    return true;
                }
                // Define o novo pokemon adversario caso ainda tenha algum pokemon na lista.
                pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);
                System.out.println("O treinador adversário joga:\n" + pokemonAdversario.toString());
            }
        }
        // Verifica se o pokemon do Adversário foi derrotado e se ele ganhou a partida
        else if (meuPokemon.getVida() <= 0) {
            System.out.println("\n===============================\nO seu Pokemon foi derrotado.");
            // Remove o pokemon derrotado da lista do usuário.
            if (!treinadorLog.getListaPoke().isEmpty()) {
                treinadorLog.getListaPoke().remove(meuPokemon);
                // Testa Vitoria da Máquina
                if (treinadorLog.getListaPoke().isEmpty()) {
                    controlaJogo.stopmusicaBatalha();
                    System.out.println("Você Perdeu :(");
                    System.exit(0);
                    return true;
                }
                if (!treinadorLog.getListaPoke().isEmpty()) {
                    System.out.println("O treinador continua com:\n" + pokemonAdversario.toString());
                    System.out.println("\nEscolha seu novo pokemon para continuar jogando.");
                    escolherPokemons();
                }
            }

        }
        return false;
    }


    public static void menuDeCombate() {
        int indice = 0;
        boolean jogoAcabou = false;

        // Menu para o combate.
        do {
            jogoAcabou = validaVitoria();
            System.out.println("\nEscolha um dos Itens Abaixo para Continuar Jogando:");

            System.out.println("""
                    =========Menu=========
                    [1] - Atacar
                    [2] - Trocar Pokemon
                    [3] - Fugir da Batalha
                    """);
            indice = sc.nextInt();

            switch (indice) {
                case 1 -> exibirAtaques();
                case 2 -> escolherPokemons();
                case 3 -> desistir();
                default -> System.out.println("Opção inválida, Tente novamente!");
            }
        } while (!jogoAcabou);
    }

    // Pergunta se o usuário deseja desistir (Somente o usuário tem essa opção).
    public static void desistir() {
        int indice = 0;

        do {
            System.out.println("Você tem certeza que deseja fugir da batalha?");
            System.out.println("""
                    [1] - Sim
                    [2] - Não
                    """);
            indice = sc.nextInt();
            switch (indice) {
                case 1 -> System.exit(0);
                case 2 -> System.out.println("Desistência Cancelada!");
                default -> System.out.println("Opção inválida, Tente novamente!");
            }
        } while (indice < 1 || indice > 2);
    }
}