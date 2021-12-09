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

## ⌨️ 입력

아래 내용을 문자열로 넘겨서 처리하는 함수를 작성한다. 복사는 아래 text를 이용하시면 됩니다. **아래 문자는 편의를 위해 "\n"을 조정했습니다.
<br/>

````text
model.Stage 1
#####
#OoP#
#####
=====
model.Stage 2
  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########
````

<br/><br/><br/><br/>

위 값을 읽어 2차원 배열로 변환 저장한다.
<br/>

| 기호  |<center>의미</center>| <center>스테이지 구분</center>|                                                        
|:---:|:----|:------------------------------:|
|  #  |&nbsp; 벽(Wall)       |&nbsp; 0|
|  O  |&nbsp; 구멍(Hall)      |&nbsp; 1|
|  o  |&nbsp; 공(Ball)       |&nbsp; 2|
|  P  |&nbsp; 플레이어(Player) |&nbsp; 3|
|  =  |&nbsp; 스테이지 구분         |&nbsp; 4|

<br/><br/><br/><br/><br/>

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

## 🖥 2단계 코딩 요구사항

- 너무 크지 않은 함수 단위로 구현하고 중복된 코드를 줄이도록 노력한다.
- 마찬가지로 Readme.md 파일과 작성한 소스 코드를 모두 기존 secret gist에 올려야 한다.
- 전역변수의 사용을 자제한다.
- 객체 또는 배열을 적절히 활용한다.

<br/><br/><br/>

## 🖥 2단계 기능 요구사항

- 처음 시작하면 스테이지 2의 지도를 출력한다.
- 간단한 프롬프트 (예: `SOKOBAN>   `)를 표시해 준다.
- 하나 이상의 문자를 입력받은 경우 순서대로 처리해서 단계별 상태를 출력한다.
- 벽이나 공등 다른 물체에 부딪히면 `해당 명령을 수행할 수 없습니다` 라는 메시지를 출력하고 플레이어를 움직이지 않는다.

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

```text
model.Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

SOKOBAN> ddzw (엔터)

  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########
 
 D: 오른쪽으로 이동합니다.
 
  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########
 
 D: (경고!) 해당 명령을 수행할 수 없습니다!
 
  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########
 
 Z: (경고!) 해당 명령을 수행할 수 없습니다!
 
  #######
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  # 
 ########
 
 W: 위로 이동합니다.
 
SOKOBAN> q
Bye~
```

<br/><br/><br/>



</div>
</details>





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
</details>

<br/><br/>

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

문제를 풀 때 턴제 RPG이며 절차 지향적 게임이기 때문에 순서와 흐름이 필요할 것이며 조건 분기가 많이 등장하리라 생각됐습니다. 따라서 `각 객체의 역할은 명확하게 분배`하고 `분기문을 지양`
하되 `크게 구애받지 말자`고 생각했습니다. 큰 흐름은 아래와 같은 순서로 진행됩니다. 클래스들의 역할은 나누고 Main 클래스 위에서 이를 절차적으로 이어주었습니다.

<br/>

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





<details>
<summary>📘	 Step 03.</summary>
<div markdown="1">


<br/><br/>

## 3단계
공 밀기, 이동 불가, 위치 계산 등 게임의 주요 기능들이 대거 등장한다. `캐릭터의 위치를 계산`하기 위해 `int[][]` 을 사용는데, 캐릭터의 위치가 String[ ][ ] 일 때는 이를 계산하며 이동시키는 과정이 많이 까다롭지만, 모든 계산을 int로한 후 마지막에 출력만
문자로 변환해 반환하면 중간의 많은 과정을 생략할 수 있기 때문이다. 마지막에 문자로 변환될 때 바뀌는 `심볼`은 아래와 같다.

<br/>

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


## 추가된 클래스

