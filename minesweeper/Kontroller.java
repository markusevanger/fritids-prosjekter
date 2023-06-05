

public class Kontroller {

    public int rader;
    public int kolonner;
    Rutenett rutenett;

    public Kontroller(int rader, int kolonner){
        
        this.rader = rader;
        this.kolonner = kolonner;
        
        rutenett = new Rutenett(rader, kolonner);
        rutenett.fyllRutenett();
        rutenett.skrivUtRutenett();

        MGUI gui = new MGUI(this);


    }

    public Rute hentRute(int rad, int kol){
        return rutenett.hentRute(rad, kol);
    }
    
}
