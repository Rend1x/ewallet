package rend1x.ewallet.core.di.holder

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.contracts.ReleasableApi
import rend1x.ewallet.core.di.navigation.BaseLauncher

abstract class FeatureHolder<C : ReleasableApi>(container: FeatureContainer) :
    BaseHolder<C>(container) {

    fun releaseFeature() {
        componentApi = null
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): L {
        return container.getFeatureLauncher(key) as L
    }
}