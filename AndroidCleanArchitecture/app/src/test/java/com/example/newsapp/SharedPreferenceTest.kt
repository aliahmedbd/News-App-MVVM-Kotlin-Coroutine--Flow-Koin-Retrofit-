package com.example.newsapp

import android.content.Context
import android.content.SharedPreferences
import com.example.newsapp.util.getCompanyDetailsSharedPref
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito


class SharedPreferenceTest {
    var sharedPrefs = Mockito.mock(SharedPreferences::class.java)
    var context: Context = Mockito.mock(Context::class.java)

    @Before
    @Throws(Exception::class)
    fun before() {
        sharedPrefs = Mockito.mock(SharedPreferences::class.java)
        context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs)
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun emptyListTest() {
        val news = this.context.getCompanyDetailsSharedPref()
        Mockito.`when`(sharedPrefs.getString(anyString(), anyString())).thenReturn("foobar")
        assertEquals(0, news?.articles?.size)
        // maybe add some verify();
    }


}