package ng.devtamuno.bolt.cache.mapper

interface CacheModelMapper<M, E> {

    fun mapToEntity(model: M): E

    fun mapToModel(entity: E): M

    fun mapToEntityList(models: List<M>?): List<E> {
        val list = mutableListOf<E>()
        models?.forEach {
            list.add(mapToEntity(it))
        }

        return list
    }

    fun mapToModelList(models: List<E>?): List<M> {
        val list = mutableListOf<M>()
        models?.forEach {
            list.add(mapToModel(it))
        }

        return list
    }
}