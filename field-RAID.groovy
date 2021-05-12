
def field = getFieldByName("RAID Type")
def EscalationLevelField = getFieldByName("Escalation Level")
def ImpactScoreField = getFieldByName("Impact Score")
def ResponsePlanField = getFieldByName("Response Plan")
def TargetResolutionDateField = getFieldByName("Target Resolution Date")
def ProbabilityField = getFieldByName("Probability")
def DecisionRequiredByField = getFieldByName("Decision Required By")
def MitigationPlanField = getFieldByName("Mitigation Plan")
def DueDateField = getFieldByName("Due Date")
def TotalRiskScoreField = getFieldByName("Total Risk Score")
def RiskImpactScoreField = getFieldByName("Risk Impact Score")

def value = field.getValue()

if (value == "Issue") {
    // Hide these fields if set
    ProbabilityField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    MitigationPlanField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    RiskImpactScoreField.setHidden(true).setRequired(false)
    TotalRiskScoreField.setHidden(true).setRequired(false)
    
    // Show these fields
    ImpactScoreField.setHidden(false).setRequired(true)
    ResponsePlanField.setHidden(false).setRequired(true)
    EscalationLevelField.setHidden(false).setRequired(true)
    TargetResolutionDateField.setHidden(false).setRequired(true)
    return
}    
else if (value != "Issue") {
    EscalationLevelField.setHidden(true).setRequired(false)
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    TargetResolutionDateField.setHidden(true).setRequired(false)
    ProbabilityField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    MitigationPlanField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    TotalRiskScoreField.setHidden(true).setRequired(false)
    RiskImpactScoreField.setHidden(true).setRequired(false)
}

if (value == "Risk") {
    // Hide these fields if set
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    
    // Show these fields
    EscalationLevelField.setHidden(false).setRequired(true)
    ProbabilityField.setHidden(false).setRequired(true)
    MitigationPlanField.setHidden(false).setRequired(true)
    TargetResolutionDateField.setHidden(false).setRequired(true)
    TotalRiskScoreField.setHidden(false).setRequired(true)
    RiskImpactScoreField.setHidden(false).setRequired(true)
    return
}
else if (value != "Risk") {
    EscalationLevelField.setHidden(true).setRequired(false)
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    TargetResolutionDateField.setHidden(true).setRequired(false)
    ProbabilityField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    MitigationPlanField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    TotalRiskScoreField.setHidden(true).setRequired(false)
    RiskImpactScoreField.setHidden(true).setRequired(false)
}

if (value == "Action") {
    // Hide these fields if set
    ProbabilityField.setHidden(true).setRequired(false)
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    
    // Show these fields
    EscalationLevelField.setHidden(false).setRequired(true)
    DueDateField.setHidden(false).setRequired(true)
    return
}
else if (value != "Action") {
    EscalationLevelField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    TotalRiskScoreField.setHidden(true).setRequired(false)
    RiskImpactScoreField.setHidden(true).setRequired(false)
}

if (value == "Decision") {
    // Hide these fields if set
    ProbabilityField.setHidden(true).setRequired(false)
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    
    // Show these fields
    EscalationLevelField.setHidden(false).setRequired(true)
    DecisionRequiredByField.setHidden(false).setRequired(true)
    return
}
else if (value != "Decision") {
    EscalationLevelField.setHidden(true).setRequired(false)
    ImpactScoreField.setHidden(true).setRequired(false)
    ResponsePlanField.setHidden(true).setRequired(false)
    TargetResolutionDateField.setHidden(true).setRequired(false)
    ProbabilityField.setHidden(true).setRequired(false)
    DecisionRequiredByField.setHidden(true).setRequired(false)
    MitigationPlanField.setHidden(true).setRequired(false)
    DueDateField.setHidden(true).setRequired(false)
    TotalRiskScoreField.setHidden(true).setRequired(false)
    RiskImpactScoreField.setHidden(true).setRequired(false)
}