<br/>

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:---------------:|:------|:---|
|1|class|&nbsp;Answer               |&nbsp; 초기 Board의 상태와 다음 스테이지로 넘어갈지에 대한 정보를 담고 있는 클래스|
|2|class|&nbsp;Disk                 |&nbsp; Init에 관련된 정보를 담고 있는 클래스                            |
|3|class|&nbsp;Init                 |&nbsp; 각 Stage와 Sokoban 게임의 정보를 초기화하는 클래스                  |
|4|class|&nbsp;Stage                |&nbsp; Board와 Stageinformation을 담고 있는 클래스                   |
|5|class|&nbsp;Stages               |&nbsp; Stage들을 저장하고 있는 클래스                                 |
|6|class|&nbsp;StageInformation     |&nbsp; 가로, 세로크기 등 Stage의 기본 정보를 담고 있는 클래스               |
|7|class|&nbsp;StageInformationList |&nbsp; model.StageInformation 클래스들을 저장하고 있는 클래스                 |

<br/><br/><br/><br/><br/>

## 1. model.Answer

초기 Board의 상태와 다음 스테이지로 넘어갈지에 대한 정보를 담고 있는 클래스. 다음 스테이지로 넘어가기 위해서는 모든 퍼즐을 맞췄는지 체크해야 하는데, 이에 관한 정보를 가지고 있다. 또한 original이라는
원본 배열을 추가로 저장하고 있는데, 이는 명령어 R이 들어왔을 때 해당 값을 반환하기 위함이다.

### 1-1. int[][]calculateAnswer(int[][]array)

정답 배열을 저장하기 위해 캐릭터의 위치를 지우고 값을 저장하는 메서드. changeNumber 메서드를 통해 불필요한 값들을 제거한다.
<br/><br/>

```java
private int[][]calculateAnswer(int[][]array){
        int[][]temp=new int[array.length][array[0].length];
        for(int row=0;row<array.length;row++){
            for(int col=0;col<array[0].length;col++){
                temp[row][col]=changeNumber(array[row][col]);
            }
        }
        return temp;
}
```

<br/><br/><br/>

### 1-2. int changeNumber(int value)

배열에서 불필요한 값을 지우기 위해 값을 바꿔주는 메서드. 예를들어 정답을 체크하는 과정에서 캐릭터는 필요가 없기 때문에 4의 값을 0으로 바꿔준다.
<br/><br/>

```java
private int changeNumber(int value){
        if(value==1)return 3;
        if(value==2)return 0;
        if(value==4)return 0;
        return value;
}
```

<br/><br/><br/>

### 1-3. boolean isAnswer(int[][] array)

정답 값을 현재 배열과 비교하는 메서드. 기존 배열에 캐릭터를 지워주기 위해 deleteCharacter 도우미 메서드를 사용되었다.
<br/><br/>

```java
public boolean isAnswer(int[][]array){
        int[][]map=deleteCharacter(array);
        int[][]answer=this.answer;
        for(int row=0;row<answer.length;row++){
            if(checkColumn(row,map[row])){
                return false;
            }
        }
        return true;
}
```

<br/><br/><br/>

### 1-4. boolean checkColumn(int row, int[] array)

기존 배열과 현재 배열의 값을 비교하는 메서드. * 객체지향 체조원칙을 (최대한) 지키기 위해 이중 for문을 분리.  
<br/><br/>

```java
private boolean checkColumn(int row,int[]array){
        for(int col=0;col<answer[0].length;col++){
            if(array[col]!=this.answer[row][col]){
                return true;
            }
        }
        return false;
}
```

<br/><br/><br/>

### 1-5. int[][] getOriginal() {

사용자가 reset 버튼을 눌렀을 때 방어적 복사로 원본 배열을 반환하기 위한 메서드. 
<br/><br/>

```java
public int[][]getOriginal(){
        int[][]temp=new int[original.length][original[0].length];
        for(int row=0;row<original.length;row++){
            for(int col=0;col<original[0].length;col++){
                temp[row][col]=original[row][col];
            }
        }
        return temp;
}
```

<br/><br/><br/>

### 1-6. int[][] deleteCharacter(int[][] array)

정답을 비교하는 과정에서 캐릭터는 불필요하기 때문에 이를 제거하기 위한 메서드.
<br/><br/>

```java
private int[][]deleteCharacter(int[][]array){
        int[][]temp=new int[array.length][array[0].length];
        for(int row=0;row<array.length;row++){
            for(int col=0;col<array[0].length;col++){
                temp[row][col]=changeCharacter(array[row][col]);
            }
        }
        return temp;
}
```

<br/><br/><br/>

### 1-7. int changeCharacter(int value)

