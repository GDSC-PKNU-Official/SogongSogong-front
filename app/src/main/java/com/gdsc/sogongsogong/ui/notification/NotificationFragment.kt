package com.gdsc.sogongsogong.ui.notification

import android.os.Bundle
import android.view.View
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentNotificationBinding
import com.gdsc.sogongsogong.fake.FakeFactory
import com.gdsc.sogongsogong.ui.base.BaseFragment

class NotificationFragment:BaseFragment<FragmentNotificationBinding>(R.layout.fragment_notification){

    private val notificationContentsAdapter by lazy { NotificationContentsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        submitNotification() // FIXME: 필요할 때 submit
    }

    private fun setAdapter() {
        binding.rvNotificationContents.adapter = notificationContentsAdapter
    }

    private fun submitNotification() {
        notificationContentsAdapter.submitList(FakeFactory.getFakeNotifs())
    }
}