package ng.devtamuno.bolt.domain.usecase.user

import io.mockk.MockKStubScope
import io.mockk.Ordering
import io.mockk.every
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import ng.devtamuno.bolt.domain.model.UserDomainModel

object TestUtil {


    fun createUser(
        id: Long? = null,
        firstName: String = "James",
        lastName: String = "John",
        email: String = "james@gmail.com",
        phoneNumber: String = "+23498989345",
        isEmailVerified: Boolean = false

    ): UserDomainModel {
        return UserDomainModel(
            id,
            firstName,
            lastName,
            email,
            phoneNumber,
            isEmailVerified
        )
    }

    fun <T> verifySuspended(
        ordering: Ordering = Ordering.UNORDERED,
        inverse: Boolean = false,
        atLeast: Int = 1,
        atMost: Int = Int.MAX_VALUE,
        exactly: Int = -1,
        timeout: Long = 0,
        testBody: suspend () -> T,
    ) = verify(
        ordering = ordering,
        inverse = inverse,
        atLeast = atLeast,
        atMost = atMost,
        exactly = exactly,
        timeout = timeout
    ) {

        runBlocking {
            testBody()
        }

    }

    fun <T> everySuspended(
        testBody: suspend () -> T,
    ): MockKStubScope<T, T> {

        return every {
            runBlocking {
                testBody()
            }
        }

    }
}
