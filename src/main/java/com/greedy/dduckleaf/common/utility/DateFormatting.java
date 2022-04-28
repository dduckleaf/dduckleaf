package com.greedy.dduckleaf.common.utility;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * <pre>
 * Class : DateFormatting
 * Comment : 날짜와 시간 정보를 원하는 포맷으로 반환받는 유틸리티 클래스입니다.
 *
 * History
 * 2022-04-28 (장민주) 처음 작성
 * </pre>
 *
 * @author 장민주
 * @version 1.0.0
 */
public class DateFormatting {

    /**
     * getDateAndTime: 데이터베이스에 삽입해줄 현재 날짜, 시간정보를 생성하여 문자열 타입으로 반환하는 메소드입니다.
     * @return 포맷 적용한 날짜와 시간 값
     * @author 장민주
     */
    public static String getDateAndTime() {

        /* 데이터베이스에 삽입해줄 현재 날짜, 시간정보 생성 */
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .format(new java.sql.Date(System.currentTimeMillis()));

        return currentDate;
    }
}
