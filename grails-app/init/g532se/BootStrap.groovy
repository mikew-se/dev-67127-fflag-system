package g532se

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        initDb()
    }

    @Transactional
    def initDb() {
        // =============== create system entities ===============
        def sysAll = new FeatureToggleSystem(name: FeatureToggle.FeatureToggleSystemEnum.ALL.name()).save()
        def sysBullfinch = new FeatureToggleSystem(name: FeatureToggle.FeatureToggleSystemEnum.BULLFINCH.name()).save()
        def sysCauldron = new FeatureToggleSystem(name: FeatureToggle.FeatureToggleSystemEnum.CAULDRON.name()).save()
        def sysKingfisher = new FeatureToggleSystem(name: FeatureToggle.FeatureToggleSystemEnum.KINGFISHER.name()).save()
        def sysGte = new FeatureToggleSystem(name: FeatureToggle.FeatureToggleSystemEnum.GTE.name()).save()

        // =============== Toggle 1 ===============
        def ft1 = new FeatureToggle(toggleKey: 'FT1')
        // enum
        ft1.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.ALL)
        // string
        ft1.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.ALL.name())
        // entity
        ft1.addToSystemEntities(sysAll)
        ft1.save(failOnError: true)

        // =============== Toggle 2 ===============
        def ft2 = new FeatureToggle(toggleKey: 'FT2')
        // enum
        ft2.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.BULLFINCH)
        ft2.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.CAULDRON)
        //string
        ft2.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.BULLFINCH.name())
        ft2.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.CAULDRON.name())
        // entity
        ft2.addToSystemEntities(sysBullfinch)
        ft2.addToSystemEntities(sysCauldron)
        ft2.save(failOnError: true)

        // =============== Toggle 3 ===============
        def ft3 = new FeatureToggle(toggleKey: 'FT3')
        // enum
        ft3.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.KINGFISHER)
        ft3.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.CAULDRON)
        //string
        ft3.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.KINGFISHER.name())
        ft3.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.CAULDRON.name())
        // entity
        ft3.addToSystemEntities(sysKingfisher)
        ft3.addToSystemEntities(sysCauldron)
        ft3.save(failOnError: true)

        // =============== Toggle 4 ===============
        def ft4 = new FeatureToggle(toggleKey: 'FT4')
        // enum
        ft4.addToSystemEnums(FeatureToggle.FeatureToggleSystemEnum.GTE)
        // string
        ft4.addToSystemStrings(FeatureToggle.FeatureToggleSystemEnum.GTE.name())
        // entity
        ft4.addToSystemEntities(sysGte)
        ft4.save(failOnError: true)
    }

    def destroy = {
    }


}
