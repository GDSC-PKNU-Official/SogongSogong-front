<div align="center">
  
[![Contributors][contributors-shield]][contributors-url] [![Forks][forks-shield]][forks-url] [![Stargazers][stars-shield]][stars-url] [![Issues][issues-shield]][issues-url]
  

<br>
<a href="https://github.com/othneildrew/Best-README-Template">
<img src="https://i.imgur.com/NbY0NQh.png" alt="Logo" width="30%">
</a>

<strong>Sogong Sogong (소공소공)</strong><br>
Anonymous Communication Platform for Small Business
to solve the UN's SDGS No.8.<br><br>
<a href="https://treejin99.notion.site/_-b293dc72cc5b472e90edf3fc707f24dc"><strong>Explore the notion (Only In Korean)</strong></a><br>
<a href="">View Demo</a> · <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-front/issues">Report Bug & Request Feature</a> · <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-back/blob/main/README.md">Back-End Readme</a>

</div>

<!-- TABLE OF CONTENTS -->
<br>
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#Introduction">Introduction</a>
      <ul>
        <li><a href="#Summary">Summary</a></li>
          <li><a href="#Flow-Chart">Flow Chart</a></li>
          <li><a href="#Tech">Tech Stack(Front-End)</a></li>    
      </ul>
    </li>
    <li>
      <a href="#Getting-Started">Getting Started</a>
      <ul>
        <li><a href="#Prerequisites">Prerequisites</a></li>
        <li><a href="#Installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#Usage">Usage</a></li>
    <li><a href="#Structure">Structure</li>
    <li><a href="#Contributing">Contributing</a></li>
    <li><a href="#Contact">Contact</a></li>
  </ol>
</details>

***

## Introduction
### Summary

*Sogong Sogong* is an Android application which communicate anonymously.
- <b>Meaning of *Sogong Sogong*</b> : *Sogong Sogong* is a combination of Korean words which means whisper(pronounced as SOGON) and abbreviation of small business owners (pronounced as SOsang-GONGin).
- <b>Target</b> : *Sogong Sogong* is for ==small business owner and prospective entrepreneurs.== So they can talk about many things that you haven't told anyone and anywhere. The things can be stories about sales concern, rude customers and even franchise's abuse of power. Also the application supports used market that allow store transactions.
- <b>Effection</b> : Because *Sogong Sogong* guarantees complete anonymity, it refreshes an atmosphere of small business, full of absurdity and COVID 19. And through used market, it supports easy-trade on online unlike people did legwork in the past.

