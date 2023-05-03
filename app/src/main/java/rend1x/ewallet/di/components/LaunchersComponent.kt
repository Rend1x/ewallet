package rend1x.ewallet.di.components

import dagger.Component
import rend1x.ewallet.core.di.navigation.LauncherApi
import rend1x.ewallet.di.modules.LauncherModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [LauncherModule::class]
)
interface LaunchersComponent : LauncherApi