package com.VedaMir.beeradviser;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        // Получить вариант,выбранный в Sprinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Построить контейнер List c сортами пива
        List<String> brandsList = expert.getBrands(beerType);
        // Построить String по данным из List
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand:brandsList){
            brandsFormatted.append(brand).append('\n');
        }

        brands.setText(brandsFormatted);
    }
}