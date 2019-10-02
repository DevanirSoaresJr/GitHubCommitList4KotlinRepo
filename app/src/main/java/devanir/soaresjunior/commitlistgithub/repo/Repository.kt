package devanir.soaresjunior.commitlistgithub.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.commitlistgithub.data.CommitResponse

interface Repository{

    fun getCommits(): LiveData<List<CommitResponse>>

    fun dispose()
}

