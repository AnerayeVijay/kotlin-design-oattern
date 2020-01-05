package command

class LightCommandHandler {

    class SwitchOff :Command
    class SwitchOn : Command

    class LightCommandHandlerImpl(private val light: LightInterface) : lightCommandEval {
        override fun invoke(command: Command) {
            when(command) {
                is SwitchOff -> light.switchOffLight()
                is SwitchOn -> light.switchOnLight()
            }
        }
    }
}

interface LightInterface {
    fun switchOffLight()
    fun switchOnLight()

}

typealias lightCommandEval = CommandHandler
