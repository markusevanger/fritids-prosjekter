
import java.util.Random;

public class Rutenett {


    int rader;
    int kolonner;
    Rute[][] rutenett;
    


    public Rutenett(int rader, int kolonner){

        this.rader = rader;
        this.kolonner = kolonner;

        rutenett = new Rute[rader][kolonner];

    }

    public Rute hentRute(int rad, int kol){

        try{
            return rutenett[rad][kol];
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
        
    }

    public void fyllRutenett(){
        

        Random rand = new Random();
        for (int rad = 0; rad < rutenett.length; rad++){
            for (int kol = 0; kol < rutenett[rad].length; kol++){
                
                if (rand.nextInt(2) < 1){
                    rutenett[rad][kol] = new Mine(rad, kol, this);
                }
                else {
                    rutenett[rad][kol] = new Rute(rad, kol, this);
                }
            }

        }

        // telle alle naboer


    }

    public void skrivUtRutenett(){
        for (Rute[] rad : rutenett){
            System.out.println();
            for (Rute kol : rad){
                System.out.print(kol);
            }
        }
    }
    
}
