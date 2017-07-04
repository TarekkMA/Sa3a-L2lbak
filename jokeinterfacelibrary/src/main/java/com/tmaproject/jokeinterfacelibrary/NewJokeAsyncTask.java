package com.tmaproject.jokeinterfacelibrary;

import android.os.AsyncTask;
import android.util.Pair;
import com.example.Joke;
import com.example.tarekkma.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import java.io.IOException;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

public class NewJokeAsyncTask
    extends AsyncTask<Pair<NewJokeAsyncTask.Callback, String>, Void, Joke> {

  public interface Callback {
    void onSuccess(Joke joke);

    void onFailed(Throwable throwable);
  }

  private static MyApi myApiService = null;
  private Callback callback;
  private IOException exception;

  @Override protected Joke doInBackground(Pair<Callback, String>... pair) {
    if (myApiService == null) {  // Only do this once
      MyApi.Builder builder =
          new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
              // options for running against local devappserver
              // - 10.0.2.2 is localhost's IP address in Android emulator
              // - turn off compression when running against local devappserver
              .setRootUrl("http://10.0.2.2:8080/_ah/api/")
              .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                    throws IOException {
                  abstractGoogleClientRequest.setDisableGZipContent(true);
                }
              });

      myApiService = builder.build();
    }

    callback = pair[0].first;
    String deviceUUID = pair[0].second;
    try {
      com.example.tarekkma.myapplication.backend.myApi.model.Joke responseJoke =
          myApiService.getNewJoke(deviceUUID).execute();
      return new Joke(responseJoke.getJoke(), responseJoke.getId(), responseJoke.getShownTimes(),
          responseJoke.getFavored(), responseJoke.getLikes(), responseJoke.getDislikes());
    } catch (IOException e) {
      exception = e;
      return null;
    }
  }

  @Override protected void onPostExecute(Joke joke) {
    super.onPostExecute(joke);
    if (joke != null) {
      callback.onSuccess(joke);
    }else {
      callback.onFailed(exception);
    }
  }
}
