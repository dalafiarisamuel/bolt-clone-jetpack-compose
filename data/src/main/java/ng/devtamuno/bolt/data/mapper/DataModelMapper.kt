package ng.devtamuno.bolt.data.mapper

abstract class DataModelMapper<E, D> {

    abstract fun mapFromDataModel(dataModel: E): D

    abstract fun mapToDataModel(domainModel: D): E

    fun mapFromEntityList(dataModelList: List<E>): List<D> {
        val domainModels = mutableListOf<D>()
        dataModelList.forEach {
            domainModels.add(mapFromDataModel(it))
        }

        return domainModels
    }


    fun mapFromDomainList(domainModels: List<D>): List<E> {
        val dataModelList = mutableListOf<E>()
        domainModels.forEach {
            dataModelList.add(mapToDataModel(it))
        }

        return dataModelList
    }
}