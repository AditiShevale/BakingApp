package com.example.aditi.bakingapp.AsyncTask;

import android.os.AsyncTask;

import com.example.aditi.bakingapp.Pojo.Recepie;
import com.example.aditi.bakingapp.Utils.NetworkUtils;

import org.json.JSONException;

import java.net.URL;
import java.util.ArrayList;

public class MyAsyncTask  extends AsyncTask<URL, Void, ArrayList<Recepie>> {

    private AsyncListner mListner;

    public MyAsyncTask(AsyncListner listner) {
        mListner = listner;
    }

    @Override
    protected ArrayList<Recepie> doInBackground(URL... urls) {
        try {
            ArrayList<Recepie> json = NetworkUtils.fetchRecipeData(urls[0]);
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Recepie> recepies) {
        super.onPostExecute(recepies);
        mListner.returnRecipe(recepies);

    }


}

