import java.util.Objects;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main {

    private static Clip musicaBatalha;
    private static Clip musicaVitoria;
    static Scanner sc = new Scanner(System.in);
    static Scanner scNome = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n" + treinadorLog.getNome() + "!\nSeparamos um time pokemon perfeito para você!");

        System.out.println("Selecione o Pokemon que iniciará lutando:");
        exibirPokemons();
    }

    public static String escolhaNome() {
        System.out.println("Bem Vindo ao nosso sistema de batalha pokemon!");
        System.out.println("Informe o seu Nome:");
        String nome = scNome.nextLine();

        return nome;
    }

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

            switch (indice) {
                case 0 -> indice = 0;
                case 1 -> indice = 1;
                case 2 -> indice = 2;
                default -> System.out.println("Opção Inválida, Tente Novamente!");
            }
        } while (indice < 0 || indice > 2);

        startMusicaBatalha();
        return indice;
    }

    static Treinador treinadorLog = new Treinador(escolhaNome(), escolhaDificuldade());
    static Pokemons pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);

    public static void exibirPokemons() {
        Pokemons meuPokemon = null;
        int indice = 0;

        // Pergunta ao usuário que pokemon ele quer.
        do {
            for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
                System.out.println("Pokemon " + (i) + " :" + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (!treinadorLog.getListaPoke().isEmpty()) {
                indice = sc.nextInt();
            }

            int aux = indiceValido(indice);

            switch (indice){
                case 0,1,2 -> meuPokemon = treinadorLog.getListaPoke().get(aux);
                default -> System.out.println("Opção Inválida, Tente Novamente");
            }
        } while (indice < 0 || indice > 2);
        //Mostra o Pokemon do usuário e da máquina.
        System.out.println("Seu Pokemon:\n" + meuPokemon.getNome() + "\n");
        System.out.println("Pokemon Adversário:\n" + pokemonAdversario.getNome());

        menuDeCombate(meuPokemon);
    }

    private static int indiceValido(int indice) {
        if (indice >= treinadorLog.getListaPoke().size()) {
            return indice - 1;
        }
        return indice;
    }

    public static void exibirAtaques(Pokemons meuPokemon) {
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

            // Remove o pokemon da lista do adversário caso ele tenha ganho.
            if (!treinadorLog.getListaPokeAdversario().isEmpty()) {
                System.out.println("\n===============================\nO pokemon do seu adversário foi derrotado.");
                treinadorLog.getListaPokeAdversario().remove(pokemonAdversario);

                // Teste para saber se o usuário venceu.
                if (treinadorLog.getListaPokeAdversario().isEmpty()) {
                    stopmusicaBatalha();
                    System.out.println("Você Venceu o seu Adversário e ganhou a liga Pokemon !!! Parabéns.");
                    startMusicaVitoria();
                    return;
                }
                // Define o novo pokemon adversario caso ainda tenha algum pokemon na lista.
                pokemonAdversario = treinadorLog.getListaPokeAdversario().get(0);
                System.out.println("O treinador adversário joga:\n" + pokemonAdversario.toString());
                menuDeCombate(meuPokemon);
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
                    stopmusicaBatalha();
                    System.out.println("Você Perdeu :(");
                    return;
                }
                if (!treinadorLog.getListaPoke().isEmpty()) {
                    System.out.println("O treinador continua com:\n" + pokemonAdversario.toString());
                    System.out.println("\nEscolha seu novo pokemon para continuar jogando.");
                    exibirPokemons();
                }
            }

        } else {
            menuDeCombate(meuPokemon);
        }
    }


    public static void menuDeCombate(Pokemons meuPokemon) {
        int indice = 0;

        // Menu para o combate.
        do {
            System.out.println("\nEscolha um dos Itens Abaixo para Continuar Jogando:");

            System.out.println("""
                    =========Menu=========
                    [1] - Atacar
                    [2] - Trocar Pokemon
                    [3] - Fugir da Batalha
                    """);
            indice = sc.nextInt();

            switch (indice) {
                case 1 -> exibirAtaques(meuPokemon);
                case 2 -> exibirPokemons();
                case 3 -> desistir(meuPokemon);
                default -> System.out.println("Opção inválida, Tente novamente!");
            }
        } while (indice < 1 || indice > 3);
    }

    // Pergunta se o usuário deseja desistir (Somente o usuário tem essa opção).
    public static void desistir(Pokemons meuPokemon) {
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
                case 2 -> menuDeCombate(meuPokemon);
                default -> System.out.println("Opção inválida, Tente novamente!");
            }
        } while (indice < 1 || indice > 2);
    }

    public static void startMusicaBatalha() {
        try {
            // Carrega o arquivo de áudio
            AudioInputStream batalha = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("battle_music.wav"));

            // Cria o objeto Clip
            musicaBatalha = AudioSystem.getClip();
            musicaBatalha.open(batalha);

            // Reproduz a música em loop
            musicaBatalha.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startMusicaVitoria() {
        try {
            // Carrega o arquivo de áudio
            AudioInputStream vitoria = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("victory_music.wav"));

            // Cria o objeto Clip
            musicaVitoria = AudioSystem.getClip();
            musicaVitoria.open(vitoria);

            // Reproduz a música uma vez
            musicaVitoria.start();

            // Aguarda até que a música termine de tocar, não entendi muito bem, mas funciona.
            musicaVitoria.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        musicaVitoria.close();
                    }
                }
            });

            // setTimeOut do java
            Thread.sleep(10000);

            // Encerra a música depois do setTimeOut do java
            musicaVitoria.stop();
            musicaVitoria.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopmusicaBatalha() {
        // Encerra a musica.
        if (musicaBatalha != null && musicaBatalha.isRunning()) {
            musicaBatalha.stop();
        }
    }
}