package com.gibisoft.knockdeokbae_2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.win.view.*

class Win(_difficulty : String) : Fragment() {
    private lateinit var mainActivity : MainActivity
    var difficulty = _difficulty

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.win, null)

        view.difficulty.text = "$difficulty 난이도 클리어"

        view.btn_home.setOnClickListener {
            mainActivity.onFragmentChange("메인화면")
        }
        return view
    }
}