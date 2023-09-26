package rend1x.ewallet.core.di.initializer

import rend1x.ewallet.core.di.container.FeatureContainerManager
import rend1x.ewallet.core.di.holder.BaseHolder

interface GlobalHolderInitializer {

    fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, BaseHolder<*>>

}