import urllib2,urlparse

import re

def redirectURL(URL):
    '''
    return a redirected URL address from give URL
    '''
    req = urllib2.Request(URL)
    res = urllib2.urlopen(req)
    return res.geturl()

def recomposeURL(URL):
    '''
    Only return the root part of the URL
    '''
    return urlparse.urlparse(URL).__getattribute__("scheme") + "://" +urlparse.urlparse(URL).hostname + "/"

def readPage(self,URL):
    page =  urllib2.urlopen(URL)
    return page.read()

class tmsURL:
    '''
    This class will return all crucial URLs concerning the schedule
    '''
    def __init__(self):
        self.initURL = "https://www.drexel.edu/webtms"
        self.rootURL = recomposeURL( redirectURL(self.initURL))

    def getRootURL(self):
        return self.rootURL

    def getTermInfo(self):
        '''
        This will list all available term from the parsed page
        '''
        termList = []
        return readPage(self,self.initURL)



a = tmsURL()
print a.getRootURL()
print a.getTermInfo()
