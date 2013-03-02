from string import letters




def subject2Code(SubjectName):
    '''
    This function will convert any 5 letter subject to a designated code number
    '''
    subjectLetters =  letters.upper()
    codeList ={}
    for eachLetter in subjectLetters:
        codeList[eachLetter] = "%02d" %  subjectLetters.index(eachLetter)

    maxLength = 5

    distance = maxLength - len(SubjectName)

    adder = "00"


    if distance < 0:
        raise TypeError
    else:
        adder *= distance

    for eachLetter in SubjectName:
        adder += str(codeList.get(eachLetter))

    # return the subject Code
    return adder


def time2number(day,hour,min):
    '''
    Make a conversion table that will generate suitable time slots
    '''
    pass


if __name__ == "__main__":
    print "This function is used by convertion function calls"

    print subject2Code("SE")
    print subject2Code("ECEC")