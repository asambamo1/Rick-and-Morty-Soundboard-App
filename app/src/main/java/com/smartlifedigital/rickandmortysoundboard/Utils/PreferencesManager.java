package com.smartlifedigital.rickandmortysoundboard.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;


public class PreferencesManager {
    private static final String FAVORITED_KEY = "favorited";
    private static final String FIRST_TIME_USER = "firstTimeUser";
    private static PreferencesManager instance;
    private SharedPreferences prefs;

    private PreferencesManager() {
        Context context = MyApplication.get().getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static PreferencesManager get() {
        if (instance == null) {
            instance = getSync();
        }
        return instance;
    }

    private static synchronized PreferencesManager getSync() {
        if (instance == null) {
            instance = new PreferencesManager();
        }
        return instance;
    }

    public Set<String> getFavoritedSoundbites() {
        return prefs.getStringSet(FAVORITED_KEY, new HashSet<String>());
    }

    private void setFavoritedSoundbites(Set<String> favorites) {
        prefs.edit().remove(FAVORITED_KEY).apply();
        prefs.edit().putStringSet(FAVORITED_KEY, favorites).apply();
    }

    public boolean isSoundbiteFavorited(String soundbite) {
        return getFavoritedSoundbites().contains(soundbite);
    }

    public void favoriteSoundbite(String soundbite) {
        Set<String> favorites = getFavoritedSoundbites();
        favorites.add(soundbite);
        setFavoritedSoundbites(favorites);
    }

    public void unfavoriteSoundbite(String soundbite) {
        Set<String> favorites = getFavoritedSoundbites();
        favorites.remove(soundbite);
        setFavoritedSoundbites(favorites);
    }

    public boolean isFirstTimeUser() {
        return prefs.getBoolean(FIRST_TIME_USER, true);
    }

    public void rememberWelcome() {
        prefs.edit().putBoolean(FIRST_TIME_USER, false).apply();
    }
}
