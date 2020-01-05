package command

interface Command {
}

typealias CommandHandler = (Command) -> Unit

class CommandHandlerImpl (val evaluate: CommandHandler) :CommandHandler {
    override fun invoke(p1: Command) {
        evaluate(p1)
    }
}