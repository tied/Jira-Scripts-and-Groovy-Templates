import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.customfields.manager.OptionsManager
def optionsManager = ComponentAccessor.getComponent(OptionsManager)

def Tenant = getFieldByName("Tenant")
Tenant.setAllowInlineEdit(false)

def TenantCustomField = customFieldManager.getCustomFieldObject(Tenant.getFieldId())
def TenantConfig = TenantCustomField.getRelevantConfig(getIssueContext())
def TenantOptionsOriginal = optionsManager.getOptions(TenantConfig)

/*define the select list manually, do not include the 'none'*/
def TenantOptionsCustYes = TenantOptionsOriginal.findAll { it.value in ['ITS', 'Jupiter', 'AAE', 'FOLK', 'EDGE', 'WVD', 'General', 'HALO', 'DASH', 'COVID', 'STATUS', 'ERVICE', 'Other'] }

Tenant.setFieldOptions( TenantOptionsCustYes )
