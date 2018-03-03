/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class DaysNumber {

    public static void main(String[] args) {
        int day = 0;
        System.out.println("Enter the date in yyyy-mm-dd");
        Scanner sc = new Scanner(System.in);
        String userdate = sc.nextLine();
        java.sql.Date currentdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        String[] ud = userdate.split("-");
        String[] cd = currentdate.toString().split("-");

        int cyear = Integer.parseInt(cd[0]);
        int cmonth = Integer.parseInt(cd[1]);
        int cday = Integer.parseInt(cd[2]);
        int uyear = Integer.parseInt(ud[0]);
        int umonth = Integer.parseInt(ud[1]);
        int uday = Integer.parseInt(ud[2]);
        //userdate = 2014-10-05  currentdate=2018-03-03
        //for years 2015 2016 2017
        for (int i = uyear + 1; i < cyear; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400) == 0) {
                day += 366;
            } else {
                day += 365;
            }
        }

        //userdate = 2014-10-05 thus, adding the days of months 11 and 12 
        for (int i = umonth + 1; i <= 12; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day += 31;
                    break;
                case 2:
                    if ((uyear % 4 == 0 && uyear % 100 != 0) || (uyear % 400) == 0) {
                        day += 29;
                    } else {
                        day += 28;
                    }
                    break;
                default:
                    day += 30;
                    break;
            }
        }

        //adding the days of usermonth ie 10 
        switch (umonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day += 31 - uday;
                break;
            case 2:
                if ((uyear % 4 == 0 && uyear % 100 != 0) || (uyear % 400) == 0) {
                    day += 29 - uday;
                } else {
                    day += 28 - uday;
                }
                break;
            default:
                day += 30 - uday;
                break;
        }

        //currentdate = 2018-03-03 thus adding the days of month 01 and 02
        for (int i = 1; i < cmonth; i++) {

            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day += 31;

                    break;
                case 2:
                    if ((cyear % 4 == 0 && cyear % 100 != 0) || (cyear % 400) == 0) {
                        day += 29;

                    } else {
                        day += 28;
                    }
                    break;
                default:
                    day += 30;
                    break;
            }
        }

        //adding the days of month 03 excluding 3 march itself
        day += cday - 1;

        System.out.println(day);

    }

}
