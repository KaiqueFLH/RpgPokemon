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

        for (int i = 0; i < treinadorLog.getListaPoke().size(); i++) {
            System.out.println((i + 1) + "º Pokemon: " + treinadorLog.getListaPoke().get(i).getNome());
        }

        if (treinadorLog.getListaPoke() != null) {
            indice = sc.nextInt();
        }

        for (int i = 0; i < treinadorLog.getListaPoke().size(); i++){
            if (indice == i + 1) {
                System.out.println(treinadorLog.getListaPoke().get(i).toString());
            }
        }
    }
}
