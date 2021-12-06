# 소코반(Sokoban)

<details>
<summary>📚	 문제 설명 및 요구사항</summary>
<div markdown="1">
</div>
<br/><br/>

## ✍🏻 기능 요구사항

- 단계별로 (할 수 있는 단계까지) [소코반 게임](https://www.cbc.ca/kids/games/play/sokoban) 을 구현한다.
- 단계별로 지정된 코딩 요구사항을 적용한다.
- 단계별로 구현한 코드 동작과 실행 결과에 대해 마크다운 문법으로 README.md 파일에 상세하게 정리한다.
- 특별히 명시되지 않은 부분은 `자유롭게 구현`한다.

<br/><br/>

<details>
<summary>📚	 Step 01.</summary>
<div markdown="1">

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

```text
String word = "Stage 1\n" + "#####\n" + "#OoP#\n" + "#####\n" + "=====\n" + "Stage 2\n" + "  #######  \n" + "###  O  ###\n" + "#    o    #\n" + "# Oo P oO #\n" + "###  o  ###\n" + " #   O  #  \n" + " ########  ";
```
<br/><br/><br/>
위 값을 읽어 2차원 배열로 변환 저장한다.
<br/>

| 기호  |<center>의미</center>| <center>스테이지 구분</center>|                                                        
|:---:|:----|:------------------------------:|
|  #  |&nbsp; 벽(Wall)       |&nbsp; 0|
|  O  |&nbsp; 구멍(Hall)      |&nbsp; 1|
|  o  |&nbsp; 공(Ball)       |&nbsp; 2|
|  P  |&nbsp; 플레이어(Player) |&nbsp; 3|
|  =  |&nbsp; 스테이지 구분         |&nbsp; 4|

<br/><br/><br/>

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

## 🖥 1단계 코딩 요구사항

- 컴파일 또는 실행이 가능해야 한다. (컴파일이나 실행되지 않을 경우 감점 대상)
- 자기만의 기준으로 최대한 간결하게 코드를 작성한다.
- Readme.md에 풀이 과정 및 코드 설명, 실행 결과를 기술하고 코드와 같이 gist에 포함해야 한다.
- 제출시 gist URL과 revision 번호를 함께 제출한다.

</div>
</details>

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

<br/><br/><br/>

</div>
</details>

## 목차

| No  |    Content                                                                              |  이동  |
|:---:|:----------------------------------------------------------------------------------------|:-----:|
|  1  |&nbsp;프로젝트 개요                                                                          |[링크]()|
|  2  |&nbsp;풀이 과정 및 코드 설명. 실행 결 기술 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|[링크]()|
|     |&nbsp;&nbsp;&nbsp; `Step 01.`  1단계 풀이 과정 / 코드                                         |       |
|  3  |&nbsp;테스트 케이스                                                                         |[링크]()|

<br/><br/><br/><br/><br/>

# 풀이 과정 및 코드 설명

<details>
<summary>📚	 Step 01.</summary>
<div markdown="1">

## 1단계

1단계는 예제를 `그대로 화면에 출력`하는 단계였습니다. 따라서 문자열 입력에 대한 예외 처리를 하지 않고 입력된 문자열을 파싱해 Stage1과 Stage2에 대한 정보를 화면에 출력했습니다.
<br/>

![링크]()

|No|종류|<center>이름</center>|<center>역할 및 책임</center>|
|:----:|:----:|:---|:---|
|1|class|&nbsp;InputView|&nbsp; 사용자의 입력을 받는 클래스        |
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

인자로 word를 받아 List<StageResult>의 형태로 최종 반환해주는 메서드 입니다. List 내부에는 Stage1과 Stage2에 대한 정보가 담겨있습니다.

````java
public List<StageResult> inputMap(String word) {
        return getResult(word);
    }
````

<br/><br/>

### 1-2. List<StageResult> getResult(String word)

인자로 word를 받아 각 Stage에 대한 실제 정보를 생성해주는 메서드입니다. 메서드 내부에서 도우미 메서드의 도움을 받아 Stage1과 Stage2에 대한 정보를 생성합니다.

```java
private List<StageResult> getResult(String word) {
        List<String> words = getWordsSplitByLine(word);
        List<StageResult> results = new ArrayList<>();

        StageResult stageFirst = new StageResult(1, getStageFirstMap(words));
        StageResult stageSecond = new StageResult(2, getStageSecondMap(words));

        results.add(stageFirst);
        results.add(stageSecond);
        return results;
    }
```

<br/><br/>

### 1-3. List<String> getWordsSplitByLine(String word)

인자로 word를 받아 List<String> 형태로 단어를 나눠주는 메서드입니다.

````java
private List<String> getWordsSplitByLine(String word) {
        String[] wordArray = word.split("\n");
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(wordArray));
        return words;
    }
````

<br/><br/>

### 1-4. int[][] getStageFirstMap(List<String> lst)

인자로 word 리스트를 받아 첫 번째 맵의 구성을 int[][] 형태로 반환해주는 메서드입니다. 각 칸들의 심볼을 int로 변환해서 값을 저장시켜줍니다.

````java
private int[][] getStageFirstMap(List<String> lst) {
        String[][] stringArray = new String[3][5];
        for (int i = 0; i < 3; i++) {
            stringArray[i] = lst.get(i + 1).split("").clone();
        }
        return getIntArray(stringArray);
    }
````

<br/><br/>

### 1-5. int[][] getStageSecondMap(List<String> lst)

인자로 word 리스트를 받아 두 번째 맵의 구성을 int[][] 형태로 반환해주는 메서드입니다. 각 칸들의 심볼을 int로 변환해서 값을 저장시켜줍니다.

