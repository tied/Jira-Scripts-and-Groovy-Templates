def descField = getFieldById("customfield_11744")
def descFieldObj = customFieldManager.getCustomFieldObject("customfield_11744")

def defaultValue = """1. Lorum Ipsum
2. random text
3. blah blah
4. Profit!
""".replaceAll(/ /, '')

if (!underlyingIssue?.getCustomFieldValue(descFieldObj)) { 
descField.setFormValue(defaultValue)
}
