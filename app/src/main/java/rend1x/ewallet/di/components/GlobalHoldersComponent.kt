package rend1x.ewallet.di.components

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import rend1x.ewallet.core.di.container.FeatureContainerManager
import rend1x.ewallet.core.di.holder.BaseHolder
import rend1x.ewallet.di.modules.GlobalHoldersModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [GlobalHoldersModule::class]
)
interface GlobalHoldersComponent {

    fun getGlobalComponent(): Map<Class<*>, BaseHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance app: Application,
            @BindsInstance appContext: Context,
            @BindsInstance featureContainerManager: FeatureContainerManager,
        ): GlobalHoldersComponent
    }
}