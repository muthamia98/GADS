package com.gads.assignment.hours

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.gads.assignment.R
import com.gads.assignment.models.LearningLeader
import kotlinx.android.synthetic.main.view_learning_leader.view.*

class LearningLeadersAdapter(
    private val learningLeaders: List<LearningLeader>
) : RecyclerView.Adapter<LearningLeadersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningLeadersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_learning_leader, parent, false)
        return LearningLeadersViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearningLeadersViewHolder, position: Int) {
        holder.bind(learningLeader = learningLeaders[position])
    }

    override fun getItemCount(): Int = learningLeaders.size

}

class LearningLeadersViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(learningLeader: LearningLeader) {
        with(itemView) {
            nameTextView.text = learningLeader.name
            hoursAndCountryTextView.text =
                "${learningLeader.hours} Learning Hours,${learningLeader.country}"
            badgeImageView.load(learningLeader.badgeUrl)
        }
    }
}