package rend1x.ewallet.core.di

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.container.FeatureContainerImpl
import rend1x.ewallet.core.di.container.NotInitializedFeatureContainer
import rend1x.ewallet.core.di.contracts.ReleasableApi
import rend1x.ewallet.core.di.initializer.FeatureHolderInitializer
import rend1x.ewallet.core.di.initializer.GlobalHolderInitializer
import rend1x.ewallet.core.di.navigation.BaseLauncher

object DI {

    private var featureContainer: FeatureContainer = NotInitializedFeatureContainer

    fun init(
        globalHolderInitializer: GlobalHolderInitializer,
        featureHolderInitializer: FeatureHolderInitializer
    ) {
        val featureContainer = FeatureContainerImpl()
        featureContainer.init(globalHolderInitializer, featureHolderInitializer)
        this.featureContainer = featureContainer
    }

    fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi {
        return featureContainer.getFeatureComponent(key)
    }

    fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        featureContainer.releaseFeatureComponent(key)
    }

    fun <GA> getGlobalApi(key: Class<out GA>): GA {
        return featureContainer.getGlobalComponent(key)
    }

    fun <L : BaseLauncher> getBaseLauncherApi(key: Class<L>): BaseLauncher {
        return featureContainer.getFeatureLauncher(key)
    }

}