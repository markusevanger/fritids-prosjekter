import os

def main():

    FIL_NAVN = "20_sporsmol_formaterer.py"


    filerListe = os.listdir()
    filerListe.remove(FIL_NAVN)
    filerListe.remove(".DS_Store")
    #filerListe.remove("test.txt")

    formaterFil(filerListe[0])

def formaterFil(tekst_fil):

    print("Formaterer " + tekst_fil + "...")
    fil = open(tekst_fil, "r")
    f = fil.read()
    f = f.replace("\n", "")
    f = f.replace("20 spørsmål, voksne:", "20 spørsmål, voksne: \n")
    f = f.replace("Svar:", "\n\nSvar:\n")

    print(f)

    fil.close()
    fil = open("test.txt", "w")

    teller = 0
    while(teller < len(f)):
        
        bokstav = f[teller]

        if bokstav.isnumeric() and f[teller+2] == ".": # to sifret
            tall = bokstav + f[teller+1]
            tall = int(tall)

            if tall != 10:
                tall = tall - 10
            tall = str(tall)
            fil.write("\n"+tall + ".")
            teller+=3
        
        elif bokstav.isnumeric() and f[teller+1] == "." and not f[teller-1].isnumeric(): #en sifret.
            tall = bokstav + "."
            fil.write("\n" + tall)
            teller+=2
        
        else:
            fil.write(bokstav)
            teller+=1
            

    #print(f_ny)

main()