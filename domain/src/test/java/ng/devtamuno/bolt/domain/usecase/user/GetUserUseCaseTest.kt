package ng.devtamuno.bolt.domain.usecase.user

import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import ng.devtamuno.bolt.domain.usecase.user.TestUtil.createUser
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetUserUseCaseTest : BaseUserUseCaseTest() {

    private val getUserUseCase: GetUserUseCase = GetUserUseCase(userRepository, coroutineDispatcher)

    @Before
    fun setUp() {
        every {
            userRepository.getUserCache()
        } returns flowOf(listOf(createUser()))
    }

    @After
    override fun reset() {
        super.reset()
    }


    @Test
    fun `test number of times user repository's getUserCache is called, expected at least once`() =
        runTest {
            getUserUseCase().first()
            verify {
                userRepository.getUserCache()
            }
        }


    @Test
    fun `test getUserUseCase returns a list of users containing only 1 item`() = runTest {

        getUserUseCase().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
        }

    }
}
