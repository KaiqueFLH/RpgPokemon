import java.util.ArrayList;

public class Charizard extends Pokemons {

    Movimentos rajadaDeFogo = new Movimentos(20,"Fogo");
    Movimentos vortexInfernal = new Movimentos(30,"Fogo");
    Movimentos espirroQuente = new Movimentos(25,"Fogo");
    Movimentos labaredaFlamejante = new Movimentos(15,"Fogo");
    //construtor
    public Charizard(String nome, String tipoPoke,int vida,int level, ArrayList<Movimentos> movimentosPoke){
        super(nome, tipoPoke, vida, level, movimentosPoke);
        movimentosPoke.add(rajadaDeFogo);
        movimentosPoke.add(vortexInfernal);
        movimentosPoke.add(espirroQuente);
        movimentosPoke.add(labaredaFlamejante);
    }

    //função de atacar;
    @Override
    void atacar() {

    }


}