캐릭터(4)를 빈칸(0)으로 바꿔주는 deleteCharacter의 도우미 메서드.
<br/><br/>

```java
private int changeCharacter(int value){
        if(value==4){
            return 0;
        }
        return value;
}
```

<br/><br/><br/><br/>

## 2. model.Disk

Sokoban 내부의 데이터를 저장/불러오기 위한 클래스. Init메서드를 통해 애플리케이션이 동작할 때 필요한 데이터를 모두 초기화 한다. 애플리케이션에서 데이터의 저장/초기화와 관련된 정보를 관리하는 역할을
담당한다.
<br/>

````java
public class model.Disk {

  private model.Init init = model.Init.of();

  private Disk() {
  }

  ;

  public static model.Disk of() {
    return new model.Disk();
  }

}

````

<br/>

## 3. model.Init

각 Stage와 Sokoban 게임의 정보를 초기화하는 클래스. 사용자는 데이터를 사용하는 것에만 집중할 수 있도록 하기 위해 애플리케이션이 실행되는 시점에 데이터를 초기화한다.

<br/><br/><br/>

## 4. model.Stage

Board와 Stageinformation을 담고 있는 클래스. 이전에는 Board에서 모든 정보를 관리했지만 각 Stage가 나누어져 있기 때문에 각각의 Stage는 자신에 대한 정보를 담고 있다. 따라서 가로
크기, 세로 크기, 맵 등과 같은 자신과 연관된 정보를 가지고 있다.
<br/>

### 4-1. List<view.GameResult> execute(List<view.Command> commandList)

플레이 한 게임의 실행 결과를 반환하는 메서드. 리스트를 순회하며 사용자로 부터 입력받은 명령어를 실행하고 그 결과(Board의 상태)를 반환한다. 

```java
public List<view.GameResult> execute(List<view.Command> commandList){
        List<view.GameResult> results=new ArrayList<>();
        for(view.Command command:commandList){
            if(command.equals(view.Command.R)){
                return List.of(resetStage());
            }
            results.add(this.board.push(command));
        }
        return results;
}
```

<br/>

### 4-2. view.GameResult resetStage()

리셋 명령어를 처리하기 위한 메서드. model.Answer 내에 있는 original 배열을 가져와 이를 반환한다. 

```java
public view.GameResult resetStage(){
        this.board.reset();
        return new view.GameResult(this.board.getBoard());
}
```

<br/><br/><br/>

## 5. model.Stages

Stage들을 저장하고 있는 클래스. model.Stage 클래스는 매 번 새로 생성될 필요가 없기 때문에 애플리케이션이 시작되는 시점에 한 번만 초기화를 한다.

```java
import model.Board;import model.Stage;
import model.StageInformation;

public class Stages {

  private static final Map<Integer, Stage> stages = new HashMap<>();

  private Stages() {
  }

  public static void putStage(int id, StageInformation information, Board board) {
    stages.put(id, new Stage(board, information));
  }

  public static model.Stages of() {
    return new model.Stages();
  }

  public Stage getStage(int value) {
    return stages.get(value);
  }
}
```

<br/><br/><br/>

## 6. model.StageInformation

가로, 세로크기, id와 같은 Stage의 기본 정보를 담고 있는 클래스. 값 객체를 사용해 상태를 표현하기 위해 한 단계 포장(Wrapping) 했다. 

```java
public class model.StageInformation {

    private final int id;
    private final int height;
    private final int width;

    public model.StageInformation(int id, int height, int width) {
        this.id = id;
        this.height = height;
        this.width = width;
}

```

<br/><br/><br/>

## 7. model.StageInformationList

model.StageInformation 클래스들을 저장하고 있는 클래스. 내부에 새로운 객체를 담아서 저장하는데, 이는 클래스가 생성될 때마다 초기화될 필요가 없으며, 스테이지 수가 많지 않기 때문에 이를 직접 생성해서
관리해도 나쁘지 않다고 판단했기 때문이다.

```java
import model.StageInformation;

public class StageInformationList {

  private static List<StageInformation> stages;

  private StageInformationList() {
  }

  static model.StageInformationList of() {
    List<StageInformation> lst = List.of(
            new StageInformation(1, 6, 6),
            new StageInformation(2, 5, 6),
            new StageInformation(3, 6, 6),
            new StageInformation(4, 6, 7)
    );
    stages = lst;
    return new model.StageInformationList();
  }
    ......

```

