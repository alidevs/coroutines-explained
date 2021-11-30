package com.alidevs.userslist.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alidevs.userslist.view.model.UserModel
import com.alidevs.userslist.view.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

	val liveData = MutableLiveData<List<UserModel>>()
	private val repository = UserRepository()

	fun getUsers() {
		CoroutineScope(Dispatchers.IO).launch {
			val response = repository.getUsersList()

			if (!response.isSuccessful) {
				liveData.postValue(null)

				// Leaves the "launch" block, not the whole function
				// But since there's nothing (no code) under the "launch" block, the function will stop
				return@launch
			}

			response.body()?.let { usersList ->
				// Posts usersList to liveData if the list is not empty.
				// But if it is empty, it would post a null instead
				liveData.postValue(usersList.takeIf { it.isNotEmpty() })
			}
		}
	}

}