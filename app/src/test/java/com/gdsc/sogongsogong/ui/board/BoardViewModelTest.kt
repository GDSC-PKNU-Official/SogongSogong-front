package com.gdsc.sogongsogong.ui.board

import com.gdsc.sogongsogong.extensions.FakeDispatcherProvider
import com.gdsc.sogongsogong.data.remote.post.PostDataSource
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.mockk
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class BoardViewModelTest : BehaviorSpec() {

    private val postDataSource = mockk<PostDataSource>(relaxUnitFun = true)

    private val dispatcherProvider = FakeDispatcherProvider()

    private val boardViewModel = BoardViewModel(dispatcherProvider, postDataSource)

    init {
        Given("게시판 화면에서") {

            When("화면에 진입할 때") {
                launch { boardViewModel.fetchAllPost(0) }

                Then("게시글의 목록을 가져온다.") {
                    // FIXME: 검증 실패
//                    coVerify { postRemoteDataSource.fetchAllPost(0) }
                }
            }


            When("게시글을 클릭할 때") {
                launch { boardViewModel.emitRecyclerViewClickEvent() }

                Then("게시글 클릭 이벤트가 발행된다.") {
                    boardViewModel.recyclerViewClickEvent.first() shouldBe Unit
                }
            }
        }
    }
}
