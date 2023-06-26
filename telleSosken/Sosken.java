class Sosken{


    public static void main(String[] args) {
        
        final int MAKS_ANTALL = 100000;

        // Jente - Jeg har like mange søstre som brødre.
        // brødrene - Vi har dobbelt så mange søstre som brødre

        // brodre: 3
        // jenter: 4

        for (int br = 0; br < MAKS_ANTALL; br++){
            for (int so = 0; so < MAKS_ANTALL; so++){
                if (so-1 == br && (br-1)*2 == so){
                    System.out.println("BRODRE: " + br + " SOSTRE: " + so);
                }
            }
        }
    }
}