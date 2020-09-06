package com.gads.assignment.skilliq

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.gads.assignment.R
import com.gads.assignment.api.GadsService
import com.gads.assignment.models.SkillIQLeader
import kotlinx.android.synthetic.main.fragment_skill_iq_leaders.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkillIQLeadersFragment : Fragment(R.layout.fragment_skill_iq_leaders) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GadsService
            .create()
            .getSkillIQLeaders()
            .enqueue(object : Callback<List<SkillIQLeader>> {

                override fun onResponse(
                    call: Call<List<SkillIQLeader>>,
                    response: Response<List<SkillIQLeader>>
                ) {
                    val skillIQLeaders = response.body() ?: emptyList()
                    skillIQLeadersRecyclerView.adapter = SkillIQLeadersAdapter(skillIQLeaders)
                }

                override fun onFailure(call: Call<List<SkillIQLeader>>, t: Throwable) {
                    Log.e("Skill IQ Error", "$t")
                }

            })
    }

    companion object {
        fun newInstance(): SkillIQLeadersFragment = SkillIQLeadersFragment()
    }

}
