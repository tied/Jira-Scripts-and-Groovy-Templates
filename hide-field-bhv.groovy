def field = getFieldByName("Automated Output")
def ScheduleField = getFieldByName("Automation Schedule Frequency")
def TimeField = getFieldByName("Automation Scheduled Time")

def value = field.getValue()

if (value == "Yes") {
    // Hide these fields if set
    ScheduleField.setHidden(true).setRequired(false)
    TimeField.setHidden(true).setRequired(false)
    // Show these fields
    ScheduleField.setHidden(false).setRequired(true).setFormValue("")
    TimeField.setHidden(false).setRequired(true).setFormValue("")

    return
}    
else if (value != "No") {
    ScheduleField.setHidden(true).setRequired(false)
    TimeField.setHidden(true).setRequired(false)
}
