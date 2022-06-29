package ng.devtamuno.bolt.domain.usecase.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.atLeastOnce
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class SaveUserUseCaseTest : BaseUserUseCaseTest() {

    private lateinit var saveUserUseCase: SaveUserUseCase

    private val param = SaveUserUseCase.Param(user)

    @Before
    override fun setUp() {
        super.setUp()

        saveUserUseCase = SaveUserUseCase(userRepository, coroutineDispatcher)

    }

    @Test
    fun `test saveUserUseCase for user repository to be called at least once`() = runBlockingTest {

        saveUserUseCase(param)
        verify(userRepository, atLeastOnce())::saveUserCache

    }
}