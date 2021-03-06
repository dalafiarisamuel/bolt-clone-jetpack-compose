package ng.devtamuno.bolt.domain.usecase.user

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class GetUserUseCaseTest : BaseUserUseCaseTest() {

    private lateinit var getUserUseCase: GetUserUseCase

    @Before
    override fun setUp() {
        super.setUp()

        getUserUseCase = GetUserUseCase(userRepository, coroutineDispatcher)

        `when`(userRepository.getUserCache()).thenReturn(flowOf(listOf(user)))
    }


    @Test
    fun `test number of times user repository's getUserCache is called, expected at least once`(): Unit =
        runBlocking {
            getUserUseCase().first()
            verify(userRepository, atLeastOnce()).getUserCache()
        }


    @Test
    fun `test getUserUseCase returns a list of users containing only 1 item`(): Unit = runBlocking {

        getUserUseCase().first().apply {
            assertThat(this).isNotEmpty()
            assertThat(this).hasSize(1)
        }

    }
}