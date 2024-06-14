package edu.url.salle.santiago.prieto.finalproject.Model.PokeAPI;

import android.content.Context;
import android.graphics.Paint;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObtainData {
    private static RequestQueue requestQueue;
    private final Context con;

    public ObtainData(Context con){
        this.con = con;
        requestQueue = getInstance();
    }

    private RequestQueue getInstance(){
        // Singleton, only one connection for all the project/classes.
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(this.con);
        }
        return requestQueue;
    }

    public void getData(String url, DataCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // Pass the result to the callback
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Pass the error to the callback
                        callback.onError(error.getMessage());
                    }
                });

        // add the request to the queue
        getInstance().add(jsonObjectRequest);
    }

    public interface DataCallback {
        void onSuccess(JSONObject result);
        void onError(String error);
    }
}
