from jira import JIRA
import re

user = 'michal USER'
apikey = 'MY API KEY'
server = 'https://jira.collabd2.test-and-trace.nhs.uk'
options = {
 'server': server
}

jira = JIRA(options, basic_auth=(user,apikey) )

size = 100
initial = 0
projects = jira.projects()
print (projects);
