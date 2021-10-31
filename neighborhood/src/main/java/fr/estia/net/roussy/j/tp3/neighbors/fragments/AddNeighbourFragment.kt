package fr.estia.net.roussy.j.tp3.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.estia.net.roussy.j.tp3.NavigationListener
import fr.estia.net.roussy.j.tp3.R
import fr.estia.net.roussy.j.tp3.data.NeighborRepository
import fr.estia.net.roussy.j.tp3.databinding.AddNeighborBinding
import fr.estia.net.roussy.j.tp3.models.Neighbor

class AddNeighbourFragment : Fragment(), TextWatcher {

    private lateinit var binding: AddNeighborBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddNeighborBinding.inflate(inflater, container, false)
        with(binding) {
            saveButton.setOnClickListener {
                createUser()
                (activity as? NavigationListener)?.let {
                    it.showFragment(ListNeighborsFragment())
                    it.updateTitle(R.string.neighbors_list)
                }
            }
        }
        return binding.root
    }

    private fun createUser() {
        with(binding) {
            val id = (NeighborRepository.getInstance().getNeighbours().size + 1)
            val name = nameTextField.text.toString()
            val image = imageTextField.text.toString()
            val address = addressTextField.text.toString()
            val telephone = telephoneTextField.text.toString()
            val description = aboutMeTextField.text.toString()
            val webSite = websiteTextField.text.toString()
            val neighbor =
                Neighbor(id.toLong(), name, image, address, telephone, description, false, webSite)
            NeighborRepository.getInstance().createNeighbor(neighbor)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(s: Editable?) {
        TODO("Not yet implemented")
    }

    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    /* URLUtil.isValidUrl(url) */
}
