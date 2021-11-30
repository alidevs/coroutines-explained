package com.alidevs.userslist.view.api

import com.alidevs.userslist.view.model.UserModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

	@GET("User")
	suspend fun getUsersList(): Response<List<UserModel>>

	companion object {
		var instance: Api? = null
			private set
			get() {
				if (field == null) {
					field = Retrofit.Builder()
						.baseUrl("https://618ebc2e50e24d0017ce141f.mockapi.io/")
						.addConverterFactory(GsonConverterFactory.create())
						.build()
						.create(Api::class.java)
				}

				return field
			}
	}

}