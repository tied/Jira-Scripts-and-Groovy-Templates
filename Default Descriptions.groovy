def desc = getFieldById("description")

def defaultValue = """h2. How to reproduce
    * step 1
    * step 2

    h2. Expected Result

    The widget should appear

    h2. Actual Result

    The widget doesn't appear""".replaceAll(/    /, '')

if (!underlyingIssue?.description) { 
    desc.setFormValue(defaultValue)
}
