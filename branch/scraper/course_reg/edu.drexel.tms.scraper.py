__author__ = 'Kevin Huang'

from bs4 import BeautifulSoup as bs
import re

allhtml = "".join(open("spring.htm").readlines())
soup =  bs(allhtml)
data = (soup.get_text()).split('\n')

class datastruct():
    '''
    This class contains the default data strcutre that is used by Drexel TMS system
    '''
    def __init__(self):
        self.SubjectCode = ""
        self.CourseNo = 0
        self.InstrType = ""
        self.Sec = 0
        self.CRN = 0
        self.CourseTitle = ""
        self.Days = ""
        self.Time = ""
        self.Instructor = ""
        self.fieldsCount = 9
        self.StartingMark = "Subject Code"
        self.EndingMark = "End main body"

    def verifyInputs(self):
        '''
        This function automatically verifies the data that is parsed in to check if it is valid
        '''
        if(self.CRN>99999 or self.fieldsCount != 9):
            raise TypeError


def cleanupData(courseItemsByList):
    '''
    This function handles all the list form of raw html page
    '''
    idxCounter = 0
    startMark = 0
    stopMark = 0
    blankIdentifier = courseItemsByList[0]
    for currentLine in courseItemsByList:
        if not currentLine == blankIdentifier:
            if re.match("^Subject Code",currentLine):
                startMark =  idxCounter
            elif re.match(" End main body",currentLine):
                stopMark = idxCounter
            else:
                #print currentLine
                pass
        idxCounter += 1

    # remove unnecessary contents:
    del courseItemsByList[stopMark:len(data)]
    del courseItemsByList[0:startMark]
    cleardataCol = []
    for i in courseItemsByList:
        if not i == "":
            cleardataCol.append(i)

    return cleardataCol

if __name__ == "__main__":
    MAGIC_NO = 8
    course= cleanupData(data)
    print course