<br/><br/>
## 주요 변경 클래스
<br/>

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:---------------:|:------|:---|
|8|class|&nbsp;model.Board                |&nbsp; 각 Stage의 배열의 상태를 관리하며 정답 클래스를 알고 있다            |
|9|class|&nbsp;model.GameMachine          |&nbsp; Sokoban게임의 중심에서 모든 정보를 관리하며 이를 조합해주는 클래스     |
|10|class|&nbsp;model.GameManager          |&nbsp; 게임에 관련된 부가 정보를 처리하는 클래스                         |

<br/><br/><br/><br/><br/>

## 8. model.Board

각 Stage의 배열의 상태를 관리하며 정답 클래스로 Stage의 상태와 관련된 역할과 책임을 가진다. 따라서 배열의 이동, 상태 변화 등과 같은 모든 

### 8-1. view.GameResult push(view.Command command)

배열을 변환하는 메서드. 현재 캐릭터의 위치를 기준으로 미는 방향의 한 칸, 두 칸 앞을 체크해서 배열을 변환할 지 결정한다. 모든 배열은 사이드 이펙트를 제거하기 위해 방어적 복사를 통해 값을 반환한다.
<br/><br/>

```java
view.GameResult push(view.Command command){
        view.GameResult gameResult=new view.GameResult();
        utils.Point point=findPlayerPosition();

        int moveBlockX=point.getX()+command.getNextPosition().get(0);
        int moveBlockY=point.getY()+command.getNextPosition().get(1);
        int[][]newBoard=copyBoard();

        if(moveable(utils.Position.of(moveBlockX,moveBlockY))){
            int[][]updatedBoard=move(point,newBoard,utils.Position.of(moveBlockX,moveBlockY));
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }else if(
            pushable(utils.Position.of(moveBlockX,moveBlockY),command)){
            int[][]updatedBoard=pushBall(point,newBoard,utils.Position.of(moveBlockX,moveBlockY),command);
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }
        checkGameResult(gameResult);
        return gameResult;
}
```

<br/><br/><br/>

### 8-2. view.GameResult push(view.Command command)

push를 두 가지로 나눈 메서드로 캐릭터가 이동 가능할 때는 move를, move를 할 수 없지만 다음 칸에서 공을 밀 수 있을 때는 pushBall 메서드를 실행한다. 
<br/><br/>

```java
private int[][]move(utils.Point position,int[][]board,utils.Point nextPosition){
        board[position.getX()][position.getY()]-=4;
        board[nextPosition.getX()][nextPosition.getY()]+=4;
        return board;
}

private int[][]pushBall(utils.Point position,int[][]board,utils.Point nextPosition,view.Command command){
        board[position.getX()][position.getY()]-=4;
        board[nextPosition.getX()][nextPosition.getY()]+=4;
        board[nextPosition.getX()][nextPosition.getY()]-=2;
        board[nextPosition.getX()+command.getNextPosition().get(0)][nextPosition.getY()+command.getNextPosition().get(1)]+=2;
        return board;
}
```

<br/><br/><br/>

### 8-3. boolean isBall, moveable, isBlank, isHall, isBallOnTheHole(int x, int y)

배열을 update하기 위해 한 칸 앞, 두 칸 앞 등 해당 칸에 어떤 심볼이 존재하는지 체크하는 메서드.
<br/><br/>

```java
private boolean isBall(int x,int y){
        return this.board[x][y]==2;
}

private boolean moveable(utils.Point point){
        return this.board[point.getX()][point.getY()]==0||this.board[point.getX()][point.getY()]==1;
}

private boolean isBlank(int x,int y){
        return this.board[x][y]==0;
}

private boolean isHall(int x,int y){
        return this.board[x][y]==1;
}

private boolean isBallOnTheHole(int x,int y){
        return this.board[x][y]==3;
}

private boolean isPlayer(int x,int y){
        return this.board[x][y]==4||this.board[x][y]==5;
}    
```

<br/><br/><br/>

### 8-4. utils.Point findPlayerPosition()

