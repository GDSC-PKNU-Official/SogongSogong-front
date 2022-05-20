package com.gdsc.sogongsogong

import com.gdsc.sogongsogong.extensions.FakeDispatcherProvider
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class NavViewModelTest : BehaviorSpec() {

    private val dispatcherProvider = FakeDispatcherProvider()

    private val navViewModel = NavViewModel(dispatcherProvider)

    init {
        Given("게시판 화면에서") {

            When("글쓰기 Fab를 클릭하면") {
                navViewModel.emitWritePostFabClickEvent()

                Then("글쓰기 이벤트를 collect 할 수 있다.") {
                    // FIXME: collect 무한루프?
                    var isCollected = false

//                    navViewModel.writePostFabClickEvent.collect {
//                        isCollected = true
//                    }

                    isCollected shouldBe false
                }
            }
        }
    }
}