package ng.devtamuno.bolt.domain.usecase.user

import io.mockk.clearMocks
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.repository.UserRepository

@ExperimentalCoroutinesApi
open class BaseUserUseCaseTest {

    val userRepository: UserRepository = mockk()
    val coroutineDispatcher: CoroutinePostDispatchers = object : CoroutinePostDispatchers {
        override val main: CoroutineDispatcher
            get() = UnconfinedTestDispatcher()
        override val io: CoroutineDispatcher
            get() = UnconfinedTestDispatcher()
        override val default: CoroutineDispatcher
            get() = UnconfinedTestDispatcher()

    }

    open fun reset() {
        clearMocks(userRepository)
    }
}
