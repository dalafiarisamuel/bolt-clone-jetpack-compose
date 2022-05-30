package ng.devtamuno.bolt.domain.usecase.recentlocation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.TripHistoryDomainModel
import ng.devtamuno.bolt.domain.repository.TripHistoryRepository
import javax.inject.Inject

class GetAllRecentLocationsUseCase @Inject constructor(
    private val repository: TripHistoryRepository,
    private val dispatchers: CoroutinePostDispatchers
) {

    @ExperimentalCoroutinesApi
    operator fun invoke(): Flow<List<TripHistoryDomainModel>> {
        return repository.getAllTripHistoriesCache().flowOn(dispatchers.io)
    }
}