import java.util.ArrayList;

public class Venussaur extends Pokemons {

    Movimentos matinhosCortantes = new Movimentos("Matinhos Cortantes",20,"Planta");
    Movimentos pinicar = new Movimentos("Pinicar",30,"Água");
    Movimentos ervaVenenosa = new Movimentos("Erva Venenosa",25,"Planta");
    Movimentos pauBrasil = new Movimentos("Pau Brasil",30,"Planta");


    //construtor
    public Venussaur(String nome, String tipoPoke, int vida, int level ) {
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(matinhosCortantes,pinicar,ervaVenenosa,pauBrasil);
    }

    //função de atacar;
    @Override
    void atacar() {

    }

}
