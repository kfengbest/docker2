import groovy.json.JsonSlurper

def textJson = new File('credentials.json').text
def jsonSlurper = new JsonSlurper()

def creds = jsonSlurper.parseText(textJson)

System.setProperty("AWS_ACCESS_KEY", creds.AWS_ACCESS_KEY);
System.setProperty("AWS_ACCESS_SECRET", creds.AWS_ACCESS_SECRET);

