package ng.devtamuno.bolt.domain.usecase.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.UserDomainModel
import ng.devtamuno.bolt.domain.repository.UserRepository
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
abstract class BaseUserUseCaseTest {

    lateinit var userRepository: UserRepository
    lateinit var coroutineDispatcher: CoroutinePostDispatchers

    val user = UserDomainModel(
        id = null,
        firstName = "James",
        lastName = "John",
        email = "james@gmail.com",
        phoneNumber = "+23498989345",
        isEmailVerified = false
    )


    open fun setUp() {
        userRepository = mock(UserRepository::class.java)
        coroutineDispatcher = object : CoroutinePostDispatchers {
            override val main: CoroutineDispatcher
                get() = UnconfinedTestDispatcher()
            override val io: CoroutineDispatcher
                get() = UnconfinedTestDispatcher()
            override val default: CoroutineDispatcher
                get() = UnconfinedTestDispatcher()

        }

    }
}