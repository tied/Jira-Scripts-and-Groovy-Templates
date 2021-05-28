import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.Issue;


def issueManager = ComponentAccessor.getIssueManager()
def customFieldManager = ComponentAccessor.getCustomFieldManager()
def cFieldProductionDowntime = customFieldManager.getCustomFieldObject(13109)
def cFieldValueProductionDowntime = issue.getCustomFieldValue(cFieldProductionDowntime)
def cFieldValueStringProductionDowntime = cFieldValueProductionDowntime.toString()

def cFieldRollbackPlan = customFieldManager.getCustomFieldObject(13111)
def cFieldValueRollbackPlan = issue.getCustomFieldValue(cFieldRollbackPlan)
def cFieldValueStringRollbackPlan = cFieldValueRollbackPlan.toString()

def cFieldSupportDocumentation = customFieldManager.getCustomFieldObject(13113)
def cFieldValueSupportDocumentation = issue.getCustomFieldValue(cFieldSupportDocumentation)
def cFieldValueStringSupportDocumentation = cFieldValueSupportDocumentation.toString()

def cFieldHistory = customFieldManager.getCustomFieldObject(13114)
def cFieldValueHistory = issue.getCustomFieldValue(cFieldHistory)
def cFieldValueStringHistory = cFieldValueHistory.toString()

def cFieldResource = customFieldManager.getCustomFieldObject(13115)
def cFieldValueResource = issue.getCustomFieldValue(cFieldResource)
def cFieldValueStringResource = cFieldValueResource.toString()

//def cFieldBlast = customFieldManager.getCustomFieldObject(13159)
//def cFieldValueBlast = issue.getCustomFieldValue(cFieldBlast)
//def cFieldValueStringBlast = cFieldValueBlast.toString()

//Change Impact
def cFieldChangeImpact = customFieldManager.getCustomFieldObject(13300)
def cFieldValueChangeImpact = issue.getCustomFieldValue(cFieldChangeImpact)
def cFieldValueStringChangeImpact = cFieldValueChangeImpact.toString()

def impactScore = 0


// Rollback Plan Exists
//if (cFieldValueStringRollbackPlan.contains("Rollback plan exists – rollback will not impact SLA")) {
//    impactScore = impactScore + 1
//} else if (cFieldValueStringRollbackPlan.contains("Rollback plan exists – Rollback would impact SLA")) {
//    impactScore = impactScore + 3
//} else if (cFieldValueStringRollbackPlan.contains("No rollback plan exists")) {
//    impactScore = impactScore + 5
// New fields as per HSUP-6777

if (cFieldValueStringRollbackPlan.contains("Backout plan exists")) {
    impactScore = impactScore + 1
} else if (cFieldValueStringRollbackPlan.contains("No backout plan exists - Forward Fix")) {
    impactScore = impactScore + 4
}


// Support Documentation
if (cFieldValueStringSupportDocumentation.contains("The change follows a repeatable and well defined and documented procedure")) {
    impactScore = impactScore + 1
} else if (cFieldValueStringSupportDocumentation.contains("Documentation exists for the technology to support the change activity")) {
// Lowered score as per HSUP-6777
    impactScore = impactScore + 2
//} else if (cFieldValueStringSupportDocumentation.contains("No Documentation")) {
//    impactScore = impactScore + 5
}

// Change Implementation History
if (cFieldValueStringHistory.contains("Change is actioned on a regular basis")) {
    impactScore = impactScore + 1
} else if (cFieldValueStringHistory.contains("Change has been actioned previously")) {
    impactScore = impactScore + 2
} else if (cFieldValueStringHistory.contains("Change has never been actioned previously by this practice/support group")) {
    impactScore = impactScore + 4
}

// Resource Required
if (cFieldValueStringResource.contains("1 person")) {
    impactScore = impactScore + 1
// Aded as per HSUP-6777
} else if (cFieldValueStringResource.contains("2 or more")) {
    impactScore = impactScore + 2
}

// Change Impact
if (cFieldValueStringChangeImpact == "Yes") {
    impactScore = impactScore + 7
} else if (cFieldValueStringChangeImpact == "No") {
    impactScore = impactScore + 1
}

    
// Overall Risk Score Calculation
if (impactScore <= 6) {
    return "Standard " + impactScore
} else if (impactScore > 6 && impactScore <= 12) {
    return "Normal " + impactScore
} else if (impactScore > 12) {
    return "Major " + impactScore
}