캐릭터의 위치를 찾기 위한 메서드. `*객체지향 체조원칙을 지키기 위해 수정하고 싶지만 아직 마땅히 대안이 떠오르지 않는다.` 
<br/><br/>

```java
protected utils.Point findPlayerPosition(){
        for(int row=0;row< this.board.length;row++){
            for(int col=0;col< this.board[0].length;col++){
                if(isPlayer(row,col)){
                    return utils.Position.of(row,col);
                }
            }
        }
        return null;
}
```

<br/><br/><br/>

### 8-5. boolean isAnswer();

정답을 찾아서 비교하기 위한 메서드. model.Answer 클래스 내부의 answer 값(int[][])과 비교를 통해 정답을 체크한다.  
<br/><br/>

```java
protected boolean isAnswer(){
        return answer.isAnswer(this.board);
}
```

<br/><br/><br/>

### 8-6. void reset()

해당 스테이지의 초기 값을 반환하는 메서드. Answer내부의 original 값(int[][])을 통해 초기 상태로 되돌린다.    
<br/><br/>

```java
public void reset(){
        int[][]reset=this.answer.getOriginal();
        update(reset);
}
```
<br/><br/><br/>

## 9. model.GameManager

사용자의 입력을 명령으로 변환해주고 게임의 횟수, 메시지/게임에 대한 정보 전달의 역할을 담당한다. 게임 안내 문구, 턴 수 체크/증가 등과 같은 게임 외적 요소들을 담당하며 플레이어의 원활한 게임 진행을 돕는
역할을 맡고 있다.

<br/><br/><br/>

### 9-1. void sayHello(), sayGoodBye(), sayTurnCount(int value), sayTurnReset()

게임과 연관된 시작, 마무리, 턴 횟수 등의 메시지를 전달하는 메서드.
<br/><br/>

```java
public void sayHello(){
        System.out.println(view.SystemMessage.GREET);
}

public void sayGoodBye(){
        System.out.println(view.SystemMessage.CLEAR_CELEBRATION);
        System.out.println(view.SystemMessage.CELEBRATION);
}

public void sayTurnCount(int value){
        System.out.println(view.SystemMessage.TURN_COUNT+""+value);
}

public void sayTurnReset(){
        System.out.println(view.SystemMessage.TURN_RESET);
}
```

<br/><br/><br/>

### 9-2. List<view.GameResult> play(int stageNumber,List<view.Command> commands)

<br/><br/>
stageNumber을 통해 해당 스테이지를 찾고 명령을 전달한다.

```java
public List<view.Command> getCommand(List<String> direction){
        List<view.Command> commands=new ArrayList<>();
        for(int i=0;i<direction.size();i++){
            view.Command command=getCommands(direction.get(i));
                if(command.equals(view.Command.R)){
                    return List.of(view.Command.R);
                }
                validateQuit(command);
                commands.add(command);
            }
        return commands;
}
```

<br/><br/><br/>

### 9-3. int stageUp(int value)

다음 단계로 진행하기 위해 스테이지를 한 단계 올리는 메서드.
<br/><br/>

```java
public int stageUp(int value){
        return value+=1;
}
```

<br/><br/>

### 9-4. int plusTurn(int value)

턴의 횟수를 1 증가시키는 메서드.
<br/><br/>

```java
public int plusTurn(int value){
        return value;
}
```

<br/><br/>
### 9-5. int turnInit()

다음 Stage로 넘어갔을 때 턴 수를 초기화하는 메서드.
<br/><br/>

```java

public int turnInit(){
        return 0;
}
```

<br/><br/><br/>
</div>
</details>



<details>
<summary>📕	 Step 04.</summary>
<div markdown="1">

## 4단계 : 추가기능 구현

4단계 부터는 조금 자유롭게 구현을 했지만 추가 구현이 많아지고 시간이 촉박해지면서 분기문이 점점 늘어났습니다. 

<br/><br/>


## 추가/변경된 주요 클래스
|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:-------------------:|:------|:---|
|1|class|&nbsp;model.Init           |&nbsp; 데이터의 초기화를 담당하는 클래스                           |
|2|class|&nbsp;model.StageData      |&nbsp; 명령어를 통해 불러올 수 있는 스테이지의 목록을 보여주기 위한 클래스  |
|3|class|&nbsp;model.AES256Cipher   |&nbsp; 암호화/복호화를 위한 클래스                               |
|4|class|&nbsp;model.Slot            |&nbsp; 캐릭터의 스테이지 상태를 저장한 클래스                       |

