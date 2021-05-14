package pl.pamo.ui.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pl.pamo.R;

public class ChartFragment extends Fragment {


    private LineChart chart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_charts, container, false);

        chart = rootView.findViewById(R.id.chart);

        createRender();

        return rootView;
    }

    private void createRender() {


        LineDataSet set = new LineDataSet(getCovidDataSet(), "COVID-19 cases");

        set.setDrawValues(false);
        set.setLineWidth(3);
        set.setColor(Color.GREEN);
        set.setCircleColor(Color.GREEN);

        LineData lineData = new LineData(set);
        chart.setData(lineData);
        chart.invalidate();

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

            @Override
            public String getFormattedValue(float value) {
                long millis = (long) value;
                return mFormat.format(new Date(millis));
            }
        });
    }

    @NotNull
    private List<Entry> getCovidDataSet() {
        List<Entry> entryList = new ArrayList<>();


        entryList.add(new Entry(convertDateToMillis("30 December 2019"), 1));
        entryList.add(new Entry(convertDateToMillis("6 January  2020"), 45));
        entryList.add(new Entry(convertDateToMillis("13 January 2020"), 137));
        entryList.add(new Entry(convertDateToMillis("20 January 2020"), 2036));
        entryList.add(new Entry(convertDateToMillis("27 January 2020"), 14582));
        entryList.add(new Entry(convertDateToMillis("3 February 2020"), 37588));
        entryList.add(new Entry(convertDateToMillis("10 February 2020"), 69307));
        entryList.add(new Entry(convertDateToMillis("17 February 2020"), 78890));
        entryList.add(new Entry(convertDateToMillis("27 February 2020"), 87146));
        entryList.add(new Entry(convertDateToMillis("2 March 2020"), 107368));
        entryList.add(new Entry(convertDateToMillis("9 March 2020"), 160971));
        entryList.add(new Entry(convertDateToMillis("16 March 2020"), 314597));
        entryList.add(new Entry(convertDateToMillis("23 March 2020"), 675472));
        entryList.add(new Entry(convertDateToMillis("30 March 2020"), 1172724));
        entryList.add(new Entry(convertDateToMillis("6 April 2020"), 1727065));
        entryList.add(new Entry(convertDateToMillis("13 April 2020"), 2260197));
        entryList.add(new Entry(convertDateToMillis("20 April 2020"), 2813992));
        entryList.add(new Entry(convertDateToMillis("27 April 2020"), 3361867));
        entryList.add(new Entry(convertDateToMillis("4 May 2020"), 3944859));
        entryList.add(new Entry(convertDateToMillis("11 May 2020"), 4542228));
        entryList.add(new Entry(convertDateToMillis("18 May 2020"), 5221880));
        entryList.add(new Entry(convertDateToMillis("25 May 2020"), 5941401));
        entryList.add(new Entry(convertDateToMillis("1 June 2020"), 6784151));
        entryList.add(new Entry(convertDateToMillis("8 June 2020"), 7672904));
        entryList.add(new Entry(convertDateToMillis("15 June 2020"), 8692127));
        entryList.add(new Entry(convertDateToMillis("22 June 2020"), 9831317));
        entryList.add(new Entry(convertDateToMillis("29 June 2020"), 11136747));
        entryList.add(new Entry(convertDateToMillis("6 July 2020"), 12568287));
        entryList.add(new Entry(convertDateToMillis("13 July 2020"), 14128559));
        entryList.add(new Entry(convertDateToMillis("20 July 2020"), 14128559));
        entryList.add(new Entry(convertDateToMillis("27 July 2020"), 17726008));
        entryList.add(new Entry(convertDateToMillis("3 August 2020"), 19563096));
        entryList.add(new Entry(convertDateToMillis("10 August 2020"), 21563096));
        entryList.add(new Entry(convertDateToMillis("17 August 2020"), 23265767));
        entryList.add(new Entry(convertDateToMillis("24 August 2020"), 25120592));
        entryList.add(new Entry(convertDateToMillis("31 August 2020"), 27086891));
        entryList.add(new Entry(convertDateToMillis("7 September 2020"), 29025081));
        entryList.add(new Entry(convertDateToMillis("14 September 2020"), 31117228));
        entryList.add(new Entry(convertDateToMillis("21 September 2020"), 33222965));
        entryList.add(new Entry(convertDateToMillis("28 September 2020"), 35363453));
        entryList.add(new Entry(convertDateToMillis("5 October 2020"), 37727659));
        entryList.add(new Entry(convertDateToMillis("12 October 2020"), 40286863));
        entryList.add(new Entry(convertDateToMillis("19 October 2020"), 43307038));
        entryList.add(new Entry(convertDateToMillis("26 October 2020"), 46766320));
        entryList.add(new Entry(convertDateToMillis("2 November 2020"), 50558407));
        entryList.add(new Entry(convertDateToMillis("9 November 2020"), 54636968));
        entryList.add(new Entry(convertDateToMillis("16 November 2020"), 58770226));
        entryList.add(new Entry(convertDateToMillis("23 November 2020"), 62828095));
        entryList.add(new Entry(convertDateToMillis("30 November 2020"), 67009710));
        entryList.add(new Entry(convertDateToMillis("7 December 2020"), 71389145));
        entryList.add(new Entry(convertDateToMillis("14 December 2020"), 76081004));
        entryList.add(new Entry(convertDateToMillis("21 December 2020"), 80203399));
        entryList.add(new Entry(convertDateToMillis("28 December 2020"), 84372702));
        entryList.add(new Entry(convertDateToMillis("4 January 2021"), 89417030));
        entryList.add(new Entry(convertDateToMillis("11 January 2021"), 94249569));
        entryList.add(new Entry(convertDateToMillis("18 January 2021"), 98497983));
        entryList.add(new Entry(convertDateToMillis("25 January 2021"), 102282845));
        entryList.add(new Entry(convertDateToMillis("1 February 2021"), 105506243));
        entryList.add(new Entry(convertDateToMillis("8 February 2021"), 108266521));
        entryList.add(new Entry(convertDateToMillis("15 February 2021"), 110757376));
        entryList.add(new Entry(convertDateToMillis("22 February 2021"), 113442688));
        entryList.add(new Entry(convertDateToMillis("1 March 2021"), 116198244));
        entryList.add(new Entry(convertDateToMillis("8 March 2021"), 119245795));
        entryList.add(new Entry(convertDateToMillis("15 March 2021"), 122870978));
        entryList.add(new Entry(convertDateToMillis("22 March 2021"), 126405434));
        entryList.add(new Entry(convertDateToMillis("29 March 2021"), 130508795));
        entryList.add(new Entry(convertDateToMillis("5 April 2021"), 135097828));
        entryList.add(new Entry(convertDateToMillis("12 April 2021"), 140373678));
        entryList.add(new Entry(convertDateToMillis("19 April 2021"), 146105297));
        entryList.add(new Entry(convertDateToMillis("26 April 2021"), 151845101));
        entryList.add(new Entry(convertDateToMillis("3 May 2021"), 157269221));
        entryList.add(new Entry(convertDateToMillis("10 May 2021"), 160076944));
        return entryList;
    }

    long convertDateToMillis(String date) {
        SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
        Date d = null;

        try {
            d = f.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return d.getTime();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}