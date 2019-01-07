package com.example.jonat.fragmentview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ViewModel(application: Application) : AndroidViewModel(application) {
    val recipies : MutableLiveData<MutableList<Recipe>> = MutableLiveData()
    fun getRecipe() {
        val url = "https://www.food2fork.com/api/search?key=d95461a58c63c28ddbe5796f7511f980"
        val request =  Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val recipe = gson.fromJson(body, Recipe::class.java)
                //       val recipee = RecipeInfo(recipe.title, recipe.image)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
            }

        })
    }


}