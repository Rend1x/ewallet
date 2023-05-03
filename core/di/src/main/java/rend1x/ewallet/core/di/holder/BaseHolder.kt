package rend1x.ewallet.core.di.holder

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.contracts.ReleasableApi

abstract class BaseHolder<C>(protected val container: FeatureContainer) {

    protected var componentApi: C? = null

    fun getComponent(): C {
        return componentApi ?: buildComponent().apply {
            componentApi = this@apply
        }
    }

    protected abstract fun buildComponent(): C

    protected fun <GC> getGlobalComponent(key: Class<GC>): GC {
        return container.getGlobalComponent(key)
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <FC> getFeatureComponent(key: Class<out ReleasableApi>): FC {
        return container.getFeatureComponent(key) as FC
    }
}