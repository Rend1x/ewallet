package rend1x.ewallet.core.main.di.holder

import rend1x.ewallet.core.di.container.FeatureContainer
import rend1x.ewallet.core.di.holder.FeatureHolder
import rend1x.ewallet.core.main.di.external.MainApi

class MainHolder(container: FeatureContainer) : FeatureHolder<MainApi>(container) {

    override fun buildComponent(): MainApi {
        TODO("Not yet implemented")
    }

}