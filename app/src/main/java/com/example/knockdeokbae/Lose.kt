package com.example.knockdeokbae

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.win.view.*

class Lose : Fragment() {
    private lateinit var mainActivity : MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.lose, null)

        view.btn_home.setOnClickListener {
            mainActivity.onFragmentChange("메인화면")
        }
        return view
    }
}