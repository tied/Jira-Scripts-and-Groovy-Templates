try {
    def OtherSpeciality = getFieldById("customfield_21840") // Get the field 'Other Speciality'
    def OtherPlaceofWork = getFieldById("customfield_21838") // Get the field 'Other place of work'  
    def PractitionerName = getFieldById("customfield_22505") // Get the field Practitioner Name
    def PractitionerEmail = getFieldById("customfield_13404") //Get the field Email address
    
    OtherSpeciality
            .setHidden(false)
            .setRequired(false)
    
    OtherPlaceofWork
            .setHidden(true)
            .setRequired(false)
    
    PractitionerName
            .setHidden(true)
            .setRequired(false)
    
    PractitionerEmail
            .setHidden(true)
            .setRequired(false)
}
catch(Exception ex)
{
    // Logs the exception to the atlassian-jira.log file which can be viewed with ScriptRunner
    log.warn("-------------------- Exception: ${ex} --------------------")
}
