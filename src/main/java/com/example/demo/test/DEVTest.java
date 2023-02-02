package com.example.demo.test;

import com.feilong.tools.mobile.MobileUtil;

public class DEVTest {

    public static void main(String[] args) {
        String mobile = "18260895472";
        String mobileStr = MobileUtil.getMobileNumberHided(mobile);
        System.out.println(mobileStr);

        System.out.println(MobileUtil.getMobileNumberHided(mobile,8));
        System.out.println(MobileUtil.getMobileNumberSegment(mobile));

    }

}
