package g532se

class FeatureToggle {

    String toggleKey
    boolean active = true
    static hasMany = [systemEnums: FeatureToggleSystemEnum, systemStrings: String, systemEntities: FeatureToggleSystem]
    String systems


}
