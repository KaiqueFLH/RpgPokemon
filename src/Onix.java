import java.util.ArrayList;

public class Onix extends Pokemons{

    Movimentos jogaRocha = new Movimentos("Joga Rocha",20,"Pedra");
    Movimentos pedraDura = new Movimentos("Pedra Dura",30,"Pedra");
    Movimentos pesoRocha = new Movimentos("Peso Rocha",25,"Pedra");
    Movimentos punhoRochoso = new Movimentos("Punho Rochoso",15,"Pedra");


    //construtor
    public Onix(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(jogaRocha,pedraDura,pesoRocha,punhoRochoso);
    }

    //função de atacar;
    @Override
    void atacar() {

    }
}
