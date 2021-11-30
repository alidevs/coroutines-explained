package com.alidevs.userslist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alidevs.userslist.databinding.UserRowBinding
import com.alidevs.userslist.view.model.UserModel

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

	private lateinit var binding: UserRowBinding
	private var data: List<UserModel>

	init {
		data = listOf()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		binding = UserRowBinding.inflate(inflater, parent, false)

		return ViewHolder(binding.root)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(data[position])
	}

	override fun getItemCount(): Int {
		return data.size
	}

	fun setData(list: List<UserModel>) {
		data = list
		notifyDataSetChanged()
	}

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(userModel: UserModel) = with(itemView) {
			// Set data to your item view here
			binding.rowUserEmail.text = userModel.email
			binding.rowUserNameTextView.text = userModel.username
			setOnClickListener {
				onClick(userModel)
			}
		}

		private fun onClick(item: UserModel) {

		}
	}

}