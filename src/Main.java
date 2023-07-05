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
            for (int i = 0; i < treinadorLog.getListaPoke().size(); i++) {
                System.out.println((i + 1) + "º Pokemon: " + treinadorLog.getListaPoke().get(i).getNome());
            }
            if (treinadorLog.getListaPoke() != null) {
                indice = sc.nextInt();
            }
        } while (indice < 1 || indice > 3);


        for (int i = 0; i < Objects.requireNonNull(treinadorLog.getListaPoke()).size(); i++) {
            if (indice == i + 1) {
                System.out.println("O Pokemon que Você escolheu foi:\n" + treinadorLog.getListaPoke().get(i).toString() + "\n");
                System.out.println("O Pokemon do Seu Adversário é:\n" + treinadorLog.getListaPokeAdversario().get(i).toString());

            }
        }

        menuDeCombate();
    }


    public static void menuDeCombate() {
        int indice = 0;
        do {
            System.out.println("\n==============================================================================================================================================");
            System.out.println("\nA Batalha Começou!\nEscolha um dos Itens Abaixo para Continuar Jogando:");

            System.out.println("""
                    =========Menu=========
                    [1] - Atacar
                    [2] - Trocar Pokemon
                    [3] - Fugir da Batalha
                    """);
            indice = sc.nextInt();
        } while (indice < 1 || indice > 3);

        switch (indice) {
            case 1 -> treinadorLog.escolherMov();
            case 2 -> treinadorLog.trocarPoke();
            case 3 -> treinadorLog.desistir();
        }
    }
}
