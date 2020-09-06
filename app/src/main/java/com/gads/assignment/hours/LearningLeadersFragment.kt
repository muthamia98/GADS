package com.gads.assignment.hours

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.gads.assignment.R
import com.gads.assignment.api.GadsService
import com.gads.assignment.models.LearningLeader
import kotlinx.android.synthetic.main.fragment_learning_leaders.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LearningLeadersFragment : Fragment(R.layout.fragment_learning_leaders) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GadsService
            .create()
            .getLearningLeaders()
            .enqueue(object : Callback<List<LearningLeader>> {

                override fun onResponse(
                    call: Call<List<LearningLeader>>,
                    response: Response<List<LearningLeader>>
                ) {
                    val learningLeaders = response.body() ?: emptyList()
                    learningLeadersRecyclerView.adapter = LearningLeadersAdapter(learningLeaders)
                }

                override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
                    Log.e("Learning Leaders Error", "$t")
                }
            })
    }

    companion object {
        fun newInstance(): LearningLeadersFragment = LearningLeadersFragment()
    }
}
