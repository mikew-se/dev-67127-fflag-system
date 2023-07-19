Testing out various methods of modelling the feature flag/toggle to system relationship using:
   
    Enum 
    String
    Entity
    Concatenated string

Querying a one to many basic type is not simple with grails, much more options with an entity.

Once up, try the links below to fetch a feature based on whether it supports the given system id.

Available systems to try as the id query param:

    ALL
    GTE
    KINGFISHER
    CAULDRON
    BULLFINCH

http://localhost:9001/featureToggle/byEnum?id=CAULDRON

http://localhost:9001/featureToggle/byString?id=CAULDRON

http://localhost:9001/featureToggle/byEntity?id=CAULDRON

http://localhost:9001/featureToggle/byConcatenatedString?id=CAULDRON

As the current code stands we just fetch all active features then filter in code
rather than in the DB so this might not be an issue as we'll end up doing something like
getActiveFeaturesPreTrafficSplit in FeatureToggleService