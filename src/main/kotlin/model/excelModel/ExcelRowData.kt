package model.excelModel

data class ExcelRowData(
//    번호
    val num: String,
//    구분
    val kind: String,
//    화장실명
    val name: String,
//    소재지도로명주소
    val roadAddress: String,
//    소재지지번주소
    val jibunAddress: String,
//    남녀공용화장실여부
    val isUnisex: String,
//    남성용-대변기수
    val toiletBowlCntForMan: String,
//    남성용-소변기수
    val toiletUrinalForMan: String,
//    남성용-장애인용대변기수
    val toiletBowlCntForManForDisabled: String,
//    남성용-장애인용소변기수
    val toiletUrinalCntForManForDisabled: String,
//    남성용-어린이용대변기수
    val toiletToiletBowlForManForChild: String,
//    남성용-어린이용소변기수
    val toiletUrinalForManForChild: String,
//    여성용-대변기수
    val toiletBowlCntForWoman: String,
//    여성용-장애인용대변기수
    val toiletBowlCntForWomanForDisabled: String,
//    여성용-어린이용대변기수
    val toiletBowlCntForWomanForChild: String,
//    관리기관명
    val governingBodyName: String,
//    전화번호
    val phoneNum: String,
//    개방시간
    val openingHours: String,
//    설치연월
    val toiletCreatedAt: String,
//    WGS84위도
    val latitude: String,
//    WGS84경도
    val longitude: String,
//    화장실소유구분
    val own: String,
//    화장실설치장소유형
    val kindOfLocation: String,
//    오물처리방식
    val wayOfSewageDisposal: String,
//    비상벨설치여부
    val hasEmergencyBell: String,
//    비상벨설치장소
    val emergencyBellLocation: String,
//    화장실입구CCTV설치유무
    val hasCCTV: String,
//    기저귀교환대유무
    val hasBabyChanging: String,
//    기저귀교환대장소
    val babyChangingLocation: String,
//    리모델링연월
    val remodeledAt: String,
//    데이터기준일자
    val updatedAt: String,
) {
    fun toCsvData(): String {
        return "$num,$kind,$name,$roadAddress,$jibunAddress,$isUnisex,$toiletBowlCntForMan,$toiletUrinalForMan,$toiletBowlCntForManForDisabled,$toiletUrinalCntForManForDisabled,$toiletToiletBowlForManForChild,$toiletUrinalForManForChild,$toiletBowlCntForWoman,$toiletBowlCntForWomanForDisabled,$toiletBowlCntForWomanForChild,$governingBodyName,$phoneNum,$openingHours,$toiletCreatedAt,$latitude,$longitude,$own,$kindOfLocation,$wayOfSewageDisposal,$hasEmergencyBell,$emergencyBellLocation,$hasCCTV,$hasBabyChanging,$babyChangingLocation,$remodeledAt,$updatedAt"
    }
}


// 하하!!!
fun List<String>.toExcelRowData(): ExcelRowData {
    return ExcelRowData(
        this[0],
        this[1],
        this[2],
        this[3],
        this[4],
        this[5],
        this[6],
        this[7],
        this[8],
        this[9],
        this[10],
        this[11],
        this[12],
        this[13],
        this[14],
        this[15],
        this[16],
        this[17],
        this[18],
        this[19],
        this[20],
        this[21],
        this[22],
        this[23],
        this[24],
        this[25],
        this[26],
        this[27],
        this[28],
        this[29],
        this[30]
    )
}

