# 소코반(Sokoban)

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
Stage 1
#####
#OoP#
#####
=====
Stage 2
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
Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어 위치 (2, 4)

Stage 2

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

[comment]: <> (2단계)

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
Stage 2

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
- 처음 시작시 Stage 1의 지도와 프롬프트가 표시된다.
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

Stage 1

#####
#OoP#
#####

SOKOBAN> A

#####
#0P #
#####

빠밤! Stage 1 클리어!
턴수: 1

Stage 2
...

Stage 5
...

빠밤! Stage 5 클리어!
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
|  1  |&nbsp;프로젝트 개요                                                                          |[링크]()|
|  2  |&nbsp;풀이 과정 및 코드 설명. 실행 결 기술 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|[링크](#풀이-과정-및-코드-설명)|
|     |&nbsp;&nbsp;&nbsp; `Step 01.`  1단계 풀이 과정 / 코드                                         |       |
|     |&nbsp;&nbsp;&nbsp; `Step 02.`  2단계 풀이 과정 / 코드                                         |       |
|  3  |&nbsp;테스트 케이스                                                                         |[링크]()|

<br/><br/><br/><br/><br/>

# 풀이 과정 및 코드 설명

<details>
<summary>📔	 Step 01.</summary>
<div markdown="1">

## 1단계

예제를 `그대로 화면에 출력`하는 문제로, 추가적 작업 없이 받은 정보를 화면에 출력하는 문제입니다. 따라서 입력 받은 문자열 입력에 대한 예외 처리를 하지 않고 입력된 문자열을 파싱해 Stage1과 Stage2에
대한 정보를 화면에 출력했습니다. *1단계에서 4단계로 갈수록 복잡해지고 구현사항이 추가되는 것 같아, 문제에서 원하는 요건만 빠르게 충족시키고 위해 일부 클래스와 메서드들은 하드코딩 되어있습니다.  
<br/>

![링크]()

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:----:|:---|:---|
|1|class|&nbsp;InputView|&nbsp; 사용자의 입력을 담당하는 클래스        |
|2|class|&nbsp;OutputView|&nbsp; 사용자에게 게임의 결과를 출력해주는 클래스        |
|3|enum|&nbsp;Message|&nbsp; 사용자에게 보여질 메시지를 관리하는 클래스        |
|4|class|&nbsp;ErrorMessage|&nbsp; 사용자에게 보여질 에러메시지를 관리하는 클래스|
|5|class|&nbsp;Position|&nbsp; Player의 좌표를 나타내는 클래스|
|6|class|&nbsp;StageResult|&nbsp; Stage의 정보를 담고 있는 클래스|

<br/><br/><br/>

## 1. InputView 클래스

사용자의 입력을 받는 클래스

<br/>

### 1-1. List<StageResult> inputMap(String word)

문자열을 인자로를 받아 List<StageResult>의 형태로 최종 반환해주는 메서드. List 내부에는 Stage1과 Stage2에 대한 정보가 담겨있다.

````java
public List<StageResult> inputMap(String word){
        return getResult(word);
}
````

<br/><br/>

### 1-2. List<StageResult> getResult(String word)

문자열을 인자로 받아 각 Stage에 대한 실제 정보를 생성해주는 메서드. 메서드 내부에서 도우미 메서드를 사용해 Stage1과 Stage2에 대한 정보를 생성한다.

```java
private List<StageResult> getResult(String word){
        List<String> words=getWordsSplitByLine(word);
        List<StageResult> results=new ArrayList<>();

        StageResult stageFirst=new StageResult(1,getStageFirstMap(words));
        StageResult stageSecond=new StageResult(2,getStageSecondMap(words));

        results.add(stageFirst);
        results.add(stageSecond);
        return results;
}
```

<br/><br/>

### 1-3. List<String> getWordsSplitByLine(String word)

문자열을 인자로 받아 List<String> 형태로 단어를 나눠주는 메서드. 맵의 정보를 나누기 위해 사용된다.

````java
private List<String> getWordsSplitByLine(String word){
        String[]wordArray=word.split("\n");
        List<String> words=new ArrayList<>();
        words.addAll(Arrays.asList(wordArray));
        return words;
}
````

<br/><br/>

### 1-4. int[ ][ ] getStageFirstMap(List<String> lst)

인자로 문자열 리스트를 받아 첫 번째 맵의 구성을 int[][] 형태로 반환해주는 메서드. 각 칸들의 심볼을 int로 변환해서 값을 저장시켜 준다.

````java
private int[][]getStageFirstMap(List<String> lst){
        String[][]stringArray=new String[3][5];
        
        for(int i=0;i< 3;i++){
            stringArray[i]=lst.get(i+1).split("").clone();
        }
        return getIntArray(stringArray);
}
````

<br/><br/>

### 1-5. int[][] getStageSecondMap(List<String> lst)

인자로 문자열 리스트를 받아 두 번째 맵의 구성을 int[][] 형태로 반환해주는 메서드. 각 칸들의 심볼을 int로 변환해서 값을 저장시켜준다.

````java
private int[][]getStageSecondMap(List<String> lst) {
        int[][]intArray=new int[7][11];
        for(int i=6;i< 13;i++){
            String[]array=lst.get(i).split("");
            int count=array.length;
            for(int j=0;j<count; j++) {
                intArray[i-6][j]=getIntValue(array[j]);
            }
        }
        return intArray;
}
````

<br/><br/>

### 1-6. int[ ][ ] getIntArray(String[][] stringArray)

문자 배열을 인자로 받아 int[][] 로 반환하는 메서드. 각 칸의 심볼을 맞는 int 값으로 변경해준다.

````java
private int[][]getIntArray(String[][]stringArray){
        int[][]intArray=new int[stringArray.length][stringArray[0].length];
        for(int row=0;row<stringArray.length;row++){
            for(int col=0;col<stringArray[0].length;col++){
                intArray[row][col]=getIntValue(stringArray[row][col]);
            }
        }
        return intArray;
}
````

<br/><br/>

### 1-7. int getIntValue(String symbol)

인자로 문자를 받아 int를 반환하는 메서드. 각 칸의 심볼을 맞는 int 값으로 변경해준다.

````java
private int getIntValue(String symbol){
        if(symbol.equals("#")){
            return 0;
        }
        if(symbol.equals("O")){
            return 1;
        }
        if(symbol.equals("o")){
            return 2;
        }
        if(symbol.equals("P")){
            return 3;
        }
        if(symbol.equals(" ")){
            return 5;
        }
            return 5;
}
````

<br/><br/><br/><br/>

## 2. OutputView

Stage의 정보를 출력해주는 클래스

<br/><br/>

### 2-1. void print(List<StageResult> results)

Stage들에 대한 정보를 인자로 받아 화면에 출력해주는 메서드.

```java
public void print(List<StageResult> results){
        stringBuilder.setLength(0);
        for(int number=0;number<results.size();number++){
            StageResult stageInfo=results.get(number);
            stringBuilder.append(Message.STAGE_INFO).append(stageInfo.getStage()).append("\n");
            String[][]stageMap=getStringArray(results.get(number).getMap());
            for(int row=0;row<stageInfo.getMap().length;row++){
                stringBuilder.append("\n");
                for(int col=0;col<stageInfo.getMap()[0].length;col++){
                    stringBuilder.append(stageMap[row][col]);
                }
            }
            
        stringBuilder.append("\n").append("\n").append(Message.HORIZONTAL_LENGTH).append(stageInfo.getHorizontalCount()).append("\n")
        .append(Message.VERTICAL_LENGTH).append(stageInfo.getVerticalCount()).append("\n")
        .append(Message.HOLE_COUNT).append(stageInfo.getHoleCount()).append("\n")
        .append(Message.BALL_COUNT).append(stageInfo.getBallCount()).append("\n")
        .append(Message.PLAYER_POSITION).append(stageInfo.getPlayerPosition()).append("\n").append("\n");
        }
        System.out.println(stringBuilder);
}
```

<br/><br/><br/>

### 2-2. String[][] getStringArray(int[][] map)

Stage 정보 중 int[ ][ ]를 인자로 받아 String[ ][ ]로 변환해주는 메서드.
<br/><br/>

```java
private String[][]getStringArray(int[][]map){
        String[][]stringArray=new String[map.length][map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
            stringArray[i][j]=getStringValue(map[i][j]);
            }
        }
        return stringArray;
}
```

<br/><br/><br/>

### 2-3. String getStringValue(int symbol)

int를 인자로 받아 String 값으로 변환해주는 메서드. 문자열 배열을 int 배열로 바꾸기 위해 사용된다.

````java
private String getStringValue(int symbol){
        if(symbol==0){
            return"#";
        }
        if(symbol==1){
            return"O";
        }
        if(symbol==2){
            return"o";
        }
        if(symbol==3){
            return"P";
        }
        if(symbol==5){
            return" ";
        }
        return" ";
}
````

<br/><br/><br/><br/>

## 3.Message

사용자에게 보여질 메시지를 관리하기 위한 enum 클래스.

<br/><br/>

## 4.ErrorMessage

사용자에게 보여질 오류 메시지를 관리하기 위한 enum 클래스.

<br/><br/>

## 5.Position

사용자의 위치를 저장하기 위한 값 객체.
<br/>

```java
@Override
public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Position position=(Position)o;
        return x==position.x&&y==position.y;
}

@Override
public int hashCode(){
        return Objects.hash(x,y);
}
```

<br/><br/><br/>

## 6.StageResult

각 Stage에 대한 정보를 담고 있는 클래스.

<br/><br/>

### 6-1. int getHoleCount(int[ ][ ] map)

int[][] 를 인자로 받아 구멍(hole)의 개수를 반환하는 메서드.
<br/><br/>

```java
private int getHoleCount(int[][]map){
        int count=0;
        for(int row=0;row<map.length;row++){
            for(int col=0;col<map[0].length;col++){
                if(map[row][col]==1){
                    count++;
                }
            }
        }
        return count;
}
```

<br/><br/><br/>

### 6-2. int getBallCount(int[][] map)

int[][]를 인자로 받아 공(ball)의 개수를 반환하는 메서드.
<br/><br/>

```java
private int getBallCount(int[][]map){
        int count=0;
        for(int row=0;row<map.length;row++){
            for(int col=0;col<map[0].length;col++){
                if(map[row][col]==2){
                    count++;
                }
            }
        }
        return count;
}
```

<br/><br/><br/>

### 6-3. Position getPlayerPosition(int[][] map)
int[ ][ ]를 인자로 받아 플레이어의 위치(x, y)의 좌표를 반환하는 메서드.
<br/><br/>

```java
private Position getPlayerPosition(int[][]map){
        int count=0;
        int playerX=Integer.MAX_VALUE;
        int playerY=Integer.MAX_VALUE;
        for(int row=0;row<map.length;row++){
            for(int col=0;col<map[0].length;col++){
                if(map[row][col]==3){
                    playerX=row;
                    playerY=col;
                }
            }
        }
        return new Position(playerX,playerY);
}
```

</div>
</details>



<details>
<summary>📕	 Step 02.</summary>
<div markdown="1">

## 2단계

2단계는 `캐릭터의 위치를 이동`시키는 문제입니다. 따라서 다른 고려사항은 크게 생각하지 않고 캐릭터가 움직일 칸이 비었으면(" ") 캐릭터의 위치를 이동시켰습니다. 2단계 까지는 비교적 복잡하지 않기 때문에 칸의 
이동을 int로 하지 않고 문자열을 그대로 사용했습니다. *마찬가지로 점진적 리팩토링을 위해 일부 클래스와 메서드가 하드코딩 되어있습니다.
<br/>

![링크]()


<br/>


## 추가된 클래스
|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:---------------:|:------|:---|
|1|class|&nbsp;Board     |&nbsp; 게임 캐릭터와 구멍, 공 등 각 요소들의 정보를 저장하는 클래스  |
|2|class|&nbsp;Command   |&nbsp; 명령어(w,a,q)들과 다음 위치의 계산을 돕는 값을 가진 클래스 |
|3|class|&nbsp;GameResult|&nbsp; 배열의 상태를 담아 반환해주는 클래스                   |
|4|class|&nbsp;Pair      |&nbsp; (x, y) 좌표를 묶어서 관리하는 클래스                   |
|5|class|&nbsp;Pairs     |&nbsp; Pair의 값들이 저장된 클래스                        |

## 1. Board 클래스

GameMachine 내부의 2차원 배열의 값과 연관된 메서드를 가지고 있는 클래스. 게임 캐릭터와 구멍, 공 등 각 심볼들의 상태를 관리하며 사이드 이펙트를 제거하기 위해 내부 배열을 갈아 끼우는 형태로 매 번
업데이트 한다.

<br/>

### 1-1. void initBoard()

Board 클래스 객체가 생성될 때 String[ ][ ] 배열을 초기화시켜주는 메서드. 
<br/><br/>

```java
void initBoard(){
        board=new String[BOARD_WIDTH][BOARD_HEIGHT];
        this.board[0]=new String[]{" "," ","#","#","#","#","#","#","#"," "," "};
        this.board[1]=new String[]{"#","#","#"," "," ","O"," "," ","#","#","#"};
        this.board[2]=new String[]{"#"," "," "," "," ","o"," "," "," "," ","#"};
        this.board[3]=new String[]{"#"," ","O","o"," ","P"," ","o","O"," ","#"};
        this.board[4]=new String[]{"#","#","#"," "," ","o"," "," ","#","#","#"};
        this.board[5]=new String[]{" ","#"," "," "," ","O"," "," ","#"," "," "};
        this.board[6]=new String[]{" ","#","#","#","#","#","#","#","#"," "," "};
}
```

<br/><br/><br/>

### 1-2. String[][] getBoard()

String[][]를 방어적 복사로 넘겨주는 반환하는 메서드. 사이드 이펙트를 제거하기 위해 매 번 배열을 생성해서 복사한 후 반환한다.
<br/>

```java
String[][]getBoard(){
        String[][]copyBoard=new String[BOARD_WIDTH][BOARD_HEIGHT];
        for(int row=BOARD_START;row<BOARD_WIDTH; row++){
            copyBoard[row]=this.board[row].clone();
        }
        return copyBoard;
}
```

<br/><br/><br/>

### 1-3. void update(String[ ][ ] updatedBoard)

배열을 업데이트 시켜주는 메서드. 사이드 이펙트를 방지하기 위해 board의 값을 null로 초기화시켜준 후 새로운 배열을 넣는다. 

<br/>

```java
protected void update(String[][]updatedBoard){
        this.board=null;
        this.board=updatedBoard;
}
```

<br/><br/><br/>

### 1-4. Pair findPlayerPosition()

현재 캐릭터의 위치를 찾는 메서드. 캐릭터를 기준으로 이동할 방향과 다음 칸을 보면 빠른 빠른 계산이 가능하다. String[][] 배열을 순회하며 `P` 인 칸의 좌표를 Pair로 반환한다.  
<br/>

```java
protected Pair findPlayerPosition(){
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;

        for(int row=0;row< 11;row++){
            for(int col=0;col< 11;col++){
                if(board[row][col].equals("P")){
                    x=row;
                    y=col;
                }
            }
        }
        return Pairs.of(x,y);
}
```

<br/><br/><br/>

### 1-5. Pair validatePosition(int x, int y)

캐릭터가 움직일 칸을 검증하는 메서드. 이동할 칸이 범위 내에 있을 때, 해당 칸이 비었을 때 true를 반환하고 그 외에는 false를 반환한다. 이를 통해 메서드 내부에서 if문으로 매 번 검증하는 것을 고려하지
않아도 된다.
<br/>

```java
protected boolean validatePosition(int x,int y){
        if(!validateRange(x,y)){
            return false;
        }

        if(!validateMoveable(x,y)){
            return false;
        }
        return true;
}
```

<br/><br/><br/>

### 1-6. Pair validateRange(int x, int y)

Pair(x, y) 값이 이동 가능한 범위 내에 있는지를 체크하는 메서드.
<br/>

```java
private boolean validateRange(int x,int y){
        return x>=0&&x< 11&&y>=0&&y< 11;
}
```

<br/><br/><br/>

### 1-7. Pair validateRange(int x, int y)

해당 칸이 비어있는지 체크하는 메서드. 
<br/>

```java
private boolean validateMoveable(Pair pair){
        return this.board[pair.getX()][pair.getY()].equals(" ");
}
```

<br/><br/><br/>

## 2. Command 클래스

사용자의 입력을 명령으로 바꿔주고, 다음에 이동할 칸의 위치를 계산할 수 있는 내부 좌표 값을 가지고 있다.
<br/>

```java
public enum Command {

    UP("U", "위쪽으로 한 칸 이동", List.of(1, 0)),
    DOWN("D", "아랫쪽으로 한 칸 이동", List.of(-1, 0)),
    RIGHT("R", "오른쪽으로 한 칸 이동", List.of(0, -1)),
    LEFT("L", "왼쪽으로 한 칸 이동", List.of(0, 1)),
    Q("Q", "프로그램 종료", List.of());
    ...

```

<br/><br/><br/>

### 2-1. Command getDirection(String input)

사용자의 입력 값으로 그에 맞는 명령을 찾는 메서드.

````java
public static Command getDirection(String input){
        return Stream.of(values())
            .filter(command->command.command.toLowerCase().equals(input))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
}
````

<br/><br/><br/>

### 2-2. static List<String> getCommands()

명령의 영문 알파벳을 반환하는 메서드. input 받는 단어를 체크할 때 해당 List의 contains 메서드를 통해 올바른 input인지 체크한다.

````java
public static List<String> getCommands(){
            return Stream.of(values())
                .map(Command::getCommand)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
}
````

<br/><br/><br/>

### 2-3. List<Integer> getNextPosition()

다음 이동할 값의 좌표를 얻는 메서드.

````java
public List<Integer> getNextPosition(){
        return nextPosition;
}
````

<br/><br/><br/>

## 3. GameResult

Board의 상태를 받아 반환해주는 클래스. 
<br/>

```java
public String[][]getBoard(){
        return board;
}
```

<br/><br/><br/>

## 4. Pair

x, y를 한 쌍으로 묶어서 관리해주는 클래스. 
<br/><br/><br/>

### 4-1. int getX(), int getY()

x와 y의 원시 값을 반환하는 메서드.
<br/>

```java
public int getX(){
        return x;
}

public int getY(){
        return y;
}
```

<br/><br/><br/>

## 5. Pairs

pair의 값들을 저장하고 있는 클래스. 값 객체를 저장해서 필요한 값들을 꺼내 사용한다.
<br/><br/>

### static Pair of(int inputX, int inputY)

x와 y의 원시 값을 반환하는 메서드입니다.
<br/>

```java
public static Pair of(int inputX,int inputY){
        return pairs.stream()
            .filter(position->position.getX()==inputX)
            .filter(position->position.getY()==inputY)
            .findAny()
            .orElseThrow(NoSuchElementException::new);
}
```

<br/><br/><br/><br/><br/><br/>

## 주요 변경 클래스

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:----:|:---|:---|
|6|class|&nbsp;InputView|&nbsp;   사용자의 입력을 담당하는 클래스 |
|7|class|&nbsp;OutputView|&nbsp;   사용자에게 게임의 결과를 출력해주는 클래스|
|8|enum|&nbsp;Message|&nbsp; 사용자에게 보여질 메시지를 관리하는 클래스        |
|9|class|&nbsp;ErrorMessage|&nbsp; 사용자에게 보여질 에러메시지를 관리하는 클래스|

<br/><br/><br/>

## 6. InputView 클래스

사용자의 입력을 받는 클래스.
<br/>

```java
public enum Command {

    UP("U", "위쪽으로 한 칸 이동", List.of(1, 0)),
    DOWN("D", "아랫쪽으로 한 칸 이동", List.of(-1, 0)),
    RIGHT("R", "오른쪽으로 한 칸 이동", List.of(0, -1)),
    LEFT("L", "왼쪽으로 한 칸 이동", List.of(0, 1)),
    Q("Q", "프로그램 종료", List.of());

```

<br/><br/><br/>

### 6-1.List<String> inputCommand()

사용자의 입력을 문자열 리스트로 반환하는 메서드.

```java
public List<String> inputCommand(){
        String value;
        System.out.print(Message.SOKOBAN);
        List<String> words;
        while(true){
            try{
                value=input.br.readLine().toLowerCase();
                words=validateCommandContains(value);
                break;
            } catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch(Exception e){
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return words;
}
```

<br/><br/><br/>

### 6-2.List<String> validateCommandContains(String direction)

사용자의 입력을 문자열 단위("")로 나누고 각 문자 값이 올바른 지 검증해주는 메서드.
<br/>

````java
private List<String> validateCommandContains(String direction){
        List<String> words=new ArrayList<>();
        Objects.requireNonNull(direction);
        String[]temp=direction.split("");
        for(int number=0;number<temp.length;number++){
            if(!commands.contains(temp[number])){
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
            }
        words.add(temp[number]);
        }
        return words;
}
````

<br/><br/>

## 7. OutputView 클래스

Stage의 정보를 출력해주는 클래스.
<br/>

### 7-1. void initBoard(String[][] board)

String[][] 배열을 인자로 받아 보드의 초기 상태를 출력해주는 메서드. 시작 전 배열의 상태를 출력하기 위한 메서드. 
<br/>

```java
public void initBoard(String[][]board){
        stringBuilder.setLength(0);
        stringBuilder.append("Stage 2").append("\n").append("\n");

        for(int row=0;row<board.length;row++){
            if(row!=0){
                stringBuilder.append("\n");
            }
            for(int col=0;col<board[0].length;col++){
                stringBuilder.append(board[row][col]);
            }
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
}
```

<br/><br/><br/>

### 7-2. void printBoard(GameResult result)

GameResult(Board의 상태(String[ ][ ]))를 인자로 받아서 이를 화면에 출력해주는 메서드. 
<br/>

```java
public void printBoard(GameResult result){
        stringBuilder.setLength(0);
        String[][]board=result.getBoard();
        for(int row=0;row<board.length;row++){
            if(row!=0){
                stringBuilder.append("\n");
            }
            for(int col=0;col<board[0].length;col++){
                stringBuilder.append(board[row][col]);
            }
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
}
```

<br/><br/><br/>
</div>

</details>





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
|7|class|&nbsp;StageInformationList |&nbsp; StageInformation 클래스들을 저장하고 있는 클래스                 |

<br/><br/><br/><br/><br/>

## 1. Answer

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

## 2. Disk

Sokoban 내부의 데이터를 저장/불러오기 위한 클래스. Init메서드를 통해 애플리케이션이 동작할 때 필요한 데이터를 모두 초기화 한다. 애플리케이션에서 데이터의 저장/초기화와 관련된 정보를 관리하는 역할을
담당한다.
<br/>

````java
public class Disk {

    private Init init = Init.of();
    private Disk() {};

    public static Disk of() {
        return new Disk();
    }

}

````

<br/>

## 3. Init

각 Stage와 Sokoban 게임의 정보를 초기화하는 클래스. 사용자는 데이터를 사용하는 것에만 집중할 수 있도록 하기 위해 애플리케이션이 실행되는 시점에 데이터를 초기화한다.

<br/><br/><br/>

## 4. Stage

Board와 Stageinformation을 담고 있는 클래스. 이전에는 Board에서 모든 정보를 관리했지만 각 Stage가 나누어져 있기 때문에 각각의 Stage는 자신에 대한 정보를 담고 있다. 따라서 가로
크기, 세로 크기, 맵 등과 같은 자신과 연관된 정보를 가지고 있다.
<br/>

### 4-1. List<GameResult> execute(List<Command> commandList)

플레이 한 게임의 실행 결과를 반환하는 메서드. 리스트를 순회하며 사용자로 부터 입력받은 명령어를 실행하고 그 결과(Board의 상태)를 반환한다. 

```java
public List<GameResult> execute(List<Command> commandList){
        List<GameResult> results=new ArrayList<>();
        for(Command command:commandList){
            if(command.equals(Command.R)){
                return List.of(resetStage());
            }
            results.add(this.board.push(command));
        }
        return results;
}
```

<br/>

### 4-2. GameResult resetStage()

리셋 명령어를 처리하기 위한 메서드. Answer 내에 있는 original 배열을 가져와 이를 반환한다. 

```java
public GameResult resetStage(){
        this.board.reset();
        return new GameResult(this.board.getBoard());
}
```

<br/><br/><br/>

## 5. Stages

Stage들을 저장하고 있는 클래스. Stage 클래스는 매 번 새로 생성될 필요가 없기 때문에 애플리케이션이 시작되는 시점에 한 번만 초기화를 한다.

```java
public class Stages {

    private static final Map<Integer, Stage> stages = new HashMap<>();

    private Stages() {}

    public static void putStage(int id, StageInformation information, Board board) {
        stages.put(id, new Stage(board, information));
    }

    public static Stages of() {
        return new Stages();
    }

    public Stage getStage(int value) {
        return stages.get(value);
    }
}
```

<br/><br/><br/>

## 6. StageInformation

가로, 세로크기, id와 같은 Stage의 기본 정보를 담고 있는 클래스. 값 객체를 사용해 상태를 표현하기 위해 한 단계 포장(Wrapping) 했다. 

```java
public class StageInformation {

  private final int id;
  private final int height;
  private final int width;

  public StageInformation(int id, int height, int width) {
    this.id = id;
    this.height = height;
    this.width = width;
  }

```

<br/><br/><br/>

## 7. StageInformationList

StageInformation 클래스들을 저장하고 있는 클래스. 내부에 새로운 객체를 담아서 저장하는데, 이는 클래스가 생성될 때마다 초기화될 필요가 없으며, 스테이지 수가 많지 않기 때문에 이를 직접 생성해서
관리해도 나쁘지 않다고 판단했기 때문이다.

```java
public class StageInformationList {

    private static List<StageInformation> stages;

    private StageInformationList() {}

    static StageInformationList of() {
        List<StageInformation> lst = List.of(
                new StageInformation(1, 6, 6),
                new StageInformation(2, 5, 6),
                new StageInformation(3, 6, 6),
                new StageInformation(4, 6, 7)
        );
        stages = lst;
        return new StageInformationList();
    }
    ......

```

<br/><br/>
## 주요 변경 클래스
<br/>

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:---------------:|:------|:---|
|8|class|&nbsp;Board                |&nbsp; 각 Stage의 배열의 상태를 관리하며 정답 클래스를 알고 있다            |
|9|class|&nbsp;GameMachine          |&nbsp; Sokoban게임의 중심에서 모든 정보를 관리하며 이를 조합해주는 클래스     |
|10|class|&nbsp;GameManager          |&nbsp; 게임에 관련된 부가 정보를 처리하는 클래스                         |

<br/><br/><br/><br/><br/>

## 8. Board

각 Stage의 배열의 상태를 관리하며 정답 클래스로 Stage의 상태와 관련된 역할과 책임을 가진다. 따라서 배열의 이동, 상태 변화 등과 같은 모든 

### 8-1. GameResult push(Command command)

배열을 변환하는 메서드. 현재 캐릭터의 위치를 기준으로 미는 방향의 한 칸, 두 칸 앞을 체크해서 배열을 변환할 지 결정한다. 모든 배열은 사이드 이펙트를 제거하기 위해 방어적 복사를 통해 값을 반환한다.
<br/><br/>

```java
GameResult push(Command command){
        GameResult gameResult=new GameResult();
        Pair pair=findPlayerPosition();

        int moveBlockX=pair.getX()+command.getNextPosition().get(0);
        int moveBlockY=pair.getY()+command.getNextPosition().get(1);
        int[][]newBoard=copyBoard();

        if(moveable(Pairs.of(moveBlockX,moveBlockY))){
            int[][]updatedBoard=move(pair,newBoard,Pairs.of(moveBlockX,moveBlockY));
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }else if(
            pushable(Pairs.of(moveBlockX,moveBlockY),command)){
            int[][]updatedBoard=pushBall(pair,newBoard,Pairs.of(moveBlockX,moveBlockY),command);
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }
        checkGameResult(gameResult);
        return gameResult;
}
```

<br/><br/><br/>

### 8-2. GameResult push(Command command)

push를 두 가지로 나눈 메서드로 캐릭터가 이동 가능할 때는 move를, move를 할 수 없지만 다음 칸에서 공을 밀 수 있을 때는 pushBall 메서드를 실행한다. 
<br/><br/>

```java
private int[][]move(Pair position,int[][]board,Pair nextPosition){
        board[position.getX()][position.getY()]-=4;
        board[nextPosition.getX()][nextPosition.getY()]+=4;
        return board;
}

private int[][]pushBall(Pair position,int[][]board,Pair nextPosition,Command command){
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

private boolean moveable(Pair pair){
        return this.board[pair.getX()][pair.getY()]==0||this.board[pair.getX()][pair.getY()]==1;
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

### 8-4. Pair findPlayerPosition()

캐릭터의 위치를 찾기 위한 메서드. `*객체지향 체조원칙을 지키기 위해 수정하고 싶지만 아직 마땅히 대안이 떠오르지 않는다.` 
<br/><br/>

```java
protected Pair findPlayerPosition(){
        for(int row=0;row< this.board.length;row++){
            for(int col=0;col< this.board[0].length;col++){
                if(isPlayer(row,col)){
                    return Pairs.of(row,col);
                }
            }
        }
        return null;
}
```

<br/><br/><br/>

### 8-5. boolean isAnswer();

정답을 찾아서 비교하기 위한 메서드. Answer 클래스 내부의 answer 값(int[][])과 비교를 통해 정답을 체크한다.  
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

## 9. GameManager

사용자의 입력을 명령으로 변환해주고 게임의 횟수, 메시지/게임에 대한 정보 전달의 역할을 담당한다. 게임 안내 문구, 턴 수 체크/증가 등과 같은 게임 외적 요소들을 담당하며 플레이어의 원활한 게임 진행을 돕는
역할을 맡고 있다.

<br/><br/><br/>

### 9-1. void sayHello(), sayGoodBye(), sayTurnCount(int value), sayTurnReset()

게임과 연관된 시작, 마무리, 턴 횟수 등의 메시지를 전달하는 메서드.
<br/><br/>

```java
public void sayHello(){
        System.out.println(Message.GREET);
}

public void sayGoodBye(){
        System.out.println(Message.CLEAR_CELEBRATION);
        System.out.println(Message.CELEBRATION);
}

public void sayTurnCount(int value){
        System.out.println(Message.TURN_COUNT+""+value);
}

public void sayTurnReset(){
        System.out.println(Message.TURN_RESET);
}
```

<br/><br/><br/>

### 9-2. List<GameResult> play(int stageNumber,List<Command> commands)

<br/><br/>
stageNumber을 통해 해당 스테이지를 찾고 명령을 전달한다.

```java
public List<Command> getCommand(List<String> direction){
        List<Command> commands=new ArrayList<>();
        for(int i=0;i<direction.size();i++){
            Command command=getCommands(direction.get(i));
                if(command.equals(Command.R)){
                    return List.of(Command.R);
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

<br/><br/><br/>

### 9-4. int plusTurn(int value)

턴의 횟수를 1 증가시키는 메서드.
<br/><br/>

```java
public int plusTurn(int value){
        return value;
}
```

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

<br/><br/><br/><br/>

## 테스트 케이스

각 테스트 케이스에 대한 예시와 출력 답안입니다. *예시의 내용을 `cmd + c + v(윈도우는 ctrl + c + v)` 해서 아래와 같이 실행하시면 됩니다.
<br/><br/>


<details>
<summary>📔	 Step 01.</summary>
<div markdown="1">

## ⌨️ 입력

`아래 내용을 문자열로 넘겨서` 처리하는 함수를 작성한다.

```java
String word="Stage 1\n"+"#####\n"+"#OoP#\n"+"#####\n"+"=====\n"+"Stage 2\n"+"  #######  \n"+"###  O  ###\n"+"#    o    #\n"+"# Oo P oO #\n"+"###  o  ###\n"+" #   O  #  \n"+" ########  ";
```

```java
public class Main {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        String word = "Stage 1\n" + "#####\n" + "#OoP#\n" + "#####\n" + "=====\n" + "Stage 2\n" + "  #######  \n" + "###  O  ###\n" + "#    o    #\n" + "# Oo P oO #\n" + "###  o  ###\n" + " #   O  #  \n" + " ########  ";
        String[] words = word.split("\n");
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            lst.add(words[i]);
        }

        InputView view = new InputView();
        List<StageResult> results = view.inputMap(word);
        OutputView outputView = new OutputView();
        outputView.print(results);
    }
}
```

<br/><br/>

## 🖥 출력

```text
Stage: 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍 수: 1
공의 수: 1
플레이어 위치: (2, 4)

Stage: 2

  #######  
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #  
 ########  

가로크기: 11
세로크기: 7
구멍 수: 4
공의 수: 4
플레이어 위치: (4, 6)
```

</div>
</details>

<details>
<summary>📕	 Step 02.</summary>
<div markdown="2">

## ⌨️ 입력

`아래 내용을 문자열로 넘겨서` 처리하는 함수를 작성한다.

```text
- w: 위쪽
- a: 왼쪽
- s: 아래쪽
- d: 오른쪽
- q: 프로그램 종료
```

```java
public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {

        GameMachine gameMachine = new GameMachine();
        outputView.printInitStage(gameMachine.getBoard().getBoard());
        GameManager manager = new GameManager();

        while (true) {
            List<String> inputValues = inputView.inputCommand();
            List<Command> commands = manager.getCommand(inputValues);
            GameResult result = gameMachine.move(commands);
        }
    }
}
```

<br/><br/>

## 🖥 동작 예시

```text
Stage 2

  #######  
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  #  
 ########  

SOKOBAN> ddzw

D: 오른쪽으로 이동합니다.

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

(경고!) 해당 명령을 수행할 수 없습니다!

  #######  
###  O  ###
#    o    #
# Oo  PoO #
###  o  ###
 #   O  #  
 ########  

W: 윗쪽으로 이동합니다.

  #######  
###  O  ###
#    oP   #
# Oo   oO #
###  o  ###
 #   O  #  
 ########  
SOKOBAN> q

Bye~
```

</div>
</details>

<br/><br/>
