package com.gads.assignment.skilliq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gads.assignment.R
import com.gads.assignment.models.SkillIQLeader
import kotlinx.android.synthetic.main.view_skill_iq_leader.view.*

class SkillIQLeadersAdapter(
    private val skillIQLeaders: List<SkillIQLeader>
) : RecyclerView.Adapter<SkillIQLeadersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIQLeadersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_skill_iq_leader, parent, false)
        return SkillIQLeadersViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillIQLeadersViewHolder, position: Int) {
        holder.bind(skillIQLeader = skillIQLeaders[position])
    }

    override fun getItemCount(): Int = skillIQLeaders.size

}

class SkillIQLeadersViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(skillIQLeader: SkillIQLeader) {
        with(itemView) {
            nameTextView.text = skillIQLeader.name
            skillIQAndCountryTextView.text =
                "${skillIQLeader.score} Skill IQ Score,${skillIQLeader.country}"
            badgeImageView.load(skillIQLeader.badgeUrl)
        }
    }
}