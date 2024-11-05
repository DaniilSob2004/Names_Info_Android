package com.example.namesfragment_hw.utils;

import com.example.namesfragment_hw.model.NameModel;
import java.util.ArrayList;
import java.util.List;

public class TaskFactory {

    public static List<NameModel> getNameModels() {
        ArrayList<NameModel> names = new ArrayList<>();

        for (int i = 0; i < TestUtils.NAMES_AND_DESCRIPTIONS.length; i++) {
            names.add(new NameModel(
                    TestUtils.NAMES_AND_DESCRIPTIONS[i][0],
                    TestUtils.getRandomDatesStr(),
                    TestUtils.NAMES_AND_DESCRIPTIONS[i][1]
            ));
        }

        return names;
    }
}
