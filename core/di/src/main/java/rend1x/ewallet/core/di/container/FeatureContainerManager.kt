package rend1x.ewallet.core.di.container

import rend1x.ewallet.core.di.initializer.FeatureHolderInitializer
import rend1x.ewallet.core.di.initializer.GlobalHolderInitializer

interface FeatureContainerManager : FeatureContainer {

    fun init(
        globalHolderInitializer: GlobalHolderInitializer,
        featureHolderInitializer: FeatureHolderInitializer
    ): FeatureContainerManager
}