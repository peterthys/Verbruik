package com.example.winkellijst.fragments

import android.content.ClipData
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
import com.example.winkellijst.data.ItemViewmodel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.custom_row.*
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment(), ListAdapter.OnItemClickListener {

    private lateinit var mItemViewModel: ItemViewmodel
    private lateinit var itemsList: LiveData<List<Boodschap>>
    private var gekozenBoodschap = Boodschap(0, "")
    private val adapter = ListAdapter(gekozenBoodschap, this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        mItemViewModel = ViewModelProvider(this).get(ItemViewmodel::class.java)
        itemsList = mItemViewModel.readAllItems

        val recyclerView = view.rv_items
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mItemViewModel = ViewModelProvider(this).get(ItemViewmodel::class.java)
        mItemViewModel.readAllItems.observe(
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


    //    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId==R.id.menu_delete)
//            var selectedItem = Boodschap
//            deleteBoodschap(boodschap = )
//        return super.onOptionsItemSelected(item)
//    }
    fun deleteBoodschap(position: Int) =
        Toast.makeText(requireContext(), "choosen !", Toast.LENGTH_SHORT).show()

    override fun onItemClick(boodschap: Boodschap) {
        gekozenBoodschap = boodschap
        Toast.makeText(requireContext(), "$boodschap verwijderd", Toast.LENGTH_SHORT).show()
    }
}
//    override fun onItemClick(position: Int) {
//        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
//
//
//}