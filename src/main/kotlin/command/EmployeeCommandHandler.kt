package command

data class AddEmployee(val id : Int, val name: String) : Command
data class DeleteEmployee(val id: Int) : Command

class EmployeeCommandHandler(private val repository: EmployeeRepository) : Evaluate {

   override fun invoke(command: Command) {
        when (command) {
            is AddEmployee -> command.invoke()
            is DeleteEmployee -> command.invoke()
        }
    }

    private fun AddEmployee.invoke() {
        repository.add(id,name)
    }

    private fun DeleteEmployee.invoke() {
        repository.delete(id)
    }

}

interface EmployeeRepository {
    fun add(id: Int, name: String)
    fun delete(id: Int)

}

typealias Evaluate = CommandHandler
