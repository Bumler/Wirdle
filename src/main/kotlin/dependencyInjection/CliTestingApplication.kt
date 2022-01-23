package dependencyInjection

import commandLayer.MessageInputProcessor
import org.koin.core.KoinComponent
import org.koin.core.inject
import util.Constants.consoleId

class CliTestingApplication : KoinComponent {
    private val messageInputProcessor by inject<MessageInputProcessor>()

    fun run(){
        println("Ok trying to run")
        val result = messageInputProcessor.processCommand("!play", consoleId)
        println("Run succeeded")
        println(result.message)
    }
}