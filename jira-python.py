from jira import JIRA
import re

user = 'michal USER'
apikey = 'MY API KEY'
server = 'https://myjirahost.jira'
options = {
 'server': server
}

jira = JIRA(options, basic_auth=(user,apikey) )

size = 100
initial = 0
projects = jira.projects()
print (projects);


##########Ver 2 with Simple auth
from jira import JIRA
import re

#props = jira.application_properties()
#projects = jira.projects()

options = {'server': 'https://myjirahost.jira'}
jira = JIRA(options, basic_auth=('admin', 'PASS'))
size = 100
initial = 0
projects = jira.projects()
print (projects);
