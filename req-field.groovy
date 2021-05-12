
def DateRejectedField = getFieldByName("Date Rejected")
def RationaleField = getFieldByName ("Rationale for Rejection")

def Datevalue = DateRejectedField.getValue()

if (Datevalue != "") {
    RationaleField.setRequired(true)
} else {
    RationaleField.setRequired(false)
}
