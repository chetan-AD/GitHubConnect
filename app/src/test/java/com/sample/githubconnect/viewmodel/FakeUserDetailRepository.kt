package com.sample.githubconnect.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.sample.githubconnect.models.entities.User
import com.sample.githubconnect.models.repositories.IUserDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeUserDetailRepository : IUserDetailRepository {

    override suspend fun getUserDetails(userName: String): LiveData<User> {
        var user = MutableLiveData<User>()
        user.value = User(
            1,
            "user1",
            "https://ex.com/1",
            "https://ex.com/1",
            "https://ex.com/1111",
            "https://ex.com/1",
            "",
            ""
        )
        return user;
    }

    override suspend fun getFollowersList(userName: String): Flow<PagingData<User>> {
        val followerList = mutableListOf<User>()
        followerList.add(
            User(
                1,
                "user1",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1",
                "",
                ""
            )
        )
        followerList.add(
            User(
                2,
                "user2",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1111",
                "https://ex.com/1",
                "",
                ""
            )
        )
        followerList.add(
            User(
                3,
                "user11",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1111",
                "https://ex.com/1",
                "",
                ""
            )
        )
        return flowOf(PagingData.from(followerList))
    }

    override suspend fun getFollowingList(userName: String): Flow<PagingData<User>> {
        var followingList = mutableListOf<User>()
        followingList.add(
            User(
                6,
                "user26",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1111",
                "https://ex.com/1",
                "",
                ""
            )
        )
        followingList.add(
            User(
                2,
                "userTest",
                "https://ex.com/1",
                "https://ex.com/1",
                "https://ex.com/1111",
                "https://ex.com/1",
                "",
                ""
            )
        )
        return flowOf(PagingData.from(followingList))
    }
}