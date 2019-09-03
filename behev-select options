import com.atlassian.jira.component.ComponentAccessor


def customFieldManager = ComponentAccessor.getCustomFieldManager()
def optionsManager = ComponentAccessor.getOptionsManager()

def formField = getFieldByName("SelectListA") // *name* of your custom field
def customField = customFieldManager.getCustomFieldObject(formField.getFieldId())
def config = customField.getRelevantConfig(getIssueContext())
def options = optionsManager.getOptions(config)

def optionsMap = options.findAll {
    it.value in ["AAA", "BBB"] // list of options you want to show
}.collectEntries {
    [
        (it.optionId.toString()) : it.value
    ]
}

// or to show the first 12 options
//def optionsMap = options.take(12).collectEntries {
//    [
//        (it.optionId.toString()) : it.value
//    ]
//}

formField.setFieldOptions(optionsMap)
