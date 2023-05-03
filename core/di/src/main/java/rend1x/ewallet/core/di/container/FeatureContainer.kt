package rend1x.ewallet.core.di.container

import rend1x.ewallet.core.di.contracts.ReleasableApi
import rend1x.ewallet.core.di.navigation.BaseLauncher

interface FeatureContainer {

    fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi

    fun releaseFeatureComponent(key: Class<out ReleasableApi>)

    fun <GC> getGlobalComponent(key: Class<GC>): GC

    fun <L : BaseLauncher> getFeatureLauncher(key: Class<out L>): BaseLauncher
}