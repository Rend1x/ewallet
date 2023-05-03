package rend1x.ewallet.core.di.container

import rend1x.ewallet.core.di.contracts.ReleasableApi
import rend1x.ewallet.core.di.holder.BaseHolder
import rend1x.ewallet.core.di.holder.FeatureHolder
import rend1x.ewallet.core.di.initializer.FeatureHolderInitializer
import rend1x.ewallet.core.di.initializer.GlobalHolderInitializer
import rend1x.ewallet.core.di.navigation.BaseLauncher
import rend1x.ewallet.core.di.navigation.LauncherApi

class FeatureContainerImpl(
    private val globalHolder: MutableMap<Class<*>, BaseHolder<*>> = HashMap(),
    private val featureHolder: MutableMap<Class<ReleasableApi>, FeatureHolder<ReleasableApi>> = HashMap(),
    private val featureLaunchers: MutableMap<Class<*>, BaseLauncher> = HashMap()
) : FeatureContainerManager {

    private var featureInitializer: FeatureHolderInitializer? = null

    override fun init(
        globalHolderInitializer: GlobalHolderInitializer,
        featureHolderInitializer: FeatureHolderInitializer
    ): FeatureContainerManager {
        globalHolder.putAll(globalHolderInitializer.init(this))
        this.featureInitializer = featureHolderInitializer
        return this
    }

    override fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi {
        return getFeatureHolder(key).getComponent()
    }

    override fun releaseFeatureComponent(key: Class<out ReleasableApi>) {
        featureHolder[key]?.releaseFeature() ?: throw IllegalStateException(
            "failed release holder $key"
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun <GC> getGlobalComponent(key: Class<GC>): GC {
        return globalHolder[key]?.getComponent() as GC
            ?: throw IllegalStateException(
                "failed get global component $key"
            )
    }

    override fun <L : BaseLauncher> getFeatureLauncher(key: Class<out L>): BaseLauncher {
        if (featureLaunchers.isEmpty()) {
            featureLaunchers.putAll(
                (globalHolder[LauncherApi::class.java]?.getComponent() as LauncherApi).provideLauncher()
            )
        }
        return featureLaunchers[key] ?: error("failed get Feature launcher $key")
    }

    private fun getFeatureHolder(key: Class<out ReleasableApi>): FeatureHolder<out ReleasableApi> {
        if (featureHolder.isEmpty()) {
            initAllFeatureHolder()
        }
        return featureHolder[key] ?: throw IllegalStateException("failed get feature holder $key")
    }

    @Suppress("UNCHECKED_CAST")
    private fun initAllFeatureHolder() {
        featureInitializer?.let { init ->
            featureHolder.putAll(
                init.init(this) as Map<out Class<ReleasableApi>, FeatureHolder<ReleasableApi>>
            )
        }
    }
}