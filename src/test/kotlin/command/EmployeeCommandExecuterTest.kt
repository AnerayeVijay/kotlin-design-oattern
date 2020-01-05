package command

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class EmployeeCommandExecuterTest {

    @Mock
    lateinit var repository: EmployeeRepository

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `add employee command`() {
        val employeeCommand = EmployeeCommandHandler(repository)
        val employeeCmdExecute = CommandHandlerImpl(employeeCommand)
        val employeeId = 1
        val employeeName = "EmployeeName"
        employeeCmdExecute((AddEmployee(employeeId, employeeName)))
        verify(repository, times(1)).add(employeeId,employeeName)
    }

    @Test
    fun `delete employee command`() {
        val employeeCommand = EmployeeCommandHandler(repository)
        val employeeCmdExecute = CommandHandlerImpl(employeeCommand)
        val employeeId = 1
        employeeCmdExecute((DeleteEmployee(employeeId)))
        verify(repository, times(1)).delete(employeeId)

    }
}

