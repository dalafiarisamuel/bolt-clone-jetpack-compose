package ng.devtamuno.bolt.domain.usecase.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.UserDomainModel
import ng.devtamuno.bolt.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatchers: CoroutinePostDispatchers
) {

    @ExperimentalCoroutinesApi
    operator fun invoke(): Flow<List<UserDomainModel>> {
        return userRepository.getUserCache().flowOn(dispatchers.io)
    }

}