import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.fields.CustomField
import org.apache.log4j.Logger
 
/**
 * Script which reads text value from two custom fields and converts then to a numeric value.
 * By default, two custom fields which are taken into consideration:
 *  - 'Impact'
 *  - 'Urgency'
 *
 * For each field a set of possible values is defined in this script.
 * Each value is assigned a numerical value which is later used for multiplication.
 * Assignment of text to a number is done in 'switch' blocks.
 * To map a new text value to a number, insert 3 lines:
 *  case "Input the text value to map":
 *      urgencyNumberValue = "Input the number to be mapped as a n integer e.g. 5";
 *      break;
 * Example of such new mapping for Urgency:
 *  case "4 - Critical":
 *      criticalNumberValue = 4;
 *      break;
 * Example for new Impact mapping:
 *  case "2 - Moderate":
 *      impactNumberValue = 2;
 *      break;
 *
 * Script can be extended to calculate the Ranking with different formula and using different amount of data.
 * */
 
def log = Logger.getLogger("scripts.Prio.PriorityRankingFieldFormula")
Issue issuea = issue;
String impactName = "Impact:";
String urgencyName = "Probability:";
CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();
try {
    List<CustomField> listOfurgencyCustomFields = customFieldManager.getCustomFieldObjectsByName(urgencyName);
    CustomField urgencyCustomField;
    if (listOfurgencyCustomFields.isEmpty()) {
        throw new Exception("Could not find a custom field with name '" + urgencyName + "'");
    } else {
        urgencyCustomField = listOfurgencyCustomFields.get(0);
    }
 
    String urgencyTextValue = issue.getCustomFieldValue(urgencyCustomField);
    Integer urgencyNumberValue;
 
    switch (urgencyTextValue) {
        /** Insert new mappings after this line*/
        case "Very Unlikely":
            urgencyNumberValue = 1;
            break;
        case "Unlikely":
            urgencyNumberValue = 2;
            break;
        case "Possible":
            urgencyNumberValue = 3;
            break;
        case "Likely":
            urgencyNumberValue = 4;
            break;
        case "Very Likely":
            urgencyNumberValue = 5;
             break;
        default: //Setting the value to zero will force the multiplication
            urgencyNumberValue = 0;
    }
 
    List<CustomField> listOfimpactCustomFields = customFieldManager.getCustomFieldObjectsByName(impactName);
    CustomField impactCustomField;
    if (listOfimpactCustomFields.isEmpty()) {
        throw new Exception("Could not find a custom field with name '" + impactName + "'");
 
    } else {
        impactCustomField = listOfimpactCustomFields.get(0)
    }
    String impactTextValue = issue.getCustomFieldValue(impactCustomField)
    Integer impactNumberValue;
    switch (impactTextValue) {
    /** Insert new mappings after this line*/
        case "Negligible":
            impactNumberValue = 1;
            break;
        case "Marginal":
            impactNumberValue= 2;
            break;
        case "Moderate":
            impactNumberValue= 3;
            break;
        case "Critical":
            impactNumberValue= 4;
        	break;
        case "Crisis":
            impactNumberValue= 5;
            break;
        default:
            impactNumberValue = 0;
    }
    /** Multiply both numbers values to receive a final Risk ranking as an integer*/
    Integer calculatedPriorityRanking = impactNumberValue * urgencyNumberValue;
    //return calculatedPriorityRanking;

    if (calculatedPriorityRanking <= 4) {
    return '<a style="color:#FFFFFF; background-color:#008000">' + "P4 - Low" + '</a>'
	} else if (calculatedPriorityRanking >= 5 && calculatedPriorityRanking <= 9) {
    return '<a style="color:#000000; background-color:#FFFF00">' + "P3 - Medium" + '</a>'
    } else if (calculatedPriorityRanking >= 10 && calculatedPriorityRanking <= 14) {
    return '<a style="color:#000000; background-color:#FFBF00">' + "P2 - High" + '</a>'
	} else if (calculatedPriorityRanking >= 15 && calculatedPriorityRanking <= 25) {
    return '<a style="color:#FFFFFF; background-color:#8B0000">' + "P1 - Very High" + '</a>'
}
 	//return urgencyNumberValue;
    
} catch (Exception e) {
    log.error("Caught exception: " + e);
//    e.printStackTrace()
    /** Return -1 to indicate that something did not go as planning in the algorithm*/
    return -1;
}
