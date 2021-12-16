package com.example.daegutour

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

class CsvReader {
    fun readFacilityCSV(ins: InputStream): List<Map<String, String>> {
        try {
            var reader: BufferedReader? = null
            reader = BufferedReader(InputStreamReader(ins, Charset.forName("utf8")))
            val data = mutableListOf<Map<String, String>>()
            var line = reader.readLine()

            // Column line pass
            line = reader.readLine()
            while (line != null) {
                val tokens = line.split('|')
                val dataMap = mutableMapOf<String, String>()

                dataMap["name"] = tokens[0]
                dataMap["latitude"] = tokens[1]
                dataMap["longitude"] = tokens[2]
                data.add(dataMap)
                line = reader.readLine()
            }
            Log.d("csv read", "Facility CSV")
            return data
        } catch (e: Exception) {
            Log.e("csv read", e.toString())
            return mutableListOf()
        }
    }

    fun readListData(ins: InputStream): List<Map<String, String>> {
        try {
            val reader = BufferedReader(InputStreamReader(ins, Charset.forName("utf8")))
            val data = mutableListOf<Map<String, String>>()
            var line = reader.readLine()

            // Column pass
            line = reader.readLine()
            while (line != null) {
                val tokens = line.split('|')
                val dataMap = mutableMapOf<String, String>()
                dataMap["img"] = tokens[0]
                dataMap["name"] = tokens[1]
                dataMap["address"] = tokens[2]
                dataMap["desc"] = tokens[3]
                dataMap["latitude"] = tokens[5]
                dataMap["longitude"] = tokens[6]
                dataMap["google"] = tokens[7]
                dataMap["naver"] = tokens[8]
                dataMap["trip"] = tokens[9]
                dataMap["avg"] = tokens[10]
                dataMap["data"] = tokens[11]
                dataMap["wordCloud"] = tokens[12]
                data.add(dataMap)
                line = reader.readLine()
            }
            Log.d("csv data", "Spot CSV")
            return data
        } catch (e: Exception) {
            Log.d("csv data", e.toString())
            return mutableListOf()
        }
    }

}
