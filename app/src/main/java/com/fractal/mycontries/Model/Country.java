package com.fractal.mycontries.Model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Country implements Serializable {
    @SerializedName("nome")
    public String nome;
    @SerializedName("topLevelDomain")
    public String topLevelDomain;
    @SerializedName("alpha2Code")
    public String alpha2Code;
    @SerializedName("alpha3Code")
    public String alpha3Code;
    @SerializedName("callingCodes")
    public String callingCodes;
    @SerializedName("capital")
    public String capital;
    @SerializedName("altSpellings")
    public String altSpellings;
    @SerializedName("region")
    public String region;
    @SerializedName("subregion")
    public String subregion;
    @SerializedName("population")
    public String population;
    @SerializedName("latlng")
    public String latlng;
    @SerializedName("demonym")
    public String demonym;
    @SerializedName("area")
    public String area;
    @SerializedName("gini")
    public String gini;
    @SerializedName("timezones")
    public String timezones;
    @SerializedName("borders")
    public String borders;
    @SerializedName("nativeName")
    public String nativeName;
    @SerializedName("numericCode")
    public String numericCode;
    @SerializedName("currencies")
    public String currencies;
    @SerializedName("languages")
    public String languages;
    @SerializedName("translations")
    public String translations;
    @SerializedName("relevance")
    public String relevance;

    public Country(String nome, String topLevelDomain, String alpha2Code, String alpha3Code, String callingCodes, String capital, String altSpellings, String region, String subregion, String population,
                   String latlng, String demonym, String area, String gini, String timezones, String borders, String nativeName, String numericCode, String currencies, String languages, String translations, String relevance) {

        this.nome = nome;
        this.topLevelDomain = topLevelDomain;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.callingCodes = callingCodes;
        this.capital = capital;
        this.altSpellings = altSpellings;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.latlng = latlng;
        this.demonym = demonym;
        this.area = area;
        this.gini = gini;
        this.timezones = timezones;
        this.borders = borders;
        this.nativeName = nativeName;
        this.numericCode = numericCode;
        this.currencies = currencies;
        this.languages = languages;
        this.translations = translations;
        this.relevance = relevance;
    }

    @Override
    public String toString() {
        return "Country{" +
                " nome='" + nome + '\'' +
                " capital='" + capital + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public String getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getPopulation() {
        return population;
    }

    public String getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getArea() {
        return area;
    }

    public String getGini() {
        return gini;
    }

    public String getTimezones() {
        return timezones;
    }

    public String getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public String getCurrencies() {
        return currencies;
    }

    public String getLanguages() {
        return languages;
    }

    public String getTranslations() {
        return translations;
    }

    public String getRelevance() {
        return relevance;
    }
}