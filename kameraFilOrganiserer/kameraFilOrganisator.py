
import os
import shutil
from datetime import datetime 

BILDER_MAPPE_NAVN = "dump" # endre denne om det trengs

def ListUorganiserteMapper(alleBildeMapper):

    uorganiserte_mapper = []
    for mappe in os.listdir(alleBildeMapper):
        if not (sjekkMappeErOrganisert(alleBildeMapper + "/" + mappe)):
            uorganiserte_mapper.append(mappe)
    return uorganiserte_mapper
    

def sjekkMappeErOrganisert(mappe):
    return os.path.isfile(mappe +"/" +"log.txt")

def organiserMappe(mappe):
    alleFiler = os.listdir(mappe)

    log = open(mappe + "/" + "log.txt", "w")
    log.write("Startet aa organisere " + mappe + str(datetime.now()) + "\n")
    fil_typer_flyttet_teller_dict = {}
    
    for fil in alleFiler:    
        fil_type = os.path.splitext(fil)[1]

        if not os.path.isdir(mappe + "/" + fil_type):
            os.mkdir(mappe + "/" + fil_type)
            log.write("Opprettet mappe med navn: " + fil_type + "." + "\n")
            fil_typer_flyttet_teller_dict[fil_type] = 0

        if not os.path.isdir(mappe + "/" + fil):

            print("Flytter " + fil + "...")
            src =  mappe + "/" + fil
            dst = mappe + "/" + fil_type
            shutil.move(src, dst)
            fil_typer_flyttet_teller_dict[fil_type]+=1
            print("Flyttet " + fil + " til " + fil_type)

    
    log.write("Ferdig aa organisere (" + mappe + "): " + str(datetime.now()) + "\n")
    log.write("" + "\n")
    log.write("Statistikk:" + "\n")
    for key in fil_typer_flyttet_teller_dict:
        log.write("Flyttet " + str(fil_typer_flyttet_teller_dict[key]) + " filer til " + key + "." + "\n")

    log.close()


def organiserAlleUorgansierteMapper(uorganiserte, path):
    
    teller = 0
    for mappe in uorganiserte:
        print("Organiserer mappen "+ mappe + "...")
        organiserMappe(path + "/" + mappe)
        teller = teller + 1
        print("Organiserte ferdig: " + mappe + "( " + str((teller/len(uorganiserte))*100) + "%).")


def main():

    

    cwd = os.getcwd()
    alleBildeMapper = cwd + "/" + BILDER_MAPPE_NAVN

    uorganiserte = ListUorganiserteMapper(alleBildeMapper)
    print("Fant " + str(len(uorganiserte)) + " av " + str(len(os.listdir(alleBildeMapper))) + " uorganiserte mapper.")

    organiserAlleUorgansierteMapper(uorganiserte, alleBildeMapper)

main()



