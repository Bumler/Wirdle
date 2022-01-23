package dependencyInjection

import commandLayer.MessageInputProcessor
import dataLayer.GameRepo
import dataLayer.PlayerRepo
import dataLayer.WordRepo
import dataLayer.inMemoryRepos.InMemoryGameRepo
import dataLayer.inMemoryRepos.InMemoryPlayerRepo
import dataLayer.inMemoryRepos.InMemoryWordRepo
import org.koin.dsl.module

val cliTestingDependencies = module {
    single<PlayerRepo> { InMemoryPlayerRepo() }
    single<GameRepo> { InMemoryGameRepo() }
    single<WordRepo> { InMemoryWordRepo() }
}