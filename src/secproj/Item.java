package secproj;


import java.util.ArrayList;


public class Item {

    private ArrayList<Jogo> infos = new ArrayList ();
    private Jogo best;
    private Jogo worst;

    public Item() {
        
    }

    public ArrayList<Jogo> getInfos() {
        return infos;
    }

    public void setInfos(Jogo game) {
        this.infos.add(game);
    }

    public Jogo getBest() {
        return best;
    }

    public void setBest(Jogo best) {
        this.best = best;
    }

    public Jogo getWorst() {
        return worst;
    }

    public void setWorst(Jogo worst) {
        this.worst = worst;
    }
    
}

