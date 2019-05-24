package com.utils;

public class Suan {
    public Double suan(Double keone,Double ketwo,Double c,Double d,Double e){
        if (keone>=90){
            keone = 4.0;
        }else if (keone>=80){
            keone = 3.0;
        }else if (keone>=70){
            keone = 2.0;
        }else if (keone>=60){
            keone = 1.0;
        }else {
            keone = 0.0;
        }

        if (ketwo>=90){
            ketwo = 4.0;
        }else if (ketwo>=80){
            ketwo = 3.0;
        }else if (ketwo>=70){
            ketwo = 2.0;
        }else if (ketwo>=60){
            ketwo = 1.0;
        }else {
            ketwo = 0.0;
        }

        if (c>=90){
            c = 4.0;
        }else if (c>=80){
            c = 3.0;
        }else if (c>=70){
            c = 2.0;
        }else if (c>=60){
            c = 1.0;
        }else {
            c = 0.0;
        }

        if (d>=90){
            d = 4.0;
        }else if (d>=80){
            d = 3.0;
        }else if (d>=70){
            d = 2.0;
        }else if (d>=60){
            d = 1.0;
        }else {
            d = 0.0;
        }

        if (e>=90){
            e = 4.0;
        }else if (e>=80){
            e = 3.0;
        }else if (e>=70){
            e = 2.0;
        }else if (e>=60){
            e = 1.0;
        }else {
            e = 0.0;
        }

        Double sum;
        sum = (keone+ketwo+c+d+e)/5;

        return sum;
    }
}
