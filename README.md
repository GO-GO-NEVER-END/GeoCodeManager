# GeocodeManager

### 개요

- 공공 화장실 데이터 중 위도, 경도 값이 없는 것들의 위도, 경도 데이터 수집 자동화를 위해 간단히 구현하였습니다.

### 사용한 기술

- Oktthp
- kotlinx-serialization
- Naver Map APi

### 간단 소개

- FileManager는 파일의 입출력을 담당하여 CSV파일을 읽고 씁니다.
- GeocodeManager는 Naver Map APi를 사용하여 주소 입력하면 위도, 경도로 반환해줍니다.

FileManager은 설정한 경로에 있는 CSV 파일을 읽은 후 위도, 경도가 없는 데이터들은 GeocodeManager를 사용하여 위도 경도를 반환받고, 위도 경도를 입력한 데이터를 CSV파일로 써줍니다.
- 네이버에 요청했을 때 데이터 값이 없는 경우도 있는데 해당 경우는 `위도, 경도가 -1`로 표기되어 있습니다.

### 해야할 것
- FileManager의 역할 분리
- Reverse Geocode 기능 구현

### PS
- 코드를 실행하기 위해서는 Private.kt 파일이 필요한데, Naver Map APi에 요청할 때 헤더에 담아야할 Client 관련 값들입니다.
  - Private.kt 파일의 코드는 노션 작업 기록에 있습니다! 