````java
private int[][] getStageSecondMap(List<String> lst) {
        int[][] intArray = new int[7][11];
        for (int i = 6; i < 13; i++) {
            String[] array = lst.get(i).split("");
            int count = array.length;
            for (int j = 0; j < count; j++) {
            intArray[i - 6][j] = getIntValue(array[j]);
                }
        }
        return intArray;
    }
````

<br/><br/>

### 1-6. int[][] getIntArray(String[][] stringArray)

문자 배열을 인자로 받아 int[][] 로 반환하는 메서드입니다. 각 칸의 심볼을 맞는 int 값으로 변경해줍니다.

````java
private int[][] getIntArray(String[][] stringArray) {
        int[][] intArray = new int[stringArray.length][stringArray[0].length];
        for (int row = 0; row < stringArray.length; row++) {
            for (int col = 0; col < stringArray[0].length; col++) {
                intArray[row][col] = getIntValue(stringArray[row][col]);
            }
        }
        return intArray;
    }
````

<br/><br/>

### 1-7. int getIntValue(String symbol)

인자로 문자를 받아 int를 반환하는 메서드입니다. 각 칸의 심볼을 맞는 int 값으로 변경해줍니다.

````java
private int getIntValue(String symbol) {
        if (symbol.equals("#")) {
            return 0;
        }
        if (symbol.equals("O")) {
            return 1;
        }
        if (symbol.equals("o")) {
            return 2;
        }
        if (symbol.equals("P")) {
            return 3;
        }
        if (symbol.equals(" ")) {
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

Stage들에 대한 정보를 인자로 받아 화면에 출력해주는 메서드 입니다.

```java
public void print(List<StageResult> results) {
        stringBuilder.setLength(0);
        for (int number = 0; number < results.size(); number++) {
            StageResult stageInfo = results.get(number);
            stringBuilder.append(Message.STAGE_INFO).append(stageInfo.getStage()).append("\n");
            String[][] stageMap = getStringArray(results.get(number).getMap());
            for (int row = 0; row < stageInfo.getMap().length; row++) {
                stringBuilder.append("\n");
                for (int col = 0; col < stageInfo.getMap()[0].length; col++) {
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
Stage 정보 중 int[][]를 인자로 받아 String[][]로 변환해주는 메서드입니다. 
<br/><br/>

```java
private String[][] getStringArray(int[][] map) {
        String[][] stringArray = new String[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
            stringArray[i][j] = getStringValue(map[i][j]);
                }
        }
        return stringArray;
    }
```

<br/><br/><br/>

### 2-3. String getStringValue(int symbol)
int를 인자로 받아 String 값으로 변환해주는 메서드입니다.

````java
private String getStringValue(int symbol) {
        if (symbol == 0) {
            return "#";
        }
        if (symbol == 1) {
            return "O";
        }
        if (symbol == 2) {
            return "o";
        }
        if (symbol == 3) {
            return "P";
        }
        if (symbol == 5) {
            return " ";
        }
        return " ";
    }
````
<br/><br/><br/><br/>

## 3.Message
사용자에게 보여질 메시지를 관리하기 위한 enum 클래스입니다. 

<br/><br/>

## 4.ErrorMessage
사용자에게 보여질 오류 메시지를 관리하기 위한 enum 클래스입니다.

<br/><br/>

## 5.Position
사용자의 위치를 저장하기 위한 값 객체 입니다. 올바른 값의 비교를 위해 equals와 hashCode를 오버라이드 했습니다.
<br/>

```java
@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

@Override
public int hashCode() {
        return Objects.hash(x, y);
    }
```
<br/><br/><br/>

## 6.StageResult
각 Stage에 대한 정보를 담고 있는 값 객체입니다.

<br/><br/>

### 6-1. int getHoleCount(int[][] map)
int[][]를 인자로 받아 구멍(hole)의 개수를 반환하는 메서드입니다.
<br/><br/>

```java
private int getHoleCount(int[][] map) {
        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
```
<br/><br/><br/>
### 6-2. int getBallCount(int[][] map)
int[][]를 인자로 받아 공(ball)의 개수를 반환하는 메서드입니다.
<br/><br/>

```java
private int getBallCount(int[][] map) {
        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
```
<br/><br/><br/>

### 6-3. Position getPlayerPosition(int[][] map)
int[][]를 인자로 받아 플레이어의 위치(x, y)의 좌표를 반환하는 메서드입니다.
<br/><br/>

```java
private Position getPlayerPosition(int[][] map) {
        int count = 0;
        int playerX = Integer.MAX_VALUE;
        int playerY = Integer.MAX_VALUE;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 3) {
                    playerX = row;
                    playerY = col;
                }
            }
        }
        return new Position(playerX, playerY);
    }
```


</div>
</details>


<br/><br/><br/><br/><br/>

## 테스트 케이스

각 테스트 케이스에 대한 예시와 출력 답안입니다. *예시의 내용을 `cmd + c + v(윈도우는 ctrl + c + v)` 해서 아래와 같이 실행하시면 됩니다.
<br/><br/>


<details>
<summary>📚	 Step 01.</summary>
<div markdown="1">

## ⌨️ 입력

`아래 내용을 문자열로 넘겨서` 처리하는 함수를 작성한다.

```java
String word = "Stage 1\n" + "#####\n" + "#OoP#\n" + "#####\n" + "=====\n" + "Stage 2\n" + "  #######  \n" + "###  O  ###\n" + "#    o    #\n" + "# Oo P oO #\n" + "###  o  ###\n" + " #   O  #  \n" + " ########  ";
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

<br/><br/>

<br/><br/><br/><br/>

<br/><br/>