## 1. model.Init 클래스

각 Stage와 Sokoban 게임의 정보를 초기화하는 클래스. 사용자는 데이터를 사용하는 것에만 집중할 수 있도록 하기 위해 애플리케이션이 실행되는 시점에 데이터를 초기화한다.

<br/>

### 1-1. List<String[][]> getMaps()


<br/><br/>
List<String[][]>의 형태로 2차원 배열들을 저장한다. 이는 각 Stage의 맵들을 나타내는데, 이를 통해 각 클래스의 맵을 초기화한다. 
```java
List<String[][]> getMaps() {
        String[][] result = getStages();
        List<String[][]> answer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i];
            String[][] array = new String[temp.length][temp[0].length()];
            for (int j = 0; j < temp.length; j++) {
                array[j] = temp[j].split("");
            }
            answer.add(array);
        }
        return answer;
}

```

<br/><br/><br/>
### 1-2. String[][] getStages()
이차원 배열의 형태로 각 스테이지를 반환한다. 이를 통해 1차원 배열로 있는 맵들을 2차원 배열에 저장하게 된다. 
<br/><br/>

```java
String[][] getStages() {
    String[] eachStages = joiningTextFileWord();
    int rows = eachStages.length;
    String[][] result = new String[rows][];
    
    for (int i = 0; i < rows; i++) {
        String[] temp = splitByComma(eachStages[i]);
        int tempCols = temp.length;
        result[i] = new String[tempCols];
        for (int j = 0; j < tempCols; j++) {
                result[i][j] = temp[j];
            }
        }
        return result;
}
```

<br/><br/><br/>


## 1-3. String[] splitByComma(String word)
", "를 기준으로 문자를 나눈다.  
<br/>
```java
private String[] splitByComma(String word) {
        return word.split(",");
}
```

<br/><br/><br/>


