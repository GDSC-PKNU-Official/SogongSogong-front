package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.extensions.FakeDispatcherProvider
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class HomeViewModelTest : BehaviorSpec() {

    private val postDataSource = mockk<PostDataSource>(relaxUnitFun = true)

    private val hotPostDataSource = mockk<HotPostDataSource>(relaxUnitFun = true)

    private val dispatcherProvider = FakeDispatcherProvider()

    private val homeViewModel = HomeViewModel(dispatcherProvider, postDataSource, hotPostDataSource)

    init {
        Given("홈 화면에서") {

            When("화면에 진입할 때") {
                Then("게시글 목록을 가져온다.") {
                    coVerify { postDataSource.fetchInitAllPost() }
                }

                Then("핫 게시글을 가져온다.") {
                    coVerify { hotPostDataSource.fetchHotPost() }
                }
            }
        }
    }
}
