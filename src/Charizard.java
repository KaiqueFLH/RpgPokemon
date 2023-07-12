import java.util.ArrayList;

public class Charizard extends Pokemons {

    Movimentos rajadaDeFogo = new Movimentos("Rajada de Fogo",20,"Fogo");
    Movimentos vortexInfernal = new Movimentos("Vortex Infernal",30,"Fogo");
    Movimentos espirroQuente = new Movimentos("Espirro Quente",25,"Fogo");
    Movimentos labaredaFlamejante = new Movimentos("Labareda Flamejante",15,"Fogo");
    //construtor
    public Charizard(String nome, String tipoPoke,int vida,int level){
        super(nome, tipoPoke, vida, level);
        this.adicionarAtaques(rajadaDeFogo,vortexInfernal,espirroQuente,labaredaFlamejante);
    }

}
