package com.example.knockdeokbae

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main.view.*

class Main : Fragment() {
    private lateinit var mainActivity : MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.main, null)

        view.btn_gameStart.setOnClickListener {
            mainActivity.onFragmentChange("난이도 선택")
        }

        view.btn_how.setOnClickListener {
            mainActivity.onFragmentChange("how")
        }
        return view
    }
}

