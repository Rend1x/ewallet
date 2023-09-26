package rend1x.ewallet.core.navigation.api

import rend1x.ewallet.core.navigation.routers.GlobalRouter

interface CoreNavigationApi {

    fun provideGlobalRouter(): GlobalRouter

    fun provideGlobalNavigationHolder(): BackstackHandler

}