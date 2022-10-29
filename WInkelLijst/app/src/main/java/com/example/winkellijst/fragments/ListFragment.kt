package com.example.winkellijst.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.winkellijst.ListAdapter
import com.example.winkellijst.R
import com.example.winkellijst.data.Boodschap
import com.example.winkellijst.data.BoodschapViewmodel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment(), ListAdapter.OnItemClickListener {

    private lateinit var mBoodschapViewModel: BoodschapViewmodel
    private lateinit var itemsList: LiveData<List<Boodschap>>
    private var gekozenBoodschap = Boodschap(0, "")
    private val adapter = ListAdapter(gekozenBoodschap, this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        mBoodschapViewModel = ViewModelProvider(this).get(BoodschapViewmodel::class.java)
        itemsList = mBoodschapViewModel.readAllItems

        val recyclerView = view.rv_items
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mBoodschapViewModel = ViewModelProvider(this).get(BoodschapViewmodel::class.java)
        mBoodschapViewModel.readAllItems.observe(
            viewLifecycleOwner,
            Observer { item ->
                adapter.setData(item)


            }
        )
        view.fab_add.setOnClickListener {

            Toast.makeText(requireContext(), "Updated !", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        setHasOptionsMenu(true)


        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)

    }

    fun deleteBoodschap() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mBoodschapViewModel.deleteBoodschap(boodschap = gekozenBoodschap)
            Toast.makeText(requireContext(), "${gekozenBoodschap.productsName} verwijderd", Toast.LENGTH_SHORT)
                .show()
                }
        builder.setNegativeButton("No") { _, _ ->
            mBoodschapViewModel.deleteAllBoodschap()
            Toast.makeText(requireContext(), "Alles verwijderd", Toast.LENGTH_SHORT)
                .show()


        }
        builder.setTitle("Delete ${gekozenBoodschap.productsName}? (YES) or delete all items (NO)")
        builder.setMessage("Are you sure to delete ${gekozenBoodschap.productsName}?")
        builder.create().show()
    }

    override fun onItemClick(boodschap: Boodschap) {
        gekozenBoodschap = boodschap
        deleteBoodschap()
        Toast.makeText(requireContext(), "${boodschap.productsName} verwijderd", Toast.LENGTH_SHORT)
            .show()
    }
}
