package ng.devtamuno.bolt.domain.usecase.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import ng.devtamuno.bolt.domain.model.UserDomainModel
import ng.devtamuno.bolt.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatchers: CoroutinePostDispatchers
) {

    @ExperimentalCoroutinesApi
    suspend operator fun invoke(param: Param) {
        withContext(dispatchers.io) {
            userRepository.saveUserCache(param.user)
        }
    }

    data class Param(val user: UserDomainModel)

}