### Flow Chart
[See Flow Chart at the following Link!](https://www.figma.com/file/SvZevMfaXG9AiroGFX3JzK/%EC%86%8C%EA%B3%B5%EC%86%8C%EA%B3%B5-%ED%94%8C%EB%A1%9C%EC%9A%B0%EC%B0%A8%ED%8A%B8?node-id=0%3A1 "title")
</br>

<h3 id="Tech"> Tech Stack(Front-End) </h3>

<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"><img src="https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white"><img src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white"><img src="https://img.shields.io/badge/firebase-%23039BE5.svg?style=for-the-badge&logo=firebase">
<!-- https://github.com/Ileriayo/markdown-badges 에서 찾기~-->


***

## Getting-Started


### Prerequisites
#### To run ***Sogong Sogong*** App
- Android 6.0(Marshmallow) at least
- Not support iOS.

#### To edit file
- Latest version of Android Studio
- Kotlin 1.6.10
<br>

### Installation
#### Follow the below instructions!
 1. Download the app.
 2. Participate in small and medium-sized communities through membership registration
 3. You can communicate with more diverse operators by authenticating your business number.
 4. Share your questions, hardships, and good tips.
 5. You can find out what you're interested in through hashtag.
 
 Let's be together at Sogong Sogong, a communication channel only for small business owners!

***

## Usage
#### This section explains the guidelines for how to use *Sogong Sogong*
###### * The pictures  down below may differ from the actual design.


1. In *Sogong Sogong*, you need business license number to sign in.<br>
If you don't have it, you can skip this process.<br>
However, service doesn't support some functions compared to members who have certified.<br>
Don't worry! You can regist it later.

2. At the main page, there are several information, posts for you!<br>
And bottom navigation means main page, board list, notification and settings in order.<br>
<img src="https://i.imgur.com/77eRtx5.png" width="30%">


3. If you want to enter boards to see posts, you can enter to them by touching at second bottom navigation.<br>
And then, see the details of post by just clicking the part.<br>


4. On the detail of post page, you can store it by clicking icons in your 'Liked Post' and 'Clippings'.<br>
In addition, you can write comments anonymously.<br>

5. When you want to post something, please click the floating icon at the bottom named 'Post'.<br>
On the writing page, you need to choose post-hashtags and write contents.<br>
Post-hashtags can be selected up to two from two categories.<br>
And posts are anonymous like comments.

6. Please click the icon 'Sogong Sogong Board' at the second page, if you want to get official information.

7. If you want to find posts, you can find them by hashtags in two ways.<br>
The first is through the search bar at the main page, second one is through 'Hastag Board' at the board list.

8. To check new notification, you can enter through third bottom naviagtion.

9. You can change application settings in 'My Page' at the bottom navigation on the far right.
 
 


***

## Structure

### Front-End
#### Directory structure
Directory sturcture could be changed.
<details>
<summary>OPEN</summary>
    
├── README.md  
├── app/  
│   ├── proguard-rules.pro  
│   ├── google-services.json   
│   │── .gitignore   
│   ├── build.gradle   
│   └── src/  
│            ├── androidTest/java/com/gdsc/sogongsogong/  
│            ├── test/java/com/gdsc/sogongsogong/  
│            └── main/  
│                     ├── AndroidManifest.xml  
│                     ├── res/  
│                     └── java/com/gdsc/sogongsogong  
│                             ├── App.kt  
│                             ├── MainActivity.kt  
│                             ├── NavViewModel.kt  
│                             ├── SplashActivity.kt  
│                             └── data/  
│                                     └── entity/  
│                                             ├── BoardReport.kt  
│                                             ├── Hashtag.kt   
│                                             ├── Noti.kt   
│                                             └── Post.kt  
│                                     └── remote/  
│                                             ├── Api.kt  
│                                             ├── ApiService.kt  
│                                             └── datasource/  
│                                                     ├── PostRemoteDataSource.kt  
│                                                     └── PostRemoteDataSourceImpl.kt  
│                             └── util/  
│                                     └── FlowExtension.kt  
│                             └── di/  
│                                     └── dispatcher/  
│                                             ├── DispatcherProvider.kt  
│                                             └── DispatcherProviderImpl.kt   
│                                     └── module/  
│                                             ├── DataSourceModule.kt  
│                                             └── DispatcherModule.kt  
│                             └── fake/  
│                                     ├── FakeFactory.kt    
│                                     └── SimpleApi.kt  
│                             └── ui  
│                                     └── base  
│                                             ├── BaseActivity.kt  
│                                             ├── BaseFragment.kt  
│                                             ├── BaseViewHolder.kt  
│                                             └── BaseViewModel.kt  
│                                     └── board  
│                                             ├── BoardActivity.kt  
│                                             ├── BoardAdapter.kt  
│                                             └── BoardViewModel.kt  
│                                     └── boardlist  
│                                             └── BoardListFragment.kt  
│                                     └── home  
│                                             ├── HomeBoardAdapter.kt  
│                                             ├── HomeFragment.kt  
│                                             └── InformationAdapter.kt  
│                                     └── join  
│                                             └── JoinActivity.kt  
│                                     └── notification  
│                                             └── NotificationFragment.kt  
│                                     └── post  
│                                             ├── PostImageAdapter.kt  
│                                             └── PostImagePagerAdapter.kt  
│                                     └── search  
│                                             └── BoardSearchActivity.kt  
│                                     └── setting  
│                                             ├── SettingsContentsAdapter.kt  
│                                             ├── SettingFragment.kt  
│                                             └── SettingViewModel.kt  
│                                     └── writepost  
│                                              └── WritePostActivity.kt  
├── .gitignore  
├── build.gradle  
├── gradle.properties  
├── gradlew  
├── gradlew.bat  
└── settings.gradle  
</details>

#### Screen structure
- Screen can be divided in **Main screen** and **Bottom navigation**.
<p align="center">
  <img src="https://i.imgur.com/zHKlUfE.jpg" width="80%">
</p>


### Back-End
- Check Back-End structure at <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-back/blob/main/README.md">this link</a>.

***
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. <br>
Any contributions you make are **greatly appreciated**.

1. <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-front/issues">Request Feature yourself</a>
2. Fork the Project
3. Create your Feature Branch (`git checkout -b feature/#{IssueNumber}`) 
    - `ex) feature/#1`
5. Commit your Changes (`git commit -m 'Issue #{IssueNumber} feat: Add some AmazingFeature'`)
6. Push to the Branch (`git push origin feature/#{IssueNumber}`)
7. Open a Pull Request

***

## Contact

<!-- 출시하면 공용 이메일 적을거임 -->


<!------------------------------------------------------------------------------------->
<!-- 밑에는 예시입니다.--------------------------------------------------------------------->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->


---






<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/GDSC-PKNU-21-22/SogongSogong-front.svg?style=for-the-badge
[contributors-url]: https://github.com//GDSC-PKNU-21-22/SogongSogong-front/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/GDSC-PKNU-21-22/SogongSogong-front.svg?style=for-the-badge
[forks-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-front/network/members

[stars-shield]: https://img.shields.io/github/stars/GDSC-PKNU-21-22/SogongSogong-front.svg?style=for-the-badge
[stars-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-front/stargazers

[issues-shield]: https://img.shields.io/github/issues/GDSC-PKNU-21-22/SogongSogong-front.svg?style=for-the-badge
[issues-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-front/issues
