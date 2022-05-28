package ng.devtamuno.bolt.domain.executor

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutinePostDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}