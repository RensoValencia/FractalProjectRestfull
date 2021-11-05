package com.fracal.company.example;

import java.util.ArrayList;
import java.util.List;

public class TestSumListUnitPriceProduct {

    public static void main(String[] args) {

        List <Double> listadaUnit;

        listadaUnit = new ArrayList<Double>();
        listadaUnit.add(new Double("5"));
        listadaUnit.add(new Double("10"));

        System.out.println("datos: " + listadaUnit.stream().reduce(Double::sum).get());

    }
}
