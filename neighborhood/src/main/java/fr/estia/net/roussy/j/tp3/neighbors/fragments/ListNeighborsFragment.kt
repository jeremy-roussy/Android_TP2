package fr.estia.net.roussy.j.tp3.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.estia.net.roussy.j.tp3.NavigationListener
import fr.estia.net.roussy.j.tp3.R
import fr.estia.net.roussy.j.tp3.adapters.ListNeighborHandler
import fr.estia.net.roussy.j.tp3.adapters.ListNeighborsAdapter
import fr.estia.net.roussy.j.tp3.data.NeighborRepository
import fr.estia.net.roussy.j.tp3.databinding.ListNeighborsFragmentBinding
import fr.estia.net.roussy.j.tp3.models.Neighbor

class ListNeighborsFragment :
    Fragment(),
    ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ListNeighborsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        recyclerView = binding.neighborsList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
                it.updateTitle(R.string.new_neighbor)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setMessage(R.string.are_you_sure)
                .setTitle(R.string.confirm)
                .setPositiveButton(
                    R.string.yes
                ) { dialog, _ ->
                    // Send the positive button event back to the host activity
                    NeighborRepository.getInstance().removeNeighbor(neighbor)
                    dialog.dismiss()
                    refreshPage()
                }
                .setNegativeButton(
                    R.string.no
                ) { _, _ ->
                    // Send the negative button event back to the host activity
                }
            builder.create().show()
        }
    }

    private fun refreshPage() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
