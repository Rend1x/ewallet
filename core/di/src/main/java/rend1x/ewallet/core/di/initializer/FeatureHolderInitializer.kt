package rend1x.ewallet.core.di.initializer

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.container.FeatureContainerManager
import rend1x.ewallet.core.di.holder.FeatureHolder

interface FeatureHolderInitializer : FeatureContainer {

    fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, FeatureHolder<*>>
}