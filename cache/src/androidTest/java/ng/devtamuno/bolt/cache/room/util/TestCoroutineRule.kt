package ng.devtamuno.bolt.cache.room.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class TestCoroutineRule(
    private val scheduler: TestCoroutineScheduler = TestCoroutineScheduler(),
    private val testDispatcher: TestDispatcher = StandardTestDispatcher(
        scheduler = scheduler,
        name = "ioDispatcher",
    )
) : TestWatcher() {

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }


    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
