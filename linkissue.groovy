import com.atlassian.jira.component.ComponentAccessor
ComponentAccessor componentAccessor;

//Set the Summary.
issue.summary = 'Demo: ' + sourceIssue.summary

def component = ComponentAccessor.getProjectComponentManager().findByComponentName(issue.getProjectId(),'kilo')
if ( component != null ) {
	issue.setComponent([component])
}

