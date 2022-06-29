package ng.devtamuno.bolt.domain.usecase.user

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.UserDomainModel
import ng.devtamuno.bolt.domain.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class GetUserUseCaseTest {

    private val testUserList = listOf(
        UserDomainModel(
            id = null,
            firstName = "James",
            lastName = "John",
            email = "james@gmail.com",
            phoneNumber = "+23498989345",
            isEmailVerified = false
        )
    )

    private lateinit var userRepository: UserRepository
    private lateinit var coroutineDispatcher: CoroutinePostDispatchers
    private lateinit var getUserUseCase: GetUserUseCase

    @Before
    fun setUp() {
        userRepository = mock(UserRepository::class.java)
        coroutineDispatcher = object : CoroutinePostDispatchers {
            override val main: CoroutineDispatcher
                get() = TestCoroutineDispatcher()
            override val io: CoroutineDispatcher
                get() = TestCoroutineDispatcher()
            override val default: CoroutineDispatcher
                get() = TestCoroutineDispatcher()

        }

        getUserUseCase = GetUserUseCase(userRepository, coroutineDispatcher)

        `when`(userRepository.getUserCache()).thenReturn(flowOf(testUserList))
    }


    @Test
    fun `test number of times user repository's getUserCache is called, expected at least once`() =
        runBlockingTest {
            getUserUseCase().first()
            verify(userRepository, atLeastOnce()).getUserCache()
        }


    @Test
    fun `test getUserUseCase returns a list of users containing only 1 item`() = runBlockingTest {

        val userList = getUserUseCase().first()
        assertThat(userList).isNotEmpty()
        assertThat(userList.size).isEqualTo(1)

    }
}