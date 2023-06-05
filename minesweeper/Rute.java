

public class Rute {

    Rute[] naboer;
    int rad;
    int kol; 
    int antallMineNaboer = 0;
    Rutenett rutenett;

    public Rute(int rad, int kol, Rutenett rutenett){

        this.rad = rad;
        this.kol = kol;
        naboer = new Rute[8];
        this.rutenett = rutenett;
        settNaboer();
    }

    public void leggTilNabo(Rute nyNabo){
        for (int i = 0; i < naboer.length; i++){
            if (naboer[i] != null){
                naboer[i] = nyNabo;
                return;
            }
        }
        System.out.println("Klarte ikke legge til nabo: " + nyNabo + " i rute:" + this);
    }  

    public void settNaboer(){
        for (int r_offset = -1; r_offset < 2; r_offset++){
            for (int k_offset = -1; k_offset < 2; k_offset++){
                if (!(r_offset == 0 && k_offset == 0)){
                    Rute nyNabo = rutenett.hentRute(r_offset + rad, k_offset + kol);
                    if (nyNabo != null){
                        leggTilNabo(nyNabo);
                        if (nyNabo instanceof Mine){
                            antallMineNaboer++;
                        }
                    }
                       
                }
            }
        }
    }
    
    public String toString(){
        return "" + antallMineNaboer;
    }
    
}
