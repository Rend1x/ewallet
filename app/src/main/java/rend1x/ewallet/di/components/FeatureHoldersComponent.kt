package rend1x.ewallet.di.components

import dagger.BindsInstance
import dagger.Component
import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.holder.FeatureHolder
import rend1x.ewallet.di.modules.FeatureHoldersModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FeatureHoldersModule::class]
)
internal interface FeatureHoldersComponent {

    fun getFeatureHolders(): Map<Class<*>, FeatureHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance featureContainer: FeatureContainer
        ): FeatureHoldersComponent
    }
}