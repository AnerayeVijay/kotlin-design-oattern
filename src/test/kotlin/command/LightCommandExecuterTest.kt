package command

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LightCommandExecuterTest {

    @Mock
    lateinit var light: LightInterface
    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }



    @Test
    fun `switch on light command`() {
        val lightCommandHandler = LightCommandHandler.LightCommandHandlerImpl(light)
        val lightCommandExecuter = CommandHandlerImpl(lightCommandHandler)

        lightCommandExecuter(LightCommandHandler.SwitchOn())
        verify(light, times(1)).switchOnLight()
    }

    @Test
    fun `switch on command`() {
        val lightCommandHandler = LightCommandHandler.LightCommandHandlerImpl(light)
        val lightCommandExecuter = CommandHandlerImpl(lightCommandHandler)

        lightCommandExecuter(LightCommandHandler.SwitchOn())
        verify(light, times(1)).switchOnLight()
    }
}
