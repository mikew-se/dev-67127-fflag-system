package g532se

import g532se.FeatureToggle.FeatureToggleSystemEnum
import grails.gorm.transactions.ReadOnly

class FeatureToggleService {

    @ReadOnly
    def byEnum(FeatureToggleSystemEnum system) {
        FeatureToggle.executeQuery("select distinct ft from FeatureToggle ft join ft.systemEnums fts where fts in (:systems)", [systems: system])

        /*FeatureToggle.createCriteria().list {  // doesn't work
            'inList'('systemEnums', system)
        }*/

        //FeatureToggle.findAllBySystemEnumsInList([system])  // doesn't work
    }

    @ReadOnly
    def byString(String system) {
        FeatureToggle.executeQuery("select distinct ft from FeatureToggle ft join ft.systemStrings fts where fts in (:systems)", [systems: system])

        /*FeatureToggle.createCriteria().list {     // doesn't work
            eq('systemStrings', systems)
        }*/

        //FeatureToggle.findAllBySystemStringsInList([system])  // doesn't work
    }

    @ReadOnly
    def byEntity(FeatureToggleSystemEnum system) {
        FeatureToggle.createCriteria().list {
            eq('active', true)
            systemEntities {
                inList('name', system.name())
            }
        }
    }

    @ReadOnly
    def getActiveFeaturesPreTrafficSplit(FeatureToggleSystemEnum systemEnum) {
        def active = []
        FeatureToggle.findAllByActive(true).each { FeatureToggle config ->
            if (config.systemEntities.contains(systemEnum)) {
                active << config
            }
        }
        active
    }
}
