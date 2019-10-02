package devanir.soaresjunior.commitlistgithub.data


import com.google.gson.annotations.SerializedName

data class CommitResponse(
    val url: String,
    val sha: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    val `commit`: Commit,
    val author: Commit.Author,
    val committer: Committer,
    val parents: List<Parent>
) {
    data class Commit(
        val url: String,
        val author: Author,
        val committer: Committer,
        val message: String,
        val tree: Tree,
        @SerializedName("comment_count")
        val commentCount: Int,
        val verification: Verification
    ) {
        data class Author(
            val name: String,
            val email: String,
            val date: String,
            val login: String,
            val id: Int,
            @SerializedName("node_id")
            val nodeId: String,
            @SerializedName("avatar_url")
            val avatarUrl: String,
            @SerializedName("gravatar_id")
            val gravatarId: String,
            val url: String,
            @SerializedName("html_url")
            val htmlUrl: String,
            @SerializedName("followers_url")
            val followersUrl: String,
            @SerializedName("following_url")
            val followingUrl: String,
            @SerializedName("gists_url")
            val gistsUrl: String,
            @SerializedName("starred_url")
            val starredUrl: String,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String,
            @SerializedName("organizations_url")
            val organizationsUrl: String,
            @SerializedName("repos_url")
            val reposUrl: String,
            @SerializedName("events_url")
            val eventsUrl: String,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String,
            val type: String,
            @SerializedName("site_admin")
            val siteAdmin: Boolean
        )

        data class Committer(
            val name: String,
            val email: String,
            val date: String
        )

        data class Tree(
            val url: String,
            val sha: String
        )

        data class Verification(
            val verified: Boolean,
            val reason: String,
            val signature: Any?,
            val payload: Any?
        )
    }

    data class Committer(
        val login: String,
        val id: Int,
        @SerializedName("node_id")
        val nodeId: String,
        @SerializedName("avatar_url")
        val avatarUrl: String,
        @SerializedName("gravatar_id")
        val gravatarId: String,
        val url: String,
        @SerializedName("html_url")
        val htmlUrl: String,
        @SerializedName("followers_url")
        val followersUrl: String,
        @SerializedName("following_url")
        val followingUrl: String,
        @SerializedName("gists_url")
        val gistsUrl: String,
        @SerializedName("starred_url")
        val starredUrl: String,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String,
        @SerializedName("organizations_url")
        val organizationsUrl: String,
        @SerializedName("repos_url")
        val reposUrl: String,
        @SerializedName("events_url")
        val eventsUrl: String,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String,
        val type: String,
        @SerializedName("site_admin")
        val siteAdmin: Boolean
    )

    data class Parent(
        val url: String,
        val sha: String
    )
}