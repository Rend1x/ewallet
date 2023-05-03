package rend1x.ewallet.core.di.navigation

interface LauncherApi {

    fun provideLauncher(): Map<Class<*>, BaseLauncher>
}