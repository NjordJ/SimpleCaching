package com.iruda.simplecaching.features.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.iruda.simplecaching.databinding.FragmentRestaurantsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentRestaurantsBinding.bind(view)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            recyclerViewRestaurants.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.restaurants.observe(viewLifecycleOwner) { restaurants ->
                restaurantAdapter.submitList(restaurants)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}