package com.gdsc.sogongsogong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_information.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class InformationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 택스트 뷰 생성
        textView.text = ""

        // 버튼을 누르면 쓰레드 동작
        button.setOnClickListener {

            // 쓰레드 생성
            val thread = NetworkThread()
            thread.start()
            thread.join()
        }
    }

    // 네트워크를 이용할 때는 쓰레드를 사용해서 접근해야 함
    inner class NetworkThread: Thread(){
        override fun run() {

            // 키 값
            val key = "키값"

            // 현재 페이지번호
            val pageNo = "&pageNo=1"

            // 한 페이지 결과 수
            val numOfRows ="&numOfRows=10"

            // AND(안드로이드)
            val MobileOS = "&MobileOS=AND"

            // 서비스명 = 어플명
            val MobileApp = "&MobileApp=AppTest"

            // API 정보를 가지고 있는 주소
            val site = "https://www.sbiz.or.kr/sup/policy/json/policyfound.do"+"&_type=json"

            val url = URL(site)
            val conn = url.openConnection()
            val input = conn.getInputStream()
            val isr = InputStreamReader(input)
            // br: 라인 단위로 데이터를 읽어오기 위해서 만듦
            val br = BufferedReader(isr)

            // Json 문서는 일단 문자열로 데이터를 모두 읽어온 후, Json에 관련된 객체를 만들어서 데이터를 가져옴
            var str: String? = null
            val buf = StringBuffer()

            do{
                str = br.readLine()

                if(str!=null){
                    buf.append(str)
                }
            }while (str!=null)

            // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
            val root = JSONObject(buf.toString())
            val response = root.getJSONObject("item").getJSONObject("items")
            val item = response.getJSONArray("items") // 객체 안에 있는 item이라는 이름의 리스트를 가져옴

            // 화면에 출력
            runOnUiThread {

                // 페이지 수만큼 반복하여 데이터를 불러온다.
                for(i in 0 until item.length()){

                    // 쪽수 별로 데이터를 읽는다.
                    val jObject = item.getJSONObject(i)

                    
                    textView.append("1. title: ${ JSON_Parse(jObject,"title")}\n")
                    textView.append("2. url: ${JSON_Parse(jObject,"url")}\n")
                    textView.append("3. year: ${JSON_Parse(jObject,"year")}\n")

                }
            }
        }

        // 함수를 통해 데이터를 불러온다.
        fun JSON_Parse(obj:JSONObject, data : String): String {

            // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
            return try {

                obj.getString(data)

            } catch (e: Exception) {
                "없습니다."
            }
        }
    }

}
