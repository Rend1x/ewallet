package rend1x.ewallet.core.di.container

import rend1x.ewallet.core.di.contracts.ReleasableApi
import rend1x.ewallet.core.di.navigation.BaseLauncher

object NotInitializedFeatureContainer : FeatureContainer {
    override fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi =
        throw IllegalStateException(ERROR_MESSAGE)

    override fun releaseFeatureComponent(key: Class<out ReleasableApi>) =
        throw IllegalStateException(ERROR_MESSAGE)

    override fun <GC> getGlobalComponent(key: Class<GC>): GC =
        throw IllegalStateException(ERROR_MESSAGE)

    override fun <L : BaseLauncher> getFeatureLauncher(key: Class<out L>): BaseLauncher =
        throw IllegalStateException(ERROR_MESSAGE)


    private const val ERROR_MESSAGE = "need init"
}