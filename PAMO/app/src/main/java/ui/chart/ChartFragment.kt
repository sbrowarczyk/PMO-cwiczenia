package ui.chart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import pl.pamo.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ChartFragment : Fragment() {
    private var chart: LineChart? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_charts, container, false)
        chart = rootView.findViewById(R.id.chart)
        createRender()
        return rootView
    }

    private fun createRender() {
        val set = LineDataSet(covidDataSet, "COVID-19 cases")
        set.setDrawValues(false)
        set.lineWidth = 3f
        set.color = Color.GREEN
        set.setCircleColor(Color.GREEN)
        val lineData = LineData(set)
        chart!!.data = lineData
        chart!!.invalidate()
        val xAxis = chart!!.xAxis
        xAxis.valueFormatter = object : ValueFormatter() {
            private val mFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
            override fun getFormattedValue(value: Float): String {
                val millis = value.toLong()
                return mFormat.format(Date(millis))
            }
        }
    }

    private val covidDataSet: List<Entry>
        private get() {
            val entryList: MutableList<Entry> = ArrayList()
            entryList.add(Entry(convertDateToMillis("30 December 2019").toFloat(), 1F))
            entryList.add(Entry(convertDateToMillis("6 January  2020").toFloat(), 45F))
            entryList.add(Entry(convertDateToMillis("13 January 2020").toFloat(), 137F))
            entryList.add(Entry(convertDateToMillis("20 January 2020").toFloat(), 2036F))
            entryList.add(Entry(convertDateToMillis("27 January 2020").toFloat(), 14582F))
            entryList.add(Entry(convertDateToMillis("3 February 2020").toFloat(), 37588F))
            entryList.add(Entry(convertDateToMillis("10 February 2020").toFloat(), 69307F))
            entryList.add(Entry(convertDateToMillis("17 February 2020").toFloat(), 78890F))
            entryList.add(Entry(convertDateToMillis("27 February 2020").toFloat(), 87146F))
            entryList.add(Entry(convertDateToMillis("2 March 2020").toFloat(), 107368F))
            entryList.add(Entry(convertDateToMillis("9 March 2020").toFloat(), 160971F))
            entryList.add(Entry(convertDateToMillis("16 March 2020").toFloat(), 314597F))
            entryList.add(Entry(convertDateToMillis("23 March 2020").toFloat(), 675472F))
            entryList.add(Entry(convertDateToMillis("30 March 2020").toFloat(), 1172724F))
            entryList.add(Entry(convertDateToMillis("6 April 2020").toFloat(), 1727065F))
            entryList.add(Entry(convertDateToMillis("13 April 2020").toFloat(), 2260197F))
            entryList.add(Entry(convertDateToMillis("20 April 2020").toFloat(), 2813992F))
            entryList.add(Entry(convertDateToMillis("27 April 2020").toFloat(), 3361867F))
            entryList.add(Entry(convertDateToMillis("4 May 2020").toFloat(), 3944859F))
            entryList.add(Entry(convertDateToMillis("11 May 2020").toFloat(), 4542228F))
            entryList.add(Entry(convertDateToMillis("18 May 2020").toFloat(), 5221880F))
            entryList.add(Entry(convertDateToMillis("25 May 2020").toFloat(), 5941401F))
            entryList.add(Entry(convertDateToMillis("1 June 2020").toFloat(), 6784151F))
            entryList.add(Entry(convertDateToMillis("8 June 2020").toFloat(), 7672904F))
            entryList.add(Entry(convertDateToMillis("15 June 2020").toFloat(), 8692127F))
            entryList.add(Entry(convertDateToMillis("22 June 2020").toFloat(), 9831317F))
            entryList.add(Entry(convertDateToMillis("29 June 2020").toFloat(), 11136747F))
            entryList.add(Entry(convertDateToMillis("6 July 2020").toFloat(), 12568287F))
            entryList.add(Entry(convertDateToMillis("13 July 2020").toFloat(), 14128559F))
            entryList.add(Entry(convertDateToMillis("20 July 2020").toFloat(), 14128559F))
            entryList.add(Entry(convertDateToMillis("27 July 2020").toFloat(), 17726008F))
            entryList.add(Entry(convertDateToMillis("3 August 2020").toFloat(), 19563096F))
            entryList.add(Entry(convertDateToMillis("10 August 2020").toFloat(), 21563096F))
            entryList.add(Entry(convertDateToMillis("17 August 2020").toFloat(), 23265767F))
            entryList.add(Entry(convertDateToMillis("24 August 2020").toFloat(), 25120592F))
            entryList.add(Entry(convertDateToMillis("31 August 2020").toFloat(), 27086891F))
            entryList.add(Entry(convertDateToMillis("7 September 2020").toFloat(), 29025081F))
            entryList.add(Entry(convertDateToMillis("14 September 2020").toFloat(), 31117228F))
            entryList.add(Entry(convertDateToMillis("21 September 2020").toFloat(), 33222965F))
            entryList.add(Entry(convertDateToMillis("28 September 2020").toFloat(), 35363453F))
            entryList.add(Entry(convertDateToMillis("5 October 2020").toFloat(), 37727659F))
            entryList.add(Entry(convertDateToMillis("12 October 2020").toFloat(), 40286863F))
            entryList.add(Entry(convertDateToMillis("19 October 2020").toFloat(), 43307038F))
            entryList.add(Entry(convertDateToMillis("26 October 2020").toFloat(), 46766320F))
            entryList.add(Entry(convertDateToMillis("2 November 2020").toFloat(), 50558407F))
            entryList.add(Entry(convertDateToMillis("9 November 2020").toFloat(), 54636968F))
            entryList.add(Entry(convertDateToMillis("16 November 2020").toFloat(), 58770226F))
            entryList.add(Entry(convertDateToMillis("23 November 2020").toFloat(), 62828095F))
            entryList.add(Entry(convertDateToMillis("30 November 2020").toFloat(), 67009710F))
            entryList.add(Entry(convertDateToMillis("7 December 2020").toFloat(), 71389145F))
            entryList.add(Entry(convertDateToMillis("14 December 2020").toFloat(), 76081004F))
            entryList.add(Entry(convertDateToMillis("21 December 2020").toFloat(), 80203399F))
            entryList.add(Entry(convertDateToMillis("28 December 2020").toFloat(), 84372702F))
            entryList.add(Entry(convertDateToMillis("4 January 2021").toFloat(), 89417030F))
            entryList.add(Entry(convertDateToMillis("11 January 2021").toFloat(), 94249569F))
            entryList.add(Entry(convertDateToMillis("18 January 2021").toFloat(), 98497983F))
            entryList.add(Entry(convertDateToMillis("25 January 2021").toFloat(), 102282845F))
            entryList.add(Entry(convertDateToMillis("1 February 2021").toFloat(), 105506243F))
            entryList.add(Entry(convertDateToMillis("8 February 2021").toFloat(), 108266521F))
            entryList.add(Entry(convertDateToMillis("15 February 2021").toFloat(), 110757376F))
            entryList.add(Entry(convertDateToMillis("22 February 2021").toFloat(), 113442688F))
            entryList.add(Entry(convertDateToMillis("1 March 2021").toFloat(), 116198244F))
            entryList.add(Entry(convertDateToMillis("8 March 2021").toFloat(), 119245795F))
            entryList.add(Entry(convertDateToMillis("15 March 2021").toFloat(), 122870978F))
            entryList.add(Entry(convertDateToMillis("22 March 2021").toFloat(), 126405434F))
            entryList.add(Entry(convertDateToMillis("29 March 2021").toFloat(), 130508795F))
            entryList.add(Entry(convertDateToMillis("5 April 2021").toFloat(), 135097828F))
            entryList.add(Entry(convertDateToMillis("12 April 2021").toFloat(), 140373678F))
            entryList.add(Entry(convertDateToMillis("19 April 2021").toFloat(), 146105297F))
            entryList.add(Entry(convertDateToMillis("26 April 2021").toFloat(), 151845101F))
            entryList.add(Entry(convertDateToMillis("3 May 2021").toFloat(), 157269221F))
            entryList.add(Entry(convertDateToMillis("10 May 2021").toFloat(), 160076944F))
            return entryList
        }

    fun convertDateToMillis(date: String?): Long {
        val f = SimpleDateFormat("dd MMM yyyy")
        var d: Date? = null
        try {
            d = f.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return d!!.time
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}