package com.alidevs.userslist.view.repository

import com.alidevs.userslist.view.api.Api
import com.alidevs.userslist.view.model.UserModel
import retrofit2.Response

class UserRepository {

	private val retrofitService = Api.instance!!

	suspend fun getUsersList(): Response<List<UserModel>> = retrofitService.getUsersList()

}