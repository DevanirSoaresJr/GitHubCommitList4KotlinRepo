package devanir.soaresjunior.commitlistgithub.net

import devanir.soaresjunior.commitlistgithub.data.CommitResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CommitService {
    @GET("/repos/jetbrains/kotlin/commits")
    fun getCommits(): Single<List<CommitResponse>>
}