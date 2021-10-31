package fr.estia.net.roussy.j.tp3.data

import fr.estia.net.roussy.j.tp3.data.service.DummyNeighborApiService
import fr.estia.net.roussy.j.tp3.data.service.NeighborApiService
import fr.estia.net.roussy.j.tp3.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun removeNeighbor(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

    fun createNeighbor(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
