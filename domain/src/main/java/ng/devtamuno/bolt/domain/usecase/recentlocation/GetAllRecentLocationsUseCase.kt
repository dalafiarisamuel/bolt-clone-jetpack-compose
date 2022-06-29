package ng.devtamuno.bolt.domain.usecase.recentlocation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.RecentLocationDomainModel
import ng.devtamuno.bolt.domain.repository.RecentLocationRepository
import javax.inject.Inject

class GetAllRecentLocationsUseCase @Inject constructor(
    private val repository: RecentLocationRepository,
    private val dispatchers: CoroutinePostDispatchers
) {

    @ExperimentalCoroutinesApi
    operator fun invoke(): Flow<List<RecentLocationDomainModel>> {
        return repository.getAllRecentLocationsCache().flowOn(dispatchers.io)
    }
}