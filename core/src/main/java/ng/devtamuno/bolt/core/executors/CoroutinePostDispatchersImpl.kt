package ng.devtamuno.bolt.core.executors

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers

import javax.inject.Inject

class CoroutinePostDispatchersImpl @Inject constructor() : CoroutinePostDispatchers {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}