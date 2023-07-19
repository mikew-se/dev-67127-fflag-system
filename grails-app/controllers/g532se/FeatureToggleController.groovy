package g532se

class FeatureToggleController {

    def featureToggleService

    def index(){}

    def byEnum() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byEnum(FeatureToggleSystemEnum.valueOf(params.id))] )
    }

    def byString() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byString(FeatureToggleSystemEnum.valueOf(params.id).name())])
    }

    def byEntity() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byEntity(FeatureToggleSystemEnum.valueOf(params.id))])
    }

    def byConcatenatedString() {
        forward( action: 'index', model: [featureToggles: featureToggleService.byConcatenatedString(FeatureToggleSystemEnum.valueOf(params.id))])
    }
}
