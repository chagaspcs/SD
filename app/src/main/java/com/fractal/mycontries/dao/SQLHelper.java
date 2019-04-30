package com.fractal.mycontries.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbCountry";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_COUNTRY = "country_tabela";
    public static final String COLUNA_name = "nome";
    public static final String COLUNA_topLevelDomain = "topLevelDomain";
    public static final String COLUNA_alpha2Code = "alpha2Code";
    public static final String COLUNA_alpha3Code = "alpha3Code";
    public static final String COLUNA_callingCodes = "callingCodes";
    public static final String COLUNA_capital = "capital";
    public static final String COLUNA_altSpellings = "altSpellings";
    public static final String COLUNA_region = "region";
    public static final String COLUNA_subregion = "subregion";
    public static final String COLUNA_population = "population";
    public static final String COLUNA_latlng = "latlng";
    public static final String COLUNA_demonym = "demonym";
    public static final String COLUNA_area = "area";
    public static final String COLUNA_gini = "gini";
    public static final String COLUNA_timezones = "timezones";
    public static final String COLUNA_borders = "borders";
    public static final String COLUNA_nativeName = "nativeName";
    public static final String COLUNA_numericCode = "numericCode";
    public static final String COLUNA_currencies = "currencies";
    public static final String COLUNA_languages = "languages";
    public static final String COLUNA_translations = "translations";
    public static final String COLUNA_relevance = "relevance";


    public SQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABELA_COUNTRY + " ( " +
                        COLUNA_name + " TEXT, " +
                        COLUNA_topLevelDomain + " TEXT, " +
                        COLUNA_alpha2Code + " TEXT, " +
                        COLUNA_alpha3Code + " TEXT, " +
                        COLUNA_callingCodes + " TEXT, " +
                        COLUNA_capital + " TEXT, " +
                        COLUNA_altSpellings + " TEXT, " +
                        COLUNA_region + " TEXT, " +
                        COLUNA_subregion + " TEXT, " +
                        COLUNA_population + " TEXT, " +
                        COLUNA_latlng + " TEXT, " +
                        COLUNA_demonym + " TEXT, " +
                        COLUNA_area + " TEXT, " +
                        COLUNA_gini + " TEXT, " +
                        COLUNA_timezones + " TEXT, " +
                        COLUNA_borders + " TEXT, " +
                        COLUNA_nativeName + " TEXT, " +
                        COLUNA_numericCode + " TEXT, " +
                        COLUNA_currencies + " TEXT, " +
                        COLUNA_languages + " TEXT, " +
                        COLUNA_translations + " TEXT, " +
                        COLUNA_relevance + " TEXT)"
        );

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // para as próximas versões
    }

}

