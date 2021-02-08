from jira import JIRA
import re

user = 'michal.kittay-jurdyga@nihp.nhs.uk'
apikey = 'aCjaoWSWG5UqxPA2Lpnrs2f3McYhkI64qIYxRQ'
server = 'https://jira.collabd2.test-and-trace.nhs.uk'
options = {
 'server': server
}

jira = JIRA(options, basic_auth=(user,apikey) )

size = 100
initial = 0
projects = jira.projects()
print (projects);
