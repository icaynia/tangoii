package com.icaynia.tangomemory.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaynia.tangomemory.Data.logManager;
import com.icaynia.tangomemory.Data.wordManager;
import com.icaynia.tangomemory.R;
import com.icaynia.tangomemory.View.Card;
import com.icaynia.tangomemory.View.GameActivityView;
import com.icaynia.tangomemory.View.TodaysActivityView;
import com.icaynia.tangomemory.View.YourTangoActivityView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.LogManager;

import static com.icaynia.tangomemory.R.id.card1;

/**
 * Created by icaynia on 2016. 12. 5..
 */

public class HomeFragment extends android.support.v4.app.Fragment  {
    private View fragmentView;
    private wordManager mWordManager;
    private logManager mLogManager;

    Date date = new Date();
    SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.KOREA);

    private Card card1;
    private Card card2;
    private Card card3;

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        initialize();
        return fragmentView;
    }

    private void initialize() {
        viewInitialize();
        mWordManager = new wordManager(getContext());
        mLogManager = new logManager(getContext());
        card1();
        card2();
        card3();
        card4();
    }

    private void viewInitialize() {
        card1 = (Card) fragmentView.findViewById(R.id.card1);
        card2 = (Card) fragmentView.findViewById(R.id.card2);
        card3 = (Card) fragmentView.findViewById(R.id.card3);

    }

    private void card1() {
        card1.setTitle("Today's Activity");
        TodaysActivityView tav = new TodaysActivityView(getContext());
        tav.setSolvedcountValue(mLogManager.getCount(transFormat.format(date))+"");

        tav.setTodayaddcountValue(mWordManager.getWordRowsToday() + "");

        card1.setContent(tav.getView());
    }

    private void card2() {
        card2.setTitle("Your Tango Activity");
        YourTangoActivityView tav = new YourTangoActivityView(getContext());
        tav.setWordquantityValue(
                mWordManager.getWordRows()+""
        );

        card2.setContent(tav.getView());
    }

    private void card3() {
        card3.setTitle("Game Activity");
        GameActivityView tav = new GameActivityView(getContext());
        tav.setAllcountValue(mLogManager.getCount()+"");
        tav.setKanjitohiraganaValue("0");
        card3.setContent(tav.getView());
    }

    private void card4() {
        card3.setTitle("Word Status");
        GameActivityView tav = new GameActivityView(getContext());
        tav.setAllcountValue(mLogManager.getCount()+"");
        tav.setKanjitohiraganaValue("0");
        card3.setContent(tav.getView());
    }


}
