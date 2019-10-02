package devanir.soaresjunior.commitlistgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import devanir.soaresjunior.commitlistgithub.R
import devanir.soaresjunior.commitlistgithub.adapter.CommitListAdapter
import devanir.soaresjunior.commitlistgithub.data.CommitResponse
import devanir.soaresjunior.commitlistgithub.di.ActivityComponent
import devanir.soaresjunior.commitlistgithub.di.ActivityModule
import devanir.soaresjunior.commitlistgithub.di.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: HomeViewModel
    lateinit var activityComponent: ActivityComponent

    private lateinit var commitListAdapter: CommitListAdapter
    private var commits = listOf<CommitResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)

        onResume()

    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchCommits().observe(this, Observer {
            commitListAdapter = CommitListAdapter()
            commitListAdapter.setData(commits)


            rvCommits.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = commitListAdapter
                commits = it
            }
        })
        viewModel.fetchCommits()
        commitListAdapter = CommitListAdapter()
        commitListAdapter.setData(commits)
    }
}
