package com.gdsc.sogongsogong.ui.board

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.ui.board.PostImageAdapter
import com.gdsc.sogongsogong.network.MasterApplication
import kotlinx.android.synthetic.main.activity_board_write.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class BoardWriteActivity : AppCompatActivity() {

    var imm: InputMethodManager? = null         // 키보드 InputMethodManager 변수 선언
    private lateinit var intentType: String
    private lateinit var intentBoardWriteId: String
    private lateinit var intentBoardWriteTitle: String
    private lateinit var intentBoardWriteBody: String
    var uriPaths: ArrayList<Uri> = ArrayList()
    var filePaths: ArrayList<String> = ArrayList()

    companion object {
        const val REQUEST_READ_EXTERNAL_STORAGE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        // toolbar 설정
        setSupportActionBar(board_write_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)       // 기본 뒤로가기 버튼 설정
        supportActionBar?.setDisplayShowTitleEnabled(false)     // 기본 title 제거

        // 키보드 InputMethodManager 세팅
        imm = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager?

        // 성공적으로 intent 전달값을 받았을 경우
        if (intent.hasExtra("board_write_id")) {
            intentType = intent.getStringExtra("type")!!
            intentBoardWriteId = intent.getStringExtra("board_write_id")!!
            intentBoardWriteTitle = intent.getStringExtra("board_write_title")!!
            intentBoardWriteBody = intent.getStringExtra("board_write_body")!!

            // 게시글 수정일 경우
            // 기존 title, body 불러오기
            if (intentBoardWriteId != "-1") {
                board_write_title.setText(intentBoardWriteTitle).toString()
                board_write_body.setText(intentBoardWriteBody).toString()
            }
        } else {
            // intent 실패할 경우 현재 액티비티 종료
            finish()
        }

        // 글쓰기 완료 버튼을 클릭했을 경우
        board_write_btn.setOnClickListener {
            val title = board_write_title.text.toString()
            val body = board_write_body.text.toString()

            if (title == "") {
                toast("제목을 입력해 주세요")
            } else if (body == "") {
                toast("내용을 입력해 주세요")
            } else {
                setWriteDialog(title, body)
            }
        }
    }

    // 글쓰기 완료 버튼 눌렀을 때 뜨는 dialog 설정 함수
    private fun setWriteDialog(title: String, body: String) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_board, null)
        val dialogText = dialogView.findViewById<TextView>(R.id.dialog_board_text)
        when (intentBoardWriteId) {
            "-1" -> dialogText.text = "게시글을 작성하시겠습니까?"
            else -> dialogText.text = "게시글을 수정하시겠습니까?"
        }

        builder.setPositiveButton("확인") { _, _ ->
                submitWritePost(title, body)
            }
            .setNegativeButton("취소", null)
        builder.setView(dialogView)
        builder.show()
    }

    // 글쓰기 완료 시 이미지 경로와 함께 포스팅하는 함수
    private fun submitWritePost(title: String, body: String) {
        val postTitle = RequestBody.create(MediaType.parse("text/plain"), title)
        val postBody = RequestBody.create(MediaType.parse("text/plain"), body)
        val images = ArrayList<MultipartBody.Part>()

        for (i in 0 until filePaths.size) {
            // File(찾을 파일 주소) -> File 클래스가 알아서 파일을 찾아줌
            val file = File(filePaths[i])
            // image라는 타입 정해주고, 실제 찾은 file을 넣어줌
            val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
            // "images" -> 서버한테 보낼 때 사용할 이름
            val part = MultipartBody.Part.createFormData("images", file.name, fileRequestBody)
            images.add(part)
        }

        // 새 글 작성의 경우 입력받은 title, body, images POST
        if (intentBoardWriteId == "-1") retrofitCreatePost(postTitle, postBody, images)
        // 글 수정의 경우 board_id + 입력받은 title, body, images UPDATE
        else retrofitPutPost(intentBoardWriteId, postTitle, postBody, images)
    }

    // 갤러리에서 이미지 선택하도록 갤러리로 화면 전환하는 함수
    private fun getImages() {
        val intent = Intent()
        // intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)      // 다중 선택 허용
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI    // 결과값 uri로 설정
        intent.type = MediaStore.Images.Media.CONTENT_TYPE            // 구글 포토만 가능하게
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "사진 최대 5장 선택 가능"),
            REQUEST_READ_EXTERNAL_STORAGE
        )
    }

    // 선택한 이미지 파일의 절대 경로 구하는 함수
    private fun getImageFilePath(contentUri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        var columnIndex = 0
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }

        return cursor.getString(columnIndex)
    }

    // 갤러리에서 이미지 선택 후 실행되는 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_READ_EXTERNAL_STORAGE && resultCode == RESULT_OK) {
            if (data?.clipData != null) {
                val count = data.clipData!!.itemCount
                if (count > 5) {
                    toast("사진은 최대 5장 선택 가능합니다")
                    return
                }
                uriPaths.clear()
                filePaths.clear()
                if (count > 1) {    // 이미지 다중 선택
                    for (i in 0 until count) {
                        val uri = data.clipData!!.getItemAt(i).uri
                        uriPaths.add(uri)
                        val filePath = getImageFilePath(uri)
                        filePaths.add(filePath)
                    }
                } else {        // 이미지 단일 선택
                    data.data?.let { uri ->
                        uriPaths.add(uri)
                        val filePath = getImageFilePath(uri)
                        filePaths.add(filePath)
                    }
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            // 사진 선택 취소
        }

        // 이미지 미리보기 화면
        val adapter = PostImageAdapter(uriPaths, LayoutInflater.from(this)) {}
        board_write_img_recyclerview.adapter = adapter
        board_write_img_recyclerview.layoutManager = LinearLayoutManager(this).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }
    }

    // 새 글 작성의 경우
    // 입력받은 title과 body POST하는 함수
    private fun retrofitCreatePost(
        title: RequestBody,
        body: RequestBody,
        images: ArrayList<MultipartBody.Part>
    ) {
        (application as MasterApplication).service.createPost(intentType, title, body, images)
            .enqueue(object : Callback<HashMap<String, Any>> {
                override fun onResponse(
                    call: Call<HashMap<String, Any>>,
                    response: Response<HashMap<String, Any>>
                ) {
                    if (response.isSuccessful && response.body()!!["success"].toString() == "true") {
                        val intent = Intent(this@BoardWriteActivity, BoardActivity::class.java)
                        intent.putExtra("type", intentType)
                        startActivity(intent)
                        finish()
                    } else {
                        toast("게시글을 작성할 수 없습니다")
                        finish()
                    }
                }

                // 응답 실패 시
                override fun onFailure(call: Call<HashMap<String, Any>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }

    // 글 수정의 경우
    // board_id + 입력받은 title, body, images UPDATE
    private fun retrofitPutPost(
        board_id: String,
        title: RequestBody,
        body: RequestBody,
        images: ArrayList<MultipartBody.Part>
    ) {
        (application as MasterApplication).service.putPostDetail(board_id, title, body, images)
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful && response.body()!!["success"] == "true") {
                        val intent = Intent(
                            this@BoardWriteActivity,
                            BoardDetailActivity::class.java
                        )
                        intent.putExtra("board_id", board_id)
                        intent.putExtra("activity_num", "0")
                        startActivity(intent)
                        finish()
                    } else {
                        toast("게시글을 수정할 수 없습니다")
                        finish()
                    }
                }

                // 응답 실패 시
                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.board_write_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // toolbar의 뒤로가기 버튼을 눌렀을 경우
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            // 사진 첨부 버튼을 클릭했을 경우
            R.id.board_write_image -> {
                val permissionChk = ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                if (permissionChk != PackageManager.PERMISSION_GRANTED) {
                    // 권한이 없을 경우
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_READ_EXTERNAL_STORAGE
                    )
                } else {
                    // 권한이 있을 경우
                    getImages()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (intentBoardWriteId == "-1") {
            val intent = Intent(this, BoardActivity::class.java)
            intent.putExtra("type", intentType)
            startActivity(intent)
        } else {
            val intent = Intent(this, BoardDetailActivity::class.java)
            intent.putExtra("board_id", intentBoardWriteId)
            intent.putExtra("activity_num", "0")
            startActivity(intent)
        }
        finish()
    }

    // 이벤트 메서드 생성
    // 액티비티 최상위 layout에 onClick 세팅
    // 해당 layout 내 view 클릭 시 함수 실행
    fun hideKeyboard(v: View) {
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }
}