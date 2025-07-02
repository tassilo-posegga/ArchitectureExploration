package eu.aggesop.architectureexploration

import android.app.Application
import eu.aggesop.architectureexploration.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ArchitectureExplorationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@ArchitectureExplorationApplication)
            modules(appModule)
        }
    }
}