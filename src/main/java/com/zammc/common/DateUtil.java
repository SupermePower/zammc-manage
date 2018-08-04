package com.zammc.common;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @description 时间工具类
 * @author: liying.fu
 * @Date: 2018/8/4 下午10:51
 */
public class DateUtil {

    /**
     * 根据时间戳返回年月日格式时间戳（Y-M-D）
     *
     * @param timestamp 时间戳
     * @return Timestamp
     */
    public static Timestamp getCurrentTime(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        Instant instantLocalDate = localDate.atStartOfDay().atZone(zone).toInstant();
        return new Timestamp(Date.from(instantLocalDate).getTime());
    }
}
