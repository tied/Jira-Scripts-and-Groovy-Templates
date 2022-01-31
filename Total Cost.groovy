import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.config.SubTaskManager

SubTaskManager subTaskManager = ComponentAccessor.getSubTaskManager();
Collection subTasks = issue.getSubTaskObjects();

def customFieldManager = ComponentAccessor.getCustomFieldManager();
def customField = customFieldManager.getCustomFieldObjectByName("Total forecasted costs");
def sum = 0;

for (currIssue in subTasks)
    if (currIssue.getIssueType().name == "Sub-task")
        sum += currIssue.getCustomFieldValue(customField) as int;

return sum
