package rend1x.ewallet

import android.app.Application

class App : Application() {

    init {
        initDagger()
        initTimber()
    }

    private fun initDagger() {
//        DI.init(
//
//        )
    }

    private fun initTimber() {
        TODO("Not yet implemented")
    }
}