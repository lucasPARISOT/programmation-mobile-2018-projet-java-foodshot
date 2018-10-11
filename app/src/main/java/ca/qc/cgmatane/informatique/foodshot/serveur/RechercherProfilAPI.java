package ca.qc.cgmatane.informatique.foodshot.serveur;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RechercherProfilAPI extends AsyncTask<String, String, String> {
    private String pseudonymeRecherche;

    public RechercherProfilAPI(String pseudonymeRecherche) {
        this.pseudonymeRecherche = pseudonymeRecherche;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        Response reponse;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://54.37.152.134/api/utilisateur/rechercher.php?pseudonyme=" + this.pseudonymeRecherche)
                .build();

        try {
            reponse = client.newCall(request).execute();
            String jsonData = reponse.body().string();
            JSONObject jObject = new JSONObject(jsonData);
            Log.d("reponse_serveur", jObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}