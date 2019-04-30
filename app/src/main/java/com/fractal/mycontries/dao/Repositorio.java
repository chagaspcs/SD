package com.fractal.mycontries.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.fractal.mycontries.Model.Country;

public class Repositorio {

    private SQLHelper helper;
    private SQLiteDatabase db;

    public Repositorio(Context ctx){
        helper = new SQLHelper(ctx);
    }

    public long inserir(Country country){
        db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLHelper.COLUNA_name, country.nome);
        cv.put(SQLHelper.COLUNA_topLevelDomain, country.topLevelDomain);
        cv.put(SQLHelper.COLUNA_alpha2Code, country.alpha2Code);
        cv.put(SQLHelper.COLUNA_alpha3Code, country.alpha3Code);
        cv.put(SQLHelper.COLUNA_callingCodes, country.callingCodes);
        cv.put(SQLHelper.COLUNA_capital, country.capital);
        cv.put(SQLHelper.COLUNA_altSpellings, country.altSpellings);
        cv.put(SQLHelper.COLUNA_region, country.region);
        cv.put(SQLHelper.COLUNA_subregion, country.subregion);
        cv.put(SQLHelper.COLUNA_population, country.population);
        cv.put(SQLHelper.COLUNA_latlng, country.latlng);
        cv.put(SQLHelper.COLUNA_demonym, country.demonym);
        cv.put(SQLHelper.COLUNA_area, country.area);
        cv.put(SQLHelper.COLUNA_gini, country.gini);
        cv.put(SQLHelper.COLUNA_timezones, country.timezones);
        cv.put(SQLHelper.COLUNA_borders, country.borders);
        cv.put(SQLHelper.COLUNA_nativeName, country.nativeName);
        cv.put(SQLHelper.COLUNA_numericCode, country.numericCode);
        cv.put(SQLHelper.COLUNA_currencies, country.currencies);
        cv.put(SQLHelper.COLUNA_languages, country.languages);
        cv.put(SQLHelper.COLUNA_translations, country.translations);
        cv.put(SQLHelper.COLUNA_relevance, country.relevance);

        long id = db.insert(SQLHelper.TABELA_COUNTRY, null, cv);

        //if(id != -1){
        //    country.nome = id;
        //}
        db.close();
        return id;
    }

    public void excluirAll(){
        db = helper.getWritableDatabase();
        db.delete(SQLHelper.TABELA_COUNTRY, null, null);
        db.close();
    }

    public List<Country> listarCountry() {
        String sql = "SELECT * FROM " + SQLHelper.TABELA_COUNTRY;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Country> list = new ArrayList();

        while (cursor.moveToNext()) {
            String nome = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_name)
            );

            String topLevelDomain = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_topLevelDomain)
            );
            String alpha2Code = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_alpha2Code)
            );
            String alpha3Code = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_alpha3Code)
            );
            String callingCodes = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_callingCodes)
            );
            String capital = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_capital)
            );
            String altSpellings = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_altSpellings)
            );
            String region = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_region)
            );
            String subregion = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_subregion)
            );
            String population = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_population)
            );
            String latlng = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_latlng)
            );
            String demonym = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_demonym)
            );
            String area = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_area)
            );
            String gini = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_gini)
            );
            String timezones = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_timezones)
            );
            String borders = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_borders)
            );
            String nativeName = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_nativeName)
            );
            String numericCode = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_numericCode)
            );
            String currencies = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_currencies)
            );
            String languages = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_languages)
            );
            String translations = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_translations)
            );
            String relevance = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_relevance)
            );

            Country country = new Country(  nome,
                                            topLevelDomain,
                                            alpha2Code,
                                            alpha3Code,
                                            callingCodes,
                                            capital,
                                            altSpellings,
                                            region,
                                            subregion,
                                            population,
                                            latlng,
                                            demonym,
                                            area,
                                            gini,
                                            timezones,
                                            borders,
                                            nativeName,
                                            numericCode,
                                            currencies,
                                            languages,
                                            translations,
                                            relevance);
            list.add(country);
        }
        cursor.close();
        return list;
    }

}
