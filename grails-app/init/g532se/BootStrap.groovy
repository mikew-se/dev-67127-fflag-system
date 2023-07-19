package g532se

import grails.gorm.transactions.Transactional
import static FeatureToggleSystemEnum.*

class BootStrap {

    def init = { servletContext ->
        initDb()
    }

    @Transactional
    def initDb() {
        // =============== create system entities ===============
        def sysAll = new FeatureToggleSystem(name: ALL.name()).save()
        def sysBullfinch = new FeatureToggleSystem(name: BULLFINCH.name()).save()
        def sysCauldron = new FeatureToggleSystem(name: CAULDRON.name()).save()
        def sysKingfisher = new FeatureToggleSystem(name: KINGFISHER.name()).save()
        def sysGte = new FeatureToggleSystem(name: GTE.name()).save()

        // =============== Toggle 1 ===============
        def ft1 = new FeatureToggle(toggleKey: 'FT1')
        // enum
        ft1.addToSystemEnums(ALL)
        // string
        ft1.addToSystemStrings(ALL.name())
        // entity
        ft1.addToSystemEntities(sysAll)
        // concatenated string
        ft1.systems = ALL.name()
        ft1.save(failOnError: true)

        // =============== Toggle 2 ===============
        def ft2 = new FeatureToggle(toggleKey: 'FT2')
        // enum
        ft2.addToSystemEnums(BULLFINCH)
        ft2.addToSystemEnums(CAULDRON)
        //string
        ft2.addToSystemStrings(BULLFINCH.name())
        ft2.addToSystemStrings(CAULDRON.name())
        // entity
        ft2.addToSystemEntities(sysBullfinch)
        ft2.addToSystemEntities(sysCauldron)
        // concatenated string
        ft2.systems = [BULLFINCH.name(), CAULDRON.name()].join(',')
        ft2.save(failOnError: true)

        // =============== Toggle 3 ===============
        def ft3 = new FeatureToggle(toggleKey: 'FT3')
        // enum
        ft3.addToSystemEnums(KINGFISHER)
        ft3.addToSystemEnums(CAULDRON)
        //string
        ft3.addToSystemStrings(KINGFISHER.name())
        ft3.addToSystemStrings(CAULDRON.name())
        // entity
        ft3.addToSystemEntities(sysKingfisher)
        ft3.addToSystemEntities(sysCauldron)
        // concatenated string
        ft3.systems = [KINGFISHER.name(), CAULDRON.name()].join(',')
        ft3.save(failOnError: true)

        // =============== Toggle 4 ===============
        def ft4 = new FeatureToggle(toggleKey: 'FT4')
        // enum
        ft4.addToSystemEnums(GTE)
        // string
        ft4.addToSystemStrings(GTE.name())
        // entity
        ft4.addToSystemEntities(sysGte)
        // concatenated string
        ft4.systems = GTE.name()
        ft4.save(failOnError: true)
    }

    def destroy = {
    }


}
