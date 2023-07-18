package g532se

class FeatureToggleController {

    def featureToggleService

    def index(){}

    def byEnum() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byEnum(FeatureToggle.FeatureToggleSystemEnum.valueOf(params.id))] )
    }

    def byString() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byString(FeatureToggle.FeatureToggleSystemEnum.valueOf(params.id).name())])
    }

    def byEntity() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byEntity(FeatureToggle.FeatureToggleSystemEnum.valueOf(params.id))])
    }
}
