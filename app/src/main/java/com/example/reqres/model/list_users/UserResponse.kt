package com.example.reqres.model.list_users

data class UserResponse(
	val data: List<DataItem?>? = null,
	val page: Int? = null,
	val perPage: Int? = null,
	val support: Support? = null,
	val total: Int? = null,
	val totalPages: Int? = null,
)
