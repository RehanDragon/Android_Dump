package com.example.anychartliabrary;
//Pie chart
//Over here we had imported AnyChart Liabrary which let us make different kind of charts in android
// thing to remember use at least Android version 4.4 which is API 19+ for this liabrary to work without any gradel sync errors
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        // pie chart started from here

        Pie pie = AnyChart.pie();

        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                // Jis Activity main mojude hain aushe ka nam likhain ga
                Toast.makeText(MainActivity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });


        //Pie Chart main data 100 percent hone chyia ha

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Data 1", 10));
        data.add(new ValueDataEntry("Data 2", 20));
        data.add(new ValueDataEntry("Data 3", 10));
        data.add(new ValueDataEntry("Data 4", 30));
        data.add(new ValueDataEntry("Data 5", 30));

        pie.data(data);

        pie.title("Data Values");
//outside
        pie.labels().position("outside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Retail channels")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        anyChartView.setChart(pie);


        // pie chart ended here



    }
}
