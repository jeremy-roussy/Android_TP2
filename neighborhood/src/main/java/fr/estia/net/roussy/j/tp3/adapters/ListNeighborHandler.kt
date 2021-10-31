package fr.estia.net.roussy.j.tp3.adapters

import fr.estia.net.roussy.j.tp3.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
}
