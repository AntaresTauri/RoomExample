package com.antares.roomexample

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private val notelist = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview_id)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val notesAdapter = AdapterRV(notelist)
        recyclerView.adapter = notesAdapter
        fab = view.findViewById(R.id.fab)

        fab.setOnClickListener {
            alertDialog()
        }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(context)
        val inflater = layoutInflater

        builder.setTitle("Добавьте текст")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog, null)

        val ediText = dialogLayout.findViewById<EditText>(R.id.edit_text)
        builder.setView(dialogLayout)

        builder.setPositiveButton("Добавить") { dialogInterface, i ->
            Toast.makeText(
                requireActivity().applicationContext,
                "Текст добавлен",
                Toast.LENGTH_SHORT
            ).show()
            notelist.add(ediText.text.toString())
        }
        builder.show()
    }
}