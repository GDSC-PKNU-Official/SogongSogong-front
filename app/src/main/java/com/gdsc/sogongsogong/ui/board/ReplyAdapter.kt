package com.gdsc.sogongsogong.ui.board

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.sogongsogong.ui.board.BoardDetailActivity
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.dataclass.Reply
import com.gdsc.sogongsogong.dataclass.ReplyChange
import com.gdsc.sogongsogong.network.MasterApplication
import kotlinx.android.synthetic.main.activity_board_detail.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReplyAdapter(
    private val replyList: ArrayList<Reply>,
    private val inflater: LayoutInflater,
    private val context: Context,
    private val menuInflater: MenuInflater,
    private val masterRole: Boolean,
    private val application: Application
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ParentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val replyBody: TextView = itemView.findViewById(R.id.parent_reply_item_body)
        private val replyDate: TextView = itemView.findViewById(R.id.parent_reply_item_date)
        private val replyLikeCnt: TextView = itemView.findViewById(R.id.parent_reply_item_like_cnt)
        private val replyCommentBtn: ImageView = itemView.findViewById(R.id.parent_reply_item_comment_btn)
        private val replyLikeBtn: ImageView = itemView.findViewById(R.id.parent_reply_item_like_btn)
        private var replyVer: Boolean = false
        private var popUserCheck: Boolean = false        // 내 댓글일 경우 true

        fun bind(reply: Reply, position: Int) {
            replyBody.text = reply.body
            replyDate.text = reply.regdate.substring(5, 16)
            replyLikeCnt.text = reply.goodCount.toString()

            if (reply.goodCheck == "Y") {
                replyLikeBtn.setImageResource(R.drawable.detail_like_selected)
                replyVer = true
            }
            if (reply.userCheck == "Y") popUserCheck = true
            if (masterRole) {
                replyCommentBtn.visibility = View.GONE
                replyLikeBtn.visibility = View.GONE
            }

            // 대댓글 버튼 눌렀을 경우
            replyCommentBtn.setOnClickListener {
                setReplyDialog(reply, true)
            }

            // 댓글 좋아요 버튼 눌렀을 경우
            replyLikeBtn.setOnClickListener {
                retrofitGoodReply(reply.reply_id.toString(), reply.goodCount, replyLikeCnt, replyLikeBtn, replyVer)
            }

        }
    }

    inner class ChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val replyBody: TextView = itemView.findViewById(R.id.child_reply_item_body)
        private val replyDate: TextView = itemView.findViewById(R.id.child_reply_item_date)
        private val replyLikeCnt: TextView = itemView.findViewById(R.id.child_reply_item_like_cnt)
        private val replyLikeBtn: ImageView = itemView.findViewById(R.id.child_reply_item_like_btn)
        private var replyVer: Boolean = false
        private var popUserCheck: Boolean = true

        fun bind(reply: Reply, position: Int) {
            replyBody.text = reply.body
            replyDate.text = reply.regdate.substring(5, 16)
            replyLikeCnt.text = reply.goodCount.toString()

            if (reply.goodCheck == "Y") {
                replyLikeBtn.setImageResource(R.drawable.detail_like_selected)
                replyVer = true
            }
            if (reply.userCheck == "Y") popUserCheck = true
            if (masterRole) replyLikeBtn.visibility = View.GONE

            // 댓글 좋아요 버튼 눌렀을 경우
            replyLikeBtn.setOnClickListener {
                retrofitGoodReply(reply.reply_id.toString(), reply.goodCount, replyLikeCnt, replyLikeBtn, replyVer)
            }

        }
    }

    // 댓글 좋아요하는 함수
    fun retrofitGoodReply(reply_id: String, likeCnt: Int, replyLikeCnt: TextView, replyLikeBtn: ImageView, replyVer: Boolean) {
        (application as MasterApplication).service.goodReply(reply_id)
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful && response.body()!!["success"] == "true") {
                        val stat = response.body()!!["stat"]
                        // 안 누름 -> 누름
                        if (stat == "INSERT") {
                            if (replyVer) replyLikeCnt.text = (likeCnt).toString()
                            else replyLikeCnt.text = (likeCnt+1).toString()
                            replyLikeBtn.setImageResource(R.drawable.detail_like_selected)
                        } else if (stat == "DELETE") {
                            // 누름 -> 안 누름
                            if (replyVer) replyLikeCnt.text = (likeCnt-1).toString()
                            else replyLikeCnt.text = likeCnt.toString()
                            replyLikeBtn.setImageResource(R.drawable.detail_like)
                        }
                    } else {
                        context.toast("댓글 좋아요를 할 수 없습니다")
                        (context as Activity).finish()
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    (context as Activity).finish()
                }
            })
    }

    fun addReplyItem(reply: Reply) {
        replyList.add(reply)
        replyList.sortBy { it.parent_id }
        notifyDataSetChanged()
    }

    fun removeReplyItem(position: Int): Int {
        var cnt = 1
        if (replyList[position].level == 0) {
            replyList.removeAt(position)
            while (replyList.isNotEmpty() && position < replyList.size)
                if (replyList[position].level != 0) {
                    replyList.removeAt(position)
                    cnt += 1
                }
                else
                    break
        } else {
            replyList.removeAt(position)
        }
        notifyDataSetChanged()
        return cnt
    }

    //댓글 삭제하기 버튼 클릭 시 뜨는 dialog 설정 함수
    fun setDeleteReplyDialog(board_id: String, reply_id: String, position: Int) {
        val builder = AlertDialog.Builder(context)
        val dialogView = inflater.inflate(R.layout.dialog_board, null)
        val dialogText = dialogView.findViewById<TextView>(R.id.dialog_board_text)
        dialogText.text = "해당 댓글을 삭제하시겠습니까?"

        builder.setPositiveButton("확인") { dialog, it ->
            (application as MasterApplication).service.deleteReply(board_id, reply_id)
                .enqueue(object : Callback<HashMap<String, String>> {
                    override fun onResponse(
                        call: Call<HashMap<String, String>>,
                        response: Response<HashMap<String, String>>
                    ) {
                        if (response.isSuccessful && response.body()!!["success"] == "true") {
                            val deleteCnt = removeReplyItem(position)
                            (context as BoardDetailActivity).board_detail_scroll.smoothScrollTo(0, 0)
                            (context as BoardDetailActivity).deleteReplyCnt(deleteCnt)
                        } else {
                            context.toast("댓글을 삭제할 수 없습니다")
                            (context as Activity).finish()
                        }
                    }

                    override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                        (context as Activity).finish()
                    }
                })
        }
            .setNegativeButton("취소", null)
        builder.setView(dialogView)
        builder.show()
    }

    // 대댓글 & 댓글 신고하기 버튼 클릭 시 뜨는 dialog 설정 함수
    // ver == true 대댓글 dialog
    // ver == false 댓글 신고하기 dialog
    fun setReplyDialog(reply: Reply, ver: Boolean) {
        val builder = AlertDialog.Builder(context)
        val dialogView = inflater.inflate(R.layout.dialog_reply, null)
        val dialogEditText = dialogView.findViewById<EditText>(R.id.dialog_reply_edittext)
        dialogEditText.hint = if (ver) "대댓글을 입력해 주세요" else "신고 사유를 입력해 주세요"

        builder.setView(dialogView)
            .setPositiveButton("확인", null)
            .setNegativeButton("취소", null)

        val dialog = builder.create()
        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val body = dialogEditText.text.toString()
                if (body == "") {
                    if (ver) context.toast("대댓글을 입력해 주세요")
                    else context.toast("신고 사유를 입력해 주세요")
                } else {
                    if (ver) retrofitCreateReplyReply(reply.board_id.toString(), reply.reply_id.toString(), body)
                    dialog.dismiss()
                }
            }
        }
        dialog.show()
    }

    // 대댓글 작성 함수
    private fun retrofitCreateReplyReply(board_id: String, reply_id: String, body: String) {
        (application as MasterApplication).service.createReplyReply(board_id, reply_id, body)
            .enqueue(object : Callback<ReplyChange> {
                override fun onResponse(
                    call: Call<ReplyChange>,
                    response: Response<ReplyChange>
                ) {
                    if (response.isSuccessful && response.body()!!.success == "true") {
                        val reply = response.body()!!.data
                        addReplyItem(reply)
                        (context as BoardDetailActivity).board_detail_scroll.smoothScrollTo(0, 0)
                        (context as BoardDetailActivity).addReplyCnt()
                    } else {
                        context.toast("대댓글을 작성할 수 없습니다")
                        (context as Activity).finish()
                    }
                }

                override fun onFailure(call: Call<ReplyChange>, t: Throwable) {
                    (context as Activity).finish()
                }
            })
    }


    override fun getItemViewType(position: Int): Int {
        return replyList[position].level
    }

    override fun getItemCount(): Int {
        return replyList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            0 -> {
                view = inflater.inflate(R.layout.reply_parent_item, parent, false)
                ParentViewHolder(view)
            }
            else -> {
                view = inflater.inflate(R.layout.reply_child_item, parent, false)
                ChildViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (replyList[position].level) {
            0 -> {
                (holder as ParentViewHolder).bind(replyList[position], position)
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as ChildViewHolder).bind(replyList[position], position)
                holder.setIsRecyclable(false)
            }
        }
    }
}