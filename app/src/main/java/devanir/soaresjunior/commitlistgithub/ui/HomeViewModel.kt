package devanir.soaresjunior.commitlistgithub.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import devanir.soaresjunior.commitlistgithub.data.CommitResponse
import devanir.soaresjunior.commitlistgithub.repo.Repository

class HomeViewModel(private val repository: Repository) : ViewModel(){


   fun fetchCommits():LiveData<List<CommitResponse>> = repository.getCommits()

    override fun onCleared() {
        super.onCleared()
        repository.dispose()

    }


}