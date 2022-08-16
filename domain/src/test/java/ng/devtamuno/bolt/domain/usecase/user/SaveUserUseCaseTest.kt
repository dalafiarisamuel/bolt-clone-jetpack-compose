package ng.devtamuno.bolt.domain.usecase.user

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.runs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import ng.devtamuno.bolt.domain.usecase.user.TestUtil.createUser
import ng.devtamuno.bolt.domain.usecase.user.TestUtil.everySuspended
import ng.devtamuno.bolt.domain.usecase.user.TestUtil.verifySuspended
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SaveUserUseCaseTest : BaseUserUseCaseTest() {

    private lateinit var saveUserUseCase: SaveUserUseCase

    private val param = SaveUserUseCase.Param(createUser())

    @Before
    fun setUp() {
        saveUserUseCase = SaveUserUseCase(userRepository, coroutineDispatcher)

    }

    @After
    override fun reset() {
        super.reset()
    }

    @Test
    fun `test saveUserUseCase for user repository to be called at least once`(): Unit = runTest {

        coEvery {
            saveUserUseCase.invoke(param)
        } just runs


        coEvery {
            userRepository.saveUserCache(param.user)
        } just runs

        saveUserUseCase(param)


        coVerify {
            userRepository.saveUserCache(param.user)
        }


    }
}
