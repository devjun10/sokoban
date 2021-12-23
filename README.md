# 소코반(Sokoban)

시연 영상은 [해당 링크](https://github.com/devjun10/CodeSquad_Cocoa/issues/3) 를 [클릭](https://github.com/devjun10/CodeSquad_Cocoa/issues/4) 하시면 됩니다.
<br/><br/>

<details>
<summary>📚	 문제 설명 및 요구사항</summary>
<div markdown="1">
</div>
<br/><br/>

## ✍🏻 공통 요구사항

- 단계별로 (할 수 있는 단계까지) [소코반 게임](https://www.cbc.ca/kids/games/play/sokoban) 을 구현한다.
- 단계별로 지정된 코딩 요구사항을 적용한다.
- `단계별로 구현한 코드 동작과 실행 결과에 대해` 마크다운 문법으로 README.md 파일에 상세하게 정리한다.
- 특별히 명시되지 않은 부분은 `자유롭게 구현`한다.

<br/><br/>

<details>
<summary>📔	 Step 01.</summary>
<div markdown="1">

## 1단계: 지도 데이터 읽어서 2차원 배열에 저장하고 화면에 출력하기

<br/><br/>

## 🖥 1단계 코딩 요구사항

- 컴파일 또는 실행이 가능해야 한다. (컴파일이나 실행되지 않을 경우 감점 대상)
- 자기만의 기준으로 최대한 간결하게 코드를 작성한다.
- Readme.md에 풀이 과정 및 코드 설명, 실행 결과를 기술하고 코드와 같이 gist에 포함해야 한다.
- 제출시 gist URL과 revision 번호를 함께 제출한다.

<br/><br/><br/>


## 🖥 출력

아래와 같은 형태로 각 스테이지 정보를 출력한다.

- 플레이어 위치는 배열 [0][0]을 기준으로 처리한다.
- 스테이지 구분값은 출력하지 않는다
  <br/>

```text
model.Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어 위치 (2, 4)

model.Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

가로크기: 10
세로크기: 7
구멍의 수: 4
공의 수: 4
플레이어 위치 (5, 6)
```

<br/><br/><br/>

</div>
<br/><br/>
</details>


<details>
<summary>	📕	 Step 02.</summary>
<div markdown="2-2">



<br/><br/><br/>

## ⌨️ 입력명령

````text
- w: 위쪽
- a: 왼쪽
- s: 아래쪽
- d: 오른쪽
- q: 프로그램 종료
````

<br/><br/><br/>

## 🖥 출력


<details>
<summary>📗	 Step 03.</summary>
<div markdown="3">
<br/>

## 3단계 : 소코반 완성하기

- 정상적인 소코반 게임을 완성하며 [해당 링크](https://www.cbc.ca/kids/games/play/sokoban)를 참조한다.

<br/><br/>

## ✍🏻 기능 요구사항

- 난이도를 고려하여 스테이지 1부터 5까지 플레이 가능한 map.txt 파일을 스스로 작성한다.
- 지도 파일 map.txt를 문자열로 읽어서 처리하도록 개선한다.
- 처음 시작시 model.Stage 1의 지도와 프롬프트가 표시된다.
- r 명령 입력시 스테이지를 초기화 한다.
- 모든 o를 O자리에 이동시키면 클리어 화면을 표시하고 다음 스테이지로 표시한다.
- 주어진 모든 스테이지를 클리어시 축하메시지를 출력하고 게임을 종료한다.

<br/>

- ### 참고
    - 플레이어는 o를 밀어서 이동할 수 있지만 당길 수는 없다.
    - o를 O 지점에 밀어 넣으면 0으로 변경된다.
    - 플레이어는 O를 통과할 수 있다.
    - 플레이어는 #을 통과할 수 없다.
    - 0 상태의 o를 밀어내면 다시 o와 O로 분리된다.
    - 플레이어가 움직일 때마다 턴수를 카운트한다.
    - 상자가 두 개 연속으로 붙어있는 경우 밀 수 없다.
    - 기타 필요한 로직은은 실제 게임을 참고해서 완성한다.

<br/><br/><br/>

## 🖥 3단계 코딩 요구사항

- 가능한 한 커밋을 자주 하고 구현의 의미가 명확하게 전달되도록 커밋 메시지를 작성한다.
- 함수나 메소드는 한 번에 한 가지 일을 하고 가능하면 20줄이 넘지 않도록 구현한다.
- 함수나 메소드의 들여쓰기를 가능하면 적게(3단계까지만) 할 수 있도록 노력한다.

<br/>

````javascript
function main() {
    for () { // 들여쓰기 1단계
        if () { // 들여쓰기 2단계
            return; // 들여쓰기 3단계
        }
    }
}
````

<br/><br/><br/>

## 🖥 실행 예시

```text
소코반의 세계에 오신 것을 환영합니다!
^오^

model.Stage 1

#####
#OoP#
#####

SOKOBAN> A

#####
#0P #
#####

빠밤! model.Stage 1 클리어!
턴수: 1

model.Stage 2
...

model.Stage 5
...

빠밤! model.Stage 5 클리어!
턴수: 5

전체 게임을 클리어하셨습니다!
축하드립니다! 
```

<br/><br/>

</div>
<br/><br/>
</details>

<details>
<summary>📚	Step 04.</summary>
<div markdown="4">

## 4단계 : 추가기능 구현

- 다양한 추가기능을 구현해 본다.
- 전부다 구현하지 않아도 무방하다.

<br/>

## ✍🏻 기능 요구사항

<br/>

### 저장하기 / 불러오기

- 1 - 5: 세이브 슬롯 1 - 5 선택
- S 키로 현재 진행상황을 저장한다.
- L 키로 세이브 슬롯에서 진행상황을 불러온다.

```text
S>  2S
2번 세이브 슬로 상태
2번 세이브에 진행상황을 저장합니다.
S>  3L
3번 세이브에서 진행상황을 불러옵니다.
```

<br/><br/><br/>

### 지도 데이터 변환하기 프로그램

- 지도 데이터 map.txt 를 읽어서 일반 텍스트 에디터로 읽을 수 없는 map_enc.txt로 변환하는 프로그램을 추가로 작성한다.
- 3 단계에서 구현한 게임이 map.txt 가 아닌 map_enc.txt 를 불러와서 실행할 수 있도록 수정한다.

<br/><br/><br/>

### 되돌리기 기능 및 되돌리기 취소 기능 구현

- u키를 누르면 한 턴 되돌리기, U키를 누르면 되돌리기 취소하기를 구현한다.

</div>
<br/><br/>
</details> 



<details>
<summary>📌 코딩 컨벤션</summary>
<div markdown="2">
<br/>

## 📌 코딩 컨벤션

- `기능 단위로 커밋`하며, 구현의 의미가 명확하게 전달되도록 커밋 메시지를 작성한다.<br/>
- 커밋은 -m 사용을 `지양`하며, 구체적 내용을 기록한다.

- `readme를 상세히 작성`한다.<br/>
    - `전체 프로젝트의 구조를 설명`한다.
    - 각 `패키지`와 `클래스, 메서드의 기능을 상세히 설명`한다.
    - (가능하다면) 패키지/클래스의 `역할과 책임을 명확하게 분리`한다.
    - 변수명은 문맥에 맞게 가장 보편적으로, 메서드명은 `무엇을 하는지를 명확히` 나타낸다.
    - 필요에 따라 그림과 PPT, 학습내용을 첨부해 `알기 쉽게 작성`한다.
    - 테스트 케이스를 기록하며 석연치 않은 부분을 매번 체크한다.

- 함수나 메소드의 들여쓰기를 가능하면 적게하도록 노력한다.<br/>
    - 한 메서드에는 가급적 `두 단계 이내`의 들여쓰기를 한다.
- 함수나 메소드는 한 번에 한 가지 일을 하고 가능하면 20줄이 넘지 않도록 구현한다. <br/>
- 무분별한 static의 사용을 최대한 `지양`한다.
- else 예약어를 `지양`한다.
- 함수나 메소드의 들여쓰기를 가능하면 적게(3단계까지만) 할 수 있도록 노력한다.

```javascript
 function main() {
    for (i = 0; i < 10; i++) { // 들여쓰기 1단계
        if (i == 2) { // 들여쓰기 2단계
            return; // 들여쓰기 3단계
        }
    }
}
```

<br/>

</div>
<br/><br/>
</details>


<details><summary>📂 구조</summary>
<div markdown="1">

## 📂 구조

```text
|-- java
|   -- com
|       -- junhopark
|           -- javaracingcar
|               |-- model
|               |   -- Car.java
|               |-- util
|               |-- util
|               |   |-- GameUtil.java
|               |   |-- GameValidator.java
|               |-- Main.java
|
|
|
|
```

<br/><br/>

## 💫 실행 방법

```shell

```

<br/><br/>


</div>
<br/><br/>
</details>





## 목차

| No  |    Content                                                                              |  이동  |
|:---:|:----------------------------------------------------------------------------------------|:-----:|
|  1  |&nbsp;프로젝트 개요                                                                          |[링크](#프로젝트-개요)|
|  2  |&nbsp;풀이 과정 및 코드 설명. 실행 결 기술 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|[링크](#풀이-과정-및-코드-설명)|
|     |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `Step 01.`  1단계 풀이 과정 / 코드                                         |       |
|     |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `Step 02.`  2단계 풀이 과정 / 코드                                         |       |
|     |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `Step 03.`  3단계 풀이 과정 / 코드                                         |       |
|     |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `Step 04.`  4단계 풀이 과정 / 코드                                         |       |
|  3  |&nbsp;테스트 케이스                                                                          |[링크](#테스트-케이스)|
|  4  |&nbsp;기타                                                                                 |[링크](#기타)|

<br/><br/><br/>




# 프로젝트 개요

턴제 RPG이며 절차 지향적 게임이기 때문에 순서와 흐름이 필요할 것이며 조건 분기가 많이 등장하리라 생각됐습니다. 따라서 `각 객체의 역할은 명확하게 분배`하고 `분기문을 지양`
하되 `크게 구애받지 말자`고 생각했습니다. 큰 흐름은 아래와 같은 순서로 진행됩니다. 클래스들의 역할은 나누고 Main 클래스 위에서 이를 절차적으로 이어주었습니다.

<br/>

0. 프로그램이 실행되면 Disk 영역의 Init과 Slot으로 부터 애플리케이션에서 사용될 데이터가 초기화 된다. 
1. InputView를 통해 사용자의 입력을 받는다.
2. GameManager는 사용자의 입력이 적절한 명령인지 판단하고 이를 model.GameMachine 내부로 전달한다.
3. GameMachine은 사용자의 명령을 받아 내부로직을 통해 이를 처리한다. 
4. 처리된 작업은 view.GameResult 클래스를 통해 바깥으로 반환된다.
5. 반환된 view.GameResult 클래스는 OutputView에 전달되어 사용자의 화면에 출력된다.

<br/>

![전체 플로우](https://user-images.githubusercontent.com/92818747/145159169-c4bba237-4730-4ae9-96de-22cdd054b24e.png)


<br/><br/><br/><br/><br/>




|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:---------------:|:------|:------------------------------------------|
|1|class|&nbsp;GameManager       |&nbsp; 게임의 진행을 돕는 클래스로 게임의 부가적 정보 전달, 게임 외적인 일을 담당한다 | 
|2|class|&nbsp;GameMachine       |&nbsp; 게임 데이터를 관리하고 내부 로직을 이어주는 역할을 담당하는 클래스     |
|3|class|&nbsp;Disk              |&nbsp; 게임의 데이터를 관리하는 클래스. 클래스들의 데이터와 초기화, 생성을 관리한다 |
|4|class|&nbsp;Init              |&nbsp; Stage에 대한 정보(Information, model.Board) 초기화를 담당하는 클래스 |
|5|class|&nbsp;Slot              |&nbsp; 사용자의 게임 데이터를 저장하고 있는 클래스                      |
|6|class|&nbsp;Stages            |&nbsp; 각 Stage에 대한 정보를 담고 있는 클래스                       |
|7|class|&nbsp;Board             |&nbsp; Stage의 심볼을 나타내는 클래스                              |
|8|class|&nbsp;StageInformation  |&nbsp; 해당 Board의 크기, 번호 등 정보를 저장하고 있는 클래스            |
|9|class|&nbsp;Answer            |&nbsp; 정답과 원본 배열의 값을 저장하고 있는 클래스                     |



<br/><br/><br/><br/><br/><br/>

## 2.역할과 책임

프로젝트는 크게 입/출력을 담당하는 view 패키지, 각 역할과 책임을 나눈 클래스들의 model 패키지, 역할과 책임을 이어주는 Main 클래스 세 가지 파트로 구성됩니다.
<br/><br/>

| No  |content|    <center>설명 </center>     |
|:---:|:----|:----------------------------------------------------------------------------------------|
|  1  |&nbsp; view 패키지  |&nbsp; 사용자의|
|  2  |&nbsp; model 패키지 |&nbsp; Model 패키지와 내부 클래스 / 인터페이스들의 역할과 책임 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
|  3  |&nbsp; Main 클래스  |&nbsp; Main 클래스의 역할과 책임

<details>
<summary>📘	 Step 03.</summary>
<div markdown="1"></div></details>
</div>
</details>
</details>



<br/><br/>

## 3단계
공 밀기, 이동 불가, 위치 계산 등 게임의 주요 기능들이 대거 등장한다. `캐릭터의 위치를 계산`하기 위해 `int[][]` 을 사용는데, 캐릭터의 위치가 String[ ][ ] 일 때는 이를 계산하며 이동시키는 과정이 많이 까다롭지만, 모든 계산을 int로한 후 마지막에 출력만
문자로 변환해 반환하면 중간의 많은 과정을 생략할 수 있기 때문이다. 마지막에 문자로 변환될 때 바뀌는 `심볼`은 아래와 같다.


|No| 기호  |<center>의미</center>| <center>스테이지 구분</center>|                                                        
|:----:|:---:|:----|:------------------------------:|
|1|`#`|&nbsp; 벽(Wall)       |&nbsp; 9|
|2|` `|&nbsp; 빈 칸(Blank)    |&nbsp; 0|
|3|`O`|&nbsp; 구멍(Hall)      |&nbsp; 1|
|4|`o`|&nbsp; 공(Ball)       |&nbsp; 2|
|5|`O`|&nbsp; 구멍 + 공       |&nbsp; 3|
|6|`P`|&nbsp; 플레이어(Player) |&nbsp; 4|
|7|`P`|&nbsp; 플레이어 + 구멍   |&nbsp; 5|


<br/><br/><br/><br/>

## 테스트 케이스

각 테스트 케이스에 대한 예시와 출력 답안입니다. 4단계는 너무 많은 케이스가 있어 [영상](https://github.com/devjun10/CodeSquad_Cocoa/issues/4) 으로 대체했습니다. 
<br/><br/>