## 1-4. String[] joiningTextFileWord()
텍스트 파일을 읽어들인 후 model.Stage("=======)를 기준으로 문자 배열을 만드는 메서드. 이를 통해 Stage를 구분한다.


```java
String[] joiningTextFileWord() {
    try {
        stringBuilder.setLength(0);
        File file = new File("map.txt");
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while ((line = bufReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufReader.close();
    } catch (IOException e) {
        System.out.println(e);
    }
    return splitByStage(stringBuilder.toString());
}
```

<br/><br/><br/>


## 2. model.StageData 클래스
현재 슬롯의 상태를 보여주기 위한 클래스. 가변 객체로 설정한 이유는 불변 클래스와의 비교를 통해 슬롯의 부족한 부분을 화면에 보여주기 위해서다. *맵을 4단계 까지밖에 구현하지 않아 5 이상은 보이지 않는다. 

<br/><br/>
```java
public class model.StageData {

    private int stageId;
    private String name;

    public model.StageData(int stageId, String name) {
        this.stageId = stageId;
        this.name = name;
    }

    public int getStageId() {
        return stageId;
    }

    public String getName() {
        return name;
    }

    public void editName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return stageId + ": " + name;
    }
}

```

<br/><br/><br/>




## 3. model.AES256Cipher 클래스

암호화/복호화를 위한 클래스. 

<br/>

### 3-1. static model.AES256Cipher getInstance()

싱글턴으로 객체를 생성하기 위한 스태틱 메서드. 
<br/><br/>

```java
public static model.AES256Cipher getInstance() {
        if(INSTANCE==null){
            synchronized (model.AES256Cipher.class){
                if(INSTANCE==null)
                    INSTANCE=new model.AES256Cipher();
                }
            }
        return INSTANCE;
}
```

<br/><br/><br/>


### 3-2. static String AES_Encode(String str)

암호화를 위한 스태틱 메서드. 이를 통해 문자열을 암호화시킬 수 있다.
<br/><br/>

```java
public static String AES_Encode(String str) {
        throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
        InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = secretKey.getBytes();

        SecretKey secureKey = new SecretKeySpec(keyData, "AES");

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.getEncoder().encode(encrypted));

        return enStr;
}
```

<br/><br/><br/>

### 3-3. static String AES_Decode(String str)

복호화를 위한 스태틱 메서드. 이를 통해 문자열을 복호화시킬 수 있다.
<br/><br/>

```java
public static String AES_Decode(String str) {
        throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
        InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = secretKey.getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

        byte[] byteStr = Base64.getDecoder().decode(str.getBytes());

        return new String(c.doFinal(byteStr), "UTF-8");
        }
```
<br/><br/><br/>

복호화를 위한 스태틱 메서드. 이를 통해 문자열을 복호화시킬 수 있다.
<br/><br/>

```java
public static String AES_Decode(String str) {
        throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
        InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = secretKey.getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

        byte[] byteStr = Base64.getDecoder().decode(str.getBytes());

        return new String(c.doFinal(byteStr), "UTF-8");
        }
```
<br/><br/><br/>

## 4. model.Slot 클래스
model.Slot 클래스가 생성될 때 내부 데이터를 초기화 한다. 아래는 불변 클래스로 해당 배열과의 비교를 통해 빈 슬롯인지, 아닌지를 출력한다.
<br/>

```java
private model.Slot() {
        for (int i = 1; i < 5; i++) {
            saveData.add(new model.StageData(i, "Empty"));
        }
        List<model.StageData> temp = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            temp.add(new model.StageData(i, "model.Stage"+i));
        }
        this.checkData = Collections.unmodifiableList(temp);
}
```


### 4-1. void saveData(int stageNumber, String[][] array)
데이터를 저장하는 메서드로 ,와 "\n"를 통해 맵을 구분해서 저장한다. 
<br/>

```java
public void saveData(int stageNumber, String[][] array) {
        stringBuilder.setLength(0);
        String name = save + stageNumber + txt;
        File file = new File(name);
        int[][] intArray = changeStringArrayToIntArray(array);
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                stringBuilder.append(intArray[row][col]).append("");
            }
        stringBuilder.append(",").append("\n");
        }
        stringBuilder.append(line);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            }
}
```
<br/><br/><br/>

### 4-2. List<model.StageData> getSlotData()
빈 슬롯이 아닌 데이터의 이름을 변환하는 메서드. 이를 통해 사용자에게 슬롯의 상태를 출력해줄 수 있다. 
<br/>

```java
List<model.StageData> getSlotData() {
        for (int i = 0; i < this.saveData.size(); i++) {
            if (loadStageData(i+1 ).length > minNumber) {
                saveData.get(i).editName(checkData.get(i).getName());
            }
        }
        return new ArrayList<>(saveData.stream()
            .collect(Collectors.toUnmodifiableList()));
}
```
<br/><br/><br/>
### 4-3. String[] joiningTextFileWord(int stageNumber)
해당 stageNumber의 맵을 콤마(,)를 기준으로 나누는 메서드
<br/>

```java
String[] joiningTextFileWord(int stageNumber) {
        String fileName = save + stageNumber + txt;
        try {
            stringBuilder.setLength(0);
            File file = new File(fileName);
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
            return splitByComma(replaceBar(stringBuilder.toString()));
}
```
<br/><br/><br/>

<br/><br/><br/>
### 4-4. int[][] changeStringArrayToIntArray(String[][] array), int[][] changeStringArrayToIntArrayOriginal(String[][] array)
String[][] 을 2차원 int[][]로 바꿔주는 메서드. int[][]형태로 보낸 후 이를 업데이트 한다.
<br/>

```java
private int[][] changeStringArrayToIntArray(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeStringSymbol(array[row][col]);
            }
        }
        return temp;
}

private int[][] changeStringArrayToIntArrayOriginal(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = Integer.parseInt(array[row][col]);
            }
        }
        return temp;
}
```
<br/><br/><br/>

</div>

</details>




<br/><br/><br/><br/>

## 테스트 케이스

각 테스트 케이스에 대한 예시와 출력 답안입니다. 4단계는 너무 많은 케이스가 있어 [영상](https://github.com/devjun10/CodeSquad_Cocoa/issues/4) 으로 대체했습니다. 
<br/><br/>

