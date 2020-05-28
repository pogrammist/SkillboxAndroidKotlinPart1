package com.example.kotlin78toolbar

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity() {

    private val users = listOf(
        "User1",
        "User2",
        "Unknown"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        initToolbar()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener {
            toast("Navigation clicked")
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_1 -> {
                    toast("action 1 clicked")
                    true
                }
                R.id.action_2 -> {
                    toast("action 2 clicked")
                    true
                }
                R.id.action_3 -> {
                    toast("action 3 clicked")
                    true
                }
                R.id.action_4 -> {
                    toast("action 4 clicked")
                    true
                }
                R.id.action_5 -> {
                    toast("action 5 clicked")
                    true
                }
                R.id.action_6 -> {
                    toast("action 6 clicked")
                    true
                }
                R.id.action_search -> {
                    toast("search clicked")
                    true
                }
                else -> false
            }
        }

        val searchItem = toolbar.menu.findItem(R.id.action_search)
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                expandTextView.text = getString(R.string.search_expanded)
                toast("search expanded")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                expandTextView.text = getString(R.string.search_collapse)
                toast("search collapse")
                return true
            }
        })

        (searchItem.actionView as SearchView).setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                users.filter { it.contains(newText ?: "", ignoreCase = true) }
                    .joinToString()
                    .let {
                        searchResultTextView.text = it
                    }
                return true
            }
        })
    }
}