package com.example.knockdeokbae

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.difficulty_selection.view.*

class DifficultySelection : Fragment() {
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.difficulty_selection, null)

        view.btn_easy.setOnClickListener {
            mainActivity.onFragmentChange("게임 플레이_easy");
        }

        view.btn_normal.setOnClickListener {
            mainActivity.onFragmentChange("게임 플레이_normal");
        }

        view.btn_hard.setOnClickListener {
            mainActivity.onFragmentChange("게임 플레이_hard");
        }

        return view
    }
}