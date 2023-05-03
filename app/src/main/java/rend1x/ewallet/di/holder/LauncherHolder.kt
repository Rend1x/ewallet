package rend1x.ewallet.di.holder

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.holder.BaseHolder
import rend1x.ewallet.core.di.navigation.LauncherApi

internal class LauncherHolder(
    container: FeatureContainer
) : BaseHolder<LauncherApi>(container) {
    override fun buildComponent(): LauncherApi {
        TODO("Not yet implemented")
    }
}