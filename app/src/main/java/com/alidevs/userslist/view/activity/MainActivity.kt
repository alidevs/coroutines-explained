package com.alidevs.userslist.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alidevs.userslist.databinding.ActivityMainBinding
import com.alidevs.userslist.view.adapter.UsersAdapter
import com.alidevs.userslist.view.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var adapter: UsersAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val viewModel: UserViewModel by viewModels()

		adapter = UsersAdapter()
		binding.recyclerView.adapter = adapter

		viewModel.liveData.observe(this) { usersList ->
			if (usersList.isNotEmpty() && usersList != null) {
				adapter.setData(usersList)
			} else {
				Toast.makeText(this, "Users' list is empty!", Toast.LENGTH_SHORT).show()
			}
		}

		viewModel.getUsers()
	}
}