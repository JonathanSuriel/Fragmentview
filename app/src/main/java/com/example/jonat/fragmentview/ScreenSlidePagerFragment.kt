package com.example.jonat.fragmentview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_screen_slide.*
import okhttp3.OkHttpClient
import okhttp3.Request

class ScreenSlidePagerFragment : Fragment() {

    private lateinit var model: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.model = ViewModelProviders.of(this).get(ViewModel::class.java)
        model.getRecipe()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  {
    val view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
        var title: TextView = view.findViewById(R.id.title)
        var image: ImageView = view.findViewById(R.id.imageView)

        model.recipies.observe(this, Observer {
            RecipeInfo -> RecipeInfo.let {
            title.text =
        }
        })
        return view
    }

    }





