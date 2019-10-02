package devanir.soaresjunior.commitlistgithub.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devanir.soaresjunior.commitlistgithub.data.CommitResponse
import devanir.soaresjunior.commitlistgithub.net.CommitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val commitService: CommitService) : Repository {

    private val compositeDisposable = CompositeDisposable()
    private val commitsLiveData = MutableLiveData<List<CommitResponse>>()

    override fun getCommits(): LiveData<List<CommitResponse>> {
        compositeDisposable.add(commitService.getCommits()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    commitsLiveData.value = it
                },
                {
                    handleError(it)

                }
            ))

        return commitsLiveData
    }

    override fun dispose() {

        compositeDisposable.clear()
    }
    private fun handleError(throwable:Throwable){
        if (throwable.message != null){
            throwable.printStackTrace()
        }
    }
}