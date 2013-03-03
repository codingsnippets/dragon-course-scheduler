
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




