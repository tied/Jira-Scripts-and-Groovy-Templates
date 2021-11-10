import com.atlassian.jira.component.ComponentAccessor

def issueManager = ComponentAccessor.issueManager

def customField = ComponentAccessor.getCustomFieldManager().getCustomFieldObject("customfield_10236")

def issue = issueManager.getIssueByCurrentKey("DK-19") // your issue key here

def value = (String) issue.getCustomFieldValue(customField)

log.info("the project selected is" + value)

return value
