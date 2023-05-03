package rend1x.ewallet.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import rend1x.ewallet.core.di.container.FeatureContainerManager
import rend1x.ewallet.core.di.holder.BaseHolder
import rend1x.ewallet.core.di.navigation.LauncherApi
import rend1x.ewallet.di.holder.LauncherHolder
import javax.inject.Singleton

@Module
internal object GlobalHoldersModule {

    @[Provides Singleton]
    @[IntoMap ClassKey(LauncherApi::class)]
    fun provideLauncherApi(featureContainerManager: FeatureContainerManager): BaseHolder<*> =
        LauncherHolder(featureContainerManager)

}