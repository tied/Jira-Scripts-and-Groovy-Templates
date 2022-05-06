try {
    def columnResult 
    def rowResult
    def colValue
    def rowValue
    def currentStatus = issue.getStatus().name // Get the status of the current issue in the workflow
    
    colValue = getCustomFieldValue(21001); // This field is Residual Impact
    rowValue = getCustomFieldValue(21002); // This field is Residual Probability
    
    
    //return "Impact: " + colValue +  "<br/>" + "Probability: " + rowValue
    
    if (!colValue || !rowValue) 
    { 
        return null
    } 
    else 
    {
        switch (rowValue) // This is probability
        {
            case 'Rare': rowResult =  0; break;
            case 'Low': rowResult = 1; break;
            case 'Medium': rowResult = 2; break;
            case 'High': rowResult = 3; break;
            case 'Almost certain': rowResult = 4; break;
    	}
    	switch (colValue) // This is impact
        {
            case 'Very low': columnResult = 0; break;
            case 'Low': columnResult = 1; break;
            case 'Medium': columnResult = 2; break;
            case 'High': columnResult = 3; break;
            case 'Major': columnResult = 4; break;
    	}

        def lookup = [ 	["1 (Green)","2 (Green)","3 (Green)","4 (Green)","5 (Green)"],
                            ["2 (Green)","4 (Green)","6 (Green)","8 (Yellow)","10 (Yellow)"],
                            ["3 (Green)","6 (Green)","9 (Yellow)","12 (Yellow)","15 (Yellow)"],
                            ["4 (Green)","8 (Yellow)","12 (Yellow)","16 (Red)","20 (Red)"],
                            ["5 (Green)","10 (Yellow)","15 (Yellow)","20 (Red)","25 (Red)"]
        ] 

    	def lookupValue = lookup[rowResult][columnResult]
    	return lookupValue
    }
}
catch(Exception ex)
{
    // Logs the exception to the atlassian-jira.log file which can be viewed with ScriptRunner
    log.warn("-------------------- Exception: ${ex} --------------------")
}
