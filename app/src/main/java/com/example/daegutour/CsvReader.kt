package com.example.daegutour

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset

class CsvReader {

    fun readCSVWifi(ins : InputStream): List<Map<String, String>> {
        try {
            var reader: BufferedReader? = null
            reader = BufferedReader(InputStreamReader(ins, Charset.forName("utf8")))
            val data = mutableListOf<Map<String, String>>()
            var line = reader.readLine()

//            Column line pass
            line = reader.readLine()
            while (line != null) {
                var tokens = line.split('|')
                val dataMap = mutableMapOf<String, String>()

                dataMap["name"] = tokens[0]
                dataMap["latitude"] = tokens[1]
                dataMap["longitude"] = tokens[2]
                dataMap["management"] = tokens[3]
                dataMap["phone_number"] = tokens[4]
                dataMap["adress"] = tokens[5]
                dataMap["service"] = tokens[6]
                dataMap["location"] = tokens[7]
                dataMap["SSID"] = tokens[8]
                data.add(dataMap)
                line = reader.readLine()
            }
            Log.d("csv data read", "Wifi CSV Data Read Success")
            return data
        } catch (e: Exception) {
            Log.d("error", "CSV Data Read Error")
            Log.d("error", e.toString())
            return mutableListOf<Map<String, String>>()
        }
    }

    fun readCSVToilet(ins : InputStream): List<Map<String, String>> {
        try {
            var reader: BufferedReader? = null
            reader = BufferedReader(InputStreamReader(ins, Charset.forName("utf8")))
            val data = mutableListOf<Map<String, String>>()
            var line = reader.readLine()

//            Column line pass
            line = reader.readLine()
            while (line != null) {
                var tokens = line.split('|')
                val dataMap = mutableMapOf<String, String>()

                dataMap["name"] = tokens[0]
                dataMap["latitude"] = tokens[1]
                dataMap["longitude"] = tokens[2]
                dataMap["management"] = tokens[3]
                dataMap["phone_number"] = tokens[4]
                dataMap["adress"] = tokens[5]
                dataMap["operate_time"] = tokens[6]
                dataMap["type"] = tokens[7]
                dataMap["uni_sex"] = tokens[8]
                data.add(dataMap)
                line = reader.readLine()
            }
            Log.d("csv data read", "Toilet CSV Data Read Success")
            return data
        } catch (e: Exception) {
            Log.d("error", "Toilet CSV Data Read Error")
            Log.d("error", e.toString())

            return mutableListOf<Map<String, String>>()
        }

    }

    fun readCSVTourguide(ins: InputStream): List<Map<String, String>> {
        try {
            var reader: BufferedReader? = null
            reader = BufferedReader(InputStreamReader(ins, Charset.forName("utf8")))
            val data = mutableListOf<Map<String, String>>()
            var line = reader.readLine()

//            Column line pass
            line = reader.readLine()
            while (line != null) {
                var tokens = line.split('|')
                val dataMap = mutableMapOf<String, String>()

                dataMap["name"] = tokens[0]
                dataMap["latitude"] = tokens[1]
                dataMap["longitude"] = tokens[2]
                dataMap["management"] = tokens[3]
                dataMap["phone_number"] = tokens[4]
                dataMap["adress"] = tokens[5]
                dataMap["service"] = tokens[6]
                dataMap["location"] = tokens[7]
                dataMap["operate_time(summer)"] = tokens[8]
                dataMap["operate_time(winter)"] = tokens[8]
                dataMap["holiday"] = tokens[8]
                dataMap["english"] = tokens[8]
                dataMap["japanese"] = tokens[8]
                dataMap["chinese"] = tokens[8]
                dataMap["desc"] = tokens[8]
                dataMap["page"] = tokens[8]

                data.add(dataMap)
                line = reader.readLine()
            }
            Log.d("csv data read", "Tour Guide CSV Data Read Success")
            return data
        } catch (e: Exception) {
            Log.d("error", "Tour Guide CSV Data Read Error")

            return mutableListOf<Map<String, String>>()
        }
    }
}