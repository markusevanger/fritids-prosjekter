import os

def main():

    FIL_NAVN = "20_sporsmol_formaterer.py"


    alleFiler = os.listdir()
    txtFiler = []
    for fil in alleFiler:
        fil_split = os.path.splitext(fil)[1]
        if fil_split == ".txt":
            txtFiler.append(fil)

    #filerListe.remove("test.txt")

    grensesnitt(txtFiler)

def grensesnitt(listeAvMuligeFiler):

    dict = {}

    teller = 1

    for x in range(100):
        print()


    print("Blank ENTER for å formatere alle følgende filer.")
    print("eller skriv tilhørende tall til filen.")
    print("skriv X for aa avslutte")
    print()

    for fil in listeAvMuligeFiler:
        dict[str(teller)] = fil
        teller+=1

    for key in dict:
        print(key + ". " + dict[key])

    

    inp = ""
    while inp != "x" and inp != "X":

        print()
        inp = input(">>")

        if inp == "":
            formaterListeAvFiler(listeAvMuligeFiler)
        elif inp.isnumeric():
            if int(inp) <= len(dict):
                formaterFil(dict[inp])
            else:
                print("Tallet for høyt/lavt!")
        elif inp == "x" or inp == "X":
            print("Avslutter programmet.")
        else:
            print("Venligst prøv igjen.")
    
    

def formaterListeAvFiler(listeAvFiler):
    for fil in listeAvFiler:
        formaterFil(fil)

def formaterFil(tekst_fil):

    print("Formaterer " + tekst_fil + "...")
    fil = open(tekst_fil, "r")
    f = fil.read()
    f = f.replace("\n", "")
    f = f.replace("20 spørsmål, voksne:", "20 spørsmål, voksne:")
    f = f.replace("Svar:", "\n\nSvar:")

    #print(f)

    fil.close()
    fil = open(tekst_fil, "w")

    teller = 0
    while(teller < len(f)):
        
        bokstav = f[teller]

        if bokstav.isnumeric() and f[teller+2] == ".": # to sifret
            tall = bokstav + f[teller+1]
            tall = int(tall)

            if tall != 10:
                tall = tall - 10
            if tall == 1:
                fil.write("\n")
             
            tall = str(tall)
            fil.write("\n"+tall + ".")
            teller+=3
        
        elif bokstav.isnumeric() and f[teller+1] == "." and not f[teller-1].isnumeric(): #en sifret.
            tall = bokstav + "."
            if int(bokstav) == 1:
                fil.write("\n")
            fil.write("\n" + tall)
            teller+=2
        
        else:
            fil.write(bokstav)
            teller+=1
    
    print("Ferdig aa formatere " + tekst_fil + ".")

    #print(f_ny)

main()