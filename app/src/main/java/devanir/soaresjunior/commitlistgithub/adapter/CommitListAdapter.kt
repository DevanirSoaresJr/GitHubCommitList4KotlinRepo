package devanir.soaresjunior.commitlistgithub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import devanir.soaresjunior.commitlistgithub.R
import devanir.soaresjunior.commitlistgithub.data.CommitResponse
import kotlinx.android.synthetic.main.item_rv_commits.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList



class CommitListAdapter :
    RecyclerView.Adapter<CommitListAdapter.CommitsVH>() {
    private val commitList = ArrayList<CommitResponse>()

    fun setData(commits: List<CommitResponse>){
        commitList.clear()
        commitList.addAll(commits)
    }

    override fun onBindViewHolder(holder: CommitsVH, position: Int) {
        holder.bind(commitList[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitsVH {
        return CommitsVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_commits, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return commitList.size
    }


    class CommitsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCommitTitle: TextView = itemView.findViewById(R.id.tvCommitTitle)
        private val tvAuthorName: TextView = itemView.findViewById(R.id.tvAuthorName)
        private val tvCommitDate: TextView = itemView.findViewById(R.id.tvCommitDate)

        fun bind(cr: CommitResponse) {
            tvCommitTitle.text = cr.commit.message
            tvAuthorName.text = cr.commit.author.name
            tvCommitDate.text = dateFormatter(cr.commit.author.date)

            Picasso.get().load(cr.author.avatarUrl).into(itemView.ivAuthorAvatar)
        }
        private fun dateFormatter(databaseDate: String): String {
            val pattern: String = if (databaseDate.matches(Regex("2019-10-01T06:40:34Z"))) {
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            } else {
                "yyyy-MM-dd'T'hh:mm:ss'Z'"
            }

            val dateFormat = SimpleDateFormat(pattern)
            val date: Date = dateFormat.parse(databaseDate)
            val outputFormat = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
            outputFormat.timeZone = TimeZone.getDefault()

            return outputFormat.format(date)
        }
    }
}